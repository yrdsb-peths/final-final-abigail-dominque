import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CookingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CookingWorld extends World
{
    private int returnX;
    private int returnY;
    
    private Exit exit;
    
    public CookingWorld(int x, int y)
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        returnX = x;
        returnY = y;
        
        exit = new Exit();
        addObject(exit, 950, 50);
    }
    
    public int getReturnX()
    {
        return returnX;
    }
    
    public int getReturnY()
    {
        return returnY;
    }
}
