import java.util.concurrent.ThreadLocalRandom;

/**
 * Initializes a walker object. Takes a string as a name and a value for its stride length.
 */

public class Walker {

    private String name;
    private double stride;
    private double x;
    private double y;
    private cPoint startLoc;
    private cPoint currentLoc;



    public Walker(String name, double stride){

        this.name = name;
        this.stride = stride;

    }

    public String getName(){

        return this.name;
    }

    public double getStride(){

        return this.stride;
    }

    public void setLocation(double startX, double startY){

        this.x  = startX;
        this.y  = startY;
        this.startLoc = new cPoint(this.x, this.y);
        this.currentLoc = new cPoint(this.startLoc);

    }

    /* takes a step in a random direction in any angle from 0 to 360 degrees */
    public void takeStep(){
        int rand = ThreadLocalRandom.current().nextInt(0,360);
        double angle = rand * Math.PI / 180.0;
        double xDis = Math.cos(angle)*this.stride;
        double yDis = Math.sin(angle)*this.stride;
        this.currentLoc.move(xDis, yDis);
        this.x = this.currentLoc.getX();
        this.y = this.currentLoc.getY();

    }

    public cPoint getLocation(){

        return this.currentLoc;
    }

    public double getX(){

        return this.x;

    }

    public double getY(){

        return this.y;

    }



    public static void main(String[] args){

        Walker testWalker = new Walker("Shiro",1.0);
        System.out.println(testWalker.getName());
        System.out.println(testWalker.getStride());
        testWalker.setLocation(0.0, 0.0);
        testWalker.takeStep();
        System.out.println(testWalker.getX() + ", " + testWalker.getY());

    }
}
