package kg.geektech.game.players;

public class Berserk extends Hero {
    private int savedDamage;

    public void setSavedDamage(int savedDamage) {
        this.savedDamage = savedDamage;
    }

    public Berserk(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if(this.getHealth() > 0 && this.getDamage() < 60){
            this.setDamage(this.getDamage() + this.savedDamage);
        }
    }


}
