package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.swing.Timer;
import javax.vecmath.*;

public class SnowMan implements ActionListener {
    private TransformGroup carTransformGroup = new TransformGroup();
    private Transform3D carTransform3D = new Transform3D();
    private Timer timer;
    private float angle= 0;

    public static void main(String[] args) {
        new SnowMan();
    }

    private SnowMan() {
        timer = new Timer(50, this);
        timer.start();
        BranchGroup scene = createSceneGraph();
        SimpleUniverse u = new SimpleUniverse();
        u.getViewingPlatform().setNominalViewingTransform();
        u.addBranchGraph(scene);
    }

    private BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();

        carTransformGroup = new TransformGroup();
        carTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        buildCastleSkeleton();
        objRoot.addChild(carTransformGroup);

        Background background = new Background(new Color3f(1.0f, 1.0f, 1.0f));
        BoundingSphere sphere = new BoundingSphere(new Point3d(0,0,0), 100000);
        background.setApplicationBounds(sphere);
        objRoot.addChild(background);

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        Color3f light1Color = new Color3f(1.0f, 0.5f, 0.4f);
        Vector3f light1Direction = new Vector3f(.8f, .8f, .0f);
        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
        light1.setInfluencingBounds(bounds);
        objRoot.addChild(light1);

        Color3f ambientColor = new Color3f(1.0f, 1.0f, 1.0f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        objRoot.addChild(ambientLightNode);
        return objRoot;
    }

    private void buildCastleSkeleton() {
        Sphere body1 = SnowManBody.getPart(.3f);
        Transform3D body1T = new Transform3D();
        body1T.setTranslation(new Vector3f(.0f, -.4f, .0f));
        TransformGroup body1TG = new TransformGroup();
        body1TG.setTransform(body1T);
        body1TG.addChild(body1);
        carTransformGroup.addChild(body1TG);

        Sphere body2 = SnowManBody.getPart(.25f);
        Transform3D body2T = new Transform3D();
        body2T.setTranslation(new Vector3f(.0f, .0f, .0f));
        TransformGroup body2TG = new TransformGroup();
        body2TG.setTransform(body2T);
        body2TG.addChild(body2);
        carTransformGroup.addChild(body2TG);

        Sphere body3 = SnowManBody.getPart(.2f);
        Transform3D body3T = new Transform3D();
        body3T.setTranslation(new Vector3f(.0f, .35f, .0f));
        TransformGroup body3TG = new TransformGroup();
        body3TG.setTransform(body3T);
        body3TG.addChild(body3);
        carTransformGroup.addChild(body3TG);

        Cylinder body4 = SnowManBody.getHat(.2f, .05f);
        Transform3D body4T = new Transform3D();
        body4T.setTranslation(new Vector3f(.0f, .5f, .0f));
        TransformGroup body4TG = new TransformGroup();
        body4TG.setTransform(body4T);
        body4TG.addChild(body4);
        carTransformGroup.addChild(body4TG);

        Cylinder body5 = SnowManBody.getHat(.1f, .2f);
        Transform3D body5T = new Transform3D();
        body5T.setTranslation(new Vector3f(.0f, .60f, .0f));
        TransformGroup body5TG = new TransformGroup();
        body5TG.setTransform(body5T);
        body5TG.addChild(body5);
        carTransformGroup.addChild(body5TG);

        Cone body6 = SnowManBody.getCarrot(0.05f, 0.2f);
        Transform3D body6T = new Transform3D();
        body6T.rotX(Math.PI/2);
        body6T.setTranslation(new Vector3f(.0f, .3f, .25f));
        TransformGroup body6TG = new TransformGroup();
        body6TG.setTransform(body6T);
        body6TG.addChild(body6);
        carTransformGroup.addChild(body6TG);

        createButton(.0f, -.1f, .21f);
        createButton(.0f, .0f, .23f);
        createButton(.0f, .1f, .21f);

        createButton(-.05f, .4f, .16f);
        createButton(.05f, .4f, .16f);
    }

    private void createButton(float x, float y, float z) {
        TransformGroup tg = new TransformGroup();
        Transform3D transform = new Transform3D();
        transform.rotX(Math.PI/2);
        Cylinder button = SnowManBody.getButton(.02f);
        Vector3f vector = new Vector3f(x, y, z);
        transform.setTranslation(vector);
        tg.setTransform(transform);
        tg.addChild(button);
        carTransformGroup.addChild(tg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        carTransform3D.rotY(angle);
        carTransformGroup.setTransform(carTransform3D);
        angle += 0.05;
    }
}

