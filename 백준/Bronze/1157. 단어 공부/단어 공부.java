import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> hash = new HashMap<>();
        for(char c : str.toCharArray()){
            c = Character.toUpperCase(c); // 대문자로 통일
            hash.put(c, hash.getOrDefault(c, 0)+1);
        }

        char up='a';
        for(char key : hash.keySet()){
            int value = hash.get(key);
            if(max < value){
                max = value;
                up=key;
            }
        }

        int cnt=0;
        for(char key : hash.keySet()){
            if(hash.get(key) == max){
                cnt++;
            }
            if(cnt>1){
                System.out.print("?");
                return;
            }
        }
        System.out.print(up);
    }
}