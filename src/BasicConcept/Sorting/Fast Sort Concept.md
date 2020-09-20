# 분할 정복법 "Divide and Conquer"

- merge sort와 quick sort는 분할 정복 알고리즘을 사용한다.
- 기본적으로 ***resursion***을 사용하여 문제를 해결하는 기법이다.
- 아래의 세가지 단계를 거쳐서 문제를 해결한다.
- 분할
  - 해결하고자 하는 문제를 작은 크기의 동일한 문제들로 분할
  - 크기는 작은 사이즈의 문제이지만, 문제 자체는 전체 문제와 동일한 문제들
- 정복
  - 각각의 작은 문제를 순환적으로 해결
- 합병
  - 작은 문제의 해를 합하여(merge) 원래 문제에 대한 해를 구함

 

## Merge sort

- divide : 데이터가 저장된 배열을 절반으로 나눔
- recursively sort : 각각을 순환적으로 정렬
- merge : 정렬된 두 개의 배열을 합쳐 전체를 정렬
- 주어진 배열을 계속해서 반으로 나누다 보면 결국 길이가 1인 리스트로 쭉 나뉘어진다.
- 길이가 1인 리스트가 된 순간. 그 각각을 정렬된 리스트로 본다.
- 이것을 한 단계식 merge하면서 다시 정렬된 리스트를 만드는 방식으로 정렬이 이루어진다.

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/merge_01.png?raw=true)

- merge sort에서 가장 중요한 과정이 다음과 같이 merge하는 과정이다. 정렬된 두 배열을 다시 하나의 정렬된 배열로 만드는 과정이다.
  - 정렬 된 두 배열을 합치기 위해, 추가배열을 이용한다.
  - 두개의 리스트에서 두 배열의 첫번째 값 중, 작은 값 하나가 추가배열의 가장 작은 값이 된다.

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/merge_02.png?raw=true)



### Merge sort Algorithm

- recursive한 호출을 하기 위해서 recursion 함수를 기술할 때는, 매개변수를 명시적으로 지정하라.



```
mergeSort(A[], p, r) {
  base case 정의; //p>=r인 경우
  if (p < r) then {
    q <- (p + q) / 2;       //p, q의 중간 지점 계산
    mergeSort(A, p, q);     //전반부 정렬
    mergeSort(A, q+1, r);   //후반부 정렬
    merge(A, p, q, r);      //합병
  }
}

merge(A[], p, q, r) {
  정렬되어 있는 두 배열 A[p...q]와 A[q+1...r]을 합하여
  정렬된 하나의 배열A[p...r]을 만든다.
}
```



- 실제 merge() 작성

```
void merge(int[] data, int p, int q, int r) {
  int i = p;
  int j = q+1;
  int k = p;
  int[] tmp = new int[data.length];
  while (i <= q && j <= r) {
    if (data[i] <= data[j])
      tmp[k++] = data[i++];
    else 
      tmp[k++] = data[j++];
  }
  while (i <= q)
    tmp[k++] = data[i++];
  while (j <= r)
    tmp[k++] = data[j++];
  for (int i = p; i <= r; i++)
    data[i] = tmp[i];
}
```



* 최적화 코드

```java
public class MergeSorter {

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int low, int high) {
        if (high - low < 2) {
            return;
        }

        int mid = (low + high) / 2;
        sort(arr, 0, mid);
        sort(arr, mid, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low];
        int t = 0, l = low, h = mid;

        while (l < mid && h < high) {
            if (arr[l] < arr[h]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[h++];
            }
        }

        while (l < mid) {
            temp[t++] = arr[l++];
        }

        while (h < high) {
            temp[t++] = arr[h++];
        }

        for (int i = low; i < high; i++) {
            arr[i] = temp[i - low];
        }
    }
}
```



### 시간복잡도

