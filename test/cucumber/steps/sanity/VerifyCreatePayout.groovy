package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def createPayoutPage=new CreatePayoutPage()
def utility=new SeleniumUtility()

When(~/^user navigates to Create Payout Page$/) {
	-> utility.openPage("//*[@id=\"megamenu\"]/li[5]","Create Payouts") 
}

Then(~/^user is on Create Create Payout Page$/) {
    -> createPayoutPage.verifyCreatePayoutPage()
}
