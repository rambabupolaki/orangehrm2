package selenium.framework.common;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class CommonMethods extends Reporting {
/*	static String employeeNames = "Moshe, Mccune, Denis, Kemper, Cristobal, Wylie, Oswaldo, Hudgens, Bryon, Craven, Abe, Tackett, Billie, Villegas, Delmer, Shipman, Erich, Callaway, Arnulfo, Barba, Cliff, Craft, Deon, Savoy, Kris, Hooks, Denny, Brantley, Hyman, Hoppe, Bryce, Grice"
			+ "Linwood, Conn, Arden, Lavigne, Avery, Christie, Cleveland, Burroughs, Buck, Damon, Rickie, Weis, Gerry, Conrad, Benito, Katz, Malcom, Tomlinson, Leonardo, Bonner, Trenton, Goodson, Norberto, Dudley, Gino, Kaye, Noble, Betz, Felton, Hawthorne, Murray, Hardwick, Kenton, Mccauley"
			+ "Luciano, Adame, Cleo, Painter, Ashley, Boatwright, Johnathon, Sommer, Bart, Goins, Toney, Womack, Jewel, Bueno, Donn, Rafferty, Solomon, Scarbrough, Adolfo, Isaac, Olen, Word, Isidro, Moe, Lucio, Connelly, Lenard, Stuart, Fritz, Escobar, Maria, Crowley"
			+ "Jarvis, Gable, Douglass, Battaglia, Rupert, Guy, Marcellus, Beasley, Harlan, Burkett, Rory, Cheng, Long, Irwin, Jewell, Cheatham, Geraldo, Mccracken, Lonny, Dupont, Marcelino, Vaughan, Vito, Jernigan, Stevie, Mast, Luigi, Mcadams, Milford, Camp, Wilmer, Peck"
			+ "Josiah, Scoggins, Nickolas, Crutcher, Denver, Orosco, Emory, Broughton, Andrea, Olivo, Jere, Cano, Asa, Mcfadden, Tyree, Falk, Rodrick, Bone, Jamel, Tirado, Odis, Odom, Gil, Newell, Carey, Werner, Ellsworth, Medlock, Demarcus, Bland, Landon, Lipscomb"
			+ "Judson, Chesser, Nathanial, Houle, Del, Apodaca, Chas, Pence, Coleman, Winslow, Rosario, Spivey, Valentine, Burkhart, Hong, Ragsdale, Mohamed, Fort, Jefferson, Strunk, Irwin, Lapointe, Curt, Whitfield, Rigoberto, Skelton, Eldridge, Martell, Chi, Gooden, Rubin, Frias, Hassan, Ahrens, Rudolf, Foust, Jc, Gracia";
*/
	static String userNames = "moshe, mccune, denis, kemper, cristobal, wylie, oswaldo, hudgens, bryon, craven, abe, tackett, billie, villegas, delmer, shipman, erich, callaway, arnulfo, barba, cliff, craft, deon, savoy, kris, hooks, denny, brantley, hyman, hoppe, bryce, grice"
			+ "linwood, conn, arden, lavigne, avery, christie, cleveland, burroughs, buck, damon, rickie, weis, gerry, conrad, benito, katz, malcom, tomlinson, leonardo, bonner, trenton, goodson, norberto, dudley, gino, kaye, noble, betz, felton, hawthorne, murray, hardwick, kenton, mccauley"
			+ "luciano, adame, cleo, painter, ashley, boatwright, johnathon, sommer, bart, goins, toney, womack, jewel, bueno, donn, rafferty, solomon, scarbrough, adolfo, isaac, olen, word, isidro, moe, lucio, connelly, lenard, stuart, fritz, escobar, maria, crowley"
			+ "jarvis, gable, douglass, battaglia, rupert, guy, marcellus, beasley, harlan, burkett, rory, cheng, long, irwin, jewell, cheatham, geraldo, mccracken, lonny, dupont, marcelino, vaughan, vito, jernigan, stevie, mast, luigi, mcadams, milford, camp, wilmer, peck"
			+ "josiah, scoggins, nickolas, crutcher, denver, orosco, emory, broughton, andrea, olivo, jere, cano, asa, mcfadden, tyree, falk, rodrick, bone, jamel, tirado, odis, odom, gil, newell, carey, werner, ellsworth, medlock, demarcus, bland, landon, lipscomb"
			+ "judson, chesser, nathanial, houle, del, apodaca, chas, pence, coleman, winslow, rosario, spivey, valentine, burkhart, hong, ragsdale, mohamed, fort, jefferson, strunk, irwin, lapointe, curt, whitfield, rigoberto, skelton, eldridge, martell, chi, gooden, rubin, frias, hassan, ahrens, rudolf, foust, jc, gracia";

	/*static String citiNstates = "New York : New York, Los Angeles : California, Chicago : Illinois, Houston : Texas, Philadelphia : Pennsylvania, San Diego : California, Dallas : Texas, Jacksonville : Florida, San Francisco : California, Fort Worth : Texas, Charlotte : North Carolina, Detroit : Michigan, Denver : Colorado, Nashville : Tennessee, "
			+ "Baltimore : Maryland, Las Vegas : Nevada, Louisville : Kentucky, Tucson : Arizona, Fresno : California, Kansas City : Missouri, Mesa : Arizona, Omaha : Nebraska, Colorado Springs : Colorado, Oakland : California, Minneapolis : Minnesota, Wichita : Kansas, New Orleans : Louisiana, Tampa : Florida, Aurora : Colorado, Santa Ana : California, "
			+ "Corpus Christi : Texas, Lexington : Kentucky, Pittsburgh : Pennsylvania, Cincinnati : Ohio, Saint Paul : Minnesota, Newark : New Jersey, Plano : Texas, Orlando : Florida, Jersey City : New Jersey, Fort Wayne : Indiana, Chandler : Arizona, Durham : North Carolina, Irvine : California, Lubbock : Texas, Gilbert : Arizona, Reno : Nevada, Hialeah : Florida, "
			+ "Irving : Texas, North Las Vegas : Nevada, Fremont : California, Richmond : Virginia, Birmingham : Alabama, Spokane : Washington, Des Moines : Iowa, Oxnard : California, Fayetteville : North Carolina, Moreno Valley : California, Yonkers : New York, Montgomery : Alabama, Shreveport : Louisiana, Akron : Ohio, Augusta : Georgia, Mobile : Alabama, Huntsville : Alabama, "
			+ "Tallahassee : Florida, Knoxville : Tennessee, Brownsville : Texas, Santa Clarita : California, Providence : Rhode Island, Oceanside : California, Rancho Cucamonga : California, Chattanooga : Tennessee, Tempe : Arizona, Cape Coral : Florida, Ontario : California, Peoria : Arizona, Pembroke Pines : Florida, Salem : Oregon, Corona : California, Palmdale : California,"
			+ " McKinney : Texas, Cary : North Carolina, Hayward : California, Macon : Georgia, Pomona : California, Sunnyvale : California, Lakewood : Colorado, Torrance : California, Hollywood : Florida, Clarksville : Tennessee, Paterson : New Jersey, Mesquite : Texas, Savannah : Georgia, Pasadena : California, Orange : California, Killeen : Texas, Hampton : Virginia, Miramar : Florida, West Valley City : Utah, "
			+ "Sterling Heights : Michigan, Thornton : Colorado, Charleston : South Carolina, Thousand Oaks : California, Elizabeth : New Jersey, Roseville : California, Stamford : Connecticut, Denton : Texas, Concord : California, Topeka : Kansas, Lafayette : Louisiana, Kent : Washington, Victorville : California, Abilene : Texas, Vallejo : California, Athens : Georgia, Norman : Oklahoma, , Beaumont : Texas, Columbia : Missouri, "
			+ "El Monte : California, Peoria : Illinois, Lansing : Michigan, Downey : California, Arvada : Colorado, Round Rock : Texas, Miami Gardens : Florida, Inglewood : California, Fairfield : California, West Jordan : Utah, Manchester : New Hampshire, Cambridge : Massachusetts, Ventura : California, Antioch : California, Billings : Montana, High Point : North Carolina, West Covina : California, Pueblo : Colorado, Norwalk : California, "
			+ "North Charleston : South Carolina, Daly City : California, Palm Bay : Florida, Burbank : California, West Palm Beach : Florida, College Station : Texas, Pearland : Texas, Santa Maria : California, Davenport : Iowa, Lakeland : Florida, Clovis : California, Edison : New Jersey, Woodbridge : New Jersey, Erie : Pennsylvania";
*/
	

	/*public String randomEmployeeNameGenerator() {
		String s;
		String dat= String.valueOf(System.currentTimeMillis());
		String dat1=dat.substring(6, 10);
		String name[] = employeeNames.split(",");
		Random random = new Random();
		String s1= name[random.nextInt(name.length)].trim();
		return s1+dat1;
		
	}*/
	public String randomUesrNameGenerator() {
		String s;
		String dat= String.valueOf(System.currentTimeMillis());
		String dat1=dat.substring(6, 10);
		String name[] = userNames.split(",");
		Random random = new Random();
		String s1= name[random.nextInt(name.length)].trim();
		return s1+dat1;
		
	}
	
	/*public String randomCitiStateNameGenerator() {
		String name[] = citiNstates.split("[\\:,]");
		Random random = new Random();
		String dat= String.valueOf(System.currentTimeMillis());
		String dat1=dat.substring(6, 10);
		String s1= name[random.nextInt(name.length)].trim();
		return s1+dat1;
	}*/

	public void closeBrowser() {
		WebDriverManager.removeWebDriver();
	}

	public void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public String generateRandomName() {
		return randomNameGenerator();
	}*/
	public  String getDateForEnrollDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now)+"T12:00:00.000Z";
	}
	public  String getDateForAcquisitionDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now)+"T"+getCurrentTime()+".000Z";
	}
	public String generateRandomtokenExpiresInMinute() {
		return generateRandomNumbers(3);
	}

	public String generateZipcode() {
		String zip = String.valueOf(System.currentTimeMillis());
		String str = zip.substring(0, 5);
		String zipcode = str + "-" + (zip.substring(6, 10)) + "," + (zip.substring(4, 9));
		return zipcode;
	}
	public String generateInvalidZipcode() {
		String zip = String.valueOf(System.currentTimeMillis());
		String str = zip.substring(0, 5);
		String zipcode = str + "-" + (zip.substring(6, 10)) + "," + (zip.substring(4, 9)+"@#");
		return zipcode;
	}
	
	public String generateSingleZipcode() {
		String zip = String.valueOf(System.currentTimeMillis());
		String str = zip.substring(0, 5);
		String zipcode = str + "-" + (zip.substring(6, 10));
		return zipcode;
	}

	public String generateRandomExpirationHours() {
		String zip = String.valueOf(System.currentTimeMillis());
		String str = zip.substring(5, 10);
		return str;
	}

	public String generateDuplicateZipcode() {
		String zip = String.valueOf(System.currentTimeMillis());
		String str = zip.substring(0, 5);
		String zipcode = str + "-" + (zip.substring(6, 10)) + "," + str + "-" + (zip.substring(6, 10));
		return zipcode;
	}

	public String randomValueOfLengthMorethan100() {
		char data = ' ';
		String dat = "";
		Random ran = new Random();
		for (int i = 0; i <= 250; i++) {
			data = (char) (ran.nextInt(25) + 97);
			dat = data + dat;
		}
		return dat;

	}

	public int generateNumber() {
		Random rand = new Random();
		int n = rand.nextInt(10) + 1;
		return n;
	}

	public String generateRandomNumbers(int length) {
		int data = 1;
		String dat = "";
		Random ran = new Random();
		for (int i = 1; i <= length; i++) {
			data = ran.nextInt(i);
			dat = data + dat;
		}
		return dat;
	}
	public String getDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now)+"T"+getCurrentTime()+".000Z";
	}
	public String getCurrentTime(){
		 Calendar cal = Calendar.getInstance();
	     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    return sdf.format(cal.getTime());
	}
	
	public String generateRandomNumbersWithLength(int length){
		String random = String.valueOf(System.currentTimeMillis());
		random = random.substring(random.length()-length, random.length());
		return random;
	}
	
	public  String getCurrentDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy"+" 0:00 ");
		LocalDateTime now = LocalDateTime.now();
		return (dtf.format(now));
	}
	public  String getCurrentDate1(){
	Calendar c = Calendar.getInstance();
	c.add(Calendar.DATE, -1);
	return new SimpleDateFormat("MM/dd/yyyy HH:mm").format(c.getTime());
}
	public String getFutureDate(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 7);
		return new SimpleDateFormat("MM/dd/yyyy"+" 0:00 ").format(c.getTime());
	}

	public String getFutureDateWithTime(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 7);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())+"T23:59:59.000Z";
	}
	public String orgId(){
		String orgId="594b51068e5ee40bdafff5bd";
		return orgId;
	}
	
	public static void main(String []args){
		CommonMethods cm = new CommonMethods();
		System.out.println(cm.getDate());
	}
}


