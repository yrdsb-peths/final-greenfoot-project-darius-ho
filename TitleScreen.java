import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 415, 1); 

        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Background gameWorld = new Background();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Press <space> to start the game", 40);
        addObject(label,350,335);
        Label label2 = new Label("Use your mouse to move the rocket", 40);
        addObject(label2,350,385);
    }
}
