package scenes;

public class MonsterBoss extends MonsterParent{
    public MonsterBoss(int monsterHealth, int monsterDamage) {
        super(monsterHealth, monsterDamage);
    }
    public MonsterBoss() {
        super(100, 15);
    }
}
