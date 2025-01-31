package cn.nukkit.nbt.tag;

import cn.nukkit.nbt.stream.NBTInputStream;
import cn.nukkit.nbt.stream.NBTOutputStream;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;

public abstract class Tag {
    public static final byte TAG_End = 0;
    public static final byte TAG_Byte = 1;
    public static final byte TAG_Short = 2;
    public static final byte TAG_Int = 3;
    public static final byte TAG_Long = 4;
    public static final byte TAG_Float = 5;
    public static final byte TAG_Double = 6;
    public static final byte TAG_Byte_Array = 7;
    public static final byte TAG_String = 8;
    public static final byte TAG_List = 9;
    public static final byte TAG_Compound = 10;
    public static final byte TAG_Int_Array = 11;

    @Override
    public abstract String toString();

    public abstract String toSNBT();

    public abstract String toSNBT(int space);

    public abstract byte getId();

    protected Tag() {
    }


    public abstract Tag copy();

    public abstract <T> T parseValue();

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tag o)) {
            return false;
        }
        return getId() == o.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static Tag newTag(byte type) {
        return switch (type) {
            case TAG_End -> new EndTag();
            case TAG_Byte -> new ByteTag();
            case TAG_Short -> new ShortTag();
            case TAG_Int -> new IntTag();
            case TAG_Long -> new LongTag();
            case TAG_Float -> new FloatTag();
            case TAG_Double -> new DoubleTag();
            case TAG_Byte_Array -> new ByteArrayTag();
            case TAG_Int_Array -> new IntArrayTag();
            case TAG_String -> new StringTag();
            case TAG_List -> new ListTag<>();
            case TAG_Compound -> new CompoundTag();
            default -> new EndTag();
        };
    }

    public static String getTagName(byte type) {
        return switch (type) {
            case TAG_End -> "TAG_End";
            case TAG_Byte -> "TAG_Byte";
            case TAG_Short -> "TAG_Short";
            case TAG_Int -> "TAG_Int";
            case TAG_Long -> "TAG_Long";
            case TAG_Float -> "TAG_Float";
            case TAG_Double -> "TAG_Double";
            case TAG_Byte_Array -> "TAG_Byte_Array";
            case TAG_Int_Array -> "TAG_Int_Array";
            case TAG_String -> "TAG_String";
            case TAG_List -> "TAG_List";
            case TAG_Compound -> "TAG_Compound";
            default -> "UNKNOWN";
        };
    }
}
