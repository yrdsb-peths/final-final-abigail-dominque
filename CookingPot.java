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
    
    // prevents collision retrigger
    private boolean used = false;
    
    //Initializes cooking pot
    public CookingPot()
    {
        pot = new GreenfootImage("bowl.png");
        pot.scale(100,100);
        setImage(pot);
    }
    
    public void act()
    {
        if(used)
        {
            return;
        }
        
        Player player = (Player) getOneIntersectingObject(Player.class);
        
        if (player != null)
        {
            used = true;
            
            FamilyWorld world = (FamilyWorld) getWorld();
            world.startCooking();
        }
    }
}
