import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Syrup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Syrup extends Ingredient
{
    public Syrup(Recipe2World world)
    {
        super(world);
        
        GreenfootImage syrup = new GreenfootImage("syrup.png");
        syrup.scale(150,150);
        setImage(syrup);
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
