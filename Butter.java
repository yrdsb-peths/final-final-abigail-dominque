import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Butter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Butter extends Ingredient
{
    public Butter()
    {
        GreenfootImage butter = new GreenfootImage("butter.png");
        butter.scale(150,150);
        setImage(butter);
    }
    public void act()
    {
        if(!isAddedToPot() && Greenfoot.mousePressed(this))
        {
            addToPot();
        }
    }
}
