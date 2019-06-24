package analize;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {

        //List<String> listLog = new ArrayList<>();
        List<String> listRes = new ArrayList<>();

        try (BufferedReader read = new BufferedReader(new FileReader(source))) {

            boolean marker = false;
            String stringForTime = "";
            String stringOfList = null;

            while ((stringOfList = read.readLine()) != null) {

                String[] stringArray = stringOfList.split(" ");

                if (!marker && (stringArray[0].equals("400") || stringArray[0].equals("500"))) {
                    marker = true;
                    stringForTime = stringArray[1] + " - ";
                }

                if (marker && (stringArray[0].equals("200") || stringArray[0].equals("300"))) {
                    marker = false;
                    stringForTime += stringArray[1] + System.lineSeparator();
                    listRes.add(stringForTime);
                    stringForTime = "";
                }
            }

            listRes.add(stringForTime);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter write = new BufferedWriter(new FileWriter(target))) {
            for (String string: listRes) {
                write.write(string);
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

}