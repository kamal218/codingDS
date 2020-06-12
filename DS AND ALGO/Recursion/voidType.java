import java.util.Arrays;
public class voidType {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        basicQuestions();
    }

    public static void basicQuestions() {
        // STRING TYPE
        // removeHi("ihihihiiiihhi", "");
        // removeHiWithoutHit("hithithithiiih", "");
        // compression("aaaaabbbbdddfrfrfffrtttt", "", 1);
        // removeConsecutive("aaaaabbbdddcccgggggggggggg","");
        // subsequences("abc", "");
        // permutation("aab", "");
        System.out.println(permutationWithoutRepetition("aabb", ""));
        
    }

    public static void removeHi(String str, String ans) {
        if (str.length() <= 1) {
            ans += str;
            System.out.print(ans);
            return;
        }
        if (str.length() > 1 && str.substring(0, 2).equals("hi"))
            removeHi(str.substring(2), ans);
        else
            removeHi(str.substring(1), ans + str.charAt(0));
    }

    public static void removeHiWithoutHit(String str, String ans) {
        if (str.length() <= 1) {
            ans += str;
            System.out.print(ans + " ");
            return;
        }
        if (str.length() > 2 && str.substring(0, 3).equals("hit"))
            removeHiWithoutHit(str.substring(3), ans + "hit");
        else if (str.length() >= 2 && str.substring(0, 2).equals("hi"))
            removeHiWithoutHit(str.substring(2), ans);
        else
            removeHiWithoutHit(str.substring(1), ans + str.charAt(0));
    }

    public static void compression(String str, String ans, int count) {
        if (str.length() <= 1) {
            ans += count == 1 ? str : str + count;
            System.out.print(ans + " ");
            return;
        }
        if (str.charAt(0) == str.charAt(1)) {
            compression(str.substring(1), ans, count + 1);

        } else {
            compression(str.substring(1), ans + str.charAt(0) + (count == 1 ? "" : count), 1);
        }
    }

    public static void removeConsecutive(String str, String ans) {
        if (str.length() <= 1) {
            ans += str;
            System.out.print(ans + " ");
            return;
        }
        if (str.charAt(0) == str.charAt(1))
            removeConsecutive(str.substring(1), ans);
        else
            removeConsecutive(str.substring(1), ans + str.charAt(0));
    }

    public static void subsequences(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        subsequences(str.substring(1), ans + str.charAt(0));
        subsequences(str.substring(1), ans);
    }

    public static void permutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(0, i) + str.substring(i + 1);
            permutation(sub, ans + str.charAt(i));
        }
    }

    public static int permutationWithoutRepetition(String str,String ans){
        if(str.length()==0){
            System.out.print(ans+" ");
            return 1;
        }
        Boolean[] map=new Boolean[26];
        int count=0;
        Arrays.fill(map,false);
        for(int i=0;i<str.length();i++){
            if( !map[str.charAt(i)-'a']){
            map[str.charAt(i)-'a']=true;
            String sub=str.substring(0,i)+str.substring(i+1);
            count+=permutationWithoutRepetition(sub, ans+str.charAt(i));
            }
        }
        return count;
    }
}