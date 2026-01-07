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
    
    //initializes recipe2
    public Recipe2()
    {
        GreenfootImage crepes = new GreenfootImage("crepes.png");
        crepes.scale(300, 300);
        setImage(crepes);
    }
    
    //switches world to Recipe2World when clicked
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            World currentWorld = getWorld();
            Greenfoot.setWorld(new Recipe2World(currentWorld));
        }
    }
}
