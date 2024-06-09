import java.util.ArrayList;
import java.util.List;

public class MoveProtonsNeutrons {
    public static void main(String args[]) {

        System.out.println("Solve = " + solve(3, 4, 5, 2));

    }

    public static List<String> solve(int protonStart, int neutronStart, int protonTarget, int neutronTarget) {
        List<String> actions = new ArrayList<>();

        while (protonStart != protonTarget) {
            if (protonStart < protonTarget) {
                actions.add("PROTON");
                protonStart++;
            } else {
                actions.add("ALPHA");
                protonStart--;
            }
        }

        while (neutronStart != neutronTarget) {
            if (neutronStart < neutronTarget) {
                actions.add("NEUTRON");
                neutronStart++;
            } else {
                actions.add("ALPHA");
                neutronStart--;
            }
        }

        return actions;
    }

}