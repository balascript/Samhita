package in.org.samhita.android.app;

public class Update {
private String UpdateName;
private String EventDesc;
private String time;
private int id;
private String url;
private int type;// 1-ad 0-update
public Update() {
	
}

public void SetDetails(int id,String name,String desc,String time,int ad,String url) {
	this.id=id;
	this.UpdateName=name;
	this.EventDesc=desc;
	this.time=time;
	this.type=ad;
	this.url=url;
	
}
public String getUpdate() {
	return this.UpdateName;
}
public String getUpdateType() {
	return ""+this.type;
}

public String getId() {
	
	return ""+this.id;
}

public String getDesc() {
	// TODO Auto-generated method stub
	return this.EventDesc;
}

public String getTime() {
	// TODO Auto-generated method stub
	return this.time;
}
public String getUrl() {
	// TODO Auto-generated method stub
	return this.url;
}
}
