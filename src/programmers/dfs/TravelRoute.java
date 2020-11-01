package programmers.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 문제 설명
		주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다.
		
		항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		
	제한사항
		모든 공항은 알파벳 대문자 3글자로 이루어집니다.
		주어진 공항 수는 3개 이상 10,000개 이하입니다.
		tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
		주어진 항공권은 모두 사용해야 합니다.
		만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
		모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
	
	입출력 예
		tickets	                                                                        return
		[[ICN, JFK], [HND, IAD], [JFK, HND]]	                                  [ICN, JFK, HND, IAD]
		[[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]]	           [ICN, ATL, ICN, SFO, ATL, SFO]

	입출력 예 설명
		예제 #1
		
		[ICN, JFK, HND, IAD] 순으로 방문할 수 있습니다.
		
		예제 #2
		
		[ICN, SFO, ATL, ICN, ATL, SFO] 순으로 방문할 수도 있지만 [ICN, ATL, ICN, SFO, ATL, SFO] 가 알파벳 순으로 앞섭니다.
	
	문제풀이 참고
		https://dailyheumsi.tistory.com/22
		
		DFS 이용
 * 
 * */

public class TravelRoute {
	static List<String> list = new ArrayList<>();
	static String route = "" ;
	static boolean[] visited;
	
	public static void main(String arg[]) {
		
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//		String[][] tickets = {{"ICN","JFK"}, {"HND","IAD"}, {"JFK","HND"}};
		String[] arr = solution(tickets);
		for(int i=0;i<arr.length;i++) {
			
			System.out.println(arr[i]);
		}
		
	}
	
	public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
		
		for(int i = 0 ; i < tickets.length; i++) {
			
			String departure = tickets[i][0];
			String destination = tickets[i][1];
			
			if(departure.equals("ICN")) {
				visited[i] = true;
				route = departure + ",";
				dfs(tickets, destination, 1);
				visited[i] = false;
			}
		}
		
		Collections.sort(list);
		String[] answer = list.get(0).split(",");
		return answer;
	}
	
	public static void dfs(String[][] tickets, String end, int count) {
		
		route += end + ",";
		
		if(count==tickets.length) {				// 모든 여행지를 다 탐색한 경우
			list.add(route);
//            System.out.print(route);
			return;
		}
		
		for(int i = 0 ; i < tickets.length ; i++) {
			String depart = tickets[i][0];		// 출발
			String desti = tickets[i][1];		// 도착
			
			if(end.equals(depart) && !visited[i]) {
				visited[i] = true;
				dfs(tickets, desti, count+1);
				visited[i] = false;
				route = route.substring(0, route.length()-4);
			}
		}
	}
}
