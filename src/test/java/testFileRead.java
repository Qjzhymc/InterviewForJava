import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testFileRead {
    public static void main(String[] args) {

        //方法一：使用try-catch-finally读取文件
//        Scanner scanner = null;
//        try {
//            File file = new File("/Users/yumengchi/InterviewForJava/src/test/java/resources/readfile");
//            scanner = new Scanner(file);
//            while (scanner.hasNext()) {
//                System.out.println(scanner.nextLine());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }
        //方法二：使用try-with-resources读取文件
        try(Scanner scanner = new Scanner(new File("/Users/yumengchi/InterviewForJava/src/test/java/resources/readfile"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
