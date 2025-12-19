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
        recipe3 = new GreenfootImage("recipe3.png");
        recipe3.scale(200,200);
        setImage(recipe3);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Recipe3World());
        }
    }
}
