/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirdtrailgame;

import Observe.Player;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import load.LoadSave;
import FruitsAndBombs.GameObjectsFruits;

/**
 *
 * @author Amr Ashraf
 */
public class GenerateObjects {
   private int speedupdate;
   private int count;

    public int getSpeedupdate() {
        return speedupdate;
    }

    public void setSpeedupdate(int speedupdate) {
        this.speedupdate = speedupdate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
   
   
    public ArrayList<GameObjectsFruits> fillList()
    {
        ArrayList<GameObjectsFruits> l=new ArrayList<>();
        if(Player.playerMaker().isLoad()){
            LoadSave ls=new LoadSave();
            try {
                l=ls.loadFruits();
            } catch (JAXBException ex) {
               
            }
            
            Player.playerMaker().setLoad(false);
        }
        else{
        count++;
        if(count%5 == 0)
            speedupdate+=2;
        
        
        Random r = new Random();
        int numberofobj  = r.nextInt(7);
        int x1 = 50,x2=700 ,y =400;
        for(int i = 0 ; i < numberofobj ; i++)
        {
            Random rr = new Random();
            int s = rr.nextInt(5);
            
            GameObjectsFruits g = getobject();
            g.setInitialVelocity(s+g.getInitialVelocity()+Player.playerMaker().getDifficulty()+speedupdate);
            g.setFallingVelocity(g.getFallingVelocity()+Player.playerMaker().getDifficulty()+speedupdate);
            if(i%2==0){
            g.setXLocation(x1);
              x1+=50;
              g.setPosition("l");
            }
            else{
              g.setXLocation(x2);
              x2+=50;
              g.setPosition("r");
            }
            g.setYLocation(y);
            l.add(g);
          
        }
        }
        return l;
    }
    
    public GameObjectsFruits getobject()
    {
        Factory f = new Factory();
        String objname=null;
        Random r = new Random();
        int x = r.nextInt(8);
        if (x==0)
            objname = "Apple";
        else if (x==1)
            objname = "Banana";
        else if (x==2)
            objname = "Orange";
        else if (x==3)
            objname = "Strawberry";
        else if (x==4)
            objname = "Pear";
        else if (x==5 && count%2==0)
            objname = "Bomb";
        else if (x==6 && count%2==0)
            objname = "FatalBomb";
        else if (x==7 && count%2==0)
            objname = "WatermelonPlus1Live";             
        else
             objname = "Apple";

        return f.objectMaker(objname);
    }
 
}
