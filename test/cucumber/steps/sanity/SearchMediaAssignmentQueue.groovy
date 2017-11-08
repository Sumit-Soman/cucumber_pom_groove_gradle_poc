package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable


def searchMediaAssignmentQueue=new SearchMediaAssignmentQueuePage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();

When(~/^user is on the Media Assignment Queue Page$/) { ->

utility.openPage(SeleniumUtility.MenuSearchMediaAssignmentsQueue,"Media Assignment Queue")

}

When(~/^user selects Status$/) { DataTable enterValues ->

    searchMediaAssignmentQueue.enterStatus(enterValues)
}

When(~/^user clicks on search button on Media Assignment queue Page$/) { ->
    utility.clickElement(locatorTypeObj.id, "search")
}

Then(~/^user finds the required result by Call Center on Media Assignment queue Page$/) { DataTable enterValues ->
    searchMediaAssignmentQueue.verifyMediaAssignmentQueue(enterValues)
}