- n개의 데이터를 정렬하는 시간을 T(n) 이라고 했을 때, N을 반으로 나누어서 정렬하는 시간은 T(n/2)이다. 따라서, 반으로 나눈 배열을 merge sort하는 시간 T(n/2)를 두번 더하고,
- 다시 이 정렬된 두개의 배열을 merge하는 과정에서 두개의 정렬된 배열의 원소를 한번 비교할 때마다, 정렬된 원소를 저장할 추가 배열에 하나씩 원소가 추가되므로 비교연산의 횟수는 n을 넘지 않는다. 총 원소의 수는 n개이다.
- 그리고 base case로, 정렬할 데이터가 1개라면 비교 연산의 횟수는 0이다.
- 따라서 아래와 같이 시간복잡도를 표현할 수 있다.

- T(n) = 
  - if n =1
    - 0
  - otherwise
    - T(n/2) + T(n/2) + n
  - => O(nlogn)

### O(nlogn)

- 길이가 n인 배열을 둘로 쪼개서 다시 정렬된 배열로 병합할 때는 비교의 횟수가 n번을 넘지 않는다.
- 길이가 n/2인 배열을 정렬하는데에는, n/4의 길이를 가지는 배열 두개를 정렬하므로, 이것의 비교연산 횟수는 n/2이다.
  - 전체로 보면 길이가 n/4인 배열을 두개씩 merge하여 정렬된 n/2배열을 두개 만드는 작업을 수행하는데 드는 비교연산의 횟수는, 2 * (n/2) = n이다.
- 아래로 내려갈수록 똑같이 비교연산의 횟수는 n이다.
- 길이가 n인 배열을 길이가 1인 각각의 리스트로 쪼개려면, 아래의 표에서 봤을때 트리의 레벨은 logN이 된다.
- 따라서, merge sort에 필요한 비교연산의 횟수는 총 n * logn이다.
- O(nlogn)







![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/merge_03.png?raw=true)

유튜브 링크 : https://www.youtube.com/watch?v=QAyl79dCO_k&list=PLjSkJdbr_gFZMNhIMl2AJ9n5c2hNK-qJk&index=2

------



## Quick sort

- 분할정복법
  - 분할
    - 배열을 다음과 같은 조건이 만족되도록 두 부분으로 나눈다.
      - 기준값 : pivot
      - elements in lower parts <= elements in upper parts
      - pivot을 기준으로 작은값들, 큰값들로 나눈다.
  - 정복
    - 각 부분을 순환적으로 정렬한다.
  - 합볍
    - 각 부분을 순환적으로 정렬했다면, 그것으로 이미 전체가 정렬 되어 있는 상태가 된다.
    - nothing to do

### 

- 리스트 가운데서 하나의 원소를 고름(pivot 선정)

\- pivot 앞에는 pivot보다 작은 값이 오고, pivot 뒤에는 pivot보다 큰 값들이 오도록 리스트를 둘로 분할한다.

\- 분할된 두 개의 리스트에 대해 재귀함수를 통해 이 과정을 반복한다.

\- 시간복잡도 : 최악 **O(n^2)**, 평균 **O(n**log**n)**



