package study.algo.medium;

public class UniquePaths {

    public static void main(String[] args) {

        System.out.println(uniquePaths(3,2));
    }


    public static int uniquePaths(int m, int n) {


        int[][] dp = new int[m][n];

        //set base conditions
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
