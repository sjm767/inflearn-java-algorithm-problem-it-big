package inflearn.java.algorithm.problem.solving.it.big.ch3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 7. 가장 많이 사용된 회의실
 */
public class MostUsedMeetingRoom {

  static class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
      return this.start - o.start;
    }
  }

  public static int solution(int n, int[][] meetings){
    int answer = 0;
    int m = meetings.length;

    Map<Integer, Integer> roomState = new HashMap<>();
    Map<Integer, Integer> roomUsedCt = new HashMap<>();
    Map<Integer, Integer> meetingMap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      roomState.put(i, 0);
      roomUsedCt.put(i, 0);
    }

    for (int i = 0; i < m; i++) {
      meetingMap.put(meetings[i][0],meetings[i][1]);
    }

    Queue<Meeting> queue = new PriorityQueue<>();

    int time = 0;
    for (;; time++) {
      Integer mtEnd = meetingMap.get(time);

      if (meetingMap.size() == 0 && queue.isEmpty()) {
        break;
      }

      if(mtEnd != null){
        queue.add(new Meeting(time, mtEnd));
        meetingMap.remove(time);
      }

      List<Integer> emptyRooms = new ArrayList<>();
      for (Integer rs : roomState.keySet()) {
        Integer endTime = roomState.get(rs);
        if(endTime <= time){
          emptyRooms.add(rs);
        }
      }

      for (Integer em : emptyRooms) {
        if (!queue.isEmpty()) {
          Meeting mt = queue.poll();
          int length = mt.end - mt.start;
          mt.start = time;
          mt.end = time + length;
          roomState.put(em, mt.end);
          roomUsedCt.put(em,roomUsedCt.getOrDefault(em,0)+1);
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (Integer key : roomUsedCt.keySet()) {
      if (max < roomUsedCt.get(key)) {
        max = roomUsedCt.get(key);
        answer = key;
      }
    }

    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    System.out.println(solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    System.out.println(solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
    System.out.println(solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
  }

}