![img](https://t1.daumcdn.net/cfile/tistory/256F4448562E5A3022)



![img](https://t1.daumcdn.net/cfile/tistory/2122044C562E5A7706)

![img](https://t1.daumcdn.net/cfile/tistory/24789D4E562E5A971A)



### Algorithm

- 마찬가지로 quicksort도 recursion이므로 매개변수를 명시화 시킨다.



```
quickSort(A[], p, r) {
  base case;// p>=r일 때, 정렬할 데이터가 0개 또는 1개이므로 할 일 없음.
  if (p < r) then {
    q = partition(A, p, r);  //pivot의 위치
    quickSort(A, p, q-1);
    quickSort(A, q+1, r);
  }
}
```



```
partition(A[], p, r) {
  배열 A[p...r]의 원소들을 A[r]을 기준으로 양쪽으로 재배치하고 A[r]이 자리한 위치를 return 한다;
}
```



### Partition

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/quick_01.png?raw=true)

- 순환적으로 pivot을 기준으로 정렬을 진행하다가, 마지막에 pivot과 큰 값들 중 첫번째 값을 바꾼다.
- 아래와 같은 방법으로 pivot보다 작은 값, 큰값들로 나눈다.
  - 새로운 값(A[j])를 봤더니, pivot보다 크다면 j를 1증가시켜서 큰 값들의 범위를 하나 늘린다.
  - 반대로, pivot보다 작다면, i를 하나 증가시키고 새로운값 A[j]과 교환하면, 여전히 맨 앞 부터 i까지는 pivot보다 작은 값들이 위치하게 된다. 
  - 다음으로 j를 1증가시키면 pivot보다 큰 값들의 범위도 유지가 된다.



```
if A[j] >= x
  j <- j+1;
else
  i <- i+1;
  exchange A[i] and A[j];
  j <- j+1;
```

- 예를 들면, 아래와 같은 흐름으로 i와 j가 움직이게 된다.
  - 시작인덱스 p, 끝인덱스 r
  - 맨 처음에 pivot보다 작다고 판정된 값은 아무것도 없으므로, i는 p-1로 시작한다. j는 p로 시작한다.
    - pivot인 15보다 31이 크므로 j를 증가시킨다.
    - 다음 값인 8은 15보다 작으므로 i를 1증가시키고 i와 j를 교환한 뒤, j를 1증가 시킨다.
    - 그 다음 값은 48은 15보다 크므로 j를 1증가시킨다.
    - ...

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/quick_02.png?raw=true)![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/quick_03.png?raw=true)

- 마지막으로 j와 r이 같아지면, pivot값과 pivot보다 큰 값들중 첫번째 값인 73을 교환하고, 
- 결과적으로 pivot보다 작은 값들의 집합, pivot, pivot보다 큰 값들의 집합으로 partition이 형성된다. 그리고 pivot의 index를 리턴해주면 된다.
- 이것을 **psedocode**로 표현하면 다음과 같다.
  - 시작인덱스 = p
  - 마지막인덱스 = r
  - pivot = x
  - i = p-1
  - j = p
  - parition에서는 n-1번의 비교연산을 가지므로, O(n)의 시간이 걸린다.



```
partition(A, p, r) {
  x <- A[r];
  i <- p-1;
  for j <- p to r-1
    if A[j] <= x then
      i <- i+1;
      exchange A[i+1] and A[r];
  exchange A[i+1] and A[r];
  return i+1;
}
```



### Quick sort Algorithm

```java
public class QuickSort {
    static int partition(int[] array,int start, int end) {
        int pivot = array[(start+end)/2];
        while(start<=end) {
            while(array[start]<pivot) start++;
            while(array[end]>pivot) end--;
            if(start<=end) {
                int tmp = array[start];
                array[start]=array[end];
                array[end]=tmp;
                start++;
                end--;
            }
        }
        return start;
    }
    static int[] quickSort(int[] array,int start, int end) {
        int p = partition(array, start, end);
        if(start<p-1)
            quickSort(array,start,p-1);
        if(p<end)
            quickSort(array,p,end);
        return array;
    }
    public static void main(String[] args) {
        int[] array = {4,2,3,5,9};
        array = quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
```

 

### 최악의 경우

- 항상 한 쪽은 0개, 다른 쪽은 n-1개로 분할되는 경우
  - n(n-1)/2가 되므로, 최악의 경우 매우 비효율적인 알고리즘이 된다.

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/quick_04.png?raw=true)

- 이미 정렬된 입력 데이터 (마지막 원소를 피봇으로 선택하는 경우)를 Quick Sort하는 경우가 위의 경우이다. 항상 한 쪽은 0개, 다른쪽은 n-1개로 분할된다.
  - 이미 정렬된 배열에서 마지막 원소를 피봇으로 봤을때, 나머지 원소들은 다 피봇보다 작은 값이 된다.
  - 그  다음 1 ~ n-1 번째 까지의 원소에서도 마지막 원소인 피봇보다 나머지 원소들이 다 작은 값이다.

### 최선의 경우

