

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Craft {

    private String craft = "craft.png";
    Client clObj = new Client(this);
    public volatile int dx;
    public volatile int dy;
    public volatile int x;
    public volatile int y;
    private Image image;
    public ImageIcon ii;
    
    public Craft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        x = 40;
        y = 60;
    }


    public void move() {
    	System.out.println(this);
        x += dx;
        y += dy;
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
            ii = new ImageIcon(this.getClass().getResource("craftBACK.png"));
            image = ii.getImage();
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
            ii = new ImageIcon(this.getClass().getResource("craft.png"));
            image = ii.getImage();
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
            ii = new ImageIcon(this.getClass().getResource("craftUP.png"));
            image = ii.getImage();
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
            ii = new ImageIcon(this.getClass().getResource("craftDOWN.png"));
            image = ii.getImage();
        }
    }
	
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        
    }
}