import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FamilyWorldNPC8 extends Actor
{
    // Sets the players height and width
    private static final int WIDTH = 250;
    private static final int HEIGHT = 250;
    
    private GreenfootImage idle; 
    
    public FamilyWorldNPC8()
    {
        // Loads and scales image 
        idle = new GreenfootImage("npc2.png");
        idle.scale(WIDTH, HEIGHT);
        setImage(idle);
    }
    
    public void act()
    {
        
    }
}
