/*
 * @author Sonakshi Grover 2014106 and divam gupta 2014038
 * */


package registrationForm;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import data_manager.*;

public class RegistrationController {

	@FXML
    private TextField enrollmentNumber;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private TextArea addressOfCorrespondence;

    @FXML
    private TextField mobileNumberl;

    @FXML
    private ToggleGroup phsStream;

    @FXML
    private ToggleGroup gender;

    @FXML
    private ToggleGroup category;

    @FXML
    private ToggleGroup physicallyDisabled;

    @FXML
    private DatePicker dataoOfBirth;

    @FXML
    private ToggleGroup warCategory;

    @FXML
    private TextField fatherName;

    @FXML
    private TextArea permanentAdress;

    @FXML
    private TextField pincode;

    @FXML
    private ComboBox<?> phdPref1;

    @FXML
    private ComboBox<?> phdPref2;

    @FXML
    private ComboBox<?> phdPref3;

    @FXML
    private ComboBox<?> nationality;

    @FXML
    private TextField classXPassingYear;

    @FXML
    private TextField classXBoardName;

    @FXML
    private TextField classXBoardMarks;

    @FXML
    private TextField classXIIBoardMarks;

    @FXML
    private TextField classXIIBoardName;

    @FXML
    private TextField classXIIPassingYear;

    @FXML
    private TextField collegeName;

    @FXML
    private TextField graguationDegree;

    @FXML
    private TextField graduationDepartment;

    @FXML
    private TextField graduationCity;

    @FXML
    private TextField universityName;

    @FXML
    private ComboBox<?> graduationState;

    @FXML
    private ComboBox<?> graduationYear;

    @FXML
    private TextField graduationMarks;

    @FXML
    private TextField graduationCGPATotal;

    @FXML
    private TextField graduationCGPA;

    @FXML
    private RadioButton cgpaIsSelected;

    @FXML
    private ToggleGroup gicm;

    @FXML
    private GridPane eceTable;

    @FXML
    private TextField ecePhdPref3;

    @FXML
    private TextField ecePhdPref1;

    @FXML
    private TextField ecePhdPref2;

    @FXML
    private TextField ecePhdPref4;

    @FXML
    private CheckBox isApplyingForECE;

    @FXML
    private GridPane pgTable;

    @FXML
    private TextField pgcollegeName;

    @FXML
    private TextField pgGraduationCity;

    @FXML
    private TextField pgGraguationDegree;

    @FXML
    private TextField pgGraduationDepartment;

    @FXML
    private TextField pgGraduationThesisTitle;

    @FXML
    private TextField pgGraduationYear;

    @FXML
    private TextField pgGraduationMarks;

    @FXML
    private ComboBox<?> pgGraduationState;

    @FXML
    private TextField pgGraduationCGPA;

    @FXML
    private TextField pgGraduationCGPATotal;

    @FXML
    private CheckBox isPG;

    @FXML
    private GridPane otherAcademicTable;

    @FXML
    private TextField oadYear;

    @FXML
    private TextField oadExamName;

    @FXML
    private TextField oadSubject;

    @FXML
    private TextField oadRank;

    @FXML
    private TextField oadScore;

    @FXML
    private CheckBox hasOtherAcademicDegrees;

    @FXML
    private GridPane gateTable;

    @FXML
    private TextField gateMarks;

    @FXML
    private TextField gateArea;

    @FXML
    private TextField gateYear;

    @FXML
    private TextField gateRank;

    @FXML
    private TextField gateScore;

    @FXML
    private CheckBox takenGate;

    @FXML
    private Button buttonChooseCV;

    @FXML
    private Button buttonUploadSOP;

    @FXML
    private Button hoho;
    
    private String origionalCVFilePath;
    private String origionalSOPFilePath;
    
    @FXML
    public void initialize()
    {
    	
    	 System.out.println(  LocalDate.now() );
    	// DataManager d = new DataManager();
    	 enrollmentNumber.setText( DataManager.getNoOfEntries().toString() );
    	 enrollmentNumber.setDisable(true);
    	 
    	 //d.readFromFile(1);
    	System.out.println(DataManager.getAllRegistrations()  );
    }
    
    
    @FXML
    public void sibmitButtonClicked(ActionEvent event) {
    	//System.out.println( (((RadioButton)phsStream.getSelectedToggle()).getText())  );
    	if(formValidify())
    	{
    		Registration r =  getFromUI();
    		System.out.println(r);
    		
    		r.setRegistrationDate(  LocalDate.now()  );
    		writeRegistrationToFile(r , DataManager.getNoOfEntries());
    		copySOPnCV( DataManager.getNoOfEntries() );
    		DataManager.writeToFile(r);
    		
    		initialize();
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Success");
    		alert.setHeaderText("Form Filed!");
    		alert.setContentText("Form Filed!");
    		alert.showAndWait();
    		
    		
    	}
    	else
    	{
    		System.out.println("form aint valid yo");
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setHeaderText("Error in form");
    		alert.setContentText("The form is not filled properly. Please check yo!");
    		alert.showAndWait();
    	}
    
    	

    }
    
