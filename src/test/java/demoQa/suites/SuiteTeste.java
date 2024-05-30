package demoQa.suites;

import static demoQa.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import demoQa.tests.TestElements;
import demoQa.tests.TestHome;

@RunWith(Suite.class)
@SuiteClasses({
	TestHome.class,
	TestElements.class,
	
})
public class SuiteTeste {

	@AfterClass
	public static void finaliza() {
		killDriver();
	}
}
