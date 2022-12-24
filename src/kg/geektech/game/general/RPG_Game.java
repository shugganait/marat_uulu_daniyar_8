package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    protected static int roundCounter;
    public static Random random = new Random();
    public static void startGame() {
        Boss boss = new Boss(1800, 50, "Dragon ||");
        Warrior warrior = new Warrior(270, 10, "Arno ||");
        Medic doc = new Medic(250, 5, 15, "Rick ||");
        Magic magic = new Magic(260, 15, "Eivor ||");
        Berserk berserk = new Berserk(280, 10, "Ezio ||");
        Medic assistant = new Medic(300, 5, 5, "Bayek ||");
        Witcher witcher = new Witcher(350, 0, "Basim ||");
        Bomber bomber = new Bomber(250, 10, "Atrey ||");
        Samurai samurai = new Samurai(270, 20, "Glenn ||");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, witcher, bomber, samurai};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundCounter + " -----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundCounter++;
        boss.chooseDefence(heroes);
        boss.hit(heroes);
        heroes[3].setSavedDamage(boss.getDamage());
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getDefence() != heroes[i].getAbility() && heroes[i].getHealth() > 0
                    && boss.getHealth() > 0) {
                heroes[i].hit(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
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
}
