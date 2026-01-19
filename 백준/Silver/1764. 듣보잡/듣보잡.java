import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 듣도 못한 사람 수
        int m = Integer.parseInt(st.nextToken());   // 보도 못한 사람 수

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }

        ArrayList<String> name = new ArrayList<>();
        for(int i=0; i<m; i++){
            String str = br.readLine();
            if(set.contains(str)){
                name.add(str);
            }
        }
        Collections.sort(name);
        StringBuilder sb = new StringBuilder();
        sb.append(name.size()).append("\n");
        for(String s : name){
            sb.append(s).append("\n");
        }
        
        System.out.print(sb);
    }
}