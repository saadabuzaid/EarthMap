package Assignment;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main2D {

    public static List<MapCoordinate> MapCoordinates = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {


        Earth run = new Earth();
        run.readDataMap("earth.xyz");
        double seaArg = 0;
        if (args.length > 0)
            seaArg = Double.parseDouble(args[0]);
        Draw dEarth = new Draw(run.getMap(), seaArg);
        JFrame earthFrame = new JFrame("Saad earth");
        earthFrame.setSize(1200, 600);
        earthFrame.getContentPane().addMouseListener(new MouseListener(dEarth));
        earthFrame.add(dEarth);
        earthFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        earthFrame.setVisible(true);
    }

}
