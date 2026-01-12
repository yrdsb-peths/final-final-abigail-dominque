import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameWorld extends World
{
    private GoatChibiNPC goat;
    
    private Player player;
    
    public GameWorld(int playerX, int playerY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        // adds goat npc
        goat = new GoatChibiNPC();
        addObject(goat, 800, 500);
        
        // adds the player
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
    }
}
