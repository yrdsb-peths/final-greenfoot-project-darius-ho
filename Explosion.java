import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The enemy will expload after it is killed
 * 
 * @author (Darius Ho) 
 * @version (January 15 2024)
 */
public class Explosion extends Actor
{
    private int jeda=5;
    
    public void addedToWorld(World Background)
    {
        GreenfootImage image=new GreenfootImage(100,100);
        image.setColor(new Color(255,255,0,180));
        image.fillOval(0,0,image.getWidth()-1,image.getHeight()-1);
        image.fillOval(20,20,image.getWidth()-41,image.getHeight()-41);
        setImage(image);
        jeda=5;
    }
    
    public void act()
    {
        if(jeda>0)jeda--;
        else getWorld().removeObject(this);
    }
}
