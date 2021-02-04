package concept.graph;
/**
 *      알고리즘 설명
 *          https://velog.io/@ming/Union-Find-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * */
public class UnionFind {

    public static int[] parent;     // 부모노드

    public static void main(String args[]){
        int[] arr = new int[4];
        parent = new int[4];

        // 4개의 노드, 부모노드 초기화
        for(int i=0;i<4;i++){
            arr[i] = parent[i] = i;
        }

        union(1,2);
        System.out.println("2의 부모 :" +find(2)+" / 3의 부모 :" +find(3));
        union(2,3);
        System.out.println("3의 부모 :" +find(2));
        System.out.println("1와3은 연결되어 있나 :" +isConnect(1,3));
        System.out.println("0와3은 연결되어 있나 :" +isConnect(0,3));
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
            // n2 > n1
            // 부모가 다르다면 n2의 부모를 n1으로 설정
            if(n2 > n1){
                parent[n2] = n1;
            }else{
                parent[n1] = n2;
            }
        }
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
