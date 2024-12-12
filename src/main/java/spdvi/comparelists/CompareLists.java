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

    private static void CompareIntern(ArrayList<ColouredShape> shapesListWithMoreElements, ArrayList<ColouredShape> shapesListWithLessElements) {
        ArrayList<ColouredShape> diff = new ArrayList<>();
        for (ColouredShape shapeInList1 : shapesListWithMoreElements) {
            ColouredShape shapeInList2 = null;
            boolean shapeIsInList2 = false;
            for (int i = 0; i < shapesListWithLessElements.size(); i++) {
                shapeInList2 = shapesListWithLessElements.get(i);
                if ((shapeInList1.getShape() == shapeInList2.getShape()) && (shapeInList1.getColor() == shapeInList2.getColor())) {
                    // shapeInList1 Exists in List2
                    shapeIsInList2 = true;
                    //Aquí ja podriem fer un break;
                }
            }
            if (!shapeIsInList2) {
                // Hi ha al menys un element diferent a les dues llistes
                diff.add(shapeInList1);
            }
        }

        if (diff.size() > 0) {
            System.out.println("Les llistes son diferents. Els seguents elements de la llista amb més elements no hi son a la llista amb menys elements: ");
            for (ColouredShape cs : diff) {
                System.out.println("Shape: " + cs.getShape() + " Colour: " + cs.getColor());
            }
        } else {
            System.out.println("Les llistes contenen els mateixos objectes");
        }
    }

    private static void CompareLists(ArrayList<ColouredShape> shapes1, ArrayList<ColouredShape> shapes2) {
//        if (shapes1.size() != shapes2.size()) {
//            System.out.println("Les llistes son diferents");
//        }

        if (shapes1.size() > shapes2.size()) {
            // A la primera llista hi ha més elements que a la segona.
            // És a dir, s'han eliminat elements
            CompareIntern(shapes1, shapes2);
        } else if (shapes1.size() < shapes2.size()) {
            // A la segona llista hi ha més elements que a la primera.
            // Es a dir, s'ha afegit algún element
            CompareIntern(shapes2, shapes1);
        } else {
            System.out.println("Les llistes contenen els mateixos objectes");

            // Les dues llistes ténen el mateix número d'elements.
            // Però, són els mateixos?
//            System.out.println("Les llistes contenen el mateix número d'elements."
//                    + " Hauriem de comprovar si son els mateixos i,"
//                    + " cas que no ho fossin, averiguar quins elements diferixen.");
//            System.out.println("Al context al que esteim, per sincronitzar les dues llistes, "
//                    + "s'haurien d'afegir els elements que hi han a la llista 2"
//                    + " a la llista 1, i eliminar de la llista 1 els elements "
//                    + "de la llista 1 que no hi son a la llista 2.");
        }

    }

    private static void InitColouredShapes1(ArrayList<ColouredShape> shapes) {
        shapes.add(new ColouredShape(Shape.CIRCLE, ShapeColor.GREEN));
        shapes.add(new ColouredShape(Shape.RECTANGLE, ShapeColor.RED));
    }

    private static void InitColouredShapes2(ArrayList<ColouredShape> shapes) {
        shapes.add(new ColouredShape(Shape.RECTANGLE, ShapeColor.RED));
        shapes.add(new ColouredShape(Shape.CIRCLE, ShapeColor.GREEN));
        shapes.add(new ColouredShape(Shape.TRIANGLE, ShapeColor.BLUE));
    }
}
