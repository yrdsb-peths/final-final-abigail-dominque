import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ChefBigNPC extends Actor
{
    private static final int BIG_HEIGHT = 526;
    private static final int BIG_WIDTH = 580;
    
    private GreenfootImage image1;
    private GreenfootImage image2;
    
    private int index = 0;
    private boolean canToggle = true;
    
    public ChefBigNPC()
    {
         //Loads and scales new images
         image1 = new GreenfootImage("chef1.png");
         image2 = new GreenfootImage("chef2.png");
         
         image1.scale(BIG_HEIGHT, BIG_WIDTH);
         image2.scale(BIG_HEIGHT, BIG_WIDTH);
         
         //Sets intial image
         setImage(image1);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space") && canToggle)
        {
            toggleImage();
            canToggle = false;
        }
        
        if(!Greenfoot.isKeyDown("space"))
        {
            canToggle = true;
        }
    }
    
    private void toggleImage()
    {
        index = (index + 1) % 3;
        
        if (index == 1)
        {
            setImage1();
        }
        
        if(index == 2 || index == 3)
        {
            setImage2();
        }
        
    }
    
    
    public void setImage1()
    {
        setImage(image1);
    }
    
    public void setImage2()
    {
        setImage(image2);
    }

}
