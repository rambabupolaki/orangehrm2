package selenium.framework.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author Automation Team
 *
 */

public class ReportZipper {

	/*****************************************************************************************************
	 * Method Name : zipFolder() Method Description : This method will creating
	 * the zip file Parameters : Need to set dir, fileList Type : Zip file
	 ******************************************************************************************************/

	public static String zipFolder() {
		String dateStamp = new SimpleDateFormat("dd_MM_yyyy-HH-mm-ss").format(new Date());
		String tmp = System.getProperty("user.dir") + "/Reports/" + dateStamp + ".zip";
		String zippedFilePath = System.getProperty("user.dir") + "/build/reports/surefire-reports/html";
		File directoryToZip = new File(zippedFilePath);

		List<File> fileList = new ArrayList<File>();
		try {
			System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getAllFiles(directoryToZip, fileList);
		System.out.println("---Creating zip file");
		writeZipFile(directoryToZip, fileList, tmp);
		System.out.println("---Done");
		return tmp;
	}

	/*****************************************************************************************************
	 * Method Name : getAllFiles() Method Description : This method will
	 * retrieve the all report files Parameters : Need to set dir, fileList Type
	 * : NA
	 ******************************************************************************************************/

	public static void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				fileList.add(file);
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					getAllFiles(file, fileList);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*****************************************************************************************************
	 * Method Name : writeZipFile() Method Description : This method will write
	 * into reports zip folder Parameters : Need to set directoryToZip,
	 * fileList, zipFilePath Type : NA
	 ******************************************************************************************************/

	public static void writeZipFile(File directoryToZip, List<File> fileList, String zipFilePath) {
		// System.out.println(directoryToZip.getName() + ".zip");

		try {
			FileOutputStream fos = new FileOutputStream(zipFilePath);
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					addToZip(directoryToZip, file, zos);
				}
			}
			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*****************************************************************************************************
	 * Method Name : addToZip() Method Description : This method will convert
	 * the report folder to zip file Parameters : Need to set directoryToZip,
	 * file, zos Type : NA
	 ******************************************************************************************************/

	public static void addToZip(File directoryToZip, File file, ZipOutputStream zos)
			throws FileNotFoundException, IOException {

		FileInputStream fis = new FileInputStream(file);
		// we want the zipEntry's path to be a relative path that is relative
		// to the directory being zipped, so chop off the rest of the path
		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		// System.out.println("Writing '" + zipFilePath + "' to zip file");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}
		zos.closeEntry();
		fis.close();
	}

	/*****************************************************************************************************
	 * Method Name : main() Method Description : Created this main method for
	 * testing purpose Parameters : NA Return Type : NA
	 ******************************************************************************************************/

	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("dd_MM_yyyy-HH-mm-ss").format(new Date()));
	}
}
