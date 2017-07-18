package org.usfirst.frc.team4206.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Vision extends Subsystem {

	NetworkTable table;
	
	public void init() {
		table = NetworkTable.getTable("GRIP/myContoursReport");
	}

	public double getErr() {
		double X = 240;
		
		try {
			X = (table.getNumberArray("centerX", new double[] {240,240})[0]
			   + table.getNumberArray("centerX", new double[] {240,240})[1]) /2; 
		} catch (ArrayIndexOutOfBoundsException e) {
			return X - 240;
		}
		
		return X - 240;
	}
	
    public void initDefaultCommand() {

    }
}

