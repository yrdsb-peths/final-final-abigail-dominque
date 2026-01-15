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
    
    
    private GreenfootImage[] cutscene;
    
    private int index = 0;
    private boolean canAdvance = true;

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
        
        cutscene = new GreenfootImage[6];
        
        cutscene[0] = new GreenfootImage("endscene1.png");
        cutscene[1] = new GreenfootImage("endscene2.png");
        cutscene[2] = new GreenfootImage("endscene3.png");
        cutscene[3] = new GreenfootImage("endscene4.png");        
        cutscene[4] = new GreenfootImage("endscene5.png");
        cutscene[5] = new GreenfootImage("endscene6.png");
        
        for (int i = 0; i < cutscene.length; i++)
        {
            cutscene[i].scale(getWidth(), getHeight());
        }
        
        setBackground(cutscene[0]);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space") && canAdvance)
        {
            nextScene();
            canAdvance = false;
        }
        
        if(!Greenfoot.isKeyDown("space"))
        {
            canAdvance = true;
        }
    }
    
    private void nextScene()
    {
        if(index < cutscene.length -1)
        {
            index++;
            setBackground(cutscene[index]);
        }
        else
        {
            stopMusic();
        }
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
