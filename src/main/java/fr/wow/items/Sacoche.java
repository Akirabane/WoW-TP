package fr.wow.items;

import java.util.List;

public class Sacoche {

    // Attributes
    private List<Epee> epees;
    private List<Gourdin> gourdins;
    private List<Pommes> pommes;
    private List<Raisins> raisins;

    // Constructor
    public Sacoche() {
        super();
        setEpees(epees);
        setGourdins(gourdins);
        setPommes(pommes);
        setRaisins(raisins);
    }


    /**
     * Getter and setters for constructor parameters
     * @return
     */
    public List<Epee> getEpees() {
        return epees;
    }

    public void setEpees(List<Epee> epees) {
        if(epees.size() > 3) {
            System.out.println("Vous ne pouvez pas avoir plus de 3 épées dans votre saccoche");
        } else {
            this.epees = epees;
        }
    }

    public List<Gourdin> getGourdins() {
        return gourdins;
    }

    public void setGourdins(List<Gourdin> gourdins) {
        this.gourdins = gourdins;
    }

    public List<Pommes> getPommes() {
        return pommes;
    }

    public void setPommes(List<Pommes> pommes) {
        if(pommes.size() > 1) {
            System.out.println("Vous ne pouvez pas avoir plus de 1 pommes dans votre saccoche");
        } else {
            this.pommes = pommes;
        }
    }

    public List<Raisins> getRaisins() {
        return raisins;
    }

    public void setRaisins(List<Raisins> raisins) {
        if (raisins.size() > 1) {
            System.out.println("Vous ne pouvez pas avoir plus de 1 raisins dans votre saccoche");
        } else {
            this.raisins = raisins;
        }
    }
}
