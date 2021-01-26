package programmers.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex4_2 {

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
