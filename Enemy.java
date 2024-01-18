import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the enemy that you will kill using your rocket and lasers
 * 
 * @author (Darius Ho) 
 * @version (January 14 2024)
 */
public class Enemy extends Actor
{
    private int vx=0;
    private boolean toRemove=false;
    
    public Enemy(int v)
    {
        vx=v;
    }
    
    public void addedToWorld(World Background)
    {
        setRotation(0);
    }
    
    public void Destroyed()
    {
        for(int i=0;i<10;i++)
        {
            int px=-20+Greenfoot.getRandomNumber(40);
            int py=-20+Greenfoot.getRandomNumber(40);
            getWorld().addObject(new Explosion_flakes(getImage()),getX()+px,getY()+py);
        }
        getWorld().addObject(new Explosion(),getX(),getY());
        toRemove=true;
    }
    
    public void move()
    {
        setLocation(getX()+vx,getY());
        /*Actor actor=getOneIntersectingObject(Rocket.class);
        if(actor!=null)
        {
            ((Rocket)actor)Destroyed();
            Destroyed();
        }*/
        if(getX()<-200)
        {
            toRemove=true;
        }    
    }
    
    public void act()
    {
        if(!toRemove) move();
        else getWorld().removeObject(this);
    }
}