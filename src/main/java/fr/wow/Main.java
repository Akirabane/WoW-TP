package fr.wow;

import fr.wow.items.Epee;
import fr.wow.items.Gourdin;
import fr.wow.personnages.Hero;
import fr.wow.personnages.Monstre;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class Main {

    private static final Logger LOG = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
        //Game starting debug
        LOG.info("Game Launched");
        LOG.info("Configuring the game");
        LOG.info("Creating teams...");
        //Creating the teams using user inputs
        LOG.info("Create your character : Name, HP");
        LOG.debug("Creating the hero by user inputs...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int hp = Integer.parseInt(reader.readLine());

        //instanciate the hero created by the user
        Hero hero = new Hero(name, hp);
        LOG.debug("Hero created: " + hero.getName() + " with " + hero.getHp() + " hp");
        //instanciate épée and give it to hero
        Epee epee = new Epee("Epee de test", 10, 1.5f, 1.5f);
        hero.setEpee(epee);
        LOG.debug("Hero got a sword: " + hero.getEpee().getName() + " with " + hero.getEpee().getDegats() + " damages");

        //AI creates the monster randomly
        LOG.debug("Creating the monster randomly...");
        //choosing a random name from list
        List<String> names = List.of("Goblin", "Orc", "Troll", "Golem", "Dragon");
        int min = 1;
        int max = names.size();
        int range = max - min + 1;
        int monstreName = 0;
        for (int i = 0; i < 10; i++) {
            int rand = (int) (Math.random() * range) + min;
            monstreName = rand;
        }

        //instanciate the monster
        Monstre monstre = new Monstre(names.get(monstreName), 25);
        LOG.debug("Monster created: " + monstre.getName() + " with " + monstre.getHp() + " hp");
        Gourdin gourdin = new Gourdin("Gourdin de test", 10, 1.5f, 1.5f);
        monstre.setGourdin(gourdin);
        LOG.debug("Monster got a club: " + monstre.getGourdin().getName() + " with " + monstre.getGourdin().getDegats() + " damages");
        LOG.info("Game is ready");
        LOG.info("Let's fight!");

        //First move when games starts
        Random random = new Random();
        int randomInt = random.nextInt(1000000000);
        if ((randomInt % 2) == 0) {
            LOG.debug(randomInt + " is even");
            LOG.info("The hero starts the fight");
            LOG.info("The hero attacks the monster");
            //attacking the monster
            monstre.setHp(monstre.getHp() - hero.getEpee().getDegats());
            LOG.info("The monster has " + monstre.getHp() + " hp left");
            LOG.info("The monster attacks the hero");
            hero.setHp(hero.getHp() - monstre.getGourdin().getDegats());
            LOG.info("The hero has " + hero.getHp() + " hp left");
        } else {
            LOG.debug(randomInt + " is odd");
            LOG.info("The monster starts the fight");
            LOG.info("The monster attacks the hero");
            //attacking the hero
            hero.setHp(hero.getHp() - monstre.getGourdin().getDegats());
            LOG.info("The hero has " + hero.getHp() + " hp left");
            LOG.info("The hero attacks the monster");
            //attacking the monster
            monstre.setHp(monstre.getHp() - hero.getEpee().getDegats());
            LOG.info("The monster has " + monstre.getHp() + " hp left");
        }

        //checking if the hero or monster is dead
        checkHp(hero, monstre);
        LOG.debug("They both survived the first round");

        //fight loop
        while (hero.getHp() > 0 && monstre.getHp() > 0) {
            LOG.info("The hero attacks the monster");
            //attacking the monster
            monstre.setHp(monstre.getHp() - hero.getEpee().getDegats());
            checkHp(hero, monstre);
            if(monstre.getHp() <= 0){
                break;
            }
            LOG.info("The monster has " + monstre.getHp() + " hp left");
            LOG.info("The monster attacks the hero");
            //attacking the hero
            hero.setHp(hero.getHp() - monstre.getGourdin().getDegats());
            checkHp(hero, monstre);
            if(hero.getHp() <= 0){
                break;
            }
            LOG.info("The hero has " + hero.getHp() + " hp left");
        }

        //end of the game
        LOG.info("The game is over");
        if (hero.getDead()) {
            LOG.info("The hero lost the fight");
        } else {
            LOG.info("The monster lost the fight");
        }
    }

    private static void checkHp(Hero hero, Monstre monstre) {
        if (hero.getHp() <= 0) {
            LOG.info("The hero is dead with " + hero.getHp() + " hp left");
            hero.setDead(true);
        } else if (monstre.getHp() <= 0) {
            LOG.info("The monster is dead with " + monstre.getHp() + " hp left");
            monstre.setDead(true);
        }
    }
}