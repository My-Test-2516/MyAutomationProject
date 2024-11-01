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
import com.github.javafaker.Faker

// Calls the URL test cases
WebUI.callTestCase(findTestCase('Test Cases/APAC_Universities/SEO_PAGES/RMIT_University/Reusuable_Testcases/Naviigate_Url'), [:], FailureHandling.STOP_ON_FAILURE)

//Clicks the Enquiry Now button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Button_Enquiry_Now'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Button_Enquiry_Now'))

/*int optionListLength = 4
Random rand = new Random()
int index = rand.nextInt(optionListLength-1)+1
TestObject program = findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Dropdown_Enquiry_Program')
WebUI.selectOptionByIndex(program, index)*/

//Randomly selects the program from the drop-down
TestObject program = findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Dropdown_Enquiry_Program')
WebUI.selectOptionByIndex(program,CustomKeywords.'keyPathPackage.customKeywords.selectRandomOptionFromDropdown'())


/*// Generates a random first name and Lastname
Faker faker = new Faker()
String randomFirstName = faker.name().firstName()
TestObject firstNameField = findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_FirstName')
WebUI.setText(firstNameField, randomFirstName)
String randomSecondName = faker.name().firstName()
TestObject secondNameField = findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_SecondName')
WebUI.setText(secondNameField, randomSecondName)*/

// Use the custom keyword to generate a random FirstName and LastName
String FirstName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomFirstName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_FirstName'), FirstName)

String LastName = CustomKeywords.'keyPathPackage.customKeywords.generateRandomLastName'()
WebUI.setText(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_SecondName'), LastName)

//Clicks the next step
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Button_Nextstep2'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Button_Nextstep2'))

/*//generates phone nubmber
String randomphoneNumber = faker.numerify("04########")
TestObject phonenumber = findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_Phonenumber')
WebUI.setText(phonenumber, randomphoneNumber)*/

// Use the custom keyword to generate a random Phone number
String Phonenumber = CustomKeywords.'keyPathPackage.customKeywords.generateRandomAustralianPhoneNumber'()
WebUI.setText(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_Phonenumber'), Phonenumber)

/*// Common email domain
String domain = "@example.com"
// Generate a random email address using the first name and common domain
String randomEmail = randomFirstName + domain
TestObject EmailAddress = findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_Email')
WebUI.setText(EmailAddress, randomEmail)*/

// Use the custom keyword to generate a random email
String Email = CustomKeywords.'keyPathPackage.customKeywords.generateRandomEmail'()
WebUI.setText(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_Email'), Email)

//Clicks the nextstep Now button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Button_Nextstep3'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Button_Nextstep3'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Dropdown_Country'),'Australia', false)

/*//Genrates random post code
String randompostCode = faker.address().zipCode()
TestObject postCode = findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_Pincode')
WebUI.click(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_Pincode'))
WebUI.setText(postCode, randompostCode)*/
WebUI.delay(3)
// Use the custom keyword to generate a post number
String Postcode = CustomKeywords.'keyPathPackage.customKeywords.selectRandomPostCode'()
WebUI.setText(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_Pincode'), Postcode)
WebUI.setText(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Field_Pincode'), Postcode)

//Clicsk the get started button
WebUI.waitForElementClickable(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Button_GetStarted'), 10)
WebUI.click(findTestObject('Object Repository/APAC_University/Rmit_University/Enquiry_Now/Button_GetStarted'))

//Verify if the Thank you for enquiry content is displayed
WebUI.delay(5)
WebUI.verifyElementText(findTestObject('Object Repository/APAC_University/Rmit_University/Main_Page/Verify_Message'), 'Thank you for enquiring')

//Close Browser
//WebUI.closeBrowser()
