/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirdtrailgame;

import Observe.Player;
import jaco.mp3.player.MP3Player;
import java.io.File;

/**
 *
 * @author Amr Ashraf
 */
public class MusicPlayer {
    private static final String startmusic="music\\fruitNinjaMusic.mp3";
    public static MP3Player mp31 = new MP3Player(new File(startmusic));
    
    
    private static final String slicemusic="music\\Slice.mp3";
    private static MP3Player mp32 = new MP3Player(new File(slicemusic));
    
    
    
    private static final String throwmusic="music\\throwFruit.mp3";
    private static MP3Player mp33 = new MP3Player(new File(throwmusic));
    
    
    private static final String loselife="music\\lose1.mp3";
    private static MP3Player mp34 = new MP3Player(new File(loselife));
    
    
    private static final String end="music\\end.mp3";
    private static MP3Player mp35 = new MP3Player(new File(end));
    
    
    private static final String boom="music\\Bomb.mp3";
    private static MP3Player mp36 = new MP3Player(new File(boom));
    
    
    private static final String throwbombmusic="music\\throwbomb.mp3";
    private static MP3Player mp37 = new MP3Player(new File(throwbombmusic));
    
    
    private static final String liveup="music\\LiveUp.mp3";
    private static MP3Player mp38 = new MP3Player(new File(liveup));
    
    
    
    public static void startMusic(){
        if(Player.playerMaker().isSoundon())
         mp31.play();  
    }
    public static void startMusicStop(){
         mp31.stop();
    }
    public static void sliceMusic(){
        if(Player.playerMaker().isSoundon())
         mp32.play();
    }
    public static void throwMusic(){
        if(Player.playerMaker().isSoundon())
         mp33.play();
    }
    public static void loseLifeMusic(){
        if(Player.playerMaker().isSoundon())
         mp34.play();
    }
    public static void endMusic(){
        if(Player.playerMaker().isSoundon())
         mp35.play();
    }
    public static void bombMusic(){
        if(Player.playerMaker().isSoundon())
         mp36.play();
    }
    public static void throwBombMusic(){
        if(Player.playerMaker().isSoundon())
         mp37.play();
    }
    public static void liveUpMusic(){
        if(Player.playerMaker().isSoundon())
         mp38.play();
    }
    

        
        
    
}
