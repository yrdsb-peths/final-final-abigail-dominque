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
        Greenfoot.setWorld(new PlayerControls(getWorld(), 1000, 700));
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            openControls();
        }
    }
}
