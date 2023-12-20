package com.demoBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demoBanking.tests.BaseTest;

public class Reporting extends TestListenerAdapter{
	
	public ExtentSparkReporter sparkRep;
	public ExtentReports extentRep;
	public ExtentTest extentTest;
//	BaseTest bs = new BaseTest();
	
	 @Override
	  public void onStart(ITestContext testContext) {
		 
		 String timestamp = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		 String repName = "TestReport"+timestamp+".html";
		 sparkRep = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
//		 try {
//			sparkRep.loadXMLConfig("/extentconfig.xml");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
		 extentRep = new ExtentReports();
		 extentRep.attachReporter(sparkRep);
		 extentRep.setSystemInfo("Host name", "localhost");
		 extentRep.setSystemInfo("Env", "QA");
		 extentRep.setSystemInfo("User", "hari");
		 
		 sparkRep.config().setDocumentTitle("demoBanking project");
		 sparkRep.config().setReportName("Login Test Report");
		 sparkRep.config().setTheme(Theme.DARK);

	  }
	 
	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  
		  extentTest = extentRep.createTest(tr.getName());// create new entry in the report
		  extentTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	  
	  }
	  
	  @Override
	  public void onTestFailure(ITestResult tr) {
//			try {
//				bs.captureScreenshot(tr.getName());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		  extentTest = extentRep.createTest(tr.getName());
		  extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		  String screenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
		  
		  File file = new File(screenshotPath);
		  if(file.exists()) {
				  extentTest.fail("screenshot: "+extentTest.addScreenCaptureFromPath(screenshotPath));
		  }
		 
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  
		  extentTest = extentRep.createTest(tr.getName());
		  extentTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
		  
	  }
	  
	  @Override
	  public void onFinish(ITestContext testContext) {
		  extentRep.flush();
	  }

}
