package study.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class BridgesAdjacencyList {


    public static void main(String[] args) {

        int numberOfNodes = 7;
        List<List<Integer>> graph = createGraph(numberOfNodes);
/*

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 3);
        addEdge(graph, 2, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 3, 4);
*/

//n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(1);
        connections.add(temp);

        for (List<Integer> val : connections) {
            for (int i = 0; i< val.size() ; i = i+2) {
                addEdge(graph, val.get(0), val.get(1));
            }
        }

        traverseGraph(graph, numberOfNodes);

    }

    private static void traverseGraph(List<List<Integer>> graph, int numberOfNodes) {

        int id = 0;
        int[] lowLinkValues = new int[numberOfNodes];
        int[] nodeIds = new int[numberOfNodes];
        //Node values
        for (int i = 0 ; i< nodeIds.length; i++) {
            nodeIds[i] = lowLinkValues[i] = id++;
        }
        boolean[] visitedNodes = new boolean[numberOfNodes];
        List<Integer> bridgeList = new ArrayList<>();
        for (int i = 0; i <numberOfNodes; i++) {
            if (!visitedNodes[i]) {
                dfs(i, -1, visitedNodes,graph, nodeIds, lowLinkValues, bridgeList);
            }
        }

        System.out.println(bridgeList.toString());

    }

    private static void dfs(int fromNode, int parent, boolean[] visitedNodes, List<List<Integer>> graph, int[] nodeIds, int[] lowLinkValues, List<Integer> bridgeList) {

        visitedNodes[fromNode] = true;

        for(Integer toNode: graph.get(fromNode)) {
            if(toNode == parent) {
                continue;
            }
            if (!visitedNodes[toNode]) {
                dfs(toNode, fromNode, visitedNodes, graph, nodeIds, lowLinkValues, bridgeList);
                lowLinkValues[fromNode] = Math.min(lowLinkValues[fromNode], lowLinkValues[toNode]);
                if (nodeIds[fromNode] < lowLinkValues[toNode]) {
                    bridgeList.add(fromNode);
                    bridgeList.add(toNode);
                }
            } else {
                lowLinkValues[fromNode] = Math.min(lowLinkValues[fromNode], nodeIds[toNode]);
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
