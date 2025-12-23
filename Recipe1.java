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
    
    public Recipe1()
    {
        recipe1 = new GreenfootImage("recipe1.jpg");
        recipe1.scale(200,200);
        setImage(recipe1);
    }
    
    //initializes recipe1
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Recipe1World());
        }
    }
}
