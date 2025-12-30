import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends World
{
    private boolean finished = false;
    
    public IntroWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        String[] introDialogue = {
          "Basically we got our zlawg emil",
          "He's lowkey lie missing his memories brah",
          "Help help help zim",
        };
        
        addObject(new DialogueBox(introDialogue), getWidth() / 2, 600);
    }
    
    public void act()
    {
        if(!finished && getObjects(DialogueBox.class).isEmpty())
        {
            finished = true;
            Greenfoot.setWorld(new MushroomWorld());
        }
    }
}
