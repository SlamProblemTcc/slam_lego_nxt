import lejos.nxt.*;
import lejos.robotics.*;
import lejos.robotics.localization.MCLPoseProvider;
import lejos.robotics.mapping.NXTNavigationModel;
import lejos.robotics.navigation.*;

public class RobotSlam extends ConfigDetails{
	
	public static void main(String[] args) throws Exception {
    	
    	DifferentialPilot robot = new DifferentialPilot(5.6, 16.4, Motor.B, Motor.C);
    	robot.setRotateSpeed(ROTATE_SPEED);
    	robot.setTravelSpeed(TRAVEL_SPEED);

    	RangeFinder sonic = new UltrasonicSensor(SensorPort.S1);
    	RangeScanner scanner;

        /*If scanner is disponible.*/
    	if (ROTATING_SONAR){
            /*Set rotating scanner*/
            scanner = new RotatingRangeScanner(MAIN_MOTOR, sonic, GEAR_RATIO);
    	}else{
            /*Set fixed scanner*/
            scanner = new FixedRangeScanner(robot, sonic);  
        }

        scanner.setAngles(ANGLES);

    	/* Map and particles will be sent from the PC.*/
    	MCLPoseProvider mcl = new MCLPoseProvider(robot, scanner, null, 0, BORDER);
    	Navigator navigator = new Navigator(robot, mcl); 	
    	NXTNavigationModel model = new NXTNavigationModel();
    	model.setDebug(true);
    	model.setRandomMoveParameters(MAX_DISTANCE, CLEARANCE);

    	/* Include the navigator to model, with robot and mcl.*/
    	model.addNavigator(navigator);

    	/* Wait to PC require the pose.*/
    	model.setAutoSendPose(false);
	}
}