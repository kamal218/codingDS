public class client {
    public static void main(String[] args) {
        // parent o1 = new parent();
        // o1.fun();
        child o2 = new child();
        o2.fun();
        System.out.println(o2.c);
        // parent o3 = new child();
        // o3.fun();
        // child o4 = new parent(); // error
    }
}