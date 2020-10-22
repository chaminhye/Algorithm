# O(n) 시간복잡도의 알고리즘

* 범위조건이 있는 경우에 한하여 굉장히 빠른 알고리즘
* 요소값을 명시적으로 비교하지 않아도 정렬할 수 있는 기법



## Counting Sort



- 원소간 비교하지 않고 각 원소가 몇개 등장하는지 갯수를 세서 정렬하는 방법이다.
- 모든 원소는 양의 정수여야 한다.
- 시간복잡도는 O(n+k) 로 퀵정렬, 병합정렬에 비해 일반적으로 빠르다.
- 정렬을 위한 길이 n의 배열 하나, 계수를 위한 길이 k의 배열 하나. O(n+k) 의 공간복잡도를 가진다.



### 정렬 과정

다음과 같은 *수열 A*를 정렬 해야하는 상황을 생각해봅시다.



![img](https://t1.daumcdn.net/cfile/tistory/2656634B56E7555108)



위 수열을 정렬하면 아래와 같은 *수열 B*를 얻습니다.



![img](https://t1.daumcdn.net/cfile/tistory/2220E94156E7555111)



`Counting Sort`가 어떻게 *수열 A*를 정렬해서 *수열 B*를 얻는지 따라가 봅시다.

1. 첫번째로 각 숫자가 몇번 등장하는지 세어줍니다.

| 숫자      |  0   |  1   |  2   |  3   |  4   |  5   |
| :-------- | :--: | :--: | :--: | :--: | :--: | :--: |
| 등장 횟수 |  3   |  2   |  2   |  3   |  3   |  3   |

> 벌써 **Counting Sort**의 이름에 왜 **Counting**이 들어가있는지 알것 같지 않나요? 이렇게 각 숫자가 몇번 등장했는지 세어주기 때문입니다.
>
> cf) 이 예제만 보면 1번 과정만 하고 벌써 정렬을 다 한 것 같습니다. 각 숫자가 등장한 횟수만큼 작은 순서대로 찍어주면 되기 때문이죠. 그럼 왜 굳이 아래 과정을 할까요?
>
> ![img](https://t1.daumcdn.net/cfile/tistory/2344644356E7555117) 같은 수열을 정렬하는 상황을 생각해보세요. 중간에 등장한 뜬금없이 큰 100이 있어서 3~99까지 무의미한 순회를 해야하죠. 따라서 방금 생각한 방법은 `숫자 크기`에 시간복잡도가 매우 큰 영향을 받으므로 `비효율적`이라는 것을 알 수 있습니다.

1. 등장 횟수를 누적합으로 바꿔줍니다.

| 숫자    |   0   |    1    |     2     |      3       |       4        |        5         |
| :------ | :---: | :-----: | :-------: | :----------: | :------------: | :--------------: |
| 누적 합 | 3 (3) | 5 (3+2) | 7 (3+2+2) | 10 (3+2+2+3) | 13 (3+2+2+3+3) | 16 (3+2+2+3+3+3) |

> 이 누적합에서 알 수 있는 것은 숫자 0은 1 ~ 3인덱스에 위치하고 숫자 2는 4 ~ 7 인덱스에 위치한다는 것입니다.

1. `정렬할 배열 A`를 뒤에서 앞으로 순회 하면서 `정렬된 배열 B` 에 넣어줍니다. 2번 과정에서 구한 누적합이 배열 A의 숫자가 배열 B의 어디에 위치해야 할지 정확하게 알려줍니다. 아래 5장의 이미지는 3번의 진행 과정을 설명합니다.

------



![img](https://t1.daumcdn.net/cfile/tistory/22538A4D56D2FFBA2E)

![img](https://t1.daumcdn.net/cfile/tistory/234A764D56D2FFBF38)

![img](https://t1.daumcdn.net/cfile/tistory/27686D4D56D2FFC117)

![img](https://t1.daumcdn.net/cfile/tistory/225C7D4D56D2FFC223)

![img](https://t1.daumcdn.net/cfile/tistory/23057D4956D2FFE314)

### Counting sort Algorithm

```java
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by yaboong on 2018. 3. 20..
 */
public class CountingSort {
    public static void main(String[] args) {
        Integer[] a = {1, 0, 3, 1, 3, 1};

        a = sort(a);

        System.out.println(Arrays.toString(a));
    }

    public static Integer[] sort(Integer[] a) {
        int max = Collections.max(Arrays.asList(a));
        Integer[] aux = new Integer[a.length];
        Integer[] c = new Integer[max+1];
        Arrays.fill(c, 0);

        // 각 원소 갯수 계산
        for (int i=0; i<a.length; i++) {
            c[a[i]] += 1;
        }

        // 누적합 계산
        for (int i=1; i<c.length; i++) {
            c[i] += c[i-1];
        }

        // 누적합을 이용해 정렬
        for (int i=a.length-1; i>=0; i--) {
            aux[--c[a[i]]] = a[i];
        }

        return aux;
    }
}
```



#### 최적화코드

```java
import java.util.*;

/**
 * Created by yaboong on 2018. 3. 20..
 */
public class CountingSortBig {
    public static void main(String[] args) {
        Integer[] a = {Integer.MAX_VALUE - 1000, Integer.MAX_VALUE, Integer.MAX_VALUE-100};

        a = sort(a);

        System.out.println(Arrays.toString(a));
    }

    public static Integer[] sort(Integer[] a) {
        List<Integer> list = Arrays.asList(a);
        int min = Collections.min(list);            // 최소값도 구한다
        int max = Collections.max(list);
        Integer[] aux = new Integer[a.length];
        Integer[] c = new Integer[max-min+1];   // c 배열 생성
        Arrays.fill(c, 0);

        for (int i=0; i<a.length; i++) {
            c[a[i]-min] += 1;               // min 값을 빼준다
        }

        for (int i=1; i<c.length; i++) {
            c[i] += c[i-1];
        }

        for (int i=a.length-1; i>=0; i--) {
            aux[--c[a[i]-min]] = a[i];      // min 값을 빼준다
        }

        return aux;
    }
}
```



### counting sort의 복잡성

데이터 개수가 nn일 때 AA의 빈도를 세는 계산복잡성은 O(n)O(n)입니다. 데이터 전체를 한번씩 훑어야 하기 때문입니다. 출력어레이 BB를 만들 때도 O(n)O(n)입니다. AA의 요소값들을 역순으로 모두 훑어야 하기 때문입니다.

한편 kk는 AA의 요소값 가운데 최댓값을 가리킵니다. 위 예시에서는 k=5k=5였습니다. 카운팅어레이 CC를 만들 때 k+1k+1개의 요소값을 0으로 초기화하게 되므로 공간복잡성은 O(k)O(k)가 됩니다. 또한 CC를 업데이트할 때 반복문이 kk번 돌게 되므로 계산복잡성 또한 O(k)O(k)가 됩니다. 그런데 AA가 만약 다음과 같다면 카운팅어레이 CC의 크기가 10000+1이 되고, 반복문 또한 10000회를 돌게 되어 대단히 비효율적이게 됩니다.

> A=[0,10000]A=[0,10000]

요컨대 counting sort의 전체적인 계산복잡성은 O(n+k)O(n+k)가 되는데요. kk가 충분히 작을 경우 O(n)O(n)이 되겠지만, kk값이 커질 경우 kk가 counting sort의 복잡성을 지배하게 됩니다.



유튜브 링크 : https://www.youtube.com/watch?v=n4kbFRn2z9M



------



## Radix Sort

* 낮은 자리 수 부터 비교하여 정렬해 간다는 것을 기본 개념으로 하는 정렬 알고리즘이다.

​       자릿수가 고정되어 있으니, 안전성이 있고(이때 데이터들 간의 상대적 순서는 보존되어야 한다.)



* 기수 정렬은 비교 연산을 하지 않으며, 무엇보다도 전체 시간복잡도 역시 ![{\displaystyle O(dn)}](https://wikimedia.org/api/rest_v1/media/math/render/svg/56870c953a3fb2902f3452a9a9d9d15f83d144d5)이어서, 정수와 같은 자료의 정렬 속도가 매우 빠르다.

* 하지만, 데이터 전체 크기에 기수 테이블의 크기만한 메모리가 더 필요하다.

* 기수 정렬은 정렬 방법의 특수성 때문에, 부동소수점 실수처럼 특수한 비교 연산이 필요한 데이터에는 적용할 수 없지만, 사용 가능할 때에는 매우 좋은 알고리즘이다.



##### **예시**

329    ->  72**0**   ->   7**2**0    ->   **3**29

457    ->  35**5**   ->   3**2**9    ->   **3**55

657    ->  43**6**   ->   4**5**6    ->  **4**36

839    ->  45**7**   ->   8**3**9    ->   **4**57

436    ->  65**7**   ->   3**5**5    ->   **6**57

720    ->  32**9**   ->   4**5**7    ->  **7**20

355    ->  83**9**   ->   6**5**7    ->  **8**39

 (a)     ->   (b)    ->    (c)     ->   (d)



(b) : 1의 자리수 정렬

(c) : 10의 자리수 정렬

(d) : 100의 자리수 정렬



##### **psedocode**

```
Radix-Sort(A, d) {    // A : n개 배열, d : 자리 형식
	for i <- 1 to d
		do use a stable sort to sort array A on digit;
}

```



### Radix Sort Algorithm

```java
import java.util.Arrays;
// 기수 정렬 알고리즘 구현
public class radix {
	// 배열에서 최대값을 얻기 위한 메서드
	static int getMax(int[] data) {
		int mx = data[0];
		for(int i=1; i<data.length; i++) {
			if(data[i] > mx) {
				mx = data[i];
			}
		}
		return mx;
	}
	// exp 변수의 수에 따라 숫자를 정렬
	static void countSort(int[] data, int exp) {
		int[] output = new int[data.length];
		int[] count = new int[10];
		Arrays.fill(count, 0);
		
		// count 값 count배열에 저장
		for(int i=0; i<data.length; i++) {
			count[(data[i]/exp)%10]++;
		}
		// count 값이 포함시켜 count배열에 저장
		for(int i=1; i<10; i++) {
			count[i] += count[i-1];
		}
		// output배열 빌드
		for(int i=data.length-1; i>=0; i--) {
			output[count[(data[i]/exp)%10]-1] = data[i];
			count[(data[i]/exp)%10]--;
		}
		// output 배열에 저장된 값을 data 배열에 저장
		for(int i=0; i<data.length; i++) {
			data[i] = output[i];
		}
	}
	static void radixsort(int[] data) {
		// 최대값 찾기
		int m = getMax(data);
		for(int exp=1; m/exp>0; exp*=10) {
			countSort(data, exp);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {4, 54, 2, 8, 63, 7, 55, 56};
		// 기수 정렬 전
		System.out.println("# 기수 정렬 전");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		
		radixsort(data);
		// 기수 정렬 후
		System.out.println("# 기수 정렬 후");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}
}
```





------

[출처]

카운팅 정렬 : https://bowbowbow.tistory.com/8

​                       https://yaboong.github.io/algorithms/2018/03/20/counting-sort/

​                       https://ratsgo.github.io/data%20structure&algorithm/2017/10/16/countingsort/

기수 정렬 :  https://journee912.tistory.com/54