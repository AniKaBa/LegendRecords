package tw.org.anikaba.legend.monster;

import org.bukkit.Bukkit;
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
}