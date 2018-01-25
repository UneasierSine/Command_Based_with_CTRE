// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc0.MyRobot;

import org.usfirst.frc0.MyRobot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc0.MyRobot.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused")
public class OI {

	Joystick joystick = new Joystick(1);
	XboxController gamePad = new XboxController(0);

    public OI() {        	
          double LStickY = gamePad.getY(GenericHID.Hand.kLeft);
          double RStickX = gamePad.getX(GenericHID.Hand.kRight);
          boolean LBump = gamePad.getBumper(GenericHID.Hand.kLeft);
          boolean RBump = gamePad.getBumper(GenericHID.Hand.kRight);
          double JoyY = joystick.getY();
          boolean joyTrig = joystick.getTrigger();
          boolean pressed = true;
          boolean released = false;
        	
          new JoystickButton(joystick, 3).whenPressed(new climb());
          if(LStickY != 0 && SmartDashboard.getString("Permission", "Yes") == "Yes") new arcadeDrive(LStickY, RStickX);
          if(RBump == true) new slider(1);
          if(LBump == true) new slider(-1);
          if(JoyY != 0) new liftUpDown(JoyY);  
          if(joyTrig == pressed) new clawClose();
          if(joyTrig == released) new clawOpen();
    }

    public Joystick getjoystick() {
        return joystick;
    }


    
}

