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
    public ListNode removeElements(ListNode head, int data) {
        if (head == null)
            return null;
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        ListNode temp1 = dummy;
        while (temp != null) {
            if (temp.val != data) {
                temp1.next = temp;
                temp1 = temp1.next;
            }
            temp = temp.next;
            temp1.next=null;
        }
        return dummy.next;
    }
}