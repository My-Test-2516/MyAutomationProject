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
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebElement
import java.util.List
import java.util.Random


//Selects the Highest Level Education
WebUI.selectOptionByValue(findTestObject('Object Repository/North America_University/SJCME_University/Dropdown_Education'), 'Bachelors degree', false)

// Use the custom keyword to generate a random FirstName and LastName
String FirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
WebUI.setText(findTestObject('Object Repository/North America_University/SJCME_University/Field_Firstname'), FirstName)

String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/North America_University/SJCME_University/Field_Lastname'), LastName)
// Use the custom keyword to generate a random email
String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
WebUI.setText(findTestObject('Object Repository/North America_University/SJCME_University/Field_Email'), Email)

// Use the custom keyword to generate a random Phone number
String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomAustralianPhoneNumber'()
WebUI.setText(findTestObject('Object Repository/North America_University/SJCME_University/Field_Phonenumber'), Phonenumber)

//Selects the Country
WebUI.selectOptionByValue(findTestObject('Object Repository/North America_University/SJCME_University/Dropdown_Country'), 'USA', false)

// Use the custom keyword to generate a post number
String Postcode = CustomKeywords.'keyPathPackage.customKeywords.selectRandomPostCodes'()
WebUI.setText(findTestObject('Object Repository/North America_University/SJCME_University/Field_Postcode'), Postcode)

//Clicks the Submit button
WebUI.waitForElementClickable(findTestObject('Object Repository/North America_University/SJCME_University/Button_Submit'), 10)
WebUI.click(findTestObject('Object Repository/North America_University/SJCME_University/Button_Submit'))

//Verify if the Thank you for enquiry content is displayed
WebUI.delay(5)
WebUI.verifyElementText(findTestObject('Object Repository/North America_University/SJCME_University/Verify_Content'), "Welcome")

WebUI.closeBrowser()

