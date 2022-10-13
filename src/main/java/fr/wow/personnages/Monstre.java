package fr.wow.personnages;

import fr.wow.items.Gourdin;

public class Monstre {


    // Attributes
    private int hp;
    private String name;
    private boolean isDead;
    private Gourdin gourdin;

    // Constructor
    public Monstre(String name, int hp) {
        setName(name);
        setHp(hp);
        setDead(false);
        setGourdin(gourdin);
    }

    /**
     *
     * Getter and setters for constructor parameters
     *
     * @return
     */
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setGourdin(Gourdin gourdin) {
        this.gourdin = gourdin;
    }

    public Gourdin getGourdin() {
        return gourdin;
    }
}
