import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        HashSet<String> set = new HashSet<>();

        for(int i=1; i<=n; i++){
            for(int j=0; j<=n-i; j++){
                String s = str.substring(j, j+i);
                set.add(s);
            }
        }
        System.out.print(set.size());
    }
}