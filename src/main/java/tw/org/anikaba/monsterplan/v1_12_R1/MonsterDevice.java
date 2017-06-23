package tw.org.anikaba.monsterplan.v1_12_R1;

import org.bukkit.Location;
import org.bukkit.entity.Monster;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftMonster;
import tw.org.anikaba.legend.monster.PlanDevice;
import tw.org.anikaba.legend.monster.PlanMonster;
import tw.org.anikaba.monsterplan.PlanConfig;

public class MonsterDevice implements PlanDevice {

    public Boolean isCannibal(Monster m) {
        return (((CraftMonster) m).getHandle() instanceof MonsterPlan);
    }

    public PlanMonster getMonster(Monster m) {
        return (MonsterPlan) ((CraftMonster) m).getHandle();
    }

    public PlanMonster getMonster(Location l, PlanConfig pc) {
        return MonsterType.valueOf(pc.getType()).getMonster(((CraftWorld) l.getWorld()).getHandle(), pc);
    }
}