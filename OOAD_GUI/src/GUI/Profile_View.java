package GUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StackLayout;

import java.awt.*;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import ClassFiles.Course;
import ClassFiles.Profile;
import ClassFiles.*;
public class Profile_View
{
	boolean isStu;
	int idDB;
	Profile_View(int id,boolean isStudent){
		isStu=isStudent;
		idDB=id;
	}
	protected Shell shlPutIdHere;
	private static Text txtFrmDatabase;
	private static Text bookDB1;
	private static Text bookDB2;
	private static Text bookDB3;
	private static Text bookDB4;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents(display);
		shlPutIdHere.open();
		shlPutIdHere.layout();
		while (!shlPutIdHere.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}
	public void createContents (Display display) {
		shlPutIdHere = new Shell();
		shlPutIdHere.setSize(478, 748);
		shlPutIdHere.setText("put id here");
		shlPutIdHere.setLayout(new FillLayout());
		System.out.println(idDB);
		Student student = new Student (idDB);
		Instructor instruc =new Instructor(idDB);
		//start accessing database here and continue filling info in everything with "from database"
		
		CTabFolder tabFolder = new CTabFolder(shlPutIdHere, SWT.NONE);
		tabFolder.setBorderVisible(false);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem profileTab = new CTabItem(tabFolder, SWT.NONE);
		profileTab.setText("Profile");
		
		Group profileGroup = new Group(tabFolder, SWT.NONE);
		profileTab.setControl(profileGroup);
		profileGroup.setLayout(null);
		
		final Label namF = new Label(profileGroup, SWT.NONE);
		namF.setBounds(21, 97, 149, 35);
		namF.setText("First Name");
		
		Label fnam = new Label(profileGroup, SWT.SHADOW_IN);
		fnam.setText("from database");
		fnam.setBounds(176, 97, 234, 35);
		
		Label namL = new Label(profileGroup, SWT.NONE);
		namL.setText("Last Name");
		namL.setBounds(21, 138, 149, 35);
		
		Label lnam = new Label(profileGroup, SWT.NONE);
		lnam.setText("from database");
		lnam.setBounds(176, 138, 234, 35);
		
		Label gen = new Label(profileGroup, SWT.NONE);
		gen.setText("Gender");
		gen.setBounds(21, 179, 149, 35);
		
		Label genL = new Label(profileGroup, SWT.NONE);
		genL.setText("from database");
		genL.setBounds(176, 179, 234, 35);
		
		Label dob = new Label(profileGroup, SWT.NONE);
		dob.setText("Date Of Birth");
		dob.setBounds(21, 220, 149, 35);
		
		Label dobL = new Label(profileGroup, SWT.NONE);
		dobL.setText("from database");
		dobL.setBounds(176, 220, 234, 35);
		
		Label dept = new Label(profileGroup, SWT.NONE);
		dept.setText("Department");
		dept.setBounds(21, 261, 149, 35);
		
		Label deptL = new Label(profileGroup, SWT.NONE);
		deptL.setText("from database");
		deptL.setBounds(176, 261, 234, 35);
		
		Label enrYr = new Label(profileGroup, SWT.NONE);
		enrYr.setText("Enrolled Year");
		enrYr.setBounds(21, 467, 149, 35);
		
		Label enrL = new Label(profileGroup, SWT.NONE);
		enrL.setText("from database");
		enrL.setBounds(176, 467, 234, 35);
		
		Label addr = new Label(profileGroup, SWT.NONE);
		addr.setText("Address");
		addr.setBounds(21, 302, 149, 35);
		
		Label addrL = new Label(profileGroup, SWT.NONE);
		addrL.setText("from database");
		addrL.setBounds(176, 302, 234, 159);
		
		
		
		
		CTabItem regedCourTab = new CTabItem(tabFolder, SWT.NONE);
		regedCourTab.setText("Courses Registered");
		
		Group regedCourGroup = new Group(tabFolder, SWT.NONE);
		regedCourTab.setControl(regedCourGroup);
		
		Button course1Button = new Button(regedCourGroup, SWT.RADIO);
		course1Button.setEnabled(false);
		course1Button.setBounds(10, 10, 214, 25);
		course1Button.setText("------");
		
		Button course3Button = new Button(regedCourGroup, SWT.RADIO);
		course3Button.setEnabled(false);
		course3Button.setText("------");
		course3Button.setBounds(227, 10, 214, 25);
		
		Button course2Button = new Button(regedCourGroup, SWT.RADIO);
		course2Button.setEnabled(false);
		course2Button.setText("------");
		course2Button.setBounds(10, 41, 214, 25);
		
		Button course4Button = new Button(regedCourGroup, SWT.RADIO);
		course4Button.setEnabled(false);
		course4Button.setText("------");
		course4Button.setBounds(227, 41, 214, 25);
		
		Label sep = new Label(regedCourGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		sep.setBounds(60, 190, 381, 2);
		
		Label det = new Label(regedCourGroup, SWT.NONE);
		det.setText("Details");
		det.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		det.setBounds(11, 179, 41, 19);
		
		Group cour1grp = new Group(regedCourGroup, SWT.NONE);
		cour1grp.setBounds(0, 198, 442, 460);
		cour1grp.setVisible(false);
		
		Label dept1 = new Label(cour1grp, SWT.NONE);
		dept1.setText("Department");
		dept1.setBounds(10, 51, 149, 35);
		
		Label term1 = new Label(cour1grp, SWT.NONE);
		term1.setText("Term");
		term1.setBounds(10, 92, 149, 35);
		
		Label crdt1 = new Label(cour1grp, SWT.NONE);
		crdt1.setText("Credits");
		crdt1.setBounds(10, 133, 149, 35);
		
		Label cls1 = new Label(cour1grp, SWT.NONE);
		cls1.setText("Classroom No");
		cls1.setBounds(10, 174, 149, 35);
		
		Label courid1 = new Label(cour1grp, SWT.NONE);
		courid1.setText("Course ID");
		courid1.setBounds(10, 10, 149, 35);
		
		Label book1 = new Label(cour1grp, SWT.NONE);
		book1.setText("Reference Book");
		book1.setBounds(10, 215, 149, 35);
		
		Label idDB1 = new Label(cour1grp, SWT.NONE);
		idDB1.setText("from database");
		idDB1.setBounds(193, 10, 237, 35);
		
		Label dptDB1 = new Label(cour1grp, SWT.NONE);
		dptDB1.setText("from database");
		dptDB1.setBounds(193, 51, 237, 35);
		
		Label trmDB1 = new Label(cour1grp, SWT.NONE);
		trmDB1.setText("from database");
		trmDB1.setBounds(193, 92, 237, 35);
		
		Label crdtDB1 = new Label(cour1grp, SWT.NONE);
		crdtDB1.setText("from database");
		crdtDB1.setBounds(193, 133, 237, 35);
		
		Label clsDB1 = new Label(cour1grp, SWT.NONE);
		clsDB1.setText("from database");
		clsDB1.setBounds(193, 174, 237, 35);
		
		Label noOfStu1 = new Label(cour1grp, SWT.NONE);
		noOfStu1.setText("No of Students\r\n registered");
		noOfStu1.setBounds(10, 327, 149, 54);
		
		Label noOfStuDB1 = new Label(cour1grp, SWT.NONE);
		noOfStuDB1.setText("from database");
		noOfStuDB1.setBounds(193, 327, 237, 35);
		
		bookDB1 = new Text(cour1grp, SWT.CENTER | SWT.MULTI);
		bookDB1.setText("frm database");
		bookDB1.setEditable(false);
		bookDB1.setBounds(193, 215, 237, 106);
		
		
		//cour 2
		Group cour2grp = new Group(regedCourGroup, SWT.NONE);
		cour2grp.setBounds(0, 198, 452, 460);
		cour2grp.setVisible(false);
		
		Label dept2 = new Label(cour2grp, SWT.NONE);
		dept2.setText("Department");
		dept2.setBounds(10, 51, 149, 35);
		
		Label term2 = new Label(cour2grp, SWT.NONE);
		term2.setText("Term");
		term2.setBounds(10, 92, 149, 35);
		
		Label crdt2 = new Label(cour2grp, SWT.NONE);
		crdt2.setText("Credits");
		crdt2.setBounds(10, 133, 149, 35);
		
		Label cls2 = new Label(cour2grp, SWT.NONE);
		cls2.setText("Classroom No");
		cls2.setBounds(10, 174, 149, 35);
		
		Label courid2 = new Label(cour2grp, SWT.NONE);
		courid2.setText("Course ID");
		courid2.setBounds(10, 10, 149, 35);
		
		Label book2 = new Label(cour2grp, SWT.NONE);
		book2.setText("Reference Book");
		book2.setBounds(10, 215, 149, 35);
		
		Label idDB2 = new Label(cour2grp, SWT.NONE);
		idDB2.setText("from database");
		idDB2.setBounds(193, 10, 237, 35);
		
		Label dptDB2 = new Label(cour2grp, SWT.NONE);
		dptDB2.setText("from database");
		dptDB2.setBounds(193, 51, 237, 35);
		
		Label trmDB2 = new Label(cour2grp, SWT.NONE);
		trmDB2.setText("from database");
		trmDB2.setBounds(193, 92, 237, 35);
		
		Label crdtDB2 = new Label(cour2grp, SWT.NONE);
		crdtDB2.setText("from database");
		crdtDB2.setBounds(193, 133, 237, 35);
		
		Label clsDB2 = new Label(cour2grp, SWT.NONE);
		clsDB2.setText("from database");
		clsDB2.setBounds(193, 174, 237, 35);
		
		Label noOfStu2 = new Label(cour2grp, SWT.NONE);
		noOfStu2.setText("No of Students\r\n registered");
		noOfStu2.setBounds(10, 327, 149, 54);
		
		Label noOfStuDB2 = new Label(cour2grp, SWT.NONE);
		noOfStuDB2.setText("from database2");
		noOfStuDB2.setBounds(193, 327, 237, 35);
		
		bookDB2 = new Text(cour2grp, SWT.CENTER | SWT.MULTI);
		bookDB2.setText("frm database");
		bookDB2.setEditable(false);
		bookDB2.setBounds(193, 215, 237, 106);
		
		//cour3
		Group cour3grp = new Group(regedCourGroup, SWT.NONE);
		cour3grp.setBounds(0, 198, 452, 460);
		cour3grp.setVisible(false);
		
		Label dept3 = new Label(cour3grp, SWT.NONE);
		dept3.setText("Department");
		dept3.setBounds(10, 51, 149, 35);
		
		Label term3 = new Label(cour3grp, SWT.NONE);
		term3.setText("Term");
		term3.setBounds(10, 92, 149, 35);
		
		Label crdt3 = new Label(cour3grp, SWT.NONE);
		crdt3.setText("Credits");
		crdt3.setBounds(10, 133, 149, 35);
		
		Label cls3 = new Label(cour3grp, SWT.NONE);
		cls3.setText("Classroom No");
		cls3.setBounds(10, 174, 149, 35);
		
		Label courid3 = new Label(cour3grp, SWT.NONE);
		courid3.setText("Course ID");
		courid3.setBounds(10, 10, 149, 35);
		
		Label book3 = new Label(cour3grp, SWT.NONE);
		book3.setText("Reference Book");
		book3.setBounds(10, 215, 149, 35);
		
		Label idDB3 = new Label(cour3grp, SWT.NONE);
		idDB3.setText("from database");
		idDB3.setBounds(193, 10, 237, 35);
		
		Label dptDB3 = new Label(cour3grp, SWT.NONE);
		dptDB3.setText("from database");
		dptDB3.setBounds(193, 51, 237, 35);
		
		Label trmDB3 = new Label(cour3grp, SWT.NONE);
		trmDB3.setText("from database");
		trmDB3.setBounds(193, 92, 237, 35);
		
		Label crdtDB3 = new Label(cour3grp, SWT.NONE);
		crdtDB3.setText("from database");
		crdtDB3.setBounds(193, 133, 237, 35);
		
		Label clsDB3 = new Label(cour3grp, SWT.NONE);
		clsDB3.setText("from database");
		clsDB3.setBounds(193, 174, 237, 35);
		
		Label noOfStu3 = new Label(cour3grp, SWT.NONE);
		noOfStu3.setText("No of Students\r\n registered");
		noOfStu3.setBounds(10, 327, 149, 54);
		
		Label noOfStuDB3 = new Label(cour3grp, SWT.NONE);
		noOfStuDB3.setText("from database3");
		noOfStuDB3.setBounds(193, 327, 237, 35);
		
		bookDB3 = new Text(cour3grp, SWT.CENTER | SWT.MULTI);
		bookDB3.setText("frm database");
		bookDB3.setEditable(false);
		bookDB3.setBounds(193, 215, 237, 106);
		
		
		Group cour4grp = new Group(regedCourGroup, SWT.NONE);
		cour4grp.setBounds(0, 198, 452, 460);
		cour4grp.setVisible(false);
		
		Label dept4 = new Label(cour4grp, SWT.NONE);
		dept4.setText("Department");
		dept4.setBounds(10, 51, 149, 35);
		
		Label term4 = new Label(cour4grp, SWT.NONE);
		term4.setText("Term");
		term4.setBounds(10, 92, 149, 35);
		
		Label crdt4 = new Label(cour4grp, SWT.NONE);
		crdt4.setText("Credits");
		crdt4.setBounds(10, 133, 149, 35);
		
		Label cls4 = new Label(cour4grp, SWT.NONE);
		cls4.setText("Classroom No");
		cls4.setBounds(10, 174, 149, 35);
		
		Label courid4 = new Label(cour4grp, SWT.NONE);
		courid4.setText("Course ID");
		courid4.setBounds(10, 10, 149, 35);
		
		Label book4 = new Label(cour4grp, SWT.NONE);
		book4.setText("Reference Book");
		book4.setBounds(10, 215, 149, 35);
		
		Label idDB4 = new Label(cour4grp, SWT.NONE);
		idDB4.setText("from database");
		idDB4.setBounds(193, 10, 237, 35);
		
		Label dptDB4 = new Label(cour4grp, SWT.NONE);
		dptDB4.setText("from database");
		dptDB4.setBounds(193, 51, 237, 35);
		
		Label trmDB4 = new Label(cour4grp, SWT.NONE);
		trmDB4.setText("from database");
		trmDB4.setBounds(193, 92, 237, 35);
		
		Label crdtDB4 = new Label(cour4grp, SWT.NONE);
		crdtDB4.setText("from database");
		crdtDB4.setBounds(193, 133, 237, 35);
		
		Label clsDB4 = new Label(cour4grp, SWT.NONE);
		clsDB4.setText("from database");
		clsDB4.setBounds(193, 174, 237, 35);
		
		Label noOfStu4 = new Label(cour4grp, SWT.NONE);
		noOfStu4.setText("No of Students\r\n registered");
		noOfStu4.setBounds(10, 327, 149, 54);
		
		Label noOfStuDB4 = new Label(cour4grp, SWT.NONE);
		noOfStuDB4.setText("from database4");
		noOfStuDB4.setBounds(193, 327, 237, 35);
		
		bookDB4 = new Text(cour4grp, SWT.CENTER | SWT.MULTI);
		bookDB4.setText("frm database");
		bookDB4.setEditable(false);
		bookDB4.setBounds(193, 215, 237, 106);
		
		
		CTabItem regCourTab = new CTabItem(tabFolder, SWT.NONE);
		regCourTab.setText("Register Course");
		
		Group regCourGroup = new Group(tabFolder, SWT.NONE);
		regCourTab.setControl(regCourGroup);
		
		CCombo combo = new CCombo(regCourGroup, SWT.BORDER);
		combo.setItems(new String[] {"Introduction To Object Oriented Programming ", "Object Oriented Analysis And Design", "Optics And Electrodynamics", "Thermodynamics", "Data Structures", "Discrete Mathmatics"});
		combo.setText("Courses Available");
		combo.setBounds(28, 39, 243, 30);
		
		Label lblCoursesDetails = new Label(regCourGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblCoursesDetails.setBounds(59, 188, 381, 2);
		
		Label lblDetails = new Label(regCourGroup, SWT.NONE);
		lblDetails.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblDetails.setBounds(10, 177, 41, 19);
		lblDetails.setText("Details");
		
		Button btnRegister = new Button(regCourGroup, SWT.CENTER);
		btnRegister.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnRegister.setBounds(28, 113, 105, 35);
		btnRegister.setText("Register");
		
		Label deptLbl = new Label(regCourGroup, SWT.NONE);
		deptLbl.setText("Department");
		deptLbl.setBounds(20, 248, 149, 35);
		
		Label termL = new Label(regCourGroup, SWT.NONE);
		termL.setText("Term");
		termL.setBounds(20, 289, 149, 35);
		
		Label crdtsL = new Label(regCourGroup, SWT.NONE);
		crdtsL.setText("Credits");
		crdtsL.setBounds(20, 330, 149, 35);
		
		Label classL = new Label(regCourGroup, SWT.NONE);
		classL.setText("Classroom No");
		classL.setBounds(20, 371, 149, 35);
		
		Label courIDL = new Label(regCourGroup, SWT.NONE);
		courIDL.setText("Course ID");
		courIDL.setBounds(20, 207, 149, 35);
		
		Label booksL = new Label(regCourGroup, SWT.NONE);
		booksL.setText("Reference Book");
		booksL.setBounds(20, 412, 149, 35);
		
		Label IDDisp = new Label(regCourGroup, SWT.NONE);
		IDDisp.setText("from database");
		IDDisp.setBounds(203, 207, 237, 35);
		
		Label deptDisp = new Label(regCourGroup, SWT.NONE);
		deptDisp.setText("from database");
		deptDisp.setBounds(203, 248, 237, 35);
		
		Label termDisp = new Label(regCourGroup, SWT.NONE);
		termDisp.setText("from database");
		termDisp.setBounds(203, 289, 237, 35);
		
		Label crdtsDisp = new Label(regCourGroup, SWT.NONE);
		crdtsDisp.setText("from database");
		crdtsDisp.setBounds(203, 330, 237, 35);
		
		Label clsnoDisp = new Label(regCourGroup, SWT.NONE);
		clsnoDisp.setText("from database");
		clsnoDisp.setBounds(203, 371, 237, 35);
		
		txtFrmDatabase = new Text(regCourGroup, SWT.CENTER | SWT.MULTI);
		txtFrmDatabase.setText("frm database");
		txtFrmDatabase.setEditable(false);
		txtFrmDatabase.setBounds(203, 412, 237, 106);
		
		Label lblSorryMaxStrength = new Label(regCourGroup, SWT.NONE);
		lblSorryMaxStrength.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblSorryMaxStrength.setBounds(92, 75, 248, 25);
		lblSorryMaxStrength.setText("Sorry!!!! max strength reached.");
		lblSorryMaxStrength.setVisible(false);
		
		course1Button.setEnabled(true);
		course2Button.setEnabled(true);
		
 
		
		//when we load the profile we load all the data of the courses 
		//and enable the radio buttons required and set there names
		// and set the data of the courses in the corresponding group 
		
		shlPutIdHere.open();
		Course course[];
		if(isStu)course=student.getCourses();
		else course = instruc.getCourses();
		while (shlPutIdHere.isDisposed ()) {
			if(course1Button.getSelection()&&course1Button.getEnabled()){
				cour1grp.setVisible(true);
				cour2grp.setVisible(false);
				cour3grp.setVisible(false);
				cour4grp.setVisible(false);
				idDB1.setText(""+course[0].number);
				dptDB1.setText(course[0].department);
				trmDB1.setText(""+course[0].term);
				crdtDB1.setText(""+course[0].credits);
				clsDB1.setText(course[0].classroom_id+"");
				noOfStuDB1.setText(""+course[0].numberOfStudents);
				bookDB1.setText(course[0].textbooks);
				
			}
			else if(course2Button.getSelection()&&course2Button.getEnabled()){
				cour1grp.setVisible(false);
				cour2grp.setVisible(true);
				cour3grp.setVisible(false);
				cour4grp.setVisible(false);
				idDB2.setText(""+course[1].number);
				dptDB2.setText(course[1].department);
				trmDB2.setText(""+course[1].term);
				crdtDB2.setText(""+course[1].credits);
				clsDB2.setText(course[1].classroom_id+"");
				noOfStuDB2.setText(""+course[1].numberOfStudents);
				bookDB2.setText(course[1].textbooks);
			}
			else if(course3Button.getSelection()&&course3Button.getEnabled()){
				cour1grp.setVisible(false);
				cour2grp.setVisible(false);
				cour3grp.setVisible(true);
				cour4grp.setVisible(false);
				idDB3.setText(""+course[2].number);
				dptDB3.setText(course[2].department);
				trmDB3.setText(""+course[2].term);
				crdtDB3.setText(""+course[2].credits);
				clsDB3.setText(course[2].classroom_id+"");
				noOfStuDB3.setText(""+course[2].numberOfStudents);
				bookDB3.setText(course[2].textbooks);
			}
			else if(course4Button.getSelection()&&course4Button.getEnabled()){
				cour1grp.setVisible(false);
				cour2grp.setVisible(false);
				cour3grp.setVisible(false);
				cour4grp.setVisible(true);
				idDB4.setText(""+course[3].number);
				dptDB4.setText(course[3].department);
				trmDB4.setText(""+course[3].term);
				crdtDB4.setText(""+course[3].credits);
				clsDB4.setText(course[3].classroom_id+"");
				noOfStuDB4.setText(""+course[3].numberOfStudents);
				bookDB4.setText(course[3].textbooks);
			}
			
			if (!display.readAndDispatch ()) display.sleep ();
		}
		System.out.println("segese");
		display.dispose ();
		
	}
}