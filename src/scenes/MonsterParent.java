package scenes;

public class MonsterParent {
    public int monsterHealth;
    public int monsterDamage;
    public MonsterParent() {
        this.monsterHealth = 10;
        this.monsterDamage = 1;
    }
    public MonsterParent(int monsterHealth, int monsterDamage){
        this.monsterHealth = monsterHealth;
        this.monsterDamage = monsterDamage;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(int monsterDamage) {
        this.monsterDamage = monsterDamage;
    }
}
