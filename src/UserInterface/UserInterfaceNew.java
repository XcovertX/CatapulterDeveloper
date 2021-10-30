package UserInterface;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import swing2swt.layout.BoxLayout;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Button;

public class UserInterfaceNew {

	protected Shell shlCatapulter;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UserInterfaceNew window = new UserInterfaceNew();
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
		shlCatapulter.open();
		shlCatapulter.layout();
		while (!shlCatapulter.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCatapulter = new Shell();
		shlCatapulter.setMinimumSize(new Point(1366, 768));
		shlCatapulter.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		shlCatapulter.setSize(450, 300);
		shlCatapulter.setText("Catapulter");
		shlCatapulter.setMaximized( true );
		shlCatapulter.setMenu(null);
		shlCatapulter.setLayout(new BorderLayout(0, 0));

		
		
		Composite composite = new Composite(shlCatapulter, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		composite.setLayoutData(BorderLayout.CENTER);
		
		Composite composite_4 = new Composite(composite, SWT.BORDER);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		composite_4.setBounds(10, 10, 502, 645);
		
		Composite composite_6 = new Composite(composite, SWT.NONE);
		composite_6.setBounds(518, 326, 557, 329);
		
		Composite composite_1 = new Composite(shlCatapulter, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		composite_1.setLayoutData(BorderLayout.NORTH);
		
		Composite composite_5 = new Composite(composite_1, SWT.NONE);
		composite_5.setBounds(10, 10, 1330, 54);
		
		Composite composite_2 = new Composite(shlCatapulter, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		composite_2.setLayoutData(BorderLayout.WEST);
		
		Composite composite_3 = new Composite(composite_2, SWT.NONE);
		composite_3.setBounds(10, 10, 255, 645);

	}

}
