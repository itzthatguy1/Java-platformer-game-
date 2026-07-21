import java.awt.*;
import java.util.ArrayList;

/**
 * Enemy class with simple AI and patrol behavior.
 */
public class Enemy extends Entity {
    
    private int width = 30;
    private int height = 30;
    private double velocityX = -2;
    private double velocityY = 0;
    private double gravity = 0.5;
    private boolean alive = true;
    private int patrolDistance = 150;
    private int startX;
    
    public Enemy(int x, int y) {
        super(x, y);
        this.startX = x;
    }
    
    public void update(ArrayList<Platform> platforms) {
        // Horizontal movement
        x += velocityX;
        
        // Gravity
        velocityY += gravity;
        if (velocityY > 15) {
            velocityY = 15;
        }
        
        y += (int)velocityY;
        
        // Collision with platforms
        boolean onPlatform = false;
        for (Platform platform : platforms) {
            if (this.getBounds().intersects(platform.getBounds())) {
                if (velocityY > 0) {
                    y = platform.getY() - height;
                    velocityY = 0;
                    onPlatform = true;
                } else if (velocityY < 0) {
                    y = platform.getY() + platform.getHeight();
                    velocityY = 0;
                }
            }
        }
        
        // Patrol behavior
        if (Math.abs(x - startX) > patrolDistance) {
            velocityX *= -1;
        }
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.setColor(new Color(255, 150, 150));
        g.fillRect(x, y, width, height);
        
        // Draw eyes
        g.setColor(Color.BLACK);
        g.fillOval(x + 5, y + 5, 5, 5);
        g.fillOval(x + 20, y + 5, 5, 5);
    }
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
    public boolean isAlive() { return alive; }
    public void setAlive(boolean alive) { this.alive = alive; }
}
