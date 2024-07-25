package org.examples.collections;

import java.util.*;

/*
# ChallengeAs efficiently as possible, find the nearest bus stop for a given (cartesian) geo coordinate.

Your position
 590 230

Bus stops
 * 595 200
 * 400 260

Expected result
 595 200
 */
public class GeoClosestPosTest {
    public static void main(String[] args) {
        Integer lat = 590;
        Integer lon = 230;
        Integer closest = 0;
        int diff = 0;
        int lastDiff = 0;

        Map<Integer, Integer> geo = new HashMap<>();

        geo.put(595,200);
        geo.put(400,260);
        geo.put(588,260);
        Iterator<Map.Entry<Integer, Integer>> rec = geo.entrySet().iterator();

        while(rec.hasNext()) {
            Map.Entry<Integer, Integer> entry = rec.next();

            diff = Math.abs(lat - entry.getKey());
            if (closest == 0) {
                lastDiff = diff;
                closest = entry.getKey();
            }
            if (closest != 0 && diff < lastDiff) {
                closest = entry.getKey();
            }
        }
        System.out.println(closest);
/* 1 for */
        Map<Integer, Integer> closeGeo = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : geo.entrySet()) {

            diff = Math.abs(lat - entry.getKey());
            if (closest == 0) {
                lastDiff = diff;
                closeGeo.put(entry.getKey(), entry.getValue());
            } else if (diff < lastDiff) {
                closeGeo.clear();
                closeGeo.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println(closeGeo);
/* 2 */
/*		Map<Integer, Integer> closeGeo = new HashMap<>();
		for (Map.Entry<Integer, Integer> entry : geo.entrySet()) {

			diff = Math.abs(lat - entry.getKey());
			if (closest == 0) {
				lastDiff = diff;
				closeGeo.put(entry.getKey(), entry.getValue());
			} else if (diff < lastDiff) {
				closeGeo.clear();
				closeGeo.put(entry.getKey(), entry.getValue());
			}
		}
		System.out.println(closeGeo);
*/

    }
}
