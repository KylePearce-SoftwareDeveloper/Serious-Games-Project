/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.engine.core;

import com.base.engine.rendering.RenderingEngine;

/**
 *
 * @author kylep
 */
public abstract class Game 
{
	private GameObject root;
	
    public void init() {}
    
    public void checkCollision() {}//12/11/19 - collision detection test
    public void updateSpotLight() {}//13/11/19
    public void checkCollisionForCollectables() {} //25/11/19 - collectible coloured cubes
    public void moveDoor() {}
    
    public void input(float delta)
    {
    	getRootObject().inputAll(delta);
    }
    
    public void update(float delta)
    {
    	getRootObject().updateAll(delta);
    }
    
    public void render(RenderingEngine renderingEngine)
    {
    	renderingEngine.render(getRootObject());
    }
    
    public void addObject(GameObject object)
    {
    	getRootObject().addChild(object);
    }
    
    private GameObject getRootObject()
    {
    	if(root == null)
    		root = new GameObject();
    	
    	return root;
    }
    
    public void setEngine(CoreEngine engine) { getRootObject().setEngine(engine); }
}
