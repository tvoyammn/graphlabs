package com.company;

import java.awt.Container;
import javax.media.j3d.*; // for transform
import javax.vecmath.Color3f;
import java.awt.Color;
import com.sun.j3d.utils.geometry.*;
import javax.vecmath.*; // for Vector3f
import com.sun.j3d.utils.image.TextureLoader;

public class SnowManBody {
    public static Sphere getPart(float radius) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Sphere(radius,  primflags, getPartAppearence());
    }

    public static Cylinder getButton(float radius) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(radius, 0.05f, primflags, getButtonAppearence());
    }

    public static Cone getCarrot(float radius, float height) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cone(radius, height, primflags, getCarrotAppearence());
    }

    public static Cylinder getHat(float radius, float height) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(radius, height, primflags, getHatAppearence());
    }

    private static Appearance getPartAppearence() {
        TextureLoader loader = new TextureLoader("source_folder\\snow.jpg", "LUMINANCE", new
                Container());

        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(new Color(200,200, 200));
        Color3f diffuse = new Color3f();
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    private static Appearance getCarrotAppearence() {
        TextureLoader loader = new TextureLoader("source_folder\\carrot.jpg", "LUMINANCE", new
                Container());

        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(new Color(100,50, 50));
        Color3f diffuse = new Color3f();
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    private static Appearance getHatAppearence() {
        TextureLoader loader = new TextureLoader("source_folder\\hat.jpg", "LUMINANCE", new
                Container());

        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(new Color(200,100, 100));
        Color3f diffuse = new Color3f(Color.red);
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    private static Appearance getButtonAppearence() {
        TextureLoader loader = new TextureLoader("source_folder\\button.jpg", "LUMINANCE", new
                Container());

        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(new Color(0,0, 00));
        Color3f diffuse = new Color3f();
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }
}

