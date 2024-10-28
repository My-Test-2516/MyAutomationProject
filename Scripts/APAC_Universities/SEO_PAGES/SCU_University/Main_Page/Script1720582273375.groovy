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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebElement



// Calls the URL test cases
WebUI.callTestCase(findTestCase('Test Cases/APAC_Universities/SEO_PAGES/SCU_University/Reusable_Testcases/Navigate_URL'), [:], FailureHandling.STOP_ON_FAILURE)

// Locate the select element using the Test Object created
TestObject selectTestObject = findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Dropdown_Course')

// Get the WebElement of the select
WebElement selectElement = WebUI.findWebElement(selectTestObject, 0)

// Create a Select object
Select select = new Select(selectElement)

// Get all available options
List<WebElement> options = select.getOptions()

// Filter out the first option if it's a placeholder or empty
List<WebElement> validOptions = options.findAll { it.getAttribute('value') != '' }

// Randomly select one of the valid options
Random random = new Random()
WebElement randomOption = validOptions[random.nextInt(validOptions.size())]

// Set the select element to the random option
select.selectByValue(randomOption.getAttribute('value'))

// Use the custom keyword to generate a random FirstName and LastName
String FirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Field_Firstname'), FirstName)

String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Field_Lastname'), LastName)

//Clicks the Next Step 1
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Button_Nextstep1'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Button_Nextstep1'))

// Use the custom keyword to select a random startdate
TestObject startdate = findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Dropdown_StartDate')
WebUI.selectOptionByIndex(startdate,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

//Selects random EnquiryReason
TestObject Enquiryreason = findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Dropdown_Enquiry')
WebUI.selectOptionByIndex(Enquiryreason, CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

WebUI.selectOptionByValue(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Dropdown_EducationLevel'),GlobalVariable.Education_Level, false)

//Selects random work experience
TestObject Workexperience = findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Dropdown_Workexperience')
WebUI.selectOptionByIndex(Workexperience,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())

//Clicks the Next Step2
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Button_Nextstep2'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Button_Nextstep2'))

// Use the custom keyword to generate a random Phone number
String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomAustralianPhoneNumber'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Field_PhoneNumber'), Phonenumber)


// Use the custom keyword to generate a random email
String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Field_Email'), Email)


//WebUI.selectOptionByLabel(findTestObject('Object Repository/APAC_University/Deakin_University/Dropdown_Country'),'Australia', false)

// Use the custom keyword to generate a post number
String Postcode = CustomKeywords.'keyPathPackage.customKeywords.selectRandomPostCode'()
WebUI.setText(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Field_PostCode'), Postcode)
WebUI.setText(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Field_PostCode'), Postcode)

//Clicks the Submit button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Button_Submit'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/SCU_University/Main_Page/Button_Submit'))

WebUI.closeBrowser()