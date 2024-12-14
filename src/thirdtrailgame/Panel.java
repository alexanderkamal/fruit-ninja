/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirdtrailgame;

import FruitsAndBombs.Bomb;
import FruitsAndBombs.FatalBomb;
import FruitsAndBombs.WatermelonPlus1Live;
import Gui.PlayJFrame;
import Observe.Player;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.xml.bind.JAXBException;
import load.LoadSave;
import FruitsAndBombs.GameObjectsFruits;

/**
 *
 * @author Amr Ashraf
 */
public class Panel extends JPanel  {

    int difficulty;
    ArrayList<GameObjectsFruits> gameobjects = new ArrayList<>();
    GenerateObjects gen = new GenerateObjects();
    GameTimer gt = new GameTimer(this);
    Timer t ;

    public Panel()  {
       
      
        MusicPlayer.startMusicStop();
        gameobjects = gen.fillList();
        difficulty=Player.playerMaker().getDifficulty();
       t = new Timer(100, gt);
        t.start();
        MouseMotionListner m = new MouseMotionListner(this);
        addMouseMotionListener(m);
    }
    

    @Override // there is an eror in set x and y
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Player.playerMaker().setDecisecond();
        for (GameObjectsFruits ob : gameobjects) {
             if(ob.isSplashpainted()){
                 if(ob instanceof Bomb || ob instanceof FatalBomb ||ob instanceof WatermelonPlus1Live  ){}
                else     
               g.drawImage(ob.getBufferedImage().get(2).getImage(), ob.getXLocation(), ob.getYLocation(), this);
              // ob.setSplashpainted(false); 
            }
            if(ob.isMovingUp() && ob.getYLocation() == 400){
                if(ob instanceof Bomb || ob instanceof FatalBomb)
                    MusicPlayer.throwBombMusic(); //not worked!!!!!!!!????
                else 
                    MusicPlayer.throwMusic();
            }
           
            if (!ob.isSliced()) {
                if(ob instanceof WatermelonPlus1Live){
                    if(((WatermelonPlus1Live) ob).getNofmove()%3==0)
                        g.drawImage(ob.getBufferedImage().get(2).getImage(), ob.getXLocation(), ob.getYLocation(), this);
                    else
                        g.drawImage(ob.getBufferedImage().get(0).getImage(), ob.getXLocation(), ob.getYLocation(), this);
                    ((WatermelonPlus1Live) ob).setNofmove();
                }else
                g.drawImage(ob.getBufferedImage().get(0).getImage(), ob.getXLocation(), ob.getYLocation(), this);
            } else {
                g.drawImage(ob.getBufferedImage().get(1).getImage(), ob.getXLocation(), ob.getYLocation(), this);
            }
        }
               
        
    }
    


   

}
