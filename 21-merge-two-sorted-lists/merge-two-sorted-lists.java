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
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode dummy= new ListNode(-1);
//         ListNode curr= dummy;

//         while(list1!=null && list2!=null){

//         if(list1.val<=list2.val){
//             curr.next= list1;
//             list1= list1.next;
//         }

//         else{
//             curr.next= list2;
//             list2= list2.next;
//         }

//         curr= curr.next;
//         }

//           if(list1!=null){
//             curr.next= list1;
//         }

//         if(list2!=null){
//             curr.next= list2;
//         }
//         return dummy.next;
//     }
// }


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) 
        return list2;

        ListNode temp = list1;
        while(temp.next != null) 
        temp = temp.next;
        temp.next = list2;

        return sortList(list1);
    }

    private ListNode sortList(ListNode head){
        if(head == null || head.next == null) 
        return head;

        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        return merge(sortList(head), sortList(right));
    }

    private ListNode getMid(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(a != null && b != null){
            if(a.val <= b.val){
                curr.next = a;
                a = a.next;
            } 
            
            else {
                curr.next = b;
                b = b.next;
            }
            
            curr = curr.next;
        }

        curr.next = (a != null) ? a : b;
        return dummy.next;
    }
}