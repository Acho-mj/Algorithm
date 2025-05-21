import java.util.*;
class Solution {
    public boolean[] visited;
    public int[] answer;
    public int solution(String begin, String target, String[] words) {
        // targer 단어가 words에 없으면 0 반환
        boolean containWord = false;
        
        for(String str : words){
            if(target.equals(str)){
                containWord = true;
            }
        }
        if(containWord==false)
            return 0;
        
        visited=new boolean[words.length];
        return bfs(begin, target, words);
    }
    
    // 현재 단어와 하나의 알파벳만 차이나는지 확인
    private boolean oneAlphabet(String a, String b) {
        int cnt=0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i))
                cnt++;
            if(cnt>1)
                return false;
        }        
        return true;
    }
    
    // bfs
    private int bfs(String begin, String target, String[] words){
        Queue<String> wordQ = new LinkedList<>();
        Queue<Integer> depthQ = new LinkedList<>();
        wordQ.offer(begin);
        depthQ.offer(0);
        
        while(!wordQ.isEmpty()){
            String currentWord = wordQ.poll();
            int currentDepth = depthQ.poll();
            
            // target 찾으면 끝
            if(currentWord.equals(target)){
                return currentDepth;
            }
            
            // 방문 처리 및 문자열의 문자 비교
            for(int i =0; i<words.length; i++){
                if(!visited[i] && oneAlphabet(currentWord, words[i])){
                    visited[i]=true;
                    wordQ.offer(words[i]);
                    depthQ.offer(currentDepth+1);
                }
            }
        }
        return 0;
    }
}