package tw.org.anikaba.monsterplan.v1_12_R1;


import net.minecraft.server.v1_12_R1.EntityTypes;
import net.minecraft.server.v1_12_R1.MinecraftKey;
import net.minecraft.server.v1_12_R1.World;
import tw.org.anikaba.monsterplan.PlanConfig;

public enum MonsterType {

    木頭人("木頭人", 30, Monster.PlanArmorStand.class),
    蝙蝠("蝙蝠", 65, Monster.PlanBat.class),
    烈焰使者("烈焰使者", 61, Monster.PlanBlaze.class),
    洞穴蜘蛛("洞穴蜘蛛", 59, Monster.PlanCaveSpider.class),
    雞("雞", 93, Monster.PlanChicken.class),
    牛("牛", 92, Monster.PlanCow.class),
    苦力怕("苦力怕", 50, Monster.PlanCreeper.class),
    驢("驢", 31, Monster.PlanDonkey.class),
    遠古深海守衛("遠古深海守衛", 4, Monster.PlanElderGuardian.class),
    終界龍("終界龍", 63, Monster.PlanEnderDragon.class),
    終界使者("終界使者", 58, Monster.PlanEnderman.class),
    終界蟎("終界蟎", 67, Monster.PlanEndermite.class),
    喚魔者("喚魔者", 34, Monster.PlanEvoker.class),
    地獄幽靈("地獄幽靈", 56, Monster.PlanGhast.class),
    巨人("巨人", 53, Monster.PlanGiant.class),
    深海守衛("深海守衛", 68, Monster.PlanGuardian.class),
    馬("馬", 100, Monster.PlanHorse.class),
    屍殼("屍殼", 23, Monster.PlanHusk.class),
    幻術師("幻術師", 37, Monster.PlanIllager.class),
    鐵魔像("鐵魔像", 99, Monster.PlanIronGolem.class),
    羊駝("羊駝", 103, Monster.PlanLlama.class),
    熔岩史萊姆("熔岩史萊姆", 62, Monster.PlanMagmaCube.class),
    騾("騾", 32, Monster.PlanMule.class),//
    蘑菇牛("蘑菇牛", 96, Monster.PlanMushroomCow.class),
    野貓("野貓", 98, Monster.PlanOcelot.class),
    鸚鵡("鸚鵡", 105, Monster.PlanParrot.class),
    豬("豬", 90, Monster.PlanPig.class),
    殭屍豬人("殭屍豬人", 57, Monster.PlanPigZombie.class),
    北極熊("北極熊", 102, Monster.PlanPolarBear.class),
    兔("兔", 101, Monster.PlanRabbit.class),
    綿羊("綿羊", 91, Monster.PlanSheep.class),
    蠹魚("蠹魚", 60, Monster.PlanSilverfish.class),
    骷髏("骷髏", 51, Monster.PlanSkeleton.class),
    骷髏馬("骷髏馬", 28, Monster.PlanSkeletonHorse.class),
    史萊姆("史萊姆", 55, Monster.PlanSlime.class),
    雪人("雪人", 97, Monster.PlanSnowman.class),
    蜘蛛("蜘蛛", 52, Monster.PlanSpider.class),
    烏賊("烏賊", 94, Monster.PlanSquid.class),//
    流髑("流髑", 6, Monster.PlanStray.class),
    惱鬼("惱鬼", 35, Monster.PlanVex.class),
    村民("村民", 120, Monster.PlanVillager.class),
    衛道士("衛道士", 36, Monster.PlanVindicator.class),
    女巫("女巫", 66, Monster.PlanWitch.class),
    凋零怪("凋零怪", 64, Monster.PlanWither.class),
    凋零怪骷髏("凋零怪骷髏", 5, Monster.PlanWitherSkeleton.class),
    狼("狼", 95, Monster.PlanWolf.class),
    殭屍("殭屍", 54, Monster.PlanZombie.class),
    殭屍馬("殭屍馬", 29, Monster.PlanZombieHorse.class),
    殭屍村民("殭屍村民", 27, Monster.PlanZombieVillager.class),
    人類("人類", 1, Monster.PlanHuman.class);

    private String name;
    private int id;
    private Class<? extends MonsterPlan> c;

    MonsterType(String n, int d, Class<? extends MonsterPlan> c) {
        this.name = n;
        this.id = d;
        this.c = c;
    }

