import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hash = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++) {
            int n = Integer.parseInt(st.nextToken());
            hash.put(n, hash.getOrDefault(n, 0)+1);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++) {
            int n = Integer.parseInt(st.nextToken());
            hash.put(n, hash.getOrDefault(n, 0)+1);
        }

        int result = 0;
        for(int k : hash.keySet()){
            if(hash.get(k) == 1){
                result += 1;
            }
        }
        System.out.print(result);
    }
}