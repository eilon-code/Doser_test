/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package poroslib.motion.trajectories;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;

/**
 * Template class for representing an individual trajectory
 * Generates a trajectory using clamped cubic splines, which require a start pose, 
 * pose relative coordinates and an end pose.
 */
public abstract class CubicTrajectory extends GenerativeTrajectory {

    @Override
    public void generateTrajectory() {
        if (!isTrajectoryGenerated()) {
            Pose2d start = getStartPoint();
            ArrayList<Translation2d> waypoints = getWaypoints();
            Pose2d end = getEndPoint();
            TrajectoryConfig config = getConfiguration();

            trajectory = TrajectoryGenerator.generateTrajectory(start, waypoints, end, config);
        }
    }

    protected abstract Pose2d getStartPoint();

    protected abstract ArrayList<Translation2d> getWaypoints();

    protected abstract Pose2d getEndPoint();
}
