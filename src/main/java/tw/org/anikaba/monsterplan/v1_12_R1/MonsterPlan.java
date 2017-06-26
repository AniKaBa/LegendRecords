package tw.org.anikaba.monsterplan.v1_12_R1;

import com.google.common.base.Optional;
import com.kunyihua.crafte.GlobalVar;
import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import tw.org.anikaba.legend.monster.Plan;
import tw.org.anikaba.legend.monster.PlanMonster;
import tw.org.anikaba.monsterplan.PlanConfig;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

public abstract class MonsterPlan extends EntityMonster implements PlanMonster, IRangedEntity {

    private String id; // 怪物編號
    protected static final DataWatcherObject<Optional<UUID>> by = DataWatcher.a
            (MonsterPlan.class, DataWatcherRegistry.m);

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
        return (UUID) ((Optional) this.datawatcher.get(by)).orNull();
    }
    // 設定主人
    public void setOwnerUUID(@Nullable UUID u) {
        this.datawatcher.set(by, Optional.fromNullable(u));
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
        if (this.passengers.size() != 0 && this.passengers.get(0) == getOwner()) {
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
                f2 *= 0.25F;
            }
            Field jump = null;
            try {
                jump = EntityLiving.class.getDeclaredField("bd");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            jump.setAccessible(true);
            if (jump != null && this.onGround) {
                try {
                    if (jump.getBoolean(passenger)) {
                        double jumpHeight = 0.5D;
                        this.motY = jumpHeight;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        super.a(f, f1, f2);
    }

    protected void i() {
        super.i();
        this.datawatcher.register(by, Optional.absent());
    }
    // 遠程攻擊
    public void a(EntityLiving e, float f) {
        EntityArrow entityarrow = this.a(f);
        double d0 = e.locX - this.locX;
        double d1 = e.getBoundingBox().b + (double) (e.length / 3.0F) - entityarrow.locY;
        double d2 = e.locZ - this.locZ;
        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float) (14 - this.world.getDifficulty().a() * 4));
        this.a(SoundEffects.gW, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(entityarrow);
        /*
        EntitySnowball entitysnowball = new EntitySnowball(this.world, this);
        double d0 = e.locY + (double) e.getHeadHeight() - 1.100000023841858D;
        double d1 = e.locX - this.locX;
        double d2 = d0 - entitysnowball.locY;
        double d3 = e.locZ - this.locZ;
        float f1 = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        entitysnowball.shoot(d1, d2 + (double) f1, d3, 1.6F, 12.0F);
        this.a(SoundEffects.gs, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(entitysnowball);*/
    }

    private EntityArrow a(float f) {
        EntityTippedArrow entitytippedarrow = new EntityTippedArrow(this.world, this);
        entitytippedarrow.a(this, f);
        return entitytippedarrow;
    }

    @Override
    public void p(boolean b) {
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
        this.uniqueID = UUID.randomUUID();
        PlanConfig pc = Plan.getPlanConfig(id);
        World world = ((CraftWorld) l.getWorld()).getHandle();
        this.setLocation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
        world.addEntity(this);
        if (Plan.getPlanConfig(this.id).getEquip().size() != 0 && Plan.isKycraft()) {
            this.setSlot(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(
                    GlobalVar.GetItemByKey(pc.getEquip().get(0))));
            this.setSlot(EnumItemSlot.CHEST, CraftItemStack.asNMSCopy(
                    GlobalVar.GetItemByKey(pc.getEquip().get(1))));
            this.setSlot(EnumItemSlot.LEGS, CraftItemStack.asNMSCopy(
                    GlobalVar.GetItemByKey(pc.getEquip().get(2))));
            this.setSlot(EnumItemSlot.FEET, CraftItemStack.asNMSCopy(
                    GlobalVar.GetItemByKey(pc.getEquip().get(3))));
            this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(
                    GlobalVar.GetItemByKey(pc.getEquip().get(4))));
            this.setSlot(EnumItemSlot.OFFHAND, CraftItemStack.asNMSCopy(
                    GlobalVar.GetItemByKey(pc.getEquip().get(5))));
        }
        s(pc.getSteed());
    }
    // 怪物座騎
    private void s(String s) {
        EntityLiving e;
        switch (s) {
            case "洞穴蜘蛛":
                e = new EntityCaveSpider(this.world);
                break;
            case "雞":
                e = new EntityChicken(this.world);
                break;
            case "牛":
                e = new EntityCow(this.world);
                break;
            case "驢":
                e = new EntityHorseDonkey(this.world);
                break;
            case "終界蟎":
                e = new EntityEndermite(this.world);
                break;
            case "馬":
                e = new EntityHorse(this.world);
                break;
            case "鐵魔像":
                e = new EntityIronGolem(this.world);
                break;
            case "羊駝":
                e = new EntityLlama(this.world);
                break;
            case "騾":
                e = new EntityHorseMule(this.world);
                break;
            case "蘑菇牛":
                e = new EntityMushroomCow(this.world);
                break;
            case "野貓":
                e = new EntityOcelot(this.world);
                break;
            case "豬":
                e = new EntityPig(this.world);
                break;
            case "北極熊":
                e = new EntityPolarBear(this.world);
                break;
            case "綿羊":
                e = new EntitySheep(this.world);
                break;
            case "蠹魚":
                e = new EntitySilverfish(this.world);
                break;
            case "骷髏":
                e = new EntitySkeleton(this.world);
                break;
            case "骷髏馬":
                e = new EntityHorseSkeleton(this.world);
                break;
            case "蜘蛛":
                e = new EntitySpider(this.world);
                break;
            case "狼":
                e = new EntityWolf(this.world);
                break;
            case "殭屍馬":
                e = new EntityHorseZombie(this.world);
                break;
            default:
                return;
        }
        e.setPositionRotation(this.locX, this.locY, this.locZ, this.yaw, 0.0F);
        this.world.addEntity(e);
        this.startRiding(e);
    }
}