import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flour extends Ingredient
{
    /**
     * Act - do whatever the Flour wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Flour()
    {
        GreenfootImage flour = new GreenfootImage("flour.png");
        flour.scale(200,200);
        setImage(flour);
    }
    
    public void act()
    {
        if(!isAddedToPot() && Greenfoot.mousePressed(this))
        {
            addToPot();
        }
    }
}
