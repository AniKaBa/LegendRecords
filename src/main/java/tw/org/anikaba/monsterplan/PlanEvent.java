package tw.org.anikaba.monsterplan;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

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
                ((LivingEntity)e.getHitEntity()).damage(r.nextInt((int) (Plan.getMonster(
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
        if (e.getEntity() instanceof Monster && Plan.isCannibal((Monster) e.getEntity())) {
            String s = Plan.getMonster((Monster) e.getEntity()).getCod();
            Plan.getPlanConfig(s).getDrops().forEach(i -> e.getDrops().add(i));
        }
    }
}