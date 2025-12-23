import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Icing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Icing extends Ingredient
{
    // Icing can exist in Recipe1World
    public Icing(Recipe1World world)
    {
        super(world);
        
        GreenfootImage icing = new GreenfootImage("icing.png");
        icing.scale(200,200);
        setImage(icing);
    }
    
    // when clicked, set location to center of the pot
    public void act()
    {
        super.act();
        
        if(!isAddedToPot() && Greenfoot.mousePressed(this))
        {
            addToPot();
        }
    }
}
