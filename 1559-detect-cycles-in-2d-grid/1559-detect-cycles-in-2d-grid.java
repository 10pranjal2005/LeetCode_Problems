class Solution{
    public boolean containsCycle(char[][] grid){
        int m=grid.length,n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    if(dfs(grid,vis,i,j,-1,-1,grid[i][j]))return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] grid,boolean[][] vis,int r,int c,int pr,int pc,char ch){
        if(vis[r][c])return true;
        vis[r][c]=true;
        int[][] d={{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] k:d){
            int nr=r+k[0],nc=c+k[1];
            if(nr>=0&&nc>=0&&nr<grid.length&&nc<grid[0].length&&grid[nr][nc]==ch){
                if(nr==pr&&nc==pc)continue;
                if(dfs(grid,vis,nr,nc,r,c,ch))return true;
            }
        }
        return false;
    }
}