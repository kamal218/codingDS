public class VehicleClientStaticMember {
    public static void main(String[] args) {
        VehicleStaticMember obj = new VehicleStaticMember();
        System.out.println(VehicleStaticMember.i); // accessed using class name
        obj.fun1();
        // System.out.println(VehicleStaticMember.p);
        // fetch(); //cannot fetch non static methods
    }

    // public void fetch() {
    //     // VehicleStaticMember obj = new VehicleStaticMember();
    //     // System.out.println(obj.i);
    //     System.out.println(VehicleStaticMember.p);
    // }
}