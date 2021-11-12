package unisa.studenti.it.GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import unisa.studenti.it.Entity.Cinema;
import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Entity.Film;
import unisa.studenti.it.Entity.Programmazione;
import unisa.studenti.it.Operazioni.InsertTable;
import unisa.studenti.it.Operazioni.OperazioniAdmin;

import org.eclipse.swt.widgets.Menu;
import java.awt.Panel;
import java.io.IOException;
import java.sql.SQLException;

import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AreaAdminGui {

	protected Shell shell;
	public Text txtGiornoAnnomesegiorno;
	public Text prezzo;
	public Text film;
	public Text datainizio;
	public Text datafine;
	public Text codiceSala;
	Display display=null;
	private Text textTitolo;
	private Text textAnno;
	private Text textDurata;
	private Text textRecensione;
	private Text textDistr;
	private Text textGenere;
	private Text textPaese;
	private Text textNomereg;
	public boolean update=false;
	private Text textCognomeRef;
	
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AreaAdminGui window = new AreaAdminGui();
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
		shell.setSize(656, 232);
		shell.setText("Cinema");
		
		
		
		Label lblAreaAmministratori = new Label(shell, SWT.NONE);
		lblAreaAmministratori.setFont(SWTResourceManager.getFont("HP Simplified", 18, SWT.NORMAL));
		lblAreaAmministratori.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblAreaAmministratori.setBounds(188, 10, 265, 40);
		lblAreaAmministratori.setText("Area Amministratori");
		
		Button AggiungiProgrammazione = new Button(shell, SWT.NONE);
		AggiungiProgrammazione.setBounds(10, 56, 201, 52);
		AggiungiProgrammazione.setText("Aggiungi programmazione");
	
		
		Button VisualizzaBiglietti = new Button(shell, SWT.NONE);
		VisualizzaBiglietti.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
		VisualizzaBiglietti.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		VisualizzaBiglietti.setBounds(217, 124, 201, 52);
		VisualizzaBiglietti.setText("Visualizza Acquisti Precedenti");
		
		Button insertCinema = new Button(shell, SWT.NONE);
		insertCinema.setBounds(217, 56, 201, 52);
		insertCinema.setText("Inserisci Cinema");
		
		Button btnInserisciFilm = new Button(shell, SWT.NONE);
		btnInserisciFilm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.setSize(656, 511);
				if(update) {
					display.close();
					AreaAdminGui window=new AreaAdminGui();
					window.open();
					update=false;
				}
				insertFilm();
				update = true;
				
			}
		});
		btnInserisciFilm.setText("Inserisci Film");
		btnInserisciFilm.setBounds(424, 56, 201, 52);
		
		Button btnVisualizzaAcquisti = new Button(shell, SWT.NONE);
		btnVisualizzaAcquisti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				 VisualizzaBigliettiAcquistatiGui window = new  VisualizzaBigliettiAcquistatiGui();
				try {
					window.open();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnVisualizzaAcquisti.setText("Visualizza Biglietti Acquistati");
		btnVisualizzaAcquisti.setBounds(10, 124, 201, 52);
		
		Button btnVisualizzaAcquisti_1 = new Button(shell, SWT.NONE);
		btnVisualizzaAcquisti_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				StampaRegistratiGui window = new StampaRegistratiGui();
				try {
					window.open();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnVisualizzaAcquisti_1.setText("Visualizza Utenti");
		btnVisualizzaAcquisti_1.setBounds(424, 124, 201, 52);
		

		
		
		
		
		
		
		
		insertCinema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				InsertCinemaGui window = new InsertCinemaGui();
				window.open();
			}
		});
	
	
		VisualizzaBiglietti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				try {
					display.close();
					VisualizzaAcquistiPrecedentiGui window = new VisualizzaAcquistiPrecedentiGui();
					window.open();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	
		
		
		
		AggiungiProgrammazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.setSize(656, 459);
				if(update) {
					display.close();
					AreaAdminGui window=new AreaAdminGui();
					window.open();
					update=false;
				}
				programmaEvento(AggiungiProgrammazione);
				update=true;
			}
		});
	
		
		
		
		
		


	}
	public void insertFilm() {
		DBMCinema.connectionDBM("root","Ggtg111014" );
		textTitolo = new Text(shell, SWT.BORDER);
		textTitolo.setBounds(64, 214, 135, 26);
		
		Label lblTitolo = new Label(shell, SWT.NONE);
		lblTitolo.setText("Titolo:");
		lblTitolo.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblTitolo.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblTitolo.setBounds(10, 215, 47, 22);
		
		Label lblAnno = new Label(shell, SWT.NONE);
		lblAnno.setText("Anno:");
		lblAnno.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblAnno.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblAnno.setBounds(217, 215, 47, 22);
		
		textAnno = new Text(shell, SWT.BORDER);
		textAnno.setBounds(265, 214, 78, 26);
		
		Label lblDurata = new Label(shell, SWT.NONE);
		lblDurata.setText("Durata:");
		lblDurata.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblDurata.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblDurata.setBounds(10, 325, 61, 22);
		
		textDurata = new Text(shell, SWT.BORDER);
		textDurata.setBounds(77, 324, 93, 26);
		
		Label lblRecensione = new Label(shell, SWT.NONE);
		lblRecensione.setText("Recensione:");
		lblRecensione.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblRecensione.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblRecensione.setBounds(215, 325, 93, 22);
		
		textRecensione = new Text(shell, SWT.BORDER);
		textRecensione.setBounds(308, 324, 78, 26);
		
		Label lblDistribuzione = new Label(shell, SWT.NONE);
		lblDistribuzione.setText("Distributore:");
		lblDistribuzione.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblDistribuzione.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblDistribuzione.setBounds(10, 273, 98, 22);
		
		textDistr = new Text(shell, SWT.BORDER);
		textDistr.setBounds(114, 272, 135, 26);
		
		Label lblGenere = new Label(shell, SWT.NONE);
		lblGenere.setText("Genere:");
		lblGenere.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblGenere.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblGenere.setBounds(281, 273, 61, 22);
		
		textGenere = new Text(shell, SWT.BORDER);
		textGenere.setBounds(343, 272, 135, 26);
		
		Label lblPaese = new Label(shell, SWT.NONE);
		lblPaese.setText("Paese:");
		lblPaese.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblPaese.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblPaese.setBounds(371, 212, 50, 22);
		
		textPaese = new Text(shell, SWT.BORDER);
		textPaese.setBounds(427, 214, 135, 26);
		
		Label lblNomeReg = new Label(shell, SWT.NONE);
		lblNomeReg.setText("Nome Regista:");
		lblNomeReg.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblNomeReg.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNomeReg.setBounds(10, 381, 107, 22);
		
		textNomereg = new Text(shell, SWT.BORDER);
		textNomereg.setBounds(123, 380, 141, 26);
		Button btnInserisci_1 = new Button(shell, SWT.NONE);
		btnInserisci_1.setBounds(10, 424, 90, 30);
		btnInserisci_1.setText("Inserisci");
		
		Label lblCognomeRegista = new Label(shell, SWT.NONE);
		lblCognomeRegista.setText("Cognome Regista:");
		lblCognomeRegista.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblCognomeRegista.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblCognomeRegista.setBounds(308, 382, 141, 22);
		
		textCognomeRef = new Text(shell, SWT.BORDER);
		textCognomeRef.setBounds(443, 380, 141, 26);
		btnInserisci_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				String nome = textTitolo.getText();
				String distributoreStr = textDistr.getText();
				String annoStr = textAnno.getText();
				String durataStr = textDurata.getText();
				String recensioneStr = textRecensione.getText();
				String genereStr = textGenere.getText();
				String paeseStr = textPaese.getText();
				String registaNome = textNomereg.getText();
				String registaCognome = textCognomeRef.getText();
				int idreg = 0;
				try {
					 idreg = OperazioniAdmin.getIDReg(registaNome,registaCognome);
					 if(idreg==0) {
						 boolean result = false;
						 result=OperazioniAdmin.createRegista(registaNome, registaCognome);
						 if(result) {
							 idreg=OperazioniAdmin.getIDReg(registaNome,registaCognome);
						 }
					 }
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				Film film = new Film(nome,distributoreStr,genereStr,paeseStr,recensioneStr,durataStr,idreg ,0, Integer.parseInt(annoStr));
				try {
					InsertTable.film(film);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
		

		
		
	}
	public void programmaEvento(Button btn1) {
		DBMCinema.connectionDBM("root","Ggtg111014" );
		txtGiornoAnnomesegiorno = new Text(shell, SWT.BORDER);
		txtGiornoAnnomesegiorno.setText("anno/mese/giorno");
		txtGiornoAnnomesegiorno.setBounds(111, 233, 138, 26);
		
		Label lblGiornoDiProgrammazione = new Label(shell, SWT.NONE);
		lblGiornoDiProgrammazione.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblGiornoDiProgrammazione.setFont(SWTResourceManager.getFont("HP Simplified",11, SWT.NORMAL));
		lblGiornoDiProgrammazione.setBounds(10, 234, 95, 20);
		lblGiornoDiProgrammazione.setText("Giorno e Ora:");
		
		prezzo = new Text(shell, SWT.BORDER);
		prezzo.setBounds(316, 233, 78, 26);
		
		
		Label lblPrezzo = new Label(shell, SWT.NONE);
		lblPrezzo.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblPrezzo.setFont(SWTResourceManager.getFont("HP Simplified",11, SWT.NORMAL));
		lblPrezzo.setBounds(255, 234, 55, 20);
		lblPrezzo.setText("Prezzo:");
		
		film = new Text(shell, SWT.BORDER);
		film.setBounds(485, 233, 129, 26);
		
		Label lblIdFilm = new Label(shell, SWT.NONE);
		lblIdFilm.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblIdFilm.setFont(SWTResourceManager.getFont("HP Simplified",11, SWT.NORMAL));
		lblIdFilm.setBounds(400, 234, 83, 20);
		lblIdFilm.setText("Titolo Film:");
		
		datainizio = new Text(shell, SWT.BORDER);
		datainizio.setBounds(106, 303, 140, 26);
		datainizio.setText("anno/mese/giorno");
		
		Label lblDataInizio = new Label(shell, SWT.NONE);
		lblDataInizio.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblDataInizio.setFont(SWTResourceManager.getFont("HP Simplified",11, SWT.NORMAL));
		lblDataInizio.setBounds(10, 304, 90, 20);
		lblDataInizio.setText("Data Inizio:");
		
		Label lblCodicesala = new Label(shell, SWT.NONE);
		lblCodicesala.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblCodicesala.setFont(SWTResourceManager.getFont("HP Simplified",11, SWT.NORMAL));
		lblCodicesala.setBounds(732, 151, 91, 20);
		lblCodicesala.setText("Codice Sala:");
		
		datafine = new Text(shell, SWT.BORDER);
		datafine.setBounds(345, 303, 152, 26);
		datafine.setText("anno/mese/giorno");
		
		Label lblDataFine = new Label(shell, SWT.NONE);
		lblDataFine.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblDataFine.setFont(SWTResourceManager.getFont("HP Simplified",11, SWT.NORMAL));
		lblDataFine.setBounds(262, 304, 78, 20);
		lblDataFine.setText("Data Fine:");
		
		
		Button btnAggiungi = new Button(shell, SWT.NONE);
		btnAggiungi.setBounds(10, 372, 90, 30);
		btnAggiungi.setText("Aggiungi");
		
		
		codiceSala = new Text(shell, SWT.BORDER);
		codiceSala.setBounds(829, 150, 78, 26);
		
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				String giorno = txtGiornoAnnomesegiorno.getText();
				double doubleValue = Double.parseDouble(prezzo.getText());
				String filmStr = film.getText();
				String datainizioStr = datainizio.getText();
				String datafineStr = datafine.getText();
				int codiceSalaStr = Integer.parseInt(codiceSala.getText());
				String x = ""+giorno+""+doubleValue+""+filmStr+""+datainizioStr+""+datafineStr+""+codiceSalaStr;
				Programmazione prg = new Programmazione(giorno,doubleValue,datainizioStr,datafineStr,codiceSalaStr,OperazioniAdmin.getIDFilm(filmStr));
				
				
				try {
					InsertTable.programmazione(prg);
					display.close();
					AreaAdminGui window = new AreaAdminGui();
					window.open();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
	
}