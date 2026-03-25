import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        // a의 갯수
        int aCnt = 0;
        for(char c : str.toCharArray()){
            if(c == 'a'){
                aCnt++;
            }
        }

        // 윈도우 크기 = aCnt
        int min = aCnt;
        for(int i=0; i<aCnt; i++){
            char c = str.charAt(i);
            if(c == 'a'){
                min--;
            }
        }

        // 슬라이딩 윈도우
        for(int i=1; i<n+aCnt; i++){
            int curMin = 0; // 현재 윈도우에서의 b 갯수

            for(int j=i; j<i+aCnt; j++) {
                int idx = j % n;
                char cur = str.charAt(idx);
                if(cur == 'b') curMin++;
            }

            min = Math.min(min, curMin);
        }

        System.out.print(min);
    }
}