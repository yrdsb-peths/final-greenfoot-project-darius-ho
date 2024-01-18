import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This is the laser used to kill enemys
 * 
 * @author (Darius Ho) 
 * @version (January 13 2024)
 */
public class Laser extends Actor
{
    private boolean toRemove=false;
    private int vx=3;
    public void addedToWorld(World Background)
    {
        GreenfootImage image=new GreenfootImage(30,10);
        image.setColor(new Color(255,255,0,180));
        image.drawLine(0,5,image.getWidth()-1,5);
        setImage(image);
    }
    public void act()
    {
        if(!toRemove)
        {
            setLocation(getX()+vx,getY());
            checkCollisions();
            if(getX()>getWorld().getWidth()+200) toRemove=true;
        }
        else
        {
            getWorld().removeObject(this);
        }
    }
    
    public boolean checkCollisions()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null)
        {
            ((Enemy) enemy).Destroyed();
            return true;
        }
        return false;
    }
}