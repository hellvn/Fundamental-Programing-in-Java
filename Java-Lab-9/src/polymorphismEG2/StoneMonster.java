package PolymorphismEG2;

public class StoneMonster extends Monster{
    public StoneMonster(String name){
        super(name);
    }
    @Override
    public  String attack(){
        return "Doton Doryuu Heki!";
    }
}
