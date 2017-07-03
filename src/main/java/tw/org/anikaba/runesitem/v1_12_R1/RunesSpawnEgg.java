package tw.org.anikaba.runesitem.v1_12_R1;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

import net.minecraft.server.v1_12_R1.DataConverterTypes;
import net.minecraft.server.v1_12_R1.MinecraftKey;
import net.minecraft.server.v1_12_R1.MinecraftServer;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.DelegateDeserialization;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.meta.SpawnEggMeta;

@DelegateDeserialization(RunesMeta.SerializableMeta.class)
public class RunesSpawnEgg extends RunesMeta implements SpawnEggMeta {

    static final ItemMetaKey ENTITY_TAG = new ItemMetaKey("EntityTag", "entity-tag");
    @ItemMetaKey.Specific(ItemMetaKey.Specific.To.NBT)
    static final ItemMetaKey ENTITY_ID = new ItemMetaKey("id");

    private EntityType spawnedType;
    private NBTTagCompound entityTag;

    RunesSpawnEgg(RunesMeta meta) {
        super(meta);

        if (!(meta instanceof RunesSpawnEgg)) {
            return;
        }

        RunesSpawnEgg egg = (RunesSpawnEgg) meta;
        this.spawnedType = egg.spawnedType;
    }

    RunesSpawnEgg(NBTTagCompound tag) {
        super(tag);

        if (tag.hasKey(ENTITY_TAG.NBT)) {
            entityTag = tag.getCompound(ENTITY_TAG.NBT);

            if (entityTag.hasKey(ENTITY_ID.NBT)) {
                this.spawnedType = EntityType.fromName(new MinecraftKey(entityTag.getString(ENTITY_ID.NBT)).getKey());
            }
        }
    }

    RunesSpawnEgg(Map<String, Object> map) {
        super(map);

        String entityType = SerializableMeta.getString(map, ENTITY_ID.BUKKIT, true);
        setSpawnedType(EntityType.fromName(entityType));
    }

    @Override
    void deserializeInternal(NBTTagCompound tag) {
        super.deserializeInternal(tag);

        if (tag.hasKey(ENTITY_TAG.NBT)) {
            entityTag = tag.getCompound(ENTITY_TAG.NBT);
            MinecraftServer.getServer().dataConverterManager.a(DataConverterTypes.ENTITY, entityTag); // PAIL: convert

            if (entityTag.hasKey(ENTITY_ID.NBT)) {
                this.spawnedType = EntityType.fromName(new MinecraftKey(entityTag.getString(ENTITY_ID.NBT)).getKey());
            }
        }
    }

    @Override
    void applyToItem(NBTTagCompound tag) {
        super.applyToItem(tag);

        if (!isSpawnEggEmpty() && entityTag == null) {
            entityTag = new NBTTagCompound();
        }

        if (hasSpawnedType()) {
            entityTag.setString(ENTITY_ID.NBT, new MinecraftKey(spawnedType.getName()).toString());
        }

        if (entityTag != null) {
            tag.set(ENTITY_TAG.NBT, entityTag);
        }
    }

    @Override
    boolean applicableTo(Material type) {
        switch (type) {
            case MONSTER_EGG:
                return true;
            default:
                return false;
        }
    }

    @Override
    boolean isEmpty() {
        return super.isEmpty() && isSpawnEggEmpty();
    }

    boolean isSpawnEggEmpty() {
        return !(hasSpawnedType() || entityTag != null);
    }

    boolean hasSpawnedType() {
        return spawnedType != null;
    }

    @Override
    public EntityType getSpawnedType() {
        return spawnedType;
    }

    @Override
    public void setSpawnedType(EntityType type) {
        Preconditions.checkArgument(type == null || type.getName() != null, "Spawn egg type must have name (%s)", type);

        this.spawnedType = type;
    }

    @Override
    boolean equalsCommon(RunesMeta meta) {
        if (!super.equalsCommon(meta)) {
            return false;
        }
        if (meta instanceof RunesSpawnEgg) {
            RunesSpawnEgg that = (RunesSpawnEgg) meta;

            return hasSpawnedType() ? that.hasSpawnedType() && this.spawnedType.equals(that.spawnedType) : !that.hasSpawnedType()
                    && entityTag != null ? that.entityTag != null && this.entityTag.equals(that.entityTag) : entityTag == null;
        }
        return true;
    }

    @Override
    boolean notUncommon(RunesMeta meta) {
        return super.notUncommon(meta) && (meta instanceof RunesSpawnEgg || isSpawnEggEmpty());
    }

    @Override
    int applyHash() {
        final int original;
        int hash = original = super.applyHash();

        if (hasSpawnedType()) {
            hash = 73 * hash + spawnedType.hashCode();
        }
        if (entityTag != null) {
            hash = 73 * hash + entityTag.hashCode();
        }

        return original != hash ? RunesSpawnEgg.class.hashCode() ^ hash : hash;
    }

    @Override
    Builder<String, Object> serialize(Builder<String, Object> builder) {
        super.serialize(builder);

        if (hasSpawnedType()) {
            builder.put(ENTITY_ID.BUKKIT, spawnedType.getName());
        }

        return builder;
    }

    @Override
    public RunesSpawnEgg clone() {
        RunesSpawnEgg clone = (RunesSpawnEgg) super.clone();

        clone.spawnedType = spawnedType;

        return clone;
    }
}
