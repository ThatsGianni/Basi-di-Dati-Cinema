package unisa.studenti.it.GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Operazioni.OperazioniUtente;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

public class VisualizzaProgrammazioneGui {

	protected Shell shlCinema;
	public Display display;
	String cinemaSel = null;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VisualizzaProgrammazioneGui window = new VisualizzaProgrammazioneGui();
			window.open("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws SQLException 
	 */
	public void open(String Username) throws SQLException {
		display = Display.getDefault();
		createContents(Username);
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
		shlCinema.setSize(670, 586);
		shlCinema.setText("CINEMA");
		int j = 0;
		
		Label lblProgrammazione = new Label(shlCinema, SWT.NONE);
		lblProgrammazione.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblProgrammazione.setFont(SWTResourceManager.getFont("HP Simplified", 18, SWT.NORMAL));
		lblProgrammazione.setBounds(213, 10, 234, 48);
		lblProgrammazione.setText("Programmazione");
		
		List list = new List(shlCinema, SWT.BORDER);
		list.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		list.setBounds(10, 174, 632, 319);
		DBMCinema.connectionDBM("root", "Ggtg111014");
		
		Button btnIndietro = new Button(shlCinema, SWT.NONE);
		btnIndietro.setBounds(268, 499, 90, 30);
		btnIndietro.setText("Indietro");
		
		Combo nomiCinema = new Combo(shlCinema, SWT.NONE);
		nomiCinema.setBounds(268, 57, 97, 28);
		
		Button btnSeleziona = new Button(shlCinema, SWT.NONE);
		btnSeleziona.setBounds(268, 100, 90, 30);
		btnSeleziona.setText("Seleziona");
		btnSeleziona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				cinemaSel=nomiCinema.getText();
				try {
					int i = 0;
					int codCin=0;
					codCin=OperazioniUtente.getCinema(cinemaSel);
					for(i=0;i<OperazioniUtente.visuallizzaProgrammazione(codCin).size();i++) {
						list.add("\n");
						list.add(OperazioniUtente.visuallizzaProgrammazione(codCin).get(i));
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		for(j=0;j<OperazioniUtente.getNomeCinema().size();j++) {
			nomiCinema.add(OperazioniUtente.getNomeCinema().get(j));
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
