import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        int n = record.length;
        HashMap<String, String> hash = new HashMap<>();
        
        for(String str : record){
            String[] user = str.split(" ");
            String word = user[0];
            String id = user[1];
            
            // Leave 가 아닐 때만
            if(!word.equals("Leave")){
                String nickname = user[2];
                hash.put(id, nickname);
            }
        }
        
        for(int i=0; i<n; i++){
            String str = record[i];
            String[] user = str.split(" ");
            String word = user[0];
            String id = user[1];
            
            if(word.equals("Enter")){
                answer.add(hash.get(id)+"님이 들어왔습니다.");
            }else if(word.equals("Leave")){
                answer.add(hash.get(id)+"님이 나갔습니다.");
            }
        }
        return answer.stream().toArray(String[]::new);
    }
}