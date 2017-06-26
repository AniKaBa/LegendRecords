package tw.org.anikaba.monsterplan;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tw.org.anikaba.legend.monster.Plan;

import java.util.Objects;

public class PlanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command c, String s, String[] ss) {
        if (!cs.hasPermission("anikaba.plan")) return false;
        if (ss.length == 0 && cs instanceof Player) {
            ((Player) cs).sendRawMessage("/cp id [編號]：在你的位置上呼叫一隻該編號的怪物。");
            ((Player) cs).sendRawMessage("/cp bc：顯示此地的區域名稱與會出現的怪物。");
            ((Player) cs).sendRawMessage("/cp t：測試用。");
        }
        if (ss.length == 1 && cs instanceof Player && Objects.equals(ss[0], "bc")) {
            String n = Plan.getChunkName(((Player) cs).getEyeLocation().getChunk());
            ((Player) cs).sendRawMessage("此地區塊：" + n);
            String s1 = "無";
            if (Plan.isArea(n)) {
                s1 = Plan.getCod(n);
            }
            ((Player) cs).sendRawMessage("目前置入怪物：" + s1);
        }
        if (ss.length == 1 && cs instanceof Player && Objects.equals(ss[0], "t")) {
            Location l = ((Player) cs).getLocation();
        }
        if (ss.length == 2 && cs instanceof Player && Objects.equals(ss[0], "id")) {
            Location l = ((Player) cs).getLocation();
            Plan.spawnMonster(l, ss[1]);
        }
        return false;
    }
}