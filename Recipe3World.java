import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Recipe3World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recipe3World extends World
{

    /**
     * Constructor for objects of class Recipe3World.
     * 
     */
    public Recipe3World()
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
        CookingPotTop pot = new CookingPotTop();
        addObject(pot, 500, 350);
    }
}
