// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Lobster extends Actor
{

    /**
     * 
     */
    public Lobster()
    {
        turn(Greenfoot.getRandomNumber(360));
        
    }

    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
        eat();
        zombify();
        
        if (isGameOver2()) {
            transitionToGameOverWorld();
        }
        if (isGameOver()) {
            transitionToGameOverWorld();
        }
    }

    /**
     * 
     */
    public void moveAround()
    {
        move(4);
        if (Greenfoot.getRandomNumber(10) == 1) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (isAtEdge()) {
            turn(180);
        }
    }

    /**
     * 
     */
    public void eat()
    {
        Actor crab = getOneIntersectingObject(Crab.class);
        if (crab != null) {
            World world = getWorld();
            world.removeObject(crab);
            Greenfoot.playSound("horror-hit-logo-142395.mp3");
        }
    }

    /**
     * 
     */
    public boolean isGameOver()
    {
        World world = getWorld();
        if (world.getObjects(Crab.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 
     */
    public boolean isGameOver2()
    {
        World world = getWorld();
        if (world.getObjects(Worm.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Make the current world, the GameOverWorld!
     */
    public void transitionToGameOverWorld()
    {
        World gameOverWorld =  new  GameOverWorld();
        Greenfoot.setWorld(gameOverWorld);
    }

    /**
     * 
     */
    public void zombify()
    {
        Actor worm = (Worm)getOneIntersectingObject(Worm.class);
        if (worm != null) {
            int wormX = worm.getX();
            int wormY = worm.getY();
            World world = getWorld();
            world.removeObject(worm);
            Lobster newLobster =  new  Lobster();
            world.addObject(newLobster, wormX, wormY);
        }
    }
}
