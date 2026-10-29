public class Client {
    public static void main1(int n) {
        ProgramInterface p;
        if (n == 1)      p = new Program1();
        else if (n == 2) p = new Program2();
        else             p = new Program3();
        System.out.println("I am main1");
        p.go();
    }

    public static void main2(int n) {
        ProgramInterface p;
        if (n == 1)      p = new Program1();
        else if (n == 2) p = new Program2();
        else             p = new Program3();
        System.out.println("I am main2");
        p.go();
    }

    public static void main3(int n) {
        ProgramInterface p;
        if (n == 1)      p = new Program1();
        else if (n == 2) p = new Program2();
        else             p = new Program3();
        System.out.println("I am main3");
        p.go();
    }
}
