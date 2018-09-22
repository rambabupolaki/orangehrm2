package selenium.framework.pojo;

public class JobPojo {
String jobTitle;
String jobDescription;
String jobSpecification;
String note;
public String getJobTitle()
{
	if(jobTitle==null)
	{
		jobTitle="Marketing";
	}
	return jobTitle;
}
public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}

public String getJobDescription()
{
	if(jobDescription==null)
	{
		jobDescription="Testing";
	}
	return jobDescription;
}
public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}

public String getJobSpecification()
{
	if(jobSpecification==null)
	{
		jobSpecification="E:\\Anusha\\Manual\\Pictures\\123.png";
	}
	return jobSpecification;
}
public void setJobSpecification(String jobSpecification) {
	this.jobSpecification = jobSpecification;
}

public String getNote()
{
	if(note==null)
	{
		note="Testing note";
	}
	return note;
}
public void setNote(String note) {
	this.note = note;
}
}


