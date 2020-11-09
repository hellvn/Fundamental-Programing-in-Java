package PolymorphismEG2;

public class FireMonster extends Monster{
    public FireMonster(String name){
        super(name);
    }
    @Override
    public  String attack(){
        return "Katon Goukakyu no Jutsu!";
    }
}
