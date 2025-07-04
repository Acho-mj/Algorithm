class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
         for (String st : str) {
            int num = Integer.parseInt(st);
            if (min > num) min = num;
            if (max < num) max = num;
        }

        return min + " " + max;
    }
}