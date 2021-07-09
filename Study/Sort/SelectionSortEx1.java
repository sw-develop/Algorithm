public class Main {
	public static void main(String[] args) {
		int[] arr = {5,6,3,4,1,2,7,8,9,0};
		
		for(int i = 0; i < arr.length; i++) {
			int minValIndex = i; //가장 작은 원소의 인덱스 
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[minValIndex])
					minValIndex = j; 
			}
			
			//swap
			int temp = arr[i];
			arr[i] = arr[minValIndex];
			arr[minValIndex] = temp;
		}
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}