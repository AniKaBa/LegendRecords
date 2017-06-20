package tw.org.anikaba.legend.monster;

public class Plan {

    private Map<String, PlanConfig> plan = new HashMap<>();
    private Map<String, String> planM = new HashMap<>();
    private Boolean k = true;
    private Cannibal c;

    public void onEnable() {
        runCommand();
        runEvents();
        runOther();
    }

    private void runCommand() {
        getCommand("cp").setExecutor(new PlanCommand());
    }

    private void runEvents() {
        getServer().getPluginManager().registerEvents(new PlanEvent(), this);
    }

    private void runOther() {
        switch (Bukkit.getBukkitVersion()) {
            case "1.12-R0.1-SNAPSHOT":
                this.c = new tw.org.anikaba.monster.v1_12_R1.CannibalDevice();
                tw.org.anikaba.monster.v1_12_R1.MonsterType.register();
                break;
            case "1.11.2-R0.1-SNAPSHOT":
                this.c = new tw.org.anikaba.monster.v1_11_R1.CannibalDevice();
                tw.org.anikaba.monster.v1_11_R1.MonsterType.register();
                break;
            case "1.10.2-R0.1-SNAPSHOT":
                this.c = new tw.org.anikaba.monster.v1_10_R1.CannibalDevice();
                tw.org.anikaba.monster.v1_10_R1.MonsterType.register();
                break;
            case "1.9.4-R0.1-SNAPSHOT":
                this.c = new tw.org.anikaba.monster.v1_9_R2.CannibalDevice();
                tw.org.anikaba.monster.v1_9_R2.MonsterType.register();
                break;
            default:
                System.out.print("[怪物計劃] 執行失敗！");
                Bukkit.shutdown();
                break;
        }
        new PlanConfig("ch-001").save();
        File f = new File("plugins/LegendRecords/Monster/");
        Arrays.asList(f.list()).forEach(s ->{
            s = s.replaceAll(".conf", "");
            PlanConfig pc = new  PlanConfig(s);
            plan.put(s, pc);
            if (pc.getBorn() != null) {
                pc.getBorn().forEach(s1 -> planM.put(s1, pc.getId()));
            }
        });
        Plugin p = Bukkit.getPluginManager().getPlugin("Kycraft");
        if (p == null) this.k = false;
    }

    public Map<String, PlanConfig> getPlan(){
        return this.plan;
    }

    public Map<String, String> getPlanM(){
        return this.planM;
    }

    public Boolean getK(){
        return this.k;
    }

    public Cannibal getC(){
        return this.c;
    }

    public static CannibalPlan getPlugin() {
        return (CannibalPlan) Bukkit.getPluginManager().getPlugin
                ("CannibalPlan");
    }
}