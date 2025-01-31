package cn.nukkit.network.protocol;

import cn.nukkit.registry.Registries;
import lombok.ToString;

@ToString
public class BiomeDefinitionListPacket extends DataPacket {
    public static final int NETWORK_ID = ProtocolInfo.BIOME_DEFINITION_LIST_PACKET;

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
        this.put(Registries.BIOME.getBiomeDefinitionListPacketData());
    }
}
