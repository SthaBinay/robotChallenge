package exception;

public class RobotSimulatorException extends Throwable {
    //core.Robot simulation process exception

    public class RobotSimulatorException extends Exception {
        public RobotSimulatorException(final String message){
            super(message);
        }
    }
}
