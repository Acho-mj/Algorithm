import java.util.*;
import java.io.*;
import java.io.StringReader;

public class Main {
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int answer;
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       int N = Integer.parseInt(br.readLine()); // 컴퓨터의 전체 갯수
       int M = Integer.parseInt(br.readLine()); // 연결된 쌍의 수

       // graph 선언 및 초기화
       graph=new ArrayList[N+1];
       for(int i=1; i<=N; i++){
           graph[i]=new ArrayList<>();
       }

       for(int i=0; i<M; i++){
           st=new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());

           graph[a].add(b);
           graph[b].add(a);
       }

       visited = new boolean[N + 1];
       dfs(1);

       // 1번에 의해 바이러스 걸리는 컴퓨터의 수
       System.out.print(answer);
   }

   private static void dfs(int cur){
       visited[cur]=true;
       for(int next:graph[cur]){
           if(!visited[next]){
               answer++;
               dfs(next);
           }
       }
   }
}