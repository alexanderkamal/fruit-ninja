/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package load;

import FruitsAndBombs.Apple;
import FruitsAndBombs.Banana;
import FruitsAndBombs.Bomb;
import FruitsAndBombs.FatalBomb;
import FruitsAndBombs.Orange;
import FruitsAndBombs.Pear;
import FruitsAndBombs.Strawberry;
import FruitsAndBombs.WatermelonPlus1Live;
import Observe.Player;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import xml.GameObjectXML;
import xml.GameObjectsXML;
import xml.PlayerXML;
import FruitsAndBombs.GameObjectsFruits;
import java.io.IOException;
import xml.Easy;
import xml.Hard;
import xml.HighScore;
import xml.Normal;

/**
 *
 * @author STAR
 */
public class LoadSave {

    public void save(ArrayList<GameObjectsFruits> fruits) throws JAXBException {
        int score, minute, second, live;
        JAXBContext jax = JAXBContext.newInstance(PlayerXML.class);
        List<GameObjectXML> gg = new ArrayList<>();
        PlayerXML player = new PlayerXML();
        score = Player.playerMaker().getScore();
        minute = Player.playerMaker().getMinutes();
        second = Player.playerMaker().getSecond();
        live = Player.playerMaker().getLives();
        player.setLives(live);
        player.setMin(minute);
        player.setScore(score);
        player.setSec(second);
        for (int i = 0; i < fruits.size(); i++) {
            GameObjectXML game = new GameObjectXML();
            game.setPosition(fruits.get(i).getPosition());
            game.setFallingvelocity(fruits.get(i).getFallingVelocity());
            game.setInitialvelocity(fruits.get(i).getInitialVelocity());
            game.setMovingup(fruits.get(i).isMovingUp());
            game.setOffscreen(fruits.get(i).hasMovedOffScreen());
            game.setScore(fruits.get(i).getScore());
            game.setSlice(fruits.get(i).isSliced());
            game.setSplashpainted(fruits.get(i).isSplashpainted());
            game.setX(fruits.get(i).getXLocation());
            game.setY(fruits.get(i).getYLocation());
            if (fruits.get(i) instanceof Apple) {
                game.setName("Apple");
            } else if (fruits.get(i) instanceof Orange) {
                game.setName("Orange");
            } else if (fruits.get(i) instanceof Banana) {
                game.setName("Banana");
            } else if (fruits.get(i) instanceof Strawberry) {
                game.setName("Strawberry");
            } else if (fruits.get(i) instanceof WatermelonPlus1Live) {
                game.setName("WatermelonPlus1Live");
            } else if (fruits.get(i) instanceof Pear) {
                game.setName("Pear");
            } else if (fruits.get(i) instanceof Bomb) {
                game.setName("Bomb");
            } else if (fruits.get(i) instanceof FatalBomb) {
                game.setName("FatalBomb");
            }
            gg.add(game);
        }
        GameObjectsXML ob = new GameObjectsXML();
        ob.setGameObject(gg);
        player.setGameObjects(ob);
        Marshaller m = jax.createMarshaller();
        m.marshal(player, new File("LastGame.xml"));
    }

