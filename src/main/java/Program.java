import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;


public class Program {

    private static final Logger LOGGER = Logger.getLogger(Program.class);

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        PropertyConfigurator.configure("log4j.properties");

        Point point1 = new Point(1,1);
        Point point2 = new Point(2,2);

        Point point3 = new Point(4,3);
        Point point4 = new Point(5,5);

        Point point = new Point(2, 2);
        Point point5 = new Point(5, 6);

        Vector vector4 = new Vector(point, point5);
        Vector vector = new Vector(point1,point2);
        Vector vector1 = new Vector(point3,point4);

        Vector vector3 = Vector.SumVector(vector,vector1);
        LOGGER.info(vector3.lengthVector());

        Vector vector2 = Vector.DiffVector(vector,vector1);
        LOGGER.info(vector2);
        LOGGER.info(vector4.lengthVector());

        objectMapper.writeValue(new File("vector.json"), vector2);
        Vector vectorFromJSON = objectMapper.readValue(new File("vector.json"),Vector.class);
        LOGGER.info(vectorFromJSON);
    }
}
