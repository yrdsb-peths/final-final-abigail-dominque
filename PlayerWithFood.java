import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerWithFood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerWithFood extends Actor
{
    private Player player; 
    
    public PlayerWithFood(Player player)
    {
        this.player = player;
        
        GreenfootImage cookies = new GreenfootImage("sugar_cookies.png");
        cookies.scale(40, 40);
        setImage(cookies);
    }
    
    public void act()
    {
        if (player != null && player.getWorld() != null)
        {
            setLocation(player.getX() + 20, player.getY() + 10);
        }
    }
}
