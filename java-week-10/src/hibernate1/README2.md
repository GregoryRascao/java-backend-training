# README 2 – Setting Up Hibernate Project

In this section, we will create our first Hibernate project.

The goal is simple:

* add Hibernate to the project
* configure database connection
* start Hibernate successfully

We are still not doing CRUD yet.
First, we just want the project to run correctly.

### Why not XML?

Older Hibernate tutorials often use hibernate.cfg.xml.

That still works, but for a simple learning project, a properties file is usually easier to read and maintain.

So in this module, we will use:

hibernate.properties for configuration
Java annotations for entity mapping

This keeps the setup smaller and easier to follow.

### What do we need?

Before starting, make sure you have:

* Java 17 or newer
* Maven
* PostgreSQL installed and running

For a modern new project, we are using Hibernate ORM 7.3. Hibernate’s current documentation also presents a native getting-started flow using a properties file, while the JPA-standard approach uses persistence.xml.

Project Structure

We will use a normal Maven structure:
```sh
hibernate-intro/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       └── resources/
├── pom.xml
```
This is the standard Maven convention.

### Step 1 – Add Dependencies

Open pom.xml and add these dependencies:

```xml
<dependencies>

    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>7.3.0.Final</version>
    </dependency>
    
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.3</version>
    </dependency>
    
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>2.0.12</version>
    </dependency>
</dependencies>
```
## Why do we need them?
* hibernate-core -> the main Hibernate library
* postgresql -> database driver
* slf4j-simple -> console logging

### Step 2 – Create the Database

Create a PostgreSQL database:

CREATE DATABASE school_db;

We do not need to create tables manually yet.

Hibernate can help with that later.

### Step 3 – Add hibernate.properties

Create this file:

src/main/resources/hibernate.properties

Add the following:

```properties
hibernate.connection.driver_class=org.postgresql.Driver
hibernate.connection.url=jdbc:postgresql://localhost:5432/school_db
hibernate.connection.username=postgres
hibernate.connection.password=your_password

hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

hibernate.show_sql=true
hibernate.format_sql=true
hibernate.highlight_sql=true

hibernate.hbm2ddl.auto=update
```

### What do these properties mean?
Connection properties

These tell Hibernate how to connect to the database:

* driver class
* database URL
* username
* password
* Dialect

The dialect tells Hibernate which SQL database it is talking to.

Here we use:

* PostgreSQLDialect

### SQL output

These settings help learning:

* show_sql=true → print SQL in console
* format_sql=true → make SQL easier to read
* highlight_sql=true → improve readability in logs

### Schema generation

**hibernate.hbm2ddl.auto**=update

This tells Hibernate to update the database schema when needed.

For learning projects, this is convenient.

Common values are:

* create → recreate tables from scratch
* update → update existing schema
* validate → check schema only
* none → do nothing

For now, update is a good choice.

### Step 4 – Create a Hibernate Utility Class

Hibernate needs a SessionFactory.

A SessionFactory is expensive to create, so we usually create it once and reuse it.

```java
package config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory =
    new Configuration().buildSessionFactory();
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
```

### Why does this work?

Hibernate’s configuration API can collect settings from configuration sources, and this simplified bootstrap style is still part of the current Hibernate documentation and Javadocs.

Because the hibernate.properties file is in src/main/resources, it is placed on the classpath and Hibernate can find it.

### Step 5 – Test the Setup

Now let’s check whether Hibernate starts correctly.

```java
package app;

import config.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        System.out.println("Hibernate started successfully!");
    }
}
```

If everything is correct, you should see:

Hibernate logs
no startup error
your success message

# Common Errors
### No suitable driver

Usually means:

PostgreSQL dependency is missing
Maven dependencies were not reloaded
### Connection refused

Usually means:

PostgreSQL is not running
wrong host or port
### Authentication failed

Usually means:

wrong username
wrong password
### Database does not exist

Usually means:

school_db was not created
database name in the URL is wrong

### Cannot get a connection as the driver manager is not properly initialize
Check your hibernate.properties file location.

### Why this setup is a good starting point

This approach is nice for beginners because:

no XML noise
easy to read
easy to change one property at a time
keeps the focus on Hibernate itself

Later, in real projects, you may see other styles:

persistence.xml in JPA-based apps
application.properties or application.yml in Spring Boot apps

All of them are valid in the right context. Hibernate’s own current docs distinguish native setup from JPA-standard setup in exactly this way.

### What did we achieve?

At this point:

* Hibernate dependency is installed
* PostgreSQL connection is configured
* SessionFactory can be created
* the project is ready for entity mapping

We still have not saved any data yet.

That is the next step.

Next

In the next README, we will create our first:

* entity class
* mapped table
* insert operation

That is the point where Hibernate starts to feel useful.