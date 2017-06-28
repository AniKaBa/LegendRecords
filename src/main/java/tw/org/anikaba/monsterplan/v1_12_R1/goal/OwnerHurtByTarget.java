package tw.org.anikaba.monsterplan.v1_12_R1.goal;

import net.minecraft.server.v1_12_R1.EntityLiving;
import net.minecraft.server.v1_12_R1.EntityTameableAnimal;
import net.minecraft.server.v1_12_R1.PathfinderGoalTarget;
import tw.org.anikaba.monsterplan.v1_12_R1.MonsterPlan;

public class OwnerHurtByTarget extends PathfinderGoalTarget {

    MonsterPlan a;
    EntityLiving b;
    private int c;

    public OwnerHurtByTarget(MonsterPlan mp) {
        super(mp, false);
        this.a = mp;
        this.a(1);
    }

    public boolean a() {
        if (!this.a.isTamed()) {
            return false;
        } else {
            EntityLiving entityliving = this.a.getOwner();
            if (entityliving == null) {
                return false;
            } else {
                this.b = entityliving.getLastDamager();
                int i = entityliving.bT();
                return i != this.c && this.a(this.b, false) && this.a.a(this.b, entityliving);
            }
        }
    }

    public void c() {
        this.e.setGoalTarget(this.b, org.bukkit.event.entity.EntityTargetEvent.TargetReason.TARGET_ATTACKED_OWNER, true); // CraftBukkit - reason
        EntityLiving entityliving = this.a.getOwner();
        if (entityliving != null) {
            this.c = entityliving.bT();
        }
        super.c();
    }
}
