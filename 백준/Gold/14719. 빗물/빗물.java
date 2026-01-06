import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] block = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++){
            block[i]=Integer.parseInt(st.nextToken());
        }

//        // i 번째를 기준으로 오른쪽의 최댓값, 왼쪽의 최댓값 중 작은 값 - 나의 높이
//        int[] leftMax = new int[w];
//        leftMax[0]=block[0];
//        for(int i=1; i<w; i++){
//            leftMax[i] = Math.max(leftMax[i-1], block[i]);
//        }
//
//        int[] rightMax = new int[w];
//        rightMax[w-1]=block[w-1];
//        for(int i=w-2; i>=0; i--){
//            rightMax[i] = Math.max(rightMax[i+1], block[i]);
//        }
//
//        // 가장자리 제외
//        int result=0;
//        for(int k=1; k<w-1; k++){
//            result += Math.min(leftMax[k], rightMax[k]) - block[k];
//        }
//        System.out.print(result);

        int result = 0;
        // 스택에는 본인보다 큰 벽을 만나지 못한 벽의 후보 저장
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<w; i++){
            // 큰 벽을 만났을 때
            while(!stack.isEmpty() && block[i]>block[stack.peek()]){
                int current = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int width = i - left - 1;

                result += width * (Math.min(block[left],block[i]) - block[current]);
            }
            stack.push(i);
        }
        System.out.print(result);
    }
}