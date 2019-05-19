package com.katalon.plugin.keyword.file

import org.apache.commons.io.FileUtils
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class DownloadKeywords {
	private String downloadFolder = System.getProperty("user.home") + "\\Downloads\\"
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
	 * Verify file existing
	 * @param downloadFileName: the download file name
	 * @param timeOut: the second time to wait for file existing
	 */
	@Keyword
	def verifyDownloadFileExist(String downloadFileName, int timeOut=waitTime) {
		WebUI.verifyEqual(waitForFileExist(downloadFileName, timeOut), true)
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
	 * Verify file data
	 * @param downloadFileName: the download file name
	 * @param expectedFilePath: the expected file path to compare
	 */
	@Keyword
	def verifyDownloadFileData(String downloadFileName, String expectedFilePath) {
		WebUI.verifyEqual(compareDownloadFile(downloadFileName, expectedFilePath), true)
	}

	/******************************************************
	 * Delete file
	 * @param downloadFileName: the download file name
	 */
	@Keyword
	def deleteDownloadFile(String downloadFileName) {
		FileUtils.forceDeleteOnExit(new File(downloadFolder + downloadFileName))
	}

	/******************************************************
	 * Clear download folder
	 */
	@Keyword
	def clearDownloadFolder() {
		FileUtils.cleanDirectory(new File(downloadFolder))
	}
}
