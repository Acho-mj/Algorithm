import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());    // 바구니
        int m = Integer.parseInt(st.nextToken());   // 공을 교환하는 횟수

        int[][] change = new int[m][2];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            change[i][0] = Integer.parseInt(st.nextToken());
            change[i][1] = Integer.parseInt(st.nextToken());
        }

        // 바구니 - 공 매칭 배열
        int[] b = new int[n+1];
        for(int i=1; i<=n; i++){
            b[i] = i;
        }

        // 바구니에 든 공 바꾸기
        for(int i=0; i<m; i++){
            int temp = b[change[i][0]];
            b[change[i][0]] = b[change[i][1]];
            b[change[i][1]] = temp;
        }

        // 바구니 1부터 순서대로 공 반환
        for(int i=1; i<=n; i++){
            System.out.print(b[i] + " ");
        }
    }
}