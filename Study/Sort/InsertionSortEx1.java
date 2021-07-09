public class Main {
	public static void main(String[] args) {
		int[] arr = {3,5,2,1,6,7,4,8,9,0};
		
		for(int i = 1; i < arr.length; i++) { //배열의 2번째 원소부터 
			for(int j = i; j > 0; j--) { //j : 정렬되어지고 있는 해당 원소의 위치 
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				else break; //자기보다 작은 데이터를 만나면 해당 위치에서 멈춤 
			}
			
		}
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}