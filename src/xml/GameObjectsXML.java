/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author STAR
 */
@XmlRootElement(name = "game_objects")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameObjectsXML {
    @XmlElement(name = "game_object")
    private List<GameObjectXML> gameObject;

    public List<GameObjectXML> getGameObject() {
        return gameObject;
    }

    public void setGameObject(List<GameObjectXML> gameObject) {
        this.gameObject = gameObject;
    }
    
    
    
}
