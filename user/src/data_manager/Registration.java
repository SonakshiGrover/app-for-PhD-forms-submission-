/*
 * @author Sonakshi Grover 2014106 and divam gupta 2014038
 * */

package data_manager;


import java.io.Serializable;
import java.time.LocalDate;

public class Registration implements Serializable
{
	//all field data as strings bools , and localDate

	String name;
	String email;
	String enrollmentNumber;
	String addressOfCorrespondence;
	String mobileNumberl;
	String phsStream;
	String phdPref1;
	String phdPref2;
	String phdPref3;
	String phdPref4;
	String gender;
	String category;
	Boolean physicallyDisabled;
	LocalDate dataoOfBirth;
	Boolean warCategory;
	String fatherName;
	String nationality;
	String permanentAdress;
	String pincode;


	// schooling info
	String classXBoardName;
	Double classXBoardMarks;
	Integer classXPassingYear;
	String classXIIBoardName;
	Double classXIIBoardMarks;
	Integer classXIIPassingYear;

	//graduation info
	String graguationDegree;
	String graduationDepartment;
	String collegeName;
	String universityName;
	String graduationCity;
	String graduationState;
	Integer graduationYear;
	Double graduationCGPA;
	Double graduationMarks;


	// ece
	Boolean isApplyingForECE;
	String ecePhdPref1;
	String ecePhdPref2;
	String ecePhdPref3;
	String ecePhdPref4;

	// Post Graduation
	Boolean isPG;
	String pgGraguationDegree;
	String pgGraduationDepartment;
	String pgcollegeName;
	String pguniversityName;
	String pgGraduationCity;
	String pgGraduationState;
	Integer pgGraduationYear;
	Double pgGraduationCGPA;
	Double pgGraduationMarks;
	String pgGraduationThesisTitle;

	//other academic degrees
	Boolean hasOtherAcademicDegrees;
	String oadExamName;
	String oadSubject;
	Integer oadYear;
	Double oadScore;
	Integer oadRank;


	//GTAE
	Boolean takenGate;
	String gateArea;
	Integer gateYear;
	Double gateMarks;
	Double gateScore;
	Integer gateRank;


	String achievements;
	String resumeFileName;
	String sopFilename;
	
	LocalDate registrationDate;
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEnrollmentNumber() {
		return enrollmentNumber;
	}
	
	public void setEnrollmentNumber(String enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}
	
	public String getAddressOfCorrespondence() {
		return addressOfCorrespondence;
	}
	
	public void setAddressOfCorrespondence(String addressOfCorrespondence) {
		this.addressOfCorrespondence = addressOfCorrespondence;
	}
	
	public String getMobileNumberl() {
		return mobileNumberl;
	}
	
	public void setMobileNumberl(String mobileNumberl) {
		this.mobileNumberl = mobileNumberl;
	}
	
	public String getPhsStream() {
		return phsStream;
	}
	
	public void setPhsStream(String phsStream) {
		this.phsStream = phsStream;
	}
	
	public String getPhdPref1() {
		return phdPref1;
	}
	
	public void setPhdPref1(String phdPref1) {
		this.phdPref1 = phdPref1;
	}
	
	public String getPhdPref2() {
		return phdPref2;
	}
	
	public void setPhdPref2(String phdPref2) {
		this.phdPref2 = phdPref2;
	}
	
	public String getPhdPref3() {
		return phdPref3;
	}
	
	public void setPhdPref3(String phdPref3) {
		this.phdPref3 = phdPref3;
	}
	
	public String getPhdPref4() {
		return phdPref4;
	}
	
