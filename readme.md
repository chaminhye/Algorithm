# Algorithm 문제 풀이

JAVA를 이용한 문제풀이



## Algorithm 개념

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



## Index

* ### <a href="https://programmers.co.kr/learn/challenges "> programmers</a>(실제 코딩테스트에 나올 난이도)

  

  * ####  [해시](https://programmers.co.kr/learn/courses/30/parts/12077)  

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

  * #### [완전탐색](https://programmers.co.kr/learn/courses/30/parts/12230)

    ( 나름 가장 수월하게 풀었던 파트)

    * [모의고사](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/bruteForce/PracticeTest.java )  
    * [소수](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/bruteForce/PrimeNumber.java )  
    * [카펫](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/bruteForce/Carpet.java )  

  * #### [탐욕법](https://programmers.co.kr/learn/courses/30/parts/12244)★★★

    * [체육복](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/greedy/GymClothes.java )  
    * [조이스틱](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/bruteForce/Joystick.java )  -> 생각보다 다양한 패턴으로 많이 출제됨!  알파벳 계산하여 출제되는 문제 ★★
    * [구명보트](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/bruteForce/Lifeboat.java )  

    

  * #### [동적계획법](https://programmers.co.kr/learn/courses/30/parts/12263)★★★

    -> 풀이를 봐도,,,,이해가 안되는 부분이 많아 집중공부할 예정

    

  * #### [깊이/너비 우선 탐색(DFS/BFS)](https://programmers.co.kr/learn/courses/30/parts/12421) ★★★★★		

     -> 풀이를 보고 푸는 방법을 참고하여 문제 풀이 진행

    * [타겟 넘버](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/dfs/TargetNumber.java )  		
    * [네트워크](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/dfs/Network )  	
    * [단어 변환](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/dfs/WordConversion.java )  	
    * [여행 경로](https://github.com/chaminhye/Algorithm/blob/master/src/programmers/dfs/TravelRoute.java )  	-> 정렬하는 부분이 keyPoint

------

* ### <a href="https://www.hackerrank.com/domains/java"> hackerrank</a> (기본기 다지기 좋음)

  * #### Strings ( 정규식을 잘 이용하면, 문제 풀이 수월함)

    * [Anagrams](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/Anagrams.java )  

    * [RegexIP ](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/RegexIP .java )   > 정규식 표현을 이용

    * [StringCompare](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/StringCompare.java )  

    * [StringReverse](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/StringReverse.java )  

    * [StringTokens ](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/Strings/StringTokens .java )   > 정규식 표현을 이용

      

  * #### BigDecimal

    * [BigNumber](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/BigDecimal/BigNumber.java )
    * [PrimalityTest](https://github.com/chaminhye/Algorithm/blob/master/src/hackerRank/BigDecimal/PrimalityTest.java )



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

