package com.graphs;
import java.util.ArrayList;



public class NumberOfProvinces {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize lists for each province
        for (int i = 0; i < 3; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add direct connections
        adjList.get(0).add(1);
        adjList.get(1).add(0);
//        adjList.get(1).add(2);
//        adjList.get(2).add();


        //0 based indexing - graph

        // Traverse through the visited array and count the number of not visited nodes or first time visited nodes.

        boolean[] visited = new boolean[3];
        int result = 0;

        for(int i=0; i<3; i++){
            if(!visited[i]){
                dfs(i, adjList, visited);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int i, ArrayList<ArrayList<Integer>> adjList, boolean[] visited){
        visited[i] = true;
        for(int j: adjList.get(i)){
            if(!visited[j]){
                dfs(j, adjList, visited);
            }
        }
    }
}
