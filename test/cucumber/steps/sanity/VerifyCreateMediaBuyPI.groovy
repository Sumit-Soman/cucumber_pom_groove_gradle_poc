package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def createMediaBuyPIPage=new CreateMediaBuyPIPage()
def utility=new SeleniumUtility()

When(~/^user navigates to Create Media Buy PI Page$/) {
    -> utility.openPageXpath("//*[@id=\"megamenu\"]/li[4]","//*[@id=\"megamenu\"]/li[4]/div/table/tbody/tr[5]/td[2]/a")
}

Then(~/^user is on Create Media Buy PI Page$/) { 
	-> createMediaBuyPIPage.verifyCreateMediaBuyPI()
}