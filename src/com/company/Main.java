package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();

        List<String> pathList = fileReader.readFilesFromFolder();


        for (int i = 0; i < pathList.size() - 1; i++) {
            int lineNumber = 0;

            File firstFile = new File(pathList.get(i));
            File secondFile = new File(pathList.get(i + 1));

            System.out.println(firstFile);
            System.out.println(secondFile);

            try {
                Scanner scanner = new Scanner(firstFile);
                Scanner secondScanner = new Scanner(secondFile);

                while (scanner.hasNextLine()) {
                    lineNumber = lineNumber + 1;

                    String firstFileValue = scanner.nextLine();
                    String secondFileValue = secondScanner.nextLine();


                    System.out.println(firstFileValue);
                    System.out.println(secondFileValue);

                    if (firstFileValue.equals(secondFileValue)) {
                        System.out.println("Check");
                    } else {
                        System.out.println("Error");
                        System.out.print("Equal check got an error at => " + lineNumber);
                        return;
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}

