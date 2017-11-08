package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def approvePaymentRequestPage=new ApprovePaymentRequestPage()
def utility=new SeleniumUtility()

When(~/^user navigates to Approve Payment Request Page$/) {
	-> utility.openPage("//*[@id=\"megamenu\"]/li[5]","Approve Payment Request") 
}

Then(~/^user is on Approve Payment Request Page$/) {
    -> approvePaymentRequestPage.verifyApprovePaymentRequestPage()
}
