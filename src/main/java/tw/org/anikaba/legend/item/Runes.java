package tw.org.anikaba.legend.item;

import org.bukkit.inventory.ItemStack;

public interface Runes {

    public ItemStack getItem(String cod);

    public void setItem(String cod, ItemStack stack);

    public void save();
}
