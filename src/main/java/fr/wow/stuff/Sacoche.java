package fr.wow.stuff;

import java.util.ArrayList;
import java.util.List;

import fr.wow.items.Epee;
import fr.wow.items.Gourdin;
import fr.wow.items.Pommes;
import fr.wow.items.Raisins;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sacoche {

    //logger
    private static final Logger LOG = LogManager.getLogger();

    //instanciate pommes
    private Pommes pomme = new Pommes();

    //instanciate raisins
    private Raisins raisin = new Raisins();

    // Attributes
    private List<Epee> epeesTot = new ArrayList<>();
    private List<Gourdin> gourdinsTot = new ArrayList<>();
    private List<Pommes> pommesTot = new ArrayList<>();
    private List<Raisins> raisinsTot = new ArrayList<>();

    // Constructor
    public Sacoche() {
        setEpees(epeesTot);
        setGourdins(gourdinsTot);
        setPommes(pommesTot);
        setRaisins(raisinsTot);
    }

    /**
     * Getter and setters for constructor parameters
     * @return
     */
    public List<Epee> getEpees() {
        return epeesTot.stream().toList();
    }

    public void setEpees(List<Epee> epees) {
        this.epeesTot = epees;
    }

    public List<Gourdin> getGourdins() {
        return gourdinsTot.stream().toList();
    }

    public void setGourdins(List<Gourdin> gourdins) {
        this.gourdinsTot = gourdins;
    }

    public List<Pommes> getPommes() {
        return pommesTot.stream().toList();
    }

    public void setPommes(List<Pommes> pommes) {
        this.pommesTot = pommes;
    }

    public List<Raisins> getRaisins() {
        return raisinsTot.stream().toList();
    }

    public void setRaisins(List<Raisins> raisins) {
        this.raisinsTot = raisins;
    }

}
