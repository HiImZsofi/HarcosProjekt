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

    public void setNev(String nev) {
        this.nev = nev;
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

    public String getNev() {
        return nev;
    }

    public int getSzint() {
        return szint;
    }

    public int getTapasztalat() {
        return tapasztalat;
    }

    public int getEletero() {
        return eletero;
    }

    public int getAlapEletero() {
        return alapEletero;
    }

    public int getAlapSebzes() {
        return alapSebzes;
    }

    public void setEletero(int eletero){
        if(this.eletero <= 0){
            this.tapasztalat = 0;
        }
        else if(this.eletero > getMaxEletero()){
            this.eletero = getMaxEletero();
        }
    }

    public void setSzint(int tapasztalat){
        if(this.tapasztalat + tapasztalat >= getSzintLepeshez()){
            this.szint += 1;
            int maradek = this.tapasztalat + tapasztalat - getSzintLepeshez();
            this.tapasztalat -= getSzintLepeshez();
            this.tapasztalat = maradek;
            setEletero(getMaxEletero());
        }
        else{
            this.tapasztalat = tapasztalat;
        }
    }

    public void Megkuzd(Harcos ellenfel){
        if(this == ellenfel){
            System.out.println("A harcos nem k??zdhet meg saj??t mag??val, adjon meg egy m??sik harcost.");
        }
        else if(this.getEletero() <= 0 || ellenfel.getEletero() <= 0){
            System.out.println("Valamelyik harcos m??r halott.");
        }
        else{
            int sebzesUtanHp = ellenfel.getEletero() - this.getSebzes();
            ellenfel.setEletero(sebzesUtanHp);
            if(ellenfel.getEletero() > 0){
                while(this.getEletero() > 0 && ellenfel.getEletero() > 0){
                    int userSebzesUtan = this.getEletero() - ellenfel.getSebzes();  //f??lre??rtelmeztem a feladatot ez??rt addig ??tik egym??st am??g meg nem hal az egyik
                    this.setEletero(userSebzesUtan);                                //k??s??n vettem ??szre
                    int oppSebzesUtan = ellenfel.getEletero() - this.getSebzes();   //:(
                    ellenfel.setEletero(oppSebzesUtan);
                }
                if(this.getEletero() > 0 && ellenfel.getEletero() < 0){
                    System.out.println("User nyert");
                    int ujTapasztalat = this.getTapasztalat() + 10;
                    this.setSzint(ujTapasztalat);
                }
                else if(this.getEletero() < 0 && ellenfel.getEletero() > 0){
                    System.out.println("Ellenf??l nyert");
                    int ujTapasztalat = ellenfel.getTapasztalat() + 10;
                    ellenfel.setSzint(ujTapasztalat);
                }
            }
        }
    }

    public void Gyogyul(){
        if(this.getEletero() == 0){
            this.setEletero(getMaxEletero());
        }
        else{
            int ujHp = this.getEletero() + 3;
            this.setEletero(ujHp);
        }
    }
 //TODO ha meghalsz akkor kutya vagy
    @Override
    public String toString() {
       return String.format("%s - LVL: %d - EXP: %d/%d - HP: %d/%d - DMG: %d",
               nev, szint, tapasztalat, getSzintLepeshez(), eletero, getMaxEletero(), getSebzes());
    }
}
