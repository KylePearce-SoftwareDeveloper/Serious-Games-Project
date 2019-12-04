package com.base.engine.rendering;

import java.util.HashMap;

import com.base.engine.core.Vector3f;
import com.base.engine.rendering.resourceManagement.MappedValues;

public class Material extends MappedValues
{
	private HashMap<String, Texture> textureHashMap;
	//private String colour = " ";//29/11/19
	private String fileName;//RANDOM LOGIC TEST(29/11/19)

	public Material() 
	{
		super();
		textureHashMap = new HashMap<String, Texture>();	
	}
	
	public void addTexture(String name, Texture texture){ textureHashMap.put(name, texture); this.fileName = texture.getFileName();}//RANDOM LOGIC TEST(29/11/19)
	
	public Texture getTexture(String name)
	{ 
		Texture result = textureHashMap.get(name);
		if(result != null)
			return result;
		
		return new Texture("test.png");
	}
	/*
	public String getColour()//29/11/19
	{ 
		return colour;
	}
	
	public void setColour(String colour)//29/11/19
	{ 
		this.colour = colour;
	}
	*/
	
	public String getFileName()
	{
		return fileName;
	}
}
