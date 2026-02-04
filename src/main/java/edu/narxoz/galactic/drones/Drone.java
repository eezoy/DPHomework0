package edu.narxoz.galactic.drones;

public abstract class Drone implements FabricDrone {
    private String id;
    private DroneStatus status;
    private double maxPayloadKg;
    private double speed;

    protected Drone(String id, double maxPayloadKg) {
        this.id = id;
        this.maxPayloadKg = maxPayloadKg;
        this.status = DroneStatus.IDLE;

        if (maxPayloadKg <= 0) {
            throw new IllegalArgumentException("Max payload is incorrect");
        }
    }

    public String getId() {
        return id;
    }

    public DroneStatus getStatus() {
        return status;
    }

    public double getMaxPayloadKg() {
        return maxPayloadKg;
    }

    public double getSpeedKmPerMin() {
        return speed;
    }

    @Override
    public void setSpeedKmPerMin(double speed) {
        this.speed = speed;
    }

    public void setStatus(DroneStatus status) {
        this.status = status;
    }
}