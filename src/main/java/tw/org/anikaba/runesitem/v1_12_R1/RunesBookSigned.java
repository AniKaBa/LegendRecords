package tw.org.anikaba.runesitem.v1_12_R1;

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;
import org.bukkit.craftbukkit.v1_12_R1.util.CraftMagicNumbers;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.DelegateDeserialization;

import com.google.common.collect.ImmutableMap.Builder;

@DelegateDeserialization(RunesMeta.SerializableMeta.class)
public class RunesBookSigned extends RunesBook implements BookMeta {

    RunesBookSigned(RunesMeta meta) {
        super(meta);
    }

    RunesBookSigned(NBTTagCompound tag) {
        super(tag, false);

        boolean resolved = true;
        if (tag.hasKey(RESOLVED.NBT)) {
            resolved = tag.getBoolean(RESOLVED.NBT);
        }

        if (tag.hasKey(BOOK_PAGES.NBT)) {
            NBTTagList pages = tag.getList(BOOK_PAGES.NBT, CraftMagicNumbers.NBT.TAG_STRING);

            for (int i = 0; i < pages.size(); i++) {
                String page = pages.getString(i);
                if (resolved) {
                    try {
                        this.pages.add(IChatBaseComponent.ChatSerializer.a(page));
                        continue;
                    } catch (Exception e) {
                        // Ignore and treat as an old book
                    }
                }
                addPage(page);
            }
        }
    }

    RunesBookSigned(Map<String, Object> map) {
        super(map);
    }

    @Override
    void applyToItem(NBTTagCompound itemData) {
        super.applyToItem(itemData, false);

        if (hasTitle()) {
            itemData.setString(BOOK_TITLE.NBT, this.title);
        } else {
            itemData.setString(BOOK_TITLE.NBT, " ");
        }

        if (hasAuthor()) {
            itemData.setString(BOOK_AUTHOR.NBT, this.author);
        } else {
            itemData.setString(BOOK_AUTHOR.NBT, " ");
        }

        if (hasPages()) {
            NBTTagList list = new NBTTagList();
            for (IChatBaseComponent page : pages) {
                list.add(new NBTTagString(
                        IChatBaseComponent.ChatSerializer.a(page)
                ));
            }
            itemData.set(BOOK_PAGES.NBT, list);
        }
        itemData.setBoolean(RESOLVED.NBT, true);

        if (generation != null) {
            itemData.setInt(GENERATION.NBT, generation);
        } else {
            itemData.setInt(GENERATION.NBT, 0);
        }
    }

    @Override
    boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    boolean applicableTo(Material type) {
        switch (type) {
            case WRITTEN_BOOK:
            case BOOK_AND_QUILL:
                return true;
            default:
                return false;
        }
    }

    @Override
    public RunesBookSigned clone() {
        RunesBookSigned meta = (RunesBookSigned) super.clone();
        return meta;
    }

    @Override
    int applyHash() {
        final int original;
        int hash = original = super.applyHash();
        return original != hash ? RunesBookSigned.class.hashCode() ^ hash : hash;
    }

    @Override
    boolean equalsCommon(RunesMeta meta) {
        return super.equalsCommon(meta);
    }

    @Override
    boolean notUncommon(RunesMeta meta) {
        return super.notUncommon(meta) && (meta instanceof RunesBookSigned || isBookEmpty());
    }

    @Override
    Builder<String, Object> serialize(Builder<String, Object> builder) {
        super.serialize(builder);
        return builder;
    }
}