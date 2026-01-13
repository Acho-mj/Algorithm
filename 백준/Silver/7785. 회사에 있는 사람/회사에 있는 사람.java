import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 현재 회사에 있는 사람
        // Map key: 이름, enter 일 경우 +1, leave 일 경우 -1 => 최종적으로 1인 사람만 반환하기
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String log = st.nextToken();

            if(log.equals("enter")){
                hash.put(name, hash.getOrDefault(name, 0)+1);
            }else{
                hash.put(name, hash.get(name)-1);
            }
        }

        ArrayList<String> arr = new ArrayList<>();
        for(String key : hash.keySet()){
            if(hash.get(key) == 1)
                arr.add(key);
        }
        Collections.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String name : arr){
            sb.append(name).append('\n');
        }

        System.out.print(sb);
    }
}