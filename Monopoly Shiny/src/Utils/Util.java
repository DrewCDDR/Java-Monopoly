package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

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
}
