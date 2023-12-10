package inflearn.java.algorithm.problem.solving.it.big.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 6. 문서 도난
 */
public class DocumentSteal {

  static class Person implements  Comparable<Person>{
    String name;

    int minute;

    public Person(String name, int minute) {
      this.name = name;
      this.minute = minute;
    }

    @Override
    public int compareTo(Person o) {
      return this.minute - o.minute;
    }
  }
  public static String[] solution(String[] reports, String times){
    String[] answer = {};
    List<String> result = new ArrayList<>();
    int startH;
    int startM;
    int endH;
    int endM;

    String[] time = times.split(" ");
    String[] startTime = time[0].split(":");
    String[] endTime = time[1].split(":");

    startH = Integer.parseInt(startTime[0]);
    startM = (startH * 60) + Integer.parseInt(startTime[1]);
    endH = Integer.parseInt(endTime[0]);
    endM = (endH * 60) + Integer.parseInt(endTime[1]);

    List<Person> personList = new ArrayList<>();

    for (String r : reports){
      String[] s = r.split(" ");
      int pHour = Integer.parseInt(s[1].split(":")[0]);
      int pMinute = (pHour * 60) + Integer.parseInt(s[1].split(":")[1]);

      personList.add(new Person(s[0], pMinute));
    }

    Collections.sort(personList);

    for (Person person : personList){
      if (person.minute >= startM && person.minute <= endM) {
        result.add(person.name);
      }
    }

    return result.toArray(answer);
  }

  public static void main(String[] args){
    System.out.println(Arrays.toString(solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
    System.out.println(
        Arrays.toString(solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
    System.out.println(Arrays.toString(solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
  }
}
