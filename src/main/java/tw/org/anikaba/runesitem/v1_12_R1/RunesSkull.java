package tw.org.anikaba.runesitem.v1_12_R1;

import java.util.Map;

import net.minecraft.server.v1_12_R1.GameProfileSerializer;
import net.minecraft.server.v1_12_R1.NBTBase;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.TileEntitySkull;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.DelegateDeserialization;

import com.google.common.collect.ImmutableMap.Builder;
import com.mojang.authlib.GameProfile;
import org.bukkit.craftbukkit.v1_12_R1.util.CraftMagicNumbers;
import org.bukkit.inventory.meta.SkullMeta;

@DelegateDeserialization(RunesMeta.SerializableMeta.class)
public class RunesSkull extends RunesMeta implements SkullMeta {

    @ItemMetaKey.Specific(ItemMetaKey.Specific.To.NBT)
    static final ItemMetaKey SKULL_PROFILE = new ItemMetaKey("SkullProfile");

    static final ItemMetaKey SKULL_OWNER = new ItemMetaKey("SkullOwner", "skull-owner");
    static final int MAX_OWNER_LENGTH = 16;

    private GameProfile profile;

    RunesSkull(RunesMeta meta) {
        super(meta);
        if (!(meta instanceof RunesSkull)) {
            return;
        }
        RunesSkull skullMeta = (RunesSkull) meta;
        this.profile = skullMeta.profile;
    }

    RunesSkull(NBTTagCompound tag) {
        super(tag);

        if (tag.hasKeyOfType(SKULL_OWNER.NBT, CraftMagicNumbers.NBT.TAG_COMPOUND)) {
            profile = GameProfileSerializer.deserialize(tag.getCompound(SKULL_OWNER.NBT));
        } else if (tag.hasKeyOfType(SKULL_OWNER.NBT, CraftMagicNumbers.NBT.TAG_STRING) && !tag.getString(SKULL_OWNER.NBT).isEmpty()) {
            profile = new GameProfile(null, tag.getString(SKULL_OWNER.NBT));
        }
    }

    RunesSkull(Map<String, Object> map) {
        super(map);
        if (profile == null) {
            setOwner(SerializableMeta.getString(map, SKULL_OWNER.BUKKIT, true));
        }
    }

    @Override
    void deserializeInternal(NBTTagCompound tag) {
        if (tag.hasKeyOfType(SKULL_PROFILE.NBT, CraftMagicNumbers.NBT.TAG_COMPOUND)) {
            profile = GameProfileSerializer.deserialize(tag.getCompound(SKULL_PROFILE.NBT));
        }
    }

    @Override
    void serializeInternal(final Map<String, NBTBase> internalTags) {
        if (profile != null) {
            NBTTagCompound nbtData = new NBTTagCompound();
            GameProfileSerializer.serialize(nbtData, profile);
            internalTags.put(SKULL_PROFILE.NBT, nbtData);
        }
    }

    @Override
    void applyToItem(final NBTTagCompound tag) { // Spigot - make final
        super.applyToItem(tag);

        if (profile != null) {
            NBTTagCompound owner = new NBTTagCompound();
            GameProfileSerializer.serialize(owner, profile);
            tag.set( SKULL_OWNER.NBT, owner );
            // Spigot start - do an async lookup of the profile.
            // Unfortunately there is not way to refresh the holding
            // inventory, so that responsibility is left to the user.
            net.minecraft.server.v1_12_R1.TileEntitySkull.b(profile, new com.google.common.base.Predicate<GameProfile>() {

                @Override
                public boolean apply(GameProfile input) {
                    NBTTagCompound owner = new NBTTagCompound();
                    GameProfileSerializer.serialize( owner, input );
                    tag.set( SKULL_OWNER.NBT, owner );
                    return false;
                }
            });
            // Spigot end
        }
    }

    @Override
    boolean isEmpty() {
        return super.isEmpty() && isSkullEmpty();
    }

    boolean isSkullEmpty() {
        return profile == null;
    }

    @Override
    boolean applicableTo(Material type) {
        switch(type) {
            case SKULL_ITEM:
                return true;
            default:
                return false;
        }
    }

    @Override
    public RunesSkull clone() {
        return (RunesSkull) super.clone();
    }

    public boolean hasOwner() {
        return profile != null && profile.getName() != null;
    }

    public String getOwner() {
        return hasOwner() ? profile.getName() : null;
    }

    public boolean setOwner(String name) {
        if (name != null && name.length() > MAX_OWNER_LENGTH) {
            return false;
        }

        if (name == null) {
            profile = null;
        } else {
            // Spigot start
            profile = TileEntitySkull.skinCache.getIfPresent(name.toLowerCase(java.util.Locale.ROOT));
            if (profile == null) profile = new GameProfile(null, name);
            // Spigot end
        }

        return true;
    }

    @Override
    int applyHash() {
        final int original;
        int hash = original = super.applyHash();
        if (hasOwner()) {
            hash = 61 * hash + profile.hashCode();
        }
        return original != hash ? RunesSkull.class.hashCode() ^ hash : hash;
    }

    @Override
    boolean equalsCommon(RunesMeta meta) {
        if (!super.equalsCommon(meta)) {
            return false;
        }
        if (meta instanceof RunesSkull) {
            RunesSkull that = (RunesSkull) meta;

            return (this.hasOwner() ? that.hasOwner() && this.profile.equals(that.profile) : !that.hasOwner());
        }
        return true;
    }

    @Override
    boolean notUncommon(RunesMeta meta) {
        return super.notUncommon(meta) && (meta instanceof RunesSkull || isSkullEmpty());
    }

    @Override
    Builder<String, Object> serialize(Builder<String, Object> builder) {
        super.serialize(builder);
        if (hasOwner()) {
            return builder.put(SKULL_OWNER.BUKKIT, this.profile.getName());
        }
        return builder;
    }
}