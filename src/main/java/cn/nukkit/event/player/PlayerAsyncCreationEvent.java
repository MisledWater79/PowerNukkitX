package cn.nukkit.event.player;

import cn.nukkit.Player;
import cn.nukkit.event.Event;
import cn.nukkit.event.HandlerList;
import cn.nukkit.network.SourceInterface;

import java.net.InetSocketAddress;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class PlayerAsyncCreationEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private final SourceInterface interfaz;
    private final InetSocketAddress socketAddress;
    private Class<? extends Player> baseClass;
    private Class<? extends Player> playerClass;

    public PlayerAsyncCreationEvent(SourceInterface interfaz, Class<? extends Player> baseClass, Class<? extends Player> playerClass, InetSocketAddress socketAddress) {
        this.interfaz = interfaz;
        this.socketAddress = socketAddress;

        this.baseClass = baseClass;
        this.playerClass = playerClass;
    }

    public SourceInterface getInterface() {
        return interfaz;
    }

    public String getAddress() {
        return this.socketAddress.getAddress().toString();
    }

    public int getPort() {
        return this.socketAddress.getPort();
    }

    public InetSocketAddress getSocketAddress() {
        return socketAddress;
    }

    public Class<? extends Player> getBaseClass() {
        return baseClass;
    }

    public void setBaseClass(Class<? extends Player> baseClass) {
        this.baseClass = baseClass;
    }

    public Class<? extends Player> getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(Class<? extends Player> playerClass) {
        this.playerClass = playerClass;
    }
}
