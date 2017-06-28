package tw.org.anikaba.monsterplan.v1_12_R1.goal;

import net.minecraft.server.v1_12_R1.EntityLiving;
import net.minecraft.server.v1_12_R1.PathfinderGoalTarget;
import tw.org.anikaba.monsterplan.v1_12_R1.MonsterPlan;

public class OwnerHurtTarget extends PathfinderGoalTarget {

    MonsterPlan a;
    EntityLiving b;
    private int c;

    public OwnerHurtTarget(MonsterPlan mp) {
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
                this.b = entityliving.bU();
                int i = entityliving.bV();
                return i != this.c && this.a(this.b, false) && this.a.a(this.b, entityliving);
            }
        }
    }

    public void c() {
        this.e.setGoalTarget(this.b, org.bukkit.event.entity.EntityTargetEvent.TargetReason.OWNER_ATTACKED_TARGET, true); // CraftBukkit - reason
        EntityLiving entityliving = this.a.getOwner();
        if (entityliving != null) {
            this.c = entityliving.bV();
        }
        super.c();
    }
}