package scenes;

public class MonsterParent {
    private int monsterHealth;
    private int monsterDamage;
    private boolean monsterIsDead;
    private static int deadMonsterCount = 0;
    public MonsterParent() {
        this.monsterHealth = 10;
        this.monsterDamage = 1;
        this.monsterIsDead = false;
    }
    public MonsterParent(int monsterHealth, int monsterDamage) {
        this.monsterHealth = monsterHealth;
        this.monsterDamage = monsterDamage;
        this.monsterIsDead = false;
    }
    public MonsterParent(int monsterHealth, int monsterDamage, boolean monsterIsDead) {
        this.monsterHealth = monsterHealth;
        this.monsterDamage = monsterDamage;
        this.monsterIsDead = true;
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

    public boolean getMonsterIsDead() {
        return monsterIsDead;
    }

    public void setMonsterIsDead(boolean monsterIsDead) {

        this.monsterIsDead = monsterIsDead;
        ++deadMonsterCount;
    }
    public static int getDeadMonsterCount() {return deadMonsterCount;}

    public static void setDeadMonsterCount(int i) {deadMonsterCount = i;}
}
