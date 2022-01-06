// 1. 주어진 배열에서 각 숫자별 중복 횟수 계산 
// 2-1. 중복되는 숫자가 없다면 배열에 -1을 담아서 반환
// 2-2. 숫자들의 중복 횟수를 배열에 담아 반환

// 방법) 
// HashMap & ArrayList 사용
// -> HashMap을 사용해 순차적으로 Value 값(중복 횟수) 업데이트
// -> HashMap은 순서를 보장하지 않으므로 중복 횟수를 배열 순서대로 저장하기 위한 리스트가 필요함 

import java.util.HashMap;
import java.util.Arrays;

import java.util.*;

public class numberOfDuplication {
	public static int[] solution(int[] arr) { // 주어진 배열에서 각 숫자별 중복 횟수를 계산하여 배열로 반환하는 함수
		
		HashMap<Integer, Integer> map = new HashMap<>(); // 타입 파라미터 생략 가능
		ArrayList<Integer> order = new ArrayList<>();
		
		// HashMap을 사용해 숫자 중복 횟수 카운트
		for(int i = 0; i < arr.length; i++) {
			int key = arr[i];
			if(map.get(key) == null) {	// 해당 키가 존재하지 않을 때 
				map.put(key, 1);
				order.add(key); // HashMap은 순서를 보장하지 않으므로 주어진 순서를 저장하기 위한 리스트가 필요함
			}
			else {	// 해당 키가 존재할 때 
				map.replace(key, map.get(key)+1);	// 중복 횟수 업데이트 
			}
		}
		
		// 중복 횟수 배열 반환 
		ArrayList<Integer> result = new ArrayList<>();

		Iterator<Integer> iterator = order.iterator();
		while(iterator.hasNext()) {
			int value = map.get(iterator.next());
			if(value > 1) result.add(value);
		}
	
		return result.stream().mapToInt(i->i).toArray();  // stream을 사용해 ArrayList -> int[]
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,3,3,4,4};
		
		int[] result = solution(arr);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	}

	
}