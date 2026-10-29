public class Main {
    public static void main(String[] args) {
        Database db1 = Database.getInstance("UsersDB");
        Database db2 = Database.getInstance("ProductsDB");

        db1.getConnection();
        db2.getConnection();

        System.out.println("Same instance? " + (db1 == db2));
    }
}
