public class client{
    public static void main(String[] args){
        String input="asdgvajdvmnasvcamnsvcasdaskmndbckasjbdcmanbscmsanbcmsnbcmsnbcmsnbcdmdsncmsbcmsnbcskgymnszdcvmzcvn";
        huffMan ecdc=new huffMan(input);
        String encode=ecdc.encodeString("akmn");
        System.out.println(encode);
        String decode=ecdc.decodeString(encode);
        System.out.print(decode);
    }
}