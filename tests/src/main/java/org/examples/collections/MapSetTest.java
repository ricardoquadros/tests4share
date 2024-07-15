package org.examples.collections;

import java.util.*;

public class MapSetTest {
    public static void main(String[] args) {

        Map<Integer, String> mapTest = new HashMap<>();
        Set<Integer> setTest = new HashSet<>();

        mapTest.put(2,"X");
        mapTest.put(1,"Y");
        mapTest.put(1,"Z");
        mapTest.put(null,null);
        mapTest.put(3,"W");

        setTest.add(3);
        setTest.add(2);
        setTest.add(null);
        setTest.add(1);
        setTest.add(null);
        setTest.add(3);

        System.out.println("mapTest = " + mapTest);
        System.out.println("mapTest.get(1) = " + mapTest.get(1));
        System.out.println("mapTest.get(null) = " + mapTest.get(null));

        System.out.println("\n\nsetTest = " + setTest);

        Iterator<Integer> i = setTest.iterator();
        while (i.hasNext()) System.out.println("setTest = " + i.next());

        LinkedHashMap<Integer, String> mapsLink = new LinkedHashMap<>();
        mapsLink.put(1, null);
        mapsLink.put(2, null);
        mapsLink.put(3, null);
        mapsLink.put(5, null);
        mapsLink.put(null, "XX");

        System.out.println("\n\nmapsLink = " + mapsLink);

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(6, null);

        mapsLink.putAll(map);
        System.out.println("mapsLink = " + mapsLink);
        System.out.println("mapsLink = " + mapsLink.get(6));
    }
}