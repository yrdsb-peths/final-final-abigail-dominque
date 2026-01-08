import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Recipe1World extends World
{
    // intro dialogue
    private DialogueBox dialogue1;
    
    // tracks whether all the ingredient were added
    private boolean ingredientsAdded = false;
    
    // tracks number of ingredients added
    private int ingredientsAddedCount = 0;
    private final int TOTAL_INGREDIENTS = 4;
    
    // tracks whether recipe was made
    private boolean recipeMade = false;
    
    // tracks whether the ending dialogue was shown
    private boolean lastDialogueShown = false;
    
    //saves previous world
    private CookingWorld worldPrevious;
    
    //Constructor for Recipe1World
    public Recipe1World(CookingWorld previous)
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
        worldPrevious = previous;
        
        // adds exit option
        Exit exit = new Exit(worldPrevious);
        addObject(exit, 950, 50);
        
        // adds cooking pot in the middle
        CookingPotTop pot = new CookingPotTop();
        addObject(pot, 500, 400);
        
        // intro text
        String[] text1;
        text1 = new String[] {
            "Let's make sugar cookies!",
            "Click the ingredients to put them in the pot."
        };
        
        dialogue1 = new DialogueBox(text1);
        addObject(dialogue1, 500, 100);
    }
    
    public void act()
    {
        // shows ingredient to add after intro dialogue
        if(!ingredientsAdded && dialogue1.isFinished())
        {
            showIngredients();
            ingredientsAdded = true;
        }
        
        //shows ending dialogue after cookies are made
        if(recipeMade && !lastDialogueShown)
        {
            showLastDialogue();
            lastDialogueShown = true;
        }
    }
    
    //ending dialogue
    private void showLastDialogue()
    {
        String[] text2;
        text2 = new String[] {
            "Good job, you baked sugar cookies!",
            "Give them to your fairy friends."
        };
        
        DialogueBox dialogue2 = new DialogueBox(text2);
        addObject(dialogue2, 500, 100);
    }
    
    //shows ingredient to add to pot
    private void showIngredients()
    {
        Icing icing = new Icing(this);
        addObject(icing, 150, 200);
        
        Sugar sugar = new Sugar(this);
        addObject(sugar, 150, 600);
        
        Flour flour = new Flour(this);
        addObject(flour, 850, 600);
        
        Butter butter = new Butter(this);
        addObject(butter, 850, 200);
    }
    
    //finishes recipe when max ingredients added
    public void ingredientAdded()
    {
        ingredientsAddedCount++;
        
        if(ingredientsAddedCount == TOTAL_INGREDIENTS)
        {
            finishRecipe();
        }
    }
    
    //removes ingredients and pot to show cookies
    private void finishRecipe()
    {
        removeObjects(getObjects(Ingredient.class));
        removeObjects(getObjects(CookingPotTop.class));
        
        recipeMade = true;
        
        worldPrevious.getFamilyWorld().giveSugarCookies();
    }
}
