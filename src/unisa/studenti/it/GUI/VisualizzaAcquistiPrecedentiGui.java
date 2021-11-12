package unisa.studenti.it.GUI;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Operazioni.OperazioniAdmin;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class VisualizzaAcquistiPrecedentiGui {

	protected Shell shell;
	Display display = null;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VisualizzaAcquistiPrecedentiGui window = new VisualizzaAcquistiPrecedentiGui();
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
		shell.setSize(1400, 800);
		shell.setText("SWT Application");
		
		int i = 0;
		DBMCinema.connectionDBM("root","Ggtg111014" );
		List list = new List(shell, SWT.BORDER);
		list.setBounds(10, 135, 1360, 500);
		
		Label lblPrecedenti = new Label(shell, SWT.NONE);
		lblPrecedenti.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblPrecedenti.setFont(SWTResourceManager.getFont("HP Simplified", 18, SWT.NORMAL));
		lblPrecedenti.setBounds(10, 10, 304, 68);
		lblPrecedenti.setText("Acquisti Precedenti");
		
		Button btnIndietro = new Button(shell, SWT.NONE);
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				AreaAdminGui window = new AreaAdminGui();
				window.open();
			}
		});
		btnIndietro.setBounds(20, 667, 90, 30);
		btnIndietro.setText("Indietro");
		for(i=0;i<OperazioniAdmin.visualizzaBigliettiStorici().size();i++) {
			list.add(OperazioniAdmin.visualizzaBigliettiStorici().get(i));
			}

	}
}
