import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{    
    private int xCoord = 1;
    private int yCoord = 1;
    
    public Enemy()
    {
        GreenfootImage cutestDogEver = new GreenfootImage("doggy.png");
        cutestDogEver.scale(50 ,50);
        setImage(cutestDogEver);
    }
  
    public void act()
    {
        attack();
        attackCollisions();
        checkSafeZoneCollision();
        checkPlayerCollision();
    }
    
    private void attack()
    {
        setLocation(getX() - xCoord, getY() - yCoord);
    }
    
    private void attackCollisions()
    {
        World world = getWorld();
        
        if(getX() <= 0 || getX() >= world.getWidth() - 1)
        {
            xCoord = -xCoord;
        }
        
        if (getY() <= 0 || getY() >= world.getHeight() - 1)
        {
            yCoord = -yCoord;  // reverse Y direction
        }
    }
        
    private void checkSafeZoneCollision()
    {
        
    }


    private void checkPlayerCollision()
    {
        GameWorld world = (GameWorld) getWorld();
        Player p = world.getPlayer();
    
        // ==== ENEMY HITBOX ====
        int eLeft   = getX() - getImage().getWidth() / 2;
        int eRight  = getX() + getImage().getWidth() / 2;
        int eTop    = getY() - getImage().getHeight() / 2;
        int eBottom = getY() + getImage().getHeight() / 2;
    
        // ==== PLAYER HITBOX ====
        int pLeft   = p.getX() - p.getImage().getWidth() / 2;
        int pRight  = p.getX() + p.getImage().getWidth() / 2;
        int pTop    = p.getY() - p.getImage().getHeight() / 2;
        int pBottom = p.getY() + p.getImage().getHeight() / 2;
    
        // ==== CHECK OVERLAP ====
        boolean overlapX = eRight > pLeft && eLeft < pRight;
        boolean overlapY = eBottom > pTop && eTop < pBottom;
    
        if (overlapX && overlapY)
        {
            // RESET PLAYER
            p.setLocation(800, 300);
    
            // ==== FIND SHALLOWEST COLLISION SIDE ====
            int overlapLeft   = eRight  - pLeft;
            int overlapRight  = pRight  - eLeft;
            int overlapTop    = eBottom - pTop;
            int overlapBottom = pBottom - eTop;
    
            int minOverlap = Math.min(
                Math.min(overlapLeft, overlapRight),
                Math.min(overlapTop, overlapBottom)
            );
    
            // ==== PUSH ENEMY OUT + BOUNCE ====
    
            if (minOverlap == overlapLeft)
            {
                // Hit from LEFT → bounce LEFT
                setLocation(pLeft - getImage().getWidth() / 2 - 2, getY());
                xCoord = -Math.abs(xCoord);
            }
            else if (minOverlap == overlapRight)
            {
                // Hit from RIGHT → bounce RIGHT
                setLocation(pRight + getImage().getWidth() / 2 + 2, getY());
                xCoord = Math.abs(xCoord);
            }
            else if (minOverlap == overlapTop)
            {
                // Hit from ABOVE → bounce UP
                setLocation(getX(), pTop - getImage().getHeight() / 2 - 2);
                yCoord = -Math.abs(yCoord);
            }
            else
            {
                // Hit from BELOW → bounce DOWN
                setLocation(getX(), pBottom + getImage().getHeight() / 2 + 2);
                yCoord = Math.abs(yCoord);
            }
        }
    }
}
