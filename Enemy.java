import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{    
    private int xCoord = 3;
    private int yCoord = 3;
    
    public Enemy()
    {
        GreenfootImage cutestDogEver = new GreenfootImage("doggy.png");
        cutestDogEver.scale(80 ,80);
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
        int zoneX = 800;
        int zoneY = 300;
        int zoneW = 200;
        int zoneH = 200;
    
        int left   = zoneX - zoneW / 2;
        int right  = zoneX + zoneW / 2;
        int top    = zoneY - zoneH / 2;
        int bottom = zoneY + zoneH / 2;
    
        int ex = getX();
        int ey = getY();
    
        boolean insideX = ex > left && ex < right;
        boolean insideY = ey > top && ey < bottom;
    
        if (insideX && insideY)
        {
            // bounce exactly like your wall code
            xCoord = -xCoord;
            yCoord = -yCoord;
        }
    }


    private void checkPlayerCollision()
    {
        // Get the world and player
        GameWorld world = (GameWorld) getWorld();
        Player p = world.getPlayer();   // you must add a getter in GameWorld
    
        int eX = getX();
        int eY = getY();
        int pX = p.getX();
        int pY = p.getY();
    
        // Distance between enemy and player
        int dx = Math.abs(eX - pX);
        int dy = Math.abs(eY - pY);
    
        // collision size (hitbox)
        int hitRange = 35;   // adjust smaller or larger as needed
    
        if (dx < hitRange && dy < hitRange)
        {
            p.setLocation(800, 300);
        }
    }

}
