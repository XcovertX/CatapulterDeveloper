package mapBuilder;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import swing2swt.layout.BoxLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class WelcomeBuilder {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WelcomeBuilder window = new WelcomeBuilder();
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
		shell.setSize(290, 147);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		shell.setMinimumSize(new Point(100, 39));
		shell.setLayout(new BorderLayout(0, 0));
		
		Label welcome_lbl = new Label(shell, SWT.NONE);
		welcome_lbl.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		welcome_lbl.setAlignment(SWT.CENTER);
		welcome_lbl.setLayoutData(BorderLayout.NORTH);
		welcome_lbl.setText("Welcome to World Builder!");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayoutData(BorderLayout.CENTER);
		composite.setLayout(null);

		
		Button buildNewWorld_btn = new Button(composite, SWT.NONE);
		buildNewWorld_btn.setBounds(10, 10, 125, 25);
		buildNewWorld_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
				new WorldDetails();
			}
		});
		buildNewWorld_btn.setText("Build New World");
		
		Button loadNewWorld_btn = new Button(composite, SWT.NONE);
		loadNewWorld_btn.setBounds(139, 10, 125, 25);
		loadNewWorld_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
				new Load();
			}
		});
		loadNewWorld_btn.setText("Load NewWorld");
		
		Button exit_btn = new Button(composite, SWT.NONE);
		exit_btn.setBounds(10, 41, 125, 25);
		exit_btn.setText("Exit");
		
		Button characterBuilder_btn = new Button(composite, SWT.NONE);
		characterBuilder_btn.setText("Character Builder");
		characterBuilder_btn.setBounds(139, 41, 125, 25);

	}
}
