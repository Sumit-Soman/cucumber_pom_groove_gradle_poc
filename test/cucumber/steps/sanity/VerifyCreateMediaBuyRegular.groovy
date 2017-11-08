package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def createMediaBuyRegularPage=new CreateMediaBuyRegularPage()
def utility=new SeleniumUtility()

When(~/^user navigates to Create Media Buy Regular Page$/) {
    -> utility.openPageXpath("//*[@id=\"megamenu\"]/li[4]","//*[@id=\"megamenu\"]/li[4]/div/table/tbody/tr[5]/td[1]/a")
}

Then(~/^user is on Create Media Buy Regular Page$/) { 
	-> createMediaBuyRegularPage.verifyCreateMediaBuyRegular()
}