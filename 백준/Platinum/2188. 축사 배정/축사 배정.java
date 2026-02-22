import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] cow;
    static boolean[] visited;
    static int[] cow_room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 소의 수
        m = Integer.parseInt(st.nextToken());   // 축사의 수

        // i번째 소가 들어가기 원하는 축사 수 + 축사 번호
        cow = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            cow[i] = new ArrayList<>();
        }
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());  // 소가 들어가기 원하는 축사 수
            for(int j=0; j<number; j++){
                int x = Integer.parseInt(st.nextToken());
                cow[i].add(x);
            }
        }

        // 최대한 많은 수의 소가 축사에 들어가도록
        int cnt = 0;
        cow_room = new int[m+1];    // 축사에 어떤 소가 들어갔는지 저장
        for(int i=1; i<=n; i++) {
            visited = new boolean[m+1]; // 축사 방문 여부
            if(dfs(i)) cnt++;
        }

        System.out.println(cnt);
    }

    // 축사 안에 들어갈 경우 true
    static boolean dfs(int idx){
        for(int room : cow[idx]){
            if(visited[room]) continue;
            visited[room] = true;

            // 축사가 비어있거나 현재 축사에 있는 소를 다른 곳으로 보낼 수 있을 경우
            if(cow_room[room] == 0 || dfs(cow_room[room])){
                cow_room[room] = idx;   // idx인 소를 현재 축사에 저장
                return true;
            }
        }

        return false;
    }
}