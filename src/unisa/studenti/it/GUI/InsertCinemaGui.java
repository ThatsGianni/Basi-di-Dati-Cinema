package unisa.studenti.it.GUI;

import java.io.IOException;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import unisa.studenti.it.Entity.Cinema;
import unisa.studenti.it.Entity.DBMCinema;
import unisa.studenti.it.Entity.Posto;
import unisa.studenti.it.Entity.Sale;
import unisa.studenti.it.Entity.Telefono;
import unisa.studenti.it.Operazioni.InsertTable;
import unisa.studenti.it.Operazioni.OperazioniAdmin;
import unisa.studenti.it.Operazioni.OperazioniUtente;

import org.eclipse.swt.widgets.Combo;

public class InsertCinemaGui {

	protected Shell shell;
	public Text textIndirizzo;
	public Text textCittà;
	public Text textNazione;
	public Text textNumSale;
	public Text textNome;
	private Text textNumSala;
	private Text textSuperficie;
	private Text textCapienza;
	private Text textTelefono;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InsertCinemaGui window = new InsertCinemaGui();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
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
	protected void createContents(){
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		shell.setSize(740, 322);
		shell.setText("SWT Application");
		
		

		DBMCinema.connectionDBM("root","Ggtg111014" );
		
		Label nomeCinema = new Label(shell, SWT.NONE);
		nomeCinema.setBackground((SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION)));
		nomeCinema.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		nomeCinema.setBounds(10, 74, 61, 20);
		nomeCinema.setText("Nome:");
		
		textNome = new Text(shell, SWT.BORDER);
		textNome.setBounds(77, 73, 201, 26);
		
