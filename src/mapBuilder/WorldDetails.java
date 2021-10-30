package mapBuilder;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import world.BuildJSON;
import world.GameWorld;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class WorldDetails {

	protected Shell shell;
	private Text worldName_txt;
	private Text location_txt;
	
	public WorldDetails() {
		open();
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WorldDetails window = new WorldDetails();
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
		shell.setSize(574, 152);
		shell.setText("SWT Application");
		
		Label worldName_lbl = new Label(shell, SWT.NONE);
		worldName_lbl.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		worldName_lbl.setBounds(10, 13, 119, 25);
		worldName_lbl.setText("World Name:");
		
		worldName_txt = new Text(shell, SWT.BORDER);
		worldName_txt.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		worldName_txt.setBounds(145, 10, 403, 28);
		
		Label saveLocation = new Label(shell, SWT.NONE);
		saveLocation.setText("Location:");
		saveLocation.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		saveLocation.setBounds(10, 47, 127, 25);
		
		location_txt = new Text(shell, SWT.BORDER);
		location_txt.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		location_txt.setBounds(145, 44, 403, 28);
		
		Button saveWorld_btn = new Button(shell, SWT.NONE);
		saveWorld_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				GameWorld gw = new GameWorld();
				
				if( worldName_txt.getText() != "" ) {
					gw.setName( worldName_txt.getText() );
					if( location_txt.getText() != "" ) {
						String location = location_txt.getText();
						new BuildJSON().construct( gw, location);
						shell.dispose();
						new WorldBuilder( location, gw.getName() );
						
					} else {
						new Message( "You must enter a file location.");
					}
				} else {
					new Message( "You must enter a world name.");
				}
				
			}
		});
		saveWorld_btn.setBounds(473, 88, 75, 25);
		saveWorld_btn.setText("Save");
		
		Button cancelWorld_btn_1 = new Button(shell, SWT.NONE);
		cancelWorld_btn_1.setText("Cancel");
		cancelWorld_btn_1.setBounds(392, 88, 75, 25);		saveWorld_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
			}
		});	
	}
}
