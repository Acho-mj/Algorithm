import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int fcnt = 0, dcnt = 0;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        fibo(n);
        dp = new int[n+1];
        dyna(n);
        System.out.print(fcnt + " " + dcnt);
    }

    static int fibo(int n){
        if(n==1 || n==2){
            fcnt++;
            return 1;
        }else{
            return fibo(n-1) + fibo(n-2);
        }
    }

    static int dyna(int n){
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dcnt++;
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}