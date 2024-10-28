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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebElement



//Opens the new browser and Navigates to the URL and maximizes the screen
WebUI.openBrowser('')
WebUI.navigateToUrl('https://r-1-0-2-mul-rdistro-wlk-opm.pantheonsite.io/online-nursing-programs')
WebUI.maximizeWindow()


// line 31 to 45 is for randomly selecting the dropdown for programs
// Locate the select element using the Test Object created
TestObject selectTestObject = findTestObject('Object Repository/North America_University/Wilkes_University/Dropdown_program')
String[] degreeoptions = ['Doctor of Nursing Practice (DNP)', 'Master of Science in Nursing (MSN)' , 'PhD in Nursing' , 'Post-Graduate APRN Certificate', 'Associate Degree in Nursing (RN) to MSN']
String randomOption1 = degreeoptions[new Random().nextInt(degreeoptions.length)]
WebUI.selectOptionByLabel(selectTestObject, randomOption1, false)

String[] options1 = ['Master of Science in Nursing (MSN)', 'Post-Graduate APRN Certificate', 'Associate Degree in Nursing (RN) to MSN']

if (Arrays.asList(options1).contains(randomOption1)) {
	WebUI.delay(3)
	TestObject APELdropdown = findTestObject('Object Repository/North America_University/Wilkes_University/Dropdown_Concentration')
	String[] APELoptions = ['Psychiatric/Mental Health Nurse Practitioner', 'FNP - Family Nurse Practitioner', 'AGPCNP - Adult-Gerontology Primary Care Nurse Practitioner', 'PMHNP - Psychiatric/ Mental Health Nurse Practitioner', 'FNP - Family Nurse Practitioner', 'AGPCNP – Adult-Gerontology Primary Care Nurse Practitioner', 'FNP - Family Nurse Practitioner', 'AGPCNP - Adult-Gerontology Primary Care Nurse Practitioner','PMHNP - Psychiatric/Mental Health Nurse Practitioner']
	String APELrandomOption = APELoptions[new Random().nextInt(APELoptions.length)]
	
	WebUI.selectOptionByLabel(APELdropdown, APELrandomOption, false)
	
	
}