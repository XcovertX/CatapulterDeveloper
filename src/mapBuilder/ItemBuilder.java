package mapBuilder;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import gameObjects.Thing;
import gameObjects.ThingHolder;
import gameObjects.ThingList;
import world.GameTile;

import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

import element.Element;

import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.custom.SashForm;

public class ItemBuilder {

	protected Shell shell;
	private Text itemName_txt;
	private Text itemDescrip_txt;
	private Button isThingHolder_btn;
	private Label lblThing;
	private Button readable_btn;
	private Label lblThingholder;
	private Button smellable_btn;
	private Button eatable_btn;
	private Button isContainer_btn;
	private Button liquid_btn;
	private Button solid_btn;
	private Button gas_btn;
	private Button translucent_btn;
	private Button drinkable_btn;
	private Button visible_btn;
	private Button holdable_btn;
	private Button wieldable_btn;
	private Button wearable_btn;
	private Button isOnTopOf_btn;
	private Button isUnderneath_btn;
	private Button isContainedWithin_btn;
	private Label largeText_lbl;
	private Text largeText_txt;
	private Label smallText_lbl;
	private Text smallText_txt;
	private Label largeTextLocation_lbl;
	private Label smallTextLocation_lbl;
	private Text largeTextLoc_txt;
	private Text smallTextLoc_txt;
	private Label itemChar_lbl;
	private Text itemChar_txt;
	private Label altNames_lbl;
	private Label itemSize_lbl;
	private Text itemSize_txt;
	private Label itemWeight_lbl;
	private Text itemWeight_txt;
	private Label itemDescriptors_lbl;
	private Button attackable_btn;
	private Button isFurnature_btn;
	private Button holdsItemsOnTop_btn;
	private Button holdsUnderneath_btn;
	private Button holdsWithin_btn;
	private Button isElement_btn;
	private Label Container;
	private List openMech_lst;
	private List closeMech_lst;
	private Label open_lbl;
	private Label close_lbl;
	private Button lockable_btn;
	private Button isHCC_btn;
	private Composite container_cpt;
	private Label AccessMech_lbl;
	private Label itemValue_btn;
	private Text itemValue_txt;
	private Composite thingHolder_cpt1;
	private Composite thingHolder_cpt;
	private Text accessMech_txt;
	private Composite thing_cpt;
	private Composite matterState_cpt;
	private Label matterState_lbl;
	private Composite composite_6;
	private Button openable_btn;
	private Button isOpen_btn;
	private Button isLocked;
	private List list;
	private Composite hcc_cpt;
	private Label hcc_lbl;
	private Label typesCanContain_lbl;
	private List size_lst;
	private Label size_lbl;
	private List type_lst;
	private Composite composite_8;
	private Label type_lbl;
	private List itemDescriptors_lst;
	private Text newDescriptor_txt;
	private Button addDescriptor_btn;
	private Button deleteDescriptor_btn;
	private List altNames_lst;
	private Text addAltName_txt;
	private Button addAltName_btn;
	private Button deleteAltName_btn;
	private Button isWeapon_btn;
	private Button isArmor_btn;
	private Composite weapon_cpt;
	private Label weapon_lbl;
	private Button isRangeWeapon_btn;
	private Button isCloseCombatWeapon;
	private Label damPot_lbl;
	private Text damPot_txt;
	private Label weaponHealth_lbl;
	private Text text;
	private Composite rangeWeapon_cpt;
	private Label rangeWeapon_lbl;
	private Label weaponRange_lbl;
	private Text text_1;
	private Button isExplosive_lbl;
	private Label rangeWeapon_lbl_1;
	private Label effectedRadius_lbl;
	private Text effectedRadius_txt;
	private Label projectileType_lbl;
	private List altNames_lst_1;
	private Label explosiveType_lbl;
	private List explosiveType_lst;
	private Composite explosive_cpt;
	private Composite composite_12;
	private Label Armor_lbl;
	private Button save_btn;
	
	private int typeListIndex;
	private Label element_lbl;
	private Label quantity_lbl;
	private Text text_2;
	private Tree items_tree;
	private TreeColumn trclmnItem;
	private Button addItem_btn;
	private Button editItem_btn;
	private Button deleteItem_btn;
	private Composite containedItems_cpt;
	private Button cancel_btn;
	
	private ThingHolder tHolder;
	private Thing item;
	
