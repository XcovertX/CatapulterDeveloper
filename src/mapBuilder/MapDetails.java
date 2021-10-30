package mapBuilder;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import world.GameMap;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class MapDetails {

	protected Shell shell;
	private Text mapName_txt;
	private boolean city;
	private boolean outland;
	private boolean forest;
	private boolean space;
	private boolean spaceShip;
	private boolean spaceStation;
	
	private Button city_btn;
	private Button forest_btn;
	private Button outland_btn;
	private Button space_btn;
	private Button spaceShip_btn;
	private Button spaceStation_btn;
	
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MapDetails window = new MapDetails();
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
		shell.setSize(450, 189);
		shell.setText("SWT Application");
		
		Label mapName_lbl = new Label(shell, SWT.NONE);
		mapName_lbl.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		mapName_lbl.setBounds(10, 10, 93, 25);
		mapName_lbl.setText("Map Name");
		
		mapName_txt = new Text(shell, SWT.BORDER);
		mapName_txt.setBounds(109, 14, 315, 21);
		
		city_btn = new Button(shell, SWT.RADIO);
		city_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearMapCatagory();
				city = true;
			}
		});
		city_btn.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		city_btn.setBounds(10, 45, 64, 25);
		city_btn.setText("City");
		
		outland_btn = new Button(shell, SWT.RADIO);
		outland_btn.setText("Outland");
		outland_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearMapCatagory();
				outland = true;
			}
		});
		outland_btn.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		outland_btn.setBounds(10, 76, 109, 25);
		
		forest_btn = new Button(shell, SWT.RADIO);
		forest_btn.setText("Forest");
		forest_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearMapCatagory();
				forest = true;
			}
		});
		forest_btn.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		forest_btn.setBounds(10, 107, 109, 25);
		
		space_btn = new Button(shell, SWT.RADIO);
		space_btn.setText("Space");
		space_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearMapCatagory();
				space = true;
			}
		});
		space_btn.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		space_btn.setBounds(137, 45, 109, 25);
		
		spaceShip_btn = new Button(shell, SWT.RADIO);
		spaceShip_btn.setText("Space Ship");
		spaceShip_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearMapCatagory();
				spaceShip = true;
			}
		});
		spaceShip_btn.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		spaceShip_btn.setBounds(137, 76, 109, 25);
		
		spaceStation_btn = new Button(shell, SWT.RADIO);
		spaceStation_btn.setText("Space Station");
		spaceStation_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearMapCatagory();
				spaceStation = true;
			}
		});
		spaceStation_btn.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		spaceStation_btn.setBounds(137, 107, 136, 25);
		
		Button create_btn = new Button(shell, SWT.NONE);
		create_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			
				GameMap gm = new GameMap();
				gm.setName( mapName_txt.getText() );
				gm.setCatagory( getMapCatagory() );
				WorldBuilder.wb.addNewMap( gm );
				shell.close();
			}
		});
		create_btn.setBounds(279, 107, 145, 25);
		create_btn.setText("Create");
		
		Button cancel_btn = new Button(shell, SWT.NONE);
		cancel_btn.setText("Cancel");
		cancel_btn.setBounds(279, 76, 145, 25);

	}
	
	public String getMapCatagory() {
		
		if( city ) {
			return "City";
		} else if( outland ) {
			return "Outland";
		} else if( forest ) {
			return "Forest";
		} else if( space ) {
			return "Space";
		} else if( spaceShip ) {
			return "Space Ship";
		} else if( spaceStation ) {
			return "Space Station";
		} else {
			return "";
		}
	}
	
	public void clearMapCatagory() {
		
		city = false;
		outland = false;
		forest = false;
		space = false;
		spaceShip = false;
		spaceStation = false;	
		
	}
	
	public void fillMapDetails( GameMap gm ) {
		
		mapName_txt.setText( gm.getName() );
		
		String cat = gm.getCatagory();
		
		if( cat.equals( "city" ) ) {
			city_btn.setSelection( true );
		} else if( cat.equals( "outland" ) ) {
			outland_btn.setSelection( true );
		} else if( cat.equals( "forest" ) ) {
			forest_btn.setSelection( true );
		}  else if( cat.equals( "space" ) ) {
			space_btn.setSelection( true );
		} else if( cat.equals( "spaceShip" ) ) {
			outland_btn.setSelection( true );
		} else if( cat.equals( "spaceStation" ) ) {
			outland_btn.setSelection( true );
		}
	}
	
}
