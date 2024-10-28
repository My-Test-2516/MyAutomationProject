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
import java.util.List
import java.util.Random

// line 29 to 42 is for randomly selecting the dropdown for programs
// Locate the select element using the Test Object created
TestObject selectTestObject = findTestObject('Object Repository/North America_University/SBU_University/Dropdown_Program')
// Get the WebElement of the select
WebElement selectElement = WebUI.findWebElement(selectTestObject, 0)
// Create a Select object
Select select = new Select(selectElement)
// Get all available options
List<WebElement> optionsrandom = select.getOptions()
// Filter out the first option if it's a placeholder or empty
List<WebElement> validOptions = optionsrandom.findAll { it.getAttribute('value') != '' }
// Randomly select one of the valid options
Random randomdropdown = new Random()
WebElement randomOptiondropdown = validOptions[randomdropdown.nextInt(validOptions.size())]
// Set the select element to the random option
select.selectByValue(randomOptiondropdown.getAttribute('value'))


WebUI.check(findTestObject('Object Repository/North America_University/SBU_University/Checkbox_Studylevel'))
WebUI.verifyElementChecked(findTestObject('Object Repository/North America_University/SBU_University/Checkbox_Studylevel'), 30)

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

