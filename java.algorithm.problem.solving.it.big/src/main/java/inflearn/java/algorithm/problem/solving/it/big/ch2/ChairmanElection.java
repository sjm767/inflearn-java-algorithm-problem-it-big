package inflearn.java.algorithm.problem.solving.it.big.ch2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 5. 회장 선거
 */
public class ChairmanElection {

  private static void addSupporter(Map<String,List<String>> supporterMap,String key, String value){
    if(supporterMap.containsKey(key)){
      supporterMap.get(key).add(value);
    }else{
      List<String> list = new ArrayList<>();
      list.add(value);

      supporterMap.put(key, list);
    }

  }
  public static String solution(String[] votes, int k){
    String answer = " ";

    Map<String, Integer> candidateMap = new HashMap<>();
    Map<String, List<String>> supporterMap = new HashMap<>();
    Map<String, Integer> presentMap = new HashMap<>();
    List<String> result = new ArrayList<>();

    for (String v : votes) {
      String[] s = v.split(" ");
      String supporter = s[0];
      String candidate = s[1];

      candidateMap.put(candidate, candidateMap.getOrDefault(candidate,0)+1);
      addSupporter(supporterMap, candidate, supporter);

    }


    for(String candidate : candidateMap.keySet()){
      Integer ct = candidateMap.get(candidate);


      if(ct >= k){
        List<String> supporters = supporterMap.get(candidate);

        for (String s : supporters) {
          presentMap.put(s,presentMap.getOrDefault(s,0)+1);
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for (String p : presentMap.keySet()) {
      Integer ct = presentMap.get(p);
      if(max < ct){
        max = ct;
      }
    }
    for (String p : presentMap.keySet()) {
      if (presentMap.get(p) == max) {
        result.add(p);
      }
    }

    Collections.sort(result);
    return result.get(0);
  }


  public static void main(String[] args){
    System.out.println(solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
    System.out.println(solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
    System.out.println(solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
    System.out.println(solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
  }
}
