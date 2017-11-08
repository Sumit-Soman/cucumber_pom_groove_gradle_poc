package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*


def createTapeFileRequestPage=new CreateTapeFileRequestPage()
def utility=new SeleniumUtility()

When(~/^user navigates to Create Tape_File Request Page$/) {
	 -> utility.openPage(SeleniumUtility.MenuCreateTapeFileRequest,"Create Tape/File Request")
}

Then(~/^user is on Create Tape_File Request Page$/) {
	 ->createTapeFileRequestPage.verifyCreateTapeFileRequestPage()
}