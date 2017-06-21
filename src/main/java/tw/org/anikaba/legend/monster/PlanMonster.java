package tw.org.anikaba.legend.monster;


public interface PlanMonster {

    void doSpawn(Location l);

    public String getCustomName();

    public float getAtkDam();

    public float getAtkSpe();

    public float getMaxHealth();

    public float getMovSpe();

    public float getDef();

    public int getExpReward();

    public List<String> getDrops();

    public PlanType getType();

    public String getId();
}