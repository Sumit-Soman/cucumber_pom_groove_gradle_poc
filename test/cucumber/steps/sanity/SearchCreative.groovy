package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchCreativePage=new SearchCreativePage()
LocatorType locatorTypeObj = new LocatorType();
def utility = new SeleniumUtility()


Given(~/^user is on Search Creative Page$/) { 
	->	utility.openPage("//ul[@class='megamenu']/li[1]","Creatives")
}

Given(~/^user enters media type, product, show and region on Search Creative Page$/) { DataTable enterValues 
 	-> searchCreativePage.fillSearchCreativeForm(enterValues)
}

When(~/^user clicks on search button on Search Creative Page$/) {
    -> utility.clickElement(locatorTypeObj.id, "searchAction")
}

Then(~/^user finds the required creatives by media type, product, show and region as result on Search Creative Page$/) { DataTable resultValues 
    -> searchCreativePage.verifyMediaTypeProductShowRegion(resultValues)
}

Given(~/^user enters and finds the required creatives by media type, product, show and region as result$/) { DataTable enterValues
    -> searchCreativePage.enterMediaTypeProductShowRegion(enterValues)
}

When(~/^user clicks on a creative from the result$/) { 
	-> searchCreativePage.clickCreative();
}

Then(~/^user navigates to the creative details page with Creative Details Tab$/){ 
	-> searchCreativePage.verifyTabIsDisplayed("Creative Details")
}

When(~/^user clicks on Allowable tab$/) { 
	-> searchCreativePage.clickTabHead("Allowable")
}
When(~/^user clicks on Dub Master tab$/) { 
	-> searchCreativePage.clickTabHead("Dub Master")
}
When(~/^user clicks on DNIS Group tab$/) { 
	-> searchCreativePage.clickTabHead("DNIS Group")
}
When(~/^user clicks on Permissions & Translations tab$/) { 
	-> searchCreativePage.clickTabHead("Permissions & Translations")
}

Then(~/^user is shown the Allowable tab$/) { 
	-> searchCreativePage.verifyTabIsDisplayed("Allowable")
}

Then(~/^user is shown the Dub Master tab$/) { 
	-> searchCreativePage.verifyTabIsDisplayed("Dub Master")
}
Then(~/^user is shown the DNIS Group tab$/) {  
	-> searchCreativePage.verifyTabIsDisplayed("DNIS Group")
}
Then(~/^user is shown the Permissions & Translations tab$/) { 
	-> searchCreativePage.verifyTabIsDisplayed("Permissions & Translations")
}