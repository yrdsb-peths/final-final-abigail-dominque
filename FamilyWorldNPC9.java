import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FamilyWorldNPC9 extends Actor
{
    // Sets the players height and width
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private GreenfootImage idle; 
    
    public FamilyWorldNPC9()
    {
        // Loads and scales image 
        idle = new GreenfootImage("npc9.png");
        idle.scale(WIDTH, HEIGHT);
        setImage(idle);
    }
    
    public void act()
    {
        
    }
}
