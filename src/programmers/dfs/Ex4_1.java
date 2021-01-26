package programmers.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Ex4_1 {

	public static boolean[] visited;
	public static String[] ans;
	public static String route;
	public static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"},{"JFK", "HND"}};
		solution(tickets);
	}

	public static String[] solution(String[][] tickets) {
		int n = tickets.length;
		ans = new String[n+1];
		visited = new boolean[n];
		String departure = "";
	
		for(int i=0;i<n;i++) {
			if(tickets[i][0].equals("ICN")) {
				route = "ICN,"+tickets[i][1];
				dfs(tickets, tickets[i][1], 1);
				route="";
			}
		}
		System.out.println("route : "+route);
	
		TreeMap<String, String> map= new TreeMap
				<String ,String>();
		for(int i=0;i<n;i++) {
			if(!map.containsKey(tickets[i][0])) {
				map.put(tickets[i][0],tickets[i][1]);
			}else {
				map.put(tickets[i][0],map.get(tickets[i][0])+","+tickets[i][1]);
			}
		}
		System.out.println(map);
//		dfs(map, "ICN", map.get("ICN"));
		
		return ans;
	}
	
	public static void dfs(String[][] tickets, String departure, int cnt) {
		if(cnt == tickets.length) {
			list.add(route);
			route ="";
			return;
		}
		
		for(int i=0;i<tickets.length;i++) {
			if(tickets[i][0].equals(departure) && !visited[i]) {
				route += route.substring(route.length()-4, route.length());
				System.out.println(route);
				visited[i] = true;
				dfs(tickets, tickets[i][1], cnt+1);
				visited[i]=false;
			}
		}
	}
}
