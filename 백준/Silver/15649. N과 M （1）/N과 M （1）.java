import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] number;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 1 부터 n 까지
        m = Integer.parseInt(st.nextToken());   // 중복없이 m 개

        number = new int[n];
        for(int i=0; i<n; i++){
            number[i] = i+1;
        }

        visited = new boolean[n];
        result = new int[m];
        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth){

        if(depth == m){
            for(int value : result){
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i]= true;
                result[depth]=number[i];
                dfs(depth+1);

                visited[i] = false;
            }
        }
    }
}