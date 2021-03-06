package tw.org.anikaba.runesitem;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.FireworkEffect;
import org.bukkit.block.banner.Pattern;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftMetaBlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.potion.PotionEffect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunesDevice {
    // 道具反序列化
    public static ItemStack deserialize(HashMap<String, Object> m){
        Map<String, Object> d = new HashMap<>();
        if(m.containsKey("meta")){
            ((Map<String, Object>) m.get("meta")).forEach((s, o) ->{
                switch (s) {
                    case "color":
                        d.put(s, Color.deserialize((Map<String, Object>) o));
                        break;
                    case "custom-color":
                        d.put(s, Color.deserialize((Map<String, Object>) o));
                        break;
                    case "custom-effects":
                        List<PotionEffect> l = new ArrayList<>();
                        ((List<Map<String, Object>>) o).forEach(map -> l.add(new PotionEffect(map)));
                        d.put(s, l);
                        break;
                    case "display-map-color":
                        /*((MapMeta) meta).setColor(Color.deserialize((Map<String, Object>) o));*/
                        d.put(s, Color.deserialize((Map<String, Object>) o));
                        break;
                    case "firework-effect":
                        FireworkEffect.Builder b = FireworkEffect.builder();
                        ((Map<String, Object>) o).forEach(((s1, o1) -> {
                            switch (s1) {
                                case "colors":
                                    ((List<Map>) o1).forEach(map -> b.withColor(Color.deserialize
                                            (map)));
                                    break;
                                case "fade-colors":
                                    ((List<Map>) o1).forEach(map -> b.withFade(Color.deserialize
                                            (map)));
                                    break;
                                case "flicker":
                                    b.flicker(true);
                                    break;
                                case "trail":
                                    b.trail(true);
                                    break;
                                case "type":
                                    b.with(FireworkEffect.Type.valueOf((String) o1));
                                    break;
                            }
                        }));
                        d.put(s, b.build());
                        break;
                    case "firework-effects":
                        List<FireworkEffect> l2 = new ArrayList<>();
                        ((List<Map<String, Object>>) o).forEach(map -> {
                            FireworkEffect.Builder b1 = FireworkEffect.builder();
                            map.forEach(((s1, o1) -> {
                                switch (s1) {
                                    case "colors":
                                        ((List<Map>) o1).forEach(map1 -> b1.withColor(Color
                                                .deserialize(map1)));
                                        break;
                                    case "fade-colors":
                                        ((List<Map>) o1).forEach(map1 -> b1.withFade(Color
                                                .deserialize(map1)));
                                        break;
                                    case "flicker":
                                        b1.flicker(true);
                                        break;
                                    case "trail":
                                        b1.trail(true);
                                        break;
                                    case "type":
                                        b1.with(FireworkEffect.Type.valueOf((String) o1));
                                        break;
                                }
                            }));
                            l2.add(b1.build());
                        });
                        d.put(s, l2);
                        break;
                    case "patterns":
                        List<Pattern> l3 = new ArrayList<>();
                        ((List<Map>) o).forEach(o1 -> l3.add(new Pattern(o1)));
                        d.put(s, l3);
                        break;
                    default:
                        d.put(s, o);
                        break;
                }
            });
            try {
                m.put("meta", CraftMetaBlockState.SerializableMeta.deserialize(d));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return ItemStack.deserialize(m);
    }
    // 道具序列化
    public static Map<String, Object> serialize(ItemStack stack){
        Map<String, Object> m = stack.serialize();
        Map<String, Object> m2 = new HashMap<>();
        if(m.containsKey("meta")) {
            stack.getItemMeta().serialize().forEach((s, o) ->{
                switch (s) {
                    case "color":
                        m2.put(s, ((Color) o).serialize());
                        break;
                    case "custom-color":
                        m2.put(s, ((Color) o).serialize());
                        break;
                    case "custom-effects":
                        List<Map<String, Object>> lce = new ArrayList<>();
                        ((List<PotionEffect>) o).forEach(p -> {
                            lce.add(p.serialize());
                        });
                        m2.put(s, lce);
                        break;
                    case "display-map-color":
                        m2.put(s, ((Color) o).serialize());
                        break;
                    case "firework-effect":
                        Map<String, Object> m3 = new HashMap<>();
                        ((FireworkEffect) o).serialize().forEach((s1, o1) -> {
                            switch (s1) {
                                case "colors":
                                    List<Map<String, Object>> lc = new ArrayList<>();
                                    ((List<Color>) o1).forEach(c -> lc.add(c.serialize()));
                                    m3.put(s1, lc);
                                    break;
                                case "fade-colors":
                                    List<Map<String, Object>> lf = new ArrayList<>();
                                    ((List<Color>) o1).forEach(c -> lf.add(c.serialize()));
                                    m3.put(s1, lf);
                                    break;
                                default:
                                    m3.put(s1, o1);
                                    break;
                            }
                        });
                        m2.put(s, m3);
                        break;
                    case "firework-effects":
                        List<Map<String, Object>> lfe = new ArrayList<>();
                        ((List<FireworkEffect>) o).forEach(f -> {
                            Map<String, Object> m4 = new HashMap<>();
                            f.serialize().forEach((s1, o1) -> {
                                switch (s1) {
                                    case "colors":
                                        List<Map<String, Object>> lc = new ArrayList<>();
                                        ((List<Color>) o1).forEach(c -> lc.add(c.serialize()));
                                        m4.put(s1, lc);
                                        break;
                                    case "fade-colors":
                                        List<Map<String, Object>> lf = new ArrayList<>();
                                        ((List<Color>) o1).forEach(c -> lf.add(c.serialize()));
                                        m4.put(s1, lf);
                                        break;
                                    default:
                                        m4.put(s1, o1);
                                        break;
                                }
                            });
                            lfe.add(m4);
                        });
                        m2.put(s, lfe);
                        break;
                    case "patterns": // 旗幟
                        List<Map<String, Object>> l2 = new ArrayList<>();
                        ((List<Pattern>) o).forEach(p -> l2.add(p.serialize()));
                        m2.put(s, l2);
                        break;
                    default:
                        m2.put(s, o);
                        break;
                }
                m.put("meta", m2);
            });
        }
        return m;
    }
}