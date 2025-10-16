
//abstract class

abstract class Shapes {
    // declaring abstract methods
    // volumes
    abstract void rectangle_volume(int length, int width, int height);

    abstract void cube_volume(double length);

    // areas
    abstract void rectangle_area(int length, int width);

    abstract void circle_area(float radius);

    abstract void square_area(int side);

    public static void main(String[] args) {
        Shapes shapes = new Main();
        shapes.square_area(34);
        shapes.square_area(35);
        shapes.rectangle_volume(20, 20, 30);

    }
}

// extending abstract class
class Main extends Shapes {

    public void rectangle_volume(int length, int width, int height) {
        int recVol = length * width * height;
        System.out.println("Volume of the rectangle is: " + recVol);
    }

    public void rectangle_area(int length, int width) {
        int recArea = length * width;
        System.out.println("Area of the rectangle is: " + recArea);
    }

    public void cube_volume(double length) {
        double cubeVol = length * length * length;
        System.out.println("Volume of the cube is: " + cubeVol);
    }

    public void circle_area(float radius) {
        double circleArea = Math.PI * Math.pow(radius, 2);
        System.out.println("Area of the circle is: " + circleArea);
    }

    public void square_area(int side) {
        double sqArea = side * side;
        System.out.println("Area of the square is: " + sqArea);
    }
}