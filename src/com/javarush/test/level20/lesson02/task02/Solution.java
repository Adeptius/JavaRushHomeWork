package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("z:\\1.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();

            User user = new User();
            user.setCountry(User.Country.UKRAINE);
            user.setFirstName("Ваня");
            user.setLastName("Иванов");
            user.setMale(true);
            Date date = new Date(1989, 10, 26);

            user.setBirthDate(date);

            javaRush.users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(this.users.size());




            for (int i = 0; i < this.users.size(); i++) {

                User temp = this.users.get(i);
                writer.println(temp.getFirstName());
                writer.println(temp.getLastName());
                writer.println(temp.getBirthDate().getYear());
                writer.println(temp.getBirthDate().getMonth());
                writer.println(temp.getBirthDate().getDate());

                writer.println(temp.isMale());
                writer.println(temp.getCountry().getDisplayedName());
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int usersCount = Integer.parseInt(reader.readLine());

            for (int i = 0; i < usersCount; i++) {
                User user = new User();

                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());

                Date date = new Date(Integer.parseInt(reader.readLine()),
                        Integer.parseInt(reader.readLine()),
                        Integer.parseInt(reader.readLine()));
                user.setBirthDate(date);

                user.setMale(Boolean.parseBoolean(reader.readLine()));
                String country = reader.readLine();
                User.Country countr = null;

                if (User.Country.UKRAINE.getDisplayedName().equals(country)) countr = User.Country.UKRAINE;
                if (User.Country.RUSSIA.getDisplayedName().equals(country)) countr = User.Country.RUSSIA;
                if (User.Country.OTHER.getDisplayedName().equals(country)) countr = User.Country.OTHER;
                user.setCountry(countr);

                this.users.add(user);
            }
            reader.close();
        }
    }
}