    public ArrayList<GameObjectsFruits> loadFruits() throws JAXBException {
        ArrayList<GameObjectsFruits> fruits = new ArrayList<>();
        try {
            JAXBContext jax = JAXBContext.newInstance(PlayerXML.class);
            Unmarshaller unmar = jax.createUnmarshaller();
            PlayerXML p = (PlayerXML) unmar.unmarshal(new File("LastGame.xml"));
            List<GameObjectXML> l = p.getGameObjects().getGameObject();
            Player.playerMaker().setScore(p.getScore());
            Player.playerMaker().setLives(p.getLives());
            Player.playerMaker().setMinutes(p.getMin());
            Player.playerMaker().setSecond(p.getSec());
            int i = 0;
            for (GameObjectXML game : l) {

                switch (game.getName()) {
                    case "Apple":
                        fruits.add(new Apple());
                        break;
                    case "Banana":
                        fruits.add(new Banana());
                        break;
                    case "Strawberry":
                        fruits.add(new Strawberry());
                        break;
                    case "Bomb":
                        fruits.add(new Bomb());
                        break;
                    case "FatalBomb":
                        fruits.add(new FatalBomb());
                        break;
                    case "WatermelonPlus1Live":
                        fruits.add(new WatermelonPlus1Live());
                        break;
                    case "Pear":
                        fruits.add(new Pear());
                        break;
                    case "Orange":
                        fruits.add(new Orange());
                        break;
                }
                fruits.get(i).setFallingVelocity(game.getFallingvelocity());
                fruits.get(i).setInitialVelocity(game.getInitialvelocity());
                fruits.get(i).setMovedOff(game.isOffscreen());
                fruits.get(i).setMovingUp(game.isMovingup());
                fruits.get(i).setPosition(game.getPosition());
                fruits.get(i).setSplashpainted(game.isSplashpainted());
                fruits.get(i).setXLocation(game.getX());
                fruits.get(i).setYLocation(game.getY());
                fruits.get(i).setSlice(game.isSlice());
                i++;
            }
        } catch (JAXBException e) {

        }
        return fruits;
    }

    public void saveHighScore() throws JAXBException {
        HighScore hg = new HighScore();
        JAXBContext jax = JAXBContext.newInstance(HighScore.class);
        try {
            Unmarshaller unmar = jax.createUnmarshaller();
            hg = (HighScore) unmar.unmarshal(new File("HighestScores.xml"));
            switch (Player.playerMaker().getDifficulty()) {
                case 0:
                    if (Player.playerMaker().getScore() > hg.getEasy().getHighscore()) {
                        Easy easy = new Easy();
                        easy.setHighscore(Player.playerMaker().getScore());
                        easy.setMin(Player.playerMaker().getMinutes());
                        easy.setSec(Player.playerMaker().getSecond());
                        hg.setEasy(easy);
                    }
                    break;
                case 5:
                    if (Player.playerMaker().getScore() > hg.getNormal().getHighscore()) {
                        Normal normal = new Normal();
                        normal.setHighscore(Player.playerMaker().getScore());
                        normal.setMin(Player.playerMaker().getMinutes());
                        normal.setSec(Player.playerMaker().getSecond());
                        hg.setNormal(normal);
                    }
                    break;
                case 10:
                    if (Player.playerMaker().getScore() > hg.getHard().getHighscore()) {
                        Hard hard = new Hard();
                        hard.setHighscore(Player.playerMaker().getScore());
                        hard.setMin(Player.playerMaker().getMinutes());
                        hard.setSec(Player.playerMaker().getSecond());
                        hg.setHard(hard);
                    }
                    break;
            }
        } catch (JAXBException ex) {

        }
        Marshaller m = jax.createMarshaller();
        m.marshal(hg, new File("HighestScores.xml"));
    }

    public int loadHighScore() throws JAXBException {
        HighScore hg = new HighScore();
        JAXBContext jax = JAXBContext.newInstance(HighScore.class);
        int score = 0;
        try {
            Unmarshaller unmar = jax.createUnmarshaller();
            hg = (HighScore) unmar.unmarshal(new File("HighestScores.xml"));
            switch (Player.playerMaker().getDifficulty()) {
                case 0:
                    score = hg.getEasy().getHighscore();
                    break;
                case 5:
                    score = hg.getNormal().getHighscore();
                    break;
                case 10:
                    score = hg.getHard().getHighscore();
                    break;
            }
        } catch (JAXBException ex) {

        }
        return score;
    }

    public void delete() throws JAXBException, IOException {
        File f = new File("LastGame.xml");
        f.delete();
        f.createNewFile();
    }
}
