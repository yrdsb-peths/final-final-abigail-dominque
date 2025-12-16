import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DialogueWorld extends World
{
    public DialogueWorld()
    {
        super(1000, 700, 1);

        String[] testing = {
            "Hello, hello, hello.",
            "Testing, testing, testing.",
            "I like giraffes.",
            "I also like cats."
        };

        DialogueBox test = new DialogueBox(testing);
        addObject(test, getWidth() / 2, 400);
    }
} 
