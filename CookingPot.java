import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CookingPot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CookingPot extends Actor
{
    private GreenfootImage pot;
    
    //Initializes cooking pot
    public CookingPot()
    {
        pot = new GreenfootImage("cooking_pot.png");
        pot.scale(70,50);
        setImage(pot);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
