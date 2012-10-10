package org.spacerobots.riyad;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 * Created with IntelliJ IDEA.
 * User: shep
 * Date: 10/9/12
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bit {

    private Geometry box1;
    private Geometry box2;
    private Geometry box3;
    private Geometry box4;

    float timeVar;

    private float rotateScale = 0.1f;

    private boolean isPaused = false;
    private boolean isTalking = false;

    public Bit(AssetManager assetManager, Node attachNode) {
        Box b = new Box(Vector3f.ZERO, 1, 1, 1);
        //Box c = new Box(Vector3f.ZERO, 1, 1, 1);
        //Box d = new Box(Vector3f.ZERO, 1, 1, 1);
        box1 = new Geometry("cube1", b);
        box2 = new Geometry("cube2", b);
        box3 = new Geometry("cube3", b);
        box4 = new Geometry("cube3", b);
        box2.rotate(2,1,2);
        box3.rotate(1,2,1);
        box4.rotate(1,1,2);
        Material mat = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", new ColorRGBA(0.1f,0.1f,0.5f,0));
        box1.setMaterial(mat);
        Material mat2 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", new ColorRGBA(0.1f,0.1f,0.7f,0));
        box2.setMaterial(mat2);
        Material mat3 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat3.setColor("Color",new ColorRGBA(0.1f,0.1f,0.9f,0));
        box3.setMaterial(mat3);
        Material mat4 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat4.setColor("Color",new ColorRGBA(0.1f,0.1f,0.3f,0));
        box4.setMaterial(mat4);
        attachNode.attachChild(box1);
        attachNode.attachChild(box2);
        attachNode.attachChild(box3);
        attachNode.attachChild(box4);
    }

    public void enable(boolean paused) {
        this.isPaused = paused;
    }

    public boolean isEnabled() {
        return this.isPaused;
    }

    public void talking(boolean talking) {
        this.isTalking = talking;
    }

    public boolean isTalking() {
        return this.isTalking;
    }

    public void rotateBit() {
        if(isPaused)
            return;
        if(timeVar > 90)
            timeVar=0;
        else
            timeVar++;
        float scale = FastMath.sin(timeVar)*0.10f + 1f;
        box1.setLocalScale((float) scale);
        box1.rotate(1.3f * rotateScale, 2 * rotateScale, 1.3f * rotateScale);
        box2.setLocalScale((float) scale);
        box2.rotate(1.3f * rotateScale, 2 * rotateScale, 1.3f * rotateScale);
        box3.setLocalScale((float) scale);
        box3.rotate(1.3f * rotateScale, 2 * rotateScale, 1.3f * rotateScale);
        if(isTalking) {
            float i = FastMath.sin(timeVar);
            box3.getMaterial().setColor("Color",new ColorRGBA(0.3f*i,0.3f*i,1.0f,0));
            box4.getMaterial().setColor("Color",new ColorRGBA(0.6f*i,0.6f*i,1.0f,0));
        } else {
            box3.getMaterial().setColor("Color",new ColorRGBA(0.1f,0.1f,0.9f,0));
            box4.getMaterial().setColor("Color",new ColorRGBA(0.1f,0.1f,0.3f,0));
        }
        box4.setLocalScale((float) scale);
        box4.rotate(1.3f* rotateScale, 2*rotateScale, 1.3f* rotateScale);
    }
}
