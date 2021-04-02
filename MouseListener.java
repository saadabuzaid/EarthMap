package Assignment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import static Assignment.Main2D.MapCoordinates;
public class MouseListener extends MouseAdapter {


    Draw draw;

    MouseListener(Draw d){
        draw = d;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            MapCoordinates.add(new MapCoordinate(draw.getX(e.getX()),draw.getY(e.getY()),0));
            System.out.printf("Clicked coordinate X:%d , Y:%d \n", e.getX(), e.getY());
            if(MapCoordinates.size() > 1){
                MapCoordinate coord1, coord2;
                coord1 = MapCoordinates.get(MapCoordinates.size() - 1);
                coord2 = MapCoordinates.get(MapCoordinates.size() - 2);
                System.out.printf("Distance between %s and %s is %.3f km \n", coord1.toString(), coord2.toString(), coord1.distanceTo(coord2));
                //MapCoordinates.sort();
                // save
                try {
                    FileWriter file = new FileWriter("src/Assignment/NewCoordinates.txt");
                    for(MapCoordinate coord : MapCoordinates){
                        file.write(coord.toString() + " \n");
                    }
                    file.close();
                    System.out.println("The new coordinates have been saved successfully.");
                } catch (IOException error) { System.out.println("Error while saving new coordinates" + error); }
            }
        } else if(e.getButton() == MouseEvent.BUTTON3){
            if(MapCoordinates.size() != 0) {
                MapCoordinate coord = MapCoordinates.get(MapCoordinates.size() - 1);
                MapCoordinates.remove(MapCoordinates.size() - 1);
                System.out.println("Deleted coordinate is:" + coord.toString());
            }
        }
    }
}