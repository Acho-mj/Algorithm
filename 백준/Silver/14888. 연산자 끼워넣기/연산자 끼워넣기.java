import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] number;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        number = new int[11];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        dfs(1, number[0], plus, minus, mul, div);

        System.out.print(max + "\n" + min);
    }

    // 연산자 계산
    private static void dfs(int idx, int cur, int plus, int minus, int mul, int div){
        if(idx == n){
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }
        if(plus>0)
            dfs(idx+1, cur+number[idx], plus-1, minus, mul, div);
        if(minus>0)
            dfs(idx+1, cur-number[idx], plus, minus-1, mul, div);
        if(mul>0)
            dfs(idx+1, cur*number[idx], plus, minus, mul-1, div);
        if(div>0 && number[idx] !=0)
            dfs(idx+1, cur/number[idx], plus, minus, mul, div-1);
    }
}