- 항상 절반으로 분할 되는 경우
  - 이 경우에는 merge sort와 같은 시간복잡도를 갖는다.
  - T(n) = 2T(n/2) + Θ(n)
  - = Θ(nlogn)

### 극단적인 경우가 아니라면

- 실제 사용을 해보면 다른 sorting알고리즘 보다 빠르기 떄문에, Quick Sort라는 이름이 붙여졌다. 그러나 최악의 경우 Θ(n²)의 시간복잡도를 가지므로, mergesort의 O(nlogn)보다 훨씬 나쁘다. 사실 최악의 경우와 최선의 경우가 발생할 확률은 드물다.

- 아래의 그림을 통해 quick sort가 빠르다는 것에 대한 설명을 보충 한다.

  - 항상 한쪽이 적어도 1/9 이상이 되도록 분할된다면? (가정이다.)
  - 항상 1:9로 분할 되면 왼쪽 트리보다 오른쪽 트리가 훨씬더 길게 그려질 것이다.
  - 가장 오른쪽의 트리를 보면 1이 될 때까지 트리가 그려지므로
  - (9/10)<sup>k</sup> *  n = 1 을 계산하면 k = log<sub>10/9</sub>n이 된다.
  - 따라서, 층의 최대 갯수는 Θ(logn)이다.
  - 추가적으로, 한 레벨씩 아래로 내려올때매다 n번의 비교연산을 하게 되므로, 결국 quick sort의 시간복잡도는 Θ(nlogn)이 된다.

- 이 증명으로 Quick Sort 최악의 경우 시간복잡도가 Θ(n²)임에도 불구하고, 실제로는 상당히 빠른 것에 대한 직관적인 설명이 될 수 있다. 분할이 극단적으로만 일어나지 않는다면 충분히 빠른 정렬알고리즘이다.

  ![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/quick_05.png?raw=true)

### 평균시간복잡도

- "평균" 혹은 "기대값"이란?

  - 어떤 사건이 일어날 확률 * 그 사건이 일어났을 때의 시간
  - quick sort 알고리즘에 n개의 데이터가 들어왔을때, 평균시간복잡도를 A(n)이라고 했을때,
  - 크기가 n인 모든 가능한 입력 I에 대해서 p(I)T(I)이다.

  ![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/quick_06.png?raw=true)

- 그러나, p(I)를 모른다.

- p(I)에 관한 적절한 가정을 한 후 분석한다.

- 예: 모든 입력 인스턴스가 동일한 확률을 가진다면

  - 1 ~ n개의 정수가 입력으로 들어온다면, 1 ~ n개의 정수를 섞어서 만들 수 있는 순열의 수는 n!개이다. 따라서, n!개의 순열이 각각 입력으로 들어올 경우의 수는 동일하다.  
  - p(I) = 1/n!

- 1 ~ n 중 맨 마지막 원소를 pivot으로 봤을 때, 이 pivot이 가장 작은 값일 경우(rank of pivot이 1인 경우)부터 가장 큰 값일 경우(rank of pivot이 n인 경우) 총 n개의 경우의 수가 있다.

  - 그러면, 그런 경우가 발생할 probability는 1/n으로 모두 같다.
  - 만약 rank of pivot이 3이라서, result of partition이 2:n-3으로 나누어 졌을 때,
  - 추가적으로 드는 running time은 A(2) + A(n-3)만큼 이다.
  - 결국 평균 시간 복잡도는 n개의 경우의 수에 대해 running time 곱하기 확률(1/n)을 해주면 된다.
  - 아래 그림에서 시그마 앞의 상수는 2/n 이다.(n/2로 표기오류된 부분) A(0) ~ A(n-1)까지 총 두번.
  - 추가적으로 분할을 하는데 걸리는 시간은 항상 동일하게 Θ(n)이다.
  - 아래의 순환식을 풀어보면 quick sort의 평균 시간복잡도는 Θ(nlogn)이 된다.

- 따라서, 결론적으로 평균시간복잡도까지 구해본 결과, 극단적인 최악의 경우가 아니라면, 실제로 빠른 정렬 알고리즘이다라는 것에 대한 증명을 할 수 있다.

  ![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/quick_07.png?raw=true)

