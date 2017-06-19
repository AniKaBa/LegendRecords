package tw.org.anikaba.monsterplan.v1_12_R1;


import net.minecraft.server.v1_12_R1.EntityTypes;
import net.minecraft.server.v1_12_R1.MinecraftKey;

public enum MonsterType {

    木頭人("木頭人", 30, PlanMonster.PlanArmorStand.class),
    蝙蝠("蝙蝠", 65, PlanMonster.PlanBat.class),
    烈焰使者("烈焰使者", 61, PlanMonster.PlanBlaze.class),
    洞穴蜘蛛("洞穴蜘蛛", 59, PlanMonster.PlanCaveSpider.class),
    雞("雞", 93, PlanMonster.PlanChicken.class),
    牛("牛", 92, PlanMonster.PlanCow.class),
    苦力怕("苦力怕", 50, PlanMonster.PlanCreeper.class),
    驢("驢", 31, PlanMonster.PlanDonkey.class),
    遠古深海守衛("遠古深海守衛", 4, PlanMonster.PlanElderGuardian.class),
    終界龍("終界龍", 63, PlanMonster.PlanEnderDragon.class),
    終界使者("終界使者", 58, PlanMonster.PlanEnderman.class),
    終界蟎("終界蟎", 67, PlanMonster.PlanEndermite.class),
    喚魔者("喚魔者", 34, PlanMonster.PlanEvoker.class),
    地獄幽靈("地獄幽靈", 56, PlanMonster.PlanGhast.class),
    巨人("巨人", 53, PlanMonster.PlanGiant.class),
    深海守衛("深海守衛", 68, PlanMonster.PlanGuardian.class),
    馬("馬", 100, PlanMonster.PlanHorse.class),
    屍殼("屍殼", 23, PlanMonster.PlanHusk.class),
    幻術師("幻術師", 37, PlanMonster.PlanIllager.class),
    鐵魔像("鐵魔像", 99, PlanMonster.PlanIronGolem.class),
    羊駝("羊駝", 103, PlanMonster.PlanLlama.class),
    熔岩史萊姆("熔岩史萊姆", 62, PlanMonster.PlanMagmaCube.class),
    騾("騾", 32, PlanMonster.PlanMule.class),//
    蘑菇牛("蘑菇牛", 96, PlanMonster.PlanMushroomCow.class),
    野貓("野貓", 98, PlanMonster.PlanOcelot.class),
    鸚鵡("鸚鵡", 105, PlanMonster.PlanParrot.class),
    豬("豬", 90, PlanMonster.PlanPig.class),
    殭屍豬人("殭屍豬人", 57, PlanMonster.PlanPigZombie.class),
    北極熊("北極熊", 102, PlanMonster.PlanPolarBear.class),
    兔("兔", 101, PlanMonster.PlanRabbit.class),
    綿羊("綿羊", 91, PlanMonster.PlanSheep.class),
    蠹魚("蠹魚", 60, PlanMonster.PlanSilverfish.class),
    骷髏("骷髏", 51, PlanMonster.PlanSkeleton.class),
    骷髏馬("骷髏馬", 28, PlanMonster.PlanSkeletonHorse.class),
    史萊姆("史萊姆", 55, PlanMonster.PlanSlime.class),
    雪人("雪人", 97, PlanMonster.PlanSnowman.class),
    蜘蛛("蜘蛛", 52, PlanMonster.PlanSpider.class),
    烏賊("烏賊", 94, PlanMonster.PlanSquid.class),//
    流髑("流髑", 6, PlanMonster.PlanStray.class),
    惱鬼("惱鬼", 35, PlanMonster.PlanVex.class),
    村民("村民", 120, PlanMonster.PlanVillager.class),
    衛道士("衛道士", 36, PlanMonster.PlanVindicator.class),
    女巫("女巫", 66, PlanMonster.PlanWitch.class),
    凋零怪("凋零怪", 64, PlanMonster.PlanWither.class),
    凋零怪骷髏("凋零怪骷髏", 5, PlanMonster.PlanWitherSkeleton.class),
    狼("狼", 95, PlanMonster.PlanWolf.class),
    殭屍("殭屍", 54, PlanMonster.PlanZombie.class),
    殭屍馬("殭屍馬", 29, PlanMonster.PlanZombieHorse.class),
    殭屍村民("殭屍村民", 27, PlanMonster.PlanZombieVillager.class),
    人類("人類", 54, PlanMonster.PlanHuman.class);

