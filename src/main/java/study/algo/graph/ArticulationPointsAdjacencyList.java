package study.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPointsAdjacencyList {

    public static void main(String[] args) {

        int numberOfNodes = 9;
        List<List<Integer>> graph = createGraph(numberOfNodes);

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 2, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 6, 7);
        addEdge(graph, 7, 8);
        addEdge(graph, 8, 5);

        List<Integer> result = traverseGraph(graph, numberOfNodes);
        System.out.println(result.toString());

    }

    private static List<Integer> traverseGraph(List<List<Integer>> graph, int numberOfNodes) {

        int id = 0;
        int rootNodeOutcomingEdgeCount;
        int[] lowLinkValues = new int[numberOfNodes];
        int[] nodeIds = new int[numberOfNodes];
        boolean[] isArticulationPoint = new boolean[numberOfNodes];

        //Fill Node and default low link values
        for (int i = 0; i < nodeIds.length; i++) {
            nodeIds[i] = lowLinkValues[i] = id++;
        }

        boolean[] visitedNodes = new boolean[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            if (!visitedNodes[i]) {
                rootNodeOutcomingEdgeCount = 0;
                dfs(i, i, -1, visitedNodes, graph, nodeIds, lowLinkValues, isArticulationPoint, rootNodeOutcomingEdgeCount);
                isArticulationPoint[i] = rootNodeOutcomingEdgeCount > 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            if (isArticulationPoint[i]) {
                result.add(i);
            }
        }

        return result;

    }

    private static void dfs(int root, int fromNode, int parent, boolean[] visitedNodes, List<List<Integer>> graph, int[] nodeIds, int[] lowLinkValues, boolean[] isArticulationPoint, int rootNodeOutcomingEdgeCount) {

        if (root == parent) {
            rootNodeOutcomingEdgeCount++;
        }

        visitedNodes[fromNode] = true;

        for (Integer toNode : graph.get(fromNode)) {
            if (toNode == parent) {
                continue;
            }
            if (!visitedNodes[toNode]) {
                dfs(root, toNode, fromNode, visitedNodes, graph, nodeIds, lowLinkValues, isArticulationPoint, rootNodeOutcomingEdgeCount);
                lowLinkValues[fromNode] = Math.min(lowLinkValues[fromNode], lowLinkValues[toNode]);
                if (nodeIds[fromNode] <= lowLinkValues[toNode]) {
                    isArticulationPoint[fromNode] = true;
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

    public static void addEdge(List<List<Integer>> graph, int fromNode, int toNode) {
        graph.get(fromNode).add(toNode);
        graph.get(toNode).add(fromNode);
    }


}
