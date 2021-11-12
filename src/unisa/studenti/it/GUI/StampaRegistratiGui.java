package unisa.studenti.it.GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Operazioni.OperazioniAdmin;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class StampaRegistratiGui {

	protected Shell shell;
	public Display display;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StampaRegistratiGui window = new StampaRegistratiGui();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws SQLException 
	 */
	public void open() throws SQLException {
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
	 * @throws SQLException 
	 */
	protected void createContents() throws SQLException {
		DBMCinema.connectionDBM("root", "Ggtg111014");
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		shell.setSize(814, 447);
		shell.setText("Cinema");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(10, 159, 776, 176);
		
		Button btnIndietro = new Button(shell, SWT.NONE);
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				AreaAdminGui window = new AreaAdminGui();
				window.open();
			}
		});
		btnIndietro.setBounds(10, 360, 90, 30);
		btnIndietro.setText("Indietro");
		
		Label lblUtentiRegistrati = new Label(shell, SWT.NONE);
		lblUtentiRegistrati.setFont(SWTResourceManager.getFont("HP Simplified", 18, SWT.NORMAL));
		lblUtentiRegistrati.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblUtentiRegistrati.setBounds(10, 10, 222, 59);
		lblUtentiRegistrati.setText("Utenti Registrati");
		
		int i = 0;
		for(i=0;i<OperazioniAdmin.getUtenti().size();i++) {
			list.add(OperazioniAdmin.getUtenti().get(i));
		}

	}

}
