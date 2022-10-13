package fr.wow.personnages;

import fr.wow.items.Epee;

public class Hero {

    // Attributes
    private int hp;
    private String name;
    private boolean isDead;
    private Epee epee;

    // Constructor
    public Hero(String name, int hp) {
        setName(name);
        setHp(hp);
        setDead(false);
        setEpee(epee);
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

    public void setEpee(Epee epee) {
        this.epee = epee;
    }

    public Epee getEpee() {
        return epee;
    }
}
