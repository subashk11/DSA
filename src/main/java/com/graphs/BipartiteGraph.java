package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args) {
        //This problem states that we have to check if the given graph is bipartite or not.
        //A graph is bipartite if two adjacent nodes have different colors.

        //adjacency list to store the graph.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        //create adjlist
        for(int i =0;i<4;i++){
            adjList.add(new ArrayList<>());
        }
        //graph
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(3).add(0);
        adjList.get(0).add(3);

        int[] visited = new int[4];
        for(int i =0;i<4;i++){
            visited[i] = -1;
        }

        // 0 - color 1 and 1 - color 2
        boolean result = true;

        for(int i = 0;i< visited.length;i++){
            if(visited[i] == -1){
                if(!bfs(i, adjList, visited, 0)){
                    result = false;
                    break;
                }
            }
        }

        System.out.println("The graph is bipartite: "+result);

    }

    static class Pair{
        int node;
        int color;
        Pair(int node, int color){
            this.node = node;
            this.color = color;
        }
    }

    //BFS traversal
    public static boolean bfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited, int color){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, color));
        visited[node] = color;

        while(!queue.isEmpty()){
            Pair currentNode = queue.poll();
            int currentColor = currentNode.color;
            int currentNodeValue = currentNode.node;

            ArrayList<Integer> adjNodes = adjList.get(currentNodeValue);

            for(Integer i : adjNodes){
                if(visited[i] == -1){
                    visited[i] = 1 - currentColor;
                    queue.add(new Pair(i, 1 - currentColor));
                }else if(visited[i] == currentColor){
                    return false;
                }
            }


        }
        return true;
    }

    //DFS traversal
    public static boolean dfs(int node, int colour, int[] visited, ArrayList<ArrayList<Integer>> adjList){
        visited[node] = colour;
        for(int i : adjList.get(node)){
            if(visited[i] == -1){
                if(dfs(i, 1 - colour, visited, adjList) == false){
                    return false;
                }
            }else if(visited[i] == colour){
                return false;
            }
        }

        return true;
    }
}
