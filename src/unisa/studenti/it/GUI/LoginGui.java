package unisa.studenti.it.GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Operazioni.OperazioniUtente;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class LoginGui {

	protected Shell shell;
	private Text Jusername;
	String username,password;
	public boolean login = false;
	Display display = new Display();
	private Text Jpassword;
	public static void main(String[] args) {
		try {
			LoginGui window = new LoginGui();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean open() {
		boolean success = false;
		Display display = Display.getDefault();
		success = createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return success;
	}


	/**
	 * Create contents of the window.
	 * @return 
	 */
	protected boolean createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		shell.setSize(327, 246);
		shell.setText("Cinema");
		
		Label lblLogin = new Label(shell, SWT.CENTER);
		lblLogin.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblLogin.setFont(SWTResourceManager.getFont("HP Simplified", 18, SWT.NORMAL));
		lblLogin.setBounds(132, 10, 85, 40);
		lblLogin.setText("LOGIN");
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblUsername.setFont(SWTResourceManager.getFont("HP Simplified", 14, SWT.NORMAL));
		lblUsername.setBounds(10, 75, 114, 36);
		lblUsername.setText("Username:");
		
		Jusername = new Text(shell, SWT.BORDER);
		Jusername.setBounds(119, 77, 150, 30);
		
		Label Password = new Label(shell, SWT.NONE);
		Password.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		Password.setFont(SWTResourceManager.getFont("HP Simplified", 14, SWT.NORMAL));
		Password.setBounds(10, 117, 99, 30);
		Password.setText("Password:");
		
		Jpassword = new Text(shell, SWT.BORDER);
		Jpassword.setBounds(119, 117, 150, 30);
		
		Button btnInvia = new Button(shell, SWT.NONE);
		
		btnInvia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				boolean result = false;
				DBMCinema.connectionDBM("root", "Ggtg111014");
				username = Jusername.getText();
				password = Jpassword.getText();
				try {
					if(username.equals("admin") && password.equals("admin")) {
						display.close();
						AreaAdminGui admin = new AreaAdminGui();
						admin.open();
						
					}
					result=OperazioniUtente.loginUtente(username,password);
						if(result) {
							JOptionPane.showMessageDialog(null,"Login effettuato.\n\nBenvenuto!");
							display.close();
							AreaUtenteGui area = new AreaUtenteGui();
							area.open(username);
							}
						else {
							JOptionPane.showMessageDialog(null,"Utente non Registrato\n\nPer continuare Registrati");
							display.close();
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInvia.setBounds(10, 159, 70, 30);
		btnInvia.setText("Invia");
		
		
		return login;
	}
	@Override
	public String toString() {
		return "" + Jusername;
	}

}
