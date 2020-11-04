package com.company.players;

public class Tank extends Hero {

    public Tank(int health, int damage, String name) {
        super(health, damage, SuperPower.BLOCK, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int temp=boss.getDamage()/5;
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth()>0&&boss.getHealth()>0&&boss.getDamage()>0){
                if(this.getHealth()>0){
                    heroes[i].setHealth(heroes[i].getHealth()+temp);
                }
            }
        }
    }
}
