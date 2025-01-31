package cn.nukkit.event.vehicle;

import cn.nukkit.entity.Entity;
import cn.nukkit.event.HandlerList;
import cn.nukkit.level.Location;
import lombok.Getter;

public class VehicleMoveEvent extends VehicleEvent {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private final Location from;
    private final Location to;

    public VehicleMoveEvent(Entity vehicle, Location from, Location to) {
        super(vehicle);
        this.from = from;
        this.to = to;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }
}
