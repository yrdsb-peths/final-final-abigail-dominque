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
    private Recipe2World recipe2World;
    private Recipe3World recipe3World;
    
    // constructor so it works in every recipe world
    public Ingredient(Recipe1World world)
    {
        recipe1World = world;
    }
    
    public Ingredient(Recipe2World world)
    {
        recipe2World = world;
    }
    
    public Ingredient(Recipe3World world)
    {
        recipe3World = world;
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
            else if(recipe2World != null)
            {
                recipe2World.ingredientAdded();
            }
            else if(recipe3World != null)
            {
                recipe3World.ingredientAdded();
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
