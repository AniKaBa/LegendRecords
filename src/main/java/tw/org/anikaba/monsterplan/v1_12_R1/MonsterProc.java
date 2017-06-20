package tw.org.anikaba.monsterplan.v1_12_R1;

public class MonsterProc {

    public static void a(MonsterPlan p, List<Float> l) {
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
        p.setExp((int) f);
    }

    public static int f(PlanMonster p, List<String> l) {
        if (l == null) return 2;
        final int[] j = {2};
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
            }
        });
        return j[0];
    }

    public static void s(PlanMonster p, List<String> l, int i) {
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
                    p.goalSelector.a(j[0], new GoalPlanFireball(p));
                    j[0]++;
                    break;
            }
        });
    }

    public static void s(String s, PlanMonster m) {
        EntityLiving e;
        switch (s) {
            case "洞穴蜘蛛":
                e = new EntityCaveSpider(m.world);
                break;
            case "雞":
                e = new EntityChicken(m.world);
                break;
            case "牛":
                e = new EntityCow(m.world);
                break;
            case "驢":
                e = new EntityHorseDonkey(m.world);
                break;
            case "終界蟎":
                e = new EntityEndermite(m.world);
                break;
            case "馬":
                e = new EntityHorse(m.world);
                break;
            case "鐵魔像":
                e = new EntityIronGolem(m.world);
                break;
            case "羊駝":
                e = new EntityLlama(m.world);
                break;
            case "騾":
                e = new EntityHorseMule(m.world);
                break;
            case "蘑菇牛":
                e = new EntityMushroomCow(m.world);
                break;
            case "野貓":
                e = new EntityOcelot(m.world);
                break;
            case "豬":
                e = new EntityPig(m.world);
                break;
            case "北極熊":
                e = new EntityPolarBear(m.world);
                break;
            case "綿羊":
                e = new EntitySheep(m.world);
                break;
            case "蠹魚":
                e = new EntitySilverfish(m.world);
                break;
            case "骷髏":
                e = new EntitySkeleton(m.world);
                break;
            case "骷髏馬":
                e = new EntityHorseSkeleton(m.world);
                break;
            case "蜘蛛":
                e = new EntitySpider(m.world);
                break;
            case "狼":
                e = new EntityWolf(m.world);
                break;
            case "殭屍馬":
                e = new EntityHorseZombie(m.world);
                break;
            default:
                return;
        }
        e.setPositionRotation(m.locX, m.locY, m.locZ, m.yaw, 0.0F);
        m.world.addEntity(e);
        m.startRiding(e);
    }
}