	public ItemBuilder( ThingHolder thingHolder ) {
		this.tHolder = thingHolder;
		open();
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
		shell.setSize(1348, 728);
		shell.setText("Item Builder");
		shell.setLayout(new FormLayout());
		shell.setLocation(5, 5);
		
		
		Label itemName_lbl = new Label(shell, SWT.NONE);
		FormData fd_itemName_lbl = new FormData();
		fd_itemName_lbl.left = new FormAttachment(0, 829);
		itemName_lbl.setLayoutData(fd_itemName_lbl);
		itemName_lbl.setText("Item Name:");
		
		itemName_txt = new Text(shell, SWT.BORDER);
		fd_itemName_lbl.right = new FormAttachment(itemName_txt, -34);
		fd_itemName_lbl.top = new FormAttachment(itemName_txt, 3, SWT.TOP);
		FormData fd_itemName_txt = new FormData();
		fd_itemName_txt.top = new FormAttachment(0, 10);
		fd_itemName_txt.left = new FormAttachment(0, 931);
		fd_itemName_txt.right = new FormAttachment(100, -10);
		itemName_txt.setLayoutData(fd_itemName_txt);
		
		Label itemDescrip_lbl = new Label(shell, SWT.NONE);
		FormData fd_itemDescrip_lbl = new FormData();
		fd_itemDescrip_lbl.left = new FormAttachment(itemName_lbl, 0, SWT.LEFT);
		itemDescrip_lbl.setLayoutData(fd_itemDescrip_lbl);
		itemDescrip_lbl.setText("Item Description:");
		
		itemDescrip_txt = new Text(shell, SWT.BORDER);
		fd_itemDescrip_lbl.top = new FormAttachment(itemDescrip_txt, 3, SWT.TOP);
		fd_itemDescrip_lbl.right = new FormAttachment(100, -409);
		FormData fd_itemDescrip_txt = new FormData();
		fd_itemDescrip_txt.top = new FormAttachment(itemName_txt, 6);
		fd_itemDescrip_txt.left = new FormAttachment(0, 931);
		fd_itemDescrip_txt.right = new FormAttachment(itemName_txt, 0, SWT.RIGHT);
		itemDescrip_txt.setLayoutData(fd_itemDescrip_txt);
		
		largeText_lbl = new Label(shell, SWT.NONE);
		largeText_lbl.setEnabled(false);
		largeText_lbl.setText("Large Text:");
		FormData fd_largeText_lbl = new FormData();
		fd_largeText_lbl.right = new FormAttachment(100, -280);
		largeText_lbl.setLayoutData(fd_largeText_lbl);
		
		largeText_txt = new Text(shell, SWT.BORDER);
		largeText_txt.setEnabled(false);
		FormData fd_largeText_txt = new FormData();
		fd_largeText_txt.top = new FormAttachment(0, 285);
		fd_largeText_txt.left = new FormAttachment(largeText_lbl, 6);
		fd_largeText_txt.right = new FormAttachment(100, -10);
		largeText_txt.setLayoutData(fd_largeText_txt);
		
		smallText_lbl = new Label(shell, SWT.NONE);
		smallText_lbl.setText("Small Text:");
		FormData fd_smallText_lbl = new FormData();
		fd_smallText_lbl.right = new FormAttachment(largeText_lbl, 0, SWT.RIGHT);
		smallText_lbl.setLayoutData(fd_smallText_lbl);
		smallText_lbl.setEnabled( false );
		
		smallText_txt = new Text(shell, SWT.BORDER);
		FormData fd_smallText_txt = new FormData();
		fd_smallText_txt.bottom = new FormAttachment(100, -312);
		fd_smallText_txt.right = new FormAttachment(largeText_lbl, 0, SWT.RIGHT);
		fd_smallText_txt.left = new FormAttachment(itemName_lbl, 0, SWT.LEFT);
		smallText_txt.setLayoutData(fd_smallText_txt);
		smallText_txt.setEnabled( false );
		
		largeTextLocation_lbl = new Label(shell, SWT.NONE);
		largeTextLocation_lbl.setText("Large Text Location:");
		FormData fd_largeTextLocation_lbl = new FormData();
		fd_largeTextLocation_lbl.top = new FormAttachment(largeText_lbl, 0, SWT.TOP);
		fd_largeTextLocation_lbl.left = new FormAttachment(itemName_lbl, 0, SWT.LEFT);
		fd_largeTextLocation_lbl.right = new FormAttachment(100, -373);
		largeTextLocation_lbl.setLayoutData(fd_largeTextLocation_lbl);
		largeTextLocation_lbl.setEnabled( false );
		
		smallTextLocation_lbl = new Label(shell, SWT.NONE);
		fd_smallText_lbl.top = new FormAttachment(smallTextLocation_lbl, 0, SWT.TOP);
		smallTextLocation_lbl.setText("Small Text Location:");
		FormData fd_largeTextLocation_lbl_1 = new FormData();
		fd_largeTextLocation_lbl_1.bottom = new FormAttachment(smallText_txt, -1);
		fd_largeTextLocation_lbl_1.left = new FormAttachment(itemName_lbl, 0, SWT.LEFT);
		smallTextLocation_lbl.setLayoutData(fd_largeTextLocation_lbl_1);
		smallTextLocation_lbl.setEnabled( false );
		
		largeTextLoc_txt = new Text(shell, SWT.BORDER);
		fd_largeText_txt.bottom = new FormAttachment(100, -359);
		FormData fd_largeTextLoc_txt = new FormData();
		fd_largeTextLoc_txt.top = new FormAttachment(largeText_lbl, 6);
		fd_largeTextLoc_txt.right = new FormAttachment(largeText_lbl, 0, SWT.RIGHT);
		fd_largeTextLoc_txt.left = new FormAttachment(itemName_lbl, 0, SWT.LEFT);
		largeTextLoc_txt.setLayoutData(fd_largeTextLoc_txt);
		largeTextLoc_txt.setEnabled( false );
		
		smallTextLoc_txt = new Text(shell, SWT.BORDER);
		FormData fd_smallTextLoc_txt = new FormData();
		fd_smallTextLoc_txt.bottom = new FormAttachment(smallText_txt, 0, SWT.BOTTOM);
		fd_smallTextLoc_txt.top = new FormAttachment(largeText_txt, 6);
		fd_smallTextLoc_txt.right = new FormAttachment(100, -10);
		fd_smallTextLoc_txt.left = new FormAttachment(smallText_txt, 6);
		smallTextLoc_txt.setLayoutData(fd_smallTextLoc_txt);
		smallTextLoc_txt.setEnabled( false );
		
		container_cpt = new Composite(shell, SWT.BORDER);
		FormData fd_container_cpt = new FormData();
		fd_container_cpt.top = new FormAttachment(0, 13);
		fd_container_cpt.bottom = new FormAttachment(100, -275);
		container_cpt.setLayoutData(fd_container_cpt);
		
		openMech_lst = new List(container_cpt, SWT.BORDER | SWT.V_SCROLL);
		openMech_lst.setEnabled(false);
		openMech_lst.setBounds(10, 214, 51, 85);
		openMech_lst.setItems(new String[] {"lift", "push", "pull", "press"});
		
		closeMech_lst = new List(container_cpt, SWT.BORDER | SWT.V_SCROLL);
		closeMech_lst.setEnabled(false);
		closeMech_lst.setBounds(67, 214, 51, 85);
		closeMech_lst.setItems(new String[] {"lift", "push", "pull", "press"});
		
		open_lbl = new Label(container_cpt, SWT.NONE);
		open_lbl.setEnabled(false);
		open_lbl.setBounds(10, 193, 51, 15);
		open_lbl.setAlignment(SWT.CENTER);
		open_lbl.setText("Open");
		
		close_lbl = new Label(container_cpt, SWT.NONE);
		close_lbl.setEnabled(false);
		close_lbl.setBounds(67, 193, 47, 15);
		close_lbl.setText("Close");
		close_lbl.setAlignment(SWT.CENTER);
		
		lockable_btn = new Button(container_cpt, SWT.CHECK);
		lockable_btn.setEnabled(false);
		lockable_btn.setBounds(10, 349, 68, 16);
		lockable_btn.setText("Lockable");
		
		AccessMech_lbl = new Label(container_cpt, SWT.NONE);
		AccessMech_lbl.setEnabled(false);
		AccessMech_lbl.setText("Access Mechanism:");
		AccessMech_lbl.setBounds(10, 145, 108, 15);
		
		thingHolder_cpt1 = new Composite(shell, SWT.BORDER);
		fd_container_cpt.left = new FormAttachment(thingHolder_cpt1, 6);
		FormData fd_thingHolder_cpt1 = new FormData();
		fd_thingHolder_cpt1.right = new FormAttachment(100, -976);
		thingHolder_cpt1.setLayoutData(fd_thingHolder_cpt1);
		
		holdsWithin_btn = new Button(thingHolder_cpt1, SWT.CHECK);
		holdsWithin_btn.setEnabled(false);
		holdsWithin_btn.setBounds(10, 10, 122, 16);
		holdsWithin_btn.setText("Holds Items Within");
		
		holdsUnderneath_btn = new Button(thingHolder_cpt1, SWT.CHECK);
		holdsUnderneath_btn.setEnabled(false);
		holdsUnderneath_btn.setBounds(10, 32, 156, 16);
		holdsUnderneath_btn.setText("Holds Items Underneath");
		
		holdsItemsOnTop_btn = new Button(thingHolder_cpt1, SWT.CHECK);
		holdsItemsOnTop_btn.setEnabled(false);
		holdsItemsOnTop_btn.setBounds(10, 54, 125, 16);
		holdsItemsOnTop_btn.setText("Holds Items On Top");
		
		thingHolder_cpt = new Composite(shell, SWT.BORDER);
		FormData fd_thingHolder_cpt = new FormData();
		fd_thingHolder_cpt.bottom = new FormAttachment(thingHolder_cpt1, -6);
		fd_thingHolder_cpt.right = new FormAttachment(100, -976);
		fd_thingHolder_cpt.top = new FormAttachment(itemName_lbl, 0, SWT.TOP);
		
		accessMech_txt = new Text(container_cpt, SWT.BORDER);
		accessMech_txt.setEnabled(false);
		accessMech_txt.setBounds(10, 166, 108, 21);
		
		Container = new Label(container_cpt, SWT.NONE);
		Container.setEnabled(false);
		Container.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		Container.setBounds(10, 10, 108, 15);
		Container.setText("Container");
		
		openable_btn = new Button(container_cpt, SWT.CHECK);
		openable_btn.setEnabled(false);
		openable_btn.setText("Openable");
		openable_btn.setBounds(10, 305, 68, 16);
		
		isOpen_btn = new Button(container_cpt, SWT.CHECK);
		isOpen_btn.setEnabled(false);
		isOpen_btn.setText("isOpen");
		isOpen_btn.setBounds(10, 327, 68, 16);
		
		isLocked = new Button(container_cpt, SWT.CHECK);
		isLocked.setEnabled(false);
		isLocked.setText("isLocked");
		isLocked.setBounds(10, 371, 68, 16);
		thingHolder_cpt.setLayoutData(fd_thingHolder_cpt);
		
		lblThingholder = new Label(thingHolder_cpt, SWT.NONE);
		lblThingholder.setEnabled(false);
		lblThingholder.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblThingholder.setBounds(10, 10, 80, 15);
		lblThingholder.setText("ThingHolder");
		
		isFurnature_btn = new Button(thingHolder_cpt, SWT.CHECK);
		isFurnature_btn.setEnabled(false);
		isFurnature_btn.setBounds(10, 31, 80, 16);
		isFurnature_btn.setText("isFurnature");
		
		isContainer_btn = new Button(thingHolder_cpt, SWT.CHECK);
		isContainer_btn.setEnabled(false);
		isContainer_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if( isContainer_btn.getSelection() ) {
					addContainerAttributes();
				} else {
					removeContainerAttributes();
				}
			}
		});
		isContainer_btn.setBounds(10, 53, 81, 16);
		isContainer_btn.setText("isContainer");
		
		thing_cpt = new Composite(shell, SWT.BORDER);
		fd_thingHolder_cpt1.left = new FormAttachment(thing_cpt, 6);
		fd_thingHolder_cpt1.top = new FormAttachment(thing_cpt, -84);
		fd_thingHolder_cpt1.bottom = new FormAttachment(thing_cpt, 0, SWT.BOTTOM);
		fd_thingHolder_cpt.left = new FormAttachment(0, 186);
		FormData fd_thing_cpt = new FormData();
		fd_thing_cpt.top = new FormAttachment(0, 13);
		fd_thing_cpt.left = new FormAttachment(0, 10);
		fd_thing_cpt.right = new FormAttachment(100, -1152);
		thing_cpt.setLayoutData(fd_thing_cpt);
		
		lblThing = new Label(thing_cpt, SWT.NONE);
		lblThing.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblThing.setBounds(10, 10, 59, 15);
		lblThing.setText("Thing");
		
		visible_btn = new Button(thing_cpt, SWT.CHECK);
		visible_btn.setBounds(10, 125, 55, 16);
		visible_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if( visible_btn.getSelection() ) {
					setVisibleAttributes();
				} else {
					removeVisibleAttributes();
				}
			}
		});
		visible_btn.setText("Visible");
		
		translucent_btn = new Button(thing_cpt, SWT.CHECK);
		translucent_btn.setBounds(10, 147, 80, 16);
		translucent_btn.setText("translucent");
		translucent_btn.setEnabled( false );
		
		readable_btn = new Button(thing_cpt, SWT.CHECK);
		readable_btn.setBounds(10, 169, 69, 16);
		readable_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if( readable_btn.getSelection() ) {
					setReadableAttributes();
				} else {
					removeReadableAttributes();
				}
			}
		});
		readable_btn.setText("Readable");
		readable_btn.setEnabled( false );
		
		isElement_btn = new Button(thing_cpt, SWT.CHECK);
		isElement_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if( isElement_btn.getSelection() ) {
					addMatterStateAttributes();
				} else {
					removeMatterStateAttributes();
				}
			}
		});
		isElement_btn.setBounds(10, 31, 72, 16);
		isElement_btn.setText("isElement");
		
		isThingHolder_btn = new Button(thing_cpt, SWT.CHECK);
		isThingHolder_btn.setBounds(10, 53, 95, 16);
		isThingHolder_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if( isThingHolder_btn.getSelection() ) {
					addThingHolderAttributes();
				} else {
					removeThingHolderAttributes();
				}
				
			}
		});
		isThingHolder_btn.setText("isThingHolder");
		
		drinkable_btn = new Button(thing_cpt, SWT.CHECK);
		drinkable_btn.setBounds(10, 191, 71, 16);
		drinkable_btn.setText("Drinkable");
		
		eatable_btn = new Button(thing_cpt, SWT.CHECK);
		eatable_btn.setBounds(10, 213, 59, 16);
		eatable_btn.setText("Eatable");
		
		smellable_btn = new Button(thing_cpt, SWT.CHECK);
		smellable_btn.setBounds(10, 235, 72, 16);
		smellable_btn.setText("Smellable");
		
		holdable_btn = new Button(thing_cpt, SWT.CHECK);
		holdable_btn.setBounds(10, 257, 69, 16);
		holdable_btn.setText("Holdable");
		
		attackable_btn = new Button(thing_cpt, SWT.CHECK);
		attackable_btn.setBounds(10, 323, 77, 16);
		attackable_btn.setText("Attackable");
		
		wieldable_btn = new Button(thing_cpt, SWT.CHECK);
		wieldable_btn.setBounds(10, 279, 73, 16);
		wieldable_btn.setText("Wieldable");
		
		wearable_btn = new Button(thing_cpt, SWT.CHECK);
		wearable_btn.setBounds(9, 301, 70, 16);
		wearable_btn.setText("Wearable");
		
		matterState_cpt = new Composite(shell, SWT.BORDER);
		FormData fd_matterState_cpt = new FormData();
		fd_matterState_cpt.right = new FormAttachment(thing_cpt, 0, SWT.RIGHT);
		fd_matterState_cpt.left = new FormAttachment(0, 10);
		fd_matterState_cpt.bottom = new FormAttachment(100, -9);
		matterState_cpt.setLayoutData(fd_matterState_cpt);
		
		matterState_lbl = new Label(matterState_cpt, SWT.NONE);
		matterState_lbl.setEnabled(false);
		matterState_lbl.setBounds(10, 31, 92, 15);
		matterState_lbl.setText("Matter State");
		
		solid_btn = new Button(matterState_cpt, SWT.CHECK);
		solid_btn.setSelection(true);
		solid_btn.setBounds(10, 52, 47, 16);
		solid_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setMatterState( "solid" );
			}
		});
		solid_btn.setText("Solid");
		solid_btn.setEnabled( false );
		
		gas_btn = new Button(matterState_cpt, SWT.CHECK);
		gas_btn.setBounds(63, 52, 40, 16);
		gas_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setMatterState( "gas" );
			}
		});
		gas_btn.setText("Gas");
		gas_btn.setEnabled( false );
		
		liquid_btn = new Button(matterState_cpt, SWT.CHECK);
		liquid_btn.setBounds(109, 52, 57, 16);
		liquid_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setMatterState( "liquid" );
			}
		});
		liquid_btn.setText("Liquid");
		liquid_btn.setEnabled( false );
		
		composite_6 = new Composite(shell, SWT.BORDER);
		fd_thing_cpt.bottom = new FormAttachment(composite_6, -6);
		fd_matterState_cpt.top = new FormAttachment(0, 570);
		
		isWeapon_btn = new Button(thing_cpt, SWT.CHECK);
		isWeapon_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if( isWeapon_btn.getSelection() ) {
					addWeaponAttributes();
				} else {
					removeWeaponAttributes();
				}
			}
		});
		isWeapon_btn.setText("isWeapon");
		isWeapon_btn.setBounds(10, 75, 73, 16);
		
		isArmor_btn = new Button(thing_cpt, SWT.CHECK);
		isArmor_btn.setText("isArmor");
		isArmor_btn.setBounds(10, 97, 70, 16);
		FormData fd_composite_6 = new FormData();
		fd_composite_6.top = new FormAttachment(0, 486);
		fd_composite_6.bottom = new FormAttachment(matterState_cpt, -6);
		fd_composite_6.left = new FormAttachment(0, 10);
		composite_6.setLayoutData(fd_composite_6);
		
		isUnderneath_btn = new Button(composite_6, SWT.CHECK);
		isUnderneath_btn.setBounds(10, 10, 91, 16);
		isUnderneath_btn.setText("isUnderneath");
		isUnderneath_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setLocation( "underneath" );
			}
		});
		
		isContainedWithin_btn = new Button(composite_6, SWT.CHECK);
		isContainedWithin_btn.setBounds(10, 32, 119, 16);
		isContainedWithin_btn.setText("isContainedWithin");
		isContainedWithin_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setLocation( "containedWithin" );
			}
		});
		
		isOnTopOf_btn = new Button(composite_6, SWT.CHECK);
		isOnTopOf_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setLocation( "onTop" );
			}
		});
		isOnTopOf_btn.setSelection(true);
		isOnTopOf_btn.setBounds(10, 54, 77, 16);
		isOnTopOf_btn.setText("isOnTopOf");
		
		isHCC_btn = new Button(container_cpt, SWT.CHECK);
		isHCC_btn.setEnabled(false);
		isHCC_btn.setBounds(10, 31, 54, 16);
		isHCC_btn.setText("isHCC");
		
		hcc_cpt = new Composite(shell, SWT.BORDER);
		fd_composite_6.right = new FormAttachment(hcc_cpt, -182);
		FormData fd_hcc_cpt = new FormData();
		fd_hcc_cpt.top = new FormAttachment(0, 420);
		fd_hcc_cpt.right = new FormAttachment(container_cpt, 0, SWT.RIGHT);
		fd_hcc_cpt.left = new FormAttachment(0, 362);
		
		element_lbl = new Label(matterState_cpt, SWT.NONE);
		element_lbl.setEnabled(false);
		element_lbl.setText("Element");
		element_lbl.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		element_lbl.setBounds(10, 10, 59, 15);
		
		quantity_lbl = new Label(matterState_cpt, SWT.NONE);
		quantity_lbl.setText("Grains:");
		quantity_lbl.setEnabled(false);
		quantity_lbl.setBounds(10, 77, 47, 15);
		
		text_2 = new Text(matterState_cpt, SWT.BORDER);
		text_2.setEnabled(false);
		text_2.setBounds(73, 74, 83, 21);
		fd_hcc_cpt.bottom = new FormAttachment(100, -75);
		
		size_lst = new List(container_cpt, SWT.BORDER | SWT.V_SCROLL);
		size_lst.setEnabled(false);
		size_lst.setItems(new String[] {"Very Small", "Small", "Medium", "Large", "Extra Large", "Magical"});
		size_lst.setBounds(10, 74, 108, 65);
		
		size_lbl = new Label(container_cpt, SWT.NONE);
		size_lbl.setEnabled(false);
		size_lbl.setText("Size:");
		size_lbl.setBounds(10, 53, 108, 15);
		hcc_cpt.setLayoutData(fd_hcc_cpt);
		
		hcc_lbl = new Label(hcc_cpt, SWT.NONE);
		hcc_lbl.setEnabled(false);
		hcc_lbl.setText("Homogeneous C C");
		hcc_lbl.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		hcc_lbl.setBounds(10, 10, 108, 15);
		
		list = new List(hcc_cpt, SWT.BORDER | SWT.MULTI);
		list.setEnabled(false);
		list.setItems(new String[] {"Solid", "Liquid", "Gas"});
		list.setBounds(10, 52, 108, 49);
		
		typesCanContain_lbl = new Label(hcc_cpt, SWT.NONE);
		typesCanContain_lbl.setEnabled(false);
		typesCanContain_lbl.setText("Types Can Contain:");
		typesCanContain_lbl.setBounds(10, 31, 108, 15);
		
		composite_8 = new Composite(shell, SWT.BORDER);
		fd_itemDescrip_txt.bottom = new FormAttachment(composite_8, -6);
		fd_largeText_lbl.top = new FormAttachment(0, 288);
		FormData fd_composite_8 = new FormData();
		fd_composite_8.top = new FormAttachment(0, 86);
		fd_composite_8.bottom = new FormAttachment(100, -409);
		fd_composite_8.left = new FormAttachment(itemName_lbl, 0, SWT.LEFT);
		fd_composite_8.right = new FormAttachment(itemName_txt, 0, SWT.RIGHT);
		composite_8.setLayoutData(fd_composite_8);
		
		type_lst = new List(composite_8, SWT.BORDER | SWT.V_SCROLL | SWT.SINGLE);
		type_lst.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				typeListIndex = type_lst.getSelectionIndex();
			}
		});
		type_lst.setBounds(238, 31, 95, 153);
		type_lst.setItems(new String[] {"Bottle", "Chest", "Revolver", "Ring"});
		
		type_lbl = new Label(composite_8, SWT.NONE);
		type_lbl.setBounds(238, 10, 68, 15);
		type_lbl.setText("Type:");
		
		itemDescriptors_lbl = new Label(composite_8, SWT.NONE);
		itemDescriptors_lbl.setBounds(143, 10, 89, 15);
		itemDescriptors_lbl.setText("Item Descriptors:");
		
		itemDescriptors_lst = new List(composite_8, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		itemDescriptors_lst.setItems(new String[] {"Bottle", "Jar", "Flask", "Beaker", "Cup"});
		itemDescriptors_lst.setBounds(143, 31, 89, 95);
		
		newDescriptor_txt = new Text(composite_8, SWT.BORDER);
		newDescriptor_txt.setBounds(143, 132, 89, 21);
		
		addDescriptor_btn = new Button(composite_8, SWT.NONE);
		addDescriptor_btn.setBounds(143, 159, 37, 25);
		addDescriptor_btn.setText("Add");
		
		deleteDescriptor_btn = new Button(composite_8, SWT.NONE);
		deleteDescriptor_btn.setText("Delete");
		deleteDescriptor_btn.setBounds(186, 159, 46, 25);
		
		altNames_lbl = new Label(composite_8, SWT.NONE);
		altNames_lbl.setBounds(10, 10, 58, 15);
		altNames_lbl.setText("Alt Names:");
		
		altNames_lst = new List(composite_8, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		altNames_lst.setItems(new String[] {"Bottle", "Jar", "Flask", "Beaker", "Cup"});
		altNames_lst.setBounds(10, 31, 127, 95);
		
		addAltName_txt = new Text(composite_8, SWT.BORDER);
		addAltName_txt.setBounds(10, 132, 127, 21);
		
		addAltName_btn = new Button(composite_8, SWT.NONE);
		addAltName_btn.setText("Add");
		addAltName_btn.setBounds(10, 159, 37, 25);
		
		deleteAltName_btn = new Button(composite_8, SWT.NONE);
		deleteAltName_btn.setText("Delete");
		deleteAltName_btn.setBounds(53, 159, 84, 25);
		
		weapon_cpt = new Composite(shell, SWT.BORDER);
		fd_container_cpt.right = new FormAttachment(weapon_cpt, -6);
		FormData fd_weapon_cpt = new FormData();
		fd_weapon_cpt.top = new FormAttachment(0, 13);
		fd_weapon_cpt.left = new FormAttachment(0, 498);
		fd_weapon_cpt.right = new FormAttachment(itemName_lbl, -161);
		weapon_cpt.setLayoutData(fd_weapon_cpt);
		
		weapon_lbl = new Label(weapon_cpt, SWT.NONE);
		weapon_lbl.setEnabled(false);
		weapon_lbl.setText("Weapon");
		weapon_lbl.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		weapon_lbl.setBounds(10, 10, 80, 15);
		
		isRangeWeapon_btn = new Button(weapon_cpt, SWT.CHECK);
		isRangeWeapon_btn.setEnabled(false);
		isRangeWeapon_btn.setText("isRangeWeapon");
		isRangeWeapon_btn.setBounds(10, 31, 146, 16);
		
		isCloseCombatWeapon = new Button(weapon_cpt, SWT.CHECK);
		isCloseCombatWeapon.setEnabled(false);
		isCloseCombatWeapon.setText("isClose Combat Weapon");
		isCloseCombatWeapon.setBounds(10, 53, 146, 16);
		
		damPot_lbl = new Label(weapon_cpt, SWT.NONE);
		damPot_lbl.setEnabled(false);
		damPot_lbl.setText("Damage Potential:");
		damPot_lbl.setBounds(10, 101, 103, 15);
		
		damPot_txt = new Text(weapon_cpt, SWT.BORDER);
		damPot_txt.setEnabled(false);
		damPot_txt.setBounds(119, 98, 37, 21);
		
		weaponHealth_lbl = new Label(weapon_cpt, SWT.NONE);
		weaponHealth_lbl.setEnabled(false);
		weaponHealth_lbl.setText("Weapon Health:");
		weaponHealth_lbl.setBounds(10, 125, 103, 15);
		
		text = new Text(weapon_cpt, SWT.BORDER);
		text.setEnabled(false);
		text.setBounds(119, 125, 37, 21);
		
		rangeWeapon_cpt = new Composite(shell, SWT.BORDER);
		fd_weapon_cpt.bottom = new FormAttachment(100, -521);
		
		isExplosive_lbl = new Button(weapon_cpt, SWT.CHECK);
		isExplosive_lbl.setEnabled(false);
		isExplosive_lbl.setText("isExplosive");
		isExplosive_lbl.setBounds(10, 75, 146, 16);
		FormData fd_rangeWeapon_cpt = new FormData();
		fd_rangeWeapon_cpt.top = new FormAttachment(weapon_cpt, 6);
		fd_rangeWeapon_cpt.right = new FormAttachment(smallText_txt, -161);
		fd_rangeWeapon_cpt.left = new FormAttachment(container_cpt, 6);
		rangeWeapon_cpt.setLayoutData(fd_rangeWeapon_cpt);
		
		rangeWeapon_lbl = new Label(rangeWeapon_cpt, SWT.NONE);
		rangeWeapon_lbl.setEnabled(false);
		rangeWeapon_lbl.setText("Range Weapon");
		rangeWeapon_lbl.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		rangeWeapon_lbl.setBounds(10, 10, 150, 15);
		
		weaponRange_lbl = new Label(rangeWeapon_cpt, SWT.NONE);
		weaponRange_lbl.setEnabled(false);
		weaponRange_lbl.setText("Weapon Range:");
		weaponRange_lbl.setBounds(10, 31, 103, 15);
		
		text_1 = new Text(rangeWeapon_cpt, SWT.BORDER);
		text_1.setEnabled(false);
		text_1.setBounds(119, 28, 37, 21);
		
		explosive_cpt = new Composite(shell, SWT.BORDER);
		fd_rangeWeapon_cpt.bottom = new FormAttachment(explosive_cpt, -6);
		
		projectileType_lbl = new Label(rangeWeapon_cpt, SWT.NONE);
		projectileType_lbl.setEnabled(false);
		projectileType_lbl.setText("Projectile Type:");
		projectileType_lbl.setBounds(10, 52, 103, 15);
		
		altNames_lst_1 = new List(rangeWeapon_cpt, SWT.BORDER | SWT.V_SCROLL);
		altNames_lst_1.setEnabled(false);
		altNames_lst_1.setItems(new String[] {"Plasma", "Laser", "Kinetic"});
		altNames_lst_1.setBounds(10, 73, 146, 49);
		FormData fd_explosive_cpt = new FormData();
		fd_explosive_cpt.top = new FormAttachment(largeTextLoc_txt, 14, SWT.TOP);
		fd_explosive_cpt.left = new FormAttachment(container_cpt, 6);
		fd_explosive_cpt.right = new FormAttachment(100, -664);
		fd_explosive_cpt.bottom = new FormAttachment(100, -236);
		explosive_cpt.setLayoutData(fd_explosive_cpt);
		
		rangeWeapon_lbl_1 = new Label(explosive_cpt, SWT.NONE);
		rangeWeapon_lbl_1.setEnabled(false);
		rangeWeapon_lbl_1.setText("Explosive");
		rangeWeapon_lbl_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		rangeWeapon_lbl_1.setBounds(10, 10, 150, 15);
		
		effectedRadius_lbl = new Label(explosive_cpt, SWT.NONE);
		effectedRadius_lbl.setEnabled(false);
		effectedRadius_lbl.setText("Effected Radius:");
		effectedRadius_lbl.setBounds(10, 28, 103, 15);
		
		effectedRadius_txt = new Text(explosive_cpt, SWT.BORDER);
		effectedRadius_txt.setEnabled(false);
		effectedRadius_txt.setBounds(119, 25, 37, 21);
		
		explosiveType_lbl = new Label(explosive_cpt, SWT.NONE);
		explosiveType_lbl.setEnabled(false);
		explosiveType_lbl.setText("Explosive Type:");
		explosiveType_lbl.setBounds(10, 49, 103, 15);
		
		explosiveType_lst = new List(explosive_cpt, SWT.BORDER | SWT.V_SCROLL);
		explosiveType_lst.setEnabled(false);
		explosiveType_lst.setItems(new String[] {"Fire", "Freeze", "Magnetic", "Concusion", "Flash"});
		explosiveType_lst.setBounds(10, 70, 146, 49);
		
		composite_12 = new Composite(shell, SWT.BORDER);
		FormData fd_composite_12 = new FormData();
		fd_composite_12.top = new FormAttachment(smallText_txt, 371, SWT.TOP);
		fd_composite_12.left = new FormAttachment(explosive_cpt, 6);
		fd_composite_12.right = new FormAttachment(100, -508);
		composite_12.setLayoutData(fd_composite_12);
		
		Armor_lbl = new Label(composite_12, SWT.NONE);
		Armor_lbl.setEnabled(false);
		Armor_lbl.setText("Armor");
		Armor_lbl.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		Armor_lbl.setBounds(10, 10, 80, 15);
		
		save_btn = new Button(shell, SWT.NONE);
		
		itemChar_lbl = new Label(composite_8, SWT.NONE);
		itemChar_lbl.setBounds(339, 10, 58, 15);
		itemChar_lbl.setText("Item Char:");
		
		itemChar_txt = new Text(composite_8, SWT.BORDER);
		itemChar_txt.setBounds(413, 7, 66, 21);
		
		itemSize_txt = new Text(composite_8, SWT.BORDER);
		itemSize_txt.setBounds(413, 34, 66, 21);
		
		itemSize_lbl = new Label(composite_8, SWT.NONE);
		itemSize_lbl.setBounds(339, 37, 50, 15);
		itemSize_lbl.setText("Item Size:");
		
		itemWeight_txt = new Text(composite_8, SWT.BORDER);
		itemWeight_txt.setBounds(413, 61, 66, 21);
		
		itemWeight_lbl = new Label(composite_8, SWT.NONE);
		itemWeight_lbl.setBounds(339, 64, 68, 15);
		itemWeight_lbl.setText("Item Weight:");
		
		itemValue_btn = new Label(composite_8, SWT.NONE);
		itemValue_btn.setBounds(339, 91, 58, 15);
		itemValue_btn.setText("Item Value:");
		
		itemValue_txt = new Text(composite_8, SWT.BORDER);
		itemValue_txt.setBounds(413, 88, 66, 21);
		save_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				buildItem();
				tHolder.getThings().add( getItem() );
				WorldBuilder.wb.updateItemsTree();
				updateItemsTree();
			}
		});
		FormData fd_save_btn = new FormData();
		fd_save_btn.right = new FormAttachment(100, -10);
		fd_save_btn.top = new FormAttachment(100, -45);
		fd_save_btn.bottom = new FormAttachment(100, -10);
		save_btn.setLayoutData(fd_save_btn);
		save_btn.setText("Save");
		fd_save_btn.left = new FormAttachment(0, 1223);
		
		containedItems_cpt = new Composite(shell, SWT.BORDER);
		FormData fd_containedItems_cpt = new FormData();
		fd_containedItems_cpt.bottom = new FormAttachment(matterState_cpt, 0, SWT.BOTTOM);
		fd_containedItems_cpt.right = new FormAttachment(largeText_lbl, 0, SWT.RIGHT);
		fd_containedItems_cpt.top = new FormAttachment(smallText_txt, 6);
		fd_containedItems_cpt.left = new FormAttachment(itemName_lbl, 0, SWT.LEFT);
		containedItems_cpt.setLayoutData(fd_containedItems_cpt);
		
		items_tree = new Tree(containedItems_cpt, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION | SWT.VIRTUAL);
		items_tree.setEnabled(false);
		items_tree.setBounds(10, 10, 199, 235);
		items_tree.setTouchEnabled(true);
		items_tree.setToolTipText("");
		items_tree.setLinesVisible(true);
		items_tree.setHeaderVisible(true);
		items_tree.setHeaderForeground(SWTResourceManager.getColor(0, 0, 128));
		items_tree.setHeaderBackground(SWTResourceManager.getColor(230, 230, 250));
		items_tree.setForeground(SWTResourceManager.getColor(0, 0, 0));
		
		trclmnItem = new TreeColumn(items_tree, SWT.NONE);
		trclmnItem.setWidth(153);
		trclmnItem.setText("Contained Items");
		
		deleteItem_btn = new Button(containedItems_cpt, SWT.NONE);
		deleteItem_btn.setEnabled(false);
		deleteItem_btn.setBounds(144, 251, 65, 36);
		deleteItem_btn.setText("Delete Item");
		
		addItem_btn = new Button(containedItems_cpt, SWT.NONE);
		addItem_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				buildItem();
				new ItemBuilder( (ThingHolder ) item );
				updateItemsTree();
			}
		});
		addItem_btn.setEnabled(false);
		addItem_btn.setBounds(10, 251, 61, 36);
		addItem_btn.setText("Add Item");
		
		editItem_btn = new Button(containedItems_cpt, SWT.NONE);
		editItem_btn.setEnabled(false);
		editItem_btn.setBounds(77, 251, 61, 36);
		editItem_btn.setText("Edit Item");
		
		cancel_btn = new Button(shell, SWT.NONE);
		cancel_btn.setText("Cancel");
		FormData fd_cancel_btn = new FormData();
		fd_cancel_btn.bottom = new FormAttachment(matterState_cpt, 0, SWT.BOTTOM);
		fd_cancel_btn.left = new FormAttachment(save_btn, -100, SWT.LEFT);
		fd_cancel_btn.top = new FormAttachment(save_btn, 0, SWT.TOP);
		fd_cancel_btn.right = new FormAttachment(save_btn, -6);
		cancel_btn.setLayoutData(fd_cancel_btn);
		


	}
	




	public void buildItem() {
		
		ThingGenerator tg = new ThingGenerator();
		Thing item = tg.getThing( type_lst.getItem( type_lst.getSelectionIndex() ) );
		
		/*
		 *  Set all attributes for a thing object.
		 */
		
		// Set Name
		item.setName( itemName_txt.getText() );
		
		// Set Description
		item.setDescription( itemDescrip_txt.getText() );
		
		// Set AltNames
		String[] altNames = new String[ altNames_lst.getItemCount() ];
		for( int i = 0; i < altNames_lst.getItemCount(); i++ ) {
			altNames[ i ] = altNames_lst.getItem( i );
		}
		item.setAltNames( altNames );
		
		// Set Item Descriptors
		String[] itemDescriptors = new String[ itemDescriptors_lst.getItemCount() ];
		for( int i = 0; i < itemDescriptors_lst.getItemCount(); i++ ) {
			itemDescriptors[ i ] = itemDescriptors_lst.getItem( i );
		}
		item.setDescriptors( itemDescriptors );
		
		// Set Default Tile Char
		item.setTileChar( itemChar_txt.getText() );
		
		// Set Item Value
		try
		{
			item.setValue( Integer.parseInt( itemValue_txt.getText() ) );
		}
		catch(NumberFormatException e)
		{
		  new Message( "Item value must be an integer." );
		  return;
		}
		
		// Set Item Weight
		try
		{
			item.setWeight( Double.parseDouble( itemWeight_txt.getText() ) );
		}
		catch(NumberFormatException e)
		{
		  new Message( "Item weight must be an double." );
		  return;
		}
		
		
		// Set Item Size
		try
		{
			item.setSize( Integer.parseInt( itemSize_txt.getText() ) );
		}
		catch(NumberFormatException e)
		{
		  new Message( "Item weight must be a number greater than zero and less than 10." );
		  return;
		}
		
		// Set Visible
		item.setVisible( visible_btn.getSelection() );
		
		// Set Readable 
		if( readable_btn.getSelection() ) {
			item.setReadable( readable_btn.getSelection() );
			if( !largeText_txt.getText().equals( "" ) ) {
				item.setHasLargeText( true );
				item.setReadableLargeText( largeText_txt.getText() );
			}
			if( !largeTextLoc_txt.getText().equals( "" ) ) {
				item.setReadableLargeTextLocation( largeTextLoc_txt.getText() );
			}
			if( !smallText_txt.getText().equals( "" ) ) {
				item.setHasSmallText( true );
				item.setReadableSmallText( smallText_txt.getText() );
			}
			if( !smallTextLoc_txt.getText().equals( "" ) ) {
				item.setReadableSmallTextLocation( smallTextLoc_txt.getText() );
			}
		}
		
		// Set Translucent
		item.setTranslucence( translucent_btn.getSelection() );
		
		// Set Drinkable
		item.setDrinkable( drinkable_btn.getSelection() );
		
		// Set Eatable
		item.setEatable( eatable_btn.getSelection() );
		
		// Set Holdable
		item.setHoldable( holdable_btn.getSelection() );
		
		// Set Wearable
		item.setWearable( wearable_btn.getSelection() );
		
		// Set Attackable
		item.setAttackable( attackable_btn.getSelection() );
		
		// Set Wieldable
		item.setWieldable( wieldable_btn.getSelection() );
		
		// Set isOnTopOf
		item.setOnTopOf( isOnTopOf_btn.getSelection() );

		// Set isUnderneath
		item.setUnderneath( isUnderneath_btn.getSelection() );
		
		// Set isContainedWithin
		item.setContainedWithin( isContainedWithin_btn.getSelection() );
		
		// Cast to Element
		if( isElement_btn.getSelection() ) {
			Element element = ( Element ) item;
			if( solid_btn.getSelection() ) {
				element.setSolid( true );
				matterState_cpt.layout();
			} else if( liquid_btn.getSelection() ) {
				element.setLiquid( true );
				matterState_cpt.layout();
			} else if( gas_btn.getSelection() ) {
				element.setGas( true );
				matterState_cpt.layout();
			}
			 
		// Set ThingHolder Attributes 
		} else if( isThingHolder_btn.getSelection() ) {
			
			
			ThingHolder thingHolder = ( ThingHolder ) item;
			
			// This is to ensure that contained items are retained when new builds are made of upper level items
			if( this.item != null ) {
				if( this.item.isThingHolder() ) {
					ThingHolder tHolder = ( ThingHolder ) this.item;
					if( !tHolder.getThings().isEmpty() ) {
						thingHolder.setThings( tHolder.getThings() );
					}
				}
			}
			
			this.item = thingHolder;
			return;
			
		}
		this.item = item;
	}
	
	public void addThingHolderAttributes() {
		changeEnableAll( thingHolder_cpt, true );
		changeEnableAll( thingHolder_cpt1, true );
		changeEnableAll( containedItems_cpt, true );
		holdsWithin_btn.setEnabled( false );
	}
	
	public void removeThingHolderAttributes() {
		deselectAllButtons( thingHolder_cpt );
		changeEnableAll( containedItems_cpt, false );
		changeEnableAll( thingHolder_cpt, false );
		changeEnableAll( thingHolder_cpt1, false );
	}
	
	public void setMatterState( String state ) {
		if( state.equals( "solid" ) ) {
			liquid_btn.setSelection( false );
			gas_btn.setSelection( false );
			quantity_lbl.setText( "Grains:" );
		} else if( state.equals( "liquid" ) ) {
			gas_btn.setSelection( false );
			solid_btn.setSelection( false );
			quantity_lbl.setText( "Drops:" );
		} else if( state.equals( "gas" ) ) {
			solid_btn.setSelection( false );
			liquid_btn.setSelection( false );
			quantity_lbl.setText( "Parts:" );
		}
	}
	
	public void setLocation( String state ) {
		if( state.equals( "onTop" ) ) {
			isUnderneath_btn.setSelection( false );
			isContainedWithin_btn.setSelection( false );
		} else if( state.equals( "underneath" ) ) {
			isContainedWithin_btn.setSelection( false );
			isOnTopOf_btn.setSelection( false );
		} else if( state.equals( "containedWithin" ) ) {
			isOnTopOf_btn.setSelection( false );
			isUnderneath_btn.setSelection( false );
		}
	}
	
	public void addMatterStateAttributes() {

		isThingHolder_btn.setSelection( false );
		isThingHolder_btn.setEnabled( false );
		removeThingHolderAttributes();
		changeEnableAll( thingHolder_cpt, false );
		changeEnableAll( container_cpt, false );
		changeEnableAll( matterState_cpt, true );
	}
	
	public void removeMatterStateAttributes() {

		changeEnableAll( matterState_cpt, false );
		isThingHolder_btn.setEnabled( true );
		
	}
	
	public void setVisibleAttributes() {
		translucent_btn.setEnabled( true );
		readable_btn.setEnabled( true );		
	}
	
	public void removeVisibleAttributes() {
		translucent_btn.setEnabled( false );
		translucent_btn.setSelection( false );
		readable_btn.setEnabled( false );	
		readable_btn.setSelection( false );
		
		removeReadableAttributes();
	}
	
	public void setReadableAttributes() {
		largeText_txt.setEnabled( true );
		largeText_lbl.setEnabled( true );
		largeTextLocation_lbl.setEnabled( true );
		largeTextLoc_txt.setEnabled( true );
		smallText_txt.setEnabled( true );
		smallText_lbl.setEnabled( true );
		smallTextLocation_lbl.setEnabled( true );
		smallTextLoc_txt.setEnabled( true );
	}
	
	public void removeReadableAttributes() {
		largeText_lbl.setEnabled( false );
		largeText_txt.setEnabled( false );
		largeText_txt.setText( "" );
		largeTextLocation_lbl.setEnabled( false );
		largeTextLoc_txt.setEnabled( false );
		largeTextLoc_txt.setText( "" );
		smallText_lbl.setEnabled( false );
		smallText_txt.setEnabled( false );
		smallText_txt.setText( "" );
		smallTextLocation_lbl.setEnabled( false );
		smallTextLoc_txt.setEnabled( false );
		smallTextLoc_txt.setText( "" );
	}
	
	public void addContainerAttributes() {
		changeEnableAll( container_cpt, true );
		holdsWithin_btn.setSelection( true );
		holdsItemsOnTop_btn.setSelection( false );
		holdsUnderneath_btn.setSelection( false );
		holdsItemsOnTop_btn.setEnabled( false );
		holdsUnderneath_btn.setEnabled( false );
	}
	
	public void removeContainerAttributes() {
		changeEnableAll( container_cpt, false );
		holdsWithin_btn.setSelection( false );
		holdsWithin_btn.setEnabled( false );
		holdsItemsOnTop_btn.setEnabled( true );
		holdsUnderneath_btn.setEnabled( true );
		
	}
	
	protected void addWeaponAttributes() {
		isThingHolder_btn.setSelection( false );
		isThingHolder_btn.setEnabled( false );
		removeThingHolderAttributes();
		changeEnableAll( thingHolder_cpt, false );
		changeEnableAll( container_cpt, false );
		changeEnableAll( weapon_cpt, true );
		
	}
	
	protected void removeWeaponAttributes() {
		changeEnableAll( weapon_cpt, false );
		deselectAllButtons( weapon_cpt );
		changeEnableAll( rangeWeapon_cpt, false );
		changeEnableAll( explosive_cpt, false );
		isThingHolder_btn.setEnabled( true );
		
	}
	
	public void deselectAllButtons( Composite c ) {
		for( Control control : c.getChildren() ) {
			if( control instanceof Button ) {
				Button button = ( Button ) control;
				button.setSelection( false );
			}
		}
	}
	
	public void changeEnableAllButtons( Composite c, boolean enable ) {
		for( Control control : c.getChildren() ) {
			if( control instanceof Button ) {
				Button button = ( Button ) control;
				button.setEnabled( enable );
			}
		}
	}
	
	public void changeEnableAll( Composite c, boolean enable ) {
		for( Control control : c.getChildren() ) {
			if( control instanceof Button ) {
				Button button = ( Button ) control;
				button.setEnabled( enable );
			}
			if( control instanceof List ) {
				List list = ( List ) control;
				list.setEnabled( enable );
			}
			if( control instanceof Label ) {
				Label label = ( Label ) control;
				label.setEnabled( enable );
			}
			if( control instanceof Text ) {
				Text text = ( Text ) control;
				text.setEnabled( enable );
			}
			if( control instanceof Tree ) {
				Tree tree = ( Tree ) control;
				tree.setEnabled( enable );
			}
		}
	}
	
	public Thing getItem() {
		return item;
	}
	
	public void updateItemsTree(){
		items_tree.removeAll();
		if( item.isThingHolder() ) {
			ThingHolder tHolder = ( ThingHolder ) item;
			ThingList things = tHolder.getThings();
			for( int i = 0; i < things.size(); i++ ) {
				Thing thing = things.get( i );
				TreeItem treeItem = new TreeItem( items_tree, 0 );
				treeItem.setText( thing.getName() );
				if( thing.isThingHolder() ) {
					getAll( thing, treeItem );
				}
			}
		}
	}
	
	private void getAll( Thing thing, TreeItem treeItem ) {
		
		ThingHolder thingHolder = ( ThingHolder ) thing;
		ThingList things = thingHolder.getThings();
		for( int i = 0; i < things.size(); i++ ) {
			Thing t = things.get( i );
			TreeItem ti = new TreeItem( treeItem, 0 );
			ti.setText( t.getName() );
			if( t.isThingHolder() ) {
				getAll( t, ti );
			}
		}
	}
}
