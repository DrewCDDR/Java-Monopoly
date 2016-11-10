package Visual;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Assets {
    public static Image map = new ImageIcon("images/Map.jpg").getImage();
    public static Image menu = new ImageIcon("images/Menu.jpg").getImage();
    public static Image menuTitle = new ImageIcon("images/MenuTitle.png ").getImage();
    public static BufferedImage[] money, newGame, rules, buy, sell, mortage, 
            roll, back, x, properties, two, three, four, five, six, tokens;
    
    public static void init(){
        money = new BufferedImage[7];
        newGame = new BufferedImage[2];
        rules = new BufferedImage[2];
        properties = new BufferedImage[2];
        buy = new BufferedImage[2];
        sell = new BufferedImage[2];
        mortage = new BufferedImage[2];
        back = new BufferedImage[2];
        x = new BufferedImage[2];
        two = new BufferedImage[2];
        three = new BufferedImage[2];
        four = new BufferedImage[2];
        five = new BufferedImage[2];
        six = new BufferedImage[2];
        roll = new BufferedImage[2];
        tokens = new BufferedImage[6];
        
        SpriteSheet moneySpSh =
                new SpriteSheet(ImageLoader.loadImage("/Money.png"));
        SpriteSheet buttons =
                new SpriteSheet(ImageLoader.loadImage("/Buttons.png"));
        SpriteSheet numbers =
                new SpriteSheet(ImageLoader.loadImage("/Numbers.png"));
        
        //BUTTONS:
        newGame[0] = buttons.cut(0, 0, 578, 110);
        newGame[1] = buttons.cut(0, 128, 578, 110);
        rules[0] = buttons.cut(581, 0, 219, 110);
        rules[1] = buttons.cut(581, 130, 219, 106);
        properties[0] = buttons.cut(911, 0, 441, 126);
        properties[1] = buttons.cut(911, 127, 441, 126);
        buy[0] = buttons.cut(1352, 0, 166, 126);
        buy[1] = buttons.cut(1352, 128, 166, 126);
        sell[0] = buttons.cut(1518, 0, 149, 110);
        sell[1] = buttons.cut(1518, 128, 149, 110);
        mortage[0] = buttons.cut(1667, 0, 407, 128);
        mortage[1] = buttons.cut(1667, 127, 407, 128);
        back[0] = buttons.cut(800, 11, 110, 88);
        back[1] = buttons.cut(800, 138, 110, 88);
        x[0] = buttons.cut(2073, 0, 81, 106);
        x[1] = buttons.cut(2073, 128, 81, 106);   
        roll[0] = buttons.cut(0, 256, 151, 106);
        roll[1] = buttons.cut(152, 256, 151, 106);
        
        two[0] = numbers.cut(0, 0, 66, 95);
        two[1] = numbers.cut(0, 95, 66, 95);    
        three[0] = numbers.cut(0, 190, 66, 96);
        three[1] = numbers.cut(0, 286, 66, 96);    
        four[0] = numbers.cut(0, 382, 66, 97);
        four[1] = numbers.cut(0, 479, 66, 97);    
        five[0] = numbers.cut(0, 576, 66, 94);
        five[1] = numbers.cut(0, 670, 66, 94);    
        six[0] = numbers.cut(0, 764, 66, 97);
        six[1] = numbers.cut(0, 861, 66, 97);    
    }
}
