import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Drag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Drag extends Actor
{
    private boolean isDragging = false;
    
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(Greenfoot.mousePressed(this))
        {
            isDragging = true;
        }
        
        if(isDragging && mouse != null)
        {
            setLocation(mouse.getX(), mouse.getY());
        }
        
        if(!Greenfoot.mousePressed(null) && isDragging && Greenfoot.getMouseInfo() == null)
        {
            isDragging = false;
        }
    }
}
