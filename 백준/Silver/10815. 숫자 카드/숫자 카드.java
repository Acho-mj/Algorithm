import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 숫자 카드 개수

        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        int m = Integer.parseInt(br.readLine());   //   소유 여부 확인 개수

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int mnum = Integer.parseInt(st.nextToken());
            if(set.contains(mnum)){
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.print(sb);
    }
}