/**
 * Camera class for following the player and managing viewport.
 */
public class Camera {
    
    private int x;
    private int y;
    private int width;
    private int height;
    
    public Camera(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
    }
    
    public void update(Player player) {
        // Follow player horizontally
        x = (int)player.getX() - width / 3;
        
        // Clamp camera position
        if (x < 0) x = 0;
        if (x > 5000 - width) x = 5000 - width;
        
        // Keep player vertically centered (roughly)
        y = (int)player.getY() - height / 3;
        if (y < 0) y = 0;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
}
