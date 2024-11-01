import java.util.*;

/**
 * ChallengeAs efficiently as possible, find the nearest bus stop
 * for a given (cartesian) geo coordinate.
 *
 * Your position
 *    590 - 230
 *
 * Bus stops
 *    595 - 200
 *    400 - 260
 *
 * Expected result
 *    595 - 200
 *
 */
public class ClosestStop {
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

        /* First review */
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
        System.out.println("1.Closest to 590: "+closest);

        /* Second review */
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
        System.out.println("2.Closest to 590: "+closeGeo);

        /* Third review */
        Location targetLocation = new Location(590, 230);
        ClosestLocationFinder finder = new ClosestLocationFinder(targetLocation);

        finder.addLocation(new Location(595, 200));
        finder.addLocation(new Location(400, 260));
        finder.addLocation(new Location(588, 260));

        int closestLatitude = finder.findClosestLocation();
        System.out.println("3.Closest to 590: " + closestLatitude);
    }
}


class Location {
    private int latitude;
    private int longitude;

    public Location(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}

class ClosestLocationFinder {
    private Location targetLocation;
    private Map<Integer, Location> locations;

    public ClosestLocationFinder(Location targetLocation) {
        this.targetLocation = targetLocation;
        this.locations = new HashMap<>();
    }

    public void addLocation(Location location) {
        locations.put(location.getLatitude(), location);
    }

    public int findClosestLocation() {
        int closestLatitude = 0;
        int minDiff = Integer.MAX_VALUE;

        for (Location location : locations.values()) {
            int diff = Math.abs(targetLocation.getLatitude() - location.getLatitude());
            if (diff < minDiff) {
                minDiff = diff;
                closestLatitude = location.getLatitude();
            }
        }

        return closestLatitude;
    }
}
