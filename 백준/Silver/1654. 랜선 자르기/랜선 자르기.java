import java.util.*;
public class Main {
	// 가지고 있는 랜선의 길이 배열 
	public static int[] arr;
	// 필요한 랜선 개수 N
	public static int n;
		
	public static long binarySearch(long start, long end){
		long answer = 0;
		while(start <= end){
			long mid = (start+end)/2;
			int count = 0;
					
			// 필요한 랜선 갯수 구하기
			for(int i=0; i<arr.length; i++){
				count += arr[i]/mid;
			}
						
			// 필요한 갯수 이상이라면 -> 길이가 길어져야함
			if(count >= n){
				// 랜선 길이 최대 반영
				answer = mid;
				start=mid+1;
						
			// 필요한 갯수에 미치지 못한다면 -> 길이 줄여야함
			}else{
				end=mid-1;
			}
		}
		return answer;
	}
    public static void main(String[] args) {  
		Scanner sc = new Scanner(System.in);
		    
		// 가지고 있는 랜선 개수 K
        int k = sc.nextInt();
        // 필요한 랜선 개수 N
        n = sc.nextInt();
        
        long max = 0;
        arr = new int[k];
        for(int i=0; i<arr.length; i++){
			arr[i]=sc.nextInt();
		    max = Math.max(max, arr[i]);
        }
        System.out.print(binarySearch(1, max));  
    }  
}
