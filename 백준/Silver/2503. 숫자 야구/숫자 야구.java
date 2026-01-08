import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] q = new int[n]; // 질문
        int[] s = new int[n]; // 스트라이크
        int[] b = new int[n]; // 볼
        for(int i=0 ; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 세자리수, 스트라이크 개수, 볼 개수
            q[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 세자리 고정
        // 123 ~ 987에서 조건에 안 맞는 숫자 필터링
        int answer=0;
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                for(int k=1; k<=9; k++){
                    if(i==j || j==k || i==k) continue;
                    boolean pass = true; // 일단 true로 두고 조건 필터링

                    for(int a=0; a<n; a++){
                        int strike = 0;
                        int ball = 0;

                        int[] cand = {i, j, k};
                        int[] ques = {
                                q[a]/100, // 백의자리
                                (q[a]/10)%10, // 십의자리
                                q[a]%10 // 일의자리
                        };
                        for(int x=0; x<3; x++){
                            // 동일한 위치와 숫자
                            if(cand[x] == ques[x]){
                                strike++;
                            }else{
                                // 위치가 다르지만 숫자는 같음
                                for(int y=0; y<3; y++){
                                    if(x!=y && cand[y] == ques[x]){
                                        ball++;
                                        break;
                                    }
                                }
                            }
                        }
                        // 스트라이크 수와 볼 수가 같지 않다면
                        if(strike != s[a] || ball != b[a]){
                            pass = false;
                            break;
                        }
                    }
                    if(pass) answer++;
                }
            }
        }
        System.out.print(answer);
    }
}