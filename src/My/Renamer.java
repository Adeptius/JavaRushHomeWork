package My;

import java.io.File;

public class Renamer {

    public static void main(String[] args) {
        try {
        File myFolder = new File("Z:\\YandexDisk\\YouTube");
            File[] files = myFolder.listFiles();
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (fileName.contains("#") ||
                        fileName.contains("$") ||
                        fileName.contains("&") ||
                        fileName.contains("%")) {
                    String newName = fileName.replace("#", "");
                    newName = newName.replace("$", "");
                    newName = newName.replace("&", "");
                    newName = newName.replace("%", "");
                    File newFile = new File(myFolder.getPath() + "\\" + newName);
                    if (files[i].renameTo(newFile)) {
                        System.out.println("Файл " + fileName + " переименован успешно");
                    }
                }
            }
        }catch (Exception ignored){}
    }
}
