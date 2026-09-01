package org.t1.java;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println( find("ABDEFADRFG", "DAFERG"));
    }

    public static Set<String> find(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.println("//OLD//");
                print(dp);
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                System.out.println("//NEW//");
                print(dp);
            }
        }

        print(dp);
        Set<String> result = new HashSet<>();
        backtrack(s1, s2, n, m, dp, "", result);

        return result;
    }

    private static void backtrack(String s1, String s2, int i, int j,
                                  int[][] dp, String current, Set<String> result) {
        //("ABDEFADRFG", "DAFERG");

        if (i == 0 || j == 0) {
            result.add(new StringBuilder(current).reverse().toString());
            return;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            backtrack(s1, s2, i - 1, j - 1, dp,
                    current + s1.charAt(i - 1), result);
        } else {

            if (dp[i - 1][j] == dp[i][j]) {
                backtrack(s1, s2, i - 1, j, dp, current, result);
            }

            if (dp[i][j - 1] == dp[i][j]) {
                backtrack(s1, s2, i, j - 1, dp, current, result);
            }
        }
    }

    public static void print(int[][] dp) {
        System.out.println("-----------------------------------");
        for(int i=0; i< dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("-----------------------------------");
    }

}