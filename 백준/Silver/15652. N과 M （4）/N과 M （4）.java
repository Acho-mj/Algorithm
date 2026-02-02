import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] number;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        number = new int[n];
        for(int i=0; i<n; i++){
            number[i] = i+1;
        }

        answer = new int[m];
        dfs(0);

        System.out.print(sb);
    }

    public static void dfs(int depth){
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            if(depth > 0 && answer[depth-1] > number[i]) continue;

            answer[depth] = number[i];
            dfs(depth + 1);
        }
    }
}