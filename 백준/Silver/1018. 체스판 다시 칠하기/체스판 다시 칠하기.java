import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 행
        int m = Integer.parseInt(st.nextToken());   // 열

        char[][] board = new char[n][m];
        for (int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        // 8*8 크기에서 번갈아가며 흰/검
        // 전체에서 8*8를 반복하는 횟수
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                answer = Math.min(answer, paint(board, i, j));
            }
        }
        System.out.print(answer);
    }

    // 8*8 안에서 페인트 칠하기
    // 시작이 흰색일 경우
    public static int paint(char[][] board, int i, int j){
        int startW=0;   // 화이트로 시작

        for(int n=i; n<i+8; n++){
            for(int m=j; m<j+8; m++) {

                // w로 시작할 경우 짝수번째 - W, 홀수번째 - B 이어야함
                if ((m + n) % 2 == 0) {
                    if (board[n][m] != 'W') {
                        startW++;
                    }
                } else {
                    if (board[n][m] != 'B') {
                        startW++;
                    }
                }
            }
        }
        return Math.min(startW, 64-startW);
    }
}