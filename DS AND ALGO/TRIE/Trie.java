public class Trie{

    public class Node{
      int wordEnd=0;
      Node[] children;
      
      public Node(){
        this.children=new Node[26];
        this.wordEnd=0;
      }

    }
    Node root=new Node();

    public void insert(String str){
        Node curr=root;
        if(curr==null)
        curr=new Node();
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(curr.children[idx]==null)
            curr.children[idx]=new Node();
            curr=curr.children[idx];
        }
        curr.wordEnd++;
    }

    public int search(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(curr.children[idx]==null){
            System.out.print("Word doesnot exist");
            return -1;
            }
            curr=curr.children[idx];
        }
        if(curr.wordEnd==0){
            System.out.print("Word doesnot exist ");
            return -1;  
        }
        return curr.wordEnd;
    }

    public boolean isPrefix(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(curr.children[idx]==null)
            return false;
            curr=curr.children[idx];
        }
        return true;
    }

}