    private String name;
    private int id;
    private Class<? extends PlanMonster> c;

    MonsterType(String n, int d, Class<? extends PlanMonster> c) {
        this.name = n;
        this.id = d;
        this.c = c;
    }
/*
    public PlanMonster getMonster (World w, PlanConfig pc) {
        switch (name) {
            case "木頭人":
                return new CannibalArmorStand(w, pc);
            case "蝙蝠":
                return new CannibalBat(w, pc);
            case "烈焰使者":
                return new CannibalBlaze(w, pc);
            case "洞穴蜘蛛":
                return new CannibalCaveSpider(w, pc);
            case "雞":
                return new CannibalChicken(w, pc);
            case "牛":
                return new CannibalCow(w, pc);
            case "苦力怕":
                return new CannibalCreeper(w, pc);
            case "驢":
                return new CannibalDonkey(w, pc);
            case "遠古深海守衛":
                return new CannibalElderGuardian(w, pc);
            case "終界龍":
                return new CannibalEnderDragon(w, pc);
            case "終界使者":
                return new CannibalEnderman(w, pc);
            case "終界蟎":
                return new CannibalEndermite(w, pc);
            case "喚魔者":
                return new CannibalEvoker(w, pc);
            case "地獄幽靈":
                return new CannibalGhast(w, pc);
            case "巨人":
                return new CannibalGiant(w, pc);
            case "深海守衛":
                return new CannibalGuardian(w, pc);
            case "馬":
                return new CannibalHorse(w, pc);
            case "屍殼":
                return new CannibalHusk(w, pc);
            case "幻術師":
                return new CannibalIllager(w, pc);
            case "鐵魔像":
                return new CannibalIronGolem(w, pc);
            case "羊駝":
                return new CannibalLlama(w, pc);
            case "熔岩史萊姆":
                return new CannibalMagmaCube(w, pc);
            case "騾":
                return new CannibalMule(w, pc);
            case "蘑菇牛":
                return new CannibalMushroomCow(w, pc);
            case "野貓":
                return new CannibalOcelot(w, pc);
            case "鸚鵡":
                return new CannibalParrot(w, pc);
            case "豬":
                return new CannibalPig(w, pc);
            case "殭屍豬人":
                return new CannibalPigZombie(w, pc);
            case "北極熊":
                return new CannibalPolarBear(w, pc);
            case "兔":
                return new CannibalRabbit(w, pc);
            case "綿羊":
                return new CannibalSheep(w, pc);
            case "蠹魚":
                return new CannibalSilverfish(w, pc);
            case "骷髏":
                return new CannibalSkeleton(w, pc);
            case "骷髏馬":
                return new CannibalSkeletonHorse(w, pc);
            case "史萊姆":
                return new CannibalSlime(w, pc);
            case "雪人":
                return new CannibalSnowman(w, pc);
            case "蜘蛛":
                return new CannibalSpider(w, pc);
            case "烏賊":
                return new CannibalSquid(w, pc);
            case "流髑":
                return new CannibalStray(w, pc);
            case "惱鬼":
                return new CannibalVex(w, pc);
            case "村民":
                return new CannibalVillager(w, pc);
            case "衛道士":
                return new CannibalVindicator(w, pc);
            case "女巫":
                return new CannibalWitch(w, pc);
            case "凋零怪":
                return new CannibalWither(w, pc);
            case "凋零怪骷髏":
                return new CannibalWitherSkeleton(w, pc);
            case "狼":
                return new CannibalWolf(w, pc);
            case "殭屍":
                return new CannibalZombie(w, pc);
            case "殭屍馬":
                return new CannibalZombieHorse(w, pc);
            case "殭屍村民":
                return new CannibalZombieVillager(w, pc);
            case "人類":
                return new CannibalHuman(w, pc);
            default:
                return new CannibalHuman(w, pc);
        }
    }
*/
    public static void register() {
        for (MonsterType e : values()) {
            EntityTypes.b.a(e.id, new MinecraftKey(e.name), e.c);
        }
    }
}