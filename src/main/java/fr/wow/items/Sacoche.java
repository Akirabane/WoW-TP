package fr.wow.items;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sacoche {

    //logger
    private static final Logger LOG = LogManager.getLogger();

    // Attributes
    private List<Epee> epees;
    private List<Gourdin> gourdins;
    private List<Pommes> pommes;
    private List<Raisins> raisins;

    // Constructor
    public Sacoche() {
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
        this.epees = epees;
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
        this.pommes = pommes;
    }

    public List<Raisins> getRaisins() {
        return raisins;
    }

    public void setRaisins(List<Raisins> raisins) {
        this.raisins = raisins;
    }
}
