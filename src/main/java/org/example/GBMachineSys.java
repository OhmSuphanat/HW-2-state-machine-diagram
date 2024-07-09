/**6510450976
 *Suphanat Sroyphet
 */
package org.example;

import java.util.Scanner;

public class GBMachineSys {
    public static void startMachine(GBMachine gbMachine) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(gbMachine.getName());
            System.out.println("Inventory: " + gbMachine.getInventory().size() + " gumballs.");
            System.out.println("Current State: " + gbMachine.getStateString());

            while (true) {
                System.out.print("Insert Quarter[I], Eject Quarter[E], Turn Crank[T] :");
                char command = scanner.nextLine().toLowerCase().charAt(0);
                try {
                    switch (command) {
                        case 'i':
                            gbMachine.insertQuarter();
                            System.out.println("You insert a Quarter.");
                            break;
                        case 'e':
                            gbMachine.ejectQuarter();
                            System.out.println("Quarter is ejected.");
                            break;
                        case 't':
                            gbMachine.turnCrank();
                            System.out.println("A gumball comes rolling out the slot.");
                            gbMachine.dispenseGumball();
                            break;
                    }
                    break;
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (gbMachine.getState() == 3) {
                System.out.println("Machine is sold out.");
                break;
            }
            System.out.println();
        }
    }

}
