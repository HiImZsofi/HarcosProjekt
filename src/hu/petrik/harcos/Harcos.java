package hu.petrik.harcos;

public class Harcos {
    private String nev;
    private int szint;
    private int tapasztalat;
    private int eletero;
    private int alapEletero;
    private int alapSebzes;


    public Harcos(String nev, int statuszSablon){
        this.nev = nev;
        this.szint = 1;
        this.tapasztalat = 0;
        if(statuszSablon == 1){
            alapEletero = 15;
            alapSebzes = 3;
        }
        else if(statuszSablon == 2){
            alapEletero = 12;
            alapSebzes = 4;
        }
        else if(statuszSablon == 3){
            alapEletero = 8;
            alapSebzes = 5;
        }
        this.eletero = getMaxEletero();
    }

    public int getSebzes() {
        return alapSebzes + szint;
    }

    public int getSzintLepeshez(){
        return 10 + szint*5;
    }

    public int getMaxEletero(){
        return alapEletero + szint * 3;
    }

    @Override
    public String toString() {
       return String.format("%s - LVL: %d - EXP: %d/%d - HP: %d/%d - DMG: %d",
               nev, szint, tapasztalat, getSzintLepeshez(), eletero, getMaxEletero(), getSebzes());
    }
}
