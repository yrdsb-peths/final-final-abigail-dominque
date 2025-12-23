import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Crepes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crepes extends Actor
{
    /**
     * Act - do whatever the Crepes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Crepes()
    {
        GreenfootImage crepes = new GreenfootImage("crepes.png");
        crepes.scale(300, 300);
        setImage(crepes);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Recipe2World());
        }
    }
}