### Pivot의 선택

- 첫번째 값이나 마지막 값을 피봇으로 선택
  - 이미 정렬된 데이터 혹은 거꾸로 정렬된 데이터가 최악의 경우가 된다.
  - 현실의 데이터는 랜덤하지 않으므로 (거꾸로) 정렬된 데이터가 입력으로 들어올 가능성은 매우 높다.(사전에 다른 소프트웨어에 의해 정렬된 데이터가 넘어오는 경우)
  - 따라서 좋은 방법이라고 할 수 없다.
- "Median of Three"
  - 첫번째 값과 마지막 값, 그리고 가운데 값 중에서 중간값(median)을 피봇으로 선택
  - 최악의 경우 시간 복잡도가 달라지지는 않음
- Randomized Quicksort
  - 피봇을 랜덤하게 선택
  - no worst case instance, but worst case execution
    - 다른 방법의 경우, 어떤 입력이 최악의 경우이다 라는 것이 정해지지만, 피봇을 랜덤하게 선택하면 어떤 데이터가 들어오더라도 랜덤값에 의해 결정 되므로. 최악의 실행이 존재한다.
  - 평균 시간복잡도 O(NlogN)



유튜브 링크 : https://www.youtube.com/watch?v=7BDzle2n47c&list=PLjSkJdbr_gFZMNhIMl2AJ9n5c2hNK-qJk&index=1

------



## Heap **Sort**



- 최악의 경우 시간복잡도 O(nlogn)
- Sorts in place - 추가 배열 불필요
  - mergesort도 최악의경우 O(nlogn)이었지만, 추가 배열이 필요했음.
- 이진 힙(binary heap) 자료구조를 사용
- O(nlogn)의 시간복잡도를 가지면서, merge sort처럼 추가적인 배열이 필요하지 않기 때문에 좋은 정렬 알고리즘 중 하나다.

### Heap의 정의

- Heap은
  - 완전 이진 트리(complete binary tree)이면서
  - Heap property를 만족해야 한다.

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/heap_02.png?raw=true)

- 동일한 데이터를 가진 서로 다른 힙이 존재할 수 있다. 즉, 힙은 유일하지 않다.(같은 원소들을 가지는는데 다른 위치에 가진다.)

- 힙은 일차원 배열로 표현가능하다. A[1...n]

  - 루트 노드 : A[1]

  - A[i]의 부모 : A[i/2]

  - A[i]의 왼쪽 자식 = A[2i]

  - A[i]의 오른쪽 자식 = A[2i + 1]

    

### Full vs Complete Binary Trees

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/heap_01.png?raw=true)

  

### 기본 연산: Max-Heapify

- 전체를 힙으로 만들어라.
  - 왼쪽 자식 트리와 오른쪽 자식 트리가 모두 heap property를 만족하는데, root만이 조건을 만족하지 않을 때, 이 트리를 힙으로 만드는 연산을 heapify라 한다.

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/heap_03.png?raw=true)

- max-heapify 연산은 아래와 같은 상황전개가 이루어진다.
  - 두 자식노드 중에 큰 값을 선택하여 교환한다.
  - 4와 16을 교환하고 나면, 오른쪽 트리가 heap property를 만족하는지 고민할 필요가 없다. 16과 15를 비교하여 큰 노드와 교환했기 때문에, 오른쪽 트리는 조건을 만족한다.
  - 4와 16을 교환하고 나면, 4를 루트노드로 봤을 때, 그 아래의 트리들은 같은 상황을 맞게 된다.
  - 왼쪽, 오른쪽 자식 힙이 property를 만족하는데, 루트노드인 4만 조건을 만족하지 않는 상황이다.
  - 같은 방법으로 두 자식중에 큰 값인 8과 루트인 4를 교환한다.
  - 그러고나면 오른쪽 힙인 7은 heap property를 만족하게 되므로 신경쓸 필요가 없으며,
  - 이러한 방식으로 루트노드인 4가 더이상 비교할 자식이 없거나, 두 자식들이 루트 노드 보다 작다면(루트 노드가 들어갈 자리를 찾았다면) 종료한다.

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/heap_04.png?raw=true) 

  

