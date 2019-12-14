package com.base.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import com.base.engine.components.*;
import com.base.engine.core.*;
import com.base.engine.rendering.*;


public class TestGame extends Game
{
	private ArrayList<MeshRenderer> meshRendererObjects = new ArrayList<MeshRenderer>();
	private ArrayList<FreeMove> freeMoveObjects = new ArrayList<FreeMove>();
	private ArrayList<SpotLight> spotLightObjects = new ArrayList<SpotLight>();
	private ArrayList<MeshRenderer> meshRendererCollectableObjects = new ArrayList<MeshRenderer>();//25/11/19 - collectible coloured cubes
	private ArrayList<MeshRenderer> doors = new ArrayList<MeshRenderer>();
	private ArrayList<Material> doorMaterials = new ArrayList<Material>();
	
	ArrayList<MeshRenderer> collectableObjectsRoom1 = new ArrayList<MeshRenderer>();
	ArrayList<MeshRenderer> collectableObjectsRoom2 = new ArrayList<MeshRenderer>();
	ArrayList<MeshRenderer> collectableObjectsRoom3 = new ArrayList<MeshRenderer>();
	
	ArrayList<MeshRenderer> victoryObjects = new ArrayList<MeshRenderer>();
	
	String collectableFilePath = "powerup.wav";//music test
	String backgroundFilePath = "Soft-piano-music.wav";//music test
    
