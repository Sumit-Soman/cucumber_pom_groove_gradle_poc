package steps.regression

import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;

import javax.servlet.jsp.PageContext;

import junit.framework.Assert;
import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchStationPage=new SearchStationPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType()

Given(~/^user is on Search Station Page$/) { 
-> utility.openPage(SeleniumUtility.MenuSearchStations,"Stations")
}

Given(~/^user enters new Data on Search Station Page$/) { DataTable enterValues 
    -> searchStationPage.enterRegressValuesStation(enterValues)
}

When(~/^user clicks on search button on Search Station Page$/) { 
    -> utility.clickElement(locatorTypeObj.id, "search")
}

Then(~/^user will not find the required Station on Search Station Page$/) {  
    -> searchStationPage.verfiyRegressStationsPage()
}


When(~/^user will click on Create Station$/) { ->
    searchStationPage.openCreateStationPage()
}

When(~/^user will fill all mandatory fields$/) { DataTable enterCreateValues ->
    searchStationPage.enterCreateStationPageData(enterCreateValues)
}

When(~/^user will save data$/) { ->
   utility.clickSearchXpath( "//*[@id=\"createStationTemplate\"]/div/form/div/div/div[3]/div/input[1]")
}

Then(~/^user will get success message$/) { ->
    searchStationPage.verifyStationCreation()
}


Then(~/^user will click on dubbing details and fill fields$/) { DataTable enterDebuggingValues ->
    searchStationPage.enterDebuggingDetailsData(enterDebuggingValues)
}

Then(~/^user will click on contact tab$/) { ->
    searchStationPage.openContactDetailstab()
}

Then(~/^user will click on Add contact button and fill all mandatory fields on pop up$/) { DataTable enterContactValues ->
    searchStationPage.enterContactDetailsData(enterContactValues)
}

Then(~/^user will click on Agency Permissions tab\.$/) { ->
    searchStationPage.openAgencyPermissionstab()
}

Then(~/^user will click on move all button and save\.$/) { ->
    searchStationPage.moveAllAndSave()
}

Then(~/^user will get warning message$/) { ->
    searchStationPage.stationCreationWarning()
}


Then(~/^verify Pagination is present on the Search Station Page$/) { ->
    def boolean status =utility.isDisplayed(locatorTypeObj.classtype, "paginateButtons")
	   assertTrue("Pagination not found on Search Station Page.", status==true)
}

When(~/^user click on Next button on Pagination on the Search Station Page$/) { ->
    utility.clickElement(locatorTypeObj.classtype, "nextLink")
}

Then(~/^user is navigated to next Search Station Result$/) { ->
	utility.sleep(2000)
	def String pageCount = utility.getText(locatorTypeObj.classtype, "currentStep")
	assertTrue("Pagination is not working on Search Station Page."+pageCount, pageCount.equalsIgnoreCase("2"))
}

When(~/^user click on Export to excel link on Search Station Page$/) { ->
    searchStationPage.exportToExcel()
}

Then(~/^excel report is saved on local machine for search station$/){
	-> searchStationPage.verifyStationFile()
}

Then(~/^verify the station count in excel$/) { ->
    searchStationPage.verifyExcelCount()
}