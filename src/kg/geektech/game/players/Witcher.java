package kg.geektech.game.players;

public class Witcher extends Hero{
    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.GIVE_OWN_LIFE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0 && heroes[i] != heroes[5] && heroes[i].getHealth() == 0){
                heroes[i].setHealth(this.getHealth());
                this.setHealth(0);
                break;
            }
        }
    }
}
