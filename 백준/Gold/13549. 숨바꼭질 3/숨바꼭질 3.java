import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 수빈이의 위치
        k = Integer.parseInt(st.nextToken());   // 동생의 위치

        if (n == k) {
            System.out.print(0);
            return;
        }

        // 걷기 : 1초 후 x-1 , x+1 / 순간이동 : 0초 후 2*x
        // 빠른 시간 출력
        System.out.print(bfs(n, 0));
    }

    static int bfs(int pos, int time){
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{pos, time});    // 현재 위치, 걸린 시간

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curPos = cur[0];
            int curTime = cur[1];

            // 동생의 위치
            if(curPos == k){
                return curTime;
            }

            // 방문처리
            if(visited[curPos]) continue;
            visited[curPos] = true;

            int teleport = curPos * 2;
            if(teleport<=100000 && !visited[teleport]){
                q.addFirst(new int[]{teleport, curTime});
            }

            int back = curPos - 1;
            if(back>=0 && !visited[back]){
                q.addLast(new int[]{back, curTime+1});
            }

            int forward = curPos + 1;
            if(forward<=100000 && !visited[forward]){
                q.addLast(new int[]{forward, curTime+1});
            }
        }
        return -1;
    }
}