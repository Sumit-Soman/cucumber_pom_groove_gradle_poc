package steps.sanity

import driver.DriverFactory
import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable
import static org.junit.Assert.assertTrue;

def searchCreativePermissionsPage=new SearchCreativePermissionsPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();

When(~/^user click on Export to excel link on Search Creative Permission Page$/) {
	-> searchCreativePermissionsPage.exportToExcel()
}

Then(~/^excel report is saved on local user machine$/){
	-> searchCreativePermissionsPage.verifyCreativePermissionFile()
}

Then(~/^verify the records count in excel sheet$/) { ->
	searchCreativePermissionsPage.verifyExcelCount()
}

// Verify Pagination and working
Then(~/^verify Pagination is present on the Search Creative Permission Page$/) {
	-> def boolean status =utility.isDisplayed(locatorTypeObj.classtype, "paginateButtons")
	   assertTrue("Pagination not found on Search DNIS Group Page.", status==true)
}

When(~/^user click on Next button on Pagination on Creative Permission Page$/) {
	-> utility.clickElement(locatorTypeObj.classtype, "nextLink")
}

Then(~/^user is navigated to next Search Creative Permission Result Page$/) { ->
	utility.sleep(3000)
	def String pageCount = utility.getText(locatorTypeObj.classtype, "currentStep")
	
	assertTrue("Pagination is not working on Search Creative Page.", pageCount.equalsIgnoreCase("2"))
}

Given(~/^user is on Search Creative Permissions Page$/) {->
	 utility.openPage("//ul[@class=\"megamenu\"]/li[1]","Creative Permissions")
}

Given(~/^user enters media type, product, show, region and Agency on Search Creative Permissions Page$/) { DataTable enterValues 
	-> searchCreativePermissionsPage.enterMediaTypeProductShowRegionAgency(enterValues) 
}

When(~/^user clicks on search button on Search Creative Permissions Page$/) { -> 
	if(SeleniumUtility.Internal) { 
		utility.clickElement(locatorTypeObj.id, "searchCreative")
	} else {
		utility.clickElement(locatorTypeObj.xpath,"//*[@id=\"pageBody\"]/div[2]/div/form/div[1]/div/div/div[16]/div/input[1]") 
	}
}

Then(~/^user finds the required creatives by media type, product, show, region and Agency on Search Creative Permissions Page$/) { DataTable resultValues
	 ->searchCreativePermissionsPage.verifyMediaTypeProductShowRegionAgency(resultValues)
}