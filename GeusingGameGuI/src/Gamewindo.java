import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;

public class Gamewindo {

	protected Shell shell;
	private Text txtAnswer;
	int s = RandomGenerator.RandomInt(1, 100);
	int sn = RandomGenerator.RandomInt(1, 1000);
	int sh = RandomGenerator.RandomInt(1, 10000);
	private Button btnEasyMode;
	private Button btnHardMode;
	private Button btnNormalMode;
	private Label lblSelectedMode;
	private Label lblResult;
	String selected = "None";
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Gamewindo window = new Gamewindo();
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
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		shell.setSize(1024, 617);
		shell.setText("Geusing Game");
		
		txtAnswer = new Text(shell, SWT.BORDER);
		txtAnswer.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		txtAnswer.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txtAnswer.setToolTipText("Enter your answer");
		txtAnswer.setBounds(10, 117, 957, 26);
		
		Label lblEnterANumber = new Label(shell, SWT.NONE);
		lblEnterANumber.setFont(SWTResourceManager.getFont("Rockwell", 10, SWT.NORMAL));
		lblEnterANumber.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		lblEnterANumber.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblEnterANumber.setBounds(10, 91, 171, 20);
		lblEnterANumber.setText("Enter a Number:");
		
		Button btnEneterGeues = new Button(shell, SWT.NONE);
		btnEneterGeues.setFont(SWTResourceManager.getFont("Rockwell", 9, SWT.NORMAL));
		btnEneterGeues.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnEneterGeues.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(selected == "E") {
					
					int Ans = Integer.parseInt(txtAnswer.getText());
					String ans = String.valueOf(s);
					if(Ans > 100) {
						MessageDialog.openError(shell,"Error Bad Input","Select a number between 1 and 100");
					}
					if(Ans == s) {
						lblResult.setText(" Congradulations you geused my number " + ans );
						
						
					}
					if(Ans < s) {
						lblResult.setText(" Higher ");
						
					}
					if(Ans > s) {
						lblResult.setText(" Lower ");
				
					}
		
				}
				else if(selected == "None") {
					MessageDialog.openError(shell,"Error","Select a gamemode");
				}
				else if(selected == "N") {
					int Ans = Integer.parseInt(txtAnswer.getText());
					String ans = String.valueOf(sn);
					if(Ans > 1000) {
						MessageDialog.openError(shell,"Error Bad Input","Select a number between 1 and 1000");
					}
					if(Ans == sn) {
						lblResult.setText(" Congradulations you geused my number " + ans );
						
						
					}
					if(Ans < sn) {
						lblResult.setText(" Higher ");
					}
					if(Ans > sn) {
						lblResult.setText(" Lower ");
				
					}
				}

				else if(selected == "H") {
					int Ans = Integer.parseInt(txtAnswer.getText());
					String ans = String.valueOf(sh);
					if(Ans > 10000) {
						MessageDialog.openError(shell,"Error Bad Input","Select a number between 1 and 10000");
					}
					if(Ans == sh) {
						lblResult.setText(" Congradulations you geused my number " + ans );
						
						
					}
					if(Ans < sh) {
						lblResult.setText(" Higher ");
					}
					if(Ans > sh) {
						lblResult.setText(" Lower ");
				
					}
				}
			}
		});
		
		btnEneterGeues.setBounds(10, 203, 171, 30);
		btnEneterGeues.setText("Enter your Geues (&+)");
		
		btnEasyMode = new Button(shell, SWT.NONE);
		btnEasyMode.setFont(SWTResourceManager.getFont("Rockwell", 9, SWT.NORMAL));
		btnEasyMode.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnEasyMode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selected = "E";
				lblSelectedMode.setText(" Easy Mode");
			}
		});
		btnEasyMode.setBounds(221, 149, 90, 30);
		btnEasyMode.setText("&Easy Mode");
		
		btnHardMode = new Button(shell, SWT.NONE);
		btnHardMode.setGrayed(true);
		btnHardMode.setSelection(true);
		btnHardMode.setFont(SWTResourceManager.getFont("Rockwell", 9, SWT.NORMAL));
		btnHardMode.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnHardMode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selected = "H";
				lblSelectedMode.setText(" Hard Mode");
			}
		});
		btnHardMode.setBounds(558, 149, 90, 30);
		btnHardMode.setText("&Hard Mode");
		
		btnNormalMode = new Button(shell, SWT.NONE);
		btnNormalMode.setFont(SWTResourceManager.getFont("Rockwell", 9, SWT.NORMAL));
		btnNormalMode.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnNormalMode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selected = "N";
				lblSelectedMode.setText(" Normal Mode");
			}
		});
		btnNormalMode.setBounds(363, 149, 117, 30);
		btnNormalMode.setText("&Normal Mode");
		
		lblSelectedMode = new Label(shell, SWT.NONE);
		lblSelectedMode.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblSelectedMode.setFont(SWTResourceManager.getFont("Rockwell", 12, SWT.NORMAL));
		lblSelectedMode.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblSelectedMode.setBounds(10, 152, 171, 23);
		lblSelectedMode.setText("  Selected mode");
		
		lblResult = new Label(shell, SWT.NONE);
		lblResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblResult.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblResult.setFont(SWTResourceManager.getFont("Rockwell", 18, SWT.NORMAL));
		lblResult.setBounds(10, 265, 957, 272);
		lblResult.setText("  Result/Hint");
		
		Label lblWelcomeToMy = new Label(shell, SWT.NONE);
		lblWelcomeToMy.setFont(SWTResourceManager.getFont("Rockwell", 20, SWT.NORMAL));
		lblWelcomeToMy.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblWelcomeToMy.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		lblWelcomeToMy.setBounds(10, 10, 986, 75);
		lblWelcomeToMy.setText("Welcome to my game \r\nEnter a geusing gamemode to Start");

	}
}
