package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchUnsourcedResponseDataPage=new SearchUnsourcedResponseDataPage()
def utility = new SeleniumUtility()


Given(~/^user is on Search unsourced Response Data Page$/) { ->
    utility.openPage("//*[@id=\"megamenu\"]/li[3]","Unsourced Response Data") 
}

When(~/^user selects Unaired tab$/) { ->
    searchUnsourcedResponseDataPage.openUnairedTab()
}

When(~/^user selects the Product for Search unsourced Response Data$/) { DataTable enterType 
 	-> searchUnsourcedResponseDataPage.selectProductUniredTab(enterType)
}

When(~/^user clicks on search button on Search Unsourced Response Data Page$/) { ->
   utility.clickSearchXpath("//*[@id=\"unairedSearchBox\"]/div/div[8]/input")
}

Then(~/^user finds the required result by product on Search Unsourced Response Data Page$/) { DataTable verifyProductType ->
    searchUnsourcedResponseDataPage.verifySearchResultProduct(verifyProductType)
}