import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChefChibiNPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChefChibiNPC extends Actor
{
    // Sets the players height and width
    private static final int WIDTH = 250;
    private static final int HEIGHT = 250;
    
    private GreenfootImage idle; 
    
    public ChefChibiNPC()
    {
        // Loads and scales image 
        idle = new GreenfootImage("chef_chibi.png");
        idle.scale(WIDTH, HEIGHT);
        setImage(idle);
    }
    
    public void act()
    {
        
    }
}
