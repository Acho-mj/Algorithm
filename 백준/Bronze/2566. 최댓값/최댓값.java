import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max =Integer.MIN_VALUE;
        int r = 0;
        int c = 0;

        int[][] map = new int[10][10];
        for(int i=1; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<10; j++){
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
                if(max < cur){
                    max = cur;
                    r = i;
                    c = j;
                }
            }
        }
        System.out.print(max + "\n" + r + " " + c);
    }
}