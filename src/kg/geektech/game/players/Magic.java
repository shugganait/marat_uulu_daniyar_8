package kg.geektech.game.players;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if(this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 && heroes[i] != heroes[5])
                    heroes[i].setDamage(heroes[i].getDamage() + 5);
            }
        }
    }
}
