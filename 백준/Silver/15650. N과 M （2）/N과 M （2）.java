import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        ans = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }

        visited = new boolean[n];
        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth){

        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(depth > 0 && arr[i]<ans[depth-1]) continue;
                visited[i] = true;
                ans[depth] = arr[i];
                dfs(depth+1);

                visited[i] = false;
            }
        }
    }
}