/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observe;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Amr Ashraf
 */
public class Player {
  private int score;
  private static Player p=null;
  private ArrayList<Observer> list = new ArrayList<>();
  private int lives=3;
  private int extralives=0;
  private int difficulty;
  private int minutes;
  private int second;
  private int decisecond;
  private boolean pause = false;
  private boolean save=false;
  private boolean soundon=true;
  private boolean retry=false;
  private boolean load=false;
  
          
                  
  
  
    public static Player playerMaker(){
        if (p==null)
            p= new Player();
        return p;
        
    }
  
    public boolean isLoad() {   
        return load;
    }

    public void setLoad(boolean load) {
        this.load = load;
    }
  
  

    public boolean isRetry() {
        return retry;
    }

    public void setRetry(boolean retry) {
        this.retry = retry;
    }
  
  

    public boolean isSoundon() {
        return soundon;
    }

    public void setSoundon(boolean soundon) {
        this.soundon = soundon;
    }
  
  
  

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }
  
  

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
  
  private Player() {
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        if(second==60){
            setMinutes(getMinutes()+1);
            this.second=0;
        }
    }

    public int getDecisecond() {
        return decisecond;
    }

    public void setDecisecond() {
        decisecond++;
        if(decisecond==10){
            setSecond(getSecond()+1);
            decisecond=0;
        }
       notifyob();
    }
  
  
  
  

    public int getExtralives() {
        return extralives;
    }

    public void setExtralives() {
        extralives++;
    }
  
  

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
  
  
    
    

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
        notifyob();
    }
    
    
    public void addobserver(Observer o){
        list.add(o);
    }
    
    public void notifyob(){
        for (Observer x : list) {
            x.update();  
        }
    }
    
  

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        notifyob();
    }
    
    
    
}
