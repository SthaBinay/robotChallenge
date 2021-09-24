package core;

import core.enums.Direction;
import exception.RobotSimulatorException;

public class Robot {

    private Position currentPosition;
    public Robot() { }
    public Position getCurrentPosition() throws RobotSimulatorException {
        if(null==this.currentPosition){
            throw new RobotSimulatorException("Robot is not active");
        }
        return currentPosition;
    }
    public void setNewPosition(final Position position){
        this.currentPositon = position;
    }
    public void move(final Position nextPosition){
        this.currentPosition = nextPosition;
    }

    public void left() throws RobotSimulatorException {
        if(null== this.currentPosition){
            throw new RobotSimulatorException("core.Robot is not Active!");
        }
        this.currentPosition.setCurrentDirection(Direction.valueOf(this.currentPosition.getCurrentDirection().getLeft()));
    }

    public void right() throws RobotSimulatorException {
        if(null == this.currentPosition){
            throw new RobotSimulatorException("core.Robot is not active!");
        }
        this.currentPosition.setCurrentDirection(Direction.valueOf(this.currentPosition.getCurrentDirection().getRight()));

    }

    public String reportPosition() throws RobotSimulatorException {
        StringBuilder report = new StringBuilder();
        report.append(this.getCurrenPosition().getXAxis())
                .append(",")
                .append(this.getCurrentPosition().getYAxis())
                .append(",")
                .append(this.getCurrentPosition().getCurrentDirection().toString());
        return report.toString();
    }
}
