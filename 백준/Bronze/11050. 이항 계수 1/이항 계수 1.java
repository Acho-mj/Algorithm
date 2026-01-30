import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.print(con(n, k));
    }
    static int con(int n, int k){
        int r = Math.min(k, n-k);
        int sum = 1;
        if(r<1) return 1;
        for(int i=1; i<=r; i++){
            sum = sum * (n - i + 1) / i;
        }
        return sum;
    }
}