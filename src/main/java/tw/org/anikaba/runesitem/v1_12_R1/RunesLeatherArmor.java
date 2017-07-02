package tw.org.anikaba.runesitem.v1_12_R1;

import java.util.Map;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.DelegateDeserialization;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.google.common.collect.ImmutableMap.Builder;

@DelegateDeserialization(RunesMeta.SerializableMeta.class)
public class RunesLeatherArmor extends RunesMeta implements LeatherArmorMeta {

    static final ItemMetaKey COLOR = new ItemMetaKey("color");

    private Color color = Color.fromRGB(0xA06540);

    RunesLeatherArmor(RunesMeta meta) {
        super(meta);
        if (!(meta instanceof RunesLeatherArmor)) {
            return;
        }

        RunesLeatherArmor armorMeta = (RunesLeatherArmor) meta;
        this.color = armorMeta.color;
    }

    RunesLeatherArmor(NBTTagCompound tag) {
        super(tag);
        if (tag.hasKey(DISPLAY.NBT)) {
            NBTTagCompound display = tag.getCompound(DISPLAY.NBT);
            if (display.hasKey(COLOR.NBT)) {
                color = Color.fromRGB(display.getInt(COLOR.NBT));
            }
        }
    }

    RunesLeatherArmor(Map<String, Object> map) {
        super(map);
        setColor(SerializableMeta.getObject(Color.class, map, COLOR.BUKKIT, true));
    }

    @Override
    void applyToItem(NBTTagCompound itemTag) {
        super.applyToItem(itemTag);

        if (hasColor()) {
            setDisplayTag(itemTag, COLOR.NBT, new NBTTagInt(color.asRGB()));
        }
    }

    @Override
    boolean isEmpty() {
        return super.isEmpty() && isLeatherArmorEmpty();
    }

    boolean isLeatherArmorEmpty() {
        return !(hasColor());
    }

    @Override
    boolean applicableTo(Material type) {
        switch(type) {
            case LEATHER_HELMET:
            case LEATHER_CHESTPLATE:
            case LEATHER_LEGGINGS:
            case LEATHER_BOOTS:
                return true;
            default:
                return false;
        }
    }

    @Override
    public RunesLeatherArmor clone() {
        return (RunesLeatherArmor) super.clone();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color == null ? Color.fromRGB(0xA06540) : color;
    }

    boolean hasColor() {
        return !Color.fromRGB(0xA06540).equals(color);
    }

    @Override
    Builder<String, Object> serialize(Builder<String, Object> builder) {
        super.serialize(builder);

        if (hasColor()) {
            builder.put(COLOR.BUKKIT, color);
        }

        return builder;
    }

    @Override
    boolean equalsCommon(RunesMeta meta) {
        if (!super.equalsCommon(meta)) {
            return false;
        }
        if (meta instanceof RunesLeatherArmor) {
            RunesLeatherArmor that = (RunesLeatherArmor) meta;

            return color.equals(that.color);
        }
        return true;
    }

    @Override
    boolean notUncommon(RunesMeta meta) {
        return super.notUncommon(meta) && (meta instanceof RunesLeatherArmor || isLeatherArmorEmpty());
    }

    @Override
    int applyHash() {
        final int original;
        int hash = original = super.applyHash();
        if (hasColor()) {
            hash ^= color.hashCode();
        }
        return original != hash ? RunesSkull.class.hashCode() ^ hash : hash;
    }
}
