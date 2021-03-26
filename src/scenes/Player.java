package scenes;

import static scenes.InitializeConfigScreen.*;

public class Player {
    private int player_Health;
    private int player_Damage;
    public Player(int player_Health) {
        this.player_Health=player_Health;
        this.player_Damage = 12;

    }

    public int getPlayer_Health() {
        return player_Health;
    }

    public void setPlayer_Health(int player_Health) {
        this.player_Health = player_Health;
    }

    public int getPlayer_Damage() {
        return player_Damage;
    }

    public void setPlayer_Damage(int player_Damage) {
        this.player_Damage = player_Damage;
    }
}
