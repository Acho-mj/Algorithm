import java.util.*;
import java.io.*;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gcd(a, b) + "\n" + lcm(a, b));
    }

    // 최대공약수
    private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

    // 최소공배수
    private static int lcm(int a, int b){
        return a*b/gcd(a, b);
    }
}