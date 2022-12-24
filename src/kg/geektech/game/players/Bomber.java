package kg.geektech.game.players;

public class Bomber extends Hero {
    public Bomber(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.VICTIM);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() == 0) {
            boss.setHealth(boss.getHealth() - 100);
        }
    }
}
