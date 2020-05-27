public class basic{

    public static void main(String[] args)
    {
        tryfunc();
    }
    public static void tryfunc()
    {
       exp3();
    }
    public static void exp1()
    {
        String a="hello";
        String b="hello";
        String c="hi";
        System.out.println(a==b); // a and b are same string constants so points to same location in String pool  
        System.out.println(a.equals(b));    //also works on simple string initialiation
        System.out.println(a==c);
    }
    public static void exp2()
    {
        String a=new String("hello");
        String b=new String("hello");
        String c=new String("hi");
        System.out.println(a==b);   //results false because these 2 string s are different objects but same value string constants are also created in string pool
        a="hello";  // a points to string pool
        b="hello";
        System.out.println(a==b); // a and b are string constants and hence points to same location
    }
    public static void exp3()
    {
        StringBuilder sb=new StringBuilder();
        sb.append("hello");
        System.out.println(sb);
        sb.append(1);
        System.out.println(sb);
        sb.insert(0,"hi");
        System.out.println(sb);
        // sb.delete(0, sb.length());
        // System.out.println(sb);
        // sb.reverse();
        // System.out.println(sb);
        CharSequence str=sb.subSequence(1,4);
        System.out.println(str);

    }
}