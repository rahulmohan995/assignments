package com.qainfotech.tatocmaven;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	App test = new App();
	
	@Test
	public void testChooseBasicCourse() {
		test.ChooseBasicCourse();
		Assert.assertTrue(test.CurrentLink().contains("grid/gate"));
	}
	
	@Test(dependsOnMethods="testChooseBasicCourse")
	public void testgridgate() {
		test.gridgate();
		Assert.assertTrue(test.CurrentLink().contains("dungeon"));
	}
	
	@Test(dependsOnMethods="testgridgate")
	public void testframedungeon() {
		test.framedungeon();
		Assert.assertTrue(test.CurrentLink().contains("basic/drag"));
	}
	
	@Test(dependsOnMethods="testframedungeon")
	public void testbasicdrag() {
		test.basicdrag();
		Assert.assertTrue(test.CurrentLink().contains("basic/windows"));
	}
	
	@Test(dependsOnMethods="testbasicdrag")
	public void testwindows() {
		test.windows();
		Assert.assertTrue(test.CurrentLink().contains("basic/cookie"));
	}
	@Test(dependsOnMethods="testwindows")
	public void testcookie() {
		test.cookie();
		Assert.assertTrue(test.CurrentLink().contains("tatoc/end"));
	}
}
