package in.ineuron.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.dto.EmployeeDTO;
import in.ineuron.service.IEmployeeService;
import in.ineuron.vo.EmployeeVO;


@Component(value = "empController")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	public List<EmployeeVO> showEmpsByDesgs(String[] desgs) throws Exception{
		
		//Use Service::
		List<EmployeeDTO> listDTO = service.fetchEmpsByDesgs(desgs);
		
		
		List<EmployeeVO> listVO = new ArrayList<>();
		
		//convert listDTO received from service to EmployeeVO as listVO::
		listDTO.forEach(emp -> {
			
			EmployeeVO empVO = new EmployeeVO();
			empVO.setsNo(String.valueOf(emp.getSrNo()));
			empVO.setEmpNo(String.valueOf(emp.getEmpNo()));
			empVO.setEmpName(emp.getEmpName());
			empVO.setJob(emp.getJob());
			empVO.setSal(emp.getSal().toString());
			empVO.setDeptNo(emp.getDeptNo().toString());
			empVO.setMgrNo(emp.getMgrNo().toString());
			
			listVO.add(empVO);
			
		});
		
		return listVO;
	}
	
}
