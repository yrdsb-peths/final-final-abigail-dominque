import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Butter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Butter extends Ingredient
{
    // butter can exist in Recipe1World only
    public Butter(Recipe1World world)
    {
        super(world);
        
        GreenfootImage butter = new GreenfootImage("butter.png");
        butter.scale(150,150);
        setImage(butter);
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
