import java.util.*;
import java.io.*;

public class Main {
    static int count =1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }

        // isPalindrome 함수의 반환값과 recursion 함수의 호출 횟수
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(isPalindrome(arr[i], 0, n-1)).append(" ").append(count);
            sb.append("\n");
            count = 1;
        }
        System.out.print(sb);
    }

    public static int isPalindrome(String str, int l, int r){
        return recursion(str, 0, str.length()-1);
    }

    public static int recursion(String str, int l, int r){
        char[] s = str.toCharArray();
        if(l>=r){
            return 1;
        }else if(s[l] != s[r]){
            return 0;
        }else{
            count++;
            return recursion(str, l+1, r-1);
        }
    }
}