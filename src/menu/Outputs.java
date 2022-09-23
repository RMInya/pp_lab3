package menu;

import droids.Droids;
import battle.*;
import java.util.*;

public class Outputs {
    public static void TFwinner(Droids[] team, int count) {
        System.out.println(Droids.ANSI_YELLOW + "The winner is team " + team[0].getTeamPointer() + Droids.ANSI_RESET);
        for (int i = 0; i < count; i++) {
            System.out.println(Droids.ANSI_BLUE + "\t" + team[i].getName() + Droids.ANSI_RESET);
        }
    }

    public static void output() {
        int temp = 0;
        for (int i = 0; i < Droids.counter; i++) {
            System.out.println("----------------------------------------");
            System.out.println(
                    "|" + (temp + 1) + "\tDroid " + Droids.objArr[i].getName() + " class " + Droids.ANSI_GREEN
                            + Droids.objArr[i].getClassPointer() + Droids.ANSI_RESET + "\t|");
            temp++;
        }
    }

    public static void teamsOutput(Droids[] team1, Droids[] team2) {
        int temp = 0;
        int tempp = 0;
        System.out.println();
        System.out.println("Team1");
        for (int p = 0; p < Droids.t1counter; p++) {

            System.out.println("----------------------------------------");
            System.out.println(
                    "|" + (temp + 1) + "\tDroid " + Droids.objArr[p].getName() + " class " + Droids.ANSI_GREEN
                            + Droids.objArr[p].getClassPointer() + Droids.ANSI_RESET + "\t|");
            temp++;
        }
        System.out.println();
        System.out.println("Team2");
        for (int p = 0; p < Droids.t2counter; p++) {
            System.out.println("----------------------------------------");
            System.out.println("|" + (tempp + 1) + "\tDroid " + team2[p].getName() + " class " + Droids.ANSI_GREEN
                    + Droids.objArr[p].getClassPointer() + Droids.ANSI_RESET + "\t|");
            tempp++;
        }
    }
    public static void fillTeam(Droids[] team, int check) {
        int temp = 0;
        int i = 0;
        System.out.println();
        System.out.println(Droids.ANSI_RED + "MAX 5 droids in 1 team" + Droids.ANSI_RESET);
        System.out.println();
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose droid to team: (0 to stop)");
            temp = scan.nextInt();
            int tempcheck = temp;
            if (temp == 0) {
                break;
            }
            if (Droids.objArr[temp - 1].getTeamPointer() == 1 || Droids.objArr[temp - 1].getTeamPointer() == 2) {
                do {
                    System.out.println("Already in team , choose another");
                    tempcheck = scan.nextInt();
                } while (Droids.objArr[tempcheck - 1].getTeamPointer() == 1
                        || Droids.objArr[tempcheck - 1].getTeamPointer() == 2);
                temp = tempcheck;
                if (temp == 0) {
                    break;
                }
            }
            team[i] = new Droids(Droids.objArr[temp - 1].getHealth(), Droids.objArr[temp - 1].getMinDamage(),
                    Droids.objArr[temp - 1].getMaxDamage(), Droids.objArr[temp - 1].getName());
            team[i].setClassPointer(Droids.objArr[temp - 1].getClassPointer());
            Droids.objArr[temp - 1].setteamPointer(check);
            team[i].setteamPointer(check);
            i++;
        }
        if (check == 1) {
            Droids.t1counter = i;
        } else {
            Droids.t2counter = i;
        }
    }
}
