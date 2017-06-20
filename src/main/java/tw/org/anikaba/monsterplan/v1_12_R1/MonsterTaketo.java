package tw.org.anikaba.monsterplan.v1_12_R1;

import net.minecraft.server.v1_12_R1.*;

import java.util.List;

public class MonsterTaketo {
    public static void o(MonsterPlan p, List<String> l) {
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