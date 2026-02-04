package edu.narxoz.galactic.drones;

public class LightDrone extends Drone {
    public LightDrone(String id, double maxPayloadKg) {
        super(id, maxPayloadKg);
    }

    @Override
    public void setSpeedKmPerMin(double speed) {
        super.setSpeedKmPerMin(speed);
    }
}