import java.util.*;
import java.io.*;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] number = new int[n];
        for(int i=0; i<n; i++){
            number[i]=Integer.parseInt(st.nextToken());
        }

        // 소수 갯수 구하기
        int cnt=0;
        for(int i=0; i<n; i++){
            if(check(number[i])){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    // 소수인지 확인하기
    private static boolean check(int n){
        if(n<2) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            // 소수 아님
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}