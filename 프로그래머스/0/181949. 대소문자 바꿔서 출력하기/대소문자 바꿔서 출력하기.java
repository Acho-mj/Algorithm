import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] str = a.toCharArray();
        
        for(int i=0; i<str.length; i++){
            if(('a'<= str[i]) && (str[i] <= 'z'))
                str[i] = Character.toUpperCase(str[i]); 
            else
                str[i] = Character.toLowerCase(str[i]);    
        }
        System.out.println(new String(str));
    }
}