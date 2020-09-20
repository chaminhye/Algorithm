## Selection Sort 

#### -> index 0번부터 작은수대로 정렬

- 선택정렬은 배열중에 가장 작은 원소들을 왼쪽부터 채워나가면서 숫자를 정렬하는 방법입니다.

  최소원소를 찾은 후 

  => 최소원소를 맨 왼쪽원소와 교환(즉, 왼쪽부터 정렬된 원소로 채워집니다.)

  => 왼쪽원소를 제외하고 원소가 하나남을때 까지 이단계를 반복

  (그림 참고)

  ![img](https://t1.daumcdn.net/cfile/tistory/99A2583B5A9FF27425)

  

  선택정렬의 비교횟수를 구해보면

  1단계 => n개의 원소 비교

  2단계 => n-1 개의 원소 비교

  3단계 => n-2 개의 원소 비교

  ....

  를 하여 비교 횟수는

  n(n-1) /2 가 됩니다.

  즉, **시간복잡도는 O(n^2)**이 됩니다.

  

  ```java
     // 선택정렬 
      public void selectionSort(int[] array) {
          int size = array.length;
          int i, j, min;
          
          for(i = 0; i < size-1; i++) {
              min = i;
              for(j = i+1; j < size; j++) {
                  if(array[j] < array[min]) {
                      min = j;
                  }
              }
              swap(array, min, i);
              System.out.printf("\nSelectionSort %d 단계 : ", i+1);
              for(j = 0; j < size; j++) {
                  System.out.printf("%3d", array[j]);
              }
          }
      }
      
      public void swap(int[] array, int i, int j) {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
      }
  ```

  

  ![img](https://t1.daumcdn.net/cfile/tistory/99A449345A9FF36016)



유튜브 링크 : https://www.youtube.com/watch?v=uCUu3fF5Dws

------



## Bubble Sort 

#### -> last index부터 큰수대로 정렬

![img](https://github.com/namjunemy/TIL/blob/master/Algorithm/img/sort_02.png?raw=true)

- 실행시간
  - (n-1) + (n-2) + … + 2 + 1 = O(n<sup>2</sup>)
- pseudocode

```
bubbleSort(A[], n) {
  for last <- n downto 2 {                    == 1
    for i <- to last-1                        == 2
      if (A[i] > A[i+1]) the A[i] <-> A[i+1]; == 3
  }
}
```

- 수행시간
  - 1의 for 루프는 n-1번 반복
  - 2의 for 루프는 각각 n-1, n-2, … , 2, 1번 반복
  - 3의 교환은 상수시간 작업
- T(n) = (n-1) + (n-2) + … + 2 + 1 = O(n<sup>2</sup>)
  - 최악, 최선, 평균 항상 n(n-1) / 2번의 비교연산을 수행하게 되므로 O(n<sup>2</sup>)이다.

### Bubble sort Algorithm

```java
public class Bubble {
  private static int[] input = {5, 6, 2, 8, 7, 23, 4, 1};

  public static void main(String[] args) {
    bubbleSort(input, input.length);
    for (int a : input) {
      System.out.print(a + " ");
    }
  }

  private static void bubbleSort(int[] input, int length) {
    int tmp;
    for (int i = length - 1; i > 0; i--)
      for (int j = 0; j < i; j++) {
        if (input[j] > input[j + 1]) {
          tmp = input[j];
          input[j] = input[j + 1];
          input[j + 1] = tmp;
        }
      }
  }
}
```

* result

```
1 2 4 5 6 7 8 23 
Process finished with exit code 0
```

유튜브 링크 :  https://www.youtube.com/watch?v=YbsQiiubO74

------



## Insertion Sort

- 삽입정렬은 아직 정렬되지 않은 임의의 데이터를 이미 정렬된 부분의 적절한 위치에 삽입해 가며 정렬하는 방식입니다.

  * 삽입정렬 또한 앞의 두 알고리즘과 같이 시간복잡도**O(n^2)**를 갖습니다. (for문이 2번 있기 때문입니다. )

  * 왼쪽원소부터 정렬되며 오른쪽 원소들을 왼쪽 정렬된 원소들과 비교하며 적절한 위치에 삽입합니다.

  
  
  ```java
  //삽입정렬(insertion sort)
   public void insertionSort(int[] array) {
       int size = array.length;
        
       for(int i=1; i < size; i++) {
           int k = i;
            
           for(int j=i-1; j >= 0; j--) {
               if(array[k] < array[j]) {
                   swap(array, k, j);
                   k = j;
               }
           }
       }
   }
    
   public void swap(int[] array, int i, int j) {
       int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
   }

  ```
  
  ```java
  public void insertionSort2(int a[], int size) {
              
   
          for (i = 1; i < size; i++) {
              j = i;
              temp = a[i];
              while ((j > 0) && (a[j - 1] > temp)) {
                  a[j] = a[j - 1];
                  j--;
              }
              a[j] = temp;
              System.out.printf("\n 삽입정렬 %d 단계 : ", i);
              for (t = 0; t < size; t++) {
                  System.out.printf("%3d", a[t]);
              }
              System.out.println();
          }
      }

  ```

  -------------------- append ---------------------

  더 좋은코드가 있어서 추가합니다.
  
  ```java
  public List<Integer> insertSort(final List<Integer> numbers){
          final List<Integer> sortedList = new LinkedList<>();
          
          originalList : for(Integer number : numbers) {
              for(int i=0; i<sortedList.size(); i++) {
                  if(number < sortedList.get(i)) {
                      sortedList.add(i, number);
                      continue originalList;
                  }
              }
              sortedList.add(sortedList.size(), number);
          }
          
          return sortedList;
    }
  ```

  

  이 삽입정렬코드에서 살펴봐야할 점은 새로운 리스트를 생성하고 해당 리스트를 반환한다는 점과 삽입정렬에서 반환하는 리스트는 LinkedList 클래스의 인스턴스라는 것입니다.

  ArrayList를 사용했더라면 리스트 중간에 원소를 추가할 경우 처리 속도가 많이 느리므로 LinkedList를 사용하였습니다.

  

  (ArrayList는 중간에 원소를 삽입하면 모든 원소를 한 칸씩 뒤로 이동시켜야 합니다.)

  최악의 경우

  => O(n^2)

  최선의 경우

  => O(n)

  버블 정렬과 마찬가지로 최악의 경우 알고리즘의 성능은 O(n^2)이 됩니다. 이미 정렬된 리스트를 다시 정렬하는 경우라면 매번 원소를 삽입할 때마다 새 리스트의 끝까지 반목문을 실행해야 되기 때문입니다. 반대로 역순으로 정렬된 리스트를 정렬하는 경우라면 앞에있는 원소를 새리스트에 넣으므로 O(n)의 성능을 가집니다.
  
  
  
  유튜브 링크 : https://www.youtube.com/watch?v=SZVugP81J1A





------

[출처]

선택정렬 : https://cornswrold.tistory.com/17

버블,삽입정렬 : https://ict-nroo.tistory.com/52