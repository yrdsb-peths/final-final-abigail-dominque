import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Actor
{
    
    private GreenfootImage exit;
    
    private World worldTarget;
    
    //sets and scales Exit
    public Exit (World world)
    {
        GreenfootImage exit = new GreenfootImage("exit_button.png");
        exit.scale(70,70);
        setImage(exit);
        
        worldTarget = world;
    }

    // Switches world to previous MushroomWorld when clicked
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(worldTarget);
        }
    }
}
