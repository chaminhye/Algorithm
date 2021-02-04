package concept.graph;

import java.util.*;

/**
*      알고리즘 설명
*          https://velog.io/@ming/MST%EC%B5%9C%EC%86%8C-%EC%8B%A0%EC%9E%A5%ED%8A%B8%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * */
public class Prim {

    public static ArrayList<Node> list = new ArrayList<Node>();
    public static ArrayList<Node>[] nodeList;                   // 연결리스트
    public static ArrayList<Node> mst = new ArrayList<>();      // mst
    public static int costs = 0;
    public static boolean[] visited;

    public static void main(String args[]){
        // 그래프 설정 ( 정점, 간선 , 비용)
        list.add(new Node(1, 2, 5));
        list.add(new Node(2, 3, 1));
        list.add(new Node(3, 6, 9));
        list.add(new Node(1, 4, 3));
        list.add(new Node(1, 3, 8));
        list.add(new Node(1, 5, 10));
        list.add(new Node(4, 5, 4));
        list.add(new Node(5, 6, 12));
        list.add(new Node(4, 6, 2));
        list.add(new Node(3, 4, 4));

        visited = new boolean[6+1];          // 1로 인덱스 맞추기 위함
        Arrays.fill(visited, false);         // 방문여부 초기화

        nodeList = new ArrayList[6+1];
        for(int i=1;i<7;i++){     // 연결리스트 초기화
            nodeList[i] = new ArrayList<Node>();
        }

        // 연결리스트에 간선과 비용 설정
        for(int i=0;i<list.size();i++){
            int start = list.get(i).start;
            int end = list.get(i).end;
            int cost = list.get(i).cost;
            nodeList[start].add(new Node(start, end, cost));
            nodeList[end].add(new Node(end, start, cost));
        }

        mst_prim(1);        // 시작 정점 1
        System.out.println("costs : "+costs);
    }

    public static void mst_prim(int p){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();     // 비용을 오름차순으로 정렬하는 Queue
        Queue<Integer> q = new LinkedList<>();

        // 시작노드
        q.offer(p);

        while(!q.isEmpty()){
            int node = q.poll();
            visited[node] = true;

            // node에 연결된 정점들에 대한 정보 중에서
            // 방문하지 않은 Node를 pq에 담는다.
            for(Node n : nodeList[node]){
                // 종료노드 
                if(!visited[n.end]){
                    System.out.println("pq :: start : "+n.start+" end : "+n.end +" cost : "+ n.cost);
                    pq.add(n);
                }
            }

            // pq에 담긴 정보들을 순차적으로 mst에 담는다.
            while(!pq.isEmpty()){
                Node e = pq.poll();

                if(!visited[e.end]){
                    q.add(e.end);
                    visited[e.end] = true;
                    costs += e.cost;
                    System.out.println("    q :: start : "+e.start+" end : "+e.end +" cost : "+ e.cost);
                    System.out.println("costs  : "+costs);
                    mst.add(e);
                    break;
                }
            }
            System.out.println("------------------------------------------");
        }
    }
}

class Node implements Comparable<Node>{
    int start;      // 시작 정점
    int end;        // 종료 정점
    int cost;       // 비용

    Node(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    // 비용으로 오름차순 정렬하기 위한 Comparable method
    @Override
    public int compareTo(Node node) {
        return node.cost >= this.cost ? -1 : 1;
    }
}
