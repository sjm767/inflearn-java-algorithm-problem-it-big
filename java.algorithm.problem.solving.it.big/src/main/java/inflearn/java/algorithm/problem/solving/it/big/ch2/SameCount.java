package inflearn.java.algorithm.problem.solving.it.big.ch2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2. 같은 빈도 수 만들기
 */
public class SameCount {

  public static int[] solution(String s){
    int[] answer = new int[5];

    Map<Character, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < 5; i++) {
      map.put((char) (i+97),0);
    }

    for (Character c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);

      if(map.get(c) > max){
        max = map.get(c);
      }
    }

    int idx = 0;
    for (Character c : map.keySet()) {
      Integer v = map.get(c);
      answer[idx++] = max - v;
    }


    return answer;
  }

  public static void main(String[] args){
    System.out.println(Arrays.toString(solution("aaabc")));
    System.out.println(Arrays.toString(solution("aabb")));
    System.out.println(Arrays.toString(solution("abcde")));
    System.out.println(Arrays.toString(solution("abcdeabc")));
    System.out.println(Arrays.toString(solution("abbccddee")));
  }
}