### Max-Heapify: recursion version

- heapify는 본질적으로 recursive한 특성을 가지고 있다.
  - 교환이 일어나고 나면, 반대쪽 힙은 생각하지 않고 반복적으로 교환이 일어난 쪽의 자식 힙만 생각하면 된다.
- root 노드에 대한 heapify는 maxHeapify(1)을 호출하면 되고, 루트노드는 i
- base case는 i의 자식이 없는 경우
- i는 heapify의 대상노드 즉, 시작노드
- k는 i의 자식노드 중 큰 쪽



```
maxHeapify(A, i) {
  if there is no child of A[i]
    return;
  k <- index of the biggest child of i;
  if A[i] >= A[k]
    return;
  exchange A[i] and A[k];
  maxHeapify(A, k);
}
```

  

### Max-Heapify: iterative version

- i=k;



```
maxHeapify(A, i) {
  while A[i] has a child do
    k <- index of the biggest child of i;
    if A[i] >= A[k]
      return;
    exchange A[i] and A[k];
    i=k;
  end.
}
```

  

### Heapify연산의 시간복잡도

- 두 자식들 중 더 큰 쪽을 찾아서 exchange하는 연산을 하면, Heap의 Tree에서 한 레벨 내려온다.
- 그러므로, Heapify 알고리즘은 어떠한 경우에도 트리의 높이보다 더 많은 시간이 필요하지 않는다.
- 따라서, 트리의 높이를 h라고 하면 시간복잡도는 O(h)가 된다.
- 여기서 h를 구해보자.
- heap은 complete binary tree이기 때문에 노드의 수를 n이라고 했을 때, h는 Θ(logn)이 된다.
- 따라서, Θ(logn)이며 n은 노드의 갯수이다.



### 정렬할 배열을 힙으로 만들기

- heap과 heapify연산을 이용하여 정렬된 배열을 만드는 알고리즘에 대해 알아본다.
  - **시간복잡도: O(n)**
  - length[A]: 정렬할 데이터의 개수
  - for 문을 length/2 부터 시작하는 이유는 leaf노드가 아닌 첫번째 노드 즉, 리프노드의 부모노드 부터 heapify연산의 가능 여부를 판단하기 때문이다.(아래의 설명 참조)
  - Max-heapify를 실행한다.
  - 완전 이진 트리의 형태(노드의 갯수가 n개)를 가지는 힙의 heapify연산이 O(logn)이다. 이 연산을, n/2번 수행하므로, 시간복잡도는 O(nlogn)으로 볼 수 있는데,
  - 이 경우는 일반적인 경우보다 과도하게 많이 측정한 시간이 된다. 왜냐면, 항상 루트노드에 대해서 heapify를 하는 것이 아니라, 마지막 leaf노드의 부모에서 부터 heapify를 수행하므로 첫번째 heapify의 경우 노드의 갯수가 2개 또는 3개이므로.
  - 좀 더 정확히 분석을 하면 정렬할 배열을 힙으로 만드는 데에는 O(n)이 된다. 증명에 관한 부분은 책을 참고한다.
  - Heap sort에서는 실제로 힙을 정렬하는 과정에서 O(nlogn)의 시간복잡도를 갖기 때문에, 힙을 만드는 과정의 시간복잡도가 O(n)이던, O(nlogn)이던 전체 힙 정렬의 시간복잡도는 O(nlogn)이 된다. 따라서, 힙을 만드는데 필요한 시간복잡도에 주목하지 않아도 된다.



```
BUILD-MAX-HEAP(A)
  1 heap-size[A] <- length[A]
  2 for i <- length[A]/2 downto 1
  3   do MAX-HEAPIFY(A, i)
```

- 먼저 주어진 1차원 배열을 complete binary tree로 해석한다. 실제로 트리를 만든다는 것이 아니라, 개념적으로 tree로 생각한다는 의미이다. 

