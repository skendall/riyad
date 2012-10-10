package org.spacerobots.riyad;

import com.jme3.app.SimpleApplication;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.MouseButtonTrigger;

/** Sample 1 - how to get started with the most simple JME 3 application.
 * Display a blue 3D cube and view from all sides by
 * moving the mouse and pressing the WASD keys. */
public class App extends SimpleApplication implements ActionListener {

    public static void main(String[] args){
        App app = new App();
        app.setShowSettings(false);
        app.setDisplayStatView(false);
        app.start(); // start the game
    }

    private long counter = 0;
    private Bit bit;

    @Override
    public void simpleInitApp() {
        bit = new Bit(assetManager,rootNode);
        inputManager.addMapping("Button1", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        inputManager.addMapping("Button2", new MouseButtonTrigger(MouseInput.BUTTON_RIGHT));
        inputManager.addListener(this,new String[]{"Button1","Button2"});
    }

    /* This is the update loop */
    @Override
    public void simpleUpdate(float tpf) {
        counter++;
        if(counter % 200 == 0)
            bit.rotateBit();
    }

    @Override
    public void onAction(String s, boolean b, float v) {
        if(s.equals("Button1"))
            bit.enable(b);
        if(s.equals("Button2"))
            bit.talking(b);

    }
}