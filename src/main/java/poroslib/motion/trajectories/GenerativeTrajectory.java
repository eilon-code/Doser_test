/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package poroslib.motion.trajectories;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;

/**
 * Base template class for representing an individual trajectory
 */
public abstract class GenerativeTrajectory {
    protected Trajectory trajectory = null;

    public abstract void generateTrajectory();

    protected abstract TrajectoryConfig getConfiguration();

    public boolean isTrajectoryGenerated() {
        return trajectory != null;
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }
}