		Label lblIndirizzo = new Label(shell, SWT.NONE);
		lblIndirizzo.setText("Indirizzo Cinema:");
		lblIndirizzo.setBackground((SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION)));
		lblIndirizzo.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblIndirizzo.setBounds(10, 117, 136, 20);
		
		textIndirizzo = new Text(shell, SWT.BORDER);
		textIndirizzo.setBounds(152, 116, 156, 26);
		
		Label lblCitt = new Label(shell, SWT.NONE);
		lblCitt.setText("Citt\u00E0:");
		lblCitt.setBackground((SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION)));
		lblCitt.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblCitt.setBounds(295, 74, 42, 20);
		
		textCittà = new Text(shell, SWT.BORDER);
		textCittà.setBounds(343, 68, 130, 26);
		
		Label lblNazione = new Label(shell, SWT.NONE);
		lblNazione.setText("Nazione:");
		lblNazione.setBackground((SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION)));
		lblNazione.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblNazione.setBounds(378, 117, 65, 20);
		
		textNazione = new Text(shell, SWT.BORDER);
		textNazione.setBounds(451, 116, 136, 26);
		
		Label lblNumSale = new Label(shell, SWT.NONE);
		lblNumSale.setText("Num Sale:");
		lblNumSale.setBackground((SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION)));
		lblNumSale.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblNumSale.setBounds(500, 69, 87, 20);
		
		textNumSale = new Text(shell, SWT.BORDER);
		textNumSale.setBounds(593, 68, 78, 26);
		
		Button btnInserisci = new Button(shell, SWT.NONE);
		btnInserisci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				String nome = textNome.getText();
				String indirizzo = textIndirizzo.getText();
				String città = textCittà.getText();
				String nazione = textNazione.getText();
				String numSale = textNumSale.getText();
				Cinema cinema = new Cinema(0,nome,indirizzo,città,nazione,Integer.parseInt(numSale));
				try {
					InsertTable.cinema(cinema);
					Telefono tel = new Telefono(textTelefono.getText(),OperazioniAdmin.getIDCinema(nome));
					InsertTable.telefono(tel);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
		btnInserisci.setBounds(343, 159, 90, 30);
		btnInserisci.setText("Inserisci");
		
		Label lblInserisciCinema = new Label(shell, SWT.NONE);
		lblInserisciCinema.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblInserisciCinema.setFont(SWTResourceManager.getFont("HP Simplified", 18, SWT.NORMAL));
		lblInserisciCinema.setBounds(10, 10, 220, 58);
		lblInserisciCinema.setText("Inserisci CINEMA");
		
		Button btnPerInserireSae = new Button(shell, SWT.NONE);
		btnPerInserireSae.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				try {
					InsertSala();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPerInserireSae.setBounds(10, 208, 119, 30);
		btnPerInserireSae.setText("Per Inserire Sale");
		
		Label lblTelefono = new Label(shell, SWT.NONE);
		lblTelefono.setText("Numero Telefono:");
		lblTelefono.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblTelefono.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblTelefono.setBounds(10, 162, 136, 20);
		
		textTelefono = new Text(shell, SWT.BORDER);
		textTelefono.setBounds(152, 162, 156, 26);
		
		
		
		

	}
	public void InsertSala() throws SQLException {
		shell.setSize(740, 533);
		Combo comboCinema = new Combo(shell, SWT.NONE);
		comboCinema.setBounds(77, 326, 113, 28);
		int j = 0;
		for(j=0;j<OperazioniUtente.getNomeCinema().size();j++) {
			comboCinema.add(OperazioniUtente.getNomeCinema().get(j));
		}
		
		Label lblCinema = new Label(shell, SWT.NONE);
		lblCinema.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblCinema.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblCinema.setBounds(10, 330, 59, 20);
		lblCinema.setText("Cinema:");
		
		textNumSala = new Text(shell, SWT.BORDER);
		textNumSala.setBounds(333, 326, 78, 28);
		
		Label lblNumeroSala = new Label(shell, SWT.NONE);
		lblNumeroSala.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNumeroSala.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblNumeroSala.setBounds(223, 330, 107, 20);
		lblNumeroSala.setText("Numero Sala:");
		
		textSuperficie = new Text(shell, SWT.BORDER);
		textSuperficie.setBounds(544, 326, 78, 28);
		
		Label lblSuperficie = new Label(shell, SWT.NONE);
		lblSuperficie.setText("Superficie:");
		lblSuperficie.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblSuperficie.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblSuperficie.setBounds(451, 327, 87, 20);
		
		textCapienza = new Text(shell, SWT.BORDER);
		textCapienza.setBounds(91, 382, 68, 28);
		
		Label lblCapienza = new Label(shell, SWT.NONE);
		lblCapienza.setText("Capienza:");
		lblCapienza.setFont(SWTResourceManager.getFont("HP Simplified", 11, SWT.NORMAL));
		lblCapienza.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblCapienza.setBounds(10, 383, 75, 20);
		
		Button btnInserisci_1 = new Button(shell, SWT.NONE);
		btnInserisci_1.setBounds(10, 446, 90, 30);
		btnInserisci_1.setText("Inserisci");
		
		btnInserisci_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				int numeroSala = Integer.parseInt(textNumSala.getText());
				double superficie = Double.parseDouble((textSuperficie.getText()));
				int capienza = Integer.parseInt(textCapienza.getText());
				int idCin = OperazioniAdmin.getIDCinema(comboCinema.getText());
				
				
			
				Sale sala = new Sale(0,numeroSala,superficie,capienza,idCin);
				try {
					InsertTable.sale(sala);
					int i = 0;
					int j = 0;
					int fila=0;
					Posto posto = null;
					int codsale = 0;
					fila=capienza/10;
					codsale = OperazioniAdmin.getCodSale(numeroSala, idCin);
					for(i=1;i<fila+1;i++) {
						for(j=1;j<10+1;j++) {
							
					posto = new Posto(0,i,j,codsale);
					try {
						InsertTable.posto(posto);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		Label lblInserisciSala = new Label(shell, SWT.NONE);
		lblInserisciSala.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblInserisciSala.setText("Inserisci SALA");
		lblInserisciSala.setFont(SWTResourceManager.getFont("HP Simplified", 18, SWT.NORMAL));
		lblInserisciSala.setBounds(10, 266, 178, 58);
		
	}
}
