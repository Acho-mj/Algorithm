import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 보석 갯수
        int k = Integer.parseInt(st.nextToken()); // 가방 갯수

        // 보석 정보 (m, v)
        ArrayList<int[]> jew = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 무게
            int v = Integer.parseInt(st.nextToken()); // 가격
            jew.add(new int[]{m, v});
        }
        Collections.sort(jew, (a,b) -> a[0]-b[0]);     // 무게 작은 것 부터

        // 가방 무게 정보 (c)
        int[] bag = new int[k];
        for(int i=0; i<k; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);   // 무게 작은 것부터

        // 무게 조건에 맞는 것 중 가격 큰 거 찾기
        long total = 0;
        int idx = 0;
        PriorityQueue<Integer> maxPrice = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<k; i++){
            while(idx<n && bag[i]>=jew.get(idx)[0]) {
                maxPrice.add(jew.get(idx)[1]);
                idx++;
            }
            if(!maxPrice.isEmpty()){
                total += maxPrice.poll();
            }
        }

        // 출력: 훔칠 수 있는 보석 가격의 합 (MAX)
        System.out.print(total);
    }
}