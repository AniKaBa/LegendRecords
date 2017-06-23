package tw.org.anikaba.monsterplan.v1_12_R1;

import net.minecraft.server.v1_12_R1.*;
import tw.org.anikaba.monsterplan.PlanConfig;
import tw.org.anikaba.monsterplan.v1_12_R1.goal.FollowOwner;

import java.util.List;

class MonsterProc {

    MonsterProc (MonsterPlan mp, PlanConfig pc) {
        mp.setCustomName(pc.getName()); // 基本資料-名稱
        a(mp, pc.getAttlist()); // 基本屬性
        o(mp, pc.getTarget()); // 攻擊對象
        s(mp, pc.getSkill(), f(mp, pc.getFeature())); // 行為、攻擊模式
        mp.k(0.1F);
        mp.P = 1.0f; // 走路可走1格高低差
    }

    private void a(MonsterPlan p, List<Float> l) {
        // 幸運
        p.getAttributeMap().b(new AttributeRanged(null, "generic.luck", l.get(0), -1024.0D,
                1024.0D).a(true));
        // 擊退抗性
        p.getAttributeInstance(GenericAttributes.c).setValue(l.get(1));
        // 攻擊傷害
        p.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(l.get(2));
        // 攻擊速度
        p.getAttributeMap().b(new AttributeRanged(null, "generic.attackSpeed", l.get(3), 0.0D,
                1024.0D).a(true));
        // 生命值
        p.getAttributeInstance(GenericAttributes.maxHealth).setValue(l.get(4));
        p.setHealth(l.get(4));
        // 移動速度
        p.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(l.get(5));
        // 護甲
        p.getAttributeInstance(GenericAttributes.g).setValue(l.get(6));
        // 追蹤範圍
        p.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).setValue(l.get(7));
        // 防禦補正
        p.getAttributeInstance(GenericAttributes.h).setValue(l.get(8));
        // 經驗值
        float f = l.get(9);
        p.setDropExp((int) f);
        // 飛行速度***只有1.12
        p.getAttributeInstance(GenericAttributes.e).setValue(l.get(10));
    }

    private int f(MonsterPlan p, List<String> l) {
        if (l == null) return 0;
        final int[] j = {0};
        l.forEach(s -> {
            switch (s) {
                case "瞪你":
                    p.goalSelector.a(j[0], new PathfinderGoalLookAtPlayer(p, EntityHuman.class,
                            8.0F));
                    j[0]++;
                    break;
                case "遊走":
                    p.goalSelector.a(j[0], new PathfinderGoalRandomStrollLand(p, 1.0D));
                    j[0]++;
                    break;
                case "游泳":
                    p.goalSelector.a(j[0], new PathfinderGoalFloat(p));
                    j[0]++;
                    break;
                case "亂看":
                    p.goalSelector.a(j[0], new PathfinderGoalRandomLookaround(p));
                    j[0]++;
                    break;
                case "跟隨":
                    p.goalSelector.a(j[0], new FollowOwner(p, 1.0D, 10.0F, 2.0F));
                    j[0]++;
                    break;
                default:
                    break;
            }
        });
        return j[0];
    }

    private void s(MonsterPlan p, List<String> l, int i) {
        if (l == null) return;
        final int[] j = {i};
        l.forEach(s -> {
            switch (s) {
                case "近戰":
                    p.goalSelector.a(j[0], new PathfinderGoalMeleeAttack(p, 1.0D, false));
                    j[0]++;
                    break;
                case "遠程（雪球）":
                    p.goalSelector.a(j[0], new PathfinderGoalArrowAttack(p, 1.25D, 20, 10.0F));
                    j[0]++;
                    break;
                case "遠程（火球）":
                    // p.goalSelector.a(j[0], new GoalPlanFireball(p));
                    // j[0]++;
                    break;
            }
        });
    }

    private void o(MonsterPlan p, List<String> l) {
        if (l == null) return;
        final int[] j = {0};
        l.forEach(s -> {
            switch (s) {
                case "蝙蝠":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityBat.class, true));
                    j[0]++;
                    break;
                case "烈焰使者":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityBlaze.class, true));
                    j[0]++;
                    break;
                case "洞穴蜘蛛":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityCaveSpider.class, true));
                    j[0]++;
                    break;
                case "雞":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityChicken.class, true));
                    j[0]++;
                    break;
                case "牛":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityCow.class, true));
                    j[0]++;
                    break;
                case "苦力怕":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityCreeper.class, true));
                    j[0]++;
                    break;
                case "驢":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityHorseDonkey.class, true));
                    j[0]++;
                    break;
                case "遠古深海守衛":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityGuardianElder.class, true));
                    j[0]++;
                    break;
                case "終界龍":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityEnderDragon.class, true));
                    j[0]++;
                    break;
                case "終界使者":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityEnderman.class, true));
                    j[0]++;
                    break;
                case "終界蟎":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityEndermite.class, true));
                    j[0]++;
                    break;
                case "喚魔者":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityEvoker.class, true));
                    j[0]++;
                    break;
                case "地獄幽靈":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityGhast.class, true));
                    j[0]++;
                    break;
                case "巨人":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityGiantZombie.class, true));
                    j[0]++;
                    break;
                case "深海守衛":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityGuardian.class, true));
                    j[0]++;
                    break;
                case "馬":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityHorse.class, true));
                    j[0]++;
                    break;
                case "屍殼":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityZombieHusk.class, true));
                    j[0]++;
                    break;
                case "幻術師":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityIllagerIllusioner.class, true));
                    j[0]++;
                    break;
                case "鐵魔像":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityIronGolem.class, true));
                    j[0]++;
                    break;
                case "羊駝":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityLlama.class, true));
                    j[0]++;
                    break;
                case "熔岩史萊姆":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityMagmaCube.class, true));
                    j[0]++;
                    break;
                case "騾":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityHorseMule.class, true));
                    j[0]++;
                    break;
                case "蘑菇牛":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityMushroomCow.class, true));
                    j[0]++;
                    break;
                case "鸚鵡":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityParrot.class, true));
                    j[0]++;
                    break;
                case "野貓":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityOcelot.class, true));
                    j[0]++;
                    break;
                case "豬":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityPig.class, true));
                    j[0]++;
                    break;
                case "殭屍豬人":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityPigZombie.class, true));
                    j[0]++;
                    break;
                case "北極熊":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityPolarBear.class, true));
                    j[0]++;
                    break;
                case "兔":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityRabbit.class, true));
                    j[0]++;
                    break;
                case "綿羊":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntitySheep.class, true));
                    j[0]++;
                    break;
                case "蠹魚":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntitySilverfish.class, true));
                    j[0]++;
                    break;
                case "骷髏":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntitySkeleton.class, true));
                    j[0]++;
                    break;
                case "骷髏馬":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityHorseSkeleton.class, true));
                    j[0]++;
                    break;
                case "史萊姆":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntitySlime.class, true));
                    j[0]++;
                    break;
                case "雪人":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntitySnowman.class, true));
                    j[0]++;
                    break;
                case "蜘蛛":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntitySpider.class, true));
                    j[0]++;
                    break;
                case "烏賊":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntitySquid.class, true));
                    j[0]++;
                    break;
                case "流髑":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntitySkeletonStray.class, true));
                    j[0]++;
                    break;
                case "惱鬼":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityVex.class, true));
                    j[0]++;
                    break;
                case "村民":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityVillager.class, true));
                    j[0]++;
                    break;
                case "衛道士":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityVindicator.class, true));
                    j[0]++;
                    break;
                case "女巫":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityWitch.class, true));
                    j[0]++;
                    break;
                case "凋零怪":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityWither.class, true));
                    j[0]++;
                    break;
                case "凋零怪骷髏":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntitySkeletonWither.class, true));
                    j[0]++;
                    break;
                case "狼":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityWolf.class, true));
                    j[0]++;
                    break;
                case "殭屍":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityZombie.class, true));
                    j[0]++;
                    break;
                case "殭屍馬":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityHorseZombie.class, true));
                    j[0]++;
                    break;
                case "殭屍村民":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityZombieVillager.class, true));
                    j[0]++;
                    break;
                case "人類":
                    p.targetSelector.a(j[0], new PathfinderGoalNearestAttackableTarget<>(
                            p, EntityHuman.class, true));
                    j[0]++;
                    break;
                default:
                    break;
            }
        });
    }
}