package core.enums;
import exception.RobotSimulatorException;

public enum Command {
    PLACE,
    MOVE,
    RIGHT,
    LEFT,
    REPORT,
    QUIT;

    public static Command validateCommand(final String command) throws RobotSimulatorException {
        try {
            return Command.valueOf(command);
        } catch(IllegalArgmentException e){
            throw new RobotSimulatorException("core.enums.Command me!");
        }
    }
}
