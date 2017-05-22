import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;

public class ConfigDetails {
	/*Configuring possible rotating range scanner*/
	protected static final int GEAR_RATIO = -12;
	protected static final boolean ROTATING_SONAR = false;
	protected static final RegulatedMotor MAIN_MOTOR = Motor.A;

    /*Define angles to search references (-45º, 0 and 45º)*/
	protected static final float[] ANGLES = {-45f,0f,45f};
    /*Define border of the pose*/
	protected static final int BORDER = 0;

    /*Configuring move of the robot*/
	protected static final double ROTATE_SPEED = 100f;
	protected static final double TRAVEL_SPEED = 100f;

    /*Set details of random move*/
	protected static final float MAX_DISTANCE = 40f;
	protected static final float CLEARANCE = 20f;
}
