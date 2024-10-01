package greedyalgorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GreedyAlgorithm {
    public static void main(String[] args){
        /*We have a radio program, and we want to cover all the states. But each station cover some states.
        *Our objective is find the smaller number of stations that covers all the states.
        * */

        //States that we want to reach
        Set<String> statesWeWantToReach = new HashSet<>(Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

        //Now the stations
        HashMap<String, Set<String>> stations = new HashMap<String, Set<String>>();
        stations.put("s1", Set.of("id", "nv", "ut"));
        stations.put("s2", Set.of("wa", "id", "mt"));
        stations.put("s3", Set.of("or", "nv", "ca"));
        stations.put("s4", Set.of("nv", "ut"));
        stations.put("s5", Set.of("ca", "az"));

        //Now a Set to storage the chosen stations
        Set<String> finalStations = new HashSet<String>();

        //Now, the algorithm to choose the most optimized stations
        while(!statesWeWantToReach.isEmpty()){
            String bestStation = null;
            Set<String> statesCoveredByBest = new HashSet<>();
            //For each station, we're going to find that with the most number of states that are not reached yet
            for(Map.Entry<String, Set<String>> station : stations.entrySet()){
                Set<String> coveredStates = new HashSet<>(station.getValue());
                coveredStates.retainAll(statesWeWantToReach);
                //Here we verify if the station reach more states than the actual bestStationCovered
                if(coveredStates.size() > statesCoveredByBest.size()){
                    bestStation = station.getKey();
                    statesCoveredByBest = coveredStates;
                }
            }
            if(bestStation != null){
                finalStations.add(bestStation);
                statesWeWantToReach.removeAll(statesCoveredByBest);
            }


        }
        System.out.println("Stations chose: " + finalStations);


    }

}
