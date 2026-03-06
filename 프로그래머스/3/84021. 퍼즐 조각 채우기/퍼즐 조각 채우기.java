import java.util.*;

class Solution {
    // 각 조각의 그룹 (하나의 조각 - 여러 개의 좌표 쌍)
    static ArrayList<List<int[]>> groupTable = new ArrayList<>();
    static ArrayList<List<int[]>> groupGame = new ArrayList<>();
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        groupTable.clear();
        groupGame.clear();
        
        int row = game_board.length;
        int col = game_board[0].length;
        
        visited = new boolean[row][col];
        // 게임 보드의 좌표
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!visited[i][j] && game_board[i][j] == 0){
                    ArrayList<int[]> list = new ArrayList<>();
                    dfs(i, j, game_board, 0, list);
                    groupGame.add(normal(list));
                }
            }
        }
        
        visited = new boolean[row][col];
        // 테이블의 좌표
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!visited[i][j] && table[i][j] == 1){
                    ArrayList<int[]> list = new ArrayList<>();
                    dfs(i, j, table, 1, list);
                    groupTable.add(normal(list));
                }
            }
        }
        
        boolean[] usedTable = new boolean[groupTable.size()];
        boolean[] usedGame = new boolean[groupGame.size()];
        
        // 회전, 정규화, dfs 덩어리 찾기 
        // groupTable에서 하나 꺼내서 game_board랑 비교 (1. 좌표, 2. 회전)
        for(int t = 0; t < groupTable.size(); t++){
            if(usedTable[t]) continue;
            List<int[]> gt = groupTable.get(t);
            
            for(int i=0; i<groupGame.size(); i++){
                if(usedGame[i]) continue;
                List<int[]> gg = groupGame.get(i);
                
                if(gt.size() != gg.size()) continue;
                
                // 크기가 같을 경우 좌표값들 비교하고 회전
                List<int[]> rotateList = new ArrayList<>(gt);     // 회전한 것들 저장
                for(int r=0; r<4; r++){
                    if(r > 0) rotateList = rotate(rotateList);
                    List<int[]> normRotated = normal(rotateList);
                    
                    boolean matched = true;
                    for(int j=0; j<normRotated.size(); j++){
                        // 좌표 비교하기
                        if(normRotated.get(j)[0] != gg.get(j)[0] || normRotated.get(j)[1] != gg.get(j)[1]){
                            matched = false;
                            break;
                        }
                    }
                    // 매칭되면 답 추가 + GameBoard의 공간 삭제
                    if(matched){
                        answer += gt.size();
                        usedTable[t] = true;
                        usedGame[i] = true;
                        break;
                    }   
                }
                if(usedTable[t]) break;
            }
        }   
        
        return answer;
    }
    
    // 그룹 리스트
    static void dfs(int x, int y, int[][] board, int target, List<int[]> list){
        visited[x][y] = true;
        list.add(new int[]{x,y});
        
        for(int i=0; i<4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];
            
            // 범위 아웃
            if(curX < 0 || curY < 0 || curX >= board.length || curY >= board[0].length) continue;
            
            // 하나의 덩어리에서의 좌표
            if(!visited[curX][curY] && board[curX][curY] == target){
                dfs(curX, curY, board, target, list);
            }
        }
    }
    
    // 회전처리
    static List<int[]> rotate(List<int[]> arr){
        ArrayList<int[]> rotArr = new ArrayList<>();
        for(int[] cur : arr){
            int x = cur[0];
            int y = cur[1];
            
            rotArr.add(new int[]{y, -x});
        }
        return rotArr;
    }
    
    // (0,0) 좌표 정규화
    static List<int[]> normal(List<int[]> arr){
        // 최소 x, y 만큼 좌표 이동
        int minX = 51;
        int minY = 51;
        for(int[] cur : arr){
            minX = Math.min(minX, cur[0]);
            minY = Math.min(minY, cur[1]);
        }
        
        ArrayList<int[]> normalArr = new ArrayList<>();
        
        for(int[] cur : arr){
            int x = cur[0];
            int y = cur[1];
            
            normalArr.add(new int[]{x-minX, y-minY});
        }
        
        // 오름차순
        normalArr.sort((a,b) -> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        
        return normalArr;
    }
}