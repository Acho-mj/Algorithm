import java.util.*;
import java.io.*;

public class Main {
    static class Member {
        int age;
        String name;
        int order;

        Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Member> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            String[] str = br.readLine().split(" ");
            list.add(new Member(Integer.parseInt(str[0]), str[1], i));  // 나이, 이름, 순서
        }

        Collections.sort(list, (a,b)->{
            if(a.age==b.age) return a.order-b.order;
            return a.age-b.age;
        });

        StringBuilder sb = new StringBuilder();
        for(Member m : list){
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.print(sb);
    }
}