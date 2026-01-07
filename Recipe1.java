import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Recipe1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recipe1 extends Actor
{
    private GreenfootImage recipe1;
    
    //initializes recipe1
    public Recipe1()
    {
        GreenfootImage cookies = new GreenfootImage("sugar_cookies.png");
        cookies.scale(300,300);
        setImage(cookies);
    }
    
    //switches world to Recipe1World when clicked
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            World currentWorld = getWorld();
            Greenfoot.setWorld(new Recipe1World(currentWorld));
        }
    }
}
