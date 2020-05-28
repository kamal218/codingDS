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
         * System.out.println(sortString("aaabbdbbbffg"));
         */
        // LEETCODE 657
        /*
         * System.out.println(judgeCircle("UUDDRL"));
         */
        // LEETCODE
        /*
         * String[] emails = { "test.email+alex@leetcode.com",
         * "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" };
         * System.out.println(numUniqueEmails(emails));
         */
        // LEETCODE 344
        /*
         * char[] s = { "h", "e", "l", "l", "o" }; reverseString(s);
         */
        // LEETCODE 557
        /*
         * String s = "Let's Code Here"; System.out.println(reverseWords(s));
         */
        // LEETCODE
        /*
         * String sen = "i love eating burger"; STring word = "burg";
         * System.out.println(isPrefixOfWord(sen, word));
         */
        // LEETCODE 1446
        /*
         * String s = "abbcccddddeeeeedcba"; System.out.println(maxPower(s));
         */
        // LEETCODE824
        /*
        String s = "I speak Goat Latin";
        System.out.println(toGoatLatin(S));
        */
        // LEETCODE 1189
        System.out.println(maxNumberOfBalloons("nlaebolko"));


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

    public static int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet<>();
        for (String email : emails)
            seen.add(cleanEmail(email));
        return seen.size();
    }

    public static String cleanEmail(String dirtyEmail) {
        StringBuilder sb = new StringBuilder();
        boolean isLocal = true;
        int iter = -1;
        while (iter < dirtyEmail.length()) {
            iter++;
            char letter = dirtyEmail.charAt(iter);
            if (letter == '@') {
                break;
            } else if (!isLocal || letter == '.') {
                continue;
            } else if (letter == '+') {
                isLocal = false;
                continue;
            } else {
                sb.append(letter);
            }
        }
        sb.append(dirtyEmail.substring(iter));
        return sb.toString();
    }

    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static String reverseWords(String s) {
        int j = 0;
        String ans = "";
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                String str = s.substring(j, i);
                char[] ch = str.toCharArray();
                revString(ch);
                ans += String.valueOf(ch);
                j = i + 1;
                if (i != s.length())
                    ans += " ";
            }

        }
        return ans;
    }

    public static void revString(char[] str) {
        int i = 0, j = str.length - 1;
        while (i < j) {
            char ch = str[i];
            str[i] = str[j];
            str[j] = ch;
            i++;
            j--;
        }
    }

    public static int isPrefixOfWord(String sen, String word) {
        int w = 0;
        for (int i = -1; i < sen.length(); i++) {
            if (i == -1 || sen.charAt(i) == ' ') {
                w++;
                if (i + word.length() + 1 <= sen.length() && sen.substring(i + 1, i + word.length() + 1).equals(word))
                    return w;
            }
        }
        return -1;
    }

    public static int maxPower(String s) {
        int i = 0, j = 0;
        int ans = 0;
        while (j < s.length() && i < s.length()) {
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }

    public static String toGoatLatin(String S) {
        StringBuilder ans = new StringBuilder();
        String last = "a";
        int j = 0;
        for (int i = 0; i <= S.length(); i++) {
            if (i == S.length() || S.charAt(i) == ' ') {
                if (S.charAt(j) == 'a' || S.charAt(j) == 'e' || S.charAt(j) == 'i' || S.charAt(j) == 'o'
                        || S.charAt(j) == 'u' || S.charAt(j) == 'A' || S.charAt(j) == 'E' || S.charAt(j) == 'I'
                        || S.charAt(j) == 'O' || S.charAt(j) == 'U') {
                    ans.append(S.substring(j, i));
                    ans.append("ma");
                } else {
                    ans.append(S.substring(j + 1, i));
                    ans.append(S.charAt(j));
                    ans.append("ma");
                }
                ans.append(last);
                if (i != S.length())
                    ans.append(' ');
                j = i + 1;
                last += "a";
            }
        }
        return ans.toString();
    }

    public static int maxNumberOfBalloons(String text) {
        int[] arr = new int[256];
        for (char c : text.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        while (arr['b'] > 0 && arr['a'] > 0 && arr['l'] > 1 && arr['o'] > 1 && arr['n'] > 0) {
            count++;
            arr['b']--;
            arr['a']--;
            arr['l']--;
            arr['l']--;
            arr['o']--;
            arr['o']--;
            arr['n']--;
        }
        return count;

    }
}