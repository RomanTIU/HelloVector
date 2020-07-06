import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


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
        Point point = new Point(-4, -6);
        Point point5 = new Point(-8, 7);


        Vector vector = new Vector(point1,point2);
        Vector vector1 = new Vector(point3,point4);
        Vector vector4 = new Vector(point, point5);

        //Vector result of sum 2 vectors
        Vector vector3 = Vector.SumVector(vector,vector1);
        LOGGER.info("Length vector is : "+ new DecimalFormat("#.#").format(vector3.lengthVector()));

        //Degree of two vectors
        Double degrees = Vector.DegreesTwoVectors(vector1,vector);
        LOGGER.info("Degrees two vectors : "+ new DecimalFormat("#.##").format(degrees));

        //Vector to OX degrees
        Vector oXVector = new Vector(new Point(0,0),new Point(-3,-6));
        LOGGER.info("Degrees one vector : "+ new DecimalFormat("#.##").format(oXVector.OneVectorDegrees()));



        //Vector result of diff 2 vectors
        Vector vector2 = Vector.DiffVector(vector,vector1);
        LOGGER.info(vector2);


        LOGGER.info("Length vector is : "+ new DecimalFormat("#.#").format(vector4.lengthVector()));

        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        Vector [] vectorMasiv = new Vector[]{vector,vector1,vector2,vector3,vector4};
        writer.writeValue(Paths.get("vector.json").toFile(),vectorMasiv);
        Vector[] vectorFromJSON = objectMapper.readValue(new File("vector.json"),Vector[].class);

        for (Vector value :
                vectorFromJSON) {
            LOGGER.info("From JSON "+value);

        }

    }
}
