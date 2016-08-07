package My;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * Created by Владелец on 30.06.2016.
 */
public class FileOperations {
    public static void main(String[] args) {
        File file = new File("Z:\\YandexDisk\\YouTube");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String extention = pathname.getPath();
                System.out.println(extention);
                return true;
            }
        };
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String extention = name.substring(name.lastIndexOf(".")+1);
                System.out.println(extention);
                return extention.equals("java");
            }
        };


        String[] list = file.list(filenameFilter);

        System.out.println();

        for (int i = 0; i < list.length; i++) {
            System.out.println("--" + list[i]);
        }
    }
}
