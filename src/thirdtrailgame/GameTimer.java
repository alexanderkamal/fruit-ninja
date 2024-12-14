/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirdtrailgame;

import Command.MoveDownCommand;
import Command.MoveUpCommand;
import FruitsAndBombs.Bomb;
import FruitsAndBombs.FatalBomb;
import FruitsAndBombs.WatermelonPlus1Live;
import Observe.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import load.LoadSave;
import FruitsAndBombs.GameObjectsFruits;

/**
 *
 * @author Amr Ashraf
 */
public class GameTimer implements ActionListener {

    Panel p;
    GenerateObjects gen = new GenerateObjects();

    public GameTimer(Panel p) {
        //this.gameobjects=gameobjects;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Player.playerMaker().isRetry()){
            Player.playerMaker().setRetry(false);
            Player.playerMaker().setPause(false);
               p.gameobjects.clear();
                gen.setCount(0);
                gen.setSpeedupdate(0);
                p.gameobjects = gen.fillList();
        }
        if (Player.playerMaker().isPause()) {
            if (Player.playerMaker().isSave()) {
                LoadSave l = new LoadSave();
                try {
                    l.save(p.gameobjects);
                } catch (JAXBException ex) {

                }
                
            }
        } else {
            ArrayList<GameObjectsFruits> gameobjects = p.gameobjects;


            for (int i = 0; i < p.gameobjects.size(); i++) {
                if (p.gameobjects.get(i).isMovingUp()) {
                    MoveUpCommand m = new MoveUpCommand(p.gameobjects.get(i));
                    m.doCommand();
                } else {
                    MoveDownCommand m = new MoveDownCommand(p.gameobjects.get(i));
                    m.doCommand();
                }
                if (p.gameobjects.get(i) instanceof Bomb || p.gameobjects.get(i) instanceof FatalBomb || p.gameobjects.get(i) instanceof WatermelonPlus1Live) {
                } else {
                    if (!p.gameobjects.get(i).isSliced() && p.gameobjects.get(i).getYLocation() > 450) {
                        Player.playerMaker().setLives(Player.playerMaker().getLives() - 1);
                        if (Player.playerMaker().getLives() <= 0) {
                            MusicPlayer.endMusic();
                        } else {
                            MusicPlayer.loseLifeMusic();
                        }
                    }
                }
                if (p.gameobjects.get(i).getYLocation() > 450) {
                    p.gameobjects.remove(i);

                }

            }
            if (p.gameobjects.size() == 0 && Player.playerMaker().getLives() > 0) {
                p.gameobjects.clear();
                p.gameobjects = gen.fillList();

            }


            p.repaint();

        }
    }
}
