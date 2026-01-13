import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoatChibiNPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoatChibiNPC extends Actor
{
    /**
     * Act - do whatever the GoatChibiNPC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage goat = new GreenfootImage("goat_chibi.png");
        goat.scale(200, 200);
        setImage(goat);
    }
}
