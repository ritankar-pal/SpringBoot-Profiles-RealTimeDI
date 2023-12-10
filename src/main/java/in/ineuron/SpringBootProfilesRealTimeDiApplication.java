package in.ineuron;
import org.springframework.boot.SpringApplication;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import in.ineuron.controller.EmployeeController;
import in.ineuron.vo.EmployeeVO;


@SpringBootApplication
public class SpringBootProfilesRealTimeDiApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootProfilesRealTimeDiApplication.class, args);

		// read inputs from end user::
		Scanner sc = new Scanner(System.in);
		System.out.print("Desgs count:: ");
		int count = sc.nextInt();
		
		String desgs[] = null;
		
		if (count >= 1)
			desgs = new String[count];
		else {
			System.out.println("invalid desg count ");
			return;
		}
		
		//Filling the desgs array with the user input::
		for (int i = 0; i < count; ++i) {
			System.out.print("enter desg" + (i + 1) + ":: ");
			String desg = sc.next();
			desgs[i] = desg;
		}
		
		EmployeeController controller = context.getBean("empController", EmployeeController.class);
		
		try {
			
			List<EmployeeVO> empVOList = controller.showEmpsByDesgs(desgs);
			System.out.println("Employee Details having:: " + Arrays.toString(desgs));
			
			empVOList.forEach(emp ->{
				System.out.println(emp);
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext) context).close();
		sc.close();
	}

}
