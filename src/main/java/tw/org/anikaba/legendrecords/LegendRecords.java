package tw.org.anikaba.legendrecords;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.plugin.java.JavaPlugin;
import tw.org.anikaba.record.monster.PlanData;
import tw.org.anikaba.runesitem.RunesDevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LegendRecords extends JavaPlugin {

    private PlanData pd;

    @Override
    public void onEnable() {
        pd = new PlanData();
        // test
        ItemStack itemStack = new ItemStack(Material.MAP);
        MapMeta itemMeta = (MapMeta) itemStack.getItemMeta();
        itemMeta.setScaling(true);
        itemMeta.setUnbreakable(true);
        List<String> l = new ArrayList<>();
        l.add("123");
        l.add("56");
        itemMeta.setLore(l);
        itemMeta.setLocalizedName("itemStack");
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL,10,true);
        itemMeta.setDisplayName("a apple");
        itemStack.setItemMeta(itemMeta);
        System.out.print("1: " + itemStack.serialize());
        Map<String, Object> map = RunesDevice.serialize(itemStack);
        System.out.print("2: " + map);
        ItemStack itemStack2 = RunesDevice.deserialize((HashMap<String, Object>) map);
        System.out.print("3: " + itemStack2.serialize());
    }

    @Override
    public void onDisable() {
    }

    public PlanData getPlanData() {
        return this.pd;
    }
}