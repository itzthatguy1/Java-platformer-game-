import java.awt.*;
import java.util.ArrayList;

/**
 * Level class that creates and manages all platforms and enemies for a level.
 */
public class Level {
    
    private ArrayList<Platform> platforms;
    private ArrayList<Enemy> enemies;
    
    public Level() {
        platforms = new ArrayList<>();
        enemies = new ArrayList<>();
        createLevel();
    }
    
    private void createLevel() {
        // Ground level
        platforms.add(new Platform(0, 550, 1200, 50, new Color(34, 139, 34)));
        
        // Starting platform
        platforms.add(new Platform(50, 480, 150, 20, new Color(100, 200, 100)));
        
        // Staircase going up
        platforms.add(new Platform(250, 450, 100, 20));
        platforms.add(new Platform(400, 410, 100, 20));
        platforms.add(new Platform(550, 370, 100, 20));
        
        // Gap section
        platforms.add(new Platform(750, 400, 80, 20));
        platforms.add(new Platform(900, 350, 80, 20));
        
        // Higher section
        platforms.add(new Platform(1050, 300, 100, 20));
        platforms.add(new Platform(1200, 400, 100, 20));
        
        // Moving down to finish
        platforms.add(new Platform(1350, 450, 100, 20));
        platforms.add(new Platform(1500, 500, 150, 20));
        
        // Extended ground to finish line
        platforms.add(new Platform(1200, 550, 500, 50, new Color(34, 139, 34)));
        
        // Enemies
        enemies.add(new Enemy(300, 420));
        enemies.add(new Enemy(600, 340));
        enemies.add(new Enemy(950, 320));
        enemies.add(new Enemy(1100, 270));
    }
    
    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }
    
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
