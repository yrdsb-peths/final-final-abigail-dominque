import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Book extends Actor
{
    
    private GreenfootImage book; 
    
    public Book()
    {
        // initiates and scales book image
        book = new GreenfootImage("book.png");
        book.scale(50,50);
        setImage(book);
    }
    
    private void openControls()
    {
        //opens instructions world when clicked
        MushroomWorld world = (MushroomWorld)getWorld();
        world.openControls();
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            openControls();
        }
    }
}
