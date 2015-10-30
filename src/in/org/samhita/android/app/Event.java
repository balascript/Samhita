package in.org.samhita.android.app;

public class Event {
	int EventId;
	String EventName;
	String EventDesc;
	String EventTime;
	String OrganizerName;
	String Contact;
	int type;
	String url;//onsite-1,online-2,workshop-3
	
	
	
	public Event() {
		
	}
	
	public void setDetails(int id,String EventName,String EventTime,String EventDesc,String OrganizerName,String Phone,int type) {
		this.EventId=id;
		this.EventName=EventName;
		this.EventDesc=EventDesc;
		this.EventTime=EventTime;
		this.OrganizerName=OrganizerName;
		this.Contact=Phone;
		this.type=type;
		this.url="";
		
	}
	public void setDetails(int id,String EventName,String EventTime,String EventDesc,String OrganizerName,String Phone,String url) {
		this.EventId=id;
		this.EventName=EventName;
		this.EventDesc=EventDesc;
		this.EventTime=EventTime;
		this.OrganizerName=OrganizerName;
		this.Contact=Phone;
		this.type=3;
		this.url=url;
		
	}
	
	public String getEventName() {
		return this.EventName ;
	}
	public String getEventURl() {
		return this.url ;
	}

	public String getTime() {
		
		return this.EventTime;
	}

	public String getOrganizer() {
		
		return this.OrganizerName;
	}

	public String getDesc() {
		
		return this.EventDesc;
	}
public String getId() {
		
		return ""+this.EventId;
	}

	public String getPhone() {
		// TODO Auto-generated method stub
		return this.Contact;
	}
	public int getType() {
		// TODO Auto-generated method stub
		return this.type;
	}
	

}
