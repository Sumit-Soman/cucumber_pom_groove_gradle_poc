package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchStationPage=new SearchStationPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();

Given(~/^user is on Search Station Page$/) { 
	-> utility.openPage(SeleniumUtility.MenuSearchStations,"Stations")
}

Given(~/^user enters Status and Station Type on Search Station Page$/) { DataTable enterValues
	-> searchStationPage.enterValuesStation(enterValues)
}

When(~/^user clicks on search button on Search Station Page$/) {
    -> utility.clickElement(locatorTypeObj.id, "search")
}

Then(~/^user finds the required Station by Status and Station Type on Search Station Page$/) { DataTable resultValues 
	-> searchStationPage.verfiyStationsPage(resultValues)
}