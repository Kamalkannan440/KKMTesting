package Testcases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMreports {
	
	public static void generateJVMreport(String jsonpath){
		File f = new File("C:\\Users\\TWINUser-08\\eclipse-workspace\\Automation_6D\\Reports\\JVMReport");
		Configuration config=new Configuration(f, "Test Report");
		config.addClassifications("Project Name","KRION6D");
		config.addClassifications("Browser Name", "Chrome");
		config.addClassifications("Release version","1.0.0");
		List<String> list= new ArrayList<String>();
		list.add(jsonpath);
		ReportBuilder report= new ReportBuilder(list, config);
		report.generateReports();
	}
}

