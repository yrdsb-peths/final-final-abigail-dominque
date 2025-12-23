import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cinnamon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cinnamon extends Ingredient
{
    public Cinnamon(Recipe3World world)
    {
        super(world);
        
        GreenfootImage cinnamon = new GreenfootImage("cinnamon.png");
        cinnamon.scale(150,150);
        setImage(cinnamon);
    }
    public void act()
    {
        super.act(); 
        
        
        if(!isAddedToPot() && Greenfoot.mousePressed(this))
        {
            addToPot();
        }
    }
}
