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
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        
        //All the nodes which are less than x will be in this list
        //Stores the head of list and initialized with dummy nodes
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        
        //All the nodes greater or equal to x will be in this list
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;
        
        while(head != null){
            
            //If the value of node is < x then add it to before list as it should come before node of x
            if(head.val < x){
                
                before.next = head;
                before = before.next;
            }
            //If the value of node is >= x then add it to after list as it should come after smaller than x nodes
            else{
                
                after.next = head;
                after = after.next;
            }
            
            head = head.next;
        }
        
        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;
        
        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = afterHead.next;
        
        return beforeHead.next;
        
        
    }
}
