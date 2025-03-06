import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		double result = (double)a/b;
		System.out.printf("%.9f\n",result);
	}
}