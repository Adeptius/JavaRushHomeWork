package com.javarush.test.level40.lesson04.task01;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/* POST, а не GET
Исправь ошибки в методе sendPost, чтобы он отправлял POST-запрос с переданными параметрами.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.sendPost(new URL("http://qainterview.cogniance.com"), "name=zapp&position=good");
    }

    public void sendPost(URL url, String urlParameters) throws Exception {
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//
//        connection.setRequestMethod("HEAD");
//        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//
//        connection.setDoOutput(true);
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
//        writer.write(urlParameters);
//        writer.close();
//
//        int responseCode = connection.getResponseCode();
//        System.out.println("Response Code: " + responseCode);
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        String responseLine;
//        StringBuilder response = new StringBuilder();
//
//        while ((responseLine = bufferedReader.readLine()) != null) {
//            response.append(responseLine);
//        }
//        bufferedReader.close();
//
//        System.out.println("Response: " + response.toString());
    }
}
