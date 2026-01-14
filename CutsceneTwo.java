import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CutsceneTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CutsceneTwo extends World
{
    private GreenfootSound bgMusic = new GreenfootSound("ending_music.mp3");
    /**
     * Constructor for objects of class CutsceneTwo.
     * 
     */
    public CutsceneTwo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        // Background music
        bgMusic.setVolume(40);
        bgMusic.playLoop();

    }
    
    // Stops and starts music when entering and leaving world
    public void stopMusic() 
    {
        bgMusic.stop();
    }
    
    public void started() 
    {
        bgMusic.playLoop();
    }
}
