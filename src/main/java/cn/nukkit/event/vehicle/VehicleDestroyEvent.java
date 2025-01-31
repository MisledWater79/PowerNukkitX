package cn.nukkit.event.vehicle;

import cn.nukkit.entity.Entity;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import lombok.Getter;

/**
 * Is called when an vehicle gets destroyed
 */
public class VehicleDestroyEvent extends VehicleEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Constructor for the VehicleDestroyEvent
     *
     * @param vehicle the destroyed vehicle
     */
    public VehicleDestroyEvent(final Entity vehicle) {
        super(vehicle);
    }

}
