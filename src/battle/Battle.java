package battle;

import java.util.Scanner;

import droids.Droids;

public class Battle {

    public static void choose() throws InterruptedException {
        System.out.println(Droids.ANSI_CYAN + "hint don`t choose medics" + Droids.ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose fighter 1 ");
        int temp = scanner.nextInt();
        System.out.println("choose fighter 2 ");
        int temp2 = scanner.nextInt();

        Arena arena = new Arena(Droids.objArr[temp - 1], Droids.objArr[temp2 - 1]);
        Droids winner = arena.startFight();

        System.out.println("--------------");
        System.out.println(Droids.ANSI_YELLOW + "The winner is " + winner.getName() + Droids.ANSI_RESET);
    }

}
