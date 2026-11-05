# Gradle Example (Alternative to Maven)

Gradle is another build tool like Maven, but it is usually seen as:

- **shorter** in syntax,
- **more flexible** for custom build logic,
- based on **Groovy or Kotlin DSL** instead of XML.

---

## Example `build.gradle`

```groovy
plugins {
    id 'java'
    id 'application'
}

group = 'com.app'
version = '1.0-SNAPSHOT'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {

    // Database
    implementation 'org.postgresql:postgresql:42.7.3'

    // JSON
    implementation 'com.google.code.gson:gson:2.11.0'

    // CSV
    implementation 'com.opencsv:opencsv:5.9'

    // Connection Pool
    implementation 'org.apache.commons:commons-dbcp2:2.12.0'

    // Logging
    implementation 'org.slf4j:slf4j-simple:2.0.12'

    // Testing
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.2'
}

application {
    mainClass = 'com.app.App'
}

tasks.test {
    useJUnitPlatform()
}

---

## ⚡ Common Gradle Commands

```bash
./gradlew build      # compile + test + package
./gradlew run        # run the application
./gradlew clean      # delete the build folder
./gradlew test       # run tests only
```

> On Windows, you will often use `gradlew.bat build` instead of `./gradlew build`.

---

## Maven vs Gradle Comparison

| Concept | Maven | Gradle |
|---|---|---|
| Config file | `pom.xml` | `build.gradle` / `build.gradle.kts` |
| Syntax | XML | Groovy / Kotlin DSL |
| Style | Convention-based | Task-based |
| Dependencies | Verbose XML | Short notation |
| Flexibility | More rigid | More flexible |
| Readability | Explicit but long | Shorter and cleaner |

---

## Same Dependency Example

### Maven

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.11.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.google.code.gson:gson:2.11.0'
```

👉 The Gradle version is much shorter.

---

## What does “scripting” mean in Gradle?

In Gradle, **the build file is not just configuration** — it can also contain **small scripts and logic**.

That means you can do things like:

- create **custom tasks**,
- run code **before or after** another task,
- read **environment variables** or project properties,
- apply **conditions** (`if`, loops, variables),
- rename artifacts or generate files automatically,
- automate multi-step workflows.

### Small example

```groovy
tasks.register('hello') {
    doLast {
        println 'Hello from Gradle scripting!'
    }
}
```

When you run:

```bash
./gradlew hello
```

Gradle executes that custom logic.

---

## Couldn’t we do these things with Maven too?

**Yes, mostly we could.** Maven can also:

- run tests,
- package applications,
- use plugins,
- define profiles,
- automate many build steps.

But the difference is usually this:

- **Maven** does it more through **XML configuration + plugins**.
- **Gradle** does it more through **DSL + scripting**, which feels more natural for custom logic.

So:

- for **standard and predictable builds**, Maven is often easier to keep consistent;
- for **custom or dynamic build logic**, Gradle is usually more comfortable.

---

## Quick Takeaway

- **Maven = convention + structure**
- **Gradle = flexibility + scripting**

Both solve the same core problem: **build automation + dependency management**.
