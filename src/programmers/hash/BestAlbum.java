package programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 문제 설명
		스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
		
		속한 노래가 많이 재생된 장르를 먼저 수록합니다.
		장르 내에서 많이 재생된 노래를 먼저 수록합니다.
		장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
              
              노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
     
     제한사항
		genres[i]는 고유번호가 i인 노래의 장르입니다.
		plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
		genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
		장르 종류는 100개 미만입니다.
		장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
		모든 장르는 재생된 횟수가 다릅니다.
	
	입출력 예
		genres	plays	return
		[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
	
	입출력 예 설명
		classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
		
		고유 번호 3: 800회 재생
		고유 번호 0: 500회 재생
		고유 번호 2: 150회 재생
		pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
		
		고유 번호 4: 2,500회 재생
		고유 번호 1: 600회 재생
		따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 * 
 * */
public class BestAlbum {

	static public void main(String agrs[]) {
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		Map<String, Object> genresMap = new HashMap<>();	// 장르 정보 ( 장르, 곡정보(infoMap)	
		Map<String, Integer> playMap = new HashMap<>();		// 재생 정보 ( 장르, 총 장르 재생수)
		ArrayList<Integer> resultList = new ArrayList<>();
		
		for(int i=0; i< genres.length; i++) {
			String key = genres[i];
			
			// 곡 정보 (고유번호, 재생횟수)
			HashMap<Integer, Integer> infoMap = null;
			
			if(genresMap.containsKey(key)) {				
				// genresMap에 이미 존재하는 장르값이라면 , genresMap 값을 가져옴
				// i ==2 인경우 , {0=500} 값을 가져옴
				infoMap = (HashMap<Integer,Integer>)genresMap.get(key);
			}else {
				infoMap = new HashMap<Integer,Integer>();	// genresMap에 존재하지 않는 새 장르
			}
		
//System.out.println("	infoMap : "+i +" : "+infoMap);
			infoMap.put(i, plays[i]);
			genresMap.put(key, infoMap);
//System.out.println("	genresMap : "+i +" : "+genresMap);
			
			
			if(playMap.containsKey(key)) {					// playMap에 이미 존재하는 장르값이면 , 이전 재생횟수와 더해줌
				playMap.put(key, playMap.get(key) + plays[i]);	
			}else {											// playMap에 없는 새로운 장르인 경우
				playMap.put(key, plays[i]);
			}
			
//System.out.println("	playMap : "+i +" : "+playMap);		
		}
		
		// 재생순으로 정렬
		Iterator it = sortByValue(playMap).iterator();
		while(it.hasNext()) {
			String genre = (String)it.next();
			// genresMap의 value(재생수)대로 정렬(1. pop 2. classic )
			Iterator idxIt = sortByValue((HashMap<String, Object>)genresMap.get(genre)).iterator();
			
			int playCnt = 0;
			
			while(idxIt.hasNext()) {
				int result = (int)idxIt.next();
				resultList.add(result);				// 고유번호 resultList에 담기
				playCnt++;
				if(playCnt > 1)	break;				// 같은 장르 , 최대 2곡까지
				
			}
		}
		
		int[] answer = new int[resultList.size()];
		
		for(int i=0; i<resultList.size(); i++) {
			answer[i] = resultList.get(i).intValue();
			System.out.print(answer[i] +" ");
		}
		
	}
	
	// map의 value값으로 내림차순
	static private ArrayList sortByValue(final Map map){
        ArrayList<Object> keyList = new ArrayList();
        keyList.addAll(map.keySet());

        Collections.sort(keyList, new Comparator(){
            public int compare(Object o1, Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });
        
        return keyList;
    }
}









