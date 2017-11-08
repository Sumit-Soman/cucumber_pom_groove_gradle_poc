package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def createTollFreeNumberPage = new CreateTollFreeNumberPage()
def utility = new SeleniumUtility()

When(~/^user navigates to Create Toll Free Number Page$/) {
  ->  utility.openPage("//ul[@class=\"megamenu\"]/li[2]","Create Toll Free Number Request")
}

Then(~/^user is on Create Toll Free Number Page$/) {
  ->  createTollFreeNumberPage.verifyCreateTollFreeNumberPage()
}