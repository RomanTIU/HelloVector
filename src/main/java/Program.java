import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.text.DecimalFormat;


public class Program {

    private static final Logger LOGGER = Logger.getLogger(Program.class);

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        PropertyConfigurator.configure("log4j.properties");
        //Vector vector
        Point point1 = new Point(1,0);
        Point point2 = new Point(2,2);
        //Vector vector1
        Point point3 = new Point(1,0);
        Point point4 = new Point(3,3);
        //Vector vector4
        Point point = new Point(0, 0);
        Point point5 = new Point(3, 4);


        Vector vector = new Vector(point1,point2);
        Vector vector1 = new Vector(point3,point4);
        Vector vector4 = new Vector(point, point5);

        //Vector result of sum 2 vectors
        Vector vector3 = Vector.SumVector(vector,vector1);
        LOGGER.info("Length vector is : "+ new DecimalFormat("#.#").format(vector3.lengthVector())+ " U");
        //Degree of two vectors
        Double degrees = Vector.DegreesTwoVectors(vector1,vector);
        LOGGER.info("Degrees : "+ new DecimalFormat("#.##").format(degrees));

        Vector oXVector = new Vector(new Point(0,0),new Point(9,9));
        LOGGER.info("Degrees : "+ new DecimalFormat("#.##").format(oXVector.OneVectorDegrees()));



        //Vector result of diff 2 vectors
        Vector vector2 = Vector.DiffVector(vector,vector1);
        LOGGER.info(vector2);


        LOGGER.info("Length vector is : "+ new DecimalFormat("#.#").format(vector4.lengthVector()));


        objectMapper.writeValue(new File("vector.json"), vector2);
        Vector vectorFromJSON = objectMapper.readValue(new File("vector.json"),Vector.class);
        LOGGER.info("From JSON"+vectorFromJSON);
    }
}
