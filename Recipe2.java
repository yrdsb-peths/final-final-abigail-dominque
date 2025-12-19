import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Recipe2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recipe2 extends Actor
{
    private GreenfootImage recipe2;
    
    //initializes recipe3
    public Recipe2()
    {
        recipe2 = new GreenfootImage("recipe2.jpg");
        recipe2.scale(200,200);
        setImage(recipe2);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Recipe2World());
        }
    }
}
