package cn.meow.search.dfs.friendCircles;

public class FriendCircles2 {
    private int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int circleNum = 0;
        // 已访问的结点
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(isConnected, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] isConnected, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {
            if (isConnected[i][k] == 1 && !hasVisited[k]) {
                dfs(isConnected, k, hasVisited);
            }
        }
    }
}
