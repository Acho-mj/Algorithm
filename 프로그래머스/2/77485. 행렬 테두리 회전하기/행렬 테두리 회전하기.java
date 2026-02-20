import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int cnt=1;
        int[][] box = new int[rows+1][columns+1];
        
        // 행렬 만들기
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                box[i][j] = cnt;
                cnt++;
            }
        }
        
        // 테두리 회전 + 최솟값 찾기
        // X1, X2 -> Y1, Y2
        int[] answer = new int [queries.length];
        int idx = 0;
        for(int[] q : queries){
            int x1 = q[0];
            int y1 = q[1];
            int x2 = q[2];
            int y2 = q[3];
            
            int temp = box[x1][y1];
            int min = temp;
                
            // |왼쪽 
            for(int i=x1;  i<x2; i++){
                box[i][y1] = box[i+1][y1];   
                min = Math.min(min, box[i][y1]);
            }
            
             // _아래
            for(int i=y1;  i<y2; i++){
                box[x2][i] = box[x2][i+1];
                min = Math.min(min, box[x2][i]);
            }
            
            // 오른쪽| 
            for(int i=x2;  i>x1; i--){
                box[i][y2] = box[i-1][y2];   
                min = Math.min(min, box[i][y2]);
            }
            
            // _위
            for(int i=y2; i>y1; i--){
                box[x1][i] = box[x1][i-1];
                min = Math.min(min, box[x1][i]);
            }
            box[x1][y1+1] = temp;
            answer[idx++] = min;
        }
        
        return answer;
    }
}