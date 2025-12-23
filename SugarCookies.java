import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SugarCookies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SugarCookies extends Actor
{
    /**
     * Act - do whatever the SugarCookies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public SugarCookies()
    {
        GreenfootImage cookies = new GreenfootImage("sugar_cookies.png");
        cookies.scale(300,300);
        setImage(cookies);
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Recipe1World());
        }
    }
}
