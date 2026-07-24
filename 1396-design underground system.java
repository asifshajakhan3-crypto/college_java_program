import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Helper class to hold check-in details
    private static class CheckIn {
        String stationName;
        int time;

        CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Helper class to track route stats
    private static class Route {
        double totalTime;
        int count;

        Route(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    // Maps id -> CheckIn details
    private Map<Integer, CheckIn> checkIns;
    // Maps "startStation->endStation" -> Route stats
    private Map<String, Route> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.remove(id); // Retrieve and remove active check-in
        String routeKey = checkIn.stationName + "->" + stationName;
        int duration = t - checkIn.time;

        // Update route aggregate data
        Route route = routes.getOrDefault(routeKey, new Route(0, 0));
        route.totalTime += duration;
        route.count++;
        routes.put(routeKey, route);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        Route route = routes.get(routeKey);
        return route.totalTime / route.count;
    }
}
