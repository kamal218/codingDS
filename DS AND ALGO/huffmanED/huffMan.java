import java.util.HashMap;
import java.util.PriorityQueue;

public class huffMan{

    HashMap<String,String> encode =new HashMap();

    HashMap<String,String> decode = new HashMap();

        public huffMan(String input){
            huffManTree(input);
        }

        public class Node implements Comparable<Node>{

            String bit="";
            Node left=null;
            Node right=null;
            int freq=0;
            String lossy="";

            public Node(){}

            public Node(String lossy,int freq,Node left,Node right){
                this.lossy=lossy;
                this.freq=freq;
                this.left=left;
                this.right=right;
            }

            @Override
            public int compareTo(Node o){
                return this.freq-o.freq;
            }

        }
        public void huffManTree(String str){

            int[] map=new int[26];

            for(int i=0;i<str.length();i++){
                map[str.charAt(i)-'a']++;
            }
            for(int i=0;i<map.length;i++){
                System.out.print(map[i]+" ");
            }
            System.out.println();

            PriorityQueue<Node> pq=new PriorityQueue();
            for(int i=0;i<map.length;i++){
                if(map[i]!=0)
                pq.add(new Node((char)(i+'a')+"",map[i],null,null));
            }

            while(pq.size()>1){
                Node first=pq.poll();
                Node second=pq.poll();
                Node nnode=new Node("("+first.lossy+")"+first.freq+"("+second.lossy+")"+second.freq,first.freq+second.freq,first,second);
                pq.add(nnode);
            }

            Node root= pq.peek();
            // System.out.print(root);
            huffManAssignBit(root);
            displayHuffmanTree(root);
        }
        // no node will have single child
        public void huffManAssignBit(Node node){

            if(node.left==null && node.right==null){
                encode.put(node.lossy,node.bit);
                decode.put(node.bit,node.lossy);
                return;
            }

            node.left.bit=node.bit+""+'0';
            huffManAssignBit(node.left);
            node.right.bit=node.bit+""+'1';
            huffManAssignBit(node.right);

        }

        public String encodeString(String input){
            for(String key: encode.keySet()){
                System.out.println(key+ " -> "+encode.get(key));
            }

            StringBuilder sb=new StringBuilder();

            for(int i=0;i<input.length();i++){
                if(encode.containsKey(input.charAt(i)+"")){
                sb.append(encode.get(input.charAt(i)+""));
                }
                else{
                System.out.print("Invalid String");
                return "";
                }
            }

            return sb.toString();
        }

        public String decodeString(String bit){

            StringBuilder sb=new StringBuilder();
            String find="";
            for(int j=0;j<bit.length();j++){
                find=find+bit.charAt(j);
                if(decode.containsKey(find)){
                    sb.append(decode.get(find));
                    find="";
                }
            }    

            return sb.toString();
        }

        public void displayHuffmanTree(Node root){
            if(root==null)
            return;
            if(root.left!=null)
            System.out.print(" lossy: "+root.left.lossy+" bit: "+root.left.bit+" -> ");
            System.out.print(" lossy: "+root.lossy+" bit: "+root.bit);
            if(root.right!=null)
            System.out.print(" <- "+" lossy: "+root.right.lossy+" bit: "+root.right.bit);
            System.out.println();
            displayHuffmanTree(root.left);
            displayHuffmanTree(root.right);
        }

}