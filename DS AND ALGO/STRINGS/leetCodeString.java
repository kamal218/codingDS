import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
         * String s = "I speak Goat Latin"; System.out.println(toGoatLatin(S));
         */
        // LEETCODE 1189
        /*
         * System.out.println(maxNumberOfBalloons("nlaebolko"));
         */
        // LEETCODE1408
        /*
         * Strings[] words = { "leetcoder", "leetcode", "od", "hamlet", "am" };
         * System.out.println(stringMatching(words));
         */
        // LEETCODE 1170
        /*
         * String[] queries = { "cbd" }; String[] words = { "zaaaz" };
         * display1D(numSmallerByFrequency(queries, words));
         */
        // LEETCODE
        /*
         * System.out.println(lengthOfLastWord("a   b   m"));
         * System.out.println(lengthOfLastWordBest("a  f  f  fffk"));
         */
        // LEETCODE
        /*
         * System.out.println(strStr("aa", "a"));
         */
        // LEETCODE
        /*
         * String[] strs = { "aa", "b" }; System.out.println(longestCommonPrefix(strs));
         */
        // LEETCODE 125
        /*
         * System.out.println(isPalindrome("helll, .,leh"));
         */
        // LEETCODE 434
        /*
         * System.out.println(countSegments("Hello, my name is John"));
         */
        // LEETCODE917
        /*
         * System.out.println(reverseOnlyLetters("z<*zj"));
         */
        // LEETCODE 1417
        /*
         * System.out.println(reformat("abc123"));
         */
        // LEETCODE 696
        /*
         * System.out.println(countBinarySubstrings("00011001001"));
         */
        // LEETCODE 13
        /*
         * System.out.println(romanToInt("IV"));
         */
        // LEETCODE 1422
        /*
         * System.out.println(maxScore("100101"));
         */
        // LEETCODE 1071
        /*
         * System.out.println(gcdOfStrings("ABCABC", "ABC"));
         */
        // LEETCODE 520
        /*
         * System.out.println(detectCapitalUse("USZFRDSg"));
         */
        // LEETCODE 387
        /*
         * System.out.println(firstUniqCharMap("leetcode"));
         * System.out.println(firstUniqCharArray(s));
         */
        // LEETCODE 383
        /*
         * System.out.println(canConstruct("a", "ab"));
         * System.out.println(canConstructBetter("a", "ab"));
         */
        // LEETCODE 415
        /*
         * System.out.println(addStrings("45879658", "5747889625"));
         */
        // LEETCODE
        /*
        System.out.println(repeatedSubstringPattern("abcabcabc"));
        */
        // LEETCODE 345
        System.out.println(reverseVowels("hheifuhbftu"));
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
        HashSet<String> seen = new HashSet<>();
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

    public static ArrayList<String> stringMatching(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i] == words[j])
                    continue;
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int ct = 0, fr = 0;
        for (int i = 0; i < queries.length; i++) {
            ct = 0;
            fr = freq(queries[i]);
            System.out.println(fr);
            for (int j = 0; j < words.length; j++) {
                if (fr < freq(words[j]))
                    ct++;
            }
            ans[i] = ct;
        }
        return ans;
    }

    public static int freq(String str) {
        int ans = 0, min_ = 27;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch - 'a' < min_) {
                ans = 1;
                min_ = ch - 'a';
            } else if (ch - 'a' == min_)
                ans++;
        }
        return ans;
    }

    public static int lengthOfLastWord(String s) {
        int ans = 0, j = 0;
        for (int i = 0; i <= s.length(); i++) {

            while (i < s.length() & j < s.length() && s.charAt(j) == ' ') {
                i++;
                j++;
            }
            if ((i == s.length() || s.charAt(i) == ' ') && j < s.length()) {
                ans = (i - j);
                j = i + 1;
            }
        }
        return ans;
    }

    public static int lengthOfLastWordBest(String s) {
        int right = s.length() - 1;
        int ans = 0;
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ')
                right--;
            while (right >= 0 && s.charAt(right) != ' ') {
                right--;
                ans++;
            }
            break;
        }
        return ans;
    }

    public static int strStr(String h, String n) {
        if (h.length() < n.length())
            return -1;
        if (n.length() == 0)
            return 0;
        for (int i = 0; i <= h.length() - n.length(); i++) {
            if (i + n.length() <= h.length() && h.charAt(i) == n.charAt(0) && h.substring(i, i + n.length()).equals(n))
                return i;
        }
        return -1;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        char p;
        for (int i = 0; i < strs[0].length(); i++) {
            p = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || !(p == (strs[j].charAt(i))))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (j >= 0 && !Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j)))
                j--;
            else if (i < s.length() && !Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)))
                i++;
            else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static int countSegments(String s) {

        int ans = 0, j = 0;
        for (int i = 0; i <= s.length(); i++) {
            while (j < s.length() && s.charAt(j) == ' ') {
                i++;
                j++;
            }
            if ((i == s.length() || s.charAt(i) == ' ') && j - i != 0) {
                ans++;
                j = i + 1;
            }
        }
        return ans;
    }

    public static String reverseOnlyLetters(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        char a, b, ch;
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            a = sb.charAt(i);
            b = sb.charAt(j);
            if (a < 'A' || a > 'z' || (a > 'Z' && a < 'a')) {
                i++;
            } else if (b < 'A' || b > 'z' || (b > 'Z' && b < 'a')) {
                j--;
            } else {
                ch = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, ch);
                i++;
                j--;
            }

        }
        return sb.toString();
    }

    public static String reformat(String s) {
        if (s.length() == 0)
            return "";
        String ans = "";
        int ch = 0, dig = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)))
                ch++;
            else
                dig++;
        }
        if (Math.abs(ch - dig) > 1)
            return "";
        Boolean let = true;
        if (dig > ch)
            let = false;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (let == true) {
                if (Character.isLetter(s.charAt(i))) {
                    ans += s.charAt(i);
                    let = false;
                    ch--;
                }
                i++;
            } else {
                if (s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9) {
                    ans += s.charAt(j);
                    let = true;
                    dig--;
                }
                j++;
            }
        }
        if (dig != 0)
            ans += s.charAt(j);
        if (ch != 0)
            ans += s.charAt(i);

        return ans;
    }

    public static int countBinarySubstrings(String s) {
        if (s.length() == 0)
            return 0;
        Boolean zero = true;
        int ctz = 0;
        int cto = 0;
        int i = 0;
        if (s.charAt(0) - '0' == 0) {
            while (i < s.length() && s.charAt(i) - '0' != 1) {
                i++;
                ctz++;
            }
        } else {
            zero = false;
            while (i < s.length() && s.charAt(i) - '0' != 0) {
                i++;
                cto++;
            }
        }
        int ans = 0;
        while (i != s.length()) {
            if (zero) {
                cto = 0;
                while (i < s.length() && s.charAt(i) - '0' != 0) {
                    i++;
                    cto++;
                }
                ans += Math.min(ctz, cto);
                zero = false;
            } else {
                ctz = 0;
                while (i < s.length() && s.charAt(i) - '0' != 1) {
                    i++;
                    ctz++;
                }
                ans += Math.min(ctz, cto);
                zero = true;
            }
        }
        return ans;
    }

    public static int romanToInt(String s) {
        int ans = 0;
        int a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            b = 0;
            a = get(s.charAt(i));
            if (i + 1 < s.length())
                b = get(s.charAt(i + 1));
            if (a == b) {
                ans += a + b;
                i++;
            } else if (a > b)
                ans += a;
            else {
                ans += (b - a);
                i++;
            }
        }
        return ans;
    }

    int get(char i) {
        switch (i) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    int get1(char i) // better the switch case
    {
        if (i == 'I')
            return 1;
        else if (i == 'V')
            return 5;
        else if (i == 'X')
            return 10;
        else if (i == 'L')
            return 50;
        else if (i == 'C')
            return 100;
        else if (i == 'D')
            return 500;
        if (i == 'M')
            return 1000;
        return 0;
    }

    public static int maxScore(String s) {
        int ans = -1;
        int one = 0;
        int zero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == 1)
                one++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) - '0' == 0) {
                ++zero;
            } else {
                --one;
            }
            ans = Math.max(one + zero, ans);
        }
        return ans;
    }

    public static String gcdOfStrings(String str1, String str2) {

        int gcd = 0;
        gcd = str1.length() < str2.length() ? GCD(str1.length(), str2.length()) : GCD(str2.length(), str1.length());
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        return str1.substring(0, gcd);
    }

    public static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 0)
            return true;
        Boolean isCap = false;
        isCap = cap(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if (isCap) {
                if (!cap(word.charAt(i))) {
                    if (i > 1) // for "FFFFFc"
                        return false;
                    isCap = false;
                }
            } else {
                if (cap(word.charAt(i)))
                    return false;
            }
        }
        return true;
    }

    public static Boolean cap(char ch) {
        if (((ch - 'A') >= 0 && (ch - 'Z') <= 0))
            return true;
        return false;
    }

    public static int firstUniqCharMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static int firstUniqCharArray(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static boolean canConstruct(String r, String m) {
        int[] ran = new int[26];
        int[] mag = new int[26];
        for (char ch : r.toCharArray())
            ran[ch - 'a']++;
        for (char ch : m.toCharArray())
            mag[ch - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (ran[i] > mag[i])
                return false;
        }
        return true;
    }

    public static boolean canConstructBetter(String r, String m) {
        int[] mag = new int[26];
        for (char ch : m.toCharArray())
            mag[ch - 'a']++;
        for (int i = 0; i < r.length(); i++) {
            if (--mag[(r.charAt(i) - 'a')] < 0)
                return false;
        }
        return true;
    }

    public static String addStrings(String num1, String num2) {
        int carry = 0;
        String ans = "";
        int num = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            num = ((num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry);
            ans = (num % 10) + "" + ans;
            carry = num / 10;
            i--;
            j--;
        }

        if (i < 0) {
            while (j >= 0) {
                num = ((num2.charAt(j) - '0') + carry);
                ans = (num % 10) + "" + ans;
                carry = num / 10;
                j--;
            }
        }
        if (j < 0) {
            while (i >= 0) {
                num = ((num1.charAt(i) - '0') + carry);
                ans = (num % 10) + "" + ans;
                carry = num / 10;
                i--;
            }
        }
        if (i < 0 && j < 0 && carry != 0)
            ans = carry + ans;
        return ans;
    }

    public static boolean repeatedSubstringPattern(String s) {
        String str = "";
        for (int i = 0; i < s.length() / 2; i++) {
            str += s.charAt(i);
            if ((str + s).equals(s + str))
                return true;
        }
        return false;
    }

    public static String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;

        char[] arr = s.toCharArray();
        while (i < j) {
            if (vow(arr[i]) && vow(arr[j])) {
                char ch = arr[i];
                arr[i] = arr[j];
                arr[j] = ch;
                i++;
                j--;
            } else if (vow(arr[i]))
                j--;
            else if (vow(arr[j]))
                i++;
            else {
                i++;
                j--;
            }
        }
        return String.valueOf(arr);
    }

    public Boolean vow(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U')
            return true;
        return false;
    }

    // ***************************HELPER
    // FUNCTIONS********************************************/
    public static void display1D(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] mat) {
        for (int[] submat : mat) {
            for (int ele : submat) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void displayArrayList1D(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }

    public static void displayArrayList2D(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}