class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        // 시간 문자열을 분과 초로 분리 후 초 단위로 변환
        String[] len = video_len.split(":");
        String[] strPos = pos.split(":");
        String[] start = op_start.split(":");
        String[] end = op_end.split(":");
        
        // m분 s초 -> time = 60 * m + s 로 통합해서 구한 후 time/60의 몫=m, 나머지=s
        int myLen = Integer.parseInt(len[0]) * 60 + Integer.parseInt(len[1]);
        int myPos = Integer.parseInt(strPos[0]) * 60 + Integer.parseInt(strPos[1]);
        int myStart = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int myEnd = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        
        
        // prev : 10초 전으로 이동, 10초 미만일 경우 0분 0초
        // next : 10초 후로 이동, 남은 시간이 10초 미만일 경우 마지막으로
        // op_start ≤ 현재 재생 위치 ≤ op_end : 자동으로 오프닝 끝나는 위치
        for(int i=0; i<commands.length; i++){
            // 오프닝 구간 처리
            if (myStart <= myPos && myPos <= myEnd) {
                myPos = myEnd;
            }
            
            // next
            if(commands[i].equals("next")){
                if(myLen - myPos < 10){
                    myPos = myLen;
                }else{
                    myPos = myPos + 10;
                }
                if (myStart <= myPos && myPos <= myEnd) {
                    myPos = myEnd;
                }
            // prev
            }else{
                if(myPos < 10){
                    myPos = 0;
                }else{
                    myPos = myPos - 10;
                }
                if (myStart <= myPos && myPos <= myEnd) {
                    myPos = myEnd;
                }   
            }
        }
        
        // 초 단위로 구한 myPos를 몫과 나머지를 통해 분, 초 구하기
        int minutes = myPos / 60;
        int seconds = myPos % 60;
        // "mm:ss" 형태
        return String.format("%02d:%02d", minutes, seconds);
    }
}