package scenes;


public class MonsterBlue extends MonsterParent{
    public MonsterBlue(int monsterHealth, int monsterDamage){
        super(monsterHealth,monsterDamage);
    }
    public MonsterBlue(){
        super(15, 2);
    }
    public MonsterBlue(boolean isDead) {
        super(100,2,true);
    }
}
