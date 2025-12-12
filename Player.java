import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Sets Player image
    public Player()
    {
        setImage("player.png");
    }
    // Player movements
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 3, getY());
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 3, getY());
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 3);
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 3);
        }
    }
}