    public MonsterPlan getMonster (World w, PlanConfig pc) {
        switch (name) {
            case "木頭人":
                return new Monster.PlanArmorStand(w, pc);
            case "蝙蝠":
                return new Monster.PlanBat(w, pc);
            case "烈焰使者":
                return new Monster.PlanBlaze(w, pc);
            case "洞穴蜘蛛":
                return new Monster.PlanCaveSpider(w, pc);
            case "雞":
                return new Monster.PlanChicken(w, pc);
            case "牛":
                return new Monster.PlanCow(w, pc);
            case "苦力怕":
                return new Monster.PlanCreeper(w, pc);
            case "驢":
                return new Monster.PlanDonkey(w, pc);
            case "遠古深海守衛":
                return new Monster.PlanElderGuardian(w, pc);
            case "終界龍":
                return new Monster.PlanEnderDragon(w, pc);
            case "終界使者":
                return new Monster.PlanEnderman(w, pc);
            case "終界蟎":
                return new Monster.PlanEndermite(w, pc);
            case "喚魔者":
                return new Monster.PlanEvoker(w, pc);
            case "地獄幽靈":
                return new Monster.PlanGhast(w, pc);
            case "巨人":
                return new Monster.PlanGiant(w, pc);
            case "深海守衛":
                return new Monster.PlanGuardian(w, pc);
            case "馬":
                return new Monster.PlanHorse(w, pc);
            case "屍殼":
                return new Monster.PlanHusk(w, pc);
            case "幻術師":
                return new Monster.PlanIllager(w, pc);
            case "鐵魔像":
                return new Monster.PlanIronGolem(w, pc);
            case "羊駝":
                return new Monster.PlanLlama(w, pc);
            case "熔岩史萊姆":
                return new Monster.PlanMagmaCube(w, pc);
            case "騾":
                return new Monster.PlanMule(w, pc);
            case "蘑菇牛":
                return new Monster.PlanMushroomCow(w, pc);
            case "野貓":
                return new Monster.PlanOcelot(w, pc);
            case "鸚鵡":
                return new Monster.PlanParrot(w, pc);
            case "豬":
                return new Monster.PlanPig(w, pc);
            case "殭屍豬人":
                return new Monster.PlanPigZombie(w, pc);
            case "北極熊":
                return new Monster.PlanPolarBear(w, pc);
            case "兔":
                return new Monster.PlanRabbit(w, pc);
            case "綿羊":
                return new Monster.PlanSheep(w, pc);
            case "蠹魚":
                return new Monster.PlanSilverfish(w, pc);
            case "骷髏":
                return new Monster.PlanSkeleton(w, pc);
            case "骷髏馬":
                return new Monster.PlanSkeletonHorse(w, pc);
            case "史萊姆":
                return new Monster.PlanSlime(w, pc);
            case "雪人":
                return new Monster.PlanSnowman(w, pc);
            case "蜘蛛":
                return new Monster.PlanSpider(w, pc);
            case "烏賊":
                return new Monster.PlanSquid(w, pc);
            case "流髑":
                return new Monster.PlanStray(w, pc);
            case "惱鬼":
                return new Monster.PlanVex(w, pc);
            case "村民":
                return new Monster.PlanVillager(w, pc);
            case "衛道士":
                return new Monster.PlanVindicator(w, pc);
            case "女巫":
                return new Monster.PlanWitch(w, pc);
            case "凋零怪":
                return new Monster.PlanWither(w, pc);
            case "凋零怪骷髏":
                return new Monster.PlanWitherSkeleton(w, pc);
            case "狼":
                return new Monster.PlanWolf(w, pc);
            case "殭屍":
                return new Monster.PlanZombie(w, pc);
            case "殭屍馬":
                return new Monster.PlanZombieHorse(w, pc);
            case "殭屍村民":
                return new Monster.PlanZombieVillager(w, pc);
            case "人類":
                return new Monster.PlanHuman(w, pc);
            default:
                return new Monster.PlanArmorStand(w, pc);
        }
    }

    public static void register() {
        for (MonsterType e : values()) {
            if ((e.c.getModifiers() & 1024) == 1024) {
                throw new RuntimeException("無效的 abstract class ：" + e.c);
            } else {
                MinecraftKey minecraftkey = new MinecraftKey(e.name);
                EntityTypes.b.a(e.id, minecraftkey, e.c);
                EntityTypes.d.add(minecraftkey);
            }
        }
    }
}