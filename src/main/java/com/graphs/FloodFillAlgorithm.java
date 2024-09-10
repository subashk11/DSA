package com.graphs;

public class FloodFillAlgorithm {
    public static void main(String[] args) {
        //Fill the provided image matrix with inital node as color and fill the connected nodes with new color.
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        // source node
        int sr = 1;
        int sc = 1;

        // new color
        int newColor = 2;

        //copy matrix
        int[][] ans = image;

        //initial colour
        int initialColor = image[sr][sc];

        //delta paths for 4 directions
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        //dfs call
        dfs(image, sr, sc, newColor, initialColor, ans, delRow, delCol);

        //print the new image
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor, int initialColor, int[][] ans, int[] delRow, int[] delCol){
        //fill the source with new colour
        ans[sr][sc] = newColor;

        int rows = image.length;
        int cols = image[0].length;

        //check for 4 directions
        for(int i =0;i<4;i++){
            int rowN = sr + delRow[i];
            int colN = sc + delCol[i];

            if(rowN >= 0 && colN >= 0 && rowN<rows && colN<cols
                    && image[rowN][colN] == initialColor && ans[rowN][colN] != newColor)
                dfs(image, rowN, colN, newColor, initialColor, ans, delRow, delCol);
            }
        }
    }

