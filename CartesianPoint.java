/**
 * Initialized the class for Cartesian points on a plane.
 */
public class CartesianPoint {

    private double x;
    private double y;
    private double radius;
    private double angle;

    public CartesianPoint(double x, double y){
        this.x  = x;
        this.y = y;
        this.radius = Math.sqrt(x*x + y*y);
        this.angle = Math.atan2(y, x);
    }

    public CartesianPoint (CartesianPoint inputPoint){

        this.x = inputPoint.getX();
        this.y = inputPoint.getY();
        this.radius = Math.sqrt(this.x*this.x + this.y*this.y);
        this.angle = Math.atan2(this.y, this.x);
    }

    public double getX(){
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void printPolar() {

        System.out.println(this.radius + " unit radius, " + this.angle + " angle radians");
    }

    public void move(double xDis, double yDis) {
        double newX = this.x + xDis;
        double newY = this.y + yDis;
        this.x = newX;
        this.y = newY;
        this.radius = Math.sqrt(this.x*this.x + this.y*this.y);
        this.angle = Math.atan2(this.y, this.x);

    }

    public double getDistance(double oX, double oY) {
        double distX = oX - this.x;
        double distY = oY - this.y;
        return Math.sqrt((distX * distX) + (distY * distY));
    }

    public double getDistance(CartesianPoint point2){
        double distX = point2.getX() - this.x;
        double distY = point2.getY() - this.y;
        return Math.sqrt((distX * distX) + (distY * distY));
    }

    public static void main(String[] args){

        CartesianPoint origin = new CartesianPoint(0.0, 0.0);
        System.out.println(origin.getX());
        System.out.println(origin.getY());
        double testDist1 = origin.getDistance(1.0, 3.0);
        System.out.println(testDist1);

        CartesianPoint testPoint = new CartesianPoint(1.0, 3.0);
        testPoint.move(2.0, 2.0);

        System.out.println(testPoint.getX());
        System.out.println(testPoint.getY());
        double testDist2 = testPoint.getDistance(origin);
        System.out.println(testDist2);

        testPoint.printPolar();
    }
}


