package unisa.studenti.it.GUI;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Operazioni.OperazioniUtente;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class RegistrazioneGui {
	/**
	 * @wbp.parser.entryPoint
	 */
	public RegistrazioneGui() {
	}

	protected Shell shell;
	private Label lblNome;
	private Label lblCognome;
	private Label lblEmail;
	private Label lblUsername;
	private Label lblPassword;
	private Text Jnome;
	private Text Jcognome;
	private Text Jemail;
	private Text Jusername;
	private Text Jpassword;
	public String nome,cognome,email,username,password;
	private Display display;

	/**

	 */
	public void open() {
		display = Display.getDefault();
		registrazioneGui();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window
	 * @wbp.parser.entryPoint
	 */
	protected void registrazioneGui() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		shell.setSize(634, 375);
		shell.setText("Cinema");
		
		Jnome = new Text(shell, SWT.BORDER);
		Jnome.setBounds(66, 46, 165, 26);
		Jnome.setFont(SWTResourceManager.getFont("HP Simplified", 9, SWT.NORMAL));
		
		lblNome = new Label(shell, SWT.NONE);
		lblNome.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNome.setFont(SWTResourceManager.getFont("HP Simplified", 9, SWT.NORMAL));
		lblNome.setBounds(10, 49, 52, 20);
		lblNome.setText("Nome:");
		
		lblCognome = new Label(shell, SWT.NONE);
		lblCognome.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblCognome.setFont(SWTResourceManager.getFont("HP Simplified", 9, SWT.NORMAL));
		lblCognome.setBounds(8, 96, 70, 20);
		lblCognome.setText("Cognome:");
		
		Jcognome = new Text(shell, SWT.BORDER);
		Jcognome.setBounds(84, 93, 165, 26);
		Jcognome.setFont(SWTResourceManager.getFont("HP Simplified", 9, SWT.NORMAL));
		
		
		Jemail = new Text(shell, SWT.BORDER);
		Jemail.setBounds(56, 144, 165, 26);
		Jemail.setFont(SWTResourceManager.getFont("HP Simplified", 9, SWT.NORMAL));
		
		
		lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblEmail.setFont(SWTResourceManager.getFont("HP Simplified", 9, SWT.NORMAL));
		lblEmail.setBounds(10, 147, 40, 20);
		lblEmail.setText("Email:");
		
		lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblUsername.setFont(SWTResourceManager.getFont("HP Simplified", 9, SWT.NORMAL));
		lblUsername.setBounds(10, 192, 70, 20);
		lblUsername.setText("Username:");
		
		Jusername = new Text(shell, SWT.BORDER);
		Jusername.setBounds(84, 189, 165, 26);
		Jusername.setFont(SWTResourceManager.getFont("HP Simplified", 9, SWT.NORMAL));
		
		
		lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblPassword.setFont(SWTResourceManager.getFont("HP Simplified", 9, SWT.NORMAL));
		lblPassword.setBounds(10, 232, 90, 48);
		lblPassword.setText("Password: \r\n(max 8 caratteri)");
		
		Jpassword = new Text(shell, SWT.BORDER);
		Jpassword.setBounds(106, 230, 165, 26);
		Jpassword.setFont(SWTResourceManager.getFont("HP Simplified", 9, SWT.NORMAL));
		
		
		Label lblRegistrazione = new Label(shell, SWT.NONE);
		lblRegistrazione.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRegistrazione.setFont(SWTResourceManager.getFont("HP Simplified", 18, SWT.NORMAL));
		lblRegistrazione.setBounds(247, 10, 500, 220);
		lblRegistrazione.setText("REGISTRAZIONE");
		
		Button btnInvia = new Button(shell, SWT.NONE);
		btnInvia.addMouseListener(new MouseAdapter() {
			public void mouseDoubleClick(MouseEvent e) {
				boolean registrato = false;
				try {
					DBMCinema.connectionDBM("root", "Ggtg111014");
					nome=Jnome.getText();
					cognome=Jcognome.getText();
					username=Jusername.getText();
					email=Jemail.getText();
					password=Jpassword.getText();
					registrato = OperazioniUtente.registrazioneUtente(username,nome,cognome,email,password);
					
					if(registrato) {
						JOptionPane.showMessageDialog(null, "Utente Registrato con successo");	
						display.close();
						
						
						
						
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnInvia.setBounds(10, 285, 90, 30);
		btnInvia.setText("Invia");

	}
}
