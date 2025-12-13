import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DialogueWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class DialogueWorld extends World
{
    public DialogueWorld()
    {
        super(600, 600, 1);

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
