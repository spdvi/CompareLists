/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package spdvi.comparelists;

import java.util.ArrayList;

/**
 *
 * @author Miquel Oscar
 */
public class CompareLists {

    public static void main(String[] args) {
        ArrayList<ColouredShape> colouredShapes1 = new ArrayList<>();
        ArrayList<ColouredShape> colouredShapes2 = new ArrayList<>();

        InitColouredShapes1(colouredShapes1);
        InitColouredShapes2(colouredShapes2);

        CompareLists(colouredShapes1, colouredShapes2);
    }

    private static void InitColouredShapes1(ArrayList<ColouredShape> shapes) {
        shapes.add(new ColouredShape(Shape.CIRCLE, ShapeColor.GREEN));
        shapes.add(new ColouredShape(Shape.RECTANGLE, ShapeColor.BLACK));
        shapes.add(new ColouredShape(Shape.TRIANGLE, ShapeColor.BLUE));
        shapes.add(new ColouredShape(Shape.SQUARE, ShapeColor.WHITE));
    }

    private static void InitColouredShapes2(ArrayList<ColouredShape> shapes) {
        shapes.add(new ColouredShape(Shape.CIRCLE, ShapeColor.GREEN));
        shapes.add(new ColouredShape(Shape.RECTANGLE, ShapeColor.BLACK));
        shapes.add(new ColouredShape(Shape.TRIANGLE, ShapeColor.BLUE));
        shapes.add(new ColouredShape(Shape.SQUARE, ShapeColor.WHITE));
    }

    private static void CompareLists(ArrayList<ColouredShape> shapes1, ArrayList<ColouredShape> shapes2) {
        if(shapes1.size() != shapes2.size()) {
            System.out.println("Les llistes son diferents");
        }
        
        ArrayList<ColouredShape> diff = new ArrayList<>();
        for(ColouredShape shapeInList1: shapes1) {
            for(ColouredShape shapeInList2: shapes2) {
                if ((shapeInList1.getShape() == shapeInList2.getShape()) && (shapeInList1.getColor() == shapeInList2.getColor())) {
                    //
                }
                else {
                    // Hi ha al menys un element diferent a les dues llistes
                    diff.add(shapeInList2);
                }
            }
        }

        if (diff.size() > 0) {
            System.out.println("Les llistes son diferents. Els seguents elements de la segona llista no hi son a la primera llista: ");
            for(ColouredShape cs: diff) {
                System.out.println("Shape: " + cs.getShape() + " Colour: " + cs.getColor());
            }
        } 
        else {
            System.out.println("Les llistes contenen els mateixos objectes");
        }
        
    }
}
