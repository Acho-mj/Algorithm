import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<String> arr = new ArrayList<>();
        String[] s = str.split(" ");

        for(int i=0; i<s.length; i++){
            // 공백 제거
            if(!s[i].equals("")){
                arr.add(s[i]);
            }
        }
        System.out.print(arr.size());
    }
}