import java.util.NoSuchElementException;
public class linkedlist
{
    private class Node
    {
        int data=0;
        Node next=null;
        Node()
        {
        }
        Node(int data)
        {
        this.data=data;
        }
        @Override
        public String toString()
        {
            return this.data+"";
        }
    }
    private Node head=null;
    private Node tail=null;
    int nodecount=0;
    //****************OVERRIDING to_string******************/
    @Override
    public String toString()
    {
        if(this.nodecount==0)
        return "[]";
        StringBuilder str=new StringBuilder();
        str.append("[");
        Node curr=this.head;
        while(curr.next!=null)
        {
            str.append(curr+",");
            curr=curr.next;
        }
        str.append(curr+"]");
        return str.toString();
    }
    //*************BASIC FUNCTIONS*******************//
    int size()
    {
        return this.nodecount;
    }
    boolean isEmpty()
    {
        return this.nodecount==0;
    }
    Node getNodeAt(int idx)
    {
        if(idx<0 || idx>=this.nodecount)
         throw new NullPointerException();
        Node curr=this.head;
        while(idx-->0)
        curr=curr.next;
        return curr;
    }
    /*****************************GET********************/
    int getFirst()
    {
        if(this.nodecount==0)
         throw new NoSuchElementException();
        return this.head.data; 
    }
    int getLast()
    {
        if(this.nodecount==0)
         throw new NoSuchElementException();
        return this.tail.data;
    }
    int getAt(int idx)
    {
        if(idx<0 || idx>=nodecount)
         throw new NullPointerException();
        return getNodeAt(idx).data;
    }
    //*************************ADD NODE*********************//
    void addFirstNode(Node node)
    {
        if(this.nodecount==0)
        {

            this.tail=node;
        }
        node.next=this.head;
        this.head=node;
        this.nodecount++;
    }
    void addFirst(int data)
    {
        Node node=new Node(data);
        addFirstNode(node);
    }
    void addLastNode(Node node)
    {
        if(this.nodecount==0)
        {
            this.head=node;
            this.tail=node;
        }
        else{
        this.tail.next=node;
        this.tail=node;
        }
        this.nodecount++;
    }
    void addLast(int data)
    {
        Node node=new Node(data);
        addLastNode(node);
    }
    void addAtNode(Node node,int idx)
    {
        if(idx==0)
        addFirstNode(node);
        else if(idx==this.nodecount)
        addLastNode(node);
        else
        {
            Node prev=getNodeAt(idx-1);
            Node forw=prev.next;

            prev.next=node;
            node.next=forw;
            this.nodecount++;
        }
    }
    void addAt(int idx,int data)
    {
        if(idx<0 || idx>this.nodecount)
        {
        System.out.print("Index out of bounds");
        return;
        }
        Node node=new Node(data);
        addAtNode(node,idx);
    }
    //**************************REMOVE NODE*******************************//
    Node removeFirstNode()
    {
        Node rn=this.head;
        if(this.nodecount==1)
        {
            this.head=null;
            this.tail=null;
        }
        else
        {
            this.head=this.head.next;
        }
        rn.next=null;
        this.nodecount--;
        return rn;
    }
    int removeFirst()
    {
        if(this.nodecount==0)
         throw new NoSuchElementException();
        return removeFirstNode().data;
    }
    Node removeLastNode()
    {
        Node rn=this.tail;
        if(this.nodecount==1)
        {
            this.tail=null;
            this.head=null;
        }
        else
        {
            Node secondlast=getNodeAt(this.nodecount-1);
            secondlast.next=null;
            this.tail=secondlast;
        }
        this.nodecount--;
        return rn;
    }
    int removeLast()
    {
        if(this.nodecount==0)
         throw new NoSuchElementException();
        return removeLastNode().data;
    }
    Node removeAtNode(int idx)
    {
        
        if(idx==0)
        return removeFirstNode();
        else if(idx==this.nodecount)
        return removeLastNode();
        else
        {
            Node prev=getNodeAt(idx-1);
            Node forw=prev.next.next;
            Node rn=prev.next;
            rn.next=null;
            prev.next=forw;
            this.nodecount--;
            return rn;
        }
        
    }
    int removeAt(int idx)
    {
        if(idx<0 || idx>=this.nodecount-1);
        return removeAtNode(idx).data;
    }
    //*******************REVERSAL**************************//
    void reverseByData()
    {
        if(this.nodecount<2)
        return;
        int si=0;
        int ei=this.nodecount-1;
        while(si<=ei)
        {
         Node first=getNodeAt(si);
         Node last=getNodeAt(ei);
         int temp=first.data;
         first.data=last.data;
         last.data=temp;            //or //first=first.next and initially first=head;
         si++;
         ei--;
        }
        return;
    }
    void reverseList()
    {
        Node prev=null;
        Node curr=this.head;
        Node forw=null;
        while(curr!=null)
        {
            forw=curr.next; //backup
            curr.next=prev;

            prev=curr;
            curr=forw;
        }
        this.tail=this.head;
        this.head=prev;
    }
}