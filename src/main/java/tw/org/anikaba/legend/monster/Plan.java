package tw.org.anikaba.legend.monster;

import org.bukkit.Location;
import org.bukkit.entity.Monster;
import tw.org.anikaba.monsterplan.PlanConfig;

public interface Plan {

    public Boolean isCannibal(Monster m);

    public PlanMonster getMonster(Monster m);

    public PlanMonster getMonster(Location l, PlanConfig pc);
}