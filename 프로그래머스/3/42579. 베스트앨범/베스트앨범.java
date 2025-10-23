import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // 필요한 것
        // 장르 순위 -> HashMap : genre, Integer
        HashMap<String, Integer> topG = new HashMap<>();
        // 고유 번호별 플레이 횟수(순위) -> HashMap : genre, List<int[]> [0]:고유번호, [1]:플레이횟수
        HashMap<String, List<int[]>> playId = new HashMap<>();
        
        // 초기 세팅
        for(int i=0; i<genres.length; i++){
            // 노래 개수가 많은 장르
            topG.put(genres[i], topG.getOrDefault(genres[i], 0) + plays[i]);
            // 장르+고유번호별 플레이 횟수
            playId.computeIfAbsent(genres[i], x -> new ArrayList<>())
                .add(new int[]{i, plays[i]});
        }
        
        // 정렬
        // 노래 개수가 많은 장르 
        // 장르 내림차순(큰 것 먼저)
        List<String> sortedGenres = new ArrayList<>(topG.keySet());
        sortedGenres.sort((a,b) -> topG.get(b) - topG.get(a));
 
        for(String genre : sortedGenres){
            // 정렬된 장르 중 많이 재생된(내림차순), 고유번호가 낮은(오름차순)
            // => 재생횟수가 같으면 고유번호가 낮은거, 같지 않으면 많이 재생된거
            List<int[]> list = playId.get(genre);
            list.sort((a,b)-> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);
            
            // 정렬된 장르에 따라 최대 2개씩 수록 (1개면 1개만)
            for(int i=0; i<Math.min(2, list.size()); i++){
                answer.add(list.get(i)[0]);
            }
        }        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}