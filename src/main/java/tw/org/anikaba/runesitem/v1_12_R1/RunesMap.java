package tw.org.anikaba.runesitem.v1_12_R1;

import java.util.Map;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagString;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.DelegateDeserialization;
import org.bukkit.inventory.meta.MapMeta;

import com.google.common.collect.ImmutableMap;

@DelegateDeserialization(RunesMeta.SerializableMeta.class)
public class RunesMap extends RunesMeta implements MapMeta {
    static final ItemMetaKey MAP_SCALING = new ItemMetaKey("map_is_scaling", "scaling");
    static final ItemMetaKey MAP_LOC_NAME = new ItemMetaKey("LocName", "display-loc-name");
    static final ItemMetaKey MAP_COLOR = new ItemMetaKey("MapColor", "display-map-color");
    static final byte SCALING_EMPTY = (byte) 0;
    static final byte SCALING_TRUE = (byte) 1;
    static final byte SCALING_FALSE = (byte) 2;

    private byte scaling = SCALING_EMPTY;
    private String locName;
    private Color color;

    RunesMap(RunesMeta meta) {
        super(meta);

        if (!(meta instanceof RunesMap)) {
            return;
        }

        RunesMap map = (RunesMap) meta;
        this.scaling = map.scaling;
        this.locName = map.locName;
        this.color = map.color;
    }

    RunesMap(NBTTagCompound tag) {
        super(tag);

        if (tag.hasKey(MAP_SCALING.NBT)) {
            this.scaling = tag.getBoolean(MAP_SCALING.NBT) ? SCALING_TRUE : SCALING_FALSE;
        }

        if (tag.hasKey(DISPLAY.NBT)) {
            NBTTagCompound display = tag.getCompound(DISPLAY.NBT);

            if (display.hasKey(MAP_LOC_NAME.NBT)) {
                locName = display.getString(MAP_LOC_NAME.NBT);
            }

            if (display.hasKey(MAP_COLOR.NBT)) {
                color = Color.fromRGB(display.getInt(MAP_COLOR.NBT));
            }
        }
    }

    RunesMap(Map<String, Object> map) {
        super(map);

        Boolean scaling = SerializableMeta.getObject(Boolean.class, map, MAP_SCALING.BUKKIT, true);
        if (scaling != null) {
            setScaling(scaling);
        }

        String locName = SerializableMeta.getString(map, MAP_LOC_NAME.BUKKIT, true);
        if (locName != null) {
            setLocationName(locName);
        }

        Color color = SerializableMeta.getObject(Color.class, map, MAP_COLOR.BUKKIT, true);
        if (color != null) {
            setColor(color);
        }
    }

    @Override
    void applyToItem(NBTTagCompound tag) {
        super.applyToItem(tag);

        if (hasScaling()) {
            tag.setBoolean(MAP_SCALING.NBT, isScaling());
        }

        if (hasLocationName()) {
            setDisplayTag(tag, MAP_LOC_NAME.NBT, new NBTTagString(getLocationName()));
        }

        if (hasColor()) {
            setDisplayTag(tag, MAP_COLOR.NBT, new NBTTagInt(color.asRGB()));
        }
    }

    @Override
    boolean applicableTo(Material type) {
        switch (type) {
            case MAP:
                return true;
            default:
                return false;
        }
    }

    @Override
    boolean isEmpty() {
        return super.isEmpty() && isMapEmpty();
    }

    boolean isMapEmpty() {
        return !(hasScaling() | hasLocationName() || hasColor());
    }

    boolean hasScaling() {
        return scaling != SCALING_EMPTY;
    }

    public boolean isScaling() {
        return scaling == SCALING_TRUE;
    }

    public void setScaling(boolean scaling) {
        this.scaling = scaling ? SCALING_TRUE : SCALING_FALSE;
    }

    @Override
    public boolean hasLocationName() {
        return this.locName != null;
    }

    @Override
    public String getLocationName() {
        return this.locName;
    }

    @Override
    public void setLocationName(String name) {
        this.locName = name;
    }

    @Override
    public boolean hasColor() {
        return this.color != null;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    boolean equalsCommon(RunesMeta meta) {
        if (!super.equalsCommon(meta)) {
            return false;
        }
        if (meta instanceof RunesMap) {
            RunesMap that = (RunesMap) meta;

            return (this.scaling == that.scaling)
                    && (hasLocationName() ? that.hasLocationName() && this.locName.equals(that.locName) : !that.hasLocationName())
                    && (hasColor() ? that.hasColor() && this.color.equals(that.color) : !that.hasColor());
        }
        return true;
    }

    @Override
    boolean notUncommon(RunesMeta meta) {
        return super.notUncommon(meta) && (meta instanceof RunesMap || isMapEmpty());
    }

    @Override
    int applyHash() {
        final int original;
        int hash = original = super.applyHash();

        if (hasScaling()) {
            hash ^= 0x22222222 << (isScaling() ? 1 : -1);
        }
        if (hasLocationName()) {
            hash = 61 * hash + locName.hashCode();
        }
        if (hasColor()) {
            hash = 61 * hash + color.hashCode();
        }

        return original != hash ? RunesMap.class.hashCode() ^ hash : hash;
    }


    public RunesMap clone() {
        return (RunesMap) super.clone();
    }

    @Override
    ImmutableMap.Builder<String, Object> serialize(ImmutableMap.Builder<String, Object> builder) {
        super.serialize(builder);

        if (hasScaling()) {
            builder.put(MAP_SCALING.BUKKIT, isScaling());
        }

        if (hasLocationName()) {
            builder.put(MAP_LOC_NAME.BUKKIT, getLocationName());
        }

        if (hasColor()) {
            builder.put(MAP_COLOR.BUKKIT, getColor());
        }

        return builder;
    }
}
