package org.examples.collections;

import java.util.ArrayList;
import java.util.List;

public class MoveProtonsNeutrons {

    public List<String> solve(int protonStart, int neutronStart, int protonTarget, int neutronTarget) {
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