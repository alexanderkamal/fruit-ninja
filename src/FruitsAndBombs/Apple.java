/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitsAndBombs;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import thirdtrailgame.GenerateObjects;

/**
 *
 * @author Amr Ashraf
 */
public class Apple implements GameObjectsFruits{
    
    
    
boolean slice=false;
boolean offscreen=false;
boolean movingup=true;
int x=200 , y=250;
int intialvelocity=15,fallingvelocity=25;
int score = 20;
String position;
boolean splashpainted=false;
int v=0;

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

@Override
    public boolean isSplashpainted() {
        return splashpainted;
    }

@Override
    public void setSplashpainted(boolean splashpainted) {
        this.splashpainted = splashpainted;
    }



@Override
    public String getPosition() {
        return position;
    }

@Override
    public void setPosition(String position) {
        this.position = position;
    }




    @Override
    public void setSlice(boolean slice) {
        this.slice=slice;
    }
    
@Override
     public boolean isSliced() {
        return slice;
    }

    @Override
    public boolean hasMovedOffScreen() {
       return offscreen;
    }

    @Override
    public void setMovedOff(boolean moved) {
        offscreen=moved;
    }

    @Override
    public boolean isMovingUp() {
        return movingup;
    }

  
    @Override
    public void setMovingUp(boolean movingUp) {
       this.movingup=movingUp;
    }

    @Override
    public int getXLocation() {
      return x;
    }

    @Override
    public void setXLocation(int x) {
        this.x=x;
    }

    @Override
    public int getYLocation() {
       return y;
    }
    
    @Override
    public void setYLocation(int y) {
     this.y=y;
    }

    @Override
    public int getInitialVelocity() {
    return intialvelocity;
    }

    @Override
    public int getFallingVelocity() {
        return fallingvelocity;
    }
    
     @Override
    public void setInitialVelocity(int iv) {
        intialvelocity=iv;
    }

    @Override
    public void setFallingVelocity(int fv) {
         fallingvelocity=fv;
    }

    

    @Override
    public ArrayList<ImageIcon> getBufferedImage() {
       ArrayList<ImageIcon> images = new ArrayList<>();
       ImageIcon i1 = new ImageIcon("app.png");
       ImageIcon i2 = new ImageIcon("sap.png");
       ImageIcon i3 = new ImageIcon("redSplash1.png");
       images.add(i1) ;
       images.add(i2);
       images.add(i3);
       return images;
    }

    @Override
    public void MoveUp() {
        
        Random r = new Random();
        int n = r.nextInt(6);
          
                setYLocation(getYLocation() - getInitialVelocity());
                if(getPosition().equals("r"))
                setXLocation(getXLocation()-getInitialVelocity()-n);
                else
                    setXLocation(getXLocation()+getInitialVelocity()-n);
                    
                if (getYLocation() < 1) {
                    setMovingUp(false);
                }
    }

    @Override
    public void MoveDown() {
        Random r = new Random();
        int n = r.nextInt(6);
        
         setYLocation(getYLocation() + getFallingVelocity());
         if(getPosition().equals("r"))
                setXLocation(getXLocation()-getInitialVelocity()-n);
                else
                    setXLocation(getXLocation()+getInitialVelocity()-n);
    
    }

    @Override
    public int getScore() {
       return score;
    }

   
    
}
