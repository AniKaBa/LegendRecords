package tw.org.anikaba.monsterplan.v1_12_R1;

public class MonsterDevice {

    public Boolean isCannibal(Monster m) {
        return (((CraftMonster) m).getHandle() instanceof PlanMonster);
    }

    @Override
    public CannibalMonster getMonster(Monster m) {
        return (PlanMonster) ((CraftMonster) m).getHandle();
    }

    @Override
    public CannibalMonster getMonster(Location l, PlanConfig pc) {
        return MonsterType.valueOf(pc.getType()).getMonster(((CraftWorld) l.getWorld()).getHandle(), pc);
    }
}