package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def offerConfiguration = new SearchOfferConfiguration()
def utility = new SeleniumUtility()

Given(~/^user is on Offer Configuration Page$/) { ->
   utility.openPage("//*[@id='megamenu']/li[2]/h2","Offer Configuration") 
}

Given(~/^user selects Product, Offer Code, Script Version, SKU and Upsell on Offer Configuration Page$/) { DataTable enterType 
    -> offerConfiguration.selectProduct(enterType)
}

When(~/^user clicks on search button on Offer Configuration Page$/) { ->
    utility.clickSearchXpath("//*[@id='pageBody']/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div/div/div[9]/input")
}

Then(~/^user finds the required result by Product as result on Offer Configuration Page$/) { DataTable verifyProductType ->
    offerConfiguration.verifySearchResultProduct(verifyProductType)
}