package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // TODO: Calculate the perimeter.
        if (myPolygon.size() < 2) {
            return 0.0;
        }

        double totalPerimeter = 0.0;

        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            // Connects the last point back to the first point using modulo
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());
            totalPerimeter += current.distance(next);
        }

        return totalPerimeter;
    }

    public double area() {
        // TODO: Calculate the area.
        Double area = 0.0;
        return area;
    }

    public void draw() {
    try {
        if (myPolygon.size() < 2) return;

        DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
        Point2D.Double first = myPolygon.get(0);

        myDrawingTool.up();
        myDrawingTool.move(first.getX(), first.getY());
        myDrawingTool.down();

        for (int i = 1; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            myDrawingTool.move(current.getX(), current.getY());
        }

        myDrawingTool.move(first.getX(), first.getY());
    } catch (java.awt.HeadlessException e) {
    }
}
}