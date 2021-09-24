package core;

import core.Position;

public class TableSurface {
    //x-axis of the table
    private int width;

    //y-axis of the table
    private int height;

    public TableSurface(final int width, final int height){
        this.width = width;
        this.height = height;
    }

    public boolean checkCoordinates(final Position position){
        return (position.getXAxis() <= this.width && position.getXAxis()>= 0)
                && (position.getYAxis() <= this.height && position.getYAxis() >= 0);

    }

}
