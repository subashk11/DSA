package com.graphs;

import java.util.ArrayList;

public class DepthFirstSearch {
    public static void main(String[] args) {

        //This traversal will give the depth wise traversal from a node.

        //1. adjacency list -> create a list of lists to store each adjacent node or connected node.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize lists for each vertex
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges
        adjList.get(0).add(1);
        adjList.get(0).add(4);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(1).add(3);
        adjList.get(1).add(4);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(1);
        adjList.get(3).add(2);
        adjList.get(3).add(4);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(4).add(3);

        //0 based indexing - graph

        //use recursion to solve this problem.
        boolean[] visited = new boolean[5];

        ArrayList<Integer> result = new ArrayList<>();

        dfs(0, adjList, visited, result);

        System.out.println(result);
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> result){
        visited[node] = true;
        result.add(node);

        ArrayList<Integer> neighbours = adjList.get(node);
        for(Integer i : neighbours){
            if(!visited[i]){
                //recursive call to go to at most depth of a node.
                dfs(i, adjList, visited, result);
            }
        }
    }
}
