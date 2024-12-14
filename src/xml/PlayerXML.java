/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author STAR
 */
@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerXML {
    
    @XmlElement(name = "score")
    private int score;
    @XmlElement(name = "minutes")
    private int min;
    @XmlElement(name = "seconds")
    private int sec;
    @XmlElement(name = "lives")
    private int lives;
    @XmlElement(name = "game_objects")
    private GameObjectsXML gameObjects;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public GameObjectsXML getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(GameObjectsXML gameObjects) {
        this.gameObjects = gameObjects;
    }
    
    
}
