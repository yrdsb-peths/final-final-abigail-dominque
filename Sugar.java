import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sugar extends Ingredient
{
    // Sugar exists in Recipe1World, Recipe2World and Recipe3World
    public Sugar(Recipe1World world)
    {
        super(world);
        
        GreenfootImage sugar = new GreenfootImage("sugar.png");
        sugar.scale(200,200);
        setImage(sugar);
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
