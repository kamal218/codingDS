public class client{
    public static void main(String[] args){
        Trie myDictionary = new Trie();
        String[] words={"the","they","them","there","their","tree","tree","tree","tree","trie","make","made","free","fly","year","yes","yet"};
        for(int i=0;i<words.length;i++){
            myDictionary.insert(words[i]);
        }
        System.out.println(myDictionary.search("tree"));
        System.out.print(myDictionary.search("ther")+"\n"+myDictionary.isPrefix("ther"));
    }
}