package in.ineuron.vo;


public class EmployeeVO {
	
	private String srNo;
	private String empNo;
	private String empName;
	private String job;
	private String sal;
	private String deptNo;
	private String mgrNo;
	
	
	public String getsNo() {
		return srNo;
	}

	public void setsNo(String sNo) {
		this.srNo = sNo;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getMgrNo() {
		return mgrNo;
	}

	public void setMgrNo(String mgrNo) {
		this.mgrNo = mgrNo;
	}

	@Override
	public String toString() {
		return "EmployeeVO [sNo=" + srNo + ", empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", sal=" + sal
				+ ", deptNo=" + deptNo + ", mgrNo=" + mgrNo + "]";
	}
	
}	
