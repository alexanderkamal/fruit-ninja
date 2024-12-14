/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirdtrailgame;

import FruitsAndBombs.Strawberry;
import FruitsAndBombs.Orange;
import FruitsAndBombs.Banana;
import FruitsAndBombs.Apple;
import FruitsAndBombs.Bomb;
import FruitsAndBombs.FatalBomb;
import FruitsAndBombs.Pear;
import FruitsAndBombs.WatermelonPlus1Live;
import FruitsAndBombs.GameObjectsFruits;

/**
 *
 * @author Amr Ashraf
 */
public class Factory {
    
    public GameObjectsFruits objectMaker(String obj)
    {
        if (obj.equals("Apple"))
            return new Apple();
        else if(obj.equals("Orange"))
            return new Orange();
        else if(obj.equals("Banana"))
            return new Banana();
        else if(obj.equals("Strawberry"))
            return new Strawberry();
        else if(obj.equals("Bomb"))
            return new Bomb();
        else if(obj.equals("FatalBomb"))
            return new FatalBomb();
        else if(obj.equals("Pear"))
            return new Pear();
        else if(obj.equals("WatermelonPlus1Live"))
            return new WatermelonPlus1Live();
        else 
            return null;
    }
    
}
