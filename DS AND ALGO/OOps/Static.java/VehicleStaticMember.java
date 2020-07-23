// we can call static methods/members from non static while vice versa is false
public class VehicleStaticMember {
    static int i = 5;
    int p = 3;

    public static void fun() {
        System.out.println("I am in fun");
        System.out.print(i);
    }
    public void fun1(){
        fun();
    }
}