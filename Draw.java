package Assignment;

import javafx.geometry.Point3D;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Draw extends JComponent {
    int width = 1200, height = 600;
    double xmin = 0,  xmax = 360, ymin = -90, ymax = 90;
    Map<Integer, Point3D> EarthMap;
    double seaLevel;

    public int scaleX(double x) {
        return (int) (width * (x - xmin) / (xmax - xmin));
    }
    public int scaleY(double y) {
        return (int) (height * (ymin - y) / (ymax - ymin) + height);
    }
    public int getX (double x){ return (int) (((x * (xmax - xmin)) / width) + xmin); }
    public int getY (double y){ return (int) ((-((y - height)*(ymax - ymin)) / height) + ymin);}
    public void setScaleX(double min, double max) {xmin = min;xmax = max;}
    public  void setScaleY(double min, double max) {ymin = min; ymax = max;}

    Draw (Map<Integer, Point3D> map, double sLevel){ EarthMap = map; seaLevel = sLevel;}

    public void paintComponent(Graphics graphics){
        height = (int) (width * (ymax - ymin) / (xmax - xmin));
        setScaleX(0, 360);
        setScaleY(-90, 90);

        for(int i = 0; i < 2336041; i++){
            Point3D data = EarthMap.get(i);
            double X = data.getX(), Y = data.getY(), Z = data.getZ();

            if(X > 180){
                X -= 180;
            } else {
                X += 180;
            }

            if (Z < 0 + seaLevel) {
                Color seaColor = new Color(18, 225, 250);
                for(int x = 0; x < Math.abs(data.getZ()) ; x += 50) {
                    seaColor = new Color(Math.max(seaColor.getRed() - 30, 0), Math.max(seaColor.getGreen() - 20,0),seaColor.getBlue() - 1);
                }
                graphics.setColor(seaColor);

            } else if(Z > 50) {
                Color up50Color = new Color(224, 230, 191);
                for(int x = 0; x < Z; x += 400){
                    up50Color = new Color(Math.max(up50Color.getRed() - 20, 0),Math.max(up50Color.getGreen() -20,0),Math.max(up50Color.getBlue() - 20, 0));
                }
                graphics.setColor(up50Color);

            } else if (Z > 0){
                Color groundColor = new Color(236, 255, 253);
                for(int x = 0; x < Z; x += 400){
                    groundColor = new Color(Math.max(groundColor.getRed() - 20, 0), Math.max(groundColor.getGreen() -20,0), Math.max(groundColor.getBlue() - 20, 0));
                }
                graphics.setColor(groundColor);
            }

            graphics.fillOval(this.scaleX(X), this.scaleY(Y), 3, 3);
        }
    }
}

