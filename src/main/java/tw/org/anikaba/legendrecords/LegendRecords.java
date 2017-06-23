package tw.org.anikaba.legendrecords;

import org.bukkit.plugin.java.JavaPlugin;
import tw.org.anikaba.Record.monster.PlanData;

public class LegendRecords extends JavaPlugin {

    private PlanData pd;

    @Override
    public void onEnable() {
        pd = new PlanData();
    }

    @Override
    public void onDisable() {
    }

    public PlanData getPlanData() {
        return this.pd;
    }
}