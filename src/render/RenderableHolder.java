package render;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RenderableHolder {
	private static RenderableHolder instance = new RenderableHolder();
	private static List<IRenderable> entities;

	public RenderableHolder() {
		// TODO Auto-generated constructor stub
		this.entities = new CopyOnWriteArrayList<IRenderable>();
		
	}

	public static RenderableHolder getInstance() {
		return instance;
	}
	
	public void add(IRenderable r){
		entities.add(r);
		
	}
	
	public static List<IRenderable> getRenderableList(){
		return entities;
	}
	

}
