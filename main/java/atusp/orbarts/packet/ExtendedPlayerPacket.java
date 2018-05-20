package atusp.orbarts.packet;

import atusp.orbarts.entity.ExtendedEntityPlayer;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class ExtendedPlayerPacket implements IMessage{
	public boolean hasOrb;
	public int[] structure = new int[4];
	public int[] limit = new int[7];
	public int[] level = new int[7];
	public int[] circuit = new int[7];
	
	public void get(ExtendedEntityPlayer props) {
		this.circuit = props.circuit;
		this.hasOrb = props.hasOrb;
		this.level = props.level;
		this.limit = props.limit;
		this.structure = props.structure;
	}
	
	public void set(ExtendedEntityPlayer props) {
		props.hasOrb = this.hasOrb;
		props.circuit = this.circuit;
		props.level = this.level;
		props.limit = this.limit;
		props.structure = this.structure;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		System.out.println("Recieving...");
		String txt = ByteBufUtils.readUTF8String(buf);
		String[] string = txt.split(",");
		this.hasOrb = Boolean.valueOf(string[0]);
		for(int i=1;i<=4;i++) {
			this.structure[i-1] = Integer.valueOf(string[i]);
		}
		for(int i=5;i<=11;i++) {
			this.circuit[i-5] = Integer.valueOf(string[i]);
		}
		for(int i=12;i<=18;i++) {
			this.limit[i-12] = Integer.valueOf(string[i]);
		}
		for(int i=19;i<=25;i++) {
			this.level[i-19] = Integer.valueOf(string[i]);
		}
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		System.out.println("Sending...");
		String txt="";
		txt+=this.hasOrb+",";
		txt+=this.structure[0]+","+this.structure[1]+","+this.structure[2]+","+this.structure[3]+",";
		txt+=this.circuit[0]+","+this.circuit[1]+","+this.circuit[2]+","+this.circuit[3]+","+this.circuit[4]+","+this.circuit[5]+","+this.circuit[6]+",";
		txt+=this.limit[0]+","+this.limit[1]+","+this.limit[2]+","+this.limit[3]+","+this.limit[4]+","+this.limit[5]+","+this.limit[6]+",";
		txt+=this.level[0]+","+this.level[1]+","+this.level[2]+","+this.level[3]+","+this.level[4]+","+this.level[5]+","+this.level[6];
		ByteBufUtils.writeUTF8String(buf, txt);
	}
	
	//输出信息
	public String toString() {
		String s = super.toString();
		s += "hasOrb:"+this.hasOrb+"\n";
		s += "structure:"+this.structure[0]+","+this.structure[1]+","+this.structure[2]+","+this.structure[3]+"\n";
		s += "circuit:"+this.circuit[0]+","+this.circuit[1]+","+this.circuit[2]+","+this.circuit[3]+","+this.circuit[4]+","+this.circuit[5]+","+this.circuit[6]+"\n";
		s += "limit:"+this.limit[0]+","+this.limit[1]+","+this.limit[2]+","+this.limit[3]+","+this.limit[4]+","+this.limit[5]+","+this.limit[6]+"\n";
		s += "level:"+this.level[0]+","+this.level[1]+","+this.level[2]+","+this.level[3]+","+this.level[4]+","+this.level[5]+","+this.level[6]+"\n";
		return s;
	}
}
