import java.util.*;
import java.io.*;

public class Main {
    static int checkCount = 0;
    static char[] strArr;
    static int[] arr;
    static int[] curArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());   // 문자열 길이
        int s = Integer.parseInt(st.nextToken());   // 부분 문자열 길이

        String str = br.readLine();     // 문자열
        strArr = str.toCharArray();

        arr = new int[4];     // DNA 각 최소 갯수
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            // 최소 요구사항 개수가 0개 라면 이미 조건 만족
            if(arr[i] == 0) checkCount++;
        }

        // 문자열 검사
        int result = 0;

        curArr = new int[4];  // 현재 윈도우의 알파벳 개수
        for(int i=0; i<s; i++){
            add(strArr[i]);
        }
        if(checkCount == 4) result++;

        // 슬라이딩
        for(int i=s; i<p; i++){
            int j = i-s;  // 제거
            add(strArr[i]);
            remove(strArr[j]);

            if(checkCount == 4) result++;
        }
        System.out.print(result);
    }

    // 문자가 호출 (최소요구사항 arr 와 갯수 맞는지 확인)
    static void add(char s){

        switch(s){
            case 'A':
                curArr[0]++;
                if(curArr[0] == arr[0]) checkCount++;
                break;
            case 'C':
                curArr[1]++;
                if(curArr[1] == arr[1]) checkCount++;
                break;
            case 'G':
                curArr[2]++;
                if(curArr[2] == arr[2]) checkCount++;
                break;
            case 'T':
                curArr[3]++;
                if(curArr[3] == arr[3]) checkCount++;
                break;
        }
    }

    // 이전 문자 제거
    static void remove(char s){
        switch(s){
            case 'A':
                if(curArr[0] == arr[0]) checkCount--;
                curArr[0]--;
                break;
            case 'C':
                if(curArr[1] == arr[1]) checkCount--;
                curArr[1]--;
                break;
            case 'G':
                if(curArr[2] == arr[2]) checkCount--;
                curArr[2]--;
                break;
            case 'T':
                if(curArr[3] == arr[3]) checkCount--;
                curArr[3]--;
                break;
        }
    }
}