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
        
        // Adds Ratata to world (the real goat)
        Ratata rat = new Ratata();
        addObject(rat, 120, 450);
        
        // adds cooking pot in the middle
        CookingPotTop pot = new CookingPotTop();
        addObject(pot, 500, 400);
        
        // intro text
        String[] text1;
        text1 = new String[] {
            "Wassup",
            "We boutta make some cookies"
        };
        
        String[] ratataSounds = {
            "rat2.mp3",
            "rat1.mp3"
        };
        
        dialogue1 = new DialogueBox(text1, ratataSounds);
        addObject(dialogue1, 500, 600);
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
            "Bro these better be good gon be honest",
            "But lie I won't be surprised if they ain't",
            "If chef Norve don't like them you're dun",
            "Okay I guess you can leave now ;-;"
        };
        
        String[] chefSounds = {
            "rat1.mp3",
            "rat2.mp3",
            "rat3.mp3",
            "rat2.mp3"
        };
        DialogueBox dialogue2 = new DialogueBox(text2, chefSounds);
        addObject(dialogue2, 500, 600);
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
    
    // removes ingredients and pot to show cookies
    private void finishRecipe()
    {
        removeObjects(getObjects(Ingredient.class));
        removeObjects(getObjects(CookingPotTop.class));
        
        SugarCookies cookies = new SugarCookies();
        addObject(cookies, 500, 300);

        recipeMade = true;
        
        worldPrevious.getFamilyWorld().giveSugarCookies();
    }
}
