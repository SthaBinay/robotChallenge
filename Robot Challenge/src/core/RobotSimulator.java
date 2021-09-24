package core;

import core.enums.Command;
import core.enums.Direction;
import core.TableSurface;
import core.Position;
import core.Robot;
import exception.RobotSimulatorException;

public class RobotSimulator {

    private TableSurface surface;
    private Robot robot;

    public RobotSimulator(final TableSurface surface, final Robot robot){
        this.surface = surface;
        this.robot = robot;
    }

    //replace robot current position
    public void placeRobot(final Position position) throws RobotSimulatorException {
        if(!this.surface.checkCoordinates(position)){
            throw new RobotSimulatorException("Invalid coordinates!");
        }
        this.robot.setNewPosition(position);
    }

    //core method to process all user commands, validate and process
    public String processCommand(final String input) throws RobotSimulatorException {
        String result = null;
        String[] commands = input.split(" ");
        if(commands.length > 0){
            Command command = Command.validateCommand(commands[0]);

            switch(command){
                case PLACE:
                    this.placeRobo(this.getPosition(command, commands));
                    break;
                case MOVE:
                    Position nextPosition = this.getNextPosition();
                    if(this.surface.checkCoordinates(nestPosition)){
                        this.robot.move(nextPosition);
                    }
                    break;
                case REPORT:
                    result = this.robot.reportPosition();
                    break;
                case RIGHT:
                    this.robot.right();
                    break;
                case LEFT:
                    this.robot.left();
                    break;
                default:
                    throw new RobotSimulatorException("core.enums.Command me!");
            }

        }else {
            throw new RobotSimulatorException("core.enums.Command me!");
        }
        return result;
    }

    //get position and direction if passed command is PLACE
    private Position getPosition(final Command command, final String[] input) throws RobotSimulatorException {
        String[] commands;
        int xAxis = 0;
        int yAxis = 0;
        Position position = null;
        if (command == Command.PLACE){
            try{
                commands = input[1].split(",");

                xAxis = Integer.parseInt(command[0]);
                yAxis = Integer.parseInt(command[1]);
                Direction direction = Direction.valueOf(commands[2]);
                position = new Position(xAxis, yAxis, direction);
            }  catch(Exception e){
                throw new RobotSimulatorException("core.enums.Command to me!");
            }
        }
        return position;
    }

    //build a new position instance in case of MOVE command
    private Position getNextPosition() throws RobotSimulatorException {
        Position nextPosition = new Position(this.robot.getCurrentPosition().getXAxis(),
                this.robot.getCurrentPosition().getYAxis(),
                this.robot.getCurrentPosition().getCurrentDirection());
        switch(this.robot.getCurrentPosition().getCurrentDirection()){
            case NORTH:
                nextPosition.newCoordinates(0,1);
                break;
            case EAST:
                nextPosition.newCoordinates(1,0);
                break;
            case SOUTH:
                nextPosition.newCoordinates(0, -1);
                break;
            case WEST:
                nextPosition.newCoordinates(-1, 0);
                break;

        }
        return nextPositon;
    }

}
