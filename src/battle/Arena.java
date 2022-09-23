package battle;

import droids.Droids;
import java.util.concurrent.TimeUnit;

public class Arena {
    private final Droids firstDroid;
    private final Droids secondDroid;
    private Droids attacker;
    private Droids defender;
    private int currentRound = 0;
    int check = 1;

    public Arena(Droids firstDroid, Droids secondDroid) {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }

    public Droids startFight() throws InterruptedException {
        do {
            prepareRound();
            int actualDamage = doFight();
            printRoundInfo(actualDamage);

            TimeUnit.SECONDS.sleep(1);
        } while (defender.isAlive());

        return attacker;
    }

    private void prepareRound() {
        initFighters();
        currentRound++;
        System.out.println("-------------------------------------");
        System.out.println("Round " + currentRound);
    }

    private int doFight() {
        return defender.getHit(attacker.getMinDamage(), attacker.getMaxDamage());
    }

    private void printRoundInfo(int actualDamage) {
        System.out.println(defender.getName() + " get hit with " + actualDamage + " damage");
        System.out.println("Defender " + defender.getName() + " health left " + defender.getHealth());
        System.out.println("Attacker " + attacker.getName() + " health left " + attacker.getHealth());
    }

    private void initFighters() {
        if (secondDroid.getClassPointer() == "Ranger" && firstDroid.getClassPointer() != "Ranger") {
            if (check == 1) {
                attacker = secondDroid;
                defender = firstDroid;
                check = 0;
            } else {
                attacker = firstDroid;
                defender = secondDroid;
                check = 1;
            }
        } else {
            if (check == 1) {
                attacker = firstDroid;
                defender = secondDroid;
                check = 0;
            } else {
                attacker = secondDroid;
                defender = firstDroid;
                check = 1;
            }
        }
    }
}

