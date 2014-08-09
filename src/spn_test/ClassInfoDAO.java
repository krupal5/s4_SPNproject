package spn_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ClassInfoDAO {
	
	static Connection conn = null;
	static ResultSet rs = null;
	
	public ArrayList<ClassInfo> getClassesByProf(){

		ArrayList<ClassInfo> classList = new ArrayList<ClassInfo>();
		conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from class, course where course.c_id = class.c_id " + 
				"and exists (select c_id from professor, teaching where p_name = 'Yvette Buchanan')";

		try{
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				ClassInfo cInfo = new ClassInfo();
				cInfo.setCid(rs.getString("c_id"));
				cInfo.setBuilding(rs.getString("building"));
				cInfo.setCapacity(Integer.parseInt(rs.getString("capacity")));
				cInfo.setDeptid(Integer.parseInt(rs.getString("dept_id")));
				cInfo.setEnd(rs.getString("end_time"));
				cInfo.setStart(rs.getString("start_time"));
				cInfo.setProfName("Yvette Buchana");
				cInfo.setSem(Long.parseLong(rs.getString("semester")));
				cInfo.setRoomNum(Integer.parseInt(rs.getString("room_num")));
				classList.add(cInfo);
			}
		}
		catch (Exception ex){
			System.out.println(ex);
		}

		return classList;
	}

}
