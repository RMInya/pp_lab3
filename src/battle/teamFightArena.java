package battle;

import java.util.Scanner;
import droids.Droids;
import menu.Outputs;

import java.util.concurrent.TimeUnit;

public class teamFightArena {
    private Droids[] firstDroids;
    private Droids[] secondDroids;
    private Droids[] attackers;
    private Droids[] defenders;
    int rangerCheacker;
    int rangerCheacker2;
    private int currentRound = 0;
    public static int attackerscounter;
    public static int defenderscounter;

    public teamFightArena(Droids[] first, Droids[] second) {
        this.firstDroids = first;
        this.secondDroids = second;
    }

    public Droids[] startTeamFight() throws InterruptedException {
        do {
            prepareRound();
            int actualDamage = Fight();
            printRoundInfo(actualDamage);

            TimeUnit.SECONDS.sleep(1);
        } while (isTheyAlive());

        // if(attackers == firstDroids){
        // return 1;
        // } else {
        // return 0;
        // }
        return attackers;
    }

    private void prepareRound() {
        InitializeTeamFight();
        currentRound++;
        if (currentRound == 1) {
            Outputs.teamsOutput(Droids.team1, Droids.team2);
            if (attackers[0].getTeamPointer() == 1) {
                System.out.println();
                System.out.println(Droids.ANSI_YELLOW + "team1 attacks first" + Droids.ANSI_RESET);
            } else {
                System.out.println();
                System.out.println(Droids.ANSI_YELLOW + "team2 attacks first" + Droids.ANSI_RESET);
            }
        }
        System.out.println(Droids.ANSI_BLUE + "-------------------------------------" + Droids.ANSI_RESET);
        System.out.println("Round " + currentRound);
    }

    public int Fight() {

        int heal = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose who to move ");
        int temp = scanner.nextInt();
        int temp2 = temp;

        if (attackers[temp - 1].getHealth() <= 0) {
            System.out.println("He is dead! choose another to move");
            do {
                temp2 = scanner.nextInt();
            } while (attackers[temp2 - 1].getHealth() <= 0);
            temp = temp2;
        }
        int hit = 0;
        int temphit = 0;
        if (attackers[temp - 1].getClassPointer() == "Ranger" || attackers[temp - 1].getClassPointer() == "Tank") {
            Scanner scan = new Scanner(System.in);
            System.out.println("choose who to hit ");
            temphit = scan.nextInt();
            hit = defenders[temphit - 1].getHit(attackers[temp - 1].getMinDamage(),
                    attackers[temp - 1].getMaxDamage());
        } else {
            Scanner s = new Scanner(System.in);
            System.out.println("Choose who to heal");
            heal = s.nextInt();
            attackers[heal - 1].getHealtshot();
        }
        if (hit > 0) {
            System.out.println();
            System.out.println(Droids.ANSI_CYAN + "\t     ACTION" + Droids.ANSI_RESET);
            System.out.println("---------------------------------");
            System.out.println(Droids.ANSI_GREEN + defenders[temphit - 1].getName() + Droids.ANSI_RESET
                    + " get hit with " + Droids.ANSI_BLACK + hit
                    + Droids.ANSI_RESET + " damage");
        } else {
            System.out.println();
            System.out.println(Droids.ANSI_CYAN + "\t     ACTION" + Droids.ANSI_RESET);
            System.out.println("---------------------------------");
            System.out.println(Droids.ANSI_GREEN + attackers[heal - 1].getName() + Droids.ANSI_RESET + Droids.ANSI_RED
                    + " got healed " + Droids.ANSI_RESET);
        }
        return hit;
    }

    private void printRoundInfo(int actualDamage) {
        System.out.println("---------------------------------");
        System.out.println(Droids.ANSI_CYAN + "hint: They are next to attack" + Droids.ANSI_RESET);
        for (int i = 0; i < defenderscounter; i++) {
            if (defenders[i].getHealth() <= 0) {
                System.out.println("Defender " + defenders[i].getName() + Droids.ANSI_BLACK + " DEAD " +
                        Droids.ANSI_RESET);
            } else {
                System.out.println("Defender " + defenders[i].getName() + " health left " + Droids.ANSI_RED +
                        defenders[i].getHealth() + Droids.ANSI_RESET);
            }
        }
        System.out.println("---------------------------------");
        for (int i = 0; i < attackerscounter; i++) {
            if (attackers[i].getHealth() <= 0) {
                System.out.println("Attacker " + attackers[i].getName() + Droids.ANSI_BLACK + " DEAD " +
                        Droids.ANSI_RESET);
            } else {
                System.out.println("Attacker " + attackers[i].getName() + " health left " + Droids.ANSI_RED +
                        attackers[i].getHealth() + Droids.ANSI_RESET);
            }
        }
    }

    int check = 1;

    public void InitializeTeamFight() {
        for (int i = 0; i < Droids.t1counter; i++) {
            if (firstDroids[i].getClassPointer() == "Ranger") {
                rangerCheacker = 1;
            }
        }
        for (int i = 0; i < Droids.t2counter; i++) {
            if (secondDroids[i].getClassPointer() == "Ranger") {
                rangerCheacker2 = 1;
            }
        }
        if (rangerCheacker == 0 && rangerCheacker2 == 1) {
            if (check == 1) {
                attackers = secondDroids;
                attackerscounter = Droids.t2counter;
                defenders = firstDroids;
                defenderscounter = Droids.t1counter;
                check = 0;
            } else {
                attackers = firstDroids;
                attackerscounter = Droids.t1counter;
                defenders = secondDroids;
                defenderscounter = Droids.t2counter;
                check = 1;
            }
        } else {
            if (check == 1) {
                attackers = firstDroids;
                attackerscounter = Droids.t1counter;
                defenders = secondDroids;
                defenderscounter = Droids.t2counter;
                check = 0;
            } else {
                attackers = secondDroids;
                attackerscounter = Droids.t2counter;
                defenders = firstDroids;
                defenderscounter = Droids.t1counter;
                check = 1;
            }
        }
    }

    public boolean isTheyAlive() {
        int life = 0;
        for (int i = 0; i < defenderscounter; i++) {
            if (defenders[i].getHealth() <= 0) {
                life++;
            }
        }
        return life < defenderscounter;
    }
}

