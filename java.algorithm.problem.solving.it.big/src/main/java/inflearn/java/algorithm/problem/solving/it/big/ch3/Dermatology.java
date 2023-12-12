package inflearn.java.algorithm.problem.solving.it.big.ch3;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 5. 피부과
 */
public class Dermatology {

  public static int getTime(String time){
    int H = Integer.parseInt(time.split(":")[0]);
    int M = Integer.parseInt(time.split(":")[1]);
    return H*60+M;
  }
  public static int solution(int[] laser, String[] enter){
    int answer = 0;
    Queue<Integer> queue = new PriorityQueue<>();

    for (int i = 0; i < enter.length; i++) {
      String[] e = enter[i].split(" ");
      int currentTime = getTime(e[0]);
      int length = laser[Integer.parseInt(e[1])];
      int endTime = currentTime + length;


      while (!queue.isEmpty() && queue.peek() <= currentTime) {
        queue.poll();
      }
      answer = Math.max(answer, queue.size());
      queue.add(endTime);
    }

    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
    System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
    System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
  }
}
