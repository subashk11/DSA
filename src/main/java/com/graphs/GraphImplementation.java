package com.graphs;

import java.util.ArrayList;

public class GraphImplementation {
    public static void main(String[] args) {

        //graphs can be stored in two ways
        //1. using a matrix (2D array) -> adjacency matrix
        //2. using a list -> adjacency list

        // input will be the number of vertices and edges
        // 1  2
        // 2  3
        // 3  4
        // 4  5
        // 1  4

        //1. adjacency matrix
        // if its a undirected graph, then the matrix will be symmetric with size of n from 1 to n, here it is n+1, 6.

        int[][] adjMatrix = new int[6][6];

        //As it is a undirected graph, we need to fill the matrix symmetrically, both the points needs to be filled.
        //1 2
        adjMatrix[1][2] = 1;
        adjMatrix[2][1] = 1;

        //2 3
        adjMatrix[2][3] = 1;
        adjMatrix[3][2] = 1;

        //3 4
        adjMatrix[3][4] = 1;
        adjMatrix[4][3] = 1;

        //4 5
        adjMatrix[4][5] = 1;
        adjMatrix[5][4] = 1;

        //1 4
        adjMatrix[1][4] = 1;
        adjMatrix[4][1] = 1;


        //2. adjacency list -> create a list of lists to store each adjacent node or connected node.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        //add n+1 empty lists to the list
        for(int i=0; i<6; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        //1 2
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        //2 3
        adjList.get(2).add(3);
        adjList.get(3).add(2);

        //3 4
        adjList.get(3).add(4);
        adjList.get(4).add(3);

        //4 5
        adjList.get(4).add(5);
        adjList.get(5).add(4);

        //1 4
        adjList.get(1).add(4);
        adjList.get(4).add(1);


        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();

        }

    }
}
