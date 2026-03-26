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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }

        // if(head.next==null){
        //     return null;
        // }

        int len=0;
        ListNode temp= head;
        while(temp!=null){
            len++;
            temp= temp.next;
        }

        if(n==len){
            return head.next;
        }

        ListNode lastSec= head;
        for(int i = 1; i < len - n; i++){
            lastSec= lastSec.next;
        }

        lastSec.next= lastSec.next.next;

        return head;
    }
}