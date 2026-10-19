/*
queue.peek() - view front without removing 
queue.offer(val) - enqueue (adds to the back)
queue.poll() - dequeue (removes from the front)
*/

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;

        Queue<Integer> studentQ = new LinkedList<>();
        for (int student : students){
            studentQ.offer(student);
        }

        int rest = n;   // Initialized to entirety of students present
        for (int sandwich : sandwiches){
            int count = 0;      // counting through each sandwich in array

            while (count < rest && studentQ.peek() != sandwich){
                // while our count of mismatches is less than the rest
                // and while the first student in line doesn't match
                // the top sandwich
                studentQ.offer(studentQ.poll());
                count++;
            }

            if (studentQ.peek() == sandwich){
                studentQ.poll();
                rest--;
            } else {
                break;
            }
        }
        return rest;
    }
}