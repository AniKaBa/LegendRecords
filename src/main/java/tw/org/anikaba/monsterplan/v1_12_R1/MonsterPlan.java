package tw.org.anikaba.monsterplan.v1_12_R1;

import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import tw.org.anikaba.legend.monster.Plan;
import tw.org.anikaba.legend.monster.PlanMonster;
import tw.org.anikaba.monsterplan.PlanConfig;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

public abstract class MonsterPlan extends EntityMonster implements PlanMonster {

    private String id; // 怪物編號
    private UUID ownerUUID; // 主人

    MonsterPlan(World world, PlanConfig pc) {
        super(world);
        new MonsterProc(this, pc); // 設定套用
        this.id = pc.getId();
    }
    // 設定死掉落的經驗值
    void setDropExp(int i) {
        this.b_ = i;
    }
    // 取得主人UUID
    public UUID getOwnerUUID() {
        return this.ownerUUID;
    }
    // 設定主人
    public void setOwnerUUID(UUID u) {
        this.ownerUUID = u;
    }
    // 取得主人EntityLiving
    public EntityLiving getOwner() {
        try {
            UUID uuid = this.getOwnerUUID();

            return uuid == null ? null : this.world.b(uuid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // 檢查是否坐下
    public boolean isSitting() {
        return false; // 有空加入動作
    }

    @Override
    public void a(float f, float f1, float f2) {
        if (this.passengers.size() != 0 && this.passengers.get(0) instanceof EntityPlayer) {
            EntityLiving passenger = (EntityLiving) this.passengers.get(0);
            this.yaw = passenger.yaw;
            this.lastYaw = this.yaw;
            this.pitch = (passenger.pitch * 0.5F);
            setYawPitch(this.yaw, this.pitch);
            this.aN = this.yaw;
            this.aP = this.aN;
            f = passenger.be;
            f1 = passenger.bh;
            f2 = passenger.bg;
            if(f2 <= 0.0F) {
                f2 *= 0.25F;// Make backwards slower
            }
            Field jump = null; //Jumping
            try {
                jump = EntityLiving.class.getDeclaredField("bd");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            jump.setAccessible(true);

            if (jump != null && this.onGround) {     // Wouldn't want it jumping while on the ground would we?
                try {
                    if (jump.getBoolean(passenger)) {
                        double jumpHeight = 0.5D;     //Here you can set the jumpHeight
                        this.motY = jumpHeight;        // Used all the time in NMS for entity jumping
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        super.a(f, f1, f2);
    }

    public void a(EntityLiving e, float v) {
        EntitySnowball entitysnowball = new EntitySnowball(this.world, this);
        double d0 = e.locY + (double) e.getHeadHeight() - 1.100000023841858D;
        double d1 = e.locX - this.locX;
        double d2 = d0 - entitysnowball.locY;
        double d3 = e.locZ - this.locZ;
        float f1 = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        entitysnowball.shoot(d1, d2 + (double) f1, d3, 1.6F, 12.0F);
        this.a(SoundEffects.gs, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(entitysnowball);
    }
    // 回傳傷害
    public float getAtkDam() {
        return Plan.getPlanConfig(this.id).getAttlist().get(2);
    }
    // 回傳攻速
    public float getAtkSpe() {
        return Plan.getPlanConfig(this.id).getAttlist().get(3);
    }
    // 回傳移動速度
    public float getMovSpe() {
        return Plan.getPlanConfig(this.id).getAttlist().get(5);
    }
    // 回傳防禦
    public float getDef() {
        return Plan.getPlanConfig(this.id).getAttlist().get(6);
    }
    // 回傳道具掉落
    public List<String> getDrops() {
        return Plan.getPlanConfig(this.id).getDrop();
    }
    // 回傳怪物編號
    public String getMpId() {
        return this.id;
    }

    public void doSpawn(Location l) {
        World world = ((CraftWorld) l.getWorld()).getHandle();
        this.setLocation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
        world.addEntity(this);
        // MonsterIntell.s(this.steed, this);
        if (CannibalPlan.getPlugin().getPlan().get(this.id).getEquip().size() != 0) {
            this.setSlot(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(CannibalPlan
                    .getPlugin().getPlan().get(this.id).getEquip().get(0)));
            this.setSlot(EnumItemSlot.CHEST, CraftItemStack.asNMSCopy(CannibalPlan
                    .getPlugin().getPlan().get(this.id).getEquip().get(1)));
            this.setSlot(EnumItemSlot.LEGS, CraftItemStack.asNMSCopy(CannibalPlan
                    .getPlugin().getPlan().get(this.id).getEquip().get(2)));
            this.setSlot(EnumItemSlot.FEET, CraftItemStack.asNMSCopy(CannibalPlan
                    .getPlugin().getPlan().get(this.id).getEquip().get(3)));
            this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(CannibalPlan
                    .getPlugin().getPlan().get(this.id).getEquip().get(4)));
            this.setSlot(EnumItemSlot.OFFHAND, CraftItemStack.asNMSCopy(CannibalPlan
                    .getPlugin().getPlan().get(this.id).getEquip().get(5)));
        }
    }
}