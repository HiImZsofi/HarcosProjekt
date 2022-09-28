package hu.petrik.harcos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Harcos> harcosok = new ArrayList<>();
    public static void main(String[] args) {
        File file = new File("harcosok.csv");
        Scanner scR;
        try {
            scR = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scR.hasNextLine()) {
            String[] temp = scR.nextLine().split(";");
            harcosok.add(new Harcos(temp[0], Integer.parseInt(temp[1])));
        }
        for (Harcos harcos : harcosok) {
            System.out.println(harcos.toString());
        }
    }
}
