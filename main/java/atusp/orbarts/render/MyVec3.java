package atusp.orbarts.render;

import net.minecraft.util.Vec3;

public class MyVec3 extends Vec3{
	public int age;
	
	public MyVec3(double x, double y, double z, int age) {
		super(x, y, z);
		this.age = age;
		// TODO Auto-generated constructor stub
	}
}
