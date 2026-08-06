/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
          PriorityQueue<ListNode> queue=new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode dummy=new ListNode();
        ListNode tail=dummy;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null) {
                queue.offer(lists[i]);
            }
        }
        while (!queue.isEmpty()) {
            ListNode samllest=queue.poll();
            tail.next=samllest;
            tail=tail.next;
            if (samllest.next!=null) {
                queue.offer(samllest.next );
            }
        }
        return dummy.next;
    }
}