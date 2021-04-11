package scenes;

public class Player {
    private int playerHealth;
    private int playerDamage;
    public Player(int playerHealth) {
        this.playerHealth = playerHealth;
        this.playerDamage = 12;

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