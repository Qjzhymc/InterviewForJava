package Algorithm4th;

public class String {

    public static void main(java.lang.String[] args) {
        System.out.println(String.class.getClassLoader());
        java.lang.String str = "123";
        System.out.println(str.getClass().getClassLoader());//启动类加载器的会返回null
    }
}
