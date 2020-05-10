import java.util.LinkedList;
public class questions
{
    public static void main(String args[])
    {
        solve();
    }
    public static void solve()
    {
        middle();
    }
     public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        ListNode forw=null;
        while(curr!=null)
        {
            forw=curr.next;
            curr.next=prev;
            
            prev=curr;
            curr=forw;
        }
        head=prev;
        return head;
    }
     public ListNode middleBySize(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return fast.next==null?slow:slow.next;
    }
    public ListNode middlByIdx(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null || fast.next!=null || fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
     public boolean isPalindrome(ListNode head) { 
        if(head==null || head.next==null )
        return true;                                        //call middleByIdx
        ListNode mid=middleByIdx(head);
        ListNode nhead=mid.next; 
         mid.next=null;
         nhead=reverseList(nhead);
        while(head!=null && nhead!=null)
        {
            if(head.val!=nhead.val)
            return false;
            head=head.next;
            nhead=nhead.next;
        }
        return true;
    }
}