package spn_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClassInfoDAO {
	
	static Connection conn = null;
	static ResultSet rs = null;
	
	public ArrayList<ClassInfo> getClassesByProf(String pname){

		ArrayList<ClassInfo> classList = new ArrayList<ClassInfo>();
		conn = ConnectionManager.getConnection();
		String sql = "select * from class, course where course.c_id = class.c_id and exists "
				+ "(select c_id from professor, teaching where p_name = '" + pname + "')";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				ClassInfo cInfo = new ClassInfo();
				cInfo.setCid(rs.getString("c_id"));
				cInfo.setBuilding(rs.getString("building"));
				cInfo.setCapacity(Integer.parseInt(rs.getString("capacity")));
				cInfo.setDeptid(rs.getString("dept_id"));
				cInfo.setEnd(rs.getString("end_time"));
				cInfo.setStart(rs.getString("start_time"));
				cInfo.setProfName("Yvette Buchana");
				cInfo.setSem(Long.parseLong(rs.getString("semester")));
				cInfo.setRoomNum(Integer.parseInt(rs.getString("room_num")));
				cInfo.setCourseName(rs.getString("c_name"));;
				classList.add(cInfo);
			}
		}
		catch (Exception ex){
			System.out.println(ex);
		}

		return classList;
	}

}
