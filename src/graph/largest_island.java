package graph;

import java.util.LinkedList;

public class largest_island {

        class pair{
            int x;
            int y;
            pair(int i,int j){
                x = i;
                y = j;
            }
        }

        int[] row = {1,0,-1,0,1,1,-1,-1};
        int[] col = {0,1,0,-1,1,-1,1,-1};
        int m;
        int n;
        public int findMaxArea(int[][] grid)
        {
            m = grid.length;
            n = grid[0].length;
            int max = 0;
            boolean called = false;
            for(int i=0;i<m;i++){
                for(int j = 0;j<n;j++){
                    if (grid[i][j] == 1){
                        int result = bfs(i,j,grid);
                        if(max <result){
                            max = result;
                        }
                    }
                }
            }
            return max;
        }

        int bfs(int r,int c,int[][] grid) {
            int island = 0;
            int[][] vist = new int[m][n];
            LinkedList<pair> queue = new LinkedList<>();
            queue.add(new pair(r,c));
            vist[r][c] = 1;

            while (!queue.isEmpty()){
                pair node = queue.pollFirst(); 
                island++;
                for(int i=0;i<8;i++){
                    int xx = node.x +row[i];
                    int yy = node.y +col[i];

                    if(isValid(xx,yy) && grid[xx][yy] == 1){
                        if(vist[xx][yy]!=1){
                            queue.add(new pair(xx,yy));
                            vist[xx][yy] = 1;

                            grid[xx][yy] = -1;
                        }
                    }
                }
            }
            return island;
        }

        boolean isValid(int x,int y){
            if(x<0 || x>=m || y<0 || y>=n){
                return false;
            }
            return true;
        }





    public static void main(String[] args) {
        largest_island ls = new largest_island();
        int[][] grid = {{1, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};
        System.out.println(ls.findMaxArea(grid));
    }
}
