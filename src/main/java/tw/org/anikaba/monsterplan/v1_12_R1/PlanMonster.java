package tw.org.anikaba.monsterplan.v1_12_R1;

import net.minecraft.server.v1_12_R1.EntityMonster;
import net.minecraft.server.v1_12_R1.World;
import tw.org.anikaba.monsterplan.PlanConfig;

abstract class PlanMonster extends EntityMonster {

    PlanMonster(World world, PlanConfig pc) {
        super(world);
    }
}