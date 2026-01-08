import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SugarCookies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SugarCookies extends Actor
{
    private Player player; 
    
    public SugarCookies()
    {
        GreenfootImage cookies = new GreenfootImage("sugar_cookies.png");
        cookies.scale(300,300);
        setImage(cookies);
    }
    
    public SugarCookies(Player player)
    {
        this.player = player;
        
        GreenfootImage cookies = new GreenfootImage("sugar_cookies.png");
        cookies.scale(50,50);
        setImage(cookies);
    }
    
    
    public void act()
    {
        if(player != null && player.getWorld() != null)
        {
            setLocation(player.getX(), player.getY());
        }
        checkChefInteraction();
    }
    
    private void checkChefInteraction()
    {

    }
}
