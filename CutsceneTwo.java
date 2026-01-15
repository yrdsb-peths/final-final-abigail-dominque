import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CutsceneTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CutsceneTwo extends World
{
    // Background music
    private GreenfootSound bgMusic = new GreenfootSound("ending_music.mp3");
    
    // Variables for the dialogue and cutscene images
    private boolean finished = false;
    private DialogueBox dialogue;
    private GreenfootImage[] backgrounds;
    private int lastLine = -1;

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

        // Cutscene images and array that stores them
        backgrounds = new GreenfootImage[8];
    
        backgrounds[0] = new GreenfootImage("end0.png");
        backgrounds[1] = new GreenfootImage("end1.png");
        backgrounds[2] = new GreenfootImage("end2.png");
        backgrounds[3] = new GreenfootImage("end3.png");
        backgrounds[4] = new GreenfootImage("end4.png");
        backgrounds[5] = new GreenfootImage("end5.png");
        backgrounds[6] = new GreenfootImage("end6.png");
        backgrounds[7] = new GreenfootImage("end7.png");
        
        for (int i = 0; i < backgrounds.length; i++)
        {
            backgrounds[i].scale(getWidth(), getHeight());
        }

        setBackground(backgrounds[0]);
        
        //dialogue while memories are playing
        String[] introDialogue = {
          "Let's piece the fragments together...",
          "... \n(patient is running from puppy)",
          "... \n(puppy bites patient)",
          "... \n(patient is crying)",
          "... \n(puppy feels sad)",
          "... \n(puppy apologizes)",
          "... \n(puppy and patient are happy!)",
          "...",
          "#socute... you've found the patient's memories!!! let's wake \nthem up hehehehehehehe"
        };
        
        //player sounds
        String[] playerSounds = {
            "player1.mp3",
            "player2.mp3",
            "player3.mp3",
            "player4.mp3",
            "player1.mp3",
            "player2.mp3",
            "player3.mp3"
        };
        
        dialogue = new DialogueBox(introDialogue, playerSounds);
        addObject(dialogue, getWidth() / 2, 600);
    }
    
    public void act()
    {
        if (dialogue != null)
        {
            int line = dialogue.getLineIndex();
    
            // Only change when line actually changes
            if (line != lastLine && line < backgrounds.length)
            {
                setBackground(backgrounds[line]);
                lastLine = line;
            }
        }
    
        if (!finished && getObjects(DialogueBox.class).isEmpty())
        {
            finished = true;
            Greenfoot.setWorld(new EndWorld());
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
