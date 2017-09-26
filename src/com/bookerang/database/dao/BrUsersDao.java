package com.bookerang.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import com.bookerang.database.object.BrUsers;
import com.bookerang.main.BrConstants;

public class BrUsersDao extends BaseDao
{ 
	public static BrUsersDao me=new BrUsersDao();
	public static List<BrUsers> getUser(String email, String password)
	{
		String sql= "select * from " +  BrConstants.DB_Br_UserTable + " where email = UPPER('" + email + "')" + " and password ='" + password +"'" ;
		return(getInstance().getCustomData(sql));
	}
	public static BrUsersDao getInstance()
	{
		return me;
	}
	protected BrUsers createObject(ResultSet rs) throws SQLException {
        BrUsers bu = new BrUsers();
        bu.setUsername(rs.getString("username"));
        bu.setPassword("password");
        bu.setEmail("email");
        
        return bu;
    }

}
