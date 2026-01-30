import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] answer;
    static int[] number;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());   // m개 선택

        // 같은 수를 중복 선택 가능
        number = new int[n];
        for(int i=0; i<n; i++){
            number[i] = i+1;
        }

        answer = new int[m];
        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth){
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            answer[depth] = number[i];
            dfs(depth + 1);
        }
    }
}