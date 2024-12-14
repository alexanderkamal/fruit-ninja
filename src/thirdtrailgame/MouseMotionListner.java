/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirdtrailgame;

import FruitsAndBombs.Bomb;
import FruitsAndBombs.FatalBomb;
import FruitsAndBombs.WatermelonPlus1Live;
import Observe.Player;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import FruitsAndBombs.GameObjectsFruits;

/**
 *
 * @author Amr Ashraf
 */
public class MouseMotionListner implements MouseMotionListener {
    //ArrayList<GameObjectsInt> gameobjects = new ArrayList<>();

    Panel p;

    public MouseMotionListner(Panel p) {
        //this.gameobjects=gameobjects;
        this.p = p;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!Player.playerMaker().isPause()) {
            int x = e.getX();
            int y = e.getY();

            for (GameObjectsFruits ob : p.gameobjects) {

                if (!ob.isSliced()) {
                    if (x >= ob.getXLocation() && x <= ob.getXLocation() + ob.getBufferedImage().get(0).getIconWidth()) {
                        if (y >= ob.getYLocation() && y <= ob.getYLocation() + ob.getBufferedImage().get(0).getIconHeight()) {
                            ob.setMovingUp(false);
                            ob.setSlice(true);
                            ob.setSplashpainted(true);
                          if(ob instanceof Bomb){
                                MusicPlayer.bombMusic();
                              Player.playerMaker().setLives(Player.playerMaker().getLives()-1);
                                // MusicPlayer.loseLifeMusic();
                          }else if(ob instanceof FatalBomb){
                                MusicPlayer.bombMusic();
                                Player.playerMaker().setLives(0);
                          }else if(ob instanceof WatermelonPlus1Live){
                                MusicPlayer.liveUpMusic();
                              Player.playerMaker().setLives(Player.playerMaker().getLives()+1);
                          } else
                                MusicPlayer.sliceMusic();
                            int score = Player.playerMaker().getScore();
                        Player.playerMaker().setScore(score+ob.getScore());
                        }

                    }
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
