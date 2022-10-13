package fr.wow.personnages;

public class Hero {

    // Attributes
    private int hp;
    private String name;
    private boolean hasArme;
    private boolean isDead;

    // Constructor
    public Hero(String name, int hp, boolean hasArme) {
        setName(name);
        setHp(hp);
        setHasArme(hasArme);
        setDead(false);
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

    public boolean getHasArme() {
        return hasArme;
    }

    public void setHasArme(boolean hasArme) {
        this.hasArme = hasArme;
    }

    public boolean getDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
