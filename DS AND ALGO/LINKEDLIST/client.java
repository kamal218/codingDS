public class client {
    public static void main(String args[]) {
        linkedlist ll = new linkedlist();
        for (int i = 1; i <= 10; i++)
            ll.addLast(i * 10);
        // ll.addAt(30,10); Index outOfBounds
        // ll.reverseByData(); //REVERSAL BY VALUE
        ll.reverseList();
        System.out.print(ll);
    }
}