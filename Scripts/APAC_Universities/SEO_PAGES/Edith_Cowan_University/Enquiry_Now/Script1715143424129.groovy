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

// Calls the URL test cases
WebUI.callTestCase(findTestCase('Test Cases/APAC_Universities/SEO_PAGES/Edith_Cowan_University/Reusable_Testcases/Navigate_URL'), [:], FailureHandling.STOP_ON_FAILURE)

//Clicks the Enquiry Now button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/Edith_Cowan_University/Button_Enquiry_Now'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/Edith_Cowan_University/Button_Enquiry_Now'))

// Calls the Lead form test cases
WebUI.callTestCase(findTestCase('Test Cases/APAC_Universities/SEO_PAGES/Edith_Cowan_University/Reusable_Testcases/Lead_Form'), [:], FailureHandling.STOP_ON_FAILURE)

//CLose Browser
//WebUI.closeBrowser()