    public void init()
    {
        float fieldDepth = 10.0f;
        float fieldWidth = 10.0f;
        
        //MATERIALS
        Material materialGrey = new Material(); 
        materialGrey.addTexture("diffuse", new Texture("grey.png"));
        materialGrey.addFloat("specularIntensity", 1);
        materialGrey.addFloat("specularPower", 8);
        Material materialWhite = new Material();
        materialWhite.addTexture("diffuse", new Texture("white.jpg"));
        materialWhite.addFloat("specularIntensity", 1);
        materialWhite.addFloat("specularPower", 8);
        Material materialBlue = new Material();
        materialBlue.addTexture("diffuse", new Texture("blue.png"));
        materialBlue.addFloat("specularIntensity", 1);
        materialBlue.addFloat("specularPower", 8);
        doorMaterials.add(materialBlue);
        Material materialYellow = new Material();
        materialYellow.addTexture("diffuse", new Texture("yellow.jpg"));
        materialYellow.addFloat("specularIntensity", 1);
        materialYellow.addFloat("specularPower", 8);
        doorMaterials.add(materialYellow);
        Material materialGreen = new Material();
        materialGreen.addTexture("diffuse", new Texture("green.png"));
        materialGreen.addFloat("specularIntensity", 1);
        materialGreen.addFloat("specularPower", 8);
        doorMaterials.add(materialGreen);//RANDOM LOGIC TEST(29/11/19)
        Material materialRed = new Material();
        materialRed.addTexture("diffuse", new Texture("red.png"));
        materialRed.addFloat("specularIntensity", 1);
        materialRed.addFloat("specularPower", 8);
        doorMaterials.add(materialRed);
        Material materialOrange = new Material();
        materialOrange.addTexture("diffuse", new Texture("orange.jpg"));
        materialOrange.addFloat("specularIntensity", 1);
        materialOrange.addFloat("specularPower", 8);
        doorMaterials.add(materialOrange);//RANDOM LOGIC TEST(29/11/19)
        Material materialPurple = new Material();
        materialPurple.addTexture("diffuse", new Texture("purple.jpg"));
        materialPurple.addFloat("specularIntensity", 1);
        materialPurple.addFloat("specularPower", 8);
        doorMaterials.add(materialPurple);//RANDOM LOGIC TEST(29/11/19)
        Material materialCyan = new Material();
        materialCyan.addTexture("diffuse", new Texture("cyan.png"));
        materialCyan.addFloat("specularIntensity", 1);
        materialCyan.addFloat("specularPower", 8);
        doorMaterials.add(materialCyan);//RANDOM LOGIC TEST(29/11/19)
        Material materialVictory = new Material();
        materialVictory.addTexture("diffuse", new Texture("victoryMaterial.png"));
        materialVictory.addFloat("specularIntensity", 1);
        materialVictory.addFloat("specularPower", 8);
        
        //MESHES
        Mesh testMonkeyMesh = new Mesh("newMonkey.obj");
        
        //MESH_RENDERERS
        //Start room geometry
        MeshRenderer startRoomWallRight = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer startRoomWallLeft = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer startRoomWallBottom = new MeshRenderer(null, materialGrey, 10.0f, 0.25f, 10.0f);
        MeshRenderer startRoomWallTop = new MeshRenderer(null, materialGrey, 10.0f, 0.25f, 10.0f);
        MeshRenderer startRoomWallFront1 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer startRoomWallFront2 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer startRoomWallBack = new MeshRenderer(null, materialWhite, 10.0f, 3.0f, 0.25f);
        meshRendererObjects.add(startRoomWallRight);
        meshRendererObjects.add(startRoomWallLeft);
        meshRendererObjects.add(startRoomWallBottom);
        meshRendererObjects.add(startRoomWallTop);
        meshRendererObjects.add(startRoomWallFront1);
        meshRendererObjects.add(startRoomWallFront2);
        meshRendererObjects.add(startRoomWallBack);
        //Level 1 Geometry
        MeshRenderer levelOneWallRight = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelOneWallLeft = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelOneWallBottom = new MeshRenderer(null, materialGrey, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelOneWallTop = new MeshRenderer(null, materialGrey, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelOneWallFront1 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelOneWallFront2 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelOneWallBack1 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelOneWallBack2 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        meshRendererObjects.add(levelOneWallRight);
        meshRendererObjects.add(levelOneWallLeft);
        meshRendererObjects.add(levelOneWallBottom);
        meshRendererObjects.add(levelOneWallTop);
        meshRendererObjects.add(levelOneWallFront1);
        meshRendererObjects.add(levelOneWallFront2);
        meshRendererObjects.add(levelOneWallBack1);
        meshRendererObjects.add(levelOneWallBack2);
        //Level 2 Geometry
        MeshRenderer levelTwoWallRight = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelTwoWallLeft = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelTwoWallBottom = new MeshRenderer(null, materialGrey, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelTwoWallTop = new MeshRenderer(null, materialGrey, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelTwoWallFront1 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelTwoWallFront2 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelTwoWallBack1 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelTwoWallBack2 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        meshRendererObjects.add(levelTwoWallRight);
        meshRendererObjects.add(levelTwoWallLeft);
        meshRendererObjects.add(levelTwoWallBottom);
        meshRendererObjects.add(levelTwoWallTop);
        meshRendererObjects.add(levelTwoWallFront1);
        meshRendererObjects.add(levelTwoWallFront2);
        meshRendererObjects.add(levelTwoWallBack1);
        meshRendererObjects.add(levelTwoWallBack2);
        //Level 3 Geometry
        MeshRenderer levelThreeWallRight = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelThreeWallLeft = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelThreeWallBottom = new MeshRenderer(null, materialGrey, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelThreeWallTop = new MeshRenderer(null, materialGrey, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelThreeWallFront1 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelThreeWallFront2 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelThreeWallBack1 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelThreeWallBack2 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        meshRendererObjects.add(levelThreeWallRight);
        meshRendererObjects.add(levelThreeWallLeft);
        meshRendererObjects.add(levelThreeWallBottom);
        meshRendererObjects.add(levelThreeWallTop);
        meshRendererObjects.add(levelThreeWallFront1);
        meshRendererObjects.add(levelThreeWallFront2);
        meshRendererObjects.add(levelThreeWallBack1);
        meshRendererObjects.add(levelThreeWallBack2);
        //End Room Geometry
        MeshRenderer endRoomWallRight = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer endRoomWallLeft = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer endRoomWallBottom = new MeshRenderer(null, materialGrey, 10.0f, 0.25f, 10.0f);
        MeshRenderer endRoomWallTop = new MeshRenderer(null, materialGrey, 10.0f, 0.25f, 10.0f);
        MeshRenderer endRoomWallFront = new MeshRenderer(null, materialWhite, 10.0f, 3.0f, 0.25f);
        MeshRenderer endRoomWallBack1 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        MeshRenderer endRoomWallBack2 = new MeshRenderer(null, materialWhite, 5.0f, 3.0f, 0.25f);
        meshRendererObjects.add(endRoomWallRight);
        meshRendererObjects.add(endRoomWallLeft);
        meshRendererObjects.add(endRoomWallBottom);
        meshRendererObjects.add(endRoomWallTop);
        meshRendererObjects.add(endRoomWallFront);
        meshRendererObjects.add(endRoomWallBack1);
        meshRendererObjects.add(endRoomWallBack2);
        //Link Corridor 1
        MeshRenderer link1WallRight = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer link1WallLeft = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer link1WallBottom = new MeshRenderer(null, materialGrey, 3.0f, 0.25f, 10.0f);
        MeshRenderer link1WallTop = new MeshRenderer(null, materialGrey, 3.0f, 0.25f, 10.0f);
        //MeshRenderer link1WallFront = new MeshRenderer(null, materialCube, 3.0f, 3.0f, 0.25f);
        meshRendererObjects.add(link1WallRight);
        meshRendererObjects.add(link1WallLeft);
        meshRendererObjects.add(link1WallBottom);
        meshRendererObjects.add(link1WallTop);
        //meshRendererObjects.add(link1WallFront);
        //Link Corridor 2
        Random door1Rand = new Random();//RANDOM LOGIC TEST(29/11/19)
        Material door1Material = doorMaterials.get(door1Rand.nextInt(7));//RANDOM LOGIC TEST(29/11/19)
        MeshRenderer link2WallRight = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer link2WallLeft = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer link2WallBottom = new MeshRenderer(null, materialGrey, 3.0f, 0.25f, 10.0f);
        MeshRenderer link2WallTop = new MeshRenderer(null, materialGrey, 3.0f, 0.25f, 10.0f);
        MeshRenderer link2WallFront = new MeshRenderer(null, door1Material, 3.0f, 3.0f, 0.25f);//RANDOM LOGIC TEST(29/11/19)
        meshRendererObjects.add(link2WallRight);
        meshRendererObjects.add(link2WallLeft);
        meshRendererObjects.add(link2WallBottom);
        meshRendererObjects.add(link2WallTop);
        meshRendererObjects.add(link2WallFront);
        doors.add(link2WallFront);
        //Link Corridor 3
        doorMaterials.remove(doors.get(0).getMaterial());//RANDOM LOGIC TEST(29/11/19)
        Random door2Rand = new Random();//RANDOM LOGIC TEST(29/11/19)
        Material door2Material = doorMaterials.get(door2Rand.nextInt(6));//RANDOM LOGIC TEST(29/11/19)
        MeshRenderer link3WallRight = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer link3WallLeft = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer link3WallBottom = new MeshRenderer(null, materialGrey, 3.0f, 0.25f, 10.0f);
        MeshRenderer link3WallTop = new MeshRenderer(null, materialGrey, 3.0f, 0.25f, 10.0f);
        MeshRenderer link3WallFront = new MeshRenderer(null, door2Material, 3.0f, 3.0f, 0.25f);//RANDOM LOGIC TEST(29/11/19)
        meshRendererObjects.add(link3WallRight);
        meshRendererObjects.add(link3WallLeft);
        meshRendererObjects.add(link3WallBottom);
        meshRendererObjects.add(link3WallTop);
        meshRendererObjects.add(link3WallFront);
        doors.add(link3WallFront);
        //Link Corridor 4
        doorMaterials.remove(doors.get(1).getMaterial());//RANDOM LOGIC TEST(29/11/19)
        Random door3Rand = new Random();//RANDOM LOGIC TEST(29/11/19)
        Material door3Material = doorMaterials.get(door3Rand.nextInt(5));//RANDOM LOGIC TEST(29/11/19)
        MeshRenderer link4WallRight = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer link4WallLeft = new MeshRenderer(null, materialWhite, 0.25f, 3.0f, 10.0f);
        MeshRenderer link4WallBottom = new MeshRenderer(null, materialGrey, 3.0f, 0.25f, 10.0f);
        MeshRenderer link4WallTop = new MeshRenderer(null, materialGrey, 3.0f, 0.25f, 10.0f);
        MeshRenderer link4WallFront = new MeshRenderer(null, door3Material, 3.0f, 3.0f, 0.25f);
        meshRendererObjects.add(link4WallRight);
        meshRendererObjects.add(link4WallLeft);
        meshRendererObjects.add(link4WallBottom);
        meshRendererObjects.add(link4WallTop);
        meshRendererObjects.add(link4WallFront);
        doors.add(link4WallFront);
        //25/11/19 - collectible coloured cubes
        MeshRenderer collectableCubeBlue = new MeshRenderer(null, materialBlue, 1.0f, 1.0f, 1.0f);
        collectableCubeBlue.setColour("blue1");//29/11/19
        meshRendererCollectableObjects.add(collectableCubeBlue);
        MeshRenderer collectableCubeBlue2 = new MeshRenderer(null, materialBlue, 1.0f, 1.0f, 1.0f);
        collectableCubeBlue2.setColour("blue2");
        meshRendererCollectableObjects.add(collectableCubeBlue2);
        MeshRenderer collectableCubeBlue3 = new MeshRenderer(null, materialBlue, 1.0f, 1.0f, 1.0f);
        collectableCubeBlue3.setColour("blue3");
        meshRendererCollectableObjects.add(collectableCubeBlue3);
        MeshRenderer collectableCubeYellow = new MeshRenderer(null, materialYellow, 1.0f, 1.0f, 1.0f);
        collectableCubeYellow.setColour("yellow1");//29/11/19
        meshRendererCollectableObjects.add(collectableCubeYellow);
        MeshRenderer collectableCubeYellow2 = new MeshRenderer(null, materialYellow, 1.0f, 1.0f, 1.0f);
        collectableCubeYellow2.setColour("yellow2");
        meshRendererCollectableObjects.add(collectableCubeYellow2);
        MeshRenderer collectableCubeYellow3 = new MeshRenderer(null, materialYellow, 1.0f, 1.0f, 1.0f);
        collectableCubeYellow3.setColour("yellow3");
        meshRendererCollectableObjects.add(collectableCubeYellow3);
        MeshRenderer collectableCubeRed = new MeshRenderer(null, materialRed, 1.0f, 1.0f, 1.0f);
        collectableCubeRed.setColour("red1");
        meshRendererCollectableObjects.add(collectableCubeRed);
        MeshRenderer collectableCubeRed2 = new MeshRenderer(null, materialRed, 1.0f, 1.0f, 1.0f);
        collectableCubeRed2.setColour("red2");
        meshRendererCollectableObjects.add(collectableCubeRed2);
        MeshRenderer collectableCubeRed3 = new MeshRenderer(null, materialRed, 1.0f, 1.0f, 1.0f);
        collectableCubeRed3.setColour("red3");
        meshRendererCollectableObjects.add(collectableCubeRed3);
        MeshRenderer collectableCubePurple = new MeshRenderer(null, materialPurple, 1.0f, 1.0f, 1.0f);
        collectableCubePurple.setColour("purple1");
        meshRendererCollectableObjects.add(collectableCubePurple);
        MeshRenderer collectableCubePurple2 = new MeshRenderer(null, materialPurple, 1.0f, 1.0f, 1.0f);
        collectableCubePurple2.setColour("purple2");
        meshRendererCollectableObjects.add(collectableCubePurple2);
        MeshRenderer collectableCubePurple3 = new MeshRenderer(null, materialPurple, 1.0f, 1.0f, 1.0f);
        collectableCubePurple3.setColour("purple3");
        meshRendererCollectableObjects.add(collectableCubePurple3);
        MeshRenderer collectableCubeGreen = new MeshRenderer(null, materialGreen, 1.0f, 1.0f, 1.0f);
        collectableCubeGreen.setColour("green1");
        meshRendererCollectableObjects.add(collectableCubeGreen);
        MeshRenderer collectableCubeGreen2 = new MeshRenderer(null, materialGreen, 1.0f, 1.0f, 1.0f);
        collectableCubeGreen2.setColour("green2");
        meshRendererCollectableObjects.add(collectableCubeGreen2);
        MeshRenderer collectableCubeGreen3 = new MeshRenderer(null, materialGreen, 1.0f, 1.0f, 1.0f);
        collectableCubeGreen3.setColour("green3");
        meshRendererCollectableObjects.add(collectableCubeGreen3);
        MeshRenderer collectableCubeCyan = new MeshRenderer(null, materialCyan, 1.0f, 1.0f, 1.0f);
        collectableCubeCyan.setColour("cyan1");
        meshRendererCollectableObjects.add(collectableCubeCyan);
        MeshRenderer collectableCubeCyan2 = new MeshRenderer(null, materialCyan, 1.0f, 1.0f, 1.0f);
        collectableCubeCyan2.setColour("cyan2");
        meshRendererCollectableObjects.add(collectableCubeCyan2);
        MeshRenderer collectableCubeCyan3 = new MeshRenderer(null, materialCyan, 1.0f, 1.0f, 1.0f);
        collectableCubeCyan3.setColour("cyan3");
        meshRendererCollectableObjects.add(collectableCubeCyan3);
        
        for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {
			if (currentMeshRenderer.getColour().endsWith("1")) {
				collectableObjectsRoom1.add(currentMeshRenderer);
			}
		}
        for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {
			if (currentMeshRenderer.getColour().endsWith("2")) {
				collectableObjectsRoom2.add(currentMeshRenderer);
			}
		}
        for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {
			if (currentMeshRenderer.getColour().endsWith("3")) {
				collectableObjectsRoom3.add(currentMeshRenderer);
			}
		}
        
        MeshRenderer victoryCube = new MeshRenderer(null, materialVictory, 0.5f, 0.5f, 0.5f);
        victoryObjects.add(victoryCube);
        
        //GAME_OBJECTS
        
        //LIGHTING
         
        //Start Room Geometry
        GameObject startRoomWRight = new GameObject().addComponent(startRoomWallRight);
        startRoomWRight.getTransform().getPos().set(10, 3, 0);
        GameObject startRoomWLeft = new GameObject().addComponent(startRoomWallLeft);
        startRoomWLeft.getTransform().getPos().set(-10, 3, 0);
        GameObject startRoomWBottom = new GameObject().addComponent(startRoomWallBottom);
        startRoomWBottom.getTransform().getPos().set(0, 0, 0);
        GameObject startRoomWTop = new GameObject().addComponent(startRoomWallTop);
        startRoomWTop.getTransform().getPos().set(0, 6, 0);
        GameObject startRoomWFront1 = new GameObject().addComponent(startRoomWallFront1);
        startRoomWFront1.getTransform().getPos().set(8, 3, 10);
        GameObject startRoomWFront2 = new GameObject().addComponent(startRoomWallFront2);
        startRoomWFront2.getTransform().getPos().set(-8, 3, 10);
        GameObject startRoomWBack = new GameObject().addComponent(startRoomWallBack);
        startRoomWBack.getTransform().getPos().set(0, 3, -10);
        //Level 1 Geometry
        GameObject levelOneWRight = new GameObject().addComponent(levelOneWallRight);
        levelOneWRight.getTransform().getPos().set(10, 3, 40);
        GameObject levelOneWLeft = new GameObject().addComponent(levelOneWallLeft);
        levelOneWLeft.getTransform().getPos().set(-10, 3, 40);
        GameObject levelOneWBottom = new GameObject().addComponent(levelOneWallBottom);
        levelOneWBottom.getTransform().getPos().set(0, 0, 40);
        GameObject levelOneWTop = new GameObject().addComponent(levelOneWallTop);
        levelOneWTop.getTransform().getPos().set(0, 6, 40);
        GameObject levelOneWFront1 = new GameObject().addComponent(levelOneWallFront1);
        levelOneWFront1.getTransform().getPos().set(8, 3, 50);
        GameObject levelOneWFront2 = new GameObject().addComponent(levelOneWallFront2);
        levelOneWFront2.getTransform().getPos().set(-8, 3, 50);
        GameObject levelOneWBack1 = new GameObject().addComponent(levelOneWallBack1);
        levelOneWBack1.getTransform().getPos().set(8, 3, 30);
        GameObject levelOneWBack2 = new GameObject().addComponent(levelOneWallBack2);
        levelOneWBack2.getTransform().getPos().set(-8, 3, 30);
        //Level 2 Geometry
        GameObject levelTwoWRight = new GameObject().addComponent(levelTwoWallRight);
        levelTwoWRight.getTransform().getPos().set(10, 3, 80);
        GameObject levelTwoWLeft = new GameObject().addComponent(levelTwoWallLeft);
        levelTwoWLeft.getTransform().getPos().set(-10, 3, 80);
        GameObject levelTwoWBottom = new GameObject().addComponent(levelTwoWallBottom);
        levelTwoWBottom.getTransform().getPos().set(0, 0, 80);
        GameObject levelTwoWTop = new GameObject().addComponent(levelTwoWallTop);
        levelTwoWTop.getTransform().getPos().set(0, 6, 80);
        GameObject levelTwoWFront1 = new GameObject().addComponent(levelTwoWallFront1);
        levelTwoWFront1.getTransform().getPos().set(8, 3, 90);
        GameObject levelTwoWFront2 = new GameObject().addComponent(levelTwoWallFront2);
        levelTwoWFront2.getTransform().getPos().set(-8, 3, 90);
        GameObject levelTwoWBack1 = new GameObject().addComponent(levelTwoWallBack1);
        levelTwoWBack1.getTransform().getPos().set(8, 3, 70);
        GameObject levelTwoWBack2 = new GameObject().addComponent(levelTwoWallBack2);
        levelTwoWBack2.getTransform().getPos().set(-8, 3, 70);
        //Level 3 Geometry
        GameObject levelThreeWRight = new GameObject().addComponent(levelThreeWallRight);
        levelThreeWRight.getTransform().getPos().set(10, 3, 120);
        GameObject levelThreeWLeft = new GameObject().addComponent(levelThreeWallLeft);
        levelThreeWLeft.getTransform().getPos().set(-10, 3, 120);
        GameObject levelThreeWBottom = new GameObject().addComponent(levelThreeWallBottom);
        levelThreeWBottom.getTransform().getPos().set(0, 0, 120);
        GameObject levelThreeWTop = new GameObject().addComponent(levelThreeWallTop);
        levelThreeWTop.getTransform().getPos().set(0, 6, 120);
        GameObject levelThreeWFront1 = new GameObject().addComponent(levelThreeWallFront1);
        levelThreeWFront1.getTransform().getPos().set(8, 3, 130);
        GameObject levelThreeWFront2 = new GameObject().addComponent(levelThreeWallFront2);
        levelThreeWFront2.getTransform().getPos().set(-8, 3, 130);
        GameObject levelThreeWBack1 = new GameObject().addComponent(levelThreeWallBack1);
        levelThreeWBack1.getTransform().getPos().set(8, 3, 110);
        GameObject levelThreeWBack2 = new GameObject().addComponent(levelThreeWallBack2);
        levelThreeWBack2.getTransform().getPos().set(-8, 3, 110);
        //End Room geometry
        GameObject endRoomWRight = new GameObject().addComponent(endRoomWallRight);
        endRoomWRight.getTransform().getPos().set(10, 3, 160);
        GameObject endRoomWLeft = new GameObject().addComponent(endRoomWallLeft);
        endRoomWLeft.getTransform().getPos().set(-10, 3, 160);
        GameObject endRoomWBottom = new GameObject().addComponent(endRoomWallBottom);
        endRoomWBottom.getTransform().getPos().set(0, 0, 160);
        GameObject endRoomWTop = new GameObject().addComponent(endRoomWallTop);
        endRoomWTop.getTransform().getPos().set(0, 6, 160);
        GameObject endRoomWFront = new GameObject().addComponent(endRoomWallFront);
        endRoomWFront.getTransform().getPos().set(0, 3, 170);
        GameObject endRoomWBack1 = new GameObject().addComponent(endRoomWallBack1);
        endRoomWBack1.getTransform().getPos().set(8, 3, 150);
        GameObject endRoomWBack2 = new GameObject().addComponent(endRoomWallBack2);
        endRoomWBack2.getTransform().getPos().set(-8, 3, 150);
        //Link Corridor 1 geometry
        GameObject link1WRight = new GameObject().addComponent(link1WallRight);
        link1WRight.getTransform().getPos().set(3, 3, 20);
        GameObject link1WLeft = new GameObject().addComponent(link1WallLeft);
        link1WLeft.getTransform().getPos().set(-3, 3, 20);
        GameObject link1WBottom = new GameObject().addComponent(link1WallBottom);
        link1WBottom.getTransform().getPos().set(0, 0, 20);
        GameObject link1WTop = new GameObject().addComponent(link1WallTop);
        link1WTop.getTransform().getPos().set(0, 6, 20);
        //GameObject link1WFront = new GameObject().addComponent(link1WallFront);
        //link1WFront.getTransform().getPos().set(0, 3, 10);
        //Link Corridor 2 geometry
        GameObject link2WRight = new GameObject().addComponent(link2WallRight);
        link2WRight.getTransform().getPos().set(3, 3, 60);
        GameObject link2WLeft = new GameObject().addComponent(link2WallLeft);
        link2WLeft.getTransform().getPos().set(-3, 3, 60);
        GameObject link2WBottom = new GameObject().addComponent(link2WallBottom);
        link2WBottom.getTransform().getPos().set(0, 0, 60);
        GameObject link2WTop = new GameObject().addComponent(link2WallTop);
        link2WTop.getTransform().getPos().set(0, 6, 60);
        GameObject link2WFront = new GameObject().addComponent(link2WallFront);
        link2WFront.getTransform().getPos().set(0, 3, 50);
        //Link Corridor 3 geometry
        GameObject link3WRight = new GameObject().addComponent(link3WallRight);
        link3WRight.getTransform().getPos().set(3, 3, 100);
        GameObject link3WLeft = new GameObject().addComponent(link3WallLeft);
        link3WLeft.getTransform().getPos().set(-3, 3, 100);
        GameObject link3WBottom = new GameObject().addComponent(link3WallBottom);
        link3WBottom.getTransform().getPos().set(0, 0, 100);
        GameObject link3WTop = new GameObject().addComponent(link3WallTop);
        link3WTop.getTransform().getPos().set(0, 6, 100);
        GameObject link3WFront = new GameObject().addComponent(link3WallFront);
        link3WFront.getTransform().getPos().set(0, 3, 90);
        //Link Corridor 4 geometry
        GameObject link4WRight = new GameObject().addComponent(link4WallRight);
        link4WRight.getTransform().getPos().set(3, 3, 140);
        GameObject link4WLeft = new GameObject().addComponent(link4WallLeft);
        link4WLeft.getTransform().getPos().set(-3, 3, 140);
        GameObject link4WBottom = new GameObject().addComponent(link4WallBottom);
        link4WBottom.getTransform().getPos().set(0, 0, 140);
        GameObject link4WTop = new GameObject().addComponent(link4WallTop);
        link4WTop.getTransform().getPos().set(0, 6, 140);
        GameObject link4WFront = new GameObject().addComponent(link4WallFront);
        link4WFront.getTransform().getPos().set(0, 3, 130);
        //25/11/19 - collectible coloured cubes
        //ROOM 1
        GameObject collectableCube1 = new GameObject().addComponent(collectableCubeBlue);
        collectableCube1.getTransform().getPos().set(-6, 3, 45);
        GameObject collectableCube2 = new GameObject().addComponent(collectableCubeYellow);
        collectableCube2.getTransform().getPos().set(6, 3, 45);
        GameObject collectableCube3 = new GameObject().addComponent(collectableCubeRed);
        collectableCube3.getTransform().getPos().set(-6, 3, 40);
        GameObject collectableCube4 = new GameObject().addComponent(collectableCubeCyan);
        collectableCube4.getTransform().getPos().set(6, 3, 40);
        GameObject collectableCube5 = new GameObject().addComponent(collectableCubePurple);
        collectableCube5.getTransform().getPos().set(-6, 3, 35);
        GameObject collectableCube6 = new GameObject().addComponent(collectableCubeGreen);
        collectableCube6.getTransform().getPos().set(6, 3, 35);
        //ROOM 2
        GameObject collectableCube7 = new GameObject().addComponent(collectableCubeBlue2);
        collectableCube7.getTransform().getPos().set(6, 3, 85);
        GameObject collectableCube8 = new GameObject().addComponent(collectableCubeYellow2);
        collectableCube8.getTransform().getPos().set(-6, 3, 85);
        GameObject collectableCube9 = new GameObject().addComponent(collectableCubeRed2);
        collectableCube9.getTransform().getPos().set(6, 3, 80);
        GameObject collectableCube10 = new GameObject().addComponent(collectableCubeCyan2);
        collectableCube10.getTransform().getPos().set(-6, 3, 80);
        GameObject collectableCube11 = new GameObject().addComponent(collectableCubePurple2);
        collectableCube11.getTransform().getPos().set(6, 3, 75);
        GameObject collectableCube12 = new GameObject().addComponent(collectableCubeGreen2);
        collectableCube12.getTransform().getPos().set(-6, 3, 75);
        //ROOM 3
        GameObject collectableCube13 = new GameObject().addComponent(collectableCubeBlue3);
        collectableCube13.getTransform().getPos().set(6, 3, 125);
        GameObject collectableCube14 = new GameObject().addComponent(collectableCubeYellow3);
        collectableCube14.getTransform().getPos().set(6, 3, 120);
        GameObject collectableCube15 = new GameObject().addComponent(collectableCubeRed3);
        collectableCube15.getTransform().getPos().set(-6, 3, 125);
        GameObject collectableCube16 = new GameObject().addComponent(collectableCubeCyan3);
        collectableCube16.getTransform().getPos().set(-6, 3, 120);
        GameObject collectableCube17 = new GameObject().addComponent(collectableCubePurple3);
        collectableCube17.getTransform().getPos().set(6, 3, 115);
        GameObject collectableCube18 = new GameObject().addComponent(collectableCubeGreen3);
        collectableCube18.getTransform().getPos().set(-6, 3, 115);
        
        GameObject victoryObject = new GameObject().addComponent(victoryCube);
        victoryObject.getTransform().getPos().set(0, 3, 160);
        victoryObject.addComponent(new LookAtComponent());
         
        GameObject player = new GameObject();
        FreeMove playerMovement = new FreeMove(10.0f);
        freeMoveObjects.add(playerMovement);
        player.getTransform().getPos().set(0, 3, -5);
        player.addComponent(new FreeLook(0.5f));
        player.addComponent(playerMovement);
        player.addComponent(new Camera((float)Math.toRadians(70.0f), (float)Window.getWidth()/(float)Window.getHeight(), 0.01f, 1000.0f));
        
        GameObject spotLightObject = new GameObject();
        SpotLight spotLight =  new SpotLight(new Vector3f(1,1,1), 0.1f, new Attenuation(0,0,0.1f), 0.7f);
        spotLightObjects.add(spotLight);
        spotLightObject.addComponent(spotLight);
        spotLightObject.getTransform().getPos().set(5,5,0);//13/11/19
         
        //Start room geometry
        addObject(startRoomWRight);
        addObject(startRoomWLeft);
        addObject(startRoomWBottom);
        addObject(startRoomWTop);
        addObject(startRoomWFront1);
        addObject(startRoomWFront2);
        addObject(startRoomWBack);
        //Level 1 geometry
        addObject(levelOneWRight);
        addObject(levelOneWLeft);
        addObject(levelOneWBottom);
        addObject(levelOneWTop);
        addObject(levelOneWFront1);
        addObject(levelOneWFront2);
        addObject(levelOneWBack1);
        addObject(levelOneWBack2);
        //Level 2 geometry
        addObject(levelTwoWRight);
        addObject(levelTwoWLeft);
        addObject(levelTwoWBottom);
        addObject(levelTwoWTop);
        addObject(levelTwoWFront1);
        addObject(levelTwoWFront2);
        addObject(levelTwoWBack1);
        addObject(levelTwoWBack2);
        //Level 3 geometry
        addObject(levelThreeWRight);
        addObject(levelThreeWLeft);
        addObject(levelThreeWBottom);
        addObject(levelThreeWTop);
        addObject(levelThreeWFront1);
        addObject(levelThreeWFront2);
        addObject(levelThreeWBack1);
        addObject(levelThreeWBack2);
        //End Room geometry
        addObject(endRoomWRight);
        addObject(endRoomWLeft);
        addObject(endRoomWBottom);
        addObject(endRoomWTop);
        addObject(endRoomWFront);
        addObject(endRoomWBack1);
        addObject(endRoomWBack2);
        //Link Corridor 1 geometry
        addObject(link1WRight);
        addObject(link1WLeft);
        addObject(link1WBottom);
        addObject(link1WTop);
        //addObject(link1WFront);
        //Link Corridor 2 geometry
        addObject(link2WRight);
        addObject(link2WLeft);
        addObject(link2WBottom);
        addObject(link2WTop);
        addObject(link2WFront);
        //Link Corridor 3 geometry
        addObject(link3WRight);
        addObject(link3WLeft);
        addObject(link3WBottom);
        addObject(link3WTop);
        addObject(link3WFront);
        //Link Corridor 4 geometry
        addObject(link4WRight);
        addObject(link4WLeft);
        addObject(link4WBottom);
        addObject(link4WTop);
        addObject(link4WFront);
        //25/11/19 - collectible coloured cubes
        addObject(collectableCube1);
        addObject(collectableCube2);
        addObject(collectableCube3);
        addObject(collectableCube4);
        addObject(collectableCube5);
        addObject(collectableCube6);
        addObject(collectableCube7);
        addObject(collectableCube8);
        addObject(collectableCube9);
        addObject(collectableCube10);
        addObject(collectableCube11);
        addObject(collectableCube12);
        addObject(collectableCube13);
        addObject(collectableCube14);
        addObject(collectableCube15);
        addObject(collectableCube16);
        addObject(collectableCube17);
        addObject(collectableCube18);
        addObject(player);
        addObject(victoryObject);
        
        playBackgroundMusic(backgroundFilePath, 0.5f);//music test
    }
    
    
    public void checkCollision() {
    	for(MeshRenderer currentMeshRenderer: meshRendererObjects) {
    		Vector3f testMeshPos = currentMeshRenderer.getParent().getTransform().getPos();
    		Vector3f testMeshScale = currentMeshRenderer.getScaleAttrib();//new Vector3f(2.0f, 2.0f, 2.0f);
    		Vector3f testPlayerPos = freeMoveObjects.get(0).getParent().getTransform().getPos();
    		Vector3f testPlayerScale = new Vector3f(1.0f, 1.0f, 1.0f);
    	
    		Vector3f tmp = new Vector3f(testPlayerPos.getX(), testPlayerPos.getY() - 1.0f, testPlayerPos.getZ());
    		//check the X axis
    		if (Math.abs(tmp.getX() - testMeshPos.getX()) < testPlayerScale.getX() + (testMeshScale.getX()) / 1.0) {
    			//check the Y axis
    			if (Math.abs(tmp.getY() - testMeshPos.getY()) < testPlayerScale.getY() + (testMeshScale.getY()) / 1.0) {
    				//check the Z axis
    				if (Math.abs(tmp.getZ() - testMeshPos.getZ()) < testPlayerScale.getZ() + (testMeshScale.getZ()) / 1.0) {
    					freeMoveObjects.get(0).getParent().getTransform().setPos(freeMoveObjects.get(0).getOldPos());
    				}
    			}
    		}
    	}
	}
    
    public void checkCollisionForCollectables() {//25/11/19 - collectible coloured cubes
    	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {
    		Vector3f testMeshPos = currentMeshRenderer.getParent().getTransform().getPos();
    		Vector3f testMeshScale = currentMeshRenderer.getScaleAttrib();//new Vector3f(2.0f, 2.0f, 2.0f);
    		Vector3f testPlayerPos = freeMoveObjects.get(0).getParent().getTransform().getPos();
    		Vector3f testPlayerScale = new Vector3f(1.0f, 1.0f, 1.0f);
    	
    		Vector3f tmp = new Vector3f(testPlayerPos.getX(), testPlayerPos.getY() - 1.0f, testPlayerPos.getZ());
    		//check the X axis
    		if (Math.abs(tmp.getX() - testMeshPos.getX()) < testPlayerScale.getX() + (testMeshScale.getX()) / 1.0) {
    			//check the Y axis
    			if (Math.abs(tmp.getY() - testMeshPos.getY()) < testPlayerScale.getY() + (testMeshScale.getY()) / 1.0) {
    				//check the Z axis
    				if (Math.abs(tmp.getZ() - testMeshPos.getZ()) < testPlayerScale.getZ() + (testMeshScale.getZ()) / 1.0) {
    					if(currentMeshRenderer.getCollected() == false) {
    						playCollectableMusic(collectableFilePath, 0.8f);//music test
    					}
    					currentMeshRenderer.setCollected(true);
    					
    				}
    			}
    		}
    	}
	}
    
    public void checkCollisionForVictoryObject() {//25/11/19 - collectible coloured cubes
    	for(MeshRenderer currentVictoryObject: victoryObjects) {
    		Vector3f testMeshPos = currentVictoryObject.getParent().getTransform().getPos();
    		Vector3f testMeshScale = currentVictoryObject.getScaleAttrib();//new Vector3f(2.0f, 2.0f, 2.0f);
    		Vector3f testPlayerPos = freeMoveObjects.get(0).getParent().getTransform().getPos();
    		Vector3f testPlayerScale = new Vector3f(1.0f, 1.0f, 1.0f);
    	
    		Vector3f tmp = new Vector3f(testPlayerPos.getX(), testPlayerPos.getY() - 1.0f, testPlayerPos.getZ());
    		//check the X axis
    		if (Math.abs(tmp.getX() - testMeshPos.getX()) < testPlayerScale.getX() + (testMeshScale.getX()) / 1.0) {
    			//check the Y axis
    			if (Math.abs(tmp.getY() - testMeshPos.getY()) < testPlayerScale.getY() + (testMeshScale.getY()) / 1.0) {
    				//check the Z axis
    				if (Math.abs(tmp.getZ() - testMeshPos.getZ()) < testPlayerScale.getZ() + (testMeshScale.getZ()) / 1.0) {
    					System.exit(0);//getRootObject().getEngine().getGame().init();//this.init();//System.out.println("RESTART");//init();
    				}
    			}
    		}
    	}
	}
    
    public void updateSpotLight()//13/11/19
    {
    	spotLightObjects.get(0).getParent().getTransform().setPos(freeMoveObjects.get(0).getNewPos());
    	spotLightObjects.get(0).getParent().getTransform().setRot(freeMoveObjects.get(0).getTransform().getRot());
    }
    
    public void moveDoor()//13/11/19
    {
    	//DOOR 1
    	int numCollectedForFirstDoor = 0;
    	boolean door1GreenMoved = false;
    	int collectedRoom1 = 0;
    	if(doors.get(0).getMaterial().getFileName() == "green.png") {
    	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
    		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
    		if(colourOfCurrentCollectable.equals("cyan1")) {
    			if(currentMeshRenderer.getCollected() == true) {
    				numCollectedForFirstDoor++;
    			}
    		}
    	}
    	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
    		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
    		if(colourOfCurrentCollectable.equals("yellow1")) {
    			if(currentMeshRenderer.getCollected() == true) {
    				numCollectedForFirstDoor++;
    			}
    		}
    	}
    	if(numCollectedForFirstDoor == 2) {
    		Vector3f oldDoorPosition = doors.get(0).getParent().getTransform().getPos();
			doors.get(0).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
			door1GreenMoved = true;
    	}
    	if(!door1GreenMoved) {
    		for(MeshRenderer currentCollectableRoom1: collectableObjectsRoom1) {
    			if(currentCollectableRoom1.getCollected() == true)
    				collectedRoom1++;
    		}
    		if(collectedRoom1 >=2)
    			System.exit(0);	
    	}
    	}
    	boolean door1PurpleMoved = false;
    	if(doors.get(0).getMaterial().getFileName() == "purple.jpg") {
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("red1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("blue1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	if(numCollectedForFirstDoor == 2) {
        		Vector3f oldDoorPosition = doors.get(0).getParent().getTransform().getPos();
    			doors.get(0).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
    			door1PurpleMoved = true;
        	}
        	if(!door1PurpleMoved) {
        		for(MeshRenderer currentCollectableRoom1: collectableObjectsRoom1) {
        			if(currentCollectableRoom1.getCollected() == true)
        				collectedRoom1++;
        		}
        		if(collectedRoom1 >=2)
        			System.exit(0);	
        	}
        	}
    	boolean door1OrangeMoved = false;
    	if(doors.get(0).getMaterial().getFileName() == "orange.jpg") {
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("yellow1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("red1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	if(numCollectedForFirstDoor == 2) {
        		Vector3f oldDoorPosition = doors.get(0).getParent().getTransform().getPos();
    			doors.get(0).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
    			door1OrangeMoved = true;
        	}
        	if(!door1OrangeMoved) {
        		for(MeshRenderer currentCollectableRoom1: collectableObjectsRoom1) {
        			if(currentCollectableRoom1.getCollected() == true)
        				collectedRoom1++;
        		}
        		if(collectedRoom1 >=2)
        			System.exit(0);	
        	}
        	}
    	boolean door1RedMoved = false;
    	if(doors.get(0).getMaterial().getFileName() == "red.png") {
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("yellow1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("purple1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	if(numCollectedForFirstDoor == 2) {
        		Vector3f oldDoorPosition = doors.get(0).getParent().getTransform().getPos();
    			doors.get(0).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
    			door1RedMoved = true;
        	}
        	if(!door1RedMoved) {
        		for(MeshRenderer currentCollectableRoom1: collectableObjectsRoom1) {
        			if(currentCollectableRoom1.getCollected() == true)
        				collectedRoom1++;
        		}
        		if(collectedRoom1 >=2)
        			System.exit(0);	
        	}
        	}
    	boolean door1BlueMoved = false;
    	if(doors.get(0).getMaterial().getFileName() == "blue.png") {
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("cyan1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("purple1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	if(numCollectedForFirstDoor == 2) {
        		Vector3f oldDoorPosition = doors.get(0).getParent().getTransform().getPos();
    			doors.get(0).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
    			door1BlueMoved = true;
        	}
        	if(!door1BlueMoved) {
        		for(MeshRenderer currentCollectableRoom1: collectableObjectsRoom1) {
        			if(currentCollectableRoom1.getCollected() == true)
        				collectedRoom1++;
        		}
        		if(collectedRoom1 >=2)
        			System.exit(0);	
        	}
        	}
    	boolean door1YellowMoved = false;
    	if(doors.get(0).getMaterial().getFileName() == "yellow.jpg") {
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("red1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("green1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	if(numCollectedForFirstDoor == 2) {
        		Vector3f oldDoorPosition = doors.get(0).getParent().getTransform().getPos();
    			doors.get(0).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
    			door1YellowMoved = true;
        	}
        	if(!door1YellowMoved) {
        		for(MeshRenderer currentCollectableRoom1: collectableObjectsRoom1) {
        			if(currentCollectableRoom1.getCollected() == true)
        				collectedRoom1++;
        		}
        		if(collectedRoom1 >=2)
        			System.exit(0);	
        	}
        	}
    	boolean door1CyanMoved = false;
    	if(doors.get(0).getMaterial().getFileName() == "cyan.png") {
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("green1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("blue1")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForFirstDoor++;
        			}
        		}
        	}
        	if(numCollectedForFirstDoor == 2) {
        		Vector3f oldDoorPosition = doors.get(0).getParent().getTransform().getPos();
    			doors.get(0).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
    			door1CyanMoved = true;
        	}
        	if(!door1CyanMoved) {
        		for(MeshRenderer currentCollectableRoom1: collectableObjectsRoom1) {
        			if(currentCollectableRoom1.getCollected() == true)
        				collectedRoom1++;
        		}
        		if(collectedRoom1 >=2)
        			System.exit(0);	
        	}
        	}
    	
    	//DOOR 2
    	boolean door2GreenMoved = false;
    	int collectedRoom2 = 0;
    	int numCollectedForSeccondDoor = 0;
    	if(doors.get(1).getMaterial().getFileName() == "green.png") {
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("cyan2")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForSeccondDoor++;
        			}
        		}
        	}
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("yellow2")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForSeccondDoor++;
        			}
        		}
        	}
        	if(numCollectedForSeccondDoor == 2) {
        		Vector3f oldDoorPosition = doors.get(1).getParent().getTransform().getPos();
    			doors.get(1).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
    			door2GreenMoved = true;
        	}
        	if(!door2GreenMoved) {
        		for(MeshRenderer currentCollectableRoom2: collectableObjectsRoom2) {
        			if(currentCollectableRoom2.getCollected() == true)
        				collectedRoom2++;
        		}
        		if(collectedRoom2 >=2)
        			System.exit(0);	
        	}
        	}
    	    boolean door2PurpleMoved = false;
        	if(doors.get(1).getMaterial().getFileName() == "purple.jpg") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("red2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("blue2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	if(numCollectedForSeccondDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(1).getParent().getTransform().getPos();
        			doors.get(1).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door2PurpleMoved = true;
            	}
            	if(!door2PurpleMoved) {
            		for(MeshRenderer currentCollectableRoom2: collectableObjectsRoom2) {
            			if(currentCollectableRoom2.getCollected() == true)
            				collectedRoom2++;
            		}
            		if(collectedRoom2 >=2)
            			System.exit(0);	
            	}
            	}
        	boolean door2OrangeMoved = false;
        	if(doors.get(1).getMaterial().getFileName() == "orange.jpg") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("yellow2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("red2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	if(numCollectedForSeccondDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(1).getParent().getTransform().getPos();
        			doors.get(1).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door2OrangeMoved = true;
            	}
            	if(!door2OrangeMoved) {
            		for(MeshRenderer currentCollectableRoom2: collectableObjectsRoom2) {
            			if(currentCollectableRoom2.getCollected() == true)
            				collectedRoom2++;
            		}
            		if(collectedRoom2 >=2)
            			System.exit(0);	
            	}
            	}
        	boolean door2RedMoved = false;
        	if(doors.get(1).getMaterial().getFileName() == "red.png") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("yellow2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("purple2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	if(numCollectedForSeccondDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(1).getParent().getTransform().getPos();
        			doors.get(1).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door2RedMoved = true;
            	}
            	if(!door2RedMoved) {
            		for(MeshRenderer currentCollectableRoom2: collectableObjectsRoom2) {
            			if(currentCollectableRoom2.getCollected() == true)
            				collectedRoom2++;
            		}
            		if(collectedRoom2 >=2)
            			System.exit(0);	
            	}
            	}
        	boolean door2BlueMoved = false;
        	if(doors.get(1).getMaterial().getFileName() == "blue.png") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("cyan2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("purple2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	if(numCollectedForSeccondDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(1).getParent().getTransform().getPos();
        			doors.get(1).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door2BlueMoved = true;
            	}
            	if(!door2BlueMoved) {
            		for(MeshRenderer currentCollectableRoom2: collectableObjectsRoom2) {
            			if(currentCollectableRoom2.getCollected() == true)
            				collectedRoom2++;
            		}
            		if(collectedRoom2 >=2)
            			System.exit(0);	
            	}
            	}
        	boolean door2YellowMoved = false;
        	if(doors.get(1).getMaterial().getFileName() == "yellow.jpg") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("red2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("green2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	if(numCollectedForSeccondDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(1).getParent().getTransform().getPos();
        			doors.get(1).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door2YellowMoved = true;
            	}
            	if(!door2YellowMoved) {
            		for(MeshRenderer currentCollectableRoom2: collectableObjectsRoom2) {
            			if(currentCollectableRoom2.getCollected() == true)
            				collectedRoom2++;
            		}
            		if(collectedRoom2 >=2)
            			System.exit(0);	
            	}
            	}
        	boolean door2CyanMoved = false;
        	if(doors.get(1).getMaterial().getFileName() == "cyan.png") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("green2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("blue2")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForSeccondDoor++;
            			}
            		}
            	}
            	if(numCollectedForSeccondDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(1).getParent().getTransform().getPos();
        			doors.get(1).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door2CyanMoved = true;
            	}
            	if(!door2CyanMoved) {
            		for(MeshRenderer currentCollectableRoom2: collectableObjectsRoom2) {
            			if(currentCollectableRoom2.getCollected() == true)
            				collectedRoom2++;
            		}
            		if(collectedRoom2 >=2)
            			System.exit(0);	
            	}
            	}
            	
        	
    	//DOOR 3
        boolean door3GreenMoved = false;
        int collectedRoom3 = 0;
    	int numCollectedForThirdDoor = 0;
    	if(doors.get(2).getMaterial().getFileName() == "green.png") {
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("cyan3")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForThirdDoor++;
        			}
        		}
        	}
        	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
        		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
        		if(colourOfCurrentCollectable.equals("yellow3")) {
        			if(currentMeshRenderer.getCollected() == true) {
        				numCollectedForThirdDoor++;
        			}
        		}
        	}
        	if(numCollectedForThirdDoor == 2) {
        		Vector3f oldDoorPosition = doors.get(2).getParent().getTransform().getPos();
    			doors.get(2).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
    			door3GreenMoved = true;
        	}
        	if(!door3GreenMoved) {
        		for(MeshRenderer currentCollectableRoom3: collectableObjectsRoom3) {
        			if(currentCollectableRoom3.getCollected() == true)
        				collectedRoom3++;
        		}
        		System.out.println(collectedRoom3);
        		if(collectedRoom3 >=2)
        			System.exit(0);	
        	}
        	}
    	    boolean door3PurpleMoved = false;
        	if(doors.get(2).getMaterial().getFileName() == "purple.jpg") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("red3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("blue3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	if(numCollectedForThirdDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(2).getParent().getTransform().getPos();
        			doors.get(2).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door3PurpleMoved = true;
            	}
            	if(!door3PurpleMoved) {
            		for(MeshRenderer currentCollectableRoom3: collectableObjectsRoom3) {
            			if(currentCollectableRoom3.getCollected() == true)
            				collectedRoom3++;
            		}
            		System.out.println(collectedRoom3);
            		if(collectedRoom3 >=2)
            			System.exit(0);	
            	}
            	}
        	boolean door3OrangeMoved = false;
        	if(doors.get(2).getMaterial().getFileName() == "orange.jpg") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("yellow3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("red3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	if(numCollectedForThirdDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(2).getParent().getTransform().getPos();
        			doors.get(2).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door3OrangeMoved = true;
            	}
            	if(!door3OrangeMoved) {
            		for(MeshRenderer currentCollectableRoom3: collectableObjectsRoom3) {
            			if(currentCollectableRoom3.getCollected() == true)
            				collectedRoom3++;
            		}
            		System.out.println(collectedRoom3);
            		if(collectedRoom3 >=2)
            			System.exit(0);	
            	}
            	}
        	boolean door3RedMoved = false;
        	if(doors.get(2).getMaterial().getFileName() == "red.png") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("yellow3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("purple3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	if(numCollectedForThirdDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(2).getParent().getTransform().getPos();
        			doors.get(2).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door3RedMoved = true;
            	}
            	if(!door3RedMoved) {
            		for(MeshRenderer currentCollectableRoom3: collectableObjectsRoom3) {
            			if(currentCollectableRoom3.getCollected() == true)
            				collectedRoom3++;
            		}
            		System.out.println(collectedRoom3);
            		if(collectedRoom3 >=2)
            			System.exit(0);	
            	}
            	}
        	boolean door3BlueMoved = false;
        	if(doors.get(2).getMaterial().getFileName() == "blue.png") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("cyan3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("purple3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	if(numCollectedForThirdDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(2).getParent().getTransform().getPos();
        			doors.get(2).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door3BlueMoved = true;
            	}
            	if(!door3BlueMoved) {
            		for(MeshRenderer currentCollectableRoom3: collectableObjectsRoom3) {
            			if(currentCollectableRoom3.getCollected() == true)
            				collectedRoom3++;
            		}
            		System.out.println(collectedRoom3);
            		if(collectedRoom3 >=2)
            			System.exit(0);	
            	}
            	}
        	boolean door3YellowMoved = false;
        	if(doors.get(2).getMaterial().getFileName() == "yellow.jpg") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("red3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("green3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	if(numCollectedForThirdDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(2).getParent().getTransform().getPos();
        			doors.get(2).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door3YellowMoved = true;
            	}
            	if(!door3YellowMoved) {
            		for(MeshRenderer currentCollectableRoom3: collectableObjectsRoom3) {
            			if(currentCollectableRoom3.getCollected() == true)
            				collectedRoom3++;
            		}
            		System.out.println(collectedRoom3);
            		if(collectedRoom3 >=2)
            			System.exit(0);	
            	}
            	}
        	boolean door3CyanMoved = false;
        	if(doors.get(2).getMaterial().getFileName() == "cyan.png") {
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("green3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	for(MeshRenderer currentMeshRenderer: meshRendererCollectableObjects) {//27/11/19
            		String colourOfCurrentCollectable = currentMeshRenderer.getColour();//29/11/19
            		if(colourOfCurrentCollectable.equals("blue3")) {
            			if(currentMeshRenderer.getCollected() == true) {
            				numCollectedForThirdDoor++;
            			}
            		}
            	}
            	if(numCollectedForThirdDoor == 2) {
            		Vector3f oldDoorPosition = doors.get(2).getParent().getTransform().getPos();
        			doors.get(2).getParent().getTransform().setPos(oldDoorPosition.add(new Vector3f(0.02f,0,0)));
        			door3CyanMoved = true;
            	}
            	if(!door3CyanMoved) {
            		for(MeshRenderer currentCollectableRoom3: collectableObjectsRoom3) {
            			if(currentCollectableRoom3.getCollected() == true)
            				collectedRoom3++;
            		}
            		System.out.println(collectedRoom3);
            		if(collectedRoom3 >=2)
            			System.exit(0);	
            	}
            	}
            	
    }
    
    public static void playCollectableMusic(String filePath, float volume)//music test
    {
    	try
    	{
    		File musicPath = new File(filePath);
    		if(musicPath.exists())
    		{
    			AudioInputStream audioinput = AudioSystem.getAudioInputStream(musicPath);
    			Clip clip = AudioSystem.getClip();
    			clip.open(audioinput);
    			if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
    				// set volume
    				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    				float range = gainControl.getMaximum() - gainControl.getMinimum();
    				float gain = (range * volume) + gainControl.getMinimum();
    				gainControl.setValue(gain);
    			}
    			clip.start();
    		}
    		else
    		{
    			System.out.println("cant find path");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void playBackgroundMusic(String filePath, float volume)//music test
    {
    	try
    	{
    		File musicPath = new File(filePath);
    		if(musicPath.exists())
    		{
    			AudioInputStream audioinput = AudioSystem.getAudioInputStream(musicPath);
    			Clip clip = AudioSystem.getClip();
    			clip.open(audioinput);
    			if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
    				// set volume
    				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    				float range = gainControl.getMaximum() - gainControl.getMinimum();
    				float gain = (range * volume) + gainControl.getMinimum();
    				gainControl.setValue(gain);
    			}
    			clip.start();
    			clip.loop(clip.LOOP_CONTINUOUSLY);
    		}
    		else
    		{
    			System.out.println("cant find path");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
