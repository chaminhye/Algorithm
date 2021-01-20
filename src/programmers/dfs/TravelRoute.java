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
		DFS 이용
		https://geehye.github.io/programmers-dfs-bfs-04/#
		
	문제 풀이
		https://velog.io/@ming/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%97%AC%ED%96%89%EA%B2%BD%EB%A1%9CLevel-3	
 * 
 * */

public class TravelRoute {
	static boolean[] visited ;
	static List<String> list = new ArrayList<String>();
	static String routes = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"},{"JFK", "HND"}};
		solution(tickets);
	}
	
	public static String[] solution(String[][] tickets) {
		String[] answers = new String[tickets.length+1];
		visited = new boolean[tickets.length];
		answers = new String[tickets.length+1];
		
		for(int i=0;i<tickets.length;i++) {
			if(tickets[i][0].equals("ICN")) {
				// 방문여부를 체크해주고,
				visited[i]=true;
				routes ="ICN";
				dfs(tickets, tickets[i][1],1);
				// false로 체크하는 이유는 , 
				// ICN으로 시작하는 다른 정점을 후에 방문하기 위함이다.
				visited[i]=false;
				System.out.println("------------------------");
			}
		}
		Collections.sort(list);
//		System.out.println("list - size : "+list.size());
		answers = list.get(0).split(",");
//		for(String st : answers) {
//			System.out.print(st+" ");
//		}
		return answers;
	}
	
	public static void dfs(String[][] tickets, String departure, int count) {
		// 출발지를 경로에 추가
		routes +=","+departure;
		if(count == tickets.length) {
			list.add(routes);
			return;
		}
		for(int i=0; i<tickets.length; i++) {
			if(tickets[i][0].equals(departure)  && !visited[i]) {
				visited[i]=true;
				dfs(tickets, tickets[i][1], count+1 );
				
				// 같은 방문지가 있는 경우, 다른 방문지를 돌기위해 false로 설정
				// 그리고 routes에서도 지워주기 위해 subString(0, length-4)으로 설정 
				visited[i]=false;
				routes = routes.substring(0, routes.length()-4);
			}
		}
	}
}
