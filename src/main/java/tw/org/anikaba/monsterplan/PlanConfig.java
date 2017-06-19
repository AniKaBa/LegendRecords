package tw.org.anikaba.monsterplan;

import ninja.leaping.configurate.ConfigurationOptions;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanConfig {

    private ConfigurationLoader<CommentedConfigurationNode> loader;
    private CommentedConfigurationNode node;

    public PlanConfig(String name) {
        File file = new File("plugins/LegendRecords/Monster/" + name +
                ".conf");
        loader = HoconConfigurationLoader.builder().setFile(file).build();
        node = loader.createEmptyNode(ConfigurationOptions.defaults());
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                node.getNode("基本資料", "名稱").setValue("殺人雞");
                node.getNode("基本資料", "編號").setValue("ch-001");
                node.getNode("基本資料", "外型").setValue("雞");
                node.getNode("基本資料", "年齡").setValue("成年");
                node.getNode("基本屬性", "攻擊傷害").setValue(3.0D);
                node.getNode("基本屬性", "追蹤範圍").setValue(10.0D);
                node.getNode("基本屬性", "移動速度").setValue(0.25D);
                node.getNode("基本屬性", "生命值").setValue(4.0D);
                node.getNode("基本屬性", "擊退抵抗").setValue(1.0D);
                node.getNode("基本屬性", "攻擊速度").setValue(4.0D);
                node.getNode("基本屬性", "護甲").setValue(2.0D);
                node.getNode("基本屬性", "防禦補正").setValue(0.0D);
                node.getNode("基本屬性", "幸運").setValue(0.0D);
                node.getNode("基本屬性", "經驗值").setValue(1.0D);
                List<String> l = new ArrayList<>();
                l.add("人類");
                l.add("雞");
                node.getNode("戰鬥設定", "攻擊對象").setValue(l);
                node.getNode("戰鬥設定", "立場").setValue("主動攻擊");
                l = new ArrayList<>();
                l.add("近戰");
                node.getNode("戰鬥設定", "技能").setValue(l);
                l = new ArrayList<>();
                l.add("world:17:13");
                l.add("world:17:12");
                l.add("world:17:14");
                l.add("world:16:13");
                l.add("world:18:13");
                node.getNode("其他設定", "出生區域").setValue(l);
                l = new ArrayList<>();
                l.add("遊走");
                l.add("瞪你");
                node.getNode("其他設定", "行為特徵").setValue(l);
                Map<String, Double> m = new HashMap<>();
                m.put("YELLOW_DUCK_HELMET", 0.01D);
                m.put("YELLOW_DUCK_CHEST", 0.01D);
                m.put("YELLOW_DUCK_SHIELD", 0.01D);
                m.put("YELLOW_DUCK_LEGGINGS", 0.01D);
                m.put("YELLOW_DUCK_BOOTS", 0.01D);
                node.getNode("其他設定", "掉落寶物").setValue(m);
                node.getNode("其他設定", "座騎").setValue("豬");
                node.getNode("武器裝備", "頭盔").setValue("YELLOW_DUCK_HELMET");
                node.getNode("武器裝備", "胸甲").setValue("YELLOW_DUCK_CHEST");
                node.getNode("武器裝備", "護腿").setValue("YELLOW_DUCK_LEGGINGS");
                node.getNode("武器裝備", "靴子").setValue("YELLOW_DUCK_BOOTS");
                node.getNode("武器裝備", "右手").setValue("NORMAL_SWORD");
                node.getNode("武器裝備", "左手").setValue("YELLOW_DUCK_SHIELD");
            } else {
                node = loader.load();
            }
        } catch (Exception e) {
            System.out.print("怪物資料建立失敗！！");
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            loader.save(node);
        } catch (IOException e) {
            System.out.print("怪物資料儲存失敗！！");
            e.printStackTrace();
        }
    }

    public String getId() {
        return node.getNode("基本資料", "編號").getString();
    }

    public String getType() {
        return node.getNode("基本資料", "外型").getString();
    }

    public String getName() {
        return node.getNode("基本資料", "名稱").getString();
    }

    public List<Float> getAttlist() {
        List<Float> l = new ArrayList<>();
        l.add(node.getNode("基本屬性", "幸運").getFloat());
        l.add(node.getNode("基本屬性", "擊退抵抗").getFloat());
        l.add(node.getNode("基本屬性", "攻擊傷害").getFloat());
        l.add(node.getNode("基本屬性", "攻擊速度").getFloat());
        l.add(node.getNode("基本屬性", "生命值").getFloat());
        l.add(node.getNode("基本屬性", "移動速度").getFloat());
        l.add(node.getNode("基本屬性", "護甲").getFloat());
        l.add(node.getNode("基本屬性", "追蹤範圍").getFloat());
        l.add(node.getNode("基本屬性", "防禦補正").getFloat());
        l.add(node.getNode("基本屬性", "經驗值").getFloat());
        return l;
    }

    public List<String> getTarget() {
        return (List<String>) node.getNode("戰鬥設定", "攻擊對象").getValue();
    }

    public List<String> getFeature() {
        return (List<String>) node.getNode("其他設定", "行為特徵").getValue();
    }

    public List<String> getSkill() {
        return (List<String>) node.getNode("戰鬥設定", "技能").getValue();
    }

    public List<String> getBorn() {
        return (List<String>) node.getNode("其他設定", "出生區域").getValue();
    }

    public String getSteed() {
        if (node.getNode("其他設定", "座騎").getString() != null) {
            return node.getNode("其他設定", "座騎").getString();
        }
        return "無";
    }
/*
    public List<String> getDrop() {
        List<String> l = new ArrayList<>();
        Map<String, Double> m = (Map<String, Double>) node.getNode("其他設定", "掉落寶物").getValue();
        if (m != null && plan.getK()) {
            m.forEach((s, f) -> l.add(s));
        }
        return l;
    }

    public List<ItemStack> getDrops() {
        List<ItemStack> l = new ArrayList<>();
        Map<String, Double> m = (Map<String, Double>) node.getNode("其他設定", "掉落寶物").getValue();
        if (m != null && plan.getK()) {
            Random r = new Random();
            m.forEach((s, f) ->{
                if (r.nextDouble() < f) {
                    l.add(GlobalVar.GetItemByKey(s));
                }
            });
        }
        return l;
    }

    public List<ItemStack> getEquip() {
        List<ItemStack> l = new ArrayList<>();
        if (plan.getK()) {
            l.add(GlobalVar.GetItemByKey(node.getNode("武器裝備", "頭盔").getString()));
            l.add(GlobalVar.GetItemByKey(node.getNode("武器裝備", "胸甲").getString()));
            l.add(GlobalVar.GetItemByKey(node.getNode("武器裝備", "護腿").getString()));
            l.add(GlobalVar.GetItemByKey(node.getNode("武器裝備", "靴子").getString()));
            l.add(GlobalVar.GetItemByKey(node.getNode("武器裝備", "右手").getString()));
            l.add(GlobalVar.GetItemByKey(node.getNode("武器裝備", "左手").getString()));
        }
        return l;
    }*/
}
