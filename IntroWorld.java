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
        backgrounds = new GreenfootImage[3];

        backgrounds[0] = new GreenfootImage("introworld_1.png");
        backgrounds[1] = new GreenfootImage("introworld_1.jpg");
        backgrounds[2] = new GreenfootImage("introworld_3.jpg");

        GreenfootImage background = new GreenfootImage("introworld_1.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        
        for (int i = 0; i < backgrounds.length; i++)
        {
            backgrounds[i].scale(getWidth(), getHeight());
        }

        setBackground(backgrounds[0]);
        String[] introDialogue = {
          "Basically we got our zlawg emil",
          "He's lowkey lie missing his memories brah",
          "Help help help zim",
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
