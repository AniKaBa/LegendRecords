package tw.org.anikaba.Record.monster;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Monster;
import org.bukkit.plugin.Plugin;
import tw.org.anikaba.legend.monster.PlanDevice;
import tw.org.anikaba.legend.monster.PlanMonster;
import tw.org.anikaba.legendrecords.LegendRecords;
import tw.org.anikaba.monsterplan.PlanCommand;
import tw.org.anikaba.monsterplan.PlanConfig;
import tw.org.anikaba.monsterplan.PlanEvent;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PlanData {

    private Map<String, PlanConfig> pcs = new HashMap<>(); // 怪物資料庫
    private Map<String, String> tom = new HashMap<>(); // 怪物出生點資料庫
    private Boolean k; // 判斷是否使用 K-item
    private PlanDevice p; // 版本載入器

    public PlanData() {
        LegendRecords p = (LegendRecords) Bukkit.getPluginManager().getPlugin("LegendRecords");
        p.getCommand("lr").setExecutor(new PlanCommand());
        p.getServer().getPluginManager().registerEvents(new PlanEvent(), p);
        switch (Bukkit.getBukkitVersion()) {
            case "1.12-R0.1-SNAPSHOT":
                this.p = new tw.org.anikaba.monsterplan.v1_12_R1.MonsterDevice();
                tw.org.anikaba.monsterplan.v1_12_R1.MonsterType.register();
                break;
            /*case "1.11.2-R0.1-SNAPSHOT":
                this.p = new tw.org.anikaba.monsterplan.v1_11_R1.MonsterDevice();
                tw.org.anikaba.monsterplan.v1_11_R1.MonsterType.register();
                break;
            case "1.10.2-R0.1-SNAPSHOT":
                this.p = new tw.org.anikaba.monsterplan.v1_10_R1.MonsterDevice();
                tw.org.anikaba.monsterplan.v1_10_R1.MonsterType.register();
                break;
            case "1.9.4-R0.1-SNAPSHOT":
                this.p = new tw.org.anikaba.monsterplan.v1_9_R2.MonsterDevice();
                tw.org.anikaba.monsterplan.v1_9_R2.MonsterType.register();
                break;*/
            default:
                System.out.print("[怪物計劃] 執行失敗！");
                Bukkit.shutdown();
                break;
        }
        new PlanConfig("ch-001").save(); // 範例
        File f = new File("plugins/LegendRecords/Monster/");
        Arrays.asList(f.list()).forEach(s ->{ // 搜尋所有設定檔並加入資料庫
            s = s.replaceAll(".conf", "");
            PlanConfig pc = new  PlanConfig(s);
            pcs.put(s, pc);
            if (pc.getBorn() != null) { // 怪物出生區資料庫
                pc.getBorn().forEach(s1 -> tom.put(s1, pc.getId()));
            }
        });
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Kycraft");
        if (plugin != null) k = false; // Kycraft 啟動判斷
    }

    public Boolean isCannibal(Monster m) {
        return p.isCannibal(m);
    }

    public PlanMonster getPlanMonster(Monster m) {
        return isCannibal(m) ? p.getMonster(m): null;
    }

    public PlanMonster spawnMonster(Location l, String id) {
        PlanMonster cm = p.getMonster(l, getPlanConfig(id));
        cm.doSpawn(l);
        return cm;
    }

    public PlanConfig getPlanConfig(String cod) {
        return pcs.getOrDefault(cod, null);
    }

    public String getChunkName(Chunk chunk) {
        return chunk.getWorld().getName() + ":" + chunk.getX() +
                ":" + chunk.getZ();
    }

    public Boolean isArea(Chunk chunk) {
        return tom.containsKey(getChunkName(chunk));
    }

    public Boolean isArea(String name) {
        return tom.containsKey(name);
    }

    public String getCod(Chunk chunk) {
        return tom.getOrDefault(getChunkName(chunk), null);
    }

    public String getCod(String name) {
        return tom.getOrDefault(name, null);
    }

    public Boolean isKycraft() {
        return this.k;
    }
}