package concept.graph;

import java.util.ArrayList;
import java.util.Collections;
/**
*      알고리즘 설명
*          https://velog.io/@ming/MST%EC%B5%9C%EC%86%8C-%EC%8B%A0%EC%9E%A5%ED%8A%B8%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * */
public class Kruskal {

    public static ArrayList<Edge> list = new ArrayList<Edge>();
    public static int[] parent;

    public static void main(String args[]){
        // 그래프 설정 ( 정점, 간선 , 비용)
        list.add(new Edge(1, 2, 5));
        list.add(new Edge(2, 3, 1));
        list.add(new Edge(3, 6, 9));
        list.add(new Edge(1, 4, 3));
        list.add(new Edge(1, 3, 8));
        list.add(new Edge(1, 5, 10));
        list.add(new Edge(4, 5, 4));
        list.add(new Edge(5, 6, 12));
        list.add(new Edge(4, 6, 2));
        list.add(new Edge(3, 4, 4));

        parent = new int[6+1];          // 1로 인덱스 맞추기 위함

        // 부모노드 자기 자신으로 초기화
        for(int i=1;i<parent.length;i++){
            parent[i] = i;
        }

        Collections.sort(list);
/*
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).n1 + " "+ list.get(i).n2 +" " +list.get(i).cost);
        }
*/
        int sum = 0;
        for(int i=0;i<list.size();i++){
            Edge edge = list.get(i);
            // 사이클이 형성되어 있는지 체크
            if(!isConnect(edge.n1, edge.n2)){
                sum += edge.cost;               // 비용 +
                System.out.println("union :: "+edge.n1 + " :: "+ edge.n2);
                union(edge.n1, edge.n2);        // 간선 연결
            }
        }
        System.out.println("sum : "+sum);
    }

    // find 함수
    public static int find(int n){
        // 부모가 자기 자신인 경우
        if(parent[n] == n ){
            return n;
        }else{
            // 재귀함수를 이용하여 부모를 추적
            return parent[n] = find(parent[n]);
        }
    }

    // union 함수
    public static void union(int n1, int n2){
        // n1과 n2를 합치기 전에 부모부터 찾아야 한다.
        n1 = find(n1);
        n2 = find(n2);

        // 대게, 부모를 합칠때는 일반적으로 더 작은값쪽을 합친다.
        if(n1 != n2){
            parent[n2] = n1;
        }
        System.out.println("    n1 : " +n1 + " :: n2 : "+n2  + "    parent["+n2+"] :: " +parent[n2] );
    }

    // 같은 부모노드를 가졌는지, 결국 모두 연결되어 있는지 확인
    public static boolean isConnect(int n1, int n2){
        n1 = find(n1);
        n2 = find(n2);

        if(n1 == n2){
            return true;
        }else{
            return false;
        }
    }
}
class Edge implements Comparable<Edge>{
    int n1;         // 정점1 (무방향 그래프라 시작, 종료 정점 구분 X)
    int n2;         // 정점2
    int cost;       // 비용

    Edge(int n1, int n2, int cost){
        this.n1 = n1;
        this.n2 = n2;
        this.cost = cost;
    }

    // 비용으로 오름차순 정렬하기 위한 Comparable method
    @Override
    public int compareTo(Edge edge) {
        return edge.cost >= this.cost ? -1 : 1;
    }
}
