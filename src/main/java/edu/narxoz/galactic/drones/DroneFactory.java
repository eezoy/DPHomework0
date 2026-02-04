package edu.narxoz.galactic.drones;

public abstract class DroneFactory {
    public static Drone create(DroneType type, String id, double maxPayloadKg) {
        switch (type) {
            case LIGHT: return new LightDrone(id, maxPayloadKg);
            case HEAVY: return new HeavyDrone(id, maxPayloadKg);
            default: throw new IllegalArgumentException("Unsupported drone type: " + type);
        }
    }
}