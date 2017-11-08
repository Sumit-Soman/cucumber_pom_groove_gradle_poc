package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def manageConfirmationAndRevisionsPage=new ManageConfirmationAndRevisionsPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();
def explicitObj = new ExplicitConditionType();


Given(~/^user is on Manage Confirmation & Revisions Page\.$/) { ->
    utility.openPage("//*[@id=\"megamenu\"]/li[4]","Confirmations and Revisions")
}

When(~/^user selects external media buys checkbox\.$/) { ->
    manageConfirmationAndRevisionsPage.selectAllExternalBilled()
}

When(~/^user clicks on search button on Manage Confirmation & Revisions Page\.$/) { ->
	utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
	utility.clickElement(locatorTypeObj.id, "confirmationRevisionSearch")
}

Then(~/^user finds the required result by external agency on Manage Confirmation & Revisions Page\.$/) { ->
    manageConfirmationAndRevisionsPage.verifySearchResultManageConfirmation()
}