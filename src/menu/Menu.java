package menu;

import java.util.*;
import droids.Droids;
import battle.*;

public class Menu {

    public void menu() throws InterruptedException {
        while (true) {
            System.out.println("\t\t" + Droids.ANSI_BLUE + "MENU");
            System.out.println(
                    "1: Create new droid(10max)\n2: show created droids\n3: battle 1v1\n4: create teams\n5: battle team vs team\n0: exit"
                            + Droids.ANSI_RESET);
            Scanner scanner = new Scanner(System.in);
            int index = scanner.nextInt();
            if (index == 0) {
                break;
            }
            if (index == 1) {
                Droids.creation();
            }
            if (index == 2) {
                Outputs.output();
            }
            if (index == 3) {
                Battle.choose();
            }
            if (index == 4) {
                Droids.makeTeams();
                Outputs.teamsOutput(Droids.team1, Droids.team2);
            }
            if (index == 5) {
                TFbattle.TeamFight();
            }
        }
    }
}