    @FXML
    public void enableDisableStuff()
    {
    	if(  isApplyingForECE.isSelected() )
    	{
    		eceTable.setDisable(false);
    	}
    	else
    	{
    		eceTable.setDisable(true);
    	}
    	
    	if(  isPG.isSelected()  )
    	{
    		pgTable.setDisable(false);
    	}
    	else
    	{
    		pgTable.setDisable(true);
    	}
    	
    	if(  hasOtherAcademicDegrees.isSelected()  )
    	{
    		otherAcademicTable.setDisable(false);
    	}
    	else
    	{
    		otherAcademicTable.setDisable(true);
    	}
    	
    	if(  takenGate.isSelected()  )
    	{
    		gateTable.setDisable(false);
    	}
    	else
    	{
    		gateTable.setDisable(true);
    	}
    	
    	
    }
    
    Boolean formValidify()
    {
    	String emailRegesRule = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$" ; // http://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
    	String noBlankRule = ".*\\S.*";
    	String mobileNumberRule = "^(\\+\\d{1,3}[- ]?)?\\d{10}$"; // http://stackoverflow.com/questions/22378736/regex-for-mobile-number-validation
    	String justIntRule = "^[0-9]+$";
    	String pincodeRule = "^[0-9]{6}$";
        String yearRule = "^[0-9]{4}$";
    	String doubleRule = "^[0-9]+([.][0-9]?)?$";
    	
    	Boolean tab1 = true;
    	
    	
    	
    	tab1 &= vilidifyTextFieldRegex(name  , noBlankRule);
    	tab1 &= vilidifyTextFieldRegex(email  , emailRegesRule);
    	tab1 &= vilidifyTextFieldRegex(enrollmentNumber  , noBlankRule);
    	tab1 &= vilidifyTextFieldRegex(mobileNumberl  , mobileNumberRule);
    	tab1 &= vilidifyTextFieldRegex(fatherName  , noBlankRule);
    	tab1 &= vilidifyTextFieldRegex(pincode  , pincodeRule);
    	tab1 &= validifyToggleGroup(phsStream);
    	tab1 &= validifyToggleGroup(gender);
    	tab1 &= validifyToggleGroup(category);
    	tab1 &= validifyToggleGroup(physicallyDisabled);
    	tab1 &= validifyToggleGroup(warCategory);
    	tab1&= validifyComboBox(phdPref1);
    	tab1&= validifyComboBox(phdPref2);
    	tab1&= validifyComboBox(phdPref3);
    	tab1&= validifyComboBox(nationality);
    	tab1&= validifydatePicker(dataoOfBirth);
    	tab1&= validifyTextArea(permanentAdress);
    	tab1&= validifyTextArea(addressOfCorrespondence);
    	
    	Boolean tab2;
    	
    
    	tab2 =    vilidifyTextFieldRegex(classXBoardName  , noBlankRule)
    			& vilidifyTextFieldRegex(classXBoardMarks  , doubleRule)
    			& (vilidifyTextFieldRegex(classXPassingYear  , yearRule) && validifyYear(classXPassingYear))
    			& vilidifyTextFieldRegex(classXIIBoardName  , noBlankRule)
    			& (vilidifyTextFieldRegex(classXIIBoardMarks  , doubleRule)&& valididyUpperLimit(classXIIBoardMarks , 100.0))
    			& (vilidifyTextFieldRegex(classXIIPassingYear  , yearRule) && validifyYear(classXIIPassingYear)); 
    	
    	

        tab2 &= vilidifyTextFieldRegex( graguationDegree, noBlankRule )
                & vilidifyTextFieldRegex( graduationDepartment, noBlankRule )
                & vilidifyTextFieldRegex( collegeName, noBlankRule )
                & vilidifyTextFieldRegex( universityName, noBlankRule )
                & vilidifyTextFieldRegex( graduationCity, noBlankRule )
                & validifyComboBox( graduationState )
                & validifyComboBox( graduationYear );
              
                
        
       if( gicm.getSelectedToggle().toString().contains("CGPA") )
    	{
        	tab2 &= (vilidifyTextFieldRegex( graduationCGPA, doubleRule ) && valididyUpperLimit(graduationCGPA , 10.0) );
    	}
        else
        {
        	tab2 &=  (vilidifyTextFieldRegex( graduationMarks, doubleRule )  && valididyUpperLimit(graduationMarks , 100.0) );
            
        }
        
        
        if(  isApplyingForECE.isSelected() )
        {
        	 tab2 &= vilidifyTextFieldRegex( ecePhdPref1, noBlankRule )
                    & vilidifyTextFieldRegex(ecePhdPref2  , noBlankRule)
                    & vilidifyTextFieldRegex(ecePhdPref3  , noBlankRule);
        }

        if( isPG.isSelected()  )
        {
             tab2 &= vilidifyTextFieldRegex( pgGraguationDegree, noBlankRule )
                    & vilidifyTextFieldRegex(pgGraduationDepartment  , noBlankRule)
                    & vilidifyTextFieldRegex(pgcollegeName  , noBlankRule)
                    & vilidifyTextFieldRegex(pgGraduationCity  , noBlankRule)
                    & validifyComboBox(pgGraduationState  )
                    &( vilidifyTextFieldRegex(pgGraduationYear  , yearRule)  && validifyYear(pgGraduationYear))
                    & (vilidifyTextFieldRegex(pgGraduationCGPA  , doubleRule) && valididyUpperLimit(pgGraduationCGPA , 10.0) )
                    & (vilidifyTextFieldRegex(pgGraduationMarks  , doubleRule)&& valididyUpperLimit(pgGraduationMarks , 100.0) )
                    & vilidifyTextFieldRegex(pgGraduationThesisTitle  , noBlankRule);
        }

        if(hasOtherAcademicDegrees.isSelected())
        {
              tab2 &= vilidifyTextFieldRegex( oadExamName, noBlankRule )
                & vilidifyTextFieldRegex( oadSubject, noBlankRule )
                & vilidifyTextFieldRegex( oadYear, yearRule )
                & vilidifyTextFieldRegex( oadScore, doubleRule ) 
                & vilidifyTextFieldRegex( oadRank, justIntRule );
        }

        if(  takenGate.isSelected()   )
        {
             tab2 &= vilidifyTextFieldRegex( gateArea, noBlankRule )
                & (vilidifyTextFieldRegex( gateYear, yearRule )  && validifyYear(gateYear))
                & (vilidifyTextFieldRegex( gateMarks, doubleRule ) && valididyUpperLimit(gateMarks , 100.0))
                & (vilidifyTextFieldRegex( gateScore, doubleRule ) && valididyUpperLimit(gateScore , 1000.0))
                & vilidifyTextFieldRegex( gateRank, justIntRule );
        }
        
        tab2 &= checkIfSOPUploded() & checkIfCVUploded();
    	
    	return tab1 & tab2;
    	
    }
    
    
    Registration getFromUI()
    {
    	Registration r = new Registration();
    	
    	
    	r.setName ( name.getText());
    	r.setEmail ( email.getText());
    	r.setEnrollmentNumber ( enrollmentNumber.getText());
    	r.setAddressOfCorrespondence ( addressOfCorrespondence.getText());
    	r.setMobileNumberl ( mobileNumberl.getText());
    	r.setPhsStream (  ((RadioButton)phsStream.getSelectedToggle()).getText()  );
    	r.setPhdPref1 ( phdPref1.getValue().toString() );
    	r.setPhdPref2 ( phdPref2.getValue().toString());
    	r.setPhdPref3 ( phdPref3.getValue().toString());
    	r.setGender ( (((RadioButton)gender.getSelectedToggle()).getText()));
    	r.setCategory ( (((RadioButton)category.getSelectedToggle()).getText()));
    	r.setPhysicallyDisabled (((RadioButton)physicallyDisabled.getSelectedToggle()).getText().equals("Yes")); 
    	r.setDataoOfBirth ( dataoOfBirth.getValue());
    	r.setWarCategory (((RadioButton)warCategory.getSelectedToggle()).getText().equals("Yes")); ;
    	r.setFatherName ( fatherName.getText());
    	r.setNationality ( nationality.getValue().toString());
    	r.setPermanentAdress ( permanentAdress.getText());
    	r.setPincode ( pincode.getText());
    	
    	
    	
    	r.setClassXBoardName ( classXBoardName.getText());
    	r.setClassXBoardMarks ( Double.parseDouble(  classXBoardMarks.getText()));
    	r.setClassXPassingYear (Integer.parseInt(classXPassingYear.getText()));
    	r.setClassXIIBoardName ( classXIIBoardName.getText());
    	r.setClassXIIBoardMarks ( Double.parseDouble(classXIIBoardMarks.getText()));
    	r.setClassXIIPassingYear ( Integer.parseInt( classXIIPassingYear.getText()));
//    	
    	
    	r.setGraguationDegree ( graguationDegree.getText());
    	r.setGraduationDepartment ( graduationDepartment.getText());
    	r.setCollegeName ( collegeName.getText());
    	r.setUniversityName ( universityName.getText());
    	r.setGraduationCity ( graduationCity.getText());
    	r.setGraduationState ( graduationState.getValue().toString());
    	r.setGraduationYear ( Integer.parseInt( graduationYear.getValue().toString()));
    	
    	 if( gicm.getSelectedToggle().toString().contains("CGPA") )
    	 {
    		 r.setGraduationCGPA ( Double.parseDouble( graduationCGPA.getText()));
    		 r.setGraduationMarks ( Double.parseDouble( graduationCGPA.getText()) / Double.parseDouble(graduationCGPATotal.getText()) * 100 );
    		 
    	 }
    	 else
    	 {
    		 r.setGraduationMarks ( Double.parseDouble( graduationMarks.getText()));
    		 r.setGraduationCGPA ( Double.parseDouble( graduationMarks.getText())*Double.parseDouble(graduationCGPATotal.getText())/100);
    	 }
    	
    	
    	
    	
    	r.setIsApplyingForECE ( isApplyingForECE.isSelected());
    	if(isApplyingForECE.isSelected())
    	{
    		r.setEcePhdPref1 ( ecePhdPref1.getText());
        	r.setEcePhdPref2 ( ecePhdPref2.getText());
        	r.setEcePhdPref3 ( ecePhdPref3.getText());
        	r.setEcePhdPref4 ( ecePhdPref4.getText());
    	}
    	
    	
    	
    	r.setIsPG ( isPG.isSelected());
    	if( isPG.isSelected()){
    		r.setPgGraguationDegree ( pgGraguationDegree.getText());
        	r.setPgGraduationDepartment ( pgGraduationDepartment.getText());
        	r.setPgcollegeName ( pgcollegeName.getText());
        	r.setPgGraduationCity ( pgGraduationCity.getText());
        	r.setPgGraduationState ( pgGraduationState.getValue().toString());
        	r.setPgGraduationYear ( Integer.parseInt( pgGraduationYear.getText() ) );
        	r.setPgGraduationCGPA ( Double.parseDouble( pgGraduationCGPA.getText()));
        	r.setPgGraduationMarks ( Double.parseDouble( pgGraduationMarks.getText()));
        	r.setPgGraduationThesisTitle ( pgGraduationThesisTitle.getText());
    	}
    	
    	
    	r.setHasOtherAcademicDegrees ( hasOtherAcademicDegrees.isSelected());
    	if( hasOtherAcademicDegrees.isSelected())
    	{
    		
        	r.setOadExamName ( oadExamName.getText());
        	r.setOadSubject ( oadSubject.getText());
        	r.setOadYear (  Integer.parseInt( oadYear.getText()));
        	r.setOadScore ( Double.parseDouble(oadScore.getText()));
        	r.setOadRank ( Integer.parseInt(oadRank.getText()));
    	}
    	
    	r.setTakenGate ( takenGate.isSelected());
    	if(takenGate.isSelected()){
    		r.setGateArea ( gateArea.getText());
        	r.setGateYear ( Integer.parseInt( gateYear.getText()));
        	r.setGateMarks ( Double.parseDouble( gateMarks.getText()));
        	r.setGateScore ( Double.parseDouble( gateScore.getText()));
        	r.setGateRank ( Integer.parseInt( gateRank.getText()));
    	}
    	
    	r.setResumeFileName(origionalCVFilePath);
    	r.setSopFilename(origionalSOPFilePath);
    	
    	
    	
    	
    	return r;
    }
    
    
    String chooseFileName()
    {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	File file = fileChooser.showOpenDialog(null);
    	
    	if(file == null)
    		return "";
    	
    	return file.toString();
    }
    
