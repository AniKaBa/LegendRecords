package tw.org.anikaba.runesitem.v1_12_R1;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

import net.minecraft.server.v1_12_R1.*;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_12_R1.block.*;
import org.bukkit.craftbukkit.v1_12_R1.util.CraftMagicNumbers;
import org.bukkit.inventory.meta.BlockStateMeta;

public class RunesBlockState extends RunesMeta implements BlockStateMeta {

    @RunesMeta.ItemMetaKey.Specific(RunesMeta.ItemMetaKey.Specific.To.NBT)
    static final ItemMetaKey BLOCK_ENTITY_TAG = new ItemMetaKey("BlockEntityTag");

    final Material material;
    NBTTagCompound blockEntityTag;

    RunesBlockState(RunesMeta meta, Material material) {
        super(meta);
        this.material = material;

        if (!(meta instanceof RunesBlockState)
                || ((RunesBlockState) meta).material != material) {
            blockEntityTag = null;
            return;
        }

        RunesBlockState te = (RunesBlockState) meta;
        this.blockEntityTag = te.blockEntityTag;
    }

    RunesBlockState(NBTTagCompound tag, Material material) {
        super(tag);
        this.material = material;

        if (tag.hasKeyOfType(BLOCK_ENTITY_TAG.NBT, CraftMagicNumbers.NBT.TAG_COMPOUND)) {
            blockEntityTag = tag.getCompound(BLOCK_ENTITY_TAG.NBT);
        } else {
            blockEntityTag = null;
        }
    }

    RunesBlockState(Map<String, Object> map) {
        super(map);
        String matName = SerializableMeta.getString(map, "blockMaterial", true);
        Material m = Material.getMaterial(matName);
        if (m != null) {
            material = m;
        } else {
            material = Material.AIR;
        }
    }

    @Override
    void applyToItem(NBTTagCompound tag) {
        super.applyToItem(tag);

        if (blockEntityTag != null) {
            tag.set(BLOCK_ENTITY_TAG.NBT, blockEntityTag);
        }
    }

    @Override
    void deserializeInternal(NBTTagCompound tag) {
        if (tag.hasKeyOfType(BLOCK_ENTITY_TAG.NBT, CraftMagicNumbers.NBT.TAG_COMPOUND)) {
            blockEntityTag = tag.getCompound(BLOCK_ENTITY_TAG.NBT);
        }
    }

    @Override
    void serializeInternal(final Map<String, NBTBase> internalTags) {
        if (blockEntityTag != null) {
            internalTags.put(BLOCK_ENTITY_TAG.NBT, blockEntityTag);
        }
    }

    @Override
    ImmutableMap.Builder<String, Object> serialize(ImmutableMap.Builder<String, Object> builder) {
        super.serialize(builder);
        builder.put("blockMaterial", material.name());
        return builder;
    }

    @Override
    int applyHash() {
        final int original;
        int hash = original = super.applyHash();
        if (blockEntityTag != null) {
            hash = 61 * hash + this.blockEntityTag.hashCode();
        }
        return original != hash ? RunesBlockState.class.hashCode() ^ hash : hash;
    }

    @Override
    public boolean equalsCommon(RunesMeta meta) {
        if (!super.equalsCommon(meta)) {
            return false;
        }
        if (meta instanceof RunesBlockState) {
            RunesBlockState that = (RunesBlockState) meta;

            return Objects.equal(this.blockEntityTag, that.blockEntityTag);
        }
        return true;
    }

    @Override
    boolean notUncommon(RunesMeta meta) {
        return super.notUncommon(meta) && (meta instanceof RunesBlockState || blockEntityTag == null);
    }

    @Override
    boolean isEmpty() {
        return super.isEmpty() && blockEntityTag == null;
    }

    @Override
    boolean applicableTo(Material type) {
        switch(type){
            case FURNACE:
            case CHEST:
            case TRAPPED_CHEST:
            case JUKEBOX:
            case DISPENSER:
            case DROPPER:
            case SIGN:
            case MOB_SPAWNER:
            case NOTE_BLOCK:
            case PISTON_BASE:
            case BREWING_STAND_ITEM:
            case ENCHANTMENT_TABLE:
            case COMMAND:
            case COMMAND_REPEATING:
            case COMMAND_CHAIN:
            case BEACON:
            case DAYLIGHT_DETECTOR:
            case DAYLIGHT_DETECTOR_INVERTED:
            case HOPPER:
            case REDSTONE_COMPARATOR:
            case FLOWER_POT_ITEM:
            case SHIELD:
            case STRUCTURE_BLOCK:
            case WHITE_SHULKER_BOX:
            case ORANGE_SHULKER_BOX:
            case MAGENTA_SHULKER_BOX:
            case LIGHT_BLUE_SHULKER_BOX:
            case YELLOW_SHULKER_BOX:
            case LIME_SHULKER_BOX:
            case PINK_SHULKER_BOX:
            case GRAY_SHULKER_BOX:
            case SILVER_SHULKER_BOX:
            case CYAN_SHULKER_BOX:
            case PURPLE_SHULKER_BOX:
            case BLUE_SHULKER_BOX:
            case BROWN_SHULKER_BOX:
            case GREEN_SHULKER_BOX:
            case RED_SHULKER_BOX:
            case BLACK_SHULKER_BOX:
            case ENDER_CHEST:
                return true;
        }
        return false;
    }

