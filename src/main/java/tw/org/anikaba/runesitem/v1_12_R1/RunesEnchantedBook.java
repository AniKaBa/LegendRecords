package tw.org.anikaba.runesitem.v1_12_R1;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.DelegateDeserialization;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

@DelegateDeserialization(RunesMeta.SerializableMeta.class)
public class RunesEnchantedBook extends RunesMeta implements EnchantmentStorageMeta {
    static final ItemMetaKey STORED_ENCHANTMENTS = new ItemMetaKey("StoredEnchantments", "stored-enchants");

    private Map<Enchantment, Integer> enchantments;

    RunesEnchantedBook(RunesMeta meta) {
        super(meta);

        if (!(meta instanceof RunesEnchantedBook)) {
            return;
        }

        RunesEnchantedBook that = (RunesEnchantedBook) meta;

        if (that.hasEnchants()) {
            this.enchantments = new HashMap<Enchantment, Integer>(that.enchantments);
        }
    }

    RunesEnchantedBook(NBTTagCompound tag) {
        super(tag);

        if (!tag.hasKey(STORED_ENCHANTMENTS.NBT)) {
            return;
        }

        enchantments = buildEnchantments(tag, STORED_ENCHANTMENTS);
    }

    RunesEnchantedBook(Map<String, Object> map) {
        super(map);

        enchantments = buildEnchantments(map, STORED_ENCHANTMENTS);
    }

    @Override
    void applyToItem(NBTTagCompound itemTag) {
        super.applyToItem(itemTag);

        applyEnchantments(enchantments, itemTag, STORED_ENCHANTMENTS);
    }

    @Override
    boolean applicableTo(Material type) {
        switch (type) {
            case ENCHANTED_BOOK:
                return true;
            default:
                return false;
        }
    }

    @Override
    boolean isEmpty() {
        return super.isEmpty() && isEnchantedEmpty();
    }

    @Override
    boolean equalsCommon(RunesMeta meta) {
        if (!super.equalsCommon(meta)) {
            return false;
        }
        if (meta instanceof RunesEnchantedBook) {
            RunesEnchantedBook that = (RunesEnchantedBook) meta;

            return (hasStoredEnchants() ? that.hasStoredEnchants() && this.enchantments.equals(that.enchantments) : !that.hasStoredEnchants());
        }
        return true;
    }

    @Override
    boolean notUncommon(RunesMeta meta) {
        return super.notUncommon(meta) && (meta instanceof RunesEnchantedBook || isEnchantedEmpty());
    }

    @Override
    int applyHash() {
        final int original;
        int hash = original = super.applyHash();

        if (hasStoredEnchants()) {
            hash = 61 * hash + enchantments.hashCode();
        }

        return original != hash ? RunesEnchantedBook.class.hashCode() ^ hash : hash;
    }

    @Override
    public RunesEnchantedBook clone() {
        RunesEnchantedBook meta = (RunesEnchantedBook) super.clone();

        if (this.enchantments != null) {
            meta.enchantments = new HashMap<Enchantment, Integer>(this.enchantments);
        }

        return meta;
    }

    @Override
    Builder<String, Object> serialize(Builder<String, Object> builder) {
        super.serialize(builder);

        serializeEnchantments(enchantments, builder, STORED_ENCHANTMENTS);

        return builder;
    }

    boolean isEnchantedEmpty() {
        return !hasStoredEnchants();
    }

    public boolean hasStoredEnchant(Enchantment ench) {
        return hasStoredEnchants() && enchantments.containsKey(ench);
    }

    public int getStoredEnchantLevel(Enchantment ench) {
        Integer level = hasStoredEnchants() ? enchantments.get(ench) : null;
        if (level == null) {
            return 0;
        }
        return level;
    }

    public Map<Enchantment, Integer> getStoredEnchants() {
        return hasStoredEnchants() ? ImmutableMap.copyOf(enchantments) : ImmutableMap.<Enchantment, Integer>of();
    }

    public boolean addStoredEnchant(Enchantment ench, int level, boolean ignoreRestrictions) {
        if (enchantments == null) {
            enchantments = new HashMap<Enchantment, Integer>(4);
        }

        if (ignoreRestrictions || level >= ench.getStartLevel() && level <= ench.getMaxLevel()) {
            Integer old = enchantments.put(ench, level);
            return old == null || old != level;
        }
        return false;
    }

    public boolean removeStoredEnchant(Enchantment ench) {
        return hasStoredEnchants() && enchantments.remove(ench) != null;
    }

    public boolean hasStoredEnchants() {
        return !(enchantments == null || enchantments.isEmpty());
    }

    public boolean hasConflictingStoredEnchant(Enchantment ench) {
        return checkConflictingEnchants(enchantments, ench);
    }
}