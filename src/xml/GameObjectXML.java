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
@XmlRootElement(name = "game_object")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameObjectXML {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "position")
    private String position;
    @XmlElement(name = "x-axis")
    private int x;
    @XmlElement(name = "y-axis")
    private int y;
    @XmlElement(name = "initial_velocity")
    private int initialvelocity;
    @XmlElement(name = "falling_velocity")
    private int fallingvelocity;
    @XmlElement(name = "score")
    private int score;
    @XmlElement(name = "sliced")
    private boolean slice;
    @XmlElement(name = "offscreen")
    private boolean offscreen;
    @XmlElement(name = "moving_up")
    private boolean movingup;
    @XmlElement(name = "splash_painted")
    private boolean splashpainted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getInitialvelocity() {
        return initialvelocity;
    }

    public void setInitialvelocity(int initialvelocity) {
        this.initialvelocity = initialvelocity;
    }

    public int getFallingvelocity() {
        return fallingvelocity;
    }

    public void setFallingvelocity(int fallingvelocity) {
        this.fallingvelocity = fallingvelocity;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isSlice() {
        return slice;
    }

    public void setSlice(boolean slice) {
        this.slice = slice;
    }

    public boolean isOffscreen() {
        return offscreen;
    }

    public void setOffscreen(boolean offscreen) {
        this.offscreen = offscreen;
    }

    public boolean isMovingup() {
        return movingup;
    }

    public void setMovingup(boolean movingup) {
        this.movingup = movingup;
    }

    public boolean isSplashpainted() {
        return splashpainted;
    }

    public void setSplashpainted(boolean splashpainted) {
        this.splashpainted = splashpainted;
    }
    
    
}
