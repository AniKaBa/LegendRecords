package tw.org.anikaba.runesitem;

public class RunesDevice {
    ItemStack deserialize(HashMap<String, Object> m){
        Map<String, Object> c = (Map) m.clone();
        c.put("meta", null);
        ItemMeta meta = ItemStack.deserialize(c).getItemMeta();
        if(m.containsKey("meta")){
            ((Map<String, Object>) m.get("meta")).forEach((s, o) ->{
                switch (s) {
                    case "ItemFlags":
                        ((List<String>) o).forEach((s1) -> meta.addItemFlags(ItemFlag
                                .valueOf(s1)));
                        break;
                    case "Unbreakable":
                        meta.setUnbreakable(true);
                        break;
                    case "author":
                        ((BookMeta) meta).setAuthor((String) o);
                        break;
                    case "base-color":
                        ((BannerMeta) meta).setBaseColor(DyeColor.valueOf((String) o));
                        break;
                    case "color":
                        ((LeatherArmorMeta) meta).setColor(Color.deserialize((Map<String,
                                Object>) o));
                        break;
                    case "custom-color":
                        ((PotionMeta) meta).setColor(Color.deserialize((Map<String,
                                Object>) o));
                        break;
                    case "custom-effects":
                        ((List<Map<String, Object>>) o).forEach(map -> ((PotionMeta) meta)
                                .addCustomEffect(new PotionEffect(map), true));
                        break;
                    case "display-loc-name":
                        ((MapMeta) meta).setLocationName((String) o);
                        break;
                    case "display-map-color":
                        ((MapMeta) meta).setColor(Color.deserialize((Map<String, Object>) o));
                        break;
                    case "display-name":
                        meta.setDisplayName((String) o);
                        break;
                    case "enchants":
                        ((Map<String, Integer>) o).forEach((s1, i) -> meta.addEnchant(Enchantment
                                .getByName(s1), i, true));
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
                        ((FireworkEffectMeta) meta).setEffect(b.build());
                        break;
                    case "firework-effects":
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
                            ((FireworkMeta) meta).addEffect(b1.build());
                        });
                        break;
                    case "generation":
                        switch ((int) o) {
                            case 0:
                                ((BookMeta) meta).setGeneration(BookMeta.Generation.ORIGINAL);
                                break;
                            case 1:
                                ((BookMeta) meta).setGeneration(BookMeta.Generation
                                        .COPY_OF_ORIGINAL);
                                break;
                            case 2:
                                ((BookMeta) meta).setGeneration(BookMeta.Generation.COPY_OF_COPY);
                                break;
                            case 3:
                                ((BookMeta) meta).setGeneration(BookMeta.Generation.TATTERED);
                                break;
                        }
                        break;
                    case "id":
                        ((SpawnEggMeta) meta).setSpawnedType(EntityType.fromName((String) o));
                        break;
                    case "loc-name":
                        meta.setLocalizedName((String) o);
                        break;
                    case "lore":
                        meta.setLore((List) o);
                        break;
                    case "pages":
                        ((BookMeta) meta).setPages((List) o);
                        break;
                    case "patterns":
                        ((List<Map>) o).forEach(o1 -> ((BannerMeta) meta).addPattern(new Pattern
                                (o1)));
                        break;
                    case "power":
                        ((FireworkMeta) meta).setPower((Integer) o);
                        break;
                    case "scaling":
                        ((MapMeta) meta).setScaling((Boolean) o);
                        break;
                    case "skull-owner":
                        ((SkullMeta) meta).setOwner((String) o);
                        break;
                    case "stored-enchants":
                        ((Map<String, Integer>) o).forEach(((s1, i) -> ((EnchantmentStorageMeta)
                                meta).addStoredEnchant(Enchantment.getByName(s1), i, true)));
                        break;
                    case "title":
                        ((BookMeta) meta).setTitle((String) o);
                        break;
                    default:
                        break;
                }
            });
            m.put("meta", meta);
        }
        return ItemStack.deserialize(m);
    }

    Map<String, Object> serialize(ItemStack stack){
        System.out.print(stack.serialize());
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
                    case "patterns":
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
