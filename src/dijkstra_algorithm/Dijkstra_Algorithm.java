package dijkstra_algorithm;

import java.util.*;

public class Dijkstra_Algorithm {

    public static void main(String[] args){
        HashMap<String, Map<String, Integer>> graph = new HashMap<>();
        HashMap<String, Double> costs = new HashMap<>();
        HashMap<String, String> early_graph = new HashMap<>();

        //Graph
        graph.put("start", Map.of("A", 6, "B", 2));
        graph.put("A", Map.of("end", 1));
        graph.put("B", Map.of("A", 3, "end", 5));
        graph.put("end", Map.of());

        //Costs
        costs.put("A", 6.0);
        costs.put("B", 2.0);
        costs.put("end", Double.POSITIVE_INFINITY);

        //Early graphs
        early_graph.put("A", "start");
        early_graph.put("B", "start");
        early_graph.put("end", "");


        dijkstra_algorithm(graph, costs, early_graph);
    }

    public static void dijkstra_algorithm(HashMap<String, Map<String, Integer>> graph, HashMap<String, Double> costs,
                                          HashMap<String, String> early_graph){
        List<String> processed = new ArrayList<>();

        String node = find_less_cost(costs, processed);
        while (node != null){
            Double cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);
            for(Map.Entry<String, Integer> neighbor : neighbors.entrySet()){
                Double new_cost = cost + neighbor.getValue();
                if(costs.get(neighbor.getKey()) > new_cost){
                    costs.replace(neighbor.getKey(), new_cost);
                    early_graph.replace(neighbor.getKey(), node);
                }
            }
            processed.add(node);
            node = find_less_cost(costs, processed);
        }

    }

    public static String find_less_cost(HashMap<String, Double> costs, List<String> processed){
        Double less_cost = Double.POSITIVE_INFINITY;
        String node_less_cost = null;

        for(Map.Entry<String, Double> node : costs.entrySet()){
            Double cost = node.getValue();
            if(cost < less_cost && !processed.contains(node.getKey())){
                less_cost = cost;
                node_less_cost = node.getKey();
            }
        }

        return node_less_cost;
    }

}
