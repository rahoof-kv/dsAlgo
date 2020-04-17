package study.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {


    public static void main(String[] args) {

        int numberOfNodes = 7;
        List<List<Integer>> graph = createGraph(numberOfNodes);

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 3);
        addEdge(graph, 2, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 3, 4);

        traverseGraph(graph, numberOfNodes);

    }

    private static void traverseGraph(List<List<Integer>> graph, int numberOfNodes) {

        int id = 0;
        int[] nodeIds = new int[numberOfNodes];
        //Node values
        for (int i = 0 ; i< nodeIds.length; i++) {
            nodeIds[i] = id++;
        }
        boolean[] visitedNodes = new boolean[numberOfNodes];
        List<Integer> nodesList = new ArrayList<>();
        for (int i = 0; i <numberOfNodes; i++) {
            if (!visitedNodes[i]) {
                dfs(i, -1, visitedNodes,graph, nodeIds, nodesList);
            }
        }

        System.out.println(nodesList.toString());

    }

    private static void dfs(int fromNode, int parent, boolean[] visitedNodes, List<List<Integer>> graph, int[] nodeIds, List<Integer> nodesList) {

        visitedNodes[fromNode] = true;

        for(Integer toNode: graph.get(fromNode)) {
            if(toNode == parent) {
                continue;
            }
            if(!visitedNodes[toNode]) {
                dfs(toNode, fromNode, visitedNodes, graph, nodeIds, nodesList);
                nodesList.add(nodeIds[toNode]);
            }
        }
    }

    public static List<List<Integer>> createGraph(int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        return graph;
    }

    public static void addEdge(List<List<Integer>> graph, int fromNode , int toNode) {
        graph.get(fromNode).add(toNode);
        graph.get(toNode).add(fromNode);
    }


}
