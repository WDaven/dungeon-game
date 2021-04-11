package scenes;

public class Player {
    private int playerHealth;
    private int playerDamage;
    private int currAttackNumber;
    public Player(int playerHealth) {
        this.playerHealth = playerHealth;
        this.playerDamage = 12;
        this.currAttackNumber = 0;

    }

    public int getCurrAttackNumber() {
        return currAttackNumber;
    }

    public void setCurrAttackNumber(int currAttackNumber) {
        this.currAttackNumber = currAttackNumber;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerDamage() {
        return playerDamage;
    }

    public void setPlayerDamage(int playerDamage) {
        this.playerDamage = playerDamage;
    }

}