    @Override
    public boolean hasBlockState() {
        return blockEntityTag != null;
    }

    @Override
    public BlockState getBlockState() {
        if (blockEntityTag != null) {
            switch (material) {
                case SHIELD:
                    blockEntityTag.setString("id", "banner");
                    break;
                case WHITE_SHULKER_BOX:
                case ORANGE_SHULKER_BOX:
                case MAGENTA_SHULKER_BOX:
                case LIGHT_BLUE_SHULKER_BOX:
                case YELLOW_SHULKER_BOX:
                case LIME_SHULKER_BOX:
                case PINK_SHULKER_BOX:
                case GRAY_SHULKER_BOX:
                case SILVER_SHULKER_BOX:
                case CYAN_SHULKER_BOX:
                case PURPLE_SHULKER_BOX:
                case BLUE_SHULKER_BOX:
                case BROWN_SHULKER_BOX:
                case GREEN_SHULKER_BOX:
                case RED_SHULKER_BOX:
                case BLACK_SHULKER_BOX:
                    blockEntityTag.setString("id", "shulker_box");
                    break;
            }
        }
        TileEntity te = (blockEntityTag == null) ? null : TileEntity.a(null, blockEntityTag);

        switch (material) {
            case SIGN:
            case SIGN_POST:
            case WALL_SIGN:
                if (te == null) {
                    te = new TileEntitySign();
                }
                return new CraftSign(material, (TileEntitySign) te);
            case CHEST:
            case TRAPPED_CHEST:
                if (te == null) {
                    te = new TileEntityChest();
                }
                return new CraftChest(material, (TileEntityChest) te);
            case BURNING_FURNACE:
            case FURNACE:
                if (te == null) {
                    te = new TileEntityFurnace();
                }
                return new CraftFurnace(material, (TileEntityFurnace) te);
            case DISPENSER:
                if (te == null) {
                    te = new TileEntityDispenser();
                }
                return new CraftDispenser(material, (TileEntityDispenser) te);
            case DROPPER:
                if (te == null) {
                    te = new TileEntityDropper();
                }
                return new CraftDropper(material, (TileEntityDropper) te);
            case END_GATEWAY:
                if (te == null) {
                    te = new TileEntityEndGateway();
                }
                return new CraftEndGateway(material, (TileEntityEndGateway) te);
            case HOPPER:
                if (te == null) {
                    te = new TileEntityHopper();
                }
                return new CraftHopper(material, (TileEntityHopper) te);
            case MOB_SPAWNER:
                if (te == null) {
                    te = new TileEntityMobSpawner();
                }
                return new CraftCreatureSpawner(material, (TileEntityMobSpawner) te);
            case NOTE_BLOCK:
                if (te == null) {
                    te = new TileEntityNote();
                }
                return new CraftNoteBlock(material, (TileEntityNote) te);
            case JUKEBOX:
                if (te == null) {
                    te = new BlockJukeBox.TileEntityRecordPlayer();
                }
                return new CraftJukebox(material, (BlockJukeBox.TileEntityRecordPlayer) te);
            case BREWING_STAND_ITEM:
                if (te == null) {
                    te = new TileEntityBrewingStand();
                }
                return new CraftBrewingStand(material, (TileEntityBrewingStand) te);
            case SKULL:
                if (te == null) {
                    te = new TileEntitySkull();
                }
                return new CraftSkull(material, (TileEntitySkull) te);
            case COMMAND:
            case COMMAND_REPEATING:
            case COMMAND_CHAIN:
                if (te == null) {
                    te = new TileEntityCommand();
                }
                return new CraftCommandBlock(material, (TileEntityCommand) te);
            case BEACON:
                if (te == null) {
                    te = new TileEntityBeacon();
                }
                return new CraftBeacon(material, (TileEntityBeacon) te);
            case SHIELD:
            case BANNER:
            case WALL_BANNER:
            case STANDING_BANNER:
                if (te == null) {
                    te = new TileEntityBanner();
                }
                return new CraftBanner(material, (TileEntityBanner) te);
            case FLOWER_POT_ITEM:
                if (te == null) {
                    te = new TileEntityFlowerPot();
                }
                return new CraftFlowerPot(material, (TileEntityFlowerPot) te);
            case STRUCTURE_BLOCK:
                if (te == null) {
                    te = new TileEntityStructure();
                }
                return new CraftStructureBlock(material, (TileEntityStructure) te);
            case WHITE_SHULKER_BOX:
            case ORANGE_SHULKER_BOX:
            case MAGENTA_SHULKER_BOX:
            case LIGHT_BLUE_SHULKER_BOX:
            case YELLOW_SHULKER_BOX:
            case LIME_SHULKER_BOX:
            case PINK_SHULKER_BOX:
            case GRAY_SHULKER_BOX:
            case SILVER_SHULKER_BOX:
            case CYAN_SHULKER_BOX:
            case PURPLE_SHULKER_BOX:
            case BLUE_SHULKER_BOX:
            case BROWN_SHULKER_BOX:
            case GREEN_SHULKER_BOX:
            case RED_SHULKER_BOX:
            case BLACK_SHULKER_BOX:
                if (te == null) {
                    te = new TileEntityShulkerBox();
                }
                return new CraftShulkerBox(material, (TileEntityShulkerBox) te);
            case ENCHANTMENT_TABLE:
                if (te == null) {
                    te = new TileEntityEnchantTable();
                }
                return new CraftEnchantingTable(material, (TileEntityEnchantTable) te);
            case ENDER_CHEST:
                if (te == null){
                    te = new TileEntityEnderChest();
                }
                return new CraftEnderChest(material, (TileEntityEnderChest) te);
            case DAYLIGHT_DETECTOR:
            case DAYLIGHT_DETECTOR_INVERTED:
                if (te == null){
                    te = new TileEntityLightDetector();
                }
                return new CraftDaylightDetector(material, (TileEntityLightDetector) te);
            case REDSTONE_COMPARATOR:
                if (te == null){
                    te = new TileEntityComparator();
                }
                return new CraftComparator(material, (TileEntityComparator) te);
            default:
                throw new IllegalStateException("Missing blockState for " + material);
        }
    }

