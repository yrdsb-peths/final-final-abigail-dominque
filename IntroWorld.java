import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class IntroWorld extends World
{
    private boolean finished = false;
    private DialogueBox dialogue;
    private GreenfootImage[] backgrounds;
    private int lastLine = -1;

    public IntroWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
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
          "Missing memories and headaches...",
          "It seems as if you're affected by the ",
          "help help zim",
          "i said help",
          "..."
        };
        
        dialogue = new DialogueBox(introDialogue);
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
            Greenfoot.setWorld(new MushroomWorld());
        }
    }
}