	public void setPhdPref4(String phdPref4) {
		this.phdPref4 = phdPref4;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Boolean getPhysicallyDisabled() {
		return physicallyDisabled;
	}
	
	public void setPhysicallyDisabled(Boolean physicallyDisabled) {
		this.physicallyDisabled = physicallyDisabled;
	}
	
	public LocalDate getDataoOfBirth() {
		return dataoOfBirth;
	}
	public void setDataoOfBirth(LocalDate dataoOfBirth) {
		this.dataoOfBirth = dataoOfBirth;
	}
	
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public Boolean getWarCategory() {
		return warCategory;
	}
	
	public void setWarCategory(Boolean warCategory) {
		this.warCategory = warCategory;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getPermanentAdress() {
		return permanentAdress;
	}
	
	public void setPermanentAdress(String permanentAdress) {
		this.permanentAdress = permanentAdress;
	}
	
	public String getPincode() {
		return pincode;
	}
	
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public String getClassXBoardName() {
		return classXBoardName;
	}
	
	public void setClassXBoardName(String classXBoardName) {
		this.classXBoardName = classXBoardName;
	}
	
	public Double getClassXBoardMarks() {
		return classXBoardMarks;
	}
	
	public void setClassXBoardMarks(Double classXBoardMarks) {
		this.classXBoardMarks = classXBoardMarks;
	}
	
	public Integer getClassXPassingYear() {
		return classXPassingYear;
	}
	public void setClassXPassingYear(Integer classXPassingYear) {
		this.classXPassingYear = classXPassingYear;
	}
	public String getClassXIIBoardName() {
		return classXIIBoardName;
	}
	public void setClassXIIBoardName(String classXIIBoardName) {
		this.classXIIBoardName = classXIIBoardName;
	}
	public Double getClassXIIBoardMarks() {
		return classXIIBoardMarks;
	}
	public void setClassXIIBoardMarks(Double classXIIBoardMarks) {
		this.classXIIBoardMarks = classXIIBoardMarks;
	}
	public Integer getClassXIIPassingYear() {
		return classXIIPassingYear;
	}
	public void setClassXIIPassingYear(Integer classXIIPassingYear) {
		this.classXIIPassingYear = classXIIPassingYear;
	}
	public String getGraguationDegree() {
		return graguationDegree;
	}
	public void setGraguationDegree(String graguationDegree) {
		this.graguationDegree = graguationDegree;
	}
	public String getGraduationDepartment() {
		return graduationDepartment;
	}
	public void setGraduationDepartment(String graduationDepartment) {
		this.graduationDepartment = graduationDepartment;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getGraduationCity() {
		return graduationCity;
	}
	public void setGraduationCity(String graduationCity) {
		this.graduationCity = graduationCity;
	}
	public String getGraduationState() {
		return graduationState;
	}
	public void setGraduationState(String graduationState) {
		this.graduationState = graduationState;
	}
	public Integer getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(Integer graduationYear) {
		this.graduationYear = graduationYear;
	}
	public Double getGraduationCGPA() {
		return graduationCGPA;
	}
	public void setGraduationCGPA(Double graduationCGPA) {
		this.graduationCGPA = graduationCGPA;
	}
	public Double getGraduationMarks() {
		return graduationMarks;
	}
	public void setGraduationMarks(Double graduationMarks) {
		this.graduationMarks = graduationMarks;
	}
	public Boolean getIsApplyingForECE() {
		return isApplyingForECE;
	}
	public void setIsApplyingForECE(Boolean isApplyingForECE) {
		this.isApplyingForECE = isApplyingForECE;
	}
	public String getEcePhdPref1() {
		return ecePhdPref1;
	}
	public void setEcePhdPref1(String ecePhdPref1) {
		this.ecePhdPref1 = ecePhdPref1;
	}
	public String getEcePhdPref2() {
		return ecePhdPref2;
	}
	public void setEcePhdPref2(String ecePhdPref2) {
		this.ecePhdPref2 = ecePhdPref2;
	}
	public String getEcePhdPref3() {
		return ecePhdPref3;
	}
	public void setEcePhdPref3(String ecePhdPref3) {
		this.ecePhdPref3 = ecePhdPref3;
	}
	public String getEcePhdPref4() {
		return ecePhdPref4;
	}
	public void setEcePhdPref4(String ecePhdPref4) {
		this.ecePhdPref4 = ecePhdPref4;
	}
	public Boolean getIsPG() {
		return isPG;
	}
	public void setIsPG(Boolean isPG) {
		this.isPG = isPG;
	}
	public String getPgGraguationDegree() {
		return pgGraguationDegree;
	}
	public void setPgGraguationDegree(String pgGraguationDegree) {
		this.pgGraguationDegree = pgGraguationDegree;
	}
	public String getPgGraduationDepartment() {
		return pgGraduationDepartment;
	}
	public void setPgGraduationDepartment(String pgGraduationDepartment) {
		this.pgGraduationDepartment = pgGraduationDepartment;
	}
	public String getPgcollegeName() {
		return pgcollegeName;
	}
	public void setPgcollegeName(String pgcollegeName) {
		this.pgcollegeName = pgcollegeName;
	}
	public String getPguniversityName() {
		return pguniversityName;
	}
	public void setPguniversityName(String pguniversityName) {
		this.pguniversityName = pguniversityName;
	}
	public String getPgGraduationCity() {
		return pgGraduationCity;
	}
	public void setPgGraduationCity(String pgGraduationCity) {
		this.pgGraduationCity = pgGraduationCity;
	}
	public String getPgGraduationState() {
		return pgGraduationState;
	}
	public void setPgGraduationState(String pgGraduationState) {
		this.pgGraduationState = pgGraduationState;
	}
	public Integer getPgGraduationYear() {
		return pgGraduationYear;
	}
	public void setPgGraduationYear(Integer pgGraduationYear) {
		this.pgGraduationYear = pgGraduationYear;
	}
	public Double getPgGraduationCGPA() {
		return pgGraduationCGPA;
	}
	public void setPgGraduationCGPA(Double pgGraduationCGPA) {
		this.pgGraduationCGPA = pgGraduationCGPA;
	}
	public Double getPgGraduationMarks() {
		return pgGraduationMarks;
	}
	public void setPgGraduationMarks(Double pgGraduationMarks) {
		this.pgGraduationMarks = pgGraduationMarks;
	}

	public void setPgGraduationThesisTitle(String pgGraduationThesisTitle) {
		this.pgGraduationThesisTitle = pgGraduationThesisTitle;
	}
	
	public Boolean getHasOtherAcademicDegrees() {
		return hasOtherAcademicDegrees;
	}
	
	public void setHasOtherAcademicDegrees(Boolean hasOtherAcademicDegrees) {
		this.hasOtherAcademicDegrees = hasOtherAcademicDegrees;
	}
	
	public String getOadExamName() {
		return oadExamName;
	}
	
	public void setOadExamName(String oadExamName) {
		this.oadExamName = oadExamName;
	}
	
	public String getOadSubject() {
		return oadSubject;
	}
	
	public void setOadSubject(String oadSubject) {
		this.oadSubject = oadSubject;
	}
	
	public Integer getOadYear() {
		return oadYear;
	}
	
	
	public void setOadYear(Integer oadYear) {
		this.oadYear = oadYear;
	}
	
	public Double getOadScore() {
		return oadScore;
	}
	
	public void setOadScore(Double oadScore) {
		this.oadScore = oadScore;
	}
	
	public Integer getOadRank() {
		return oadRank;
	}
	
	public void setOadRank(Integer oadRank) {
		this.oadRank = oadRank;
	}
	
	public Boolean getTakenGate() {
		return takenGate;
	}
	
	public void setTakenGate(Boolean takenGate) {
		this.takenGate = takenGate;
	}
	
	public String getGateArea() {
		return gateArea;
	}
	
	public void setGateArea(String gateArea) {
		this.gateArea = gateArea;
	}
	
	public Integer getGateYear() {
		return gateYear;
	}
	
	public void setGateYear(Integer gateYear) {
		this.gateYear = gateYear;
	}
	
	public Double getGateMarks() {
		return gateMarks;
	}
	
	public void setGateMarks(Double gateMarks) {
		this.gateMarks = gateMarks;
	}
	
	public Double getGateScore() {
		return gateScore;
	}
	
	public void setGateScore(Double gateScore) {
		this.gateScore = gateScore;
	}
	
	public Integer getGateRank() {
		return gateRank;
	}
	
	public void setGateRank(Integer gateRank) {
		this.gateRank = gateRank;
	}
	
	public String getAchievements() {
		return achievements;
	}
	
	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}
	
	public String getResumeFileName() {
		return resumeFileName;
	}
	
	public void setResumeFileName(String resumeFileName) {
		this.resumeFileName = resumeFileName;
	}
	
	public String getSopFilename() {
		return sopFilename;
	}
	
	public void setSopFilename(String sopFilename) {
		this.sopFilename = sopFilename;
	}

	@Override
	public String toString() {
		return "name= " + name + 
				 ", \n <br> email= " + email + 
				 ", \n <br> enrollmentNumber= " + enrollmentNumber + 
				 ", \n <br> addressOfCorrespondence= " + addressOfCorrespondence + 
				 ", \n <br> mobileNumberl= " + mobileNumberl + 
				 ", \n <br> phsStream= " + phsStream + 
				 ", \n <br> phdPref1= " + phdPref1 + 
				 ", \n <br> phdPref2= " + phdPref2 + 
				 ", \n <br> phdPref3= " + phdPref3 + 
				 ", \n <br> phdPref4= " + phdPref4 + 
				 ", \n <br> gender= " + gender + 
				 ", \n <br> category= " + category + 
				 ", \n <br> physicallyDisabled= " + physicallyDisabled + 
				 ", \n <br> dataoOfBirth= " + dataoOfBirth + 
				 ", \n <br> warCategory= " + warCategory + 
				 ", \n <br> fatherName= " + fatherName + 
				 ", \n <br> nationality= " + nationality + 
				 ", \n <br> permanentAdress= " + permanentAdress + 
				 ", \n <br> pincode= " + pincode + 
				 ", \n <br> classXBoardName= " + classXBoardName + 
				 ", \n <br> classXBoardMarks= " + classXBoardMarks + 
				 ", \n <br> classXPassingYear= " + classXPassingYear + 
				 ", \n <br> classXIIBoardName= " + classXIIBoardName + 
				 ", \n <br> classXIIBoardMarks= " + classXIIBoardMarks + 
				 ", \n <br> classXIIPassingYear= " + classXIIPassingYear + 
				 ", \n <br> graguationDegree= " + graguationDegree + 
				 ", \n <br> graduationDepartment= " + graduationDepartment + 
				 ", \n <br> collegeName= " + collegeName + 
				 ", \n <br> universityName= " + universityName + 
				 ", \n <br> graduationCity= " + graduationCity + 
				 ", \n <br> graduationState= " + graduationState + 
				 ", \n <br> graduationYear= " + graduationYear + 
				 ", \n <br> graduationCGPA= " + graduationCGPA + 
				 ", \n <br> graduationMarks= " + graduationMarks + 
				 ", \n <br> isApplyingForECE= " + isApplyingForECE + 
				 ", \n <br> ecePhdPref1= " + ecePhdPref1 + 
				 ", \n <br> ecePhdPref2= " + ecePhdPref2 + 
				 ", \n <br> ecePhdPref3= " + ecePhdPref3 + 
				 ", \n <br> ecePhdPref4= " + ecePhdPref4 + 
				 ", \n <br> isPG= " + isPG + 
				 ", \n <br> pgGraguationDegree= " + pgGraguationDegree + 
				 ", \n <br> pgGraduationDepartment= " + pgGraduationDepartment + 
				 ", \n <br> pgcollegeName= " + pgcollegeName + 
				 ", \n <br> pguniversityName= " + pguniversityName + 
				 ", \n <br> pgGraduationCity= " + pgGraduationCity + 
				 ", \n <br> pgGraduationState= " + pgGraduationState + 
				 ", \n <br> pgGraduationYear= " + pgGraduationYear + 
				 ", \n <br> pgGraduationCGPA= " + pgGraduationCGPA + 
				 ", \n <br> pgGraduationMarks= " + pgGraduationMarks + 
				 ", \n <br> pgGraduationThesisTitle= " + pgGraduationThesisTitle + 
				 ", \n <br> hasOtherAcademicDegrees= " + hasOtherAcademicDegrees + 
				 ", \n <br> oadExamName= " + oadExamName + 
				 ", \n <br> oadSubject= " + oadSubject + 
				 ", \n <br> oadYear= " + oadYear + 
				 ", \n <br> oadScore= " + oadScore + 
				 ", \n <br> oadRank= " + oadRank + 
				 ", \n <br> takenGate= " + takenGate + 
				 ", \n <br> gateArea= " + gateArea + 
				 ", \n <br> gateYear= " + gateYear + 
				 ", \n <br> gateMarks= " + gateMarks + 
				 ", \n <br> gateScore= " + gateScore + 
				 ", \n <br> gateRank= " + gateRank + 
				 ", \n <br> achievements= " + achievements + 
				 ", \n <br> resumeFileName= " + resumeFileName + 
				 ", \n <br> sopFilename= " + sopFilename +
				 "timestamp = "   + registrationDate; 
	}	

}