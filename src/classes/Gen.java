package classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gen {
    public Gen() {
    }

    public static void prefixGen(int exportAmount, String email) {
        List<String> output = new ArrayList();

        String emailAddr;
        for (int i = 0; i < exportAmount; ++i) {
            emailAddr = getRandomString(5);
            String emailCore = email.replace("@gmail.com", "");
            String finalEmail = emailCore + "+" + emailAddr + "@gmail.com";
            output.add(finalEmail);
        }

        saveToFile(output);
        System.out.println("Generated Email Addresses:");
        Iterator var7 = output.iterator();

        while (var7.hasNext()) {
            emailAddr = (String) var7.next();
            System.out.println(emailAddr);
        }

    }

    public static String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            int index = random.nextInt(characters.length());
            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString();
    }

    public static void saveToFile(List<String> emails) {
        int fileCount = 1;

        String fileName;
        for (fileName = "GenEmail.txt"; (new File(fileName)).exists(); ++fileCount) {
            fileName = "GenEmail" + fileCount + ".txt";
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            Iterator var4 = emails.iterator();

            while (var4.hasNext()) {
                String email = (String) var4.next();
                writer.write(email + "\n");
            }

            writer.close();
        } catch (IOException var6) {
            System.out.println("An error occurred while saving to file: " + var6.getMessage());
        }

    }
}