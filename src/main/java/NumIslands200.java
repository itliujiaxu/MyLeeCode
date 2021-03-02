
/*200. 岛屿数量
        给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
        此外，你可以假设该网格的四条边均被水包围。

        示例 1：
            输入：grid = [
            ["1","1","1","1","0"],
            ["1","1","0","1","0"],
            ["1","1","0","0","0"],
            ["0","0","0","0","0"]
            ]
            输出：1
        示例 2：
            输入：grid = [
            ["1","1","0","0","0"],
            ["1","1","0","0","0"],
            ["0","0","1","0","0"],
            ["0","0","0","1","1"]
            ]
            输出：3

        提示：
            m == grid.length
            n == grid[i].length
            1 <= m, n <= 300
            grid[i][j] 的值为 '0' 或 '1'*/
public class NumIslands200 {
    //岛屿横向长度
    private int n;
    //岛屿纵向长度
    private int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int result = 0;
        if(n == 0 || m == 0) {
            return 0;
        }
        //循环遍历每个节点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //如果为‘水’，则继续下次循环
                if(grid[i][j] == '0') {
                    continue;
                }
                //如果为‘陆地’，则结果加1，并对其同一块陆地的所有节点都置为0
                result++;
                dfs(grid,i,j);
            }
        }
        return result;
    }
    private void dfs(char[][] grid, int i, int j){
        //防止超界
        if(i < 0 || i >= n || j < 0 || j >= m){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        //递归将统一陆地位置都置0
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public static void main(String[] args) {
        NumIslands200 numIslands = new NumIslands200();
        char[][] grid = {
                {'1','1','0','0'},
                {'1','0','0','0'},
                {'1','0','1','1'},
                {'0','0','1','1'}
        };
        System.out.println(numIslands.numIslands(grid));
    }
}
