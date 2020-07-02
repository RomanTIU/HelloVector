import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Vector {
   private Point startPoint;
   private Point endPoint;


    public double lengthVector(){
        return  Math.abs(Math.sqrt(Math.pow(endPoint.getCoordonateX()- startPoint.getCoordonateX(),2) + Math.pow(endPoint.getCoordonateY()- startPoint.getCoordonateY(),2)));

    }

    public static Vector SumVector(Vector prim, Vector second) throws Exception {
        if (prim.startPoint.getCoordonateX() == second.startPoint.getCoordonateX() &
                prim.startPoint.getCoordonateY() == second.startPoint.getCoordonateY() &
                prim.endPoint.getCoordonateX() == second.endPoint.getCoordonateX() &
                prim.endPoint.getCoordonateY() == second.endPoint.getCoordonateY()){
            throw new Exception("Vectorii trebuie sa fie diferiti!");
        }
        Point firstPoint = new Point(prim.startPoint.getCoordonateX(),prim.startPoint.getCoordonateY());
        Point secondPoint = new Point(prim.endPoint.getCoordonateX()+(second.endPoint.getCoordonateX()-second.startPoint.getCoordonateX()),prim.endPoint.getCoordonateY()+(second.endPoint.getCoordonateY()-second.startPoint.getCoordonateY()));

        return new Vector(firstPoint,secondPoint);
    }

    public static Vector DiffVector(Vector prim, Vector second) throws Exception {
        if (prim.startPoint.getCoordonateX() == second.startPoint.getCoordonateX() &
                prim.startPoint.getCoordonateY() == second.startPoint.getCoordonateY() &
                prim.endPoint.getCoordonateX() == second.endPoint.getCoordonateX() &
                prim.endPoint.getCoordonateY() == second.endPoint.getCoordonateY()){
            throw new Exception("Vectorii trebuie sa fie diferiti!");
        }

        Point firstPoint = new Point(prim.endPoint.getCoordonateX(),prim.endPoint.getCoordonateY());
        Point secondPoint = new Point((prim.startPoint.getCoordonateX()+(second.endPoint.getCoordonateX()-second.startPoint.getCoordonateX())),prim.startPoint.getCoordonateY()+(second.endPoint.getCoordonateY()-second.startPoint.getCoordonateY()));
        return new Vector(firstPoint,secondPoint);
    }
}
