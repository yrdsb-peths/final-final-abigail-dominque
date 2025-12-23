import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Recipe3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recipe3 extends Actor
{
    private GreenfootImage recipe3;
    
    //initializes recipe3
    public Recipe3()
    {
        GreenfootImage rolls = new GreenfootImage("cinnamon_rolls.png");
        rolls.scale(300, 300);
        setImage(rolls);
    }
    
    //switches world to Recipe3World when clicked
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Recipe3World());
        }
    }
}
