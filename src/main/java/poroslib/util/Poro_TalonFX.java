package poroslib.util;

import java.util.function.Consumer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//If at some point in the future, want to move to hash style, add properties 
//necessary to create a trajectory and add a generate method with hash option 
public class Poro_TalonFX extends WPI_TalonFX 
{
    public enum SpeedControllerSetType {
        PercentOutput,
        Velocity
    }
    
    private SpeedControllerSetType setType = SpeedControllerSetType.PercentOutput;
    private Mapper<Double> speedControllerMapper;

    public Poro_TalonFX(int deviceNumber) {
        super(deviceNumber);
    }

    public void setSetType(SpeedControllerSetType setType) {
        this.setType = setType;
    }

    public void setMapper(Mapper<Double> speedControllerMapper) {
        this.speedControllerMapper = speedControllerMapper;
    }

    @Override
    public void set(double speed) {
        if(speedControllerMapper != null) {
            System.out.println("mapping");
            speed = speedControllerMapper.map(speed);
        }
        if(setType == SpeedControllerSetType.Velocity) {
            // set(ControlMode.Velocity, speed);
        }
        else {
            super.set(speed);
        }

    }
    
}