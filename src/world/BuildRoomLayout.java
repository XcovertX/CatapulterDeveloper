package world;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import gameObjects.ThingList;
import mapBuilder.Confirmation;
import mapBuilder.WorldBuilder;

public class BuildRoomLayout {
	
	private GameRoom gr;
	private int roomLength;
	private int roomWidth;
	private int roomSize;
	private Composite tileLayout;
	
	public BuildRoomLayout() {
		this.gr = WorldBuilder.wb.getGr();
		tileLayout = WorldBuilder.wb.getTileLayout();
		roomLayout();
	}
	
	private void roomLayout() {
	    	
    	this.roomLength = gr.getRoomLength();
    	this.roomWidth = gr.getRoomWidth();
    	this.roomSize = roomLength * roomWidth;
    	
    	WorldBuilder.wb.setRoomTiles( roomSize );
	    
	    
	    // Builds the map master copy in MapBuilder
	   // currentMapBuilder.buildLayout( roomNumberTotal );
	    
	    // Builds the map working copy in view
//	    buildLayout( roomSize );
	    
	    int index = 0;
	    		
	    for( int i = roomWidth; i > 0; i-- ) {
	    	
	    	for( int j = 1; j <= roomLength; j++ ) {
	    		
	    		if( WorldBuilder.wb.isNewRoom() ) {
	    			
		    		GameTile tile = new GameTile();
		    		tile.setTileNumber( index );
		    		gr.addTile( tile );
		    		
	    		}
	    		
	    		addButton( tileLayout, index, j, i );
	    		index++;
	    	}
	    }

		WorldBuilder.wb.setGt( ( GameTile) gr.getTiles().get( 0 ) );
		WorldBuilder.wb.getRoomTiles()[ 0 ].setSelection( true );
	    tileLayout.setEnabled( true );
	    tileLayout.setVisible( true );
    }
    
    // adds buttons to mapLayout
    private void addButton(Composite com, int tileNumber, int i, int j) {
    	
        Button button = new Button( com, SWT.FLAT );
        if( gr.getTiles().size() > 0 ) {
        	if( ( (GameTile) gr.getTiles().get( tileNumber ) ).getNotTile() ) {
        		button.setBackground( new Color( null, 36, 36, 36 ) );;
        	}
        } else {
        	button.setBackground( new Color( null, 210, 214, 217 ) );
        }
        
        int tileSizeModifier;
        if( roomLength > roomWidth ) {
        	tileSizeModifier = Math.round( 385 / ( roomLength + 2 ) );
        } else {
        	tileSizeModifier = Math.round( 385 / ( roomWidth + 2 ) );
        }
        
        button.setBounds( tileSizeModifier * i, tileSizeModifier * j, tileSizeModifier, tileSizeModifier );
        
        if( roomSize < 150 ) {
        	button.setFont( SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL) );
        	button.setText( Integer.toString( tileNumber ) );
        } else if( roomSize < 300 ) {
        	button.setFont( SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL) );
        	button.setText( Integer.toString( tileNumber ) );
        } else if( roomSize < 500 ) {
        	button.setFont( SWTResourceManager.getFont("Segoe UI", 4, SWT.NORMAL) );
        	button.setText( Integer.toString( tileNumber ) );
        }
		
        WorldBuilder.wb.getRoomTiles()[ tileNumber ] = button;
        WorldBuilder.wb.getRoomTiles()[ tileNumber ].addMouseListener(new MouseAdapter() {
        	
			@Override
			public void mouseDown(MouseEvent e) {
				
				WorldBuilder.wb.saveTile();
				WorldBuilder.wb.setGt( ( GameTile ) gr.getTiles().get( tileNumber ) );
				WorldBuilder.wb.updateTileViewer();
			}
		});
        
        WorldBuilder.wb.getButtonlist().add(button);
       
        
    }
    
	public void buildTile() {
		
		
//		this.currentRoom = new GameRoom( currentRoomName, currentRoomDescription, currentMap, tiles, roomLength, roomWidth );
//		boolean notTile = false;
//		
//		
//		for( int i = 0; i < numberOfTiles; i++ ) {
//			
//			int tileNumber = i;
//			ThingList items = new ThingList();
//			ThingList npcs = new ThingList();
//			
//			this.currentRoom.addTile( new GameTile( "", "", currentRoom, items, npcs, tileNumber, notTile, " . " ) );
//			this.currentTileList = this.currentRoom.getTiles();
//		}
	}

}
