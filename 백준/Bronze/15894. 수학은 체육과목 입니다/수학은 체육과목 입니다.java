import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());

        // 한 변의 길이가 1인 정사각형 - 가장 아랫줄의 정사각형이 n개 일 때 도형의 둘레 반환
        long result = 4*n;
        System.out.print(result);
    }
}