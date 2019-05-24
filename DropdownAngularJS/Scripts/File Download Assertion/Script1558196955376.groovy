import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*DownloadAssertionKeywords.setWAIT_TIME(user-timeout)
 KeywordUtil.logInfo("The wait time is: " + DownloadAssertionKeywords.getWAIT_TIME())
 
 DownloadAssertionKeywords.setDOWNLOAD_FOLDER("<user-dir>")
 KeywordUtil.logInfo("The wait time is: " + DownloadAssertionKeywords.getDOWNLOAD_FOLDER())*/

'Wait for file exist'
boolean fileStatus = CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.waitForFileExist'("Documents.txt")
WebUI.comment("File status : " + fileStatus.toString())

'Verify file exist'
CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.verifyDownloadFileExist'("Documents.txt")

'Get file content'
String fileContent = CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.getDownloadFileContent'("Documents.txt")
WebUI.comment("File content : " + fileContent)

'Get file size'
long fileSize = CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.getDownloadFileSize'("Image.jpg")
WebUI.comment("File size : " + fileSize.toString())

'Verify file size'
CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.verifyDownloadFileSize'("Image.jpg", 1724648)

'Compare file'
boolean compareFile = CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.compareDownloadFile'("Image.jpg", "D:\\Image_Baseline.jpg")
WebUI.comment("Compare file status : " + compareFile.toString())

'Verify file'
CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.verifyDownloadFile'("Image.jpg", "D:\\Image_Baseline.jpg")

'Delete file'
CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.deleteDownloadFile'("Image.jpg")

'Verify file deleted'
CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.verifyDownloadFileNotExist'("Image.jpg")

'Clear download folder'
CustomKeywords.'com.katalon.plugin.keyword.file.DownloadAssertionKeywords.clearDownloadFolder'()

