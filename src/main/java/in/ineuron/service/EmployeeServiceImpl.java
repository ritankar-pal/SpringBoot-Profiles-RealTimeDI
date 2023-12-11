package in.ineuron.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import in.ineuron.bo.EmployeeBO;
import in.ineuron.dao.IEmployeeDao;
import in.ineuron.dto.EmployeeDTO;


@Component(value = "empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String[] desgs) throws Exception {
		
		StringBuilder builder = new StringBuilder("(");
		
		for (int i = 0; i < desgs.length; i++) {
			
			if(i == desgs.length - 1)
				builder.append("'" + desgs[i] + "' )");
			else
				builder.append("'" + desgs[i] + "',");
		}
		
		//Converting the StringBuilder object to string::
		String condn = builder.toString();
		
		List<EmployeeBO> listBO = dao.getEmpsByDesg(condn);
		
		List<EmployeeDTO> listDTO = new ArrayList<EmployeeDTO>();
		
		listBO.forEach(elem -> {
			
			EmployeeDTO empDTO = new EmployeeDTO();
			
			BeanUtils.copyProperties(elem, empDTO); 
			empDTO.setSrNo(listDTO.size() + 1); 
			
			listDTO.add(empDTO);
//			System.out.println(empDTO);
		});
		
		return listDTO;
	}

}
