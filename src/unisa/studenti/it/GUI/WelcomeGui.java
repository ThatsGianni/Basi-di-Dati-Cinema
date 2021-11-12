package unisa.studenti.it.GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

public class WelcomeGui {

	protected Shell shell;
	Display display = new Display();
	
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WelcomeGui window = new WelcomeGui();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		shell.setSize(497, 266);
		shell.setText("Cinema");
		
		Label lblWelcome = new Label(shell, SWT.CENTER);
		lblWelcome.setAlignment(SWT.LEFT);
		lblWelcome.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblWelcome.setFont(SWTResourceManager.getFont("HP Simplified", 21, SWT.NORMAL));
		lblWelcome.setBounds(10, 16, 286, 34);
		lblWelcome.setText("Welcome to Cinema");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				if(combo.getText().equals("Accedi")) {

					display.close();
					LoginGui window = new LoginGui();
					window.open();
					
						
				}
				if(combo.getText().equals("Registrati")) {
					display.close();
					RegistrazioneGui window = new RegistrazioneGui();
					window.open();
					
				}
			}
		});
		combo.setFont(SWTResourceManager.getFont("HP Simplified Hans", 12, SWT.NORMAL));
		combo.setItems("Accedi","Registrati");
		combo.setBounds(272, 75, 175, 31);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel.setFont(SWTResourceManager.getFont("HP Simplified", 12, SWT.BOLD | SWT.ITALIC));
		lblNewLabel.setBounds(10, 77, 256, 25);
		lblNewLabel.setText("Per iniziare scegli un opzione");
		
			

	}

}
