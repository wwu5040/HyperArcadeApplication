package devin;


import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;


public class Inventory extends FullFunctionScreen {
	
	private Button back;

	public Inventory(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/inventory.png"));
		//back = new Button (0,100,200,100,"GO Back",new Action() {
			//public void act() {
			//	ArcadeGUI.test.setScreen(ArcadeGUI.screen1);
		//	}
		//}
	}

}
