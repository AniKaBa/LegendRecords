package tw.org.anikaba.monsterplan;

import com.kunyihua.crafte.GlobalVar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import tw.org.anikaba.legend.monster.Plan;

import java.util.Random;

public class PlanEvent implements Listener {

    @EventHandler
    public void onJoin (PlayerInteractEntityEvent e) {
    }

    @EventHandler
    public void onHit (ProjectileHitEvent e) {
        if (e.getEntity().getShooter() instanceof Monster && e.getHitEntity() instanceof
                LivingEntity) {
            if (Plan.isCannibal((Monster) e.getEntity().getShooter())) {
                Random r = new Random();
                ((LivingEntity)e.getHitEntity()).damage(r.nextInt((int) (Plan.getPlanMonster(
                        (Monster) e.getEntity()).getAtkDam() * 100.0F)) / 100.0F);
            }
        }
    }

    @EventHandler
    public void onSpawn (EntitySpawnEvent e) {
        if (e.getEntityType() != EntityType.ZOMBIE) return;
        if (!Plan.isArea(e.getLocation().getChunk())) return;
        Plan.spawnMonster(e.getLocation(), Plan.getCod(e.getLocation().getChunk()));
        e.setCancelled(true);
    }

    @EventHandler
    public void onDeath (EntityDeathEvent e) {
        if (e.getEntity() instanceof Monster && Plan.isCannibal((Monster) e.getEntity()) &&
                Plan.isKycraft()) {
            String s = Plan.getPlanMonster((Monster) e.getEntity()).getMpId();
            Plan.getPlanConfig(s).getDrop().forEach(i -> e.getDrops().add(
                    GlobalVar.GetItemByKey(s)));
        }
    }
}