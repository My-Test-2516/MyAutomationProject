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

WebUI.openBrowser('https://studysbu.online/landing/ppc5/edd-educational-leadership-online?SearchEngine=LinkedInIM&utm_source=Linkedin&utm_campaign=CSU-LinkedInIM-MSWADV&utm_medium=cpc&CampaignSourceCode=CSU-LinkedinIM-MSWADV-InMail_US&SearchKeyword=No_campus_visits&MediaCampaignID=209611194&MediaAdID=201838474')

WebUI.maximizeWindow()
//calls the Lead form  cases
//WebUI.callTestCase(findTestCase('Test Cases/North America_Universities/PPC_Pages/SBU_University/Reusable_Testcases/Lead_Form'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.check(findTestObject('Object Repository/North America_University/SBU_University/Checkbox1_Studylevel'))
WebUI.verifyElementChecked(findTestObject('Object Repository/North America_University/SBU_University/Checkbox1_Studylevel'), 30)

// Use the custom keyword to generate a random email
String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
WebUI.setText(findTestObject('Object Repository/North America_University/SBU_University/Field_Email'), Email)

//Clicks the next step
WebUI.waitForElementClickable(findTestObject('Object Repository/North America_University/SBU_University/Button_Nextstep 2'), 10)
WebUI.click(findTestObject('Object Repository/North America_University/SBU_University/Button_Nextstep 2'))

// Use the custom keyword to generate a random FirstName and LastName
String FirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
WebUI.setText(findTestObject('Object Repository/North America_University/SBU_University/Field_Firstname'), FirstName)

String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/North America_University/SBU_University/Field_Lastname'), LastName)

// Use the custom keyword to generate a random Phone number
String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomAustralianPhoneNumber'()
WebUI.setText(findTestObject('Object Repository/North America_University/SBU_University/Field_Phonenumber'), Phonenumber)

// Use the custom keyword to generate a post number
String Postcode = CustomKeywords.'keyPathPackage.customKeywords.selectRandomPostCodes'()
WebUI.setText(findTestObject('Object Repository/North America_University/SBU_University/Field_Postcode'), Postcode)

//Clicks the Submit buttono
WebUI.waitForElementClickable(findTestObject('Object Repository/North America_University/SBU_University/Button_Download_Brochure'), 10)
WebUI.click(findTestObject('Object Repository/North America_University/SBU_University/Button_Download_Brochure'))

//Verify if the Thank you for enquiry content is displayed
WebUI.delay(5)
WebUI.verifyElementText(findTestObject('Object Repository/North America_University/SBU_University/Verify_Content'), "Welcome to Bona's Online")

WebUI.closeBrowser()
