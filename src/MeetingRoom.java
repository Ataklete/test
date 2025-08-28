/*
* Given n meetings in the form of start[] and end[], where start[i] is the start time of ith meeting and end[i] is the end time of ith meeting. The task is to print the meeting number of all the meetings which can be held in a single room such that total number of meetings held is maximized. The meeting room can have only one meeting at a particular time.

Note: The start time of one chosen meeting can't be equal to the end time of any other chosen meeting.

Examples:

Input: start[] = {1, 3, 0, 5, 8, 5}, end[] = {2, 4, 6, 7, 9, 9}
Output: 1 2 4 5
Explanation: We can attend the 1st meeting from (1 to 2), then the 2nd meeting from (3 to 4), then the 4th meeting from (5 to 7), and the 5th meeting from (8 to 9).

Input: start[] = {10, 12, 20}, end[] = {20, 25, 30}
Output: 1
Explanation: We can attend at most one meeting in a single meeting room.
*
*
*
*
* */

import java.util.*;

public class MeetingRoom {

    /*******************the other way to find position of the meeting using Meeting Object*********************************
    * class Meeting {
    int startTime, endTime, pos;

    Meeting(int startTime, int endTime, int pos) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.pos = pos;
    }
}

// Custom comparator to compare meetings according to end time
class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting m1, Meeting m2) {
        return Integer.compare(m1.endTime, m2.endTime);
    }
}
    * */

    public static Map<Integer, Integer> maxMeetingRooms(List<Integer> start, List<Integer> end) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < start.size()-1; i++) {
            map.put(start.get(i), end.get(i));
        }
        int nextStart = 0;
        Map<Integer, Integer> result = new TreeMap<>();
        for (Map.Entry<Integer, Integer> s : map.entrySet()){
            if (s.getKey() > nextStart) {
                nextStart = s.getValue();
                result.put(s.getKey(), s.getValue());
                result.put(s.getKey(), s.getValue());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> start = Arrays.asList(1, 3, 0, 5, 8, 5);
        List<Integer> end = Arrays.asList(2, 4, 6, 7, 9, 9);

        Map<Integer, Integer> res = maxMeetingRooms(start, end);
        for (Map.Entry<Integer, Integer> meeting : res.entrySet()) {
            System.out.println(meeting + " ");
        }
    }
}
