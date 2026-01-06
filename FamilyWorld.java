import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FamilyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FamilyWorld extends World
{
    private Player player;
    
    // Save player position
    private int savedPlayerX;
    private int savedPlayerY;
    
    public FamilyWorld(int playerX, int playerY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        CookingPot pot = new CookingPot();
        addObject(pot, 600, 300);
        
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
        
        //restore position
        if(playerX != -1 && playerY != -1)
        {
            player.setLocation(playerX, playerY);
        }
    }
    
    // Called by Player when touching CookingPot
    public void startCooking()
    {
        savedPlayerX = player.getX();
        savedPlayerY = player.getY();
        
        //slightly moves player so the pot is not triggered again 
        player.setLocation(player.getX(), player.getY() + 50);
        
        Greenfoot.setWorld(new CookingWorld(this, savedPlayerX, savedPlayerY));
    }
    
}
