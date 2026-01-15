import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class IntroWorld extends World
{
    // Variables for the dialogue and cutscene images
    private boolean finished = false;
    private DialogueBox dialogue;
    private GreenfootImage[] backgrounds;
    private int lastLine = -1;

    public IntroWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
        // Cutscene images and array that stores them
        backgrounds = new GreenfootImage[5];
        
        backgrounds[0] = new GreenfootImage("introworld_1.png");
        backgrounds[1] = new GreenfootImage("introworld_2.png");
        backgrounds[2] = new GreenfootImage("introworld_3.png");
        backgrounds[3] = new GreenfootImage("introworld_4.png");
        backgrounds[4] = new GreenfootImage("blackscreen.png");
        
        
        for (int i = 0; i < backgrounds.length; i++)
        {
            backgrounds[i].scale(getWidth(), getHeight());
        }

        setBackground(backgrounds[0]);
        
        String[] introDialogue = {
          "You're missing memories??!?!?!?!",
          "Don't even worry about it we'll fix you right up",
          "Just close your eyes and let me (professional) get to work",
          "Hehe haw haw",
          "..."
        };
        
        String[] playerSounds = {
            "player1.mp3",
            "player2.mp3",
            "player3.mp3",
            "player4.mp3",
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
        
        //switches world to mushroomworld after cutscene is done
        if (!finished && getObjects(DialogueBox.class).isEmpty())
        {
            finished = true;
            Greenfoot.setWorld(new MushroomWorld());
        }
    }
}
