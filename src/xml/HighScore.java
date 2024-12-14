/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author STAR
 */
@XmlRootElement(name = "highest_scores")
@XmlAccessorType(XmlAccessType.FIELD)
public class HighScore {
    
    @XmlElement(name = "hard")
    private Hard hard;
    
    @XmlElement(name = "normal")
    private Normal normal;
    
    @XmlElement(name = "easy")
    private Easy easy;

    public Hard getHard() {
        return hard;
    }

    public void setHard(Hard hard) {
        this.hard = hard;
    }

    public Normal getNormal() {
        return normal;
    }

    public void setNormal(Normal normal) {
        this.normal = normal;
    }

    public Easy getEasy() {
        return easy;
    }

    public void setEasy(Easy easy) {
        this.easy = easy;
    }

   
    
    
}
