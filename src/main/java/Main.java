import java.io.File;
import java.net.MalformedURLException;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URLClassLoaderAccess loader = URLClassLoaderAccess.create((URLClassLoader) Main.class.getClassLoader());
        File libsFile = new File("libs");
        if (!libsFile.exists()) {
            System.out.println("libs folder not found");
            return;
        }

        File[] libs = libsFile.listFiles();

        if (libs == null || libs.length == 0) {
            System.out.println("no libs");
            return;
        }

        for (File filename : libs) {
            if (filename.isFile() && filename.getName().endsWith(".jar")) {
                loader.addURL(filename.toURI().toURL());
                System.out.println("added: " + filename.getName());
            }
        }
    }
}
