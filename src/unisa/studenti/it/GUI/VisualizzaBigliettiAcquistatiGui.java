package unisa.studenti.it.GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Operazioni.OperazioniAdmin;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class VisualizzaBigliettiAcquistatiGui {

	protected Shell shell;
	public Display display = null;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VisualizzaBigliettiAcquistatiGui window = new VisualizzaBigliettiAcquistatiGui();
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
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		shell.setSize(1019, 502);
		shell.setText("SWT Application");
		DBMCinema.connectionDBM("root", "Ggtg111014");
		Label lblBigliettiAcquistati = new Label(shell, SWT.NONE);
		lblBigliettiAcquistati.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblBigliettiAcquistati.setFont(SWTResourceManager.getFont("HP Simplified Hans", 18, SWT.NORMAL));
		lblBigliettiAcquistati.setBounds(10, 10, 296, 53);
		lblBigliettiAcquistati.setText("BIGLIETTI Acquistati");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(10, 103, 981, 300);
		
		Button btnIndietro = new Button(shell, SWT.NONE);
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				AreaAdminGui window=new AreaAdminGui();
				window.open();
			}
		});
		btnIndietro.setBounds(10, 415, 90, 30);
		btnIndietro.setText("Indietro");
		int i = 0;
		for(i=0;i<OperazioniAdmin.visualizzaAcquisti().size();i++) {
			list.add(OperazioniAdmin.visualizzaAcquisti().get(i));
			
		}

	}
}
