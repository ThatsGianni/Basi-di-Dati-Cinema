package unisa.studenti.it.GUI;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Link;

public class AreaUtenteGui {

	protected Shell shell;
	Display display = new Display();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AreaUtenteGui window = new AreaUtenteGui();
			window.open("GiovanniT");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(String username) {
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
	protected void createContents(String username) {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		shell.setSize(632, 199);
		shell.setText("Cinema");
		
		Label lblAcquistaIlTuo = new Label(shell, SWT.NONE);
		lblAcquistaIlTuo.setFont(SWTResourceManager.getFont("HP Simplified", 14, SWT.NORMAL));
		lblAcquistaIlTuo.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblAcquistaIlTuo.setBounds(10, 64, 233, 39);
		lblAcquistaIlTuo.setText("Acquista il Tuo Biglietto");
		
		Label lblBenvenuto = new Label(shell, SWT.NONE);
		lblBenvenuto.setFont(SWTResourceManager.getFont("HP Simplified Hans", 18, SWT.NORMAL));
		lblBenvenuto.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblBenvenuto.setBounds(10, 10, 379, 48);
		lblBenvenuto.setText("Benvenuto "+username);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel.setFont(SWTResourceManager.getFont("HP Simplified", 14, SWT.NORMAL));
		lblNewLabel.setBounds(431, 44, 164, 59);
		lblNewLabel.setText("      Visuallizza \r\nProgrammazione");
		
		Button acquista = new Button(shell, SWT.NONE);
		acquista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				AcquistoBigliettoGui window = new AcquistoBigliettoGui();
				try {
					display.close();
					window.open(username);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		acquista.setBounds(20, 109, 154, 31);
		acquista.setText("Acquista");
		
		Button visualizza = new Button(shell, SWT.NONE);
		visualizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				VisualizzaProgrammazioneGui window = new VisualizzaProgrammazioneGui();
				try {
					window.open(username);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		visualizza.setText("Visualizza");
		visualizza.setBounds(441, 109, 154, 31);
		
		Link link = new Link(shell, SWT.NONE);
		link.setLinkForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		link.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				VisualizzaAcquisto window = new VisualizzaAcquisto();
				try {
					window.open(username);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		link.setBounds(246, 109, 127, 20);
		link.setText("<a>Vai ai tuoi biglietti</a>");
		
		Link link_1 = new Link(shell, 0);
		link_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				display.close();
				VisualizzaCinemaGui window = new VisualizzaCinemaGui();
				try {
					window.open(username);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		link_1.setText("<a>Visualizza i nostri cinema</a>");
		link_1.setLinkForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		link_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		link_1.setBounds(421, 18, 183, 20);

	}
}
