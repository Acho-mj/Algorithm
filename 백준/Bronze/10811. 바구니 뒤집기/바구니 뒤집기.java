import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());    // 바구니
        int m = Integer.parseInt(st.nextToken());   // 역순으로 만들 바구니

        int[] bk = new int[n+1];
        for(int i=1; i<=n; i++){
            bk[i] = i;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while(a<b){
                int temp = bk[a];
                bk[a] = bk[b];
                bk[b] = temp;
                a++;
                b--;
            }
        }
        
        for(int i=1; i<=n; i++){
            System.out.print(bk[i] + " ");
        }
    }
}