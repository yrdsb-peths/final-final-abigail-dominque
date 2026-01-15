import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FamilyWorldNPC4 extends Actor
{
    // Sets the players height and width
    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;
    
    private GreenfootImage idle; 
    
    public FamilyWorldNPC4()
    {
        // Loads and scales image 
        idle = new GreenfootImage("npc4.png");
        idle.scale(WIDTH, HEIGHT);
        setImage(idle);
    }
    
    public void act()
    {
        
    }
}
