package steps

import static cucumber.api.groovy.EN.*
import static org.junit.Assert.assertTrue;
import java.beans.PropertyChangeEvent;
import junit.framework.Assert;
import pages.*
import cucumber.api.DataTable

def searchCreativePage=new SearchCreativePage()
def createCreativePage=new CreativePage();
def searchVendorPage=new SearchVendorPage()
def utility = new SeleniumUtility()
def vendorObj = new VendorPage();
def locatorTypeObj = new LocatorType();


Given(~/^user is on Search Creative Page$/) {
	->	utility.openPage("//ul[@class='megamenu']/li[1]","Creatives")
}

When(~/^user directly clicks on Save button$/){
	-> utility.clickElement(locatorTypeObj.xpath, "//input[@class='cta_button']");
}

Then(~/^user is displayed Alert to fill all required fields$/){
	-> createCreativePage.verifyErrorValidation()
}

Given(~/^user enters media type, product, show, region and Version on Search Creative Page$/) { DataTable enterValues
	->  while (true){
		searchCreativePage.fillSearchCreativeForm(enterValues)
		searchCreativePage.clickSearch()
		def String msg = searchCreativePage.getStatus()
		if(msg.contains('No'))
			utility.clickElement(locatorTypeObj.id, "active")
			msg = searchCreativePage.getStatus()
			if(msg.contains('No')) break
		else break
	}
}

Given(~/^user goes to Create Creative Page$/) { 
	-> utility.clickElement(locatorTypeObj.classtype, "customButton");
}

Given(~/^user enters Media Type, Product, Show, Region, Version and Allowable on Create Creative Page$/) { DataTable enterValues
	-> createCreativePage.createCreative(enterValues)
}

Then(~/^user is displayed message of successful Creation of new Creative$/){
	-> createCreativePage.verifySuccessMessage();
		createCreativePage.getPSVR()
}

Given(~/^user select on DNIS Group tab$/) {
	-> searchCreativePage.clickTabHead("DNIS Group")
}

When(~/^user clicks on Dub Master tab$/) {
	-> searchCreativePage.clickTabHead("Dub Master")
}

When(~/^user adds Master and Sub Master Dub$/) {DataTable enterValues
	-> createCreativePage.addDubMasterAndSub(enterValues)
}

When(~/^user clicks on DNIS Group tab$/) {
	-> searchCreativePage.clickTabHead("DNIS Group")
}

When(~/^user adds DNIS Group$/) {DataTable enterValues
	-> createCreativePage.addDNSGroup(enterValues)
}

When(~/^user clicks on Permissions & Translations tab$/) {
	-> searchCreativePage.clickTabHead("Permissions & Translations")
}

Given(~/^user is on Search Vendor Page$/) {
	->	utility.openPage("//ul[@class='megamenu']/li[1]","Vendors")
	utility.handleWindowAlert()
}

When(~/^user searches for Vendor with vendor Name and Type$/){ DataTable vendorDetails
	-> searchVendorPage.searchExistingAgencyVendor(vendorDetails)
}

Then(~/^user is displayed Vendor Name on Search Vendor page$/){DataTable vendorDetails
	-> searchVendorPage.verifyVendorSearch(vendorDetails)
}

When(~/^user clicks on the Displayed Vendor$/){
	-> utility.clickElement(locatorTypeObj.cssSelector, "tr.odd.edit > td")
}

When(~/^user add Permission & Translation to the Selected Vendor$/){DataTable permissionDetails
	-> vendorObj.addPermission(permissionDetails)
}

Then(~/^user is shown the Dub Master tab$/) {
	-> searchCreativePage.verifyTabIsDisplayed("Dub Master")
}
Then(~/^user is shown the DNIS Group tab$/) {
	-> searchCreativePage.verifyTabIsDisplayed("DNIS Group")
}

Then(~/^user verifies DNIS Group created$/) {
	-> createCreativePage.verifyDNSGroup()
}

Then(~/^user is shown the Permissions & Translations tab$/) {
	-> searchCreativePage.verifyTabIsDisplayed("Permissions & Translations")
}
// Edit Creative

Given(~/^user searches and open the creative on Search Creative page$/){DataTable enterValues
	-> searchCreativePage.fillSearchCreativeForm(enterValues)
	   searchCreativePage.clickSearch()
	   searchCreativePage.verifyCreative()
	   searchCreativePage.clickCreative()
	
}
Given(~/^user clicks on Edit button on edit Creative Page$/){
	-> utility.clickElement(locatorTypeObj.classtype, "cta_button")
}

When(~/^user enter Creative Description on Edit creative page$/){DataTable input
	-> createCreativePage.editCreative(input)
}
Then(~/^user is displayed success message$/){
	-> createCreativePage.verifySuccessMessage()
}

//Export to Excel

When(~/^user click on Export to excel link on Search Creative Page$/){
	-> searchCreativePage.exportToExcel()	
}

Then(~/^excel report is saved on local machine$/){
	-> searchCreativePage.verifyCreativeFile()
}

Then(~/^verify the Creative count in excel$/){
	-> searchCreativePage.verifyExcelCount()
}

// Verify Paginatin and working
Then(~/^verify Pagination is present on the Search Creative Page$/){
	-> def boolean status =utility.isDisplayed(locatorTypeObj.classtype, "paginateButtons")
	   assertTrue("Pagination not found on Search Creative Page.", status==true)
}

When(~/^user click on Next button on Pagination$/){
	-> utility.clickElement(locatorTypeObj.classtype, "nextLink")
}

Then(~/^user is navigated to next Search Creative Result$/){
	-> utility.sleep(1000) 
	def String pageCount = utility.getText(locatorTypeObj.classtype, "currentStep")
	assertTrue("Pagination is not working on Search Creative Page.", pageCount.equalsIgnoreCase("2"))
}