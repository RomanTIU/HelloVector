import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Vector {
   private Point startPoint;
   private Point endPoint;


    public double lengthVector(){
        return  Math.abs(Math.sqrt(Math.pow(endPoint.getCoordonateX()- startPoint.getCoordonateX(),2) + Math.pow(endPoint.getCoordonateY()- startPoint.getCoordonateY(),2)));

    }

    public static Vector SumVector(Vector prim, Vector second){

        Point firstPoint = new Point(prim.startPoint.getCoordonateX(),prim.startPoint.getCoordonateY());
        Point secondPoint = new Point(prim.endPoint.getCoordonateX()+(second.endPoint.getCoordonateX()-second.startPoint.getCoordonateX()),prim.endPoint.getCoordonateY()+(second.endPoint.getCoordonateY()-second.startPoint.getCoordonateY()));

        return new Vector(firstPoint,secondPoint);
    }

    public static Vector DiffVector(Vector prim, Vector second){

        Point firstPoint = new Point(prim.endPoint.getCoordonateX(),prim.endPoint.getCoordonateY());
        Point secondPoint = new Point((prim.startPoint.getCoordonateX()+(second.endPoint.getCoordonateX()-second.startPoint.getCoordonateX())),prim.startPoint.getCoordonateY()+(second.endPoint.getCoordonateY()-second.startPoint.getCoordonateY()));
        return new Vector(firstPoint,secondPoint);
    }
}
