package core;

import core.enums.Direction;
import exception.RobotSimulatorException;

public class Position {


        private int xAxis;
        private int yAxis;

        private Direction currentDirection;

        public Position(final int xAxis, final int yAxis, final Direction currentDirection){
            this.currentDirection = currentDirection;
            this.xAxis = xAxis;
            this.yAxis = yAxis;
        }

        public int getXAxis(){
            return xAxis;
        }

        public int getYAxis(){
            return yAxis;
        }

        public Direction getCurrentDirection() throws RobotSimulatorException {
            if(null == this.currentDirction){
                throw new RobotSimulatorException("Robot is not active!");

            }
            return currentDirection;
        }
        public void setCurrentDirection(Direction currentDirection){
            this.currentDirection = currentDirection;
        }

        public void newCoordinates(final int x, final int y){
            this.xAxis += x;
            this.yAxis += y;
        }

}
