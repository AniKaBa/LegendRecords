package tw.org.anikaba.runesitem;

import ninja.leaping.configurate.ConfigurationOptions;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.bukkit.inventory.ItemStack;
import tw.org.anikaba.legend.item.Runes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RunesItem extends RunesDevice implements Runes {

    private ConfigurationLoader<CommentedConfigurationNode> loader;
    private CommentedConfigurationNode node;
    private String s;

    public RunesItem(String name) {
        File file = new File("plugins/LegendRecords/Data/" +name + ".conf");
        s = name;
        loader = HoconConfigurationLoader.builder().setFile(file).build();
        node = loader.createEmptyNode(ConfigurationOptions.defaults());
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs(); // 建立目錄
                save(); // 建立空文件
            } else {
                node = loader.load();
            }
        } catch (Exception e) {
            System.out.print("建立 符文道具資料庫 發生錯誤！");
            e.printStackTrace();
        }
    }
    // 紀錄道具轉換型態
    private void setItemData(String cod, Map<String, Object> serialize) {
        node.getNode(s, cod).setValue(serialize);
    }
    // 取得道具轉換型態
    private HashMap getItemData(String cod) {
        return (HashMap) node.getNode(s, cod).getValue();
    }
    // 取得道具
    @Override
    public ItemStack getItem(String cod) {
        return deserialize(getItemData(cod));
    }
    // 紀錄道具
    @Override
    public void setItem(String cod, ItemStack stack) {
        setItemData(cod, serialize(stack));
    }
    // 資料儲存
    public void save() {
        try {
            loader.save(node);
        } catch (IOException e) {
            System.out.print("土符文道具資料庫 儲存錯誤!!");
            e.printStackTrace();
        }
    }
}
