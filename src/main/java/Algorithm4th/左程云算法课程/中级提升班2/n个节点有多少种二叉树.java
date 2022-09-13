package Algorithm4th.左程云算法课程.中级提升班2;

public class n个节点有多少种二叉树 {
    /**
     * 给定n值，代表二叉树的节点个数，返回能形成多少种不同的二叉树结构
     * 方法1：递归方法
     */
    public int numTrees(int n) {
        if (n==0) {
            return 1;
        }
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        int res = 0;
        for (int leftNum = 0;leftNum<=n-1;leftNum++) {
            int leftWays = numTrees(leftNum);
            int rightWays = numTrees(n-leftNum-1);
            res += leftWays * rightWays;
        }
        return res;
    }
    /**
     * 方法2：动态规划(其实很多动态规划都是由递归优化而来)
     */
    public int numTrees2(int n) {
        if (n<2) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1;i<n+1;i++) { //节点个数为i的时候
            for (int leftNum=0;leftNum<=i-1;leftNum++) {//左边节点是leftNum，右边节点是i-leftNum-1
                dp[i] += dp[leftNum] * dp[i-leftNum-1];
            }
        }
        return dp[n];
    }

}
