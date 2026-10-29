public class Database {
    private static Database instance;
    private String name;

    private Database(String name) {
        this.name = name;
    }

    public static synchronized Database getInstance(String name) {
        if (instance == null) {
            instance = new Database(name);
        }
        return instance;
    }

    public void getConnection() {
        System.out.println("You are connected to the database " + name);
    }
}
