package My;

import java.io.*;

public class Re {

    public static void main(String[] args) throws IOException {

        File file =  new File("Z:\\Телефон\\Загрузки\\Содержание философии.txt");
        File file2 = new File("Z:\\Телефон\\Загрузки\\Содержание философии2.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        while(reader.ready()){
            try {
                String s = reader.readLine();
                if (!s.equals(" ") || !s.equals("")) {
                    String i = s.substring(s.lastIndexOf('\t'));
                    i = i.replace(" ", "");
                    i = i.replace("\t", "");

                    String result;
                    if (i.length() == 2)      result = i + "    " + s.substring(0, s.lastIndexOf("\t"));
                    else if (i.length() == 3) result = i + "   "  + s.substring(0, s.lastIndexOf("\t"));
                    else                      result = i + "  "   + s.substring(0, s.lastIndexOf("\t"));
                    if (result.substring(6,11).equals("Глава")) result = "\n===" + result.substring(6) + "===";

                    writer.write(result);
                    writer.write("\n");
                }
            }catch (Exception e){}
        }
        reader.close();
        writer.close();
    }
}
