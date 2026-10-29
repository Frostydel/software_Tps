public class Client {
    public static void main1(int n) {
        ProgramInterface p = ProgramFactory.create(n);
        System.out.println("I am main1");
        p.go();
    }

    public static void main2(int n) {
        ProgramInterface p = ProgramFactory.create(n);
        System.out.println("I am main2");
        p.go();
    }

    public static void main3(int n) {
        ProgramInterface p = ProgramFactory.create(n);
        System.out.println("I am main3");
        p.go();
    }
}
