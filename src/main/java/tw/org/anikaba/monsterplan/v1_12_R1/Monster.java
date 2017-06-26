package tw.org.anikaba.monsterplan.v1_12_R1;

import net.minecraft.server.v1_12_R1.*;
import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import tw.org.anikaba.monsterplan.PlanConfig;

class Monster {
    // 木頭人
    static class PlanArmorStand extends MonsterPlan {
        PlanArmorStand(World w, PlanConfig pc) {
            super(w, pc);
            this.setSize(0.5F, 1.975F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("木頭人");
        }
        protected SoundEffect F() {
            return SoundEffects.gQ;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.gV;
        }
        protected SoundEffect cf() {
            return SoundEffects.gR;
        }
    }
    // 蝙蝠
    static class PlanBat extends MonsterPlan {
        PlanBat(World w, PlanConfig pc) {
            super(w, pc);
            this.setSize(0.5F, 0.9F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("蝙蝠");
        }
        @Nullable
        public SoundEffect F() {
            return SoundEffects.x;
        }

        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.z;
        }

        protected SoundEffect cf() {
            return SoundEffects.y;
        }
    }
    // 烈焰使者
    static class PlanBlaze extends MonsterPlan {
        PlanBlaze(World w, PlanConfig pc) {
            super(w, pc);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("烈焰使者");
        }
        protected SoundEffect F() {
            return SoundEffects.C;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.F;
        }
        protected SoundEffect cf() {
            return SoundEffects.E;
        }
    }
    // 洞穴蜘蛛
    static class PlanCaveSpider extends MonsterPlan {
        PlanCaveSpider(World w, PlanConfig pc) {
            super(w, pc);
            this.setSize(0.7F, 0.5F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("洞穴蜘蛛");
        }
        protected SoundEffect F() {
            return SoundEffects.hz;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.hB;
        }
        protected SoundEffect cf() {
            return SoundEffects.hA;
        }
    }
    // 雞
    static class PlanChicken extends MonsterPlan {
        PlanChicken(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.4F, 0.7F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("雞");
        }
        protected SoundEffect F() {
            return SoundEffects.ad;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.ag;
        }
        protected SoundEffect cf() {
            return SoundEffects.ae;
        }
    }
    // 牛
    static class PlanCow extends MonsterPlan {
        PlanCow(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.9F, 1.4F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("牛");
        }
        protected SoundEffect F() {
            return SoundEffects.ar;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.at;
        }
        protected SoundEffect cf() {
            return SoundEffects.as;
        }
    }
    // 苦力怕
    static class PlanCreeper extends MonsterPlan {
        PlanCreeper(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.7F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("苦力怕");
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.ax;
        }
        protected SoundEffect cf() {
            return SoundEffects.aw;
        }
    }
    // 驢
    static class PlanDonkey extends MonsterPlan {
        PlanDonkey(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(1.3964844F, 1.6F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("驢");
        }
        protected SoundEffect F() {
            return SoundEffects.aC;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.aG;
        }
        protected SoundEffect cf() {
            return SoundEffects.aF;
        }
    }
    // 遠古深海守衛
    static class PlanElderGuardian extends MonsterPlan {
        PlanElderGuardian(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(1.9975F, 1.9975F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("遠古深海守衛");
        }
        protected SoundEffect F() {
            return this.isInWater() ? SoundEffects.aI : SoundEffects.aJ;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return this.isInWater() ? SoundEffects.aO : SoundEffects.aP;
        }
        protected SoundEffect cf() {
            return this.isInWater() ? SoundEffects.aL : SoundEffects.aM;
        }
    }
    // 終界龍
    static class PlanEnderDragon extends MonsterPlan {
        PlanEnderDragon(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(16.0F, 8.0F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("終界龍");
        }
        protected SoundEffect F() {
            return SoundEffects.aU;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.aZ;
        }
    }
    // 終界使者
    static class PlanEnderman extends MonsterPlan {
        PlanEnderman(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 2.9F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("終界使者");
        }
        protected SoundEffect F() {
            return SoundEffects.bg;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.bf;
        }
        protected SoundEffect cf() {
            return SoundEffects.be;
        }
    }
    // 終界蟎
    static class PlanEndermite extends MonsterPlan {
        PlanEndermite(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.4F, 0.3F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("終界蟎");
        }
        protected SoundEffect F() {
            return SoundEffects.bj;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.bl;
        }
        protected SoundEffect cf() {
            return SoundEffects.bk;
        }
    }
    // 喚魔者
    static class PlanEvoker extends MonsterPlan {
        PlanEvoker(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.95F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("喚魔者");
        }
        protected SoundEffect F() {
            return SoundEffects.bs;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.bv;
        }
        protected SoundEffect cf() {
            return SoundEffects.bu;
        }
    }
    // 地獄幽靈
    static class PlanGhast extends MonsterPlan {
        PlanGhast(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(4.0F, 4.0F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("地獄幽靈");
        }
        protected SoundEffect F() {
            return SoundEffects.cb;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.cd;
        }
        protected SoundEffect cf() {
            return SoundEffects.cc;
        }
    }
    // 巨人
    static class PlanGiant extends MonsterPlan {
        PlanGiant(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(this.width * 6.0F, this.length * 6.0F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("巨人");
        }
    }
    // 深海守衛
    static class PlanGuardian extends MonsterPlan {
        PlanGuardian(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.85F, 0.85F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("深海守衛");
        }
        protected SoundEffect F() {
            return this.isInWater() ? SoundEffects.cw : SoundEffects.cx;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return this.isInWater() ? SoundEffects.cC : SoundEffects.cD;
        }
        protected SoundEffect cf() {
            return this.isInWater() ? SoundEffects.cz : SoundEffects.cA;
        }
    }
    // 馬
    static class PlanHorse extends MonsterPlan {
        PlanHorse(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(1.3964844F, 1.6F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("馬");
        }
        protected SoundEffect F() {
            return SoundEffects.cF;
        }
        protected SoundEffect cf() {
            return SoundEffects.cJ;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.cM;
        }
    }
    // 屍殼
    static class PlanHusk extends MonsterPlan {
        PlanHusk(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.95F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("屍殼");
        }
        protected SoundEffect F() {
            return SoundEffects.cY;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.da;
        }
        protected SoundEffect cf() {
            return SoundEffects.cZ;
        }
    }
    // 幻術師
    static class PlanIllager extends MonsterPlan {
        PlanIllager(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.95F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("幻術師");
        }
        protected SoundEffect F() {
            return SoundEffects.dc;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.df;
        }
        protected SoundEffect cf() {
            return SoundEffects.de;
        }
    }
    // 鐵魔像
    static class PlanIronGolem extends MonsterPlan {
        PlanIronGolem(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(1.4F, 2.7F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("鐵魔像");
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.dl;
        }
        protected SoundEffect cf() {
            return SoundEffects.dk;
        }
    }
    // 羊駝
    static class PlanLlama extends MonsterPlan {
        PlanLlama(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.9F, 1.87F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("羊駝");
        }
        protected SoundEffect F() {
            return SoundEffects.dM;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.dR;
        }
        protected SoundEffect cf() {
            return SoundEffects.dP;
        }
    }
    // 熔岩史萊姆
    static class PlanMagmaCube extends MonsterPlan {
        PlanMagmaCube(World w,  PlanConfig pc) {
            super(w, pc);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("熔岩史萊姆");
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.hj;
        }
        protected SoundEffect cf() {
            return SoundEffects.hi;
        }
    }
    // 騾
    static class PlanMule extends MonsterPlan {
        PlanMule(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(1.3964844F, 1.6F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("騾");
        }
        protected SoundEffect F() {
            return SoundEffects.ej;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.em;
        }
        protected SoundEffect cf() {
            return SoundEffects.el;
        }
    }
    // 蘑菇牛
    static class PlanMushroomCow extends MonsterPlan {
        PlanMushroomCow(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.9F, 1.4F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("蘑菇牛");
        }
        protected SoundEffect F() {
            return SoundEffects.ar;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.at;
        }
        protected SoundEffect cf() {
            return SoundEffects.as;
        }
    }
    // 野貓
    static class PlanOcelot extends MonsterPlan {
        PlanOcelot(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 0.7F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("野貓");
        }
        @Nullable
        protected SoundEffect F() {
            return SoundEffects.Y;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.X;
        }
        protected SoundEffect cf() {
            return SoundEffects.V;
        }
    }
    // 鸚鵡
    static class PlanParrot extends MonsterPlan {
        PlanParrot(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.5F, 0.9F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("鸚鵡");
        }
        protected SoundEffect F() {
            return SoundEffects.eH;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.eL;
        }
        protected SoundEffect cf() {
            return SoundEffects.eI;
        }
    }
    // 豬
    static class PlanPig extends MonsterPlan {
        PlanPig(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.9F, 0.9F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("豬");
        }
        protected SoundEffect F() {
            return SoundEffects.fo;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.fq;
        }
        protected SoundEffect cf() {
            return SoundEffects.fp;
        }
    }
    // 殭屍豬人
    static class PlanPigZombie extends MonsterPlan {
        PlanPigZombie(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.95F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("殭屍豬人");
        }
        protected SoundEffect F() {
            return SoundEffects.js;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.jv;
        }
        protected SoundEffect cf() {
            return SoundEffects.ju;
        }
    }
    // 北極熊
    static class PlanPolarBear extends MonsterPlan {
        PlanPolarBear(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(1.3F, 1.4F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("北極熊");
        }
        protected SoundEffect F() {
            return this.isBaby() ? SoundEffects.fN : SoundEffects.fM;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.fP;
        }
        protected SoundEffect cf() {
            return SoundEffects.fO;
        }
    }
    // 兔
    static class PlanRabbit extends MonsterPlan {
        PlanRabbit(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.4F, 0.5F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("兔");
        }
        protected SoundEffect F() {
            return SoundEffects.fV;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.fY;
        }
        protected SoundEffect cf() {
            return SoundEffects.fX;
        }
    }
    // 綿羊
    static class PlanSheep extends MonsterPlan {
        PlanSheep(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.9F, 1.3F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("綿羊");
        }
        protected SoundEffect F() {
            return SoundEffects.gs;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.gu;
        }
        protected SoundEffect cf() {
            return SoundEffects.gt;
        }
    }
    // 蠹魚
    static class PlanSilverfish extends MonsterPlan {
        PlanSilverfish(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.4F, 0.3F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("蠹魚");
        }
        protected SoundEffect F() {
            return SoundEffects.gM;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.gO;
        }
        protected SoundEffect cf() {
            return SoundEffects.gN;
        }
    }
    // 骷髏
    static class PlanSkeleton extends MonsterPlan {
        PlanSkeleton(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.99F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("骷髏");
        }
        protected SoundEffect F() {
            return SoundEffects.gQ;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.gV;
        }
        protected SoundEffect cf() {
            return SoundEffects.gR;
        }
    }
    // 骷髏馬
    static class PlanSkeletonHorse extends MonsterPlan {
        PlanSkeletonHorse(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(1.3964844F, 1.6F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("骷髏馬");
        }
        protected SoundEffect F() {
            return SoundEffects.gS;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.gU;
        }
        protected SoundEffect cf() {
            return SoundEffects.gT;
        }
    }
    // 史萊姆
    static class PlanSlime extends MonsterPlan {
        PlanSlime(World w,  PlanConfig pc) {
            super(w, pc);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("史萊姆");
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.hm;
        }
        protected SoundEffect cf() {
            return SoundEffects.hl;
        }
    }
    // 雪人
    static class PlanSnowman extends MonsterPlan {
        PlanSnowman(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.7F, 1.9F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("雪人");
        }
        protected SoundEffect F() {
            return SoundEffects.hq;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.hs;
        }
        protected SoundEffect cf() {
            return SoundEffects.hr;
        }
    }
    // 蜘蛛
    static class PlanSpider extends MonsterPlan {
        PlanSpider(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(1.4F, 0.9F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("蜘蛛");
        }
        protected SoundEffect F() {
            return SoundEffects.hz;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.hB;
        }
        protected SoundEffect cf() {
            return SoundEffects.hA;
        }
    }
    // 烏賊
    static class PlanSquid extends MonsterPlan {
        PlanSquid(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.8F, 0.8F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("烏賊");
        }
        protected SoundEffect F() {
            return SoundEffects.hF;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.hH;
        }
        protected SoundEffect cf() {
            return SoundEffects.hG;
        }
    }
    // 流髑
    static class PlanStray extends MonsterPlan {
        PlanStray(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.99F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("流髑");
        }
        protected SoundEffect F() {
            return SoundEffects.hR;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.hT;
        }
        protected SoundEffect cf() {
            return SoundEffects.hS;
        }
    }
    // 惱鬼
    static class PlanVex extends MonsterPlan {
        PlanVex(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.4F, 0.8F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("惱鬼");
        }
        protected SoundEffect F() {
            return SoundEffects.ig;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.ij;
        }
        protected SoundEffect cf() {
            return SoundEffects.ii;
        }
    }
    // 村民
    static class PlanVillager extends MonsterPlan {
        PlanVillager(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.95F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("村民");
        }
        protected SoundEffect F() {
            return SoundEffects.io;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.im;
        }
        protected SoundEffect cf() {
            return SoundEffects.il;
        }
    }
    // 衛道士
    static class PlanVindicator extends MonsterPlan {
        PlanVindicator(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.95F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("衛道士");
        }
        protected SoundEffect F() {
            return SoundEffects.iq;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.is;
        }
        protected SoundEffect cf() {
            return SoundEffects.ir;
        }
    }
    // 女巫
    static class PlanWitch extends MonsterPlan {
        PlanWitch(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.95F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("女巫");
        }
        protected SoundEffect F() {
            return SoundEffects.ix;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.iA;
        }
        protected SoundEffect cf() {
            return SoundEffects.iy;
        }
    }
    // 凋零怪
    static class PlanWither extends MonsterPlan {
        PlanWither(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.9F, 3.5F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("凋零怪");
        }
        protected SoundEffect F() {
            return SoundEffects.iC;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.iF;
        }
        protected SoundEffect cf() {
            return SoundEffects.iE;
        }
    }
    // 凋零怪骷髏
    static class PlanWitherSkeleton extends MonsterPlan {
        PlanWitherSkeleton(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.7F, 2.4F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("凋零怪骷髏");
        }
        protected SoundEffect F() {
            return SoundEffects.iH;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.iJ;
        }
        protected SoundEffect cf() {
            return SoundEffects.iI;
        }
    }
    // 狼
    static class PlanWolf extends MonsterPlan {
        PlanWolf(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 0.85F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("狼");
        }
        protected SoundEffect F() {
            return SoundEffects.iO;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.iQ;
        }
        protected SoundEffect cf() {
            return SoundEffects.iN;
        }
    }
    // 殭屍
    static class PlanZombie extends MonsterPlan {
        PlanZombie(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.95F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("殭屍");
        }
        protected SoundEffect F() {
            return SoundEffects.ji;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.jq;
        }
        protected SoundEffect cf() {
            return SoundEffects.jm;
        }
    }
    // 殭屍馬
    static class PlanZombieHorse extends MonsterPlan {
        PlanZombieHorse(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(1.3964844F, 1.6F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("殭屍馬");
        }
        protected SoundEffect F() {
            return SoundEffects.jn;
        }
        protected SoundEffect d(DamageSource damagesource) {
            return SoundEffects.jp;
        }
        protected SoundEffect cf() {
            return SoundEffects.jo;
        }
    }
    // 殭屍村民
    static class PlanZombieVillager extends MonsterPlan {
        PlanZombieVillager(World w,  PlanConfig pc) {
            super(w, pc);
            this.setSize(0.6F, 1.95F);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("殭屍村民");
        }
        public SoundEffect F() {
            return SoundEffects.jx;
        }
        public SoundEffect d(DamageSource damagesource) {
            return SoundEffects.jB;
        }
        public SoundEffect cf() {
            return SoundEffects.jA;
        }
    }
    // 人類，無實體
    static class PlanHuman extends MonsterPlan {
        PlanHuman(World w,  PlanConfig pc) {
            super(w, pc);
        }
        @Nullable
        protected MinecraftKey J() {
            return new MinecraftKey("人類");
        }
    }
}