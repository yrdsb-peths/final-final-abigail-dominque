import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MushroomChibiNPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MushroomChibiNPC extends Actor
{
    // Sets the players height and width
    private static final int WIDTH = 64;
    private static final int HEIGHT = 64;
    
    
    private GreenfootImage idle; 
    
    public MushroomChibiNPC()
    {
        // Loads and scales image 
        idle = new GreenfootImage("mushroom_chibi.jpg");
        idle.scale(WIDTH, HEIGHT);
        setImage(idle);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
