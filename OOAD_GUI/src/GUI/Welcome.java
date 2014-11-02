package GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import Database.*;
public class Welcome {

	protected Shell INSTI;
	private Text studentID;
	private Text instructorID;
	private Text password;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Welcome window = new Welcome();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		INSTI.open();
		INSTI.layout();
		while (!INSTI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		INSTI = new Shell();
		INSTI.setSize(450, 300);
		INSTI.setText("Institute Login");
		
		
		studentID = new Text(INSTI, SWT.BORDER);
		studentID.setBounds(153, 98, 92, 21);
		studentID.setVisible(false);
		
		instructorID = new Text(INSTI, SWT.BORDER);
		instructorID.setBounds(153, 98, 92, 21);
		instructorID.setVisible(false);
		
		password = new Text(INSTI, SWT.BORDER);
		password.setBounds(153, 133, 93, 21);
		password.setVisible(false);
		password.setEchoChar('*');
		
		final Label stuLabel = new Label(INSTI, SWT.NONE);
		stuLabel.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		stuLabel.setBounds(47, 98, 71, 21);
		stuLabel.setText("Student ID");
		stuLabel.setVisible(false);
		
		final Label instLabel = new Label(INSTI, SWT.NONE);
		instLabel.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		instLabel.setBounds(47, 98, 71, 21);
		instLabel.setText("Instructor ID");
		instLabel.setVisible(false);
		
		final Label pass = new Label(INSTI, SWT.NONE);
		pass.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		pass.setBounds(47, 134, 71, 21);
		pass.setText("Password");
		pass.setVisible(false);
		
		Button studentButton = new Button(INSTI, SWT.NONE);
		
		studentButton.setBounds(200, 23, 136, 25);
		studentButton.setText("Students Login");
		studentButton.setVisible(true);
		
		final Button loginButton = new Button(INSTI, SWT.NONE);
		loginButton.setBounds(183, 190, 63, 21);
		loginButton.setText("Login");
		loginButton.setVisible(false);
		
		final Button registerButton = new Button(INSTI, SWT.NONE);
		registerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Registration reg=new Registration();
				boolean temp = studentID.getVisible();
				//System.out.println(temp);
				INSTI.close();
				//reg.isStudent = studentID.getVisible();
				reg.open(temp);
			}
		});
		registerButton.setBounds(183, 226, 63, 21);
		registerButton.setText("Register");
		registerButton.setVisible(false);
		
		Button instructorButton = new Button(INSTI, SWT.NONE);
		instructorButton.setBounds(63, 23, 136, 25);
		instructorButton.setText("Instructors Login");
		
		final Label errorM = new Label(INSTI, SWT.NONE);
		errorM.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		errorM.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		errorM.setBounds(153, 54, 92, 21);
		errorM.setText("incorrect login!!!!!");
		errorM.setVisible(false);
		instructorButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				studentID.setVisible(false);
				stuLabel.setVisible(false);
				instLabel.setVisible(true);
				instructorID.setVisible(true);
				pass.setVisible(true);
				password.setVisible(true);
				loginButton.setVisible(true);
				registerButton.setVisible(true);
				
			}
			
		});
		
		
		studentButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				instLabel.setVisible(false);
				instructorID.setVisible(false);
				studentID.setVisible(true);
				stuLabel.setVisible(true);
				pass.setVisible(true);
				password.setVisible(true);
				loginButton.setVisible(true);
				registerButton.setVisible(true);
			}
		});
		loginButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String passw;
				int user;
				boolean isStudent=true;
				if(studentID.getVisible())user = Integer.parseInt(studentID.getText());
				else {
					user = Integer.parseInt(instructorID.getText());
					isStudent = false;
				}
				passw = password.getText();
				CheckLogin check = new CheckLogin();
				if(check.check(user, passw)){
					Profile_View next = new Profile_View(user, isStudent);
					INSTI.close();
					next.open();
				}
				else errorM.setVisible(true);//show error message 
			}
		});

	}
}
