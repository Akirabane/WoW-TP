package fr.wow;

import fr.wow.items.Epee;
import fr.wow.items.Gourdin;
import fr.wow.personnages.Hero;
import fr.wow.personnages.Monstre;
import fr.wow.stuff.Sacoche;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final Logger LOG = LogManager.getLogger();
    public static void main(String[] args) throws IOException {
        //Game starting debug
        LOG.info("Game Launched");
        LOG.debug("Configuring the game");
        LOG.debug("Creating teams...");
        //Creating the teams using user inputs
        LOG.info("Create your character : Name, HP");
        LOG.debug("Creating the hero by user inputs...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        //instanciate the hero created by the user
        Hero hero = new Hero(name, 30);
        LOG.info("Hero created: {} with {} hp", hero.getName(), hero.getHp());
        //create list of Epee and give them to the hero
        LOG.debug("Creating the list of Epee...");
        List<Epee> epees = new ArrayList<Epee>();
        epees.add(new Epee("Epee1", 10, 1.5f, 1.5f));
        epees.add(new Epee("Epee2", 10, 1.5f, 1.5f));
        epees.add(new Epee("Epee3", 10, 1.5f, 1.5f));
        Sacoche sacocheHero = new Sacoche();
        sacocheHero.setEpees(epees);
        LOG.debug("List of Epee created" + epees.stream().map(Epee::getName).reduce("", (a, b) -> a + " " + b));
        hero.setEpee(sacocheHero.getEpees());
        LOG.info("total d'épées possédées par le Hero: " + hero.getEpee().stream().map(Epee::getName).reduce("", (a, b) -> a + " " + b));
        LOG.debug("Hero has " + hero.getEpee().stream().map(epee1 -> {
            return epee1.getDegats();
        }).count() + " épée(s)");

        //AI creates the monster randomly
        LOG.debug("Creating the monster randomly...");
        //choosing a random name from list
        List<String> names = List.of("Goblin", "Orc", "Troll", "Golem", "Dragon");
        int monstreName = 0;
        for (int i = 0; i < 10; i++) {
            //Ne pas utiliser Math.random
            Random random = new Random();
            monstreName = random.nextInt(names.size());
        }

        //instanciate the monster
        Monstre monstre = new Monstre(names.get(monstreName), 25);
        LOG.debug("Monster created: {} with {} hp", monstre.getName(), monstre.getHp());
        List<Gourdin> gourdins = new ArrayList<Gourdin>();
        gourdins.add(new Gourdin("Gourdin1", 10, 1.5f, 1.5f));
        gourdins.add(new Gourdin("Gourdin2", 10, 1.5f, 1.5f));
        gourdins.add(new Gourdin("Gourdin3", 10, 1.5f, 1.5f));
        Sacoche sacocheMonstre = new Sacoche();
        sacocheMonstre.setGourdins(gourdins);
        LOG.debug("List of Gourdin created" + gourdins.stream().map(Gourdin::getName).reduce("", (a, b) -> a + " " + b));
        hero.setEpee(sacocheHero.getEpees());
        monstre.setGourdin(sacocheMonstre.getGourdins());
        LOG.info("total de gourdins possédés par le Monstre: {}", monstre.getGourdin().stream().map(Gourdin::getName).reduce("", (a, b) -> a + " " + b));
        LOG.debug("Monster has {} épée(s)", monstre.getGourdin().stream().map(gourdin1 -> {
            return gourdin1.getDegats();
        }).count() );

        //game starts
        LOG.info("Game is ready");
        LOG.info("Let's fight!");

        //First move after game starts
        Random random = new Random();
        boolean turn = random.nextBoolean();
        if (turn) {
            LOG.info("The hero starts the fight");
            LOG.info("The hero attacks the monster");
            //attacking the monster
            monstre.setHp(monstre.getHp() - hero.getEpee().get(0).getDegats());
            LOG.info("The monster has {} hp left", monstre.getHp());
            LOG.info("The monster attacks the hero");
            hero.setHp(hero.getHp() - monstre.getGourdin().get(0).getDegats());
            LOG.info("The hero has {} hp left", hero.getHp());
        } else {
            LOG.info("The monster starts the fight");
            LOG.info("The monster attacks the hero");
            //attacking the hero
            hero.setHp(hero.getHp() - monstre.getGourdin().get(0).getDegats());
            LOG.info("The hero has {} hp left", hero.getHp());
            LOG.info("The hero attacks the monster");
            //attacking the monster
            monstre.setHp(monstre.getHp() - hero.getEpee().get(0).getDegats());
            LOG.info("The monster has {} hp left", monstre.getHp());
        }

        //checking if the hero or monster is dead
        checkHp(hero, monstre);
        //switch case to check if hero or monster is dead
        if(!hero.getDead() && !monstre.getDead()){
            //fight loop
            while (!hero.getDead() && !monstre.getDead()) {
                LOG.info("The hero attacks the monster");
                //attacking the monster
                monstre.setHp(monstre.getHp() - hero.getEpee().get(0).getDegats());
                checkHp(hero, monstre);
                if(monstre.getHp() <= 0){
                    break;
                }
                LOG.info("The monster has {} hp left", monstre.getHp());
                LOG.info("The monster attacks the hero");
                //attacking the hero
                hero.setHp(hero.getHp() - monstre.getGourdin().get(0).getDegats());
                checkHp(hero, monstre);
                if(hero.getHp() <= 0){
                    break;
                }
                LOG.info("The hero has {} hp left", hero.getHp());
            }
            //end of the game
            LOG.info("The game is over");
            if (hero.getDead()) {
                LOG.info("The hero lost the fight");
            } else {
                LOG.info("The monster lost the fight");
            }
        }
    }

    /**
     * Check if the hero or the monster is dead and set the dead boolean parameter to true
     * @param hero
     * @param monstre
     */
    private static void checkHp(Hero hero, Monstre monstre) {
        if (hero.getHp() <= 0) {
            LOG.info("The hero is dead with {} hp left", hero.getHp());
            hero.setDead(true);
            LOG.debug("Hero is dead: {}", hero.getDead());
        }
        //Else if incorrect
        if (monstre.getHp() <= 0) {
            LOG.info("The monster is dead with {} hp left", monstre.getHp());
            monstre.setDead(true);
            LOG.debug("Monster is dead: {}", monstre.getDead());
        }
    }
}