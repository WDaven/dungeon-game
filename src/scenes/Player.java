package scenes;

import static scenes.InitializeConfigScreen.getCurrWeaponList;

public class Player {
    private int player_Health;
    private int player_Damage;
    public Player(int player_Health) {
        this.player_Health=player_Health;
        switch (getCurrWeaponList()[0]) {
            case "dagger":
                this.player_Damage = 8;
                break;
            case "sword":
                this.player_Damage = 10;
                break;
            case "greatsword":
                this.player_Damage = 12;
                break;
            default:
                this.player_Damage = 8;
        }

    }
    public Player() {
        new Player(100);
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
