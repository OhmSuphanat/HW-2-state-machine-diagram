/**6510450976
 *Suphanat Sroyphet
 */
package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class GBMachine {
    private String name;
    private ArrayList<GumBall> inventory;
    private int state;

    public GBMachine(String name, int capacity) {
        this.name = name;
        this.inventory = getBuildInGums(capacity);
        this.state = 0;
    }

    private ArrayList<GumBall> getBuildInGums(int n) {
        ArrayList<GumBall> gumBalls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gumBalls.add(new GumBall());
        }
        return gumBalls;
    }

    public void insertQuarter() {
        if (state != 0) {
            throw new StateException();
        }
        setState(1);
    }

    public void ejectQuarter() {
        if (state != 1) {
            throw new StateException();
        }
        setState(0);

    }

    public void turnCrank() {
        if (state != 1) {
            throw new StateException();
        }
        setState(2);
    }

    public void dispenseGumball() {
        if (state != 2) {
            throw new StateException();
        }
        inventory.remove(inventory.size()-1);
        setState(0);
        if (inventory.isEmpty()) {
            setState(3);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<GumBall> getInventory() {
        return inventory;
    }

    public int getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(ArrayList<GumBall> inventory) {
        this.inventory = inventory;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateString() {
        ArrayList<String> allState = new ArrayList<>(Arrays.asList("No Quarter", "Has Quarter",
                "Gumball Sold", "Out of Gumball"));
        return allState.get(this.state);
    }
}
