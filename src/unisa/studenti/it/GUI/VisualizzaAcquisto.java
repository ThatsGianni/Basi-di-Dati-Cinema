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

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.ExpandBar;

public class VisualizzaAcquisto {

	protected Shell shlCinema;
	public Display display = null;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VisualizzaAcquisto window = new VisualizzaAcquisto();
			window.open("GiovanniT");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws SQLException 
	 */
	public void open(String username) throws SQLException {
	 display = Display.getDefault();
		createContents(username);
		shlCinema.open();
		shlCinema.layout();
		while (!shlCinema.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws SQLException 
	 */
	protected void createContents(String username) throws SQLException {
		shlCinema = new Shell();
		shlCinema.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		shlCinema.setSize(1011, 300);
		shlCinema.setText("Cinema");
		int i = 0;
		
		DBMCinema.connectionDBM("root", "Ggtg111014");
		Label lblITuoiAcquisti = new Label(shlCinema, SWT.NONE);
		lblITuoiAcquisti.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblITuoiAcquisti.setFont(SWTResourceManager.getFont("HP Simplified Hans", 18, SWT.NORMAL));
		lblITuoiAcquisti.setBounds(23, 10, 186, 44);
		lblITuoiAcquisti.setText("I tuoi acquisti:");
		
		List list = new List(shlCinema, SWT.BORDER);
		list.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD | SWT.ITALIC));
		
		list.setBounds(10, 60, 973, 140);
		
		for(i=0;i<OperazioniUtente.visualizzaAcquisto(username).size();i++) {
			list.add("\n");
			list.add(OperazioniUtente.visualizzaAcquisto(username).get(i));
			}
		if(OperazioniUtente.visualizzaAcquisto(username).isEmpty()) {
			list.add("Non hai acquistato biglietti");
		}
		
		
		
		Button btnIndietro = new Button(shlCinema, SWT.NONE);
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				AreaUtenteGui window= new AreaUtenteGui();
				window.open(username);
			}
		});
		btnIndietro.setBounds(23, 213, 90, 30);
		btnIndietro.setText("Indietro");
		
		Button btnCancella = new Button(shlCinema, SWT.NONE);
		btnCancella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				int x =list.getSelectionIndex();
				list.remove(x);
				String str = list.getItem(x);
				x = str.lastIndexOf("Numero Biglietto: ");
				int y = str.lastIndexOf(",");
				str=str.substring(x,y);
				x = str.lastIndexOf(" ");
				str = str.substring(x+1);
				try {
					OperazioniUtente.cancellaAcquisto(str);
					
					if(OperazioniUtente.visualizzaAcquisto(username).isEmpty()) {
						list.add("Non hai acquistato biglietti");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCancella.setBounds(213, 213, 90, 30);
		btnCancella.setText("Cancella");

	}
}
