package cn.nukkit.network.protocol;

import lombok.ToString;

/**
 * @author MagicDroidX (Nukkit Project)
 */
@ToString
public class BlockEventPacket extends DataPacket {
    public static final int NETWORK_ID = ProtocolInfo.BLOCK_EVENT_PACKET;

    @Override
    public int pid() {
        return NETWORK_ID;
    }

    public int x;
    public int y;
    public int z;
    public int case1;
    public int case2;

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putBlockVector3(this.x, this.y, this.z);
        this.putVarInt(this.case1);
        this.putVarInt(this.case2);
    }
}
