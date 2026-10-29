public class ProgramFactory {
    public static ProgramInterface create(int n) {
        switch (n) {
            case 1: return new Program1();
            case 2: return new Program2();
            case 3: return new Program3();
            default: throw new IllegalArgumentException("Unknown program: " + n);
        }
    }
}
