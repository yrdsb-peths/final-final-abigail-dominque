import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CinnamonRolls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CinnamonRolls extends Actor
{
    /**
     * Act - do whatever the CinnamonRolls wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //sets image for cinnamon rolls
    public CinnamonRolls()
    {
        GreenfootImage rolls = new GreenfootImage("cinnamon_rolls.png");
        rolls.scale(300, 300);
        setImage(rolls);
    }
    
    
    public void act()
    {
        
    }
}
