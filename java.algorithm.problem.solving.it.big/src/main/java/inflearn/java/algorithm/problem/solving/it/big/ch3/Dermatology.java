package inflearn.java.algorithm.problem.solving.it.big.ch3;

import java.util.LinkedList;
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
    int n = enter.length;
    int[][] customers = new int[n][2];
    Queue<Integer> queue = new LinkedList<>();

    int idx = 0;
    for (String e : enter) {
      String[] eSplit = e.split(" ");
      int enterTime = getTime(eSplit[0]);
      int laserType = Integer.parseInt(eSplit[1]);

      customers[idx][0] = enterTime;
      customers[idx][1] = laserType;
      idx++;
    }

    int finishTime = customers[0][0];

    idx = 0;
    for (int currentTime = customers[0][0]; currentTime <=1200; currentTime++) {
      if(idx < n && customers[idx][0] == currentTime){
        if(queue.isEmpty() && finishTime < currentTime){
          finishTime = currentTime;
        }
        queue.add(customers[idx][1]);
        idx++;
      }

      if(finishTime == currentTime && !queue.isEmpty()){
        Integer q = queue.poll();
        finishTime = currentTime + laser[q];
      }
      answer = Math.max(queue.size(), answer);

    }

    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
    System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
    System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
  }
}
