package cn.nukkit.network.protocol;

import cn.nukkit.math.Vector3f;
import lombok.ToString;

import java.util.Optional;

@ToString
public class SpawnParticleEffectPacket extends DataPacket {
    public static final int NETWORK_ID = ProtocolInfo.SPAWN_PARTICLE_EFFECT_PACKET;

    public int dimensionId;
    public long uniqueEntityId = -1;
    public Vector3f position;
    public String identifier;
    /**
     * @since v503
     */
    public Optional<String> molangVariablesJson = Optional.empty();

    @Override
    public int pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
    }

    @Override
    public void encode() {
        this.reset();
        this.putByte((byte) this.dimensionId);
        this.putEntityUniqueId(uniqueEntityId);
        this.putVector3f(this.position);
        this.putString(this.identifier);
        this.putBoolean(molangVariablesJson.isPresent());
        molangVariablesJson.ifPresent(this::putString);
    }
}
