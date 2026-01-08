import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] bk = new int[n+1];
        for(int i=1; i<=n; i++){
            bk[i] = 0;
        }

        // a번 ~ b번까지 같은 번호 'k'의 공을 넣는다
        // 바구니에는 공을 1개만 넣음
        // 공이 들어있을 경우 빼고 새로 넣음
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 넣는 공의 번호

            for(int j=a; j<=b; j++){
                bk[j] = c;
            }
        }

        // 바구니에 들어있는 공의 번호를 반환, 없으면 0
        for(int i=1; i<=n; i++){
            System.out.print(bk[i] + " ");
        }
    }
}