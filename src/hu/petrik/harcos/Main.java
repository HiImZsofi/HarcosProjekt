package hu.petrik.harcos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

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
       /* for (Harcos harcos : harcosok) {
            System.out.println(harcos.toString());  //konzolra kiíratás
        }*/
        Scanner sc = new Scanner(in);
        System.out.println("Adja meg a játékosa nevét: ");
        String username = sc.nextLine();
        System.out.println("Adja meg a játékosa számát (1-3 között): ");
        int usernumber = 5;
        while(usernumber > 3 || usernumber < 0){
            usernumber = Integer.parseInt(sc.nextLine());
        }
        harcosok.add(new Harcos(username, usernumber));
        for (int i = 0; i < harcosok.size(); i++) {
            Harcos getLatestIndex = harcosok.get(harcosok.size() - 1) ;
            if (harcosok.get(i) == getLatestIndex){
                harcosok.get(i).setNev(username);
                System.out.println(harcosok.get(i));
            }
        }
    }
}
