package droids;

import java.util.*;
import menu.*;

public class Droids {
    private String name;
    private int health;
    private int maxdamage;
    private int mindamage;
    public static int counter = 0;
    private String classpointer;
    private int teamPointer;
    public static int t1counter;
    public static int t2counter;
    public static Droids[] objArr = new Droids[10];
    static int check = 1;
    public static Droids[] team1 = new Droids[5];
    public static Droids[] team2 = new Droids[5];

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public Droids(int health, int mindamage, int maxdamage, String name) {
        this.health = health;
        this.maxdamage = maxdamage;
        this.mindamage = mindamage;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public int getHealth() {
        return health;
    }

    public String getClassPointer() {
        return classpointer;
    }

    public void setClassPointer(String cp) {
        this.classpointer = cp;
    }

    public int getMinDamage() {
        return mindamage;
    }

    public int getMaxDamage() {
        return maxdamage;
    }

    public void setteamPointer(int tp) {
        this.teamPointer = tp;
    }

    public int getTeamPointer() {
        return teamPointer;
    }

    public static void creation() {
        while (true) {
            if (counter == 10) {
                System.out.println("Droids Max");
                break;
            }
            System.out.println(Droids.ANSI_BLUE + "Droid classes:\n1:Ranger\n2:Tank\n3:Medic" + Droids.ANSI_RESET);
            Scanner scanner = new Scanner(System.in);
            System.out.println("choose droid " + (counter + 1) + " class ");
            int index = scanner.nextInt();
            if (index == 1) {
                createRanger();
            }
            if (index == 2) {
                createTank();
            }
            if (index == 3) {
                createMedic();
            }
            counter++;
            break;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHit(int mindamage, int maxdamage) {
        Random random = new Random();

        int actualDamage = random.nextInt(mindamage, maxdamage);
        this.health -= actualDamage;

        if (health < 0) {
            health = 0;
        }

        return actualDamage;
    }

    public static void makeTeams() {
        int check = 1;
        System.out.println("\nfill team 1\n");
        Outputs.fillTeam(team1, check);
        check = 2;
        System.out.println("\nfill team 2\n");
        Outputs.fillTeam(team2, check);
    }

    public int getHealtshot() {
        int actualDamage = 0;
        this.health += 30;
        return actualDamage;
    }

    public static void createMedic() {
        Scanner scan = new Scanner(System.in);
        System.out.println("choose droid name");
        String name = scan.nextLine();
        int medicHealth = 100;
        int medicMaxDamage = 0, medicMinDamage = 0;
        objArr[counter] = new Droids(medicHealth, medicMinDamage, medicMaxDamage, name);
        objArr[counter].setClassPointer("Medic");
    }

    public static void createRanger() {
        Scanner scan = new Scanner(System.in);
        System.out.println("choose droid name");
        String name = scan.nextLine();
        int rangerhealth = 150;
        int rangerMaxDamage = 40, rangerMinDamage = 30;
        objArr[counter] = new Droids(rangerhealth, rangerMinDamage, rangerMaxDamage, name);
        objArr[counter].setClassPointer("Ranger");
    }

    public static void createTank() {
        Scanner scan = new Scanner(System.in);
        System.out.println("choose droid name");
        String name = scan.nextLine();
        int tankHealth = 250;
        int tankMaxDamage = 29, tankMinDamage = 20;
        objArr[counter] = new Droids(tankHealth, tankMinDamage, tankMaxDamage, name);
        objArr[counter].setClassPointer("Tank");
    }
}
