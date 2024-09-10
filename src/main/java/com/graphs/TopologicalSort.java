package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.graphs.NumberOfProvinces.dfs;

public class TopologicalSort {
    public static void main(String[] args) {
        //This Algorithm will only work for Directed Acyclic Graphs(DAG).

        // The intuition behind this algorithm is that we will print the nodes with a topological order.
        // We will use the DFS traversal to get the topological order.

        //adjacency list to store the graph.
        int V = 6;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        //create adjlist
        for(int i =0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        //graph
        adjList.get(5).add(2);
        adjList.get(5).add(0);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(1);

        //Visited array
        boolean[] visited = new boolean[V];

        //Stack to store the order
        Stack<Integer> stack = new Stack<>();

        //traversal of each nodes which are not visited.
        for(int i =0;i<V;i++){
            if(!visited[i]){
                dfs(i, adjList, visited, stack);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            result.add(stack.pop());
        }

        System.out.println(result.toString());

        //KAHNS ALGORITHM or BFS can also be used to get the topological order.
        int[] inorder = new int[V];

        for(int i =0 ;i<V;i++){
            for(Integer j : adjList.get(i)){
                inorder[j]++;
            }
        }

        bfs(adjList, inorder, V);
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> stack){
        visited[node] = true;

        for(Integer i : adjList.get(node)){
            if(!visited[i]){
                dfs(i, adjList, visited, stack);

            }
        }
        stack.push(node);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adjList, int[] inorder, int V){

        Queue<Integer> queue = new LinkedList<>();

        for(int i =0;i<V;i++){
            if(inorder[i] == 0){
                queue.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        //BFS traversal
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for(Integer i : adjList.get(node)){
                inorder[i]--;
                if(inorder[i] == 0){
                    queue.add(i);
                }
            }
        }

        System.out.println(result.toString());

    }
}
