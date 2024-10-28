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

WebUI.openBrowser('https://studysbu.online/landing/ppc5/mscs?SearchEngine=LinkedInIM&utm_source=Linkedin&utm_campaign=CSU-LinkedInIM-MSWADV&utm_medium=cpc&CampaignSourceCode=CSU-LinkedinIM-MSWADV-InMail_US&SearchKeyword=No_campus_visits&MediaCampaignID=209611194&MediaAdID=201838474')

WebUI.maximizeWindow()
//calls the Lead form  cases
WebUI.callTestCase(findTestCase('Test Cases/North America_Universities/PPC_Pages/SBU_University/Reusable_Testcases/Lead_Form'), [:], FailureHandling.STOP_ON_FAILURE)