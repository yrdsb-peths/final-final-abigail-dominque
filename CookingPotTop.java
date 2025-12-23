import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CookingPotTop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CookingPotTop extends Actor
{
    
    private GreenfootImage top;
    
    //Initializes image
    public CookingPotTop()
    {
        top = new GreenfootImage("cooking_pot_top.png");
        top.scale(500,500);
        setImage(top);
    }
    
    public void act()
    {
        
    }
}
