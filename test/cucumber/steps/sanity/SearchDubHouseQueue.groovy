package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchDubHouseQueuePage=new SearchDubHouseQueuePage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();


When(~/^user is on the Dub House Queue Page$/) {

	 -> utility.openPage("//ul[@class='megamenu']/li[2]","Dub House Queue")
}
When(~/^user selects Dub House$/) {DataTable enterValues 
 	-> searchDubHouseQueuePage.enterDubHouseStatus(enterValues)
}

When(~/^user clicks on search button on Dub House queue Page$/) { 
  -> utility.clickElement(locatorTypeObj.id, "search")
}

Then(~/^user finds the required result by Dub House on Dub House queue Page$/) { DataTable enterValues
   -> searchDubHouseQueuePage.verifyDubHouseStatus(enterValues)
}

