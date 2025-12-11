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
    
    private int frame = 0;
    private int animationTimer = 0;
    
    // Sets player image when the user moves
    public void act()
    {
        movePlayer();
        animatePlayer();
    }
    
    // Player movements
    public void movePlayer()
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
    
    private void animatePlayer()
    {
        animationTimer++;
        
        if(animationTimer % 6 == 0)  // controls speed
        {
            setImage("walk" + frame + ".png");
            frame = (frame + 1) % 4; // 4-frame animation
        }
    }
}
