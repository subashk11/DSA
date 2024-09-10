package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectACycle {

    static class Pair{
        int node;
        int parent;
        Pair(int node, int parent){
            this.parent = parent;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        // provided a adjacency list, detect if there is a cycle in the graph.

        // adjecency list -
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize lists for each node
        for (int i = 0; i < 4; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(0);

        //0 based indexing - graph
        boolean[] visited = new boolean[4];



        boolean result = false;
        for(int i =0; i < 4; i++){
            if(!visited[i]){
                if(bfs(i, adjList, visited)){
                    result = true;
                    break;
                }else{
                    result = false;
                }
            }
        }

        System.out.println(result);
    }

    public static boolean bfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited){
        visited[node] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, -1));

        while(!queue.isEmpty()){
            int currentNode = queue.peek().node;
            int parent = queue.peek().parent;
            queue.poll();
            for(int adj : adjList.get(currentNode)){
                if(!visited[adj]){
                    visited[adj] = true;
                    queue.add(new Pair(adj, currentNode));
                }else if(parent != adj){
                    return true;
                }
            }
        }
        return false;
    }
}
