import java.util.*;

interface Mission { void display(String indent); int getDuration(); }

class SimpleMission implements Mission {
    private final String name; private final int duration;
    SimpleMission(String name, int duration) { this.name = name; this.duration = duration; }
    public void display(String indent) { System.out.println(indent + name + " (" + duration + " min)"); }
    public int getDuration() { return duration; }
}

class MissionGroup implements Mission {
    private final String name; private final List<Mission> children = new ArrayList<>();
    MissionGroup(String name) { this.name = name; }
    void add(Mission m) { children.add(m); }
    void remove(Mission m) { children.remove(m); }
    public void display(String indent) {
        System.out.println(indent + name + " (" + getDuration() + " min)");
        for (Mission m : children) m.display(indent + "  ");
    }
    public int getDuration() {
        int sum = 0;
        for (Mission m : children) sum += m.getDuration();
        return sum;
    }
}

public class Level2_Main {
    public static void main(String[] args) {
        MissionGroup prep = new MissionGroup("Preparation");
        prep.add(new SimpleMission("Check fuel", 5));
        prep.add(new SimpleMission("Load robots", 10));
        MissionGroup root = new MissionGroup("Launch Operation");
        root.add(prep);
        root.add(new SimpleMission("Deploy", 8));
        root.display("");
        System.out.println("Total duration: " + root.getDuration() + " min");
    }
}
