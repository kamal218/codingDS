public class factor {
    public static void main(String[] args) {

        int a = 4, b = 12;
        System.out.println(LCM(a, b));
        System.out.println(HCF(a,b));
        System.out.println(GCD(a,b));
    }

    public static int LCM(int a, int b) {
        // a is less then b
        int lcm = 1;
        int i = 2;
        while (a != 1) // for(int i=2;i<=a;i++)
        {
            if (a % i == 0) {
                lcm *= i;
                a /= i;
                b /= i;
            } else
                i++;
        }
        return lcm * a * b;
    }

    public static int HCF(int a,int b)
    {
        return ((a*b)/LCM(a,b));
    }
    public static int GCD(int a,int b)
    {
        return ((a*b)/LCM(a,b));
    }
}