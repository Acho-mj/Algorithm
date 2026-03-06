import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> st = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for(char c : s.toCharArray()){
            if(c == '.'){
                if(!stackCheck()) return;
                sb.append(".");
            }else{
                st.add(c);
            }
        }

        // 스택에 남아있는 X 처리
        if(!stackCheck()) return;

        System.out.print(sb);
    }

    private static boolean stackCheck(){
        int size = st.size();
        if (size == 0) return true;

        // X의 개수가 2로 나누어 지지 않을 때
        if(size % 2 !=0){
            System.out.print(-1);
            return false;
        }else{
            // 나누어 떨어진다면 값 치환
            while(size>0){
                if(size >= 4){
                    sb.append("AAAA");
                    size -= 4;
                }else{
                    sb.append("BB");
                    size -= 2;
                }
            }
        }
        st.clear();

        return true;
    }
}