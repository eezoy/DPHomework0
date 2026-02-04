package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.DroneFactory;
import edu.narxoz.galactic.drones.DroneType;
import edu.narxoz.galactic.task.*;
import edu.narxoz.galactic.dispatcher.*;

public class Main {
    public static void main(String[] args) {
        Planet pandora = new Planet("Pandora", 9460800, 12614400, "Toxic");
        SpaceStation ISV = new SpaceStation("Venture Star", 0, 0, 5);
        Cargo cargo = new Cargo(500, "Unobtanium");
        Drone lightDrone = DroneFactory.create(DroneType.LIGHT, "SA-2 «Samson»", 250);
        Drone heavyDrone = DroneFactory.create(DroneType.HEAVY, "C-21 «Dragon»", 1250);
        lightDrone.setSpeedKmPerMin(10.0);
        heavyDrone.setSpeedKmPerMin(5.0);
        DeliveryTask task = new DeliveryTask(ISV, pandora, cargo);
        Dispatcher dispatcher = new Dispatcher();

        Result r1 = dispatcher.assignTask(task, lightDrone);
        System.out.println("Step 1 (LightDrone): Result = " + r1.ok() + ", Reason = " + r1.reason());

        Result r2 = dispatcher.assignTask(task, heavyDrone);
        System.out.println("Step 2 (HeavyDrone): Result = " + r2.ok() + ", Drone = " + heavyDrone.getStatus() + ", Task = " + task.getState());

        System.out.println("Step 3 (Estimation): Time = " + task.estimateTime());

        Result r3 = dispatcher.completeTask(task);
        System.out.println("Step 4 (Result): Result = " + r3.ok() + ", Drone = " + heavyDrone.getStatus() + ", Task = " + task.getState());
    }
}