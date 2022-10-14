package fr.wow.items;

import fr.wow.stuff.ISacoche;

public class Gourdin implements ISacoche {

    // Attributes
    private String name;
    private int degats;
    private float longueur;
    private float poids;
    private boolean isBroken;

    // Constructor
    public Gourdin(String name, int degats, float longueur, float poids) {
        setName(name);
        setDegats(degats);
        setLongueur(longueur);
        setPoids(poids);
        setBroken(false);
    }

    /**
     *
     * Getter and setters for constructor parameters
     *
     * @return
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public float getLongueur() {
        return longueur;
    }

    public void setLongueur(float longueur) {
        this.longueur = longueur;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public boolean getBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }
}