    @Override
    public void setBlockState(BlockState blockState) {
        Validate.notNull(blockState, "blockState must not be null");
        TileEntity te = ((CraftBlockState) blockState).getTileEntity();
        Validate.notNull(te, "Invalid tile for " + blockState);

        boolean valid;
        switch (material) {
            case SIGN:
            case SIGN_POST:
            case WALL_SIGN:
                valid = te instanceof TileEntitySign;
                break;
            case CHEST:
            case TRAPPED_CHEST:
                valid = te instanceof TileEntityChest;
                break;
            case BURNING_FURNACE:
            case FURNACE:
                valid = te instanceof TileEntityFurnace;
                break;
            case DISPENSER:
                valid = te instanceof TileEntityDispenser;
                break;
            case DROPPER:
                valid = te instanceof TileEntityDropper;
                break;
            case END_GATEWAY:
                valid = te instanceof TileEntityEndGateway;
                break;
            case HOPPER:
                valid = te instanceof TileEntityHopper;
                break;
            case MOB_SPAWNER:
                valid = te instanceof TileEntityMobSpawner;
                break;
            case NOTE_BLOCK:
                valid = te instanceof TileEntityNote;
                break;
            case JUKEBOX:
                valid = te instanceof BlockJukeBox.TileEntityRecordPlayer;
                break;
            case BREWING_STAND_ITEM:
                valid = te instanceof TileEntityBrewingStand;
                break;
            case SKULL:
                valid = te instanceof TileEntitySkull;
                break;
            case COMMAND:
            case COMMAND_REPEATING:
            case COMMAND_CHAIN:
                valid = te instanceof TileEntityCommand;
                break;
            case BEACON:
                valid = te instanceof TileEntityBeacon;
                break;
            case SHIELD:
            case BANNER:
            case WALL_BANNER:
            case STANDING_BANNER:
                valid = te instanceof TileEntityBanner;
                break;
            case FLOWER_POT_ITEM:
                valid = te instanceof TileEntityFlowerPot;
                break;
            case STRUCTURE_BLOCK:
                valid = te instanceof TileEntityStructure;
                break;
            case WHITE_SHULKER_BOX:
            case ORANGE_SHULKER_BOX:
            case MAGENTA_SHULKER_BOX:
            case LIGHT_BLUE_SHULKER_BOX:
            case YELLOW_SHULKER_BOX:
            case LIME_SHULKER_BOX:
            case PINK_SHULKER_BOX:
            case GRAY_SHULKER_BOX:
            case SILVER_SHULKER_BOX:
            case CYAN_SHULKER_BOX:
            case PURPLE_SHULKER_BOX:
            case BLUE_SHULKER_BOX:
            case BROWN_SHULKER_BOX:
            case GREEN_SHULKER_BOX:
            case RED_SHULKER_BOX:
            case BLACK_SHULKER_BOX:
                valid = te instanceof TileEntityShulkerBox;
                break;
            case ENCHANTMENT_TABLE:
                valid = te instanceof TileEntityEnchantTable;
                break;
            case ENDER_CHEST:
                valid = te instanceof TileEntityEnderChest;
                break;
            case DAYLIGHT_DETECTOR:
            case DAYLIGHT_DETECTOR_INVERTED:
                valid = te instanceof TileEntityLightDetector;
                break;
            case REDSTONE_COMPARATOR:
                valid = te instanceof TileEntityComparator;
                break;
            default:
                valid = false;
                break;
        }

        Validate.isTrue(valid, "Invalid blockState for " + material);

        blockEntityTag = new NBTTagCompound();
        te.save(blockEntityTag);
    }
}