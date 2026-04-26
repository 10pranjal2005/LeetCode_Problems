class Solution{
    int[] d={1,0,-1,0,1};
    public boolean containsCycle(char[][] g){
        int m=g.length,n=g[0].length;
        boolean[][] v=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!v[i][j]){
                    if(dfs(g,v,i,j,-1,-1,g[i][j]))return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] g,boolean[][] v,int r,int c,int pr,int pc,char ch){
        v[r][c]=true;
        for(int k=0;k<4;k++){
            int nr=r+d[k],nc=c+d[k+1];
            if(nr<0||nc<0||nr>=g.length||nc>=g[0].length||g[nr][nc]!=ch)continue;
            if(nr==pr&&nc==pc)continue;
            if(v[nr][nc]||dfs(g,v,nr,nc,r,c,ch))return true;
        }
        return false;
    }
}