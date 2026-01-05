import java.util.*;
import java.io.*;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt=0;
        for(int i=1; i<=n; i++){
            // 약수 수하기
            if(n%i==0)
                cnt++;
            if(cnt == k){
                System.out.println(i);
                return;
            }
        }
        // N의 약수 중 K 번째로 작은 수가 없는 경우
        System.out.print(0);
    }
}