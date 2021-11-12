package unisa.studenti.it.GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Operazioni.OperazioniUtente;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AcquistoBigliettoGui {
	public String filmSel = null;
	public String cinemaSel=null;
	int codpos=0;
	String fila=null;
	String colonna=null;
	public String posto=null;
	public int codCinema=0;
	protected Shell shell;
	Display display = null;
	private Button btnSelezionaPosto;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AcquistoBigliettoGui window = new AcquistoBigliettoGui();
			window.open("GiovanniT");
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
	protected void createContents(String username) throws SQLException {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		int j = 0;
		shell.setSize(894, 518);
		shell.setText("Cinema");
		Combo nomiCinema = new Combo(shell, SWT.NONE);
		nomiCinema.setBounds(44, 81, 205, 28);
		
		
		
		Label lblFilm = new Label(shell, SWT.NONE);
		lblFilm.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblFilm.setFont(SWTResourceManager.getFont("HP Simplified Hans", 18, SWT.NORMAL));
		lblFilm.setBounds(331, 190, 167, 34);
		lblFilm.setText("FILM IN SALA");
		
		DBMCinema.connectionDBM("root", "Ggtg111014");
		Combo comboFilm = new Combo(shell, SWT.NONE);
		comboFilm.setBounds(331, 72, 167, 28);
		
		Button btnCompraBiglietto = new Button(shell, SWT.NONE);
		btnCompraBiglietto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		
		btnCompraBiglietto.setBounds(371, 122, 90, 30);
		btnCompraBiglietto.setText("Seleziona");
		
		List listFilm = new List(shell, SWT.BORDER);
		listFilm.setBounds(44, 230, 770, 195);
		
		
		Button btnIndietro = new Button(shell, SWT.NONE);
		btnIndietro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				AreaUtenteGui window = new AreaUtenteGui();
				window.open(username);
			}
		});
		btnIndietro.setBounds(371, 431, 90, 30);
		btnIndietro.setText("Indietro");
		for(j=0;j<OperazioniUtente.getNomeCinema().size();j++) {
			nomiCinema.add(OperazioniUtente.getNomeCinema().get(j));
		}
		Button selCinema = new Button(shell, SWT.NONE);
		selCinema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				cinemaSel=nomiCinema.getText();
				try {
					
					codCinema=OperazioniUtente.getCinema(cinemaSel);
					int i = 0;
					
					for(i=0;i<OperazioniUtente.visuallizzaProgrammazione(codCinema).size();i++){
						listFilm.add(OperazioniUtente.visuallizzaProgrammazione(codCinema).get(i));
						}
					
					i=0;
					
					for(i=0;i<OperazioniUtente.visuallizzaProgrammazione(codCinema,"").size();i++){
						comboFilm.add(OperazioniUtente.visuallizzaProgrammazione(codCinema,"").get(i));
			}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				btnCompraBiglietto.addMouseListener(new MouseAdapter() {
					

					@Override
					public void mouseDoubleClick(MouseEvent e) {
						try {
							filmSel=comboFilm.getText();
							System.out.println(filmSel);
							Combo comboPosto = new Combo(shell, SWT.NONE);
							comboPosto.setBounds(504, 72, 97, 28);
							
							btnSelezionaPosto = new Button(shell, SWT.NONE);
							
							btnSelezionaPosto.setBounds(511, 122, 90, 30);
							btnSelezionaPosto.setText("Seleziona");
							
							Label lblPosto = new Label(shell, SWT.NONE);
							lblPosto.setText("Posto");
							lblPosto.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
							lblPosto.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
							lblPosto.setBounds(528, 46, 50, 20);
							
							
							
							int codprog = OperazioniUtente.getCodProg(filmSel);
							System.out.println(""+codprog);
							String query = "SELECT NUMFILA, NUMCOL from PROG_POSL where codprog="+codprog+";";
							ArrayList<String> posti=new ArrayList<String>();
							java.sql.Statement pquery = DBMCinema.getConn().createStatement();	
							ResultSet postiLiberi = pquery.executeQuery(query);
							while(postiLiberi.next()) {
								comboPosto.add("Fila: "+postiLiberi.getString("NUMFILA")+"/Colonna: "+postiLiberi.getString("NUMCOL"));
							}
							btnSelezionaPosto.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseDoubleClick(MouseEvent e) {
									
									 posto = comboPosto.getText();
									  fila = posto.substring(6,7);
									  int x = posto.length();
									  colonna = posto.substring(17,x);
									 
									
									
									 try {
										codpos=OperazioniUtente.getCodPosto(fila, colonna, codprog);
										 if(colonna.equals("")) {
											 colonna = posto.substring(18,19);
										 }
										
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									 Button btnAcquista = new Button(shell, SWT.NONE);
										btnAcquista.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseDoubleClick(MouseEvent e) {
												try {
													OperazioniUtente.acquistoBiglietto(username, filmSel,codpos);
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												JOptionPane.showMessageDialog(null,"Acquistato");
												display.close();
												AreaUtenteGui window = new AreaUtenteGui();
												window.open(username);
											}
										});
										btnAcquista.setBounds(616, 72, 90, 30);
										btnAcquista.setText("Acquista");
								}
							});
							
						
							 
							 
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
		});
		
		selCinema.setBounds(92, 134, 90, 30);
		selCinema.setText("Seleziona");
		
		Label lblSelezionaCinema = new Label(shell, SWT.NONE);
		lblSelezionaCinema.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblSelezionaCinema.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblSelezionaCinema.setBounds(74, 45, 136, 20);
		lblSelezionaCinema.setText("Seleziona Cinema");
		
		Label lblSelezionaFilm = new Label(shell, SWT.NONE);
		lblSelezionaFilm.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblSelezionaFilm.setText("Seleziona Film");
		lblSelezionaFilm.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblSelezionaFilm.setBounds(345, 46, 113, 20);
		
		Label lblAcquistaIlTuo = new Label(shell, SWT.NONE);
		lblAcquistaIlTuo.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblAcquistaIlTuo.setFont(SWTResourceManager.getFont("HP Simplified", 18, SWT.NORMAL));
		lblAcquistaIlTuo.setBounds(268, 10, 337, 34);
		lblAcquistaIlTuo.setText("ACQUISTA IL TUO BIGLIETTO");
		
	
		
		
		
	
		
		
		
		
		
	}
}
