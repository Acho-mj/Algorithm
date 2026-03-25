import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String s = "";
        // 입력받은 대로
        while((s = br.readLine()) != null){
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}