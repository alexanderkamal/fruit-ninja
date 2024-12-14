/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitsAndBombs;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public interface GameObjectsFruits {
    public int getScore();
    public void setSlice(boolean Slice);
    public boolean hasMovedOffScreen();
    public void setMovedOff(boolean moved);
    public boolean isMovingUp();
    public boolean isSliced();
    public void setMovingUp(boolean movingUp);
    public int getXLocation();
    public void setXLocation(int x);
    public int getYLocation();
    public int getInitialVelocity();
    public int getFallingVelocity();
    public void setYLocation(int y);
    public ArrayList<ImageIcon> getBufferedImage();
    public void MoveUp();
    public void MoveDown();
    public void setInitialVelocity(int iv);
    public void setFallingVelocity(int fv);
     public String getPosition();
    public void setPosition(String position);
     public boolean isSplashpainted();
    public void setSplashpainted(boolean splashpainted);
  
    
    
}
