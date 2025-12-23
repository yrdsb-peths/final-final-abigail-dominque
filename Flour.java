import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flour extends Ingredient
{
    // Flour can exist in Recipe1World, Recipe2World and Recipe3World
    public Flour(Recipe1World world)
    {
        super(world);
        
        GreenfootImage flour = new GreenfootImage("flour.png");
        flour.scale(200,200);
        setImage(flour);
    }
    
    public Flour(Recipe2World world)
    {
        super(world);
        
        GreenfootImage flour = new GreenfootImage("flour.png");
        flour.scale(200,200);
        setImage(flour);
    }
    
    public Flour(Recipe3World world)
    {
        super(world);
        
        GreenfootImage flour = new GreenfootImage("flour.png");
        flour.scale(200,200);
        setImage(flour);
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
