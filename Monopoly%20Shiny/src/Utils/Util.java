package Utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.swing.JLabel;

public class Util {
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                 builder.append(line +"\n");
            }
            br.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }
    
    public static int parseInt(String number){
        try{
            return Integer.parseInt(number);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public static int rand(int min, int max){
        Random rand = new Random();
        int randNum = rand.nextInt((max - min) + 1) + min;
        return randNum;
    }
    public static float rand(float min, float max){
        Random rand = new Random();
        float randNum = rand.nextFloat() * (max-min) +min;
        return randNum;
    }
    public static Font loadFont(float size, int style, JLabel j) {
    Font font = null;
    InputStream is = j.getClass().getResourceAsStream("starv___.ttf");
    try {
        font = Font.createFont(Font.TRUETYPE_FONT, is);
        font = font.deriveFont(size);
        font = font.deriveFont(style);
    } /*catch (FileNotFoundException fe) {
        System.out.println("File not found"); // was in here because i tried a file       instead of an InputStream
    } */catch (FontFormatException ex) {
        System.out.println("Font is null1");
    } catch (IOException e) {
        System.out.println("Font is null2");
    }
    return font;
}
}
