# Algorithm 문제 풀이

JAVA를 이용한 알고리즘 문제풀이 

📑[알고리즘 풀이 설명 velog](https://velog.io/@ming/series/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%ED%92%80%EC%9D%B4JAVA)

[📕알고리즘 개념알기 velog](https://velog.io/@ming/series/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%9C%EB%85%90%EC%95%8C%EA%B8%B0)

## Algorithm 개념

* #### 🌳 [알고리즘 개념 정리 개인 블로그](https://velog.io/@ming/series/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%9C%EB%85%90%EC%95%8C%EA%B8%B0)  

* #### [정렬](https://github.com/chaminhye/Algorithm/tree/master/src/concept/sorting)  

  * ###### [simple, slow](https://github.com/chaminhye/Algorithm/blob/master/src/concept/sorting/Simple%20Sort%20Concept.md) 

    * Bubble sort : O(n^2)
    * Insertion sort : worst - O(n^2) / best : O(n)
    * Selection sort : O(n^2)

  * ###### [fast](https://github.com/chaminhye/Algorithm/blob/master/src/concept/sorting/Fast%20Sort%20Concept.md) 

    * Quick sort : worst - O(n^2), avg - O(n**log**n)
    * Merge sort : O(n**log**n)
    * Heap sort  : O(n**log**n)

  * ###### [O(n)](https://github.com/chaminhye/Algorithm/blob/master/src/concept/sorting/O(n)%20Sort%20Concept.md) 

    * Radix sort

* #### [Dynamic Programming](https://github.com/chaminhye/Algorithm/tree/master/src/concept/dp/dp)  

  *  [Floyd Warshall 알고리즘](https://velog.io/@ming/Floyd-Warshall-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)  -> [소스보기](https://github.com/chaminhye/Algorithm/tree/master/src/concept/dp/FloydWarshall.java)

* #### [DFS vs BFS](https://velog.io/@ming/DFS-vs-BFS-%ED%83%90%EC%83%89)  

  *  [인접행렬, 인접리스트, 스택으로 구현한 DFS  & 큐로 구현한BFS](https://velog.io/@ming/DFS-vs-BFS-%ED%83%90%EC%83%89) -> [소스보기](https://github.com/chaminhye/Algorithm/blob/master/src/concept/graph/DFSandBFS.java)

* ####  [Binary Search](https://velog.io/@ming/%EC%9D%B4%EB%B6%84%ED%83%90%EC%83%89Binary-Search)

  *  [이분탐색(이진탐색) 개념](https://velog.io/@ming/%EC%9D%B4%EB%B6%84%ED%83%90%EC%83%89Binary-Search) ->  [소스보기](https://github.com/chaminhye/Algorithm/blob/master/src/concept/search/BinarySearch.java)

  

## Index

* ### <a href="https://programmers.co.kr/learn/challenges "> programmers</a>(실제 코딩테스트에 나올 난이도)

  

  * ####  [practice](https://programmers.co.kr/learn/courses/30/parts/12077)  

    * [(Level2)멀쩡한 사각형](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/practice/FineSquare.java)  -> 최대공약수로 접근, 규칙성을 찾는것이 목표

  * #### [해시](https://programmers.co.kr/learn/courses/30/parts/12077)  

    * [완주하지 못한 선수](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/hash/NotFinishPlayer.java)  

    * [전화번호](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/hash/PhoneNumberBook.java)  

    * [위장](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/hash/Camouflage.java)  

    * [베스트 앨범](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/hash/BestAlbum.java)  

      

  * #### [스택/큐](https://programmers.co.kr/learn/courses/30/parts/12081)  

    * [주식가격](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/stackQueue/StockPrice.java )  

    * [기능개발](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/stackQueue/FunctionDevelope.java )  

    * [다리를 지나는 트럭](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/stackQueue/TruckCrossingBridge.java )  

    * [프린터](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/stackQueue/Printer.java )  

      

  * #### [힙](https://programmers.co.kr/learn/courses/30/parts/12117)  

    * [더 맵게](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/heap/MoreSpicy.java )  

    * [디스크 컨트롤러](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/heap/DiskController.java )  

    * [이중 우선순위 큐](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/heap/DoublePriorityQueue.java )  

      

  * #### [정렬](https://programmers.co.kr/learn/courses/30/parts/12198)

    * [K번째 수](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/sort/KthNumber.java )  

    * [H-Index](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/sort/HIndex.java)

      

  * #### [완전탐색](https://programmers.co.kr/learn/courses/30/parts/12230)

    ( 나름 가장 수월하게 풀었던 파트)
  
    * [모의고사](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/bruteForce/PracticeTest.java )  
    * [소수](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/bruteForce/PrimeNumber.java )  
    * [카펫](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/bruteForce/Carpet.java )  
  
  * #### [탐욕법](https://programmers.co.kr/learn/courses/30/parts/12244)★★★
  
    * [체육복](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/greedy/GymClothes.java )  
    * [조이스틱](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/greedy/Joystick.java )  -> 생각보다 다양한 패턴으로 많이 출제됨!  알파벳 계산하여 출제되는 문제 ★★
  * [구명보트](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/greedy/Lifeboat.java )  
    * [큰 수 만들기](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/greedy/MakingBigNumber.java )  

    

  * #### [동적계획법](https://programmers.co.kr/learn/courses/30/parts/12263)★★★★★

    -> 풀이를 보고 푸는 방법을 참고하여 문제 풀이 진행 ( 연습이 많이 필요한 파트)

    * [정수삼각형](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/dynamic/IntegerTriangle.java )  	-> 계산식 세우는 부분 연습필요

    * [N으로 표현](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/dynamic/PresentationN.java )  	

      

  * #### [깊이/너비 우선 탐색(DFS/BFS)](https://programmers.co.kr/learn/courses/30/parts/12421) ★★★★★		

    -> 풀이를 보고 푸는 방법을 참고하여 문제 풀이 진행

    -> 그림을 그려서 문제에 대한 이해도를 높이자.!
  
    * [타겟 넘버](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/dfs/TargetNumber.java )     -> DFS로 문제풀이	
    
    * [네트워크](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/dfs/Network )  	-> DFS & BFS 문제풀이
    
    * [단어 변환](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/dfs/WordConversion.java )     -> DFS로 문제풀이
    
    * [여행 경로](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/dfs/TravelRoute.java )     -> DFS로 문제풀이
    
      
    
  * #### [이분탐색](https://programmers.co.kr/learn/courses/30/parts/12486)
  
    * [입국심사](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/binary/Immigration.java )  -> 이분탐색, 접근방법을 잘 생각해야함.
    
      
    
  * #### [그래프](https://programmers.co.kr/learn/courses/30/parts/14393)
  
    *  [가장 먼 노드](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/graph/FarthestNode.java) -> BFS 탐색 이용
    * [순위](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/graph/Ranking.java) -> 플로리다 와샬 알고리즘 적용
  
    


------

* ### <a href="https://www.hackerrank.com/domains/java"> hackerrank</a> (기본기 다지기 좋음)

  * #### Strings ( 정규식을 잘 이용하면, 문제 풀이 수월함)

    * [Anagrams](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/Anagrams.java )  

    * [RegexIP](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/RegexIP.java )   ->  정규식 표현을 이용

    * [StringCompare](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/StringCompare.java )  

    * [StringReverse](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/StringReverse.java )  

    * [StringTokens](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/StringTokens.java )   -> 정규식 표현을 이용

    * [TimeConversion](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/TimeConversion.java )  

      

  * #### BigDecimal
  
    * [BigNumber](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/BigDecimal/BigNumber.java )
    * [PrimalityTest](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/BigDecimal/PrimalityTest.java )
    * [MiniMaxSum](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/BigDecimal/MiniMaxSum.java )
    
  * #### **DP**
  
    * [TheCoinChangeProblem](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/DynamicPrograming/TheCoinChangeProblem.java ) ->bottom-up 방식으로 거스름돈을 계산한다..
  
      
  
  * #### **Sorting**
  
    * [MigratoryBirds](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Sorting/MigratoryBirds.java )  -> Map과 Collections.max를 이용하면 쉽게 풀이가능
  
  * #### Greedy
  
    * [Candies](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Greedy/Candies.java )  
  
  * #### Practice
  
    * [GradingStudents](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/practice/GradingStudents.java ) -> 나머지 연산을 통해 간단하게 풀이 가능
    
    * [AppleAndOrange](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/practice/AppleAndOrange.java ) 
    
    * [NumberLineJumps](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/practice/NumberLineJumps.java ) -> 계산식을 이용하여 , 나머지 연산이용하는것이 키포인트!
    
    * [BetweenTwoSets](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/practice/BetweenTwoSets.java ) -> 유클리드 호제법을 이용한 최대공약수, 최소공배수 구하기
    
    * [BreakingTheRecords](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/practice/BreakingTheRecords.java ) 
    
    * [SubarrayDivision](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/practice/SubarrayDivision.java ) 
    
    * [DayoftheProgrammer](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/practice/DayoftheProgrammer.java ) -> 문제 지문을 이해하는데 집중하면 난이도 최하문제
    
      

------



* ### <a href="https://app.codility.com/programmers/"> 코딜리티</a>

  * #### Iterations

    * [BinaryGap](https://github.com/chaminhye/Algorithm/blob/master/src/codility/iterations/BinaryGap.java)

  * #### Arrays

    * [CycleRotation](https://github.com/chaminhye/Algorithm/blob/master/src/codility/arrays/CycleRotation.java)

  * #### Sorting

    * [Distinct](https://github.com/chaminhye/Algorithm/blob/master/src/codility/sorting/Distinct.java)
    * [MaxProductOfThree](https://github.com/chaminhye/Algorithm/blob/master/src/codility/sorting/MaxProductOfThree.java)

  * #### Greedy

    * [MaxNonoverlappingSegments](https://github.com/chaminhye/Algorithm/blob/master/src/codility/greedy/MaxNonoverlappingSegments.java)
    * [TieRopes](https://github.com/chaminhye/Algorithm/blob/master/src/codility/greedy/TieRopes.java)

