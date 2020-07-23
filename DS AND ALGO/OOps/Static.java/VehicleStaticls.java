public class VehicleStaticls {
    int i = 5;

    public void fun() {
        System.out.println("I am in main class");
    }

    public static class SubClass {
        public void fun() {
            System.out.println("I am in sub class");
        }
    }
}