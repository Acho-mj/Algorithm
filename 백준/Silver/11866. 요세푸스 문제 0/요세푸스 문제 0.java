import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 큐에 넣고 k만큼 돌리기 (k번째까 아니라면 큐에 다시 넣기)
        int ord = 1;
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(ord == k){
                if(cnt > 0) sb.append(", ");
                sb.append(cur);
                cnt++;
                ord=1;
            }else{
                ord++;
                q.add(cur);
            }
        }
        sb.append(">");
        System.out.print(sb);
    }
}