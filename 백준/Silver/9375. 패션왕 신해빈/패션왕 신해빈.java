import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hash = new HashMap<>();
            for(int i=0; i<n; i++){
                String[] str = br.readLine().split(" ");
                // 의상 종류 = key
                hash.put(str[1], hash.getOrDefault(str[1], 0) + 1);
            }
            int answer = 1;
            for(String key : hash.keySet()){
                answer *= (hash.get(key)+1);
            }
            answer -= 1;    // 알몸의 경우

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}