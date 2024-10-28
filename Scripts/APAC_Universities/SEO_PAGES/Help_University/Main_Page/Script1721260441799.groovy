import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ObjectRepository
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.logging.KeywordLogger



//Calls the URL test cases
WebUI.callTestCase(findTestCase('Test Cases/APAC_Universities/SEO_PAGES/Help_University/Resuable_Testcases/Navigate_URL'), [:], FailureHandling.STOP_ON_FAILURE)

//Scrolls to the particular element 

KeywordLogger logger = new KeywordLogger()

// Define the Test Object
TestObject testObject = ObjectRepository.findTestObject('Object Repository/APAC_University/Help_University/Program_Info')

// Check if the element is present
boolean isElementPresent = WebUI.verifyElementPresent(testObject, 10, FailureHandling.CONTINUE_ON_FAILURE)

if (isElementPresent) {
	logger.logPassed("Element is present. Scrolling to the element.")
	WebUI.scrollToElement(testObject, 10)
}
else {
	// If element is not present, log the information and continue
	logger.logWarning("Element is not present. Continuing with other steps.")
}

//Calls the Leadfrom test cases
WebUI.callTestCase(findTestCase('Test Cases/APAC_Universities/SEO_PAGES/Help_University/Resuable_Testcases/Lead_Form'), [:], FailureHandling.STOP_ON_FAILURE)

