package cn.nukkit.network.protocol;

import lombok.ToString;

@ToString
public class VideoStreamConnectPacket extends DataPacket {

    public static final int NETWORK_ID = ProtocolInfo.VIDEO_STREAM_CONNECT_PACKET;

    public static final byte ACTION_OPEN = 0;
    public static final byte ACTION_CLOSE = 1;

    public String address;
    public float screenshotFrequency;
    public byte action;

    @Override
    public int pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
    }

    @Override
    public void encode() {
        this.putString(address);
        this.putLFloat(screenshotFrequency);
        this.putByte(action);
    }
}
