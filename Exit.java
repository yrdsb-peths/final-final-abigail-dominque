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
    
    //sets and scales Exit
    public Exit ()
    {
        GreenfootImage exit = new GreenfootImage("exit.png");
        exit.scale(100,100);
        setImage(exit);
    }

    // Switches world to previous MushroomWorld when clicked
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new MushroomWorld(true, 
                    ((CookingWorld) getWorld()).getReturnX(), (
                    (CookingWorld) getWorld()).getReturnY()
            ));
        }
    }
}
