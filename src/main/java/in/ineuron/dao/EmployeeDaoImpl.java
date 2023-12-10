package in.ineuron.dao;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.bo.EmployeeBO;

@Component(value = "empDao")
public class EmployeeDaoImpl implements IEmployeeDao {
	
	@Autowired
	private DataSource dataSource;
	

	@Override
	public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception {
		return null;
	}

}
