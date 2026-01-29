import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 상의 n, 하의 n -> 서로 다른 색상 (n * n-1)
        System.out.print(n*(n-1));
    }
}