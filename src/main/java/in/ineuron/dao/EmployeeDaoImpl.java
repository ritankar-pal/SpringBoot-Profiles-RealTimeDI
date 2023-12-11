package in.ineuron.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import in.ineuron.bo.EmployeeBO;


@Component(value = "empDao")
public class EmployeeDaoImpl implements IEmployeeDao {
	
	@Autowired
	private DataSource dataSource;
	
	private static final String SQL_SELECT_QUERY = "select empNo, empName, job, sal, deptNo, mgrNo from employee where job in";
	

	@Override
	public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception {
		
		ArrayList<EmployeeBO> listBO = new ArrayList<>();
		
		try(Connection connection = dataSource.getConnection(); 
				PreparedStatement psmt = connection.prepareStatement(SQL_SELECT_QUERY + cond + "order by job")){
			
			ResultSet resultSet = null;
			
			if(psmt != null) {
				resultSet = psmt.executeQuery();
			}
			
			while(resultSet.next()) {
				
				EmployeeBO empBO = new EmployeeBO();
				
				empBO.setEmpNo(resultSet.getInt(1));
				empBO.setEmpName(resultSet.getString(2));
				empBO.setJob(resultSet.getString(3));
				empBO.setSal(resultSet.getDouble(4));
				empBO.setDeptNo(resultSet.getInt(5));
				empBO.setMgrNo(resultSet.getInt(6));
				
				listBO.add(empBO);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return listBO;
	}

}
