package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchMediaAssignmentsPage=new SearchMediaAssignmentsPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();

Given(~/^user is on Search Media Assignments Page$/) {
	 -> utility.openPage(SeleniumUtility.MenuSearchMediaAssignments,"Search Media Assignments")
}

Given(~/^user enters Creative, Agency and Media Type on Search Media Assignments Page$/) { DataTable enterValues
	 -> searchMediaAssignmentsPage.enterCreativeAgencyMediaType(enterValues)
}

When(~/^user clicks on search button on Search Media Assignments Page$/) {
	 -> utility.clickElement(locatorTypeObj.id, "search")
}

Then(~/^user finds the required Media Assignments by Product, Agency and Media Type on Search Media Assignments Page$/) { DataTable verifyValues
	 -> searchMediaAssignmentsPage.verifyCreativeAgencyMediaType(verifyValues)
}
