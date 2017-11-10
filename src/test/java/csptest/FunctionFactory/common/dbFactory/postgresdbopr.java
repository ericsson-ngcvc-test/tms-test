package csptest.FunctionFactory.common.dbFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author jiayong.zou
 *
 */
public class postgresdbopr {
	public postgresdbopr() {
		// TODO Auto-generated constructor stub
	}

	public static String selectdb(String dburl, String username, String password, String oprsql) {
		Connection conn = getConn(dburl, username, password);
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(oprsql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ResultSet rs = null;
		StringBuilder result = new StringBuilder();
		try {
			rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					String columnname = rs.getMetaData().getColumnLabel(i);
					String columnvalue = rs.getString(i);
					if (i < col) {
						result.append(columnname).append(":").append(columnvalue).append(",");
					} else {
						result.append(columnname).append(":").append(columnvalue);
					}

				}
				result.append("\n");
			}
			return result.toString();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result.toString();

	}

	public static boolean insertdb(String dburl, String username, String password, String oprsql) {
		Connection conn = getConn(dburl, username, password); 
			int i = 0;  
	         PreparedStatement pstmt;  
	        try {  
	            pstmt = (PreparedStatement) conn.prepareStatement(oprsql);  
	          i=  pstmt.executeUpdate();        
	            pstmt.close();  
	            conn.close();  
	            if(i>=1){
	            	return true;
	            }else{
	            	return false;
	            }	            
	            
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return false;  	
		
		}
	
	public static boolean updatedb(String dburl, String username, String password, String oprsql) {
		Connection conn = getConn(dburl, username, password); 
			int i = 0;  
	         PreparedStatement pstmt;  
	        try {  
	            pstmt = (PreparedStatement) conn.prepareStatement(oprsql);  
	          i=  pstmt.executeUpdate();        
	            pstmt.close();  
	            conn.close();  
	            if(i>=1){
	            	return true;
	            }else{
	            	return false;
	            }	            
	            
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return false;  	
		
		}
	public static boolean deletedb(String dburl, String username, String password, String oprsql) {
		Connection conn = getConn(dburl, username, password); 
			int i = 0;  
	         PreparedStatement pstmt;  
	        try {  
	            pstmt = (PreparedStatement) conn.prepareStatement(oprsql);  
	          i=  pstmt.executeUpdate();        
	            pstmt.close();  
	            conn.close();  
	            if(i>=1){
	            	return true;
	            }else{
	            	return false;
	            }	            
	            
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return false;  	
		
		}
	
	
	public static Connection getConn(String dburl, String username, String passwrod) {
		String driver = "org.postgresql.Driver";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,driver
			conn = (Connection) DriverManager.getConnection(dburl, username, passwrod);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void main(String[] args) {
		String dburl = "jdbc:postgresql://172.21.36.168:5432/tscdb";
		String username = "tscdba";
		String password = "tscdba";
		String  selectsql = "select * from tsc_vehicle_profile where vin='DECO20140120DECO1'";
		String	insertsql="insert into test(name,sex)values ('zhangshan',5)";
		String  updatesql="update test set name='zhangwu' where name='zhangshan'";
		String  deletesql="delete from test where name='zhangwu'";
		//String selectresult = postgresdbopr.selectdb(dburl, username, password, selectsql);
		//boolean insertresult=postgresdbopr.insertdb(dburl, username, password, insertsql);
		//boolean updaterusult=postgresdbopr.insertdb(dburl, username, password, updatesql);
	   boolean deleteresult=postgresdbopr.insertdb(dburl, username, password, deletesql);
	  //output
	   // System.out.println(selectsql+"\t"+selectresult);
	  // System.out.println(insertsql+"\t"+insertresult); 
	  // System.out.println(updatesql+"\t"+updaterusult);
		System.out.println(deletesql+"\t"+deleteresult);

	}

}
