import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the background for the game
 * 
 * @author (Darius Ho) 
 * @version (January 13 2024)
 */
public class Background extends World
{
    public int score = 0;
    Label scoreLabel;
    private int jeda=0;
    
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1,false);
        
        addObject(new Rocket(),100,200);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    public void act()
    {
        if(jeda>0)jeda--;
        else jeda=20;
        if(jeda==1)
        {
            int py=Greenfoot.getRandomNumber(getHeight());
            addObject(new Enemy(-(2+Greenfoot.getRandomNumber(3))),getWidth()+200,py);
        }
        checkCollisions();
    }
    
    private void checkCollisions()
    {   
        Rocket rocket = getRocket();
        java.util.List<Enemy> enemies = getObjects(Enemy.class);

        if (enemies != null && !enemies.isEmpty()) 
        {
            for (Enemy enemy : enemies) 
            {
                if (!enemy.toRemove && rocket.intersects(enemy)) 
                {
                    enemy.Destroyed();
                    increaseScore();
                }
            }
        }
    }   
    
    private Rocket getRocket()
    {
        java.util.List<Rocket> rockets = getObjects(Rocket.class);
        return rockets.isEmpty() ? null : rockets.get(0);
    }
}