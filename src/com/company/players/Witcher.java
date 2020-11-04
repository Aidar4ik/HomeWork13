package com.company.players;

public class Witcher extends Hero {
    public Witcher(int health, int damage, String name) {
        super(health, damage,SuperPower.RESURRECTION, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i <heroes.length ; i++) {
            if(heroes[i].getHealth()<=0&&boss.getHealth()>0){
                if(this.getHealth()>0){
                    heroes[i].setHealth(this.getHealth());
                    this.setHealth(0);
                    System.out.println(this.getName()+" |Воскресил "+heroes[i].getName()+ " и умер");
                }
            }
        }
    }
}
