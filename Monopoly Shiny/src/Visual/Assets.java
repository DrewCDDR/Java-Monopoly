package Visual;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Assets {
    public static Image menu = new ImageIcon("images/Menu.jpg").getImage();
    public static Image menuTitle = new ImageIcon("images/MenuTitle.").getImage();
    public static BufferedImage[] money;
    
    public static void init(){
        money = new BufferedImage[7];
        
        SpriteSheet moneySpSh =
                new SpriteSheet(ImageLoader.loadImage("images/Money.jpg"));
    }
}