    // this method checks if a textField is valid or not and highlight that
    Boolean vilidifyTextFieldRegex(TextField  f , String regexRule)
    {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regexRule);
        java.util.regex.Matcher m = p.matcher(f.getText());
        
        if(m.matches())
        {
        	f.setStyle("-fx-control-inner-background: white");
        	return true;
        }
        else
        {
        	f.setStyle("-fx-control-inner-background: pink");
        	return false;
        }
    }
    
    Boolean valididyUpperLimit(TextField  f , Double limit)
    {
       Double p = Double.parseDouble( f.getText() );
       if( p > limit || p < 0)
       {
    	   f.setStyle("-fx-control-inner-background: pink");
       		return false;
       }
       else
       {
    	   f.setStyle("-fx-control-inner-background: white");
    	   return true;
       }
    }
    
    Boolean validifyYear(TextField  f )
    {
    	Integer curYear = LocalDate.now().getYear();
    	Integer y = Integer.parseInt(f.getText());
    	
    	
    	if( y > curYear)
    	{
    		f.setStyle("-fx-control-inner-background: pink");
        	return false;
    	}
    	else
    	{
    		f.setStyle("-fx-control-inner-background: white");
     	    return true;
    	}
    	
    }
    
    
    Boolean validifyToggleGroup(ToggleGroup t)
    {
    	if(t.getSelectedToggle() == null)
    	{
    		for(Toggle r : t.getToggles())
    		{
    			((RadioButton) r).setStyle("-fx-border-color:red");
    		}
    		
    		return false;
    	}
    	else
    	{
    		for(Toggle r : t.getToggles())
    		{
    			((RadioButton) r).setStyle("-fx-border-color:none");
    		}
    		return true;
    	}
    }
    
    Boolean validifyComboBox(ComboBox<?> c)
    {
    	if(c.getValue() == null)
    	{
    		c.setStyle("-fx-border-color:red");
    		return false;
    	}		
    	else
    	{
    		c.setStyle("-fx-border-color:none");
    		return true;
    	}
    }
    
    
    Boolean validifydatePicker(DatePicker c)
    {
    	if(c.getValue() == null || c.getValue().isAfter(LocalDate.now())  )
    	{
    		c.setStyle("-fx-border-color:red");
    		return false;
    	}		
    	else
    	{
    		c.setStyle("-fx-border-color:none");
    		return true;
    	}
    }
    
    Boolean validifyTextArea(TextArea c)
    {
    	if(c.getText().trim().equals(""))
    	{
    		c.setStyle("-fx-control-inner-background: pink");
    		return false;
    	}		
    	else
    	{
    		c.setStyle("-fx-control-inner-background: white");
    		return true;
    	}
    }
    
    Boolean checkIfCVUploded()
    {
    	if(origionalCVFilePath == null || origionalCVFilePath.equals(""))
    	{
    		buttonChooseCV.setStyle("-fx-border-color:red");
    		return false;
    	}
    	else{
    		buttonChooseCV.setStyle("-fx-border-color:white"); 
    		return true;
    	}
    }
    
    Boolean checkIfSOPUploded()
    {
    	if(origionalSOPFilePath == null || origionalSOPFilePath.equals(""))
    	{
    		buttonUploadSOP.setStyle("-fx-border-color:red");
    		return false;
    	}
    	else{
    		buttonUploadSOP.setStyle("-fx-border-color:white");
    		return true;
    	}
    }
    
    public void chooseCV()
    {
    	origionalCVFilePath = chooseFileName();
    	
    }
    
    public void chooseSOP()
    {
    	origionalSOPFilePath = chooseFileName();
    	
    }
    
   void copyFile(String s , String d)
   {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(s);
	        os = new FileOutputStream(d);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	        is.close();
	        os.close();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
   }
   
   String getFileType(String path){
       String fileType = null;
       fileType = path.substring(path.indexOf('.',path.lastIndexOf('/'))+1).toUpperCase();
       return fileType;
   }
    
    void copySOPnCV(Integer i )
    {
    	if(origionalCVFilePath == null || origionalCVFilePath.equals(""))
    		return;
    	if(origionalSOPFilePath == null ||origionalSOPFilePath.equals("") )
    		return;
    	try
    	{
    		String cvExt = getFileType(origionalCVFilePath); 
    		String sopExt = getFileType(origionalSOPFilePath); 
    		copyFile(origionalCVFilePath , "src/dbData/cv_and_sop/CV_" + i +"." +cvExt);
    		copyFile( origionalSOPFilePath , "src/dbData/cv_and_sop/SOP_" + i + "." + sopExt );
    		
    		
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	
    }
    
    void writeRegistrationToFile(Registration r , Integer i)
    {
    	
    	try
    	{
    		  FileWriter out = null;
			  out = new FileWriter(   "src/dbData/registration_html_files/" +i+ ".html"  );
			  out.write(r.toString());
			  out.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

}
