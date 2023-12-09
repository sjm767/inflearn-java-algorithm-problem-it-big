package inflearn.java.algorithm.problem.solving.it.big.ch2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 서로 다른 빈도수 만들기
 */
public class DifferentCount {
  public static int solution(String s){
    int answer = 0;
    Map<Character, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    for (Character c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (Character c : map.keySet()) {
      int v = map.get(c);

      while (set.contains(v) && v>=0) {
        v--;
        answer++;
      }

      if(v>0){
        set.add(v);
      }

    }

    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution("aaabbbcc"));
    System.out.println(solution("aaabbc"));
    System.out.println(solution("aebbbbc"));
    System.out.println(solution("aaabbbcccde"));
    System.out.println(solution("aaabbbcccdddeeeeeff"));
  }
}
