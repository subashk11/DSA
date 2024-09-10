package com.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Aliendictionary {
    public static void main(String[] args) {
        //Alien Dictionary - Problem states that string of values is passed and need to find the order of the characters
        // In a dictionary format

        // Sample data
        String[] data = {"baa", "abcd", "abca", "cab", "cad"};
        int n = data.length;

        //Algorithm - Use Topology sort in DFS to solve the problem
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0;i < n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        //1. First form the DAG
        for(int i = 0;i<data.length - 1;i++){
            String s1 = data[i];
            String s2 = data[i+1];

            int len = Math.min(s1.length(), s2.length());
            for(int ptr = 0; ptr < len ; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    int val1 = s1.charAt(ptr) - 'a';
                    int val2 = s2.charAt(ptr) - 'a';
                    System.out.println("Value 1 : "+ val1 + " val 2 : "+ val2);
                    adjList.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }

        }

        //visited array
        boolean[] visited = new boolean[n];
        List<Integer> result = topoSort(adjList, visited);

        System.out.println(result.toString());



    }

    public static List<Integer> topoSort(ArrayList<ArrayList<Integer>> adjList, boolean[] visited){
        //create stack and pass it to dfs
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<visited.length;i++){
            if(!visited[i]){
                dfs(i, adjList, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i< visited.length; i++){
            int num = stack.pop();
            result.add(num);
        }

        return result;
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> stack){
        //make the node visited
        visited[node] = true;
        for(int i : adjList.get(node)){
            if(!visited[i]){
                dfs(i, adjList, visited, stack);
            }
        }
        //add the last node in the graph first
        stack.push(node);
    }

}
