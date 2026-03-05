import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] cnt = new int[1000001];     // 빈도 수
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            cnt[arr[i]]++;
        }

        // 스택에 오큰등수 못 찾은 인덱스 넣기
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            // 현재 스택 상단에 있는 인덱스
            while(!s.isEmpty() && cnt[arr[s.peek()]] < cnt[arr[i]]){
                ans[s.peek()] = arr[i];
                s.pop();
            }
            s.push(i);
        }

        // 아직도 오큰등수를 못 찾은 경우
        while(!s.isEmpty()){
            ans[s.peek()] = -1;
            s.pop();
        }

        // 출력
        for(int i=0; i<n; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.print(sb);
    }
}