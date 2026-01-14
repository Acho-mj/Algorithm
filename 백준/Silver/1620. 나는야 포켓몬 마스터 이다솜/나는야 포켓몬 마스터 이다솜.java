import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 도감에 수록되어있는 수
        int m = Integer.parseInt(st.nextToken());   // 맞춰야하는 문제 수

        // <이름, 도감번호>
        HashMap<String, Integer> pokemon = new HashMap<>();
        String[] pokemonName = new String[n+1];
        for(int i=1; i<=n; i++){
            String str = br.readLine();
            pokemon.put(str, i);
            pokemonName[i] = str;
        }

        StringBuilder sb = new StringBuilder();
        // 문제가 알파벳 -> 번호, 숫자 -> 문자
        for(int i=0; i<m; i++){
            // 입력값이 숫자, 문자로 나눠서 처리해야됨
            String line = br.readLine();
            if(Character.isLetter(line.charAt(0))){
                String name = line;
                // 입력이 문자열일 경우 - 번호(value) 반환
                sb.append(pokemon.get(name));
            }else{
                int num = Integer.parseInt(line);
                // 입력이 숫자일 경우 - 이름(key) 반환
                sb.append(pokemonName[num]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}