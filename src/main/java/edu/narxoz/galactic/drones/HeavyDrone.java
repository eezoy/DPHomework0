package edu.narxoz.galactic.drones;

public class HeavyDrone extends Drone {
    public HeavyDrone(String id, double maxPayloadKg) {
        super(id, maxPayloadKg);
    }

    @Override
    public void setSpeedKmPerMin(double speed) {
        super.setSpeedKmPerMin(speed);
    }
}