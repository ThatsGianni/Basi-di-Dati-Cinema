package unisa.studenti.it.GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;



import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Operazioni.OperazioniUtente;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;

public class VisualizzaCinemaGui {

	protected Shell shell;
	public Display display = null;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
		try {
			VisualizzaCinemaGui window = new VisualizzaCinemaGui();
			window.open("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(String username) throws SQLException {
		display = Display.getDefault();
		createContents(username);
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
	protected void createContents(String username) throws SQLException {
		shell = new Shell();
		shell.setSize(615, 389);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		shell.setText("SWT Application");
		
		DBMCinema.connectionDBM("root", "Ggtg111014");
		Label lblINostriCinema = new Label(shell, SWT.NONE);
		lblINostriCinema.setFont(SWTResourceManager.getFont("HP Simplified", 18, SWT.NORMAL));
		lblINostriCinema.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblINostriCinema.setBounds(10, 10, 199, 49);
		lblINostriCinema.setText("I Nostri Cinema");
		
		org.eclipse.swt.widgets.List list = new org.eclipse.swt.widgets.List(shell, SWT.BORDER);
		list.setBounds(10, 65, 577, 225);
		
		Button btnIndietro = new Button(shell, SWT.NONE);
		btnIndietro.setBounds(10, 302, 90, 30);
		btnIndietro.setText("Indietro");
		

		int i = 0;
		for(i=0;i<OperazioniUtente.visualizzaCinema().size();i++) {
			list.add(OperazioniUtente.visualizzaCinema().get(i));
			}
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				AreaUtenteGui window = new AreaUtenteGui();
				window.open(username);
			}
		});
		}
}
