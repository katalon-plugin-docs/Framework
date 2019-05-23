package com.katalon.plugin.keyword.file

import org.apache.commons.io.FileUtils
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

public class DownloadAssertionKeywords {
	private String downloadFolder = System.getProperty("user.home").toString().replace("\\", "/") + "/Downloads/"
	private int waitTime = 5

	/******************************************************
	 * Wait for file exist
	 * @param downloadFileName: the download file name
	 * @param timeOut: the second time to wait for file existing
	 */
	@Keyword
	def waitForFileExist(String downloadFileName, int timeOut=waitTime) {
		return FileUtils.waitFor(new File(downloadFolder + downloadFileName), timeOut)
	}

	/******************************************************
	 * Verify file exist
	 * @param downloadFileName: the download file name
	 * @param timeOut: the second time to wait for file existing
	 */
	@Keyword
	def verifyDownloadFileExist(String downloadFileName, int timeOut=waitTime) {
		if(waitForFileExist(downloadFileName, timeOut)) KeywordUtil.markPassed(downloadFileName + " is existed.")
		else KeywordUtil.markFailedAndStop(downloadFileName + " is not existed.")
	}

	/******************************************************
	 * Verify file not exist
	 * @param downloadFileName: the download file name
	 */
	@Keyword
	def verifyDownloadFileNotExist(String downloadFileName) {
		if(waitForFileExist(downloadFileName, 0)) KeywordUtil.markFailedAndStop(downloadFileName + " still exists.")
		else KeywordUtil.markPassed(downloadFileName + " is not existed.")
	}

	/******************************************************
	 * Get file content
	 * @param downloadFileName: the download file name
	 * @return the file content
	 */
	@Keyword
	def getDownloadFileContent(String downloadFileName) {
		return FileUtils.readFileToString(new File(downloadFolder + downloadFileName))
	}

	/******************************************************
	 * Get file size
	 * @param downloadFileName: the download file name
	 * @return the file size (byte)
	 */
	@Keyword
	def getDownloadFileSize(String downloadFileName) {
		return FileUtils.sizeOfAsBigInteger(new File(downloadFolder + downloadFileName))
	}

	/******************************************************
	 * Verify file size
	 * @param downloadFileName: the download file name
	 * @param expectedSize: the expected file size (byte)
	 */
	@Keyword
	def verifyDownloadFileSize(String downloadFileName, long expectedSize) {
		WebUI.verifyEqual(getDownloadFileSize(downloadFileName), expectedSize)
	}

	/******************************************************
	 * Compare file
	 * @param downloadFileName: the download file name
	 * @param filePath: the full file name to compare
	 * @return the compare status : true (the same); false (not the same)
	 */
	@Keyword
	def compareDownloadFile(String downloadFileName, String filePath) {
		File file1 = new File(downloadFolder + downloadFileName)
		File file2 = new File(filePath)
		return FileUtils.contentEquals(file1, file2)
	}

	/******************************************************
	 * Verify file
	 * @param downloadFileName: the download file name
	 * @param expectedFilePath: the expected file path to compare
	 */
	@Keyword
	def verifyDownloadFile(String downloadFileName, String expectedFilePath) {
		if(compareDownloadFile(downloadFileName, expectedFilePath)) KeywordUtil.markPassed(downloadFileName + " and " + expectedFilePath + " are the same.")
		else KeywordUtil.markFailedAndStop(downloadFileName + " and " + expectedFilePath + " are not the same.")
	}

	/******************************************************
	 * Delete file
	 * @param downloadFileName: the download file name
	 */
	@Keyword
	def deleteDownloadFile(String downloadFileName) {
		File deleteFile = new File(downloadFolder + downloadFileName)
		if(FileUtils.waitFor(deleteFile, 0)) {
			FileUtils.forceDelete(deleteFile)
			int countTime = 10
			while (FileUtils.waitFor(deleteFile, 0) && countTime > 0){
				Thread.sleep(500)
				countTime--
			}
		}
	}

	/******************************************************
	 * Clear download folder
	 */
	@Keyword
	def clearDownloadFolder() {
		FileUtils.cleanDirectory(new File(downloadFolder))
	}
}
