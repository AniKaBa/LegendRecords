package tw.org.anikaba.legend.monster;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Monster;
import tw.org.anikaba.Record.monster.PlanData;
import tw.org.anikaba.legendrecords.LegendRecords;
import tw.org.anikaba.monsterplan.PlanConfig;

public class Plan {

    private static PlanData getPlanData() {
        LegendRecords lr = (LegendRecords) Bukkit.getPluginManager().getPlugin("LegendRecords");
        return lr.getPlanData();
    }

    public static PlanConfig getPlanConfig(String id) {
        return getPlanData().getPlanConfig(id);
    }

    public static Boolean isKycraft() {
        return getPlanData().isKycraft();
    }

    public static Boolean isCannibal(Monster m) {
        return getPlanData().isCannibal(m);
    }

    public static PlanMonster getPlanMonster(Monster m) {
        return getPlanData().getPlanMonster(m);
    }

    public static Boolean isArea(Chunk c) {
        return getPlanData().isArea(c);
    }

    public static Boolean isArea(String s) {
        return getPlanData().isArea(s);
    }

    public static String getCod(Chunk c) {
        return getPlanData().getCod(c);
    }

    public static String getCod(String s) {
        return getPlanData().getCod(s);
    }

    public static PlanMonster spawnMonster(Location l, String id) {
        return getPlanData().spawnMonster(l, id);
    }

    public static String getChunkName(Chunk c) {
        return getPlanData().getChunkName(c);
    }
}