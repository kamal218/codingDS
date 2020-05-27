import java.util.ArrayList;
import java.util.HashMap;

public class leetCodeString {

    public static void main(String[] args) {
        questions();
    }

    public static void questions() {
        /*
         * // LEETCODE 1108 System.out.println(defangIPaddr("1.1.1.1"));
         */
        /*
         * // LEETCODE 1221 System.out.println(balancedStringSplit("RLRRLLRLRL"));
         */
        /*
         * // LEETCODE 709 System.out.println(toLowerCase("Hello"));
         */
        // LEETCODE 1436
        // System.out.println(destCity(paths));
        // LEETCODE
        /*
         * String s = "10#12"; System.out.println(freqAlphabets(s));
         */
        // LEETCODE 1374
        /*
         * System.out.println(generateTheString(300));
         */
        // LEETCODE
        /*
        System.out.println(sortString("aaabbdbbbffg"));
        */
        // LEETCODE 657
        System.out.println(judgeCircle("UUDDRL"));

    }

    public static String defangIPaddr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                // sb.append('[');
                // sb.append('.');
                // sb.append(']');
                sb.append("[.]");
            } else {
                sb.append(str.charAt(i));
            }
        }
        String ans = sb.substring(0, sb.length());
        return ans;
    }

    public static int balancedStringSplit(String s) {
        int ans = 0, r = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                l++;
            else
                r++;
            if (l == r)
                ans++;
        }
        return ans;
    }

    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch - 'A' <= 26 && ch - 'A' >= 0)
                ch += 32;
            sb.append(ch);
        }
        String ans = sb.substring(0);
        return ans;
    }

    public static String destCity(ArrayList<ArrayList<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < paths.size(); i++)
            map.put(paths.get(i).get(0), 1);
        for (int i = 0; i < paths.size(); i++) {
            if (!map.containsKey(paths.get(i).get(1)))
                return paths.get(i).get(1);
        }
        return "";
    }

    public static String freqAlphabets(String s) {
        String ans = "";
        for (int i = s.length() - 1; i >= 0;) {
            char ch = s.charAt(i);
            if (ch == '#') {
                int c = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                ch = (char) ('a' + c - 1);
                i -= 3;
            } else {
                ch = (char) ('a' + (ch - '1'));
                i--;
            }
            ans = ch + "" + ans;
        }
        return ans;
    }

    public static String generateTheString(int n) {
        StringBuilder ans = new StringBuilder();
        if (n % 2 == 0) {
            while (n != 1) {
                ans.append((char) 'a');
                n--;
            }
            ans.append((char) 'b');
        } else {
            while (n != 0) {
                ans.append((char) 'b');
                n--;
            }
        }

        return ans.toString();
    }

    public static String sortString(String s) {
        int[] ch = new int[26];
        int max_ = 0;
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a']++;
            max_ = Math.max(ch[s.charAt(i) - 'a'], max_);
        }
        StringBuilder sb = new StringBuilder();
        Boolean left = true;
        for (int j = 0; j < max_; j++) {
            if (left) {
                for (int i = 0; i < ch.length; i++) {
                    if (ch[i] != 0) {
                        char c = (char) ('a' + i);
                        sb.append(c);
                        ch[i]--;
                    }
                }
                left = false;
            } else {
                for (int i = ch.length - 1; i >= 0; i--) {
                    if (ch[i] != 0) {
                        char c = (char) ('a' + i);
                        sb.append(c);
                        ch[i]--;
                    }
                }
                left = true;
            }
        }
        return sb.toString();
    }

    public static boolean judgeCircle(String moves) {
        int up = 0, right = 0;
        char ch;
        for (int i = 0; i < moves.length(); i++) {
            ch = moves.charAt(i);
            if (ch == 'U') {
                up++;
            } else if (ch == 'D') {
                up--;
            } else if (ch == 'R') {
                right++;
            } else {
                right--;
            }
        }
        if (up == 0 && right == 0)
            return true;
        return false;
    }
}