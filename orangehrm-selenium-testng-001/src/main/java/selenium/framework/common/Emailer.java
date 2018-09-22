package selenium.framework.common;
import java.io.FileReader;
import java.util.HashMap;
import java.io.BufferedReader;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Emailer extends PropertiesFileReader {

	final static String smtpAuthUserName = getProperties().getProperty("smtpUserName");
	final static String smtpAuthPassword = getProperties().getProperty("smtpPassword");
	static String emailFrom = getProperties().getProperty("fromAddress");
	static String emailTo = getProperties().getProperty("toAddress");
	static String attachmentFlag = getProperties().getProperty("attachment");
	
	public static void main(String[] args) {
	sendEmail(Boolean.valueOf(attachmentFlag));
	}

	/*****************************************************************************************************
	 * Method Name : sendEmail() Method Description : This method will send the
	 * email after the batch execution Parameters : Need to set flag Return Type
	 * : True/False
	 ******************************************************************************************************/

	public static boolean sendEmail(boolean flag) {
		String attachmentFile = "";
		String fileName = "";

		if (!getProperties().getProperty("emailFlag").equalsIgnoreCase("true")) {
			System.out.println("Email Trigger Flag set to false.  Skipping Send email");
			return false;
		}

		if (flag) {
			attachmentFile = ReportZipper.zipFolder();
			fileName = attachmentFile.substring(attachmentFile.lastIndexOf("/"), attachmentFile.length());
		}
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				System.out.println("Authenticating Credentials.");
				return new PasswordAuthentication(smtpAuthUserName, smtpAuthPassword);
			}
		};
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", getProperties().getProperty("smtpHost"));
		properties.setProperty("mail.smtp.port", getProperties().getProperty("smtpPort"));
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(properties, authenticator);
		// 2) compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailFrom));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			message.setSubject("Reactor CX Automation Test Execution Results");
			
			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPart1 = new MimeBodyPart();
			//messageBodyPart1.setText(emailContent());
			messageBodyPart1.setContent(emailContent(insertExecutionDetails()),"text/html");
			multipart.addBodyPart(messageBodyPart1);

			if (flag) {
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
				DataSource source = new FileDataSource(attachmentFile);
				messageBodyPart2.setDataHandler(new DataHandler(source));
				messageBodyPart2.setFileName(fileName);
				multipart.addBodyPart(messageBodyPart2);
			}
			// 6) set the multiplart object to the message object
			message.setContent(multipart);
			// 7) send message
			Transport.send(message);
			System.out.println("message sent....");
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return true;
	}
	
	
	public static HashMap<String, String> insertExecutionDetails(){
		HashMap<String, String> details = new HashMap<String, String>();
		String line="";
		try {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"/target/surefire-reports/TestSuite.txt");
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				
				if(line.contains("Tests run:")){
					String [] splitter = line.split(",");
					for (int i = 0; i < splitter.length; i++) {
						if(splitter[i].contains("Tests run:")){
							String [] mapper = splitter[i].split(":");
							details.put("totalCases", mapper[1].trim());
						}else if(splitter[i].contains("Failures")){
							String [] mapper = splitter[i].split(":");
							details.put("failures", mapper[1].trim());
						}else if(splitter[i].contains("Errors")){
							String [] mapper = splitter[i].split(":");
							details.put("errors", mapper[1].trim());
						}else if(splitter[i].contains("Skipped")){
							String [] mapper = splitter[i].split(":");
							details.put("skipped", mapper[1].trim());
						}else if(splitter[i].contains("Time elapsed:")){
							String [] mapper = splitter[i].split(":");
							mapper[1] = mapper[1].substring(0, mapper[1].indexOf("sec"));
							details.put("time", mapper[1].trim());
						}
						
					}
					System.out.println(line);	
					System.out.println(details);
					break;
				}
				
			}
			
			fr.close();
			br.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;
	}
	
    public static String emailContent(HashMap<String, String> executionDetails){
    	
    	
		return "Hi All,<br><br>"
				+ "This is a Selenium test execution email.<br>"
				+ "Attached are the results of the Automation Test Execution from Jenkins.<br>"
				+ "This is an auto-generated email.<br><br>"
				+ ""
				+"<table width='100%' border='1' align='center'>"
        		+"<tr align='center'>"
        			+ "<th><b>Total Test Cases<b></th>"
        			+ "<th><b>Failures<b></th>"
        			+ "<th><b>Errors<b></th>"
        			+ "<th><b>Skipped<b></th>"
        			+ "<th><b>Time (Sec)<b></th>"
        		+"</tr>"
        		+"<tr align='center'>"
    			+ "<td>"+executionDetails.get("totalCases")+"</td>"
    			+ "<td>"+executionDetails.get("failures")+"</td>"
    			+ "<td>"+executionDetails.get("errors")+"</td>"
    			+ "<td>"+executionDetails.get("skipped")+"</td>"
    			+ "<td>"+executionDetails.get("time")+"</td>"
    			+"</tr>"
        		+"</table>"
				+ "<br>-----------------------<br>"
				+ "Thanks & Regards,<br>"
				+ "Jenkins Executer<br>";
		}
    
	public static final String emailText = ""
			+ "Hi All,\n\n"
			+ "This is a Selenium test execution email.\n"
			+ "Attached are the results of the Automation Test Execution from Jenkins.\n"
			+ "This is an auto-generated email.\n\n"
			+ ""
			+ "-----------------------\n"
			+ "Thanks & Regards,\n"
			+ System.getProperty("user.name");
	
	
	
	
}
