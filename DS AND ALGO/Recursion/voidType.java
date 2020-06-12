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
        // System.out.println(permutationWithoutRepetition("aabb", ""));

        // PATH TYPE
        // System.out.println(mazePath_HVD(0, 0, 2, 2, ""));
        // System.out.println(mazePath_HVD_Multi(0, 0, 2, 2, ""));
        // System.out.println(boardPath_Dice(10, "", 1));

        // NQUEEN WAYS 1D BOARD
        // Boolean[] boxes=new Boolean[4];
        // Arrays.fill(boxes,false);
        // System.out.println(nQueenWaysPer(boxes, 2, 0, ""));
        System.out.println(nQueenWaysCom(4, 2, 0, -1, ""));
       
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

    public static int permutationWithoutRepetition(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return 1;
        }
        Boolean[] map = new Boolean[26];
        int count = 0;
        Arrays.fill(map, false);
        for (int i = 0; i < str.length(); i++) {
            if (!map[str.charAt(i) - 'a']) {
                map[str.charAt(i) - 'a'] = true;
                String sub = str.substring(0, i) + str.substring(i + 1);
                count += permutationWithoutRepetition(sub, ans + str.charAt(i));
            }
        }
        return count;
    }

    public static int mazePath_HVD(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans + " ");
            return 1;
        }
        int count = 0;
        if (sr + 1 <= er) {
            count += mazePath_HVD(sr + 1, sc, er, ec, ans + "V");
        }
        if (sc + 1 <= ec) {
            count += mazePath_HVD(sr, sc + 1, er, ec, ans + "H");
        }
        if (sr + 1 <= er && sc <= ec) {
            count += mazePath_HVD(sr + 1, sc + 1, er, ec, ans + "D");
        }
        return count;
    }

    public static int mazePath_HVD_Multi(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans + " ");
            return 1;
        }
        int count = 0;
        for (int jump = 1; jump + sr <= er; jump++) {
            count += mazePath_HVD_Multi(jump + sr, sc, er, ec, ans + "V" + jump + " ");
        }
        for (int jump = 1; jump + sc <= ec; jump++) {
            count += mazePath_HVD_Multi(sr, jump + sc, er, ec, ans + "H" + jump + " ");

        }
        for (int jump = 1; jump + sr <= er && jump + sc <= ec; jump++) {
            count += mazePath_HVD_Multi(sr + jump, sc + jump, er, ec, ans + "D" + jump + " ");
        }
        return count;
    }

    public static int boardPath_Dice(int board, String ans, int s) {
        if (s == board) {
            System.out.println(ans + " ");
            return 1;
        }
        int count = 0;
        for (int i = 1; i < 7; i++) {
            if (s + i <= board)
                count += boardPath_Dice(board, ans + i + " ", s + i);
        }
        return count;
    }

    public static int nQueenWaysPer(Boolean[] boxes, int tnq, int qpsf, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans + " ");
            return 1;
        }
        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (!boxes[i]) {
                boxes[i]=true;
                count += nQueenWaysPer(boxes, tnq, qpsf + 1, ans + i + " ");
                boxes[i]=false;
            }
        }
        return count;
    }
    public static int nQueenWaysCom(int boxes,int tnq,int qpsf,int vidx,String ans){
        if(tnq==qpsf){
            System.out.println(ans+" ");
            return 1;
        }
        int count=0;
        for(int i=vidx+1;i<boxes;i++){
            if(vidx+1<boxes)
            count+=nQueenWaysCom(boxes, tnq, qpsf+1, i, ans+i+" ");
        }
        return count;
    }
}