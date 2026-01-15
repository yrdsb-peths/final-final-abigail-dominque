import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class CookingWorld extends World
{
    private int returnX;
    private int returnY;
    
    private Exit exit;
    
    private CookingPotTop pot;
    
    private DialogueBox dialogue;
    
    private boolean recipesShown = false;

    private FamilyWorld familyWorld;

    // constructor for CookingWorld
    public CookingWorld(FamilyWorld previous, int x, int y)
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        familyWorld = previous;
        returnX = x;
        returnY = y;
        
        // sets bg image
        GreenfootImage background = new GreenfootImage("kitchen.jpg");
        background.scale(1000,700);
        setBackground(background);
        
        // adds exit option
        exit = new Exit(familyWorld);
        addObject(exit, 950, 50);
        
        String[] text;
        text = new String[] {
            "Ey get ready to cook bluddy... click the cookies and we'll get right \nto it ._.",
            "What you mean you can't see me ;-"
        };
        
        String[] chefSounds = {
            "rat1.mp3",
            "rat3.mp3"
        };
        dialogue = new DialogueBox(text, chefSounds);
        addObject(dialogue, 500, 600);
    }
    
    //shows recipe options after dialogue
    public void act()
    {
        if(!recipesShown && dialogue != null && dialogue.isFinished())
        {
            showRecipies();
            recipesShown = true;
        }
    }
    
    //shows recipe options to choose from
    private void showRecipies()
    {
        Recipe1 recipe1 = new Recipe1();
        addObject(recipe1, 500, 350);
    }
    
    public FamilyWorld getFamilyWorld()
    {
        return familyWorld;
    }
    
    public int getReturnX()
    {
        return returnX;
    }
    
    public int getReturnY()
    {
        return returnY;
    }
    
    public void finishCooking(String recipe)
    {
        if (recipe.equals("SugarCookie"))
        {
            familyWorld.giveSugarCookies();
        }
    }

}
