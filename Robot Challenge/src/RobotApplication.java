import core.TableSurface;
import core.Robot;
import core.RobotSimulator;
import exception.RobotSimulatorException;

import java.io.Console;
//main class to kick off robot simulator

import core.TableSurface;

public class RobotApplication {

    public static void main(String[] args) {
        Console console = System.console();

        //handle console unavailability
        if(console == null){
            System.err.println("Console not available!");
            System.exit(0);
        }

        //Instruction
        System.out.println("Welcome to the Robot Challenge");
        System.out.println("My commands are");
        System.out.println("PLACE X,Y,FACING DIRECTION (NORTH/SOUTH/EAST/WEST) ");
        System.out.println("MOVE, LEFT, RIGHT");
        System.out.println("REPORT: to get current location");
        System.out.println("QUIT");

        //flag to check if robot is active or not

        boolean isAlive = true;

        //setup table surface with units and create robot simulator

        TableSurface surface = new TableSurface(4,4);
        RobotSimulator simulator = new RobotSimulator(surface, new Robot());

        while(isAlive){
            String command = console.readLine(">>");
            if("QUIT".equalsIgnoreCase(command)){
                isAlive = false;
            } else {
                try {
                    //start processing commands
                    String result = simulator.processCommand(command);
                    if(null != result){
                        System.out.println("Output: "+ result);
                    }
                }catch (RobotSimulatorException e){
                    //catch all thrown exception and display message to console
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
