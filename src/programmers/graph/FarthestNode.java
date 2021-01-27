package programmers.graph;

import java.util.LinkedList;
import java.util.Queue;
/**
 *  문제 풀이
 *      https://velog.io/@ming/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B0%80%EC%9E%A5-%EB%A8%BC-%EB%85%B8%EB%93%9CLevel-3
 * */
public class FarthestNode {
    public static void main(String args[]){
        System.out.println(solution(6, new int[][]{{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}}));
    }

    // 인접리스트로 접근
    public static int solution(int n, int[][] edge ){
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        LinkedList<Integer>[] adj = new LinkedList[n+1];           // 인접리스트 생성

        for(int i=0;i<n+1;i++){
            adj[i] = new LinkedList<Integer>();
        }

        // 간선을 인접리스트로 표현
        for(int i=0;i<edge.length;i++){
            int start = edge[i][0]-1;       // 0번째 인덱스부터 맞춰주기 위한 작업
            int end = edge[i][1]-1;

            adj[start].add(end);
            adj[end].add(start);
        }

        Queue<Integer> q= new LinkedList<>();
        q.add(0);                           // 1번노드가 곧 0번째 인덱스 (1 depth)
        visited[0]=true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int v = q.poll();
                // 연결된 간선을 모두 q에 담기 (2 depth)
                // v == 0, adj[v] = {1,2} 가 담겨 있다. (2 depth)
                for(int j=0;j<adj[v].size();j++){
                    int node = adj[v].get(j);
                    if(!visited[node]){
                        visited[node]=true;
                        q.add(node);
                    }
                }
            }
            // 모든 방문이 끝난경우가 최종 depth라고 판단.
            answer = size;
        }
        return answer;
    }

}
