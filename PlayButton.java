import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayButton extends Actor
{
    public PlayButton() {
        // Play button image
        GreenfootImage img = new GreenfootImage("play_button.png");
        img.scale(180, 114);
        setImage(img);
    }

    public void act() {
        // Detect if the button is clicked
        if (Greenfoot.mouseClicked(this)) {
            onClick();
        }
    }

    // What happens when button is clicked
    private void onClick() {
        // Switches the world
        Greenfoot.setWorld(new IntroWorld());
    }
}
