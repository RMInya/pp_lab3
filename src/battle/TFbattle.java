package battle;

import droids.Droids;
import menu.Outputs;

public class TFbattle {
    public static void TeamFight() throws InterruptedException {
        teamFightArena teamFightArena = new teamFightArena(Droids.team1, Droids.team2);

        Droids[] winner = teamFightArena.startTeamFight();

        System.out.println("--------------");
        if (winner[0].getTeamPointer() == 1) {
            Outputs.TFwinner(Droids.team1, Droids.t1counter);
        } else {
            Outputs.TFwinner(Droids.team2, Droids.t2counter);
        }
        
    }
}

