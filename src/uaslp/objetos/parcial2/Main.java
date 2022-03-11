package uaslp.objetos.parcial2;


import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

abstract class Figure{
 private static int figuresCreated;
 private final String name;

protected Figure(String name){
    this.name=name;
    figuresCreated++;
}
public abstract float getArea();
public abstract float getPerimeter();

public final String getName(){
    return name;
}

public static int  getFiguresCreated(){

    return figuresCreated;
}
}

class Circle extends Figure{

    public Circle(){
        super("Circulo");
    }
 private float radio;

    public Circle(float radio){
        super("Circulo");
        this.radio=radio;
    }
public float getArea(){
    return (float)Math.PI * radio * radio;
}
public float getPerimeter(){
    return (float)Math.PI * 2 * radio;
}

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
}

class Rectangle extends Figure{

    public Rectangle(){
        super("Rectangulo");
    }
    private float base;
    private float height;
    public Rectangle(float base, float height ){
        super("Rectangulo");
        this.base = base;
        this.height=height;

    }

    public float getArea(){
        return base * height;
    }
    public float getPerimeter(){
        return 2*base + 2*height;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

class Polygon extends Figure{

    private float apotema;
    private int sidesCount;
    private float sideLenght;


    public Polygon(float apotema, int sidesCount, float sideLenght){
        super("Poligono");
        this.apotema=apotema;
        this.sidesCount=sidesCount;
        this.sideLenght=sideLenght;

    }
    public float getArea(){
        return getPerimeter() * apotema/2;
    }
    public float getPerimeter(){
        return sideLenght*sidesCount;
    }

}





public class Main {

    public static void main(String[] args) {
        List<Figure> figureList = new LinkedList<>();



        //circlesTest();
        //rectanglesTest();
        //polygonTest();


        figureList.add(new Polygon(4,5,6.3f));
        figureList.add(new Polygon(4.5f,8,3.9f));
        figureList.add(new Rectangle(4,5));
        figureList.add(new Rectangle(4.5f,9.6f));
        Circle circle1 =new Circle();
        Circle circle2 =new Circle(10.6f);

        circle1.setRadio(5.3f);

        figureList.add(circle1);
        figureList.add(circle2);


        for(Figure figure: figureList){
            System.out.println(figure.getName()+", Area: "+figure.getArea()+", Perimetro: "+figure.getPerimeter());
        }
        if(Modifier.isAbstract(Figure.class.getModifiers())){
            System.out.println("Figure es abstracta");
        }
        System.out.println("Se generaron: "+ Figure.getFiguresCreated()+" figuras");

    }

    private static void polygonTest() {
        List<Polygon> polygonList = new LinkedList<>();



        polygonList.add(new Polygon(4,5,6.3f));
        polygonList.add(new Polygon(4.5f,8,3.9f));

        for(Polygon polygon: polygonList){
            System.out.println(polygon.getName()+", Area: "+polygon.getArea()+", Perimetro: "+polygon.getPerimeter());
        }
    }

    private static void rectanglesTest() {

        List<Rectangle> rectangleList = new LinkedList<>();



        rectangleList.add(new Rectangle(4,5));
        rectangleList.add(new Rectangle(4.5f,9.6f));

        for(Rectangle rectangle: rectangleList){
            System.out.println(rectangle.getName()+", Area: "+rectangle.getArea()+", Perimetro: "+rectangle.getPerimeter());
        }
    }

    private static void circlesTest() {
        List<Circle> circleList = new LinkedList<>();
        Circle circle1 =new Circle();
        Circle circle2 =new Circle(10.6f);

        circle1.setRadio(5.3f);

        circleList.add(circle1);
        circleList.add(circle2);

        for(Circle circle: circleList){
            System.out.println(circle.getName()+", Area: "+circle.getArea()+", Perimetro: "+circle.getPerimeter());
        }
    }
}
