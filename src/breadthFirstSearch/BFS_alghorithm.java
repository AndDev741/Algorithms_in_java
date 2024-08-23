package breadthFirstSearch;

import java.awt.*;
import java.util.*;
import java.util.List;

public class BFS_alghorithm {

    public static void main(String[] args) {
        breadth_first_search();
    }

    public static void breadth_first_search() {
        String seller = "Maurice";

        //Creation of the graph
        HashMap<String, List<String>> graph = new HashMap<>();
        graph.put("me", List.of("Alice", "Bob", "Charlie"));
        graph.put("Charlie", List.of());
        graph.put("Alice", List.of("Jorge", "Maurice"));
        graph.put("Bob", List.of("Maurice"));
        graph.put("Maurice", List.of());
        graph.put("Jorge", List.of());

        //Queue to make the search
        Deque<String> queue_of_search = new ArrayDeque<>();
        queue_of_search.add("me");

        //To track the nodes already verified
        Set<String> searched = new HashSet<>();

        while(!queue_of_search.isEmpty()){

            String person = queue_of_search.poll(); //poll() return the next element in the queue
            if(!searched.contains(person)) {

                //verify if the person is the seller
                if(person.equals(seller)){
                    System.out.println(person + " is the seller!");
                    return;
                } else {
                    //Add other contacts to the queue
                    queue_of_search.addAll(graph.getOrDefault(person, Collections.emptyList()));

                    //Mark the person as verified
                    searched.add(person);
                }
            }
        }

        System.out.println("No sellers find in the contacts");
    }
}