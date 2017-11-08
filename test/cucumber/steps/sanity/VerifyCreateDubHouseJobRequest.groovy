package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def createDubHouseJobRequestPage=new CreateDubHouseJobRequestPage()
def utility=new SeleniumUtility()

When(~/^user navigates to Create Dub House Job Request Page$/) {
	-> utility.openPage("//*[@id=\"megamenu\"]/li[2]","Create Dub House Job Request") 
}

Then(~/^user is on Create Dub House Job Request Page$/) {
    -> createDubHouseJobRequestPage.verifyCreateDubHouseJobRequestPage()
}
