package study.algo.medium;

import java.util.Stack;

public class Graph {

    private final int maxVertices = 4;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Stack<Integer> stack;

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0,1);
        graph.addEdge(1,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);

        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');

        graph.displayVertex(0);
        graph.displayGraph();

        graph.dfs();
    }
    
    public Graph(){
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int y = 0; y < maxVertices; y++) {
            for (int x = 0; x < maxVertices; x++) {
                adjMatrix[y][x] = 0;
            }
        }
        stack = new Stack<>();
    }

    public void addVertex(char label){
        vertexList[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
       // adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    public void displayGraph(){
        for (int y = 0; y < maxVertices; y++) {
            for (int x = 0; x < maxVertices; x++) {
               System.out.print(adjMatrix[y][x]);
            }
            System.out.print("\n");
        }
    }

    public void dfs(){
        vertexList[0].visited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()){

            int v = getAdjUnvisitedVertex(stack.peek());

            if(v == -1){
                this.stack.pop();
            }else{
                vertexList[v].visited = true;
                displayVertex(v);
                this.stack.push(v);
            }
        }

        //reset flags
        for (int j = 0; j < vertexCount; j++) {
            vertexList[j].visited = false;
        }
    }

    private int getAdjUnvisitedVertex(int v) {

        for (int j = 0; j < vertexCount; j++) {
            if(adjMatrix[v][j] == 1 && vertexList[j].visited == false){
                return j;
            }
        }
        return -1;
    }
}

class Vertex {
    public char label;
    public boolean visited;

    public Vertex(char label) {
        this.label = label;
        this.visited = false;
    }
}