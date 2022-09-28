package hu.petrik.harcos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
                //System.out.println(harcosok.get(i));
                System.out.println("Harcos létrehozva");
            }
        }

        System.out.println("Az összes jelenlegi harcos: ");
        for (int i = 0; i < harcosok.size(); i++) {
            System.out.println(i + " " + harcosok.get(i).toString());
        }

        String menupont = " ";
        int korokszama = 0;
        double randomharcos = (Math.random() * 3) + 1;
        menupont = sc.nextLine().toLowerCase();
        System.out.println(menupont);
        System.out.println("Válasszon az alábbi listából: a.) Harcolás, b.) Gyógyulás, c.) Kilépés");
        while(menupont.equals("a")){
            int harcosnumber = 5;
            System.out.println("Melyik harcossal szeretne megküzdeni(1-3)?");
            while(harcosnumber > 3 || harcosnumber < 0){
                System.out.println("Rossz számot adott meg");
                harcosnumber = Integer.parseInt(sc.nextLine());
            }
            harcosnumber += 1;
            for (int i = 0; i < harcosok.size(); i++) {
                harcosok.get(usernumber).Megkuzd(harcosok.get(harcosnumber));
            }
            korokszama++;
        }
        while(menupont.equals("b")){
            harcosok.get(usernumber).Gyogyul();
            korokszama++;
        }
        if(menupont.equals("c")){
            return;
        }
        else if(korokszama % 3 == 0){
            for (int i = 0; i < harcosok.size(); i++) {
                harcosok.get(usernumber).Megkuzd(harcosok.get((int) randomharcos));
            }
            korokszama++;
        }
    }
}
