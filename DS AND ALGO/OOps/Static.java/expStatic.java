public class expStatic {
    static {
        System.out.println("I am in 1st static block");
        System.exit(0);
    }
    public static void main(String[] args){
        System.out.println("I am in main");
    }
    static{
        System.out.println("I am in 2nd static block");
    }
}