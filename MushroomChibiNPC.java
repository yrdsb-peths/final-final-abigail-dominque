import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MushroomChibiNPC extends Actor
{
    // Sets the players height and width
    private static final int WIDTH = 80;
    private static final int HEIGHT = 80;
    
    
    private GreenfootImage idle; 
    
    public MushroomChibiNPC()
    {
        // Loads and scales image 
        idle = new GreenfootImage("recipe3.png");
        idle.scale(WIDTH, HEIGHT);
        setImage(idle);
    }
    
    public void act()
    {
        
    }
}

