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
    
    // instance variable for each recipe world
    private Recipe1World recipe1World;
    
    // constructor so it works in every recipe world
    public Ingredient(Recipe1World world)
    {
        recipe1World = world;
    }
    
    public void act()
    {
        // sets location of ingredient to the center of the 
        // pot when clicked
        if(!addedToPot && Greenfoot.mousePressed(this))
        {
            addedToPot = true;
            setLocation(500,400);
            
            if(recipe1World != null)
            {
                recipe1World.ingredientAdded();
            }
        }
    }
    
    public boolean addToPot()
    {
        return addedToPot;
    }
    
    public boolean isAddedToPot()
    {
        return addedToPot;
    }
}
