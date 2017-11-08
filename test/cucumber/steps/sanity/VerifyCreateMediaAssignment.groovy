package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def createMediaAssignmentPage=new CreateMediaAssignmentPage()
def utility=new SeleniumUtility()

When(~/^user navigates to Create Media Assignment Page$/) {
    -> utility.openPage("//*[@id=\"megamenu\"]/li[2]","Create Media Assignment")
}

Then(~/^user is on Create Media Assignment Page$/) { 
	-> createMediaAssignmentPage.verifyCreateMediaAssignmentPage()
}