import java.util.Scanner;
class InputScanner {
protected Scanner scanner = new Scanner(System.in);
}
abstract class Shape extends InputScanner {
protected int dimension1;
protected int dimension2;
public abstract void printArea();
public void input() {
System.out.print("Enter dimension 1: ");
dimension1 = scanner.nextInt();
System.out.print("Enter dimension 2: ");
dimension2 = scanner.nextInt();
}
}
class Rectangle extends Shape {
public void printArea() {
int area = dimension1 * dimension2;
System.out.println("Area of Rectangle: " + area);
}
}
class Triangle extends Shape {    
public void printArea() {
double area = 0.5 * dimension1 * dimension2;
System.out.println("Area of Triangle: " + area);
}
}
class Circle extends Shape {
public void printArea() {
double area = Math.PI * Math.pow(dimension1, 2);
System.out.println("Area of Circle: " + area);
}
}

public class Main {
public static void main(String[] args) {
InputScanner inputScanner = new InputScanner();
System.out.println("Rectangle:");
Rectangle rectangle = new Rectangle();
rectangle.input();
rectangle.printArea();
System.out.println("Triangle:");
Triangle triangle = new Triangle();
triangle.input();
triangle.printArea();
System.out.println("Circle:");
Circle circle = new Circle();
System.out.print("Enter radius: ");
circle.dimension1 = inputScanner.scanner.nextInt();
circle.printArea();        
inputScanner.scanner.close();
}
}
