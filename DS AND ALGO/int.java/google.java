class google {
    public static void main(String[] args) {
        question();
    }

    public static void question() {
        // System.out.println(trailingZeroesInFactorial(100));
        int n=500;
        System.out.println(binSearch(0, n - 1, n));

    }

    public static int trailingZeroesInFactorial(int n) {
        int two = 0, five = 0;
        for (int i = 2; i <= n; i++) {
            two += numberOfTwo(i);
            five += numberOfFive(i);
        }
        return Math.min(two, five);
    }

    public static int numberOfTwo(int n) {
        int two = 0;
        while (n % 2 == 0) {
            two++;
            n /= 2;
        }
        return two;
    }

    public static int numberOfFive(int n) {
        int five = 0;
        while (n % 5 == 0) {
            five++;
            n /= 5;
        }
        return five;
    }

    public static int binSearch(int si, int ei, int stairs) {
        while (si <= ei) {
            int mid = (ei-(ei-si)/2);
            int val = ((mid + 1) * (mid + 2)) / 2;
            if (val == stairs)
                return mid + 1;
            else if (val > stairs)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return ei + 1;
    }
}