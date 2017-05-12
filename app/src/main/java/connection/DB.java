package connection;

/**
 * Created by milson on 30.03.17.
 */

public class DB {/*
    private static String URL_DATABASE = "jdbc:postgresql://localhost:5432/";
    private String db_name; //название базы данных
    private String db_user; //логин пользователя бд
    private String db_password; //пароль пользователя бд
    private Connection connection;

    public DB(String db_name, String db_user, String db_password) {
        this.db_name = db_name;
        this.db_user = db_user;
        this.db_password = db_password;
        this.connection = null;
    }
    /*
    * Подключение к бд
    *//*

    public void connectToDB() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("This is  my BD?");
            this.connection = DriverManager.getConnection(URL_DATABASE + this.db_name, this.db_user, this.db_password);
        } catch (Exception ex) {
            System.out.println("Where is your my BD?");
            ex.printStackTrace();
            return;
        }
    }

    public void closeConnectionToDB() {

        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ResultSet getResultExecuteQuery(String query) {
        try {
            Statement statement = this.connection.createStatement();
            return statement.executeQuery(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void createTable(String query) {
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Таблица добавлена");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void createTrigger(String query) {
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Триггер добавлен");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        DB db = new DB("test", "dev", "dev");

        db.connectToDB();

/**
 * Cоздание таблицы подписчиков
 *//*

        db.createTable("" +
                "CREATE TABLE IF NOT EXISTS city_lib (" +
                "id bigserial PRIMARY KEY, " +
                "name character varying NOT NULL)");

        db.createTable(
                "CREATE TABLE IF NOT EXISTS players ( " +
                        "id bigserial PRIMARY KEY," +
                        "name character varying UNIQUE NOT NULL," +
                        "age integer NOT NULL," +
                        "city_id integer REFERENCES city_lib" +
                        ")");
        db.createTable(
                "CREATE TABLE IF NOT EXISTS game (" +
                        "id bigserial PRIMARY KEY," +
                        "id_winner integer REFERENCES players," +
                        "os character varying UNIQUE NOT NULL" +
                        ")");

        db.closeConnectionToDB();
    }*/
}