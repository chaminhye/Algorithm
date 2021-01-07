package hackerRank.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MigratoryBirds {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(4);
		arr.add(4);
		arr.add(4);
		arr.add(5);
		arr.add(3);
//		arr.add(3);
//		arr.add(3);
		migratoryBirds(arr);
	}

	public static int migratoryBirds(List<Integer> arr) {

		// map에 담기(birds유형, birds의 수)
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0 ;i<arr.size();i++){
			if(map.containsKey(arr.get(i))){
				map.put(arr.get(i), map.get(arr.get(i))+1);
			}else{
				map.put(arr.get(i),1);
			}
		}
//		System.out.println(Collections.max(map.entrySet(), Map.Entry.comparingByValue()));
		// map의 값의 최대값으로 키값을 구하는 방법
		return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}

