/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package poroslib.motion.trajectories;

import java.util.HashMap;

import edu.wpi.first.wpilibj.trajectory.Trajectory;

/**
 * Add your docs here.
 */
public class TrajectoryStore {
    private final HashMap<String, GenerativeTrajectory> trajectoryMap = new HashMap<>();

    public void addTrajectory(String name, GenerativeTrajectory generativeTrajectory) {
        trajectoryMap.put(name, generativeTrajectory);
    }

    public Trajectory getTrajectory(String name) {
        GenerativeTrajectory generativeTrajectory = trajectoryMap.get(name);
        generativeTrajectory.generateTrajectory();
        return generativeTrajectory.getTrajectory();
    }

    public void generateTrajectories() {
        for (GenerativeTrajectory generativeTrajectory : trajectoryMap.values()) {
            generativeTrajectory.generateTrajectory();
        }
    }
}
