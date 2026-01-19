import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 문자열의 개수
        int m = Integer.parseInt(st.nextToken());   // 집합에 포함된 것 찾기

        HashSet<String> S = new HashSet<>();
        for(int i=0; i<n; i++){
            S.add(br.readLine());
        }

        int count=0;
        for(int i=0; i<m; i++){
            String str = br.readLine();
            if(S.contains(str)) count++;
        }

        System.out.print(count);
    }
}