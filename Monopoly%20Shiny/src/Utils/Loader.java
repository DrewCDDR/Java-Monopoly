package Utils;

import Nodes.UtilityNode;
import Cards.Chance;
import Cards.CommunityChest;
import Cards.Corner;
import Cards.Property;
import Cards.Station;
import Cards.Tax;
import Cards.Utility;
import Nodes.ChanceNode;
import Nodes.CommunityNode;
import Nodes.CornerNode;
import Nodes.MapNode;
import Nodes.PropertyNode;
import Nodes.StationNode;
import Nodes.TaxNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loader {
    public  File cards = new File("txts/cards.txt");
    public  File properties = new File("txts/properties.txt");
    public  File taxes = new File("txts/taxes.txt");
    public  File corners = new File("txts/corners.txt");
    public  File station = new File("txts/stations.txt");
    public  File utilities = new File("txts/utilities.txt");
    private Scanner lector;
    private ChanceNode chancePtr;
    private CommunityNode communityPtr;
    private PropertyNode propertyPtr;
    private StationNode stationPtr;
    private UtilityNode utilityPtr;
    private TaxNode taxPtr;
    private CornerNode cornerPtr;
    private MapNode mapPtr;
    
    public Loader(){
        File cards = new File("txts/cards.txt");
        File properties = new File("txts/properties.txt");
        File taxes = new File("txts/taxes.txt");
        File corners = new File("txts/corners.txt");
        File station = new File("txts/stations.txt");
        File utilities = new File("txts/utilities.txt");
    }
    
    public void loadCards(File file){
        try {
            Scanner lector = new Scanner(file);
            int c = 0;
            while (lector.hasNextLine()) {    
                String[] l = new String[5];
                String line = lector.nextLine();
                String[] s0 = line.split(";");
                for (int i = 0; i < 5; i++) {
                    String[] s1 = s0[i].split("=");
                    l[i] = s1[1];
                }
                if ("\"COMMUNITY\"".equals(l[2])) {
//                    System.out.println("New CommunityChest Card at C #" +c);
                    CommunityChest cc = new CommunityChest(l[2], c);
                    cc.title = l[0];
                    cc.description = l[1];
                    cc.flag = l[3];
                    cc.value = l[4];
                    
                    CommunityNode p = new CommunityNode(cc);
                    if (c == 0) {
                        communityPtr = p;
//                        System.out.println("New PTR for CommunitChest");
                    }else{
                        communityPtr.add(p);
//                        System.out.println("Added a Communitychest Node");
                    }
                    
                }else if("\"CHANCE\"".equals(l[2])){
//                    System.out.println("New Chance Card at C #" +c);
                    Chance ch = new Chance(l[2], c);
                    ch.title = l[0];
                    ch.description = l[1];
                    ch.flag = l[3];
                    ch.value = l[4];
                    
                    ChanceNode p = new ChanceNode(ch);
                    if (c == 17) {
                        chancePtr = p;
//                        System.out.println("New PTR for Chance");
                    }else{
                        chancePtr.add(p);
//                        System.out.println("Added a Chance Node");
                    }
                }
//                System.out.println("=========================================");
                c++;
            }
            /*System.out.println("=========================================");
            communityPtr.printTitles();
            System.out.println("=========================================");
            chancePtr.printTitles();*/
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadPorperties(File file){
        try {
//            System.out.println("Entered");
            Scanner lector = new Scanner(file);
            int c = 0;
            while (lector.hasNextLine()) {    
//                System.out.println("Reading");    
                String[] l = new String[13];
                String line = lector.nextLine();
                String[] s0 = line.split(";");
                for (int i = 0; i < 13; i++) {
//                    System.out.println("Separating");
                    String[] s1 = s0[i].split("=");
                    l[i] = s1[1];
                }
//                System.out.println("Assining");
                Property pr = new Property("Property", c);
                pr.setIndex(Integer.parseInt(l[0]));
                pr.setName(l[1]);
                pr.setColorName(l[2]);
                pr.setRent(Integer.parseInt(l[3]));
                pr.setOneHouseValue(Integer.parseInt(l[4]));
                pr.setTwoHouseValue(Integer.parseInt(l[5]));
                pr.setThreeHouseValue(Integer.parseInt(l[6]));
                pr.setFourHouseValue(Integer.parseInt(l[7]));
                pr.setHotelValue(Integer.parseInt(l[8]));
                pr.setMortage(Integer.parseInt(l[9]));
                pr.setHouseCost(Integer.parseInt(l[10]));
                pr.setHotelCost(Integer.parseInt(l[11]));
                pr.setPropertyValue(Integer.parseInt(l[12]));
                
                PropertyNode p = new PropertyNode(pr);
                if (c == 0) {
                    propertyPtr = p;
                }else{
                    propertyPtr.add(p);
                }
//                System.out.println("=========================================");
                c++;
            }
//            propertyPtr.printProperty();
   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadTaxes(File file){
        try {
            Scanner lector = new Scanner(file);
            int c = 0;
            while (lector.hasNextLine()) {    
                String[] l = new String[2];
                String line = lector.nextLine();
                String[] s0 = line.split(";");
                for (int i = 0; i < 2; i++) {
                    String[] s1 = s0[i].split("=");
                    l[i] = s1[1];
                }
                Tax t = new Tax("Tax",c);
                t.setIndex(Integer.parseInt(l[0]));
                t.setName(l[1]);
                
                TaxNode p = new TaxNode(t);
                if (c == 0) {
                    taxPtr = p;
                }else{
                    taxPtr.add(p);
                }
                c++;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadCorners(File file){
        try {
            Scanner lector = new Scanner(file);
            int c = 0;
            while (lector.hasNextLine()) {    
                String[] l = new String[3];
                String line = lector.nextLine();
                String[] s0 = line.split(";");
                for (int i = 0; i < 3; i++) {
                    String[] s1 = s0[i].split("=");
                    l[i] = s1[1];
                }
                Corner crn = new Corner("Corner",c);
                crn.setIndex(Integer.parseInt(l[0]));
                crn.setMove(l[1]);
                crn.setName(l[2]);
                
                CornerNode p = new CornerNode(crn);
                if (c == 0) {
                    cornerPtr = p;
                }else{
                    cornerPtr.add(p);
                }
                c++;
            }
            
//            cornerPtr.printTitles();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadStations(File file){
        try {
            Scanner lector = new Scanner(file);
            int c = 0;
            while (lector.hasNextLine()) {    
                String[] l = new String[8];
                String line = lector.nextLine();
                String[] s0 = line.split(";");
                for (int i = 0; i < 8; i++) {
                    String[] s1 = s0[i].split("=");
                    l[i] = s1[1];
                }
                Station s = new Station("Station",c);
                s.setIndex(Integer.parseInt(l[0]));
                s.setPrice(Integer.parseInt(l[1]));
                s.setRent(Integer.parseInt(l[2]));
                s.setName(l[3]);
                s.setIf2(Integer.parseInt(l[4]));
                s.setIf3(Integer.parseInt(l[5]));
                s.setIf4(Integer.parseInt(l[6]));
                s.setMortage(Integer.parseInt(l[7]));
                                
                StationNode p = new StationNode(s);
                if (c == 0) {
                    stationPtr = p;
                }else{
                    stationPtr.add(p);
                }
                c++;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadUtilities(File file){
        try {
            Scanner lector = new Scanner(file);
            int c = 0;
            while (lector.hasNextLine()) {                
                String[] l = new String[4];
                String line = lector.nextLine();
                String[] s0 = line.split(";");
                for (int i = 0; i < 4; i++) {
                    String[] s1 = s0[i].split("=");
                    l[i] = s1[1];
                }
                Utility u = new Utility("Utility", c);
                u.setIndex(Integer.parseInt(l[0]));
                u.setName(l[1]);
                u.setPrice(Integer.parseInt(l[2]));
                u.setMortage(Integer.parseInt(l[3]));
                
                UtilityNode p = new UtilityNode(u);
                if (c == 0) {
                    utilityPtr = p;
                }else{
                    utilityPtr.add(p);
                }
                
                c++;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadMap(){
        int c = 1;
        PropertyNode prP = propertyPtr;
        CornerNode crP = cornerPtr;
        TaxNode txP = taxPtr;
        StationNode stP = stationPtr;
        UtilityNode uP = utilityPtr;
//        System.out.println("Started");
        while(c < 41){
//            System.out.println("Entered");
//                System.out.println("========================================="); 
//                System.out.println("1: " +((Corner)crP.corner).getIndex()); 
//                System.out.println("Next Property Must be: " +((Property)prP.property).getName()); 
//                System.out.println("3: " +((Tax)txP.tax).getIndex()); 
//                System.out.println("4: " +((Station)stP.station).getIndex()); 
//                System.out.println("5: " +((Utility)uP.card).getIndex()); 
//                System.out.println("C:" +c);
            if(crP != null){    
                if (c == ((Corner)crP.corner).getIndex()) {
//                     System.out.println("C #" +c +": Corner, NAME = " + ((Corner)crP.corner).getName()); 
                     MapNode p = new MapNode(c, ((Corner)crP.corner).getName(), crP.corner);
                     if (c == 1) {
                        mapPtr = p;
                    }else{
                         mapPtr.add(p);
                    }
                    crP = crP.link;
                    c++;
                }
            }
            if(prP != null){
                if( c == ((Property)prP.property).getIndex()){
//                    System.out.println("C #" +c +": Property, NAME = " +((Property) prP.property).getName());
                    MapNode p = new MapNode(c, ((Property) prP.property).getName(), prP.property);
                    mapPtr.add(p);
                    prP = prP.link;
                    c++;
                }
            }
            if(txP != null){
                if(c == ((Tax)txP.tax).getIndex()){
//                    System.out.println("C #" +c +": Tax, NAME = " +((Tax) txP.tax).getName());
                    MapNode p = new MapNode(c, ((Tax) txP.tax).getName(), txP.tax);
                    mapPtr.add(p);
                    txP = txP.link;
                    c++;
                }
            }
            if(stP != null){
                if(c == ((Station)stP.station).getIndex()){
//                    System.out.println("C #" +c +": Station, NAME = " +((Station) stP.station).getName());
                    MapNode p = new MapNode(c, ((Station) stP.station).getName(), stP.station);
                    mapPtr.add(p);
                    stP = stP.link;
                    c++;
                }
            }
            if(uP != null){
                if(c == ((Utility) uP.card).getIndex()){
//                    System.out.println("C #" +c +": Utility, NAME = " +((Utility) uP.card).getName());
                    MapNode p = new MapNode(c, ((Utility) uP.card).getName(), uP.card);
                    mapPtr.add(p);
                    uP = uP.link;
                    c++;
                }
            }
            if (c == 8 || c == 23 || c == 37) {
//                System.out.println("C #" +c +": Chance");
                MapNode p = new MapNode(c,"CHANCE",null);
                mapPtr.add(p);
                c++;
            }else if(c == 3 || c == 18 || c == 34){
//                System.out.println("C #" +c +": Community");
                MapNode p = new MapNode(c,"COMMUNITY",null);
                mapPtr.add(p);
                c++;
            }
        }
    }

    public MapNode getMapPtr() {
        return mapPtr;
    }

    public void setMapPtr(MapNode mapPtr) {
        this.mapPtr = mapPtr;
    }
}
    
    
    

