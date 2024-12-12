package spdvi.comparelists;

/**
 *
 * @author Miquel Oscar
 */
public class ColouredShape {
    private Shape shape;
    private ShapeColor color;
    
    public ColouredShape(Shape shape, ShapeColor color) {
        this.shape = shape;
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public ShapeColor getColor() {
        return color;
    }

    public void setColor(ShapeColor color) {
        this.color = color;
    }
}
