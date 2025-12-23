import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Icing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Icing extends Ingredient
{
    /**
     * Act - do whatever the Icing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Icing(Recipe1World world)
    {
        super(world);
        
        GreenfootImage icing = new GreenfootImage("icing.png");
        icing.scale(200,200);
        setImage(icing);
    }
    
    public void act()
    {
        super.act();
        
        if(!isAddedToPot() && Greenfoot.mousePressed(this))
        {
            addToPot();
        }
    }
}