- 다음으로 complete binary tree를 heap으로 바꾼다.

  - Level order의 역순으로 노드들을 고려했을 때, leaf노드가 아닌 첫번째 노드(16)부터, 그 노드를 루트 노드로 하는 sub tree에 대해서 heapify연산을 할 수 있는 조건(양쪽 서브트리가 모두 heap인가)을 확인한다. 
  - 다음 순서로 2에 대해 양쪽 sub tree에 대해 양쪽 섭즈트리가 모두 heap인가를 확인한다. 싱글노드이므로 힙이다. 따라서 2는 heapify 연산을 하기 위한 조건이 된다. 따라서, heapify연산을 수행하면 2와 14가 exchange된다.
  - 같은 방식으로 level order의 역순으로 올라가면서, heapify연산을 수행한다.
  - 결과적으로 f 단계와 같이 max heap을 얻을 수 있다.
  - 이것을 pseudo code로 작성하면 위의 코드와 같이 단순하게 작성할 수 있다.

  ![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/heap_05.png?raw=true)

### 실제 입력 배열을 힙으로 만드는 과정

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/heap_06.png?raw=true)

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/heap_07.png?raw=true)

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/heap_08.png?raw=true)



### Heap Sort

- 주어진 데이터로 힙을 만든다.
- 힙에서 최댓값(루트)을 가장 마지막 값과 바꾼다.
- 힙의 크기가 1 줄어든 것으로 간주한다. 즉, 가장 마지막 값은 힙의 일부가 아닌 것으로 간주한다.
- 루트 노드에 대해서 HEAPIFY(1)을 실행한다.
- 2~4번을 반복한다.
- 마지막노드와 루트노드를 바꾸고 힙의 크기를 1줄이면, 루트노드를 제외한 모든 곳에서 heap property를 만족하므로 heapify(1)을 실행해주면 된다.

### pseudo code

- 먼저 배열 A를 max Heap으로 만든다. O(n)의 시간이 든다.
- Heap size가 2가될 때 까지 반복하고,
- 루트노드와 마지막노드를 교환하고, 힙의 사이즈를 1줄인다.
- Max-Heapify를 호출한다.



```
HEAPSORT(A)
1. BUILD-MAX-HEAP(A)                 : O(n)
2. for i <- heap_size downto 2 do    : n-1 times
3.   exchange A[1] <-> A[i]          : O(1)
4.   heap_size <- heap_size - 1      : O(1)
5.   MAX-HEAPIFY(A, 1)               : O(logn)
```

 

### Heap Sort Algorithm

```java
private void solve() {
    int[] array = { 230, 10, 60, 550, 40, 220, 20 };
 
    heapSort(array);
 
    for (int v : array) {
        System.out.println(v);
    }
}
 
public static void heapify(int array[], int n, int i) {
    int p = i;
    int l = i * 2 + 1;
    int r = i * 2 + 2;
 
    if (l < n && array[p] < array[l]) {
        p = l;
    }
 
    if (r < n && array[p] < array[r]) {
        p = r;
    }
 
    if (i != p) {
        swap(array, p, i);
        heapify(array, n, p);
    }
}
 
public static void heapSort(int[] array) {
    int n = array.length;
 
    // init, max heap
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(array, n, i);
    }
 
    // for extract max element from heap
    for (int i = n - 1; i > 0; i--) {
        swap(array, 0, i);
        heapify(array, i, 0);
    }
}
 
public static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}
```

유튜브 링크 : https://www.youtube.com/watch?v=iyl9bfp_8ag





------

[출처]

합병정렬 : https://ict-nroo.tistory.com/53?category=698685

​                   https://www.daleseo.com/sort-merge/

퀵정렬 :  https://ict-nroo.tistory.com/54?category=698685

​               https://hahahoho5915.tistory.com/9

​               https://heekim0719.tistory.com/282 

힙정렬 : https://ict-nroo.tistory.com/55?category=698685

​               https://mygumi.tistory.com/310