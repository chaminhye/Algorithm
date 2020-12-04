# Dynamic Programming

### ✔주어진 문제를 세분화하여 최적의 해를 찾는 방법 -> 메모이제이션(Memoization)

#### 🔆곧 중복된 부분과 불필요한 요소를 배제하는 것으로 연산의 효율을 높인다.



### DP의 속성

1. Overlapping Subproblem(부분 문제가 겹친다.)

2. Optimal Substructure(최적 부분 구조)

   

### DP 풀이 방식

1. Top-Down

   1. 큰 문제를 작은 문제로 나눈다.
      F(n-1), F(n-2)로 나눈다.
   2. 작은 문제를 푼다.
      F(n-1) + F(n-2)

   > 재귀호출을 하는 방식으로 푼다.

2. Bottom-up : 작은문제를 푼다.

   1. 문제를 크기가 작은 문제부터 차례대로 쓴다.
   2. 문제의 크기를 조금씩 크게 만들면서 문제를 푼다.
   3. 작은 문제를 풀면서 큰 문제의 답을 구한다.

   ```java
   int d[100];
   public int fibonacci(int n) {
       d[0] = 0;
       d[1] = 1;
       for (int i = 2; i <= n; i++) {
           d[i] = d[i - 1] + d[i - 2];
       }
       return d[n];
   }
   ```



예를 들어 설명하는 것이 가장 이해하기 쉬울거라고 생각하여 피보나치 알고리즘을 통해 알아보자.

기존 피보나치 알고리즘은, 재귀함수를 통해 계산을 하게 된다.

**f(n) = f(n-1) + f(n-2)**  -> * Overlapping Subproblem : f(n)을 큰 문제, f(n-1), f(n-2)을 작은문제로 생각 

​                                     -> * Optimal Substructure : 작은 문제로 쪼갠 우측항의 f(n-1)+f(n-2)로 큰문제인 f(n)의 값을 구한다.   

0 ,1 ,1, 2, 3, 5, 8 ......

| index | 0    | 1    | 2    | 3    | 4    | 5    | 6    |
| ----- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| value | 0    | 1    | 1    | 2    | 3    | 5    | 8    |

f(n)을 통해서 4번째 인덱스 값을 가져오기 위해, 이미 계산한 값을 재귀 호출하고 있다.

f(4) = f(3) + f(2) 

f(3) = f(2) +f(1)

f(2) = ...

```java
public static int fn_fibonacci(int n){
	if(n==0){
        return 0;
    }else if(n==1){
        return 1;
    }else{
        return fn_fibonacci(n-1) + fn_fibonacci(n-2);
    }
}
```



💡 <u>**이를 해결하기 위해 Dynamic Programming 방법으로 피보나치 알고리즘을 풀게 된다면,**</u>

​	배열 또는 HashMap을 생성하여, 값을 가지고 있는다. (다시 ♻ 활용한다.)

```java
// 배열을 통해 값을 저장
int arr[100];
public static int fn_dp_arr_fibonacci(int n){
	if(n <= 1){		
        return n;
    }else if(n == 2){
        return 1;
    }else{
        if(arr[n] > 0){		//  이미 연산완료했으므로, 값 반환
            return arr[n];
        }
        arr[n] = fn_dp_arr_fibonacci(n-1) + fn_dp_arr_fibonacci(n-2);
        return arr[n];
    }
}

// HashMap을 통해 값을 저장
public static int fn_dp_map_fibonacci(int n, HashMap<Integer, Integer> dp){
	if(dp.contains(n)){		//  이미 연산완료했으므로, 값 반환
        return dp.get(n);
    }else if(n == 0){
        return 0;
    }else if(n <= 2){
        return 1;
    }else{
        int value = fn_dp_map_fibonacci(n-1, dp) + fn_dp_map_fibonacci(n-2, dp);
        dp.put(n, value);
        return value;
    }
}
```



 💡**Tip**. 동적계획법을 해결할 때는 **이미 답을 뱉어내는 함수를 내가 가지고 있다고 가정**해야 그 다음 생각을 쉽게 전개시킬 수 있습니다.

참고 : https://blog.naver.com/oncoder-hs/221323255829







출처 : https://m.blog.naver.com/oncoder-hs/220738696560

​           https://developer-mac.tistory.com/77