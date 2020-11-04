package com.company.general;

import com.company.players.*;

import java.awt.event.WindowFocusListener;

public class RPG_Game {
    public static void start() {
        System.out.println("Game started!");
        Boss boss = new Boss(5000, 50, "Танос");
        Warrior warrior = new Warrior(250, 20, "Воин");
        Medic doc = new Medic(220, 0, 15, "Айболит");
        Magic magic = new Magic(240, 15, "Стрэндж");
        Berserk berserk = new Berserk(250, 10, "Бек");
        Medic assistant = new Medic(245, 5, 5, "Джун");
        Witcher witcher = new Witcher(300,0,"Смертник");
        Thor thor = new Thor(250,20,"Тор");
        WindRanger windRanger= new WindRanger(200,15,"Виднра");
        Tank tank = new Tank(300,5,"Исл");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant,witcher,thor,windRanger,tank};

        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        heroesApplySuperPower(boss, heroes);
        heroesHit(boss, heroes);
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }

        printStatistics(boss, heroes);
    }
    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }

        }
    }

    private static void heroesApplySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("____________");
        System.out.println(boss.getName() + " health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName()
                    + " health: " + heroes[i].getHealth());
        }
        System.out.println("____________");
    }
}
