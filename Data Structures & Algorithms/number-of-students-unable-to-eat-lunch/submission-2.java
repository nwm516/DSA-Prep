/*
queue.peek() - view front without removing 
queue.offer(val) - enqueue (adds to the back)
queue.poll() - dequeue (removes from the front)
*/

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Queue<Integer> sQ = new LinkedList<>();

        for (int student : students){
            sQ.offer(student);
        }

        int hungry = n;
        for (int sandwich : sandwiches){
            int count = 0;
            while (count < hungry && sQ.peek() != sandwich){
                sQ.offer(sQ.poll());
                count++;
            }

            if (sQ.peek() == sandwich){
                sQ.poll();
                hungry--;
            } else {
                break;
            }
        }
        return hungry;
        
    }
}