package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def createMediaBuyGuaranteePage=new CreateMediaBuyGuaranteePage()
def utility=new SeleniumUtility()

When(~/^user navigates to Create Media Buy Guarantee Page$/) {
    -> utility.openPageXpath("//*[@id=\"megamenu\"]/li[4]","//*[@id=\"megamenu\"]/li[4]/div/table/tbody/tr[6]/td/a")
}

Then(~/^user is on Create Media Buy Guarantee Page$/) { 
	-> createMediaBuyGuaranteePage.verifyCreateMediaBuyGuarantee()
}