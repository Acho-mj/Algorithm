import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] tmp;
    static int count=0;
    static int k;
    static int answer=-1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());   // 저장횟수

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        // 정렬 호출
        tmp = new int[n];
        merge_sort(arr, 0, n-1);

        // k번째 저장되는 수 출력 (저장횟수가 k보다 작으면 -1)
        System.out.print(answer);
    }

    public static void merge_sort(int[] arr, int p, int r){
        if(p < r){
            int q = (p+r)/2;
            merge_sort(arr, p, q);
            merge_sort(arr, q+1, r);

            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] sort, int p, int q, int r){
        int i = p;
        int j = q+1;
        int t = p;
        while(i<=q && j<=r){
            if(sort[i] <= sort[j]){
                tmp[t++] = sort[i++];
            }else{
                tmp[t++] = sort[j++];
            }
        }

        while(i <= q) tmp[t++] = sort[i++];
        while(j <= r) tmp[t++] = sort[j++];

        for(int idx=p; idx<=r; idx++){
            count++;
            sort[idx] = tmp[idx];
            if (count == k) {
                answer = sort[idx];
                return;
            }
        }
    }
}