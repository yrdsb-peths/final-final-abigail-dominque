import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sugar extends Ingredient
{
    /**
     * Act - do whatever the Sugar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Sugar()
    {
        GreenfootImage sugar = new GreenfootImage("sugar.png");
        sugar.scale(200,200);
        setImage(sugar);
    }
    public void act()
    {
        if(!isAddedToPot() && Greenfoot.mousePressed(this))
        {
            addToPot();
        }
    }
}
