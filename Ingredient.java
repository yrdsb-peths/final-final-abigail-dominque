import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ingredient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ingredient extends Actor
{
    private boolean addedToPot = false;
    
    public void act()
    {
        System.out.println("Ingredient ACT running");
        
        if(Greenfoot.mousePressed(this))
        {
            System.out.println("Ingredient clicked");
            
            Recipe1World world = (Recipe1World) getWorld();
            world.ingredientAdded();
            
            getWorld().removeObject(this);
        }
    }
    
    public void addToPot()
    {
        if(addedToPot) return;
        
        addedToPot = true;
        
        setLocation(500,400);
        
        Recipe1World world = (Recipe1World) getWorld();
        world.ingredientAdded();
    }
    
    public boolean isAddedToPot()
    {
        return addedToPot;
    }
}
