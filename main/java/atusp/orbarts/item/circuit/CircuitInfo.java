package atusp.orbarts.item.circuit;

//回路信息
public class CircuitInfo {
	public String name;
	public String description;
	public int circuitId;
	public int rank;
	public String type;
	
	public int needFire;
	public int needWater;
	public int needWind;
	public int needEarth;
	public int needTime;
	public int needSpace;
	public int needMirage;
	
	public int giveFire;
	public int giveWater;
	public int giveWind;
	public int giveEarth;
	public int giveTime;
	public int giveSpace;
	public int giveMirage;
	
	//public CircuitInfo(){}

	/**
	 * 名称、描述、id(不要重复),等级,属性,需要的火、水、风、土、时、空、幻，提供的火、水、风、土、时、空、幻
	 * @param name
	 * @param description
	 * @param circuitId
	 * @param lv
	 * @param type
	 * @param needFire
	 * @param needWater
	 * @param needWind
	 * @param needEarth
	 * @param needTime
	 * @param needSpace
	 * @param needMirage
	 * @param giveFire
	 * @param giveWater
	 * @param giveWind
	 * @param giveEarth
	 * @param giveTime
	 * @param giveSpace
	 * @param giveMirage
	 */
	public CircuitInfo(String name, String description, int circuitId, int lv,
			String type, int needFire, int needWater, int needWind,
			int needEarth, int needTime, int needSpace, int needMirage,
			int giveFire, int giveWater, int giveWind, int giveEarth,
			int giveTime, int giveSpace, int giveMirage) {
		super();
		this.name = name;
		this.description = description;
		this.circuitId = circuitId;
		this.rank = lv;
		this.type = type;
		this.needFire = needFire;
		this.needWater = needWater;
		this.needWind = needWind;
		this.needEarth = needEarth;
		this.needTime = needTime;
		this.needSpace = needSpace;
		this.needMirage = needMirage;
		this.giveFire = giveFire;
		this.giveWater = giveWater;
		this.giveWind = giveWind;
		this.giveEarth = giveEarth;
		this.giveTime = giveTime;
		this.giveSpace = giveSpace;
		this.giveMirage = giveMirage;
	}
}
