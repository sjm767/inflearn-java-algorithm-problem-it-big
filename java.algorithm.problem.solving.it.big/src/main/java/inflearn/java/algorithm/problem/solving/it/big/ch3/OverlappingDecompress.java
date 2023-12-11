package inflearn.java.algorithm.problem.solving.it.big.ch3;

import java.util.Stack;

/**
 * 2. 겹쳐진 압축 해제
 */
public class OverlappingDecompress {
  public static String solution(String s){
    String answer = "";

    String word="";
    int ct = 0;
    Stack<Character> stack = new Stack<>();

    for (Character c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        ct = Integer.parseInt(c + "");
      }
      else if(c=='('){
        for (int i = 0; i < ct; i++) {
          stack.push('(');
        }
      } else if (Character.isAlphabetic(c)) {
        stack.push(c);
      }
    }



    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution("2(ab)k3(bc)"));
    System.out.println(solution("3(a2(b))ef"));
//    System.out.println(solution("2(ab)k3(bc)"));
//    System.out.println(solution("2(ab3((cd)))"));
//    System.out.println(solution("2(2(ab)3(2(ac)))"));
//    System.out.println(solution("3(ab2(sg))"));
  }
}
