/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package poroslib.motion.trajectories;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;

/**
 * Template class for representing an individual trajectory
 * Generates a trajectory using quintic hermite splines, which require absolute field coordinates.
 */
public abstract class QuinticTrajectory extends GenerativeTrajectory {

    @Override
    public void generateTrajectory() {
        if (!isTrajectoryGenerated()) {
            ArrayList<Pose2d> waypoints = getWaypoints();
            TrajectoryConfig config = getConfiguration();

            trajectory = TrajectoryGenerator.generateTrajectory(waypoints, config);
            System.out.println("total traj time" + trajectory.getTotalTimeSeconds());
        }
    }

    protected abstract ArrayList<Pose2d> getWaypoints();
}
