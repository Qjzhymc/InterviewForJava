package doc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class testClassLoad {
    @Override
    public String toString() {
        return "类加载成功。";
    }
}

/**
 * 如何自定义一个类加载器，继承ClassLoader并重写findClass方法，指明如何获取类的字节码流；
 * 如果要破坏双亲委派模型，则可以重写loadClass(双亲委派的具体逻辑实现)方法就可以了。
 */
public class PathClassLoader extends ClassLoader {
    private String classPath;

    public PathClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getData(String className) {
        String path = classPath + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = is.read(buffer)) != -1) {
                stream.write(buffer, 0, num);
            }
            return stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    public static void main(String args[]) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        ClassLoader pcl = new PathClassLoader("/home/IdeaProjects/MyMavenProjectForLeetCode");
        Class c = pcl.loadClass("doc.testClassLoad");//注意要包括包名
        System.out.println(c.newInstance());//打印类加载成功.
    }
}