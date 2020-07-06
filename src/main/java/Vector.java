import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Vector {
    private Point startPoint;
    private Point endPoint;


    public double lengthVector() {
        return Math.abs(Math.sqrt(Math.pow(endPoint.getCoordonateX() - startPoint.getCoordonateX(), 2) + Math.pow(endPoint.getCoordonateY() - startPoint.getCoordonateY(), 2)));

    }

    public static Vector SumVector(Vector prim, Vector second) throws Exception {
        if ((prim.startPoint.getCoordonateX() == prim.endPoint.getCoordonateX() &
                prim.startPoint.getCoordonateY() == prim.endPoint.getCoordonateY()) ||

                (second.startPoint.getCoordonateX() == second.endPoint.getCoordonateX() &
                        second.startPoint.getCoordonateY() == second.endPoint.getCoordonateY())) {

            throw new Exception("Vectorii trebuie sa fie de lungime nenula");
        }

        Point firstPoint = new Point(prim.startPoint.getCoordonateX(), prim.startPoint.getCoordonateY());
        Point secondPoint = new Point(prim.endPoint.getCoordonateX() + (second.endPoint.getCoordonateX() - second.startPoint.getCoordonateX()), prim.endPoint.getCoordonateY() + (second.endPoint.getCoordonateY() - second.startPoint.getCoordonateY()));

        return new Vector(firstPoint, secondPoint);
    }

    public static Vector DiffVector(Vector prim, Vector second) throws Exception {
        if ((prim.startPoint.getCoordonateX() == prim.endPoint.getCoordonateX() &
                prim.startPoint.getCoordonateY() == prim.endPoint.getCoordonateY()) ||

                (second.startPoint.getCoordonateX() == second.endPoint.getCoordonateX() &
                        second.startPoint.getCoordonateY() == second.endPoint.getCoordonateY())) {

            throw new Exception("Vectorii trebuie sa fie de lungime nenula");

        }

        Point firstPoint = new Point(prim.endPoint.getCoordonateX(), prim.endPoint.getCoordonateY());
        Point secondPoint = new Point((prim.startPoint.getCoordonateX() + (second.endPoint.getCoordonateX() - second.startPoint.getCoordonateX())), prim.startPoint.getCoordonateY() + (second.endPoint.getCoordonateY() - second.startPoint.getCoordonateY()));

        return new Vector(firstPoint, secondPoint);
    }

    public Point returnProiection() {
        return new Point(this.endPoint.getCoordonateX() - this.startPoint.getCoordonateX(),
                this.endPoint.getCoordonateY() - this.startPoint.getCoordonateY());
    }

    public static double DegreesTwoVectors(Vector prim, Vector second) {
        Point proiectionPrim = prim.returnProiection();
        Point proiectionSecond = second.returnProiection();
        return Math.toDegrees(Math.acos(((proiectionPrim.getCoordonateX() * proiectionSecond.getCoordonateX()) +
                (proiectionPrim.getCoordonateY() * proiectionSecond.getCoordonateY())) /
                (prim.lengthVector() * second.lengthVector())));
    }


    public double OneVectorDegrees() {

        Vector rootZero = new Vector(new Point(0, 0),
                new Point(this.endPoint.getCoordonateX() - this.startPoint.getCoordonateX(),
                        this.endPoint.getCoordonateY() - this.startPoint.getCoordonateY()));

        if (rootZero.endPoint.getCoordonateX() >= 0 & rootZero.endPoint.getCoordonateY() > 0) {
            Vector translationVectorOX = new Vector(this.startPoint, new Point(this.endPoint.getCoordonateX(), 0));
            return Math.toDegrees(Math.acos((translationVectorOX.lengthVector()) / this.lengthVector()));

        }
        if (rootZero.endPoint.getCoordonateX() >= 0 & rootZero.endPoint.getCoordonateY() < 0) {
            Vector translationVectorOX = new Vector(this.startPoint, new Point(this.endPoint.getCoordonateX(), 0));
            return 270 + Math.toDegrees(Math.acos((translationVectorOX.lengthVector()) / this.lengthVector()));
        }
        if (rootZero.endPoint.getCoordonateX() <= 0 & rootZero.endPoint.getCoordonateY() < 0) {
            Vector translationVectorOX = new Vector(this.startPoint, new Point(this.endPoint.getCoordonateX(), 0));
            return 180 + Math.toDegrees(Math.acos((translationVectorOX.lengthVector()) / this.lengthVector()));
        }
        if (rootZero.endPoint.getCoordonateX() <= 0 & rootZero.endPoint.getCoordonateY() > 0) {
            Vector translationVectorOX = new Vector(this.startPoint, new Point(this.endPoint.getCoordonateX(), 0));
            return 90 + Math.toDegrees(Math.acos((translationVectorOX.lengthVector()) / this.lengthVector()));
        }
        return 1000;
    }




}
