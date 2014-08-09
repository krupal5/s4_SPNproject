package spn_test;

public class ClassInfo {
	
	private int capacity;
	private int room_num = 0;
	private long semester = 0;
	private String start_time = "";
	private String end_time = "";
	private String profName = "";
	private String building = "";
	private String cid = "";
	private String did = "";
	private String courseName = "";

	public int getCid(){
		return Integer.parseInt(cid);
	}
	
	public String getStringCid(){
		return cid;
	}
	
	public int getDeptid(){
		return Integer.parseInt(did);
	}
	
	public String getStringDeptid(){
		return did;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public int getRoomNum(){
		return room_num;
	}
	
	public long getSem(){
		return semester;
	}
	
	public String getBuilding(){
		return building;
	}
	
	public String getStart(){
		return start_time;
	}
	
	public String getEnd(){
		return end_time;
	}
	
	public String getCoursename(){
		return courseName;
	}
	
	public void setCid(String c){
		this.cid = c;
	}
	
	public void setDeptid(String d){
		this.did = d;
	}
	
	public void setCapacity(int cap){
		this.capacity = cap;
	}
	
	public void setRoomNum(int room){
		this.room_num = room;
	}
	
	public void setSem(long sem){
		this.semester = sem;
	}
	
	public void setBuilding(String build){
		this.building = build;
	}
	
	public void setStart(String strt){
		this.start_time = strt;
	}
	
	public void setEnd(String en){
		this.end_time = en;
	}
	
	public void setProfName(String name){
		this.profName = name;
	}
	
	public void setCourseName(String cname){
		this.courseName = cname;
	}
}
