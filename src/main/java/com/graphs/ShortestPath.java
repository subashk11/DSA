package com.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortestPath {
    static class Pair{
        int node;
        int weight;

        Pair(int node, int weight){
            this.node = node;
            this.weight = node;
        }
    }
    public static void main(String[] args) {
        // This problem states to find the minimum distance from src to all nodes

        //create a graph
        List<List<Pair>> graph = new ArrayList<>();

        for(int i = 0 ; i< 5; i++){
            graph.add(new ArrayList<>());
        }
        // Adding edges with weights
        graph.get(0).add(new Pair(1, 2));
        graph.get(0).add(new Pair(2, 3));
        graph.get(1).add(new Pair(3, 6));
        graph.get(1).add(new Pair(2, 1));
        graph.get(2).add(new Pair(3, 1));
        graph.get(2).add(new Pair(4, 4));
        graph.get(3).add(new Pair(4, 2));

        //graph.get(4).add(new Pair(5, 1));

        int n = graph.size();
        System.out.println(n);
        //DO a topology sort and get the sorted stack
        boolean[] visited = new boolean[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i< n ; i++){
            if(!visited[i]){
                dfs(i, graph, visited, stack);
            }
        }

        System.out.println("stack size is : " + stack.size());

        //Do a distance calculation
        int[] distance = new int[n+1];

        for(int i = 0 ; i<= n;i++){
            distance[i] = -1;
        }

        //traverse through the stack
        int src = stack.peek();
        distance[src] = 0;

        while(!stack.isEmpty()){
            int source = stack.pop();
            int distanceTravelled = distance[source];
            List<Pair> adjList = graph.get(source);

            for(Pair node : adjList){
                int nd = node.node;
                int d = node.weight;
                if(distance[nd] == -1){
                    distance[nd] = distanceTravelled + d;
                }else if(distance[n] > d){
                    distance[nd] = d;
                }
            }
        }

        for(int i = 0; i< n;i++){
            System.out.print(distance[i]+" ");
        }
    }

    public static void dfs(int node, List<List<Pair>> graph, boolean[] visited, Stack<Integer> stack){
        System.out.println(node);
        visited[node] = true;

        for(Pair currNode : graph.get(node)){
            if(!visited[currNode.node]){
                dfs(currNode.node, graph, visited, stack);
            }
        }

        stack.push(node);
    }
}
