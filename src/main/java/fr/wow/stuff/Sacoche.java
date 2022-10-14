package fr.wow.stuff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    //private Pommes pomme = new Pommes();

    //instanciate raisins
    //private Raisins raisin = new Raisins();

    // Attributes
    //private List<Epee> epeesTot = new ArrayList<>();
    //private List<Gourdin> gourdinsTot = new ArrayList<>();
    //private List<Pommes> pommesTot = new ArrayList<>();
    //private List<Raisins> raisinsTot = new ArrayList<>();

    private List<ISacoche> sacochable = new ArrayList<>();

    // Constructor
    public Sacoche() {
    }

    /**
     * Getter and setters for constructor parameters
     * @return
     */
    public List<Epee> getEpees() {
        //Recupérer les épées en filtre avec un stream.
        return sacochable.stream().filter(e -> e instanceof Epee).map(e -> (Epee) e).collect(Collectors.toList());
    }

    public void setEpees(List<Epee> epees) {
        this.sacochable.addAll(epees);
    }

    public List<Gourdin> getGourdins() {
        return sacochable.stream().filter(e -> e instanceof Gourdin).map(e -> (Gourdin) e).collect(Collectors.toList());
    }

    public void setGourdins(List<Gourdin> gourdins) {
        this.sacochable.addAll(gourdins);
    }

    public List<Pommes> getPommes() {
        return sacochable.stream().filter(e -> e instanceof Pommes).map(e -> (Pommes) e).collect(Collectors.toList());
    }

    public void setPommes(List<Pommes> pommes) {
        this.sacochable.addAll(pommes);
    }

    public List<Raisins> getRaisins() {
        return sacochable.stream().filter(e -> e instanceof Raisins).map(e -> (Raisins) e).collect(Collectors.toList());
    }

    public void setRaisins(List<Raisins> raisins) {
        this.sacochable.addAll(raisins);
    }

}
