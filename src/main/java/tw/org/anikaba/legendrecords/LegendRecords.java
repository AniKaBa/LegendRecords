package tw.org.anikaba.legendrecords;

import org.bukkit.plugin.java.JavaPlugin;
import tw.org.anikaba.Record.monster.PlanData;
import tw.org.anikaba.monsterplan.v1_12_R1.MonsterType;

public class LegendRecords extends JavaPlugin {

    private PlanData pd = new PlanData();

    @Override
    public void onEnable() {
        MonsterType.register();
    }

    @Override
    public void onDisable() {
    }

    public PlanData getPlanData() {
        return this.pd;
    }
}