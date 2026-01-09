import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 큐에 입력
        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.add(Integer.parseInt(st.nextToken()));
        }

        // 순서 확인용 변수
        int ord = 1;

        Stack<Integer> s = new Stack<>();
        // 현재 순서와 번호가 일치하지 않으면 스택에 넣기
        while(!q.isEmpty()){
            int cur = q.poll();
            // 스택에 있는 값 == ord의 경우
            while(!s.isEmpty()){
                if(s.peek() == ord){
                    s.pop();
                    ord++;
                }else{
                    break;
                }
            }
            if(cur == ord){
                ord++;
            }else{
                s.add(cur);
            }
        }
        boolean isVaild = true;
        while(!s.isEmpty()){
            if(s.pop() != ord) {
                isVaild = false;
                break;
            }else{
                ord++;
            }
        }
        System.out.print(isVaild?"Nice":"Sad");
    }
}