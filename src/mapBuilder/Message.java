package mapBuilder;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Message {
	
	private Message msg;

	protected Shell shell;
	private String message;
	
	public Message( String msg ) {
		this.msg = this;
		this.message = msg;
		this.open();
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Message window = new Message( "test" );
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
		shell.setSize(450, 204);
		shell.setText("confirm");
		
		Label msg_lbl = new Label(shell, SWT.NONE);
		msg_lbl.setAlignment(SWT.CENTER);
		msg_lbl.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		msg_lbl.setBounds(10, 35, 414, 84);
		msg_lbl.setText( message );
		
		Button confirm_btn = new Button(shell, SWT.NONE);
		confirm_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				msg.shell.dispose();
			}
		});
		confirm_btn.setBounds(182, 125, 75, 25);
		confirm_btn.setText("Ok.");
	}

}
