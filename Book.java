import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Book here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Book extends Actor
{
    
    private GreenfootImage book; 

    /**
     * Act - do whatever the Book wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Book()
    {
        // initiates and scales book image
        book = new GreenfootImage("book.png");
        book.scale(50,50);
        setImage(book);
    }
    
    public void act()
    {
        // changes book image to an open book when clicked
        if(Greenfoot.mouseClicked(this))
        {
            setImage("open_book.png");
            openInstructions();
        }
    }
    
    private void openInstructions()
    {
        //opens instructions world when clicked
        MushroomWorld world = (MushroomWorld)getWorld();
        
        world.openInstructions();
    }
}
