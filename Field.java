import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Initializes the field which contains all walkers and allows for comparisons between them.
 */
public class Field {

    private Walker firstWalker;
    private HashMap<String, Walker> Walkers = new HashMap<>();
    private cPoint Origin = new cPoint(0.0,0.0);

    public Field (Walker firstWalker){
        this.firstWalker = firstWalker;
        this.Walkers.put(firstWalker.getName(), firstWalker);
    }

    public void addWalker (Walker newWalker){
        this.Walkers.put(newWalker.getName(), newWalker);

    }

    public double getOriginDist(String walkerName){
        Walker testWalker = Walkers.get(walkerName);
        if (testWalker != null){

            cPoint curLoc = testWalker.getLocation();
            return curLoc.getDistance(0.0,0.0);

        }

        else {
            throw new NoSuchElementException();
        }
    }

    public double getWalkerDist(String walkerName, String walkerName2){
        Walker testWalker1 = Walkers.get(walkerName);
        Walker testWalker2 = Walkers.get(walkerName2);
        cPoint walker1Loc;
        cPoint walker2Loc;

        if (testWalker1 != null){
            walker1Loc = testWalker1.getLocation();
        }
        else{
            throw new NoSuchElementException(walkerName +" is not walking in the field.");
        }
        if (testWalker2 != null){
            walker2Loc = testWalker2.getLocation();
        }
        else{
            throw new NoSuchElementException(walkerName2 + " is not walking in the field.");
        }

        return walker1Loc.getDistance(walker2Loc.getX(), walker2Loc.getY());
    }

    public static void main(String[] args){

        Walker Shiro = new Walker("Shiro", 1);
        Walker Stallman = new Walker("Stallman", 0.75);
        Shiro.setLocation(0.0, 0.0);
        Stallman.setLocation(0.0, 0.0);

        Field USCCampus = new Field(Shiro);
        USCCampus.addWalker(Stallman);

        for(int i = 0; i < 1000; i++){
            Stallman.takeStep();
        }

        Shiro.takeStep();

        System.out.println(USCCampus.getWalkerDist("Kaisen", "Stallman"));
        System.out.println(USCCampus.getOriginDist("Shiro"));
        System.out.println(Shiro.getName()+ " is at ("+ Shiro.getX()+ ", "+ Shiro.getY() + "), while The Bearded One is " +
                "at " + "(" +Stallman.getX()+ ", " + Stallman.getY()+") being obnoxious. Keep moving.");


    }
}
