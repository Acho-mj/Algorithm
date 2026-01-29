import java.util.*;
import java.io.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb.append(fact(m, n)).append("\n");
        }
        System.out.print(sb);
    }

    static long fact(int n, int m){
        m = Math.min(n-m, m);
        long sum = 1;

        for(int i=1; i<=m; i++){
            sum = sum * (n - i + 1) / i;
        }
        return sum;
    }
}