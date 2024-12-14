/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import FruitsAndBombs.GameObjectsFruits;

/**
 *
 * @author Amr Ashraf
 */
public class MoveUpCommand implements command{
  
  GameObjectsFruits gob;

    public MoveUpCommand(GameObjectsFruits gob) {
        this.gob = gob;
    }
  
    @Override
    public void doCommand() {
        gob.MoveUp();
        
    }
    
}
