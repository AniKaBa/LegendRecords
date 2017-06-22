package tw.org.anikaba.monsterplan.v1_12_R1;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import tw.org.anikaba.monsterplan.PlanConfig;

import java.util.UUID;

public class MonsterPlayer extends EntityPlayer {

    public MonsterPlayer(WorldServer ws, Location l, PlanConfig pc) {
        super(m(), w(l), g(), new PlayerInteractManager(ws));
    }

    private static MinecraftServer m() {
        return ((CraftServer) Bukkit.getServer()).getServer();
    }

    private static GameProfile g() {
        return new GameProfile(UUID.randomUUID(), "Npc");
    }

    private static WorldServer w(Location l) {
        return ((CraftWorld) l.getWorld()).getHandle();
    }
}