import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        // 배열 a 입력받기
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 배열 b 입력받기
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            index[i] = i; // B의 원래 인덱스 저장
        }

        // a 오름차순 정렬
        Arrays.sort(a);

        // b의 값을 기준으로 인덱스 정렬(b 값 내림차순)
        Arrays.sort(index, (i, j) -> b[j] - b[i]);  

        // a의 최솟값과 b의 최댓값 매칭
        int[] newA = new int[n];
        for (int i = 0; i < n; i++) {
            newA[index[i]] = a[i]; 
        }

        // 결과 계산
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += newA[i] * b[i];
        }

        System.out.println(result);
    }
}