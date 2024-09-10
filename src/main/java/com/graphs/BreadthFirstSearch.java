package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        // This traversal will give the levelwise/distance wise traversal of the graph.

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

        //BFS traversal

        //Visted array to keep track of visited nodes
        boolean[] visited = new boolean[5];

        //Queue to store the nodes
        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> result = new ArrayList<>();

        //add the starting node.
        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            //get the adjancent nodes of the current node from the input graph.
            ArrayList<Integer> neighbours = adjList.get(node);
            for(int i : neighbours){
                //check the node is already visited or not
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        System.out.println(result.toString());

    }


    /**
     *
     *  Time and space complexity of BFS:
     *  The queue will run for all the node ie N times
     *  The inner for loop will run for all the edges ie 2E times
     *
     *  TC = O(N + 2E)
     */
}
