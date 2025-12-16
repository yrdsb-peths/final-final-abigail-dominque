import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FireflyCounter extends Actor
{
    private int count = 0;
    
    public FireflyCounter()
    {
        updateImage();
    }
    
    public void addFirefly()
    {
        count++;
        updateImage();
    }
    
    public int getCount()
    {
        return count;
    }
    
    private void updateImage()
    {
        setImage(new GreenfootImage(
            "Fireflies: " + count + "/3",
            24,
            Color.YELLOW,
            new Color(0, 0, 0, 0)
            ));
    }
}
