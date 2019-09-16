package com.base.game;

import com.base.engine.components.GameComponent;
import com.base.engine.core.*;
import com.base.engine.rendering.RenderingEngine;
import com.base.engine.rendering.Shader;

public class LookAtComponent extends GameComponent
{
	RenderingEngine renderingEngine;

	@Override
	public void update(float delta)
	{
		if(renderingEngine != null)
		{
			Quaternion newRot = getTransform().getLookAtDirection(renderingEngine.getMainCamera().getTransform().getTransformedPos(),
					new Vector3f(0,1,0));//something is wrong with newRot, coss if i pass in a empty quaternion to the line below the monkey does not move
					//getTransform().getRot().getUp());

			getTransform().setRot(getTransform().getRot().nlerp(newRot, delta * 5.0f, true));//this is the line of code changing the rotation and position of the model
			//getTransform().setRot(getTransform().getRot().slerp(newRot, delta * 5.0f, true));
		}
	}

	@Override
	public void render(Shader shader, RenderingEngine renderingEngine)
	{
		this.renderingEngine = renderingEngine;
	}
}
