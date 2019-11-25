package com.base.game;

import java.util.ArrayList;

import com.base.engine.components.*;
import com.base.engine.core.*;
import com.base.engine.rendering.*;


public class TestGame extends Game
{
	private ArrayList<MeshRenderer> meshRendererObjects = new ArrayList<MeshRenderer>();
	private ArrayList<FreeMove> freeMoveObjects = new ArrayList<FreeMove>();
	private ArrayList<SpotLight> spotLightObjects = new ArrayList<SpotLight>();
	private ArrayList<MeshRenderer> meshRendererCollectableObjects = new ArrayList<MeshRenderer>();//25/11/19 - collectible coloured cubes
    
    public void init()
    {
        float fieldDepth = 10.0f;
        float fieldWidth = 10.0f;
        
        //MATERIALS
        Material materialCube = new Material(); 
        materialCube.addTexture("diffuse", new Texture("bricks.jpg"));
        materialCube.addFloat("specularIntensity", 1);
        materialCube.addFloat("specularPower", 8);
        Material materialTest = new Material();
        materialTest.addTexture("diffuse", new Texture("white.jpg"));
        materialTest.addFloat("specularIntensity", 1);
        materialTest.addFloat("specularPower", 8);
        
        //MESHES
        Mesh testMonkeyMesh = new Mesh("newMonkey.obj");
        
        //MESH_RENDERERS
        //Start room geometry
        MeshRenderer startRoomWallRight = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer startRoomWallLeft = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer startRoomWallBottom = new MeshRenderer(null, materialCube, 10.0f, 0.25f, 10.0f);
        MeshRenderer startRoomWallTop = new MeshRenderer(null, materialCube, 10.0f, 0.25f, 10.0f);
        MeshRenderer startRoomWallFront1 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer startRoomWallFront2 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer startRoomWallBack = new MeshRenderer(null, materialCube, 10.0f, 3.0f, 0.25f);
        meshRendererObjects.add(startRoomWallRight);
        meshRendererObjects.add(startRoomWallLeft);
        meshRendererObjects.add(startRoomWallBottom);
        meshRendererObjects.add(startRoomWallTop);
        meshRendererObjects.add(startRoomWallFront1);
        meshRendererObjects.add(startRoomWallFront2);
        meshRendererObjects.add(startRoomWallBack);
        //Level 1 Geometry
        MeshRenderer levelOneWallRight = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelOneWallLeft = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelOneWallBottom = new MeshRenderer(null, materialCube, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelOneWallTop = new MeshRenderer(null, materialCube, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelOneWallFront1 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelOneWallFront2 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelOneWallBack1 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelOneWallBack2 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        meshRendererObjects.add(levelOneWallRight);
        meshRendererObjects.add(levelOneWallLeft);
        meshRendererObjects.add(levelOneWallBottom);
        meshRendererObjects.add(levelOneWallTop);
        meshRendererObjects.add(levelOneWallFront1);
        meshRendererObjects.add(levelOneWallFront2);
        meshRendererObjects.add(levelOneWallBack1);
        meshRendererObjects.add(levelOneWallBack2);
        //Level 2 Geometry
        MeshRenderer levelTwoWallRight = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelTwoWallLeft = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelTwoWallBottom = new MeshRenderer(null, materialCube, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelTwoWallTop = new MeshRenderer(null, materialCube, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelTwoWallFront1 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelTwoWallFront2 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelTwoWallBack1 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelTwoWallBack2 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        meshRendererObjects.add(levelTwoWallRight);
        meshRendererObjects.add(levelTwoWallLeft);
        meshRendererObjects.add(levelTwoWallBottom);
        meshRendererObjects.add(levelTwoWallTop);
        meshRendererObjects.add(levelTwoWallFront1);
        meshRendererObjects.add(levelTwoWallFront2);
        meshRendererObjects.add(levelTwoWallBack1);
        meshRendererObjects.add(levelTwoWallBack2);
        //Level 3 Geometry
        MeshRenderer levelThreeWallRight = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelThreeWallLeft = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer levelThreeWallBottom = new MeshRenderer(null, materialCube, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelThreeWallTop = new MeshRenderer(null, materialCube, 10.0f, 0.25f, 10.0f);
        MeshRenderer levelThreeWallFront1 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelThreeWallFront2 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelThreeWallBack1 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer levelThreeWallBack2 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        meshRendererObjects.add(levelThreeWallRight);
        meshRendererObjects.add(levelThreeWallLeft);
        meshRendererObjects.add(levelThreeWallBottom);
        meshRendererObjects.add(levelThreeWallTop);
        meshRendererObjects.add(levelThreeWallFront1);
        meshRendererObjects.add(levelThreeWallFront2);
        meshRendererObjects.add(levelThreeWallBack1);
        meshRendererObjects.add(levelThreeWallBack2);
        //End Room Geometry
        MeshRenderer endRoomWallRight = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer endRoomWallLeft = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer endRoomWallBottom = new MeshRenderer(null, materialCube, 10.0f, 0.25f, 10.0f);
        MeshRenderer endRoomWallTop = new MeshRenderer(null, materialCube, 10.0f, 0.25f, 10.0f);
        MeshRenderer endRoomWallFront = new MeshRenderer(null, materialCube, 10.0f, 3.0f, 0.25f);
        MeshRenderer endRoomWallBack1 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        MeshRenderer endRoomWallBack2 = new MeshRenderer(null, materialCube, 5.0f, 3.0f, 0.25f);
        meshRendererObjects.add(endRoomWallRight);
        meshRendererObjects.add(endRoomWallLeft);
        meshRendererObjects.add(endRoomWallBottom);
        meshRendererObjects.add(endRoomWallTop);
        meshRendererObjects.add(endRoomWallFront);
        meshRendererObjects.add(endRoomWallBack1);
        meshRendererObjects.add(endRoomWallBack2);
        //Link Corridor 1
        MeshRenderer link1WallRight = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer link1WallLeft = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer link1WallBottom = new MeshRenderer(null, materialCube, 3.0f, 0.25f, 10.0f);
        MeshRenderer link1WallTop = new MeshRenderer(null, materialCube, 3.0f, 0.25f, 10.0f);
        //MeshRenderer link1WallFront = new MeshRenderer(null, materialCube, 3.0f, 3.0f, 0.25f);
        meshRendererObjects.add(link1WallRight);
        meshRendererObjects.add(link1WallLeft);
        meshRendererObjects.add(link1WallBottom);
        meshRendererObjects.add(link1WallTop);
        //meshRendererObjects.add(link1WallFront);
        //Link Corridor 2
        MeshRenderer link2WallRight = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer link2WallLeft = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer link2WallBottom = new MeshRenderer(null, materialCube, 3.0f, 0.25f, 10.0f);
        MeshRenderer link2WallTop = new MeshRenderer(null, materialCube, 3.0f, 0.25f, 10.0f);
        MeshRenderer link2WallFront = new MeshRenderer(null, materialCube, 3.0f, 3.0f, 0.25f);
        meshRendererObjects.add(link2WallRight);
        meshRendererObjects.add(link2WallLeft);
        meshRendererObjects.add(link2WallBottom);
        meshRendererObjects.add(link2WallTop);
        meshRendererObjects.add(link2WallFront);
        //Link Corridor 3
        MeshRenderer link3WallRight = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer link3WallLeft = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer link3WallBottom = new MeshRenderer(null, materialCube, 3.0f, 0.25f, 10.0f);
        MeshRenderer link3WallTop = new MeshRenderer(null, materialCube, 3.0f, 0.25f, 10.0f);
        MeshRenderer link3WallFront = new MeshRenderer(null, materialCube, 3.0f, 3.0f, 0.25f);
        meshRendererObjects.add(link3WallRight);
        meshRendererObjects.add(link3WallLeft);
        meshRendererObjects.add(link3WallBottom);
        meshRendererObjects.add(link3WallTop);
        meshRendererObjects.add(link3WallFront);
        //Link Corridor 4
        MeshRenderer link4WallRight = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer link4WallLeft = new MeshRenderer(null, materialCube, 0.25f, 3.0f, 10.0f);
        MeshRenderer link4WallBottom = new MeshRenderer(null, materialCube, 3.0f, 0.25f, 10.0f);
        MeshRenderer link4WallTop = new MeshRenderer(null, materialCube, 3.0f, 0.25f, 10.0f);
        MeshRenderer link4WallFront = new MeshRenderer(null, materialCube, 3.0f, 3.0f, 0.25f);
        meshRendererObjects.add(link4WallRight);
        meshRendererObjects.add(link4WallLeft);
        meshRendererObjects.add(link4WallBottom);
        meshRendererObjects.add(link4WallTop);
        meshRendererObjects.add(link4WallFront);
        //25/11/19 - collectible coloured cubes
        MeshRenderer collectableCube = new MeshRenderer(null, materialTest, 1.0f, 1.0f, 1.0f);
        meshRendererCollectableObjects.add(collectableCube);
        
        //GAME_OBJECTS
        GameObject directionalLightObject = new GameObject();
        DirectionalLight directionalLight = new DirectionalLight(new Vector3f(0,0,1), 0.4f);
        directionalLightObject.addComponent(directionalLight);
        directionalLight.getTransform().setRot(new Quaternion(new Vector3f(1,0,0), (float)Math.toRadians(-45)));
                  
        GameObject pointLightObject = new GameObject();
        pointLightObject.addComponent(new PointLight(new Vector3f(0,1,0), 1.0f, new Attenuation(0,0,1)));
        pointLightObject.getTransform().getPos().set(0, 3, 0);
         
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
        GameObject collectableCube1 = new GameObject().addComponent(collectableCube);
        collectableCube1.getTransform().getPos().set(0, 3, 3);
         
        GameObject testMesh5 = new GameObject().addComponent(new LookAtComponent()).addComponent(new MeshRenderer(testMonkeyMesh, materialTest, 0.0f, 0.0f, 0.0f));// 11/7/19 test
        testMesh5.getTransform().getPos().set(0, 3, 0);
        testMesh5.getTransform().setRot(new Quaternion(new Vector3f(0,1,0), 0.4f));
         
        GameObject player = new GameObject();
        FreeMove playerMovement = new FreeMove(10.0f);
        freeMoveObjects.add(playerMovement);
        player.getTransform().getPos().set(5, 3, 0);
        player.addComponent(new FreeLook(0.5f));
        player.addComponent(playerMovement);
        player.addComponent(new Camera((float)Math.toRadians(70.0f), (float)Window.getWidth()/(float)Window.getHeight(), 0.01f, 1000.0f));
        
        GameObject spotLightObject = new GameObject();
        SpotLight spotLight =  new SpotLight(new Vector3f(0,1,1), 0.4f, new Attenuation(0,0,0.1f), 0.7f);
        spotLightObjects.add(spotLight);
        spotLightObject.addComponent(spotLight);
        spotLightObject.getTransform().getPos().set(5,5,0);//13/11/19
         
        addObject(directionalLightObject);
        addObject(pointLightObject);
        addObject(spotLightObject);
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
        addObject(testMesh5);
        addObject(player);
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
    					currentMeshRenderer.setCollected(true);
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
}
