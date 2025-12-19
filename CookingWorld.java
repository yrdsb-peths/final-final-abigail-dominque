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
    
    private CookingPotTop pot;
    
    private DialogueBox dialogue;
    
    private boolean recipesShown = false;
    
    public CookingWorld(int x, int y)
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        returnX = x;
        returnY = y;
        
        GreenfootImage background = new GreenfootImage("kitchen.jpg");
        background.scale(1000,700);
        setBackground(background);
        
        exit = new Exit();
        addObject(exit, 950, 50);
        
        String[] text;
        text = new String[] {
            "Welcome to the kitchen!",
            "Choose a recipe to begin."
        };
        
        dialogue = new DialogueBox(text);
        addObject(dialogue, 500, 600);
    }
    
    public void act()
    {
        if(!recipesShown && dialogue != null && dialogue.isFinished())
        {
            showRecipies();
            recipesShown = true;
        }
    }
    
    private void showRecipies()
    {
        Recipe1 recipe1 = new Recipe1();
        addObject(recipe1, 200, 350);
        
        Recipe2 recipe2 = new Recipe2();
        addObject (recipe2, 500, 350);
        
        Recipe3 recipe3 = new Recipe3();
        addObject(recipe3, 800, 350);
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
