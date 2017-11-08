package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def invoiceUploadHistoryPage = new InvoiceUploadHistoryPage()
def utility = new SeleniumUtility()

Given(~/^user is on Invoice Upload History Page$/) { ->
    utility.openPageXpath(SeleniumUtility.MenuInvoiceUploadHistory,SeleniumUtility.MenuInvoiceUploadHistoryLink)
}

Given(~/^user enters File Type on Invoice Upload History Page$/) { DataTable enterValues ->
    invoiceUploadHistoryPage.enterStatus(enterValues)
}

When(~/^user clicks on search button on Invoice Upload History Page$/) { ->
     utility.clickSearchXpath(SeleniumUtility.invoiceUploadHistorySearch)
}

Then(~/^user finds the required records with File Type as Supporting Document or Invoice File on Invoice Upload History Page$/) { DataTable verifyValues ->
    invoiceUploadHistoryPage.verifyStatus(verifyValues)
}
