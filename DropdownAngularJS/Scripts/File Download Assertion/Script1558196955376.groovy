import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String home = System.getProperty("user.home") + "\\Downloads\\"
println home

a = CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.compareDownloadFile'("aThang1.jpg", "D:\\aThang.jpg")
println a.toString()

b = CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.getDownloadFileSize'("Lan_Broadcom_14.0.1.0_W7x86W7x64_A.zip")
println b.toString()

c = CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.waitForFileExist'("Katalon Training.xlsx")
println c.toString()
CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.deleteDownloadFile'("Filnal_-_1.zip")
CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.clearDownloadFolder'()
