import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eggs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Eggs extends Ingredient
{
    // eggs can exist in Recipe2world and Recipe3World
    public Eggs(Recipe2World world)
    {
        super(world);
        
        GreenfootImage eggs = new GreenfootImage("eggs.png");
        eggs.scale(150,150);
        setImage(eggs);
    }
    
    public Eggs(Recipe3World world)
    {
        super(world);
        
        GreenfootImage eggs = new GreenfootImage("eggs.png");
        eggs.scale(150,150);
        setImage(eggs);
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
