package interfaces.exercises;
/*
    Exercise 4
    We have different databases, Postgres, MySql, SQL Server, MongoDB
    They all fetch data
    Create a client(main method) for databases
    But the databases can be interchangeable.
 */
public class Exercise4 {
    interface Database{
        void fetchData();
    }

    static class Postgres implements Database{
        @Override
        public void fetchData(){
            System.out.println("Postgres fetch data");
        }
    }
    static class Mysql implements Database{
        @Override
        public void fetchData(){
            System.out.println("Mysql fetch data");
        }
    }
    static class SQLServer implements Database{
        @Override
        public void fetchData(){
            System.out.println("SQL Server fetch data");
        }
    }
    static class MongoDb implements Database{
        @Override
        public void fetchData(){
            System.out.println("MongoDb fetch data");
        }
    }

    static class DatabaseClient {
        private Database database;

        public DatabaseClient(Database database) {
            this.database = database;
        }

        public void connectAndFetch() {
            System.out.print("Connecting to database...");
            database.fetchData();
        }
    }


    static void main(String[] args) {
        Database mongo = new MongoDb();
        Database sqlServer = new SQLServer();
        Database mysql = new Mysql();
        Database postgres = new Postgres();

        DatabaseClient client1 =  new DatabaseClient(mongo);
        DatabaseClient client2 =  new DatabaseClient(sqlServer);

        client1.connectAndFetch();
        client2.connectAndFetch();

        // We can change the client
        DatabaseClient client3 = new DatabaseClient(mysql);
        client3.connectAndFetch();

        // and Again
        DatabaseClient client4 = new DatabaseClient(postgres);
        client4.connectAndFetch();
    }

}


