import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
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
        
        exit = new Exit(new MushroomWorld(true, returnX, returnY));
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
        SugarCookies recipe1 = new SugarCookies();
        addObject(recipe1, 200, 350);
        
        Crepes recipe2 = new Crepes();
        addObject (recipe2, 500, 350);
        
        CinnamonRolls recipe3 = new CinnamonRolls();
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
