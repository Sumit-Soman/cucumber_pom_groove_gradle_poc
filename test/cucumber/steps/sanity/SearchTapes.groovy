package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchTapesPage=new SearchTapesPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();
def explicitObj = new ExplicitConditionType();

Given(~/^user is on Search Search Tapes Page$/) {
	-> utility.openPage(SeleniumUtility.MenuSearchTapes,"Search Tapes")
}

Given(~/^user enters Media Type, Creative and Agency on Search Tapes Page$/) { DataTable enterSearchTapesValues
	-> searchTapesPage.enterMediaTypeCreativeAgency(enterSearchTapesValues)
}

When(~/^user clicks on search button on Search Tapes Page$/) { 
	->utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
	utility.clickElement(locatorTypeObj.id, "search")
}

Then(~/^user finds the required tapes by media type on Search Tapes Page$/) { DataTable searchTapesResultValues
    -> searchTapesPage.verifyMediaType(searchTapesResultValues)
}