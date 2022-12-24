package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Samurai extends Hero {
    public Samurai(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SURIKEN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int randomChoice = RPG_Game.random.nextInt(2);
        if (this.getHealth() > 0) {
            if(randomChoice == 0) {
                boss.setHealth(boss.getHealth() - 30);
                System.out.println("Samurai threw surikens with poison in the Boss");
            }
            if (randomChoice == 1) {
                boss.setHealth(boss.getHealth() + 30);
                System.out.println("Samurai threw healing surikens in the Boss");
            }
        }
    }
}
