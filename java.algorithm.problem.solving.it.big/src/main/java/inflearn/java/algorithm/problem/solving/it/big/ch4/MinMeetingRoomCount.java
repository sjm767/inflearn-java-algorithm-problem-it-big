package inflearn.java.algorithm.problem.solving.it.big.ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 7. 최소 회의실 개수
 */
public class MinMeetingRoomCount {

  public static int solution(int[][] meetings){
    ArrayList<int[]> list = new ArrayList<>();
    for(int[] x : meetings){
      list.add(new int[]{x[0], 1});
      list.add(new int[]{x[1], 2});
    }
    list.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    int answer = 0, cnt = 0;
    for(int[] x : list){
      if(x[1] == 1) cnt++;
      else cnt--;
      answer = Math.max(answer, cnt);
    }
    return answer;
//    int answer = 0;
//    int n = meetings.length;
//    int max = Integer.MIN_VALUE;
//    Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//    Queue<Integer> queue = new PriorityQueue<>();
//
//    for (int i = 0; i < n; i++) {
//      int s = meetings[i][0];
//      int e = meetings[i][1];
//
//      if (queue.isEmpty()) {
//        queue.add(e);
//        max = Math.max(queue.size(), max);
//      } else {
//        if(queue.peek() > s){
//          queue.add(e);
//          max = Math.max(queue.size(), max);
//        } else{
//          queue.poll();
//          queue.add(e);
//        }
//      }
//    }
//    return max;
  }

  public static void main(String[] args){
//    System.out.println(solution(new int[][]{{0, 10}, {12, 25}, {5, 15}}));
//    System.out.println(solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
    System.out.println(solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
//    System.out.println(solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
  }
}
