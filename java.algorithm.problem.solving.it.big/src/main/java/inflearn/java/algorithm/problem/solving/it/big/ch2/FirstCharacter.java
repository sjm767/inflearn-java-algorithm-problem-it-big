package inflearn.java.algorithm.problem.solving.it.big.ch2;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 한 번 사용한 최초 문자
 */
public class FirstCharacter {
  public static int solution(String s){
    int answer = -1;
    Map<Character, Integer> map = new HashMap<>();

    for (Character c : s.toCharArray()) {
      map.put(c,map.getOrDefault(c,0)+1);
    }

    for (int i=0;i<s.length();i++) {
      Integer ct = map.get(s.charAt(i));
      if(ct == 1){
        return i+1;
      }
    }

    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution("statitsics"));
    System.out.println(solution("aabb"));
    System.out.println(solution("stringshowtime"));
    System.out.println(solution("abcdeabcdfg"));
  }
}
