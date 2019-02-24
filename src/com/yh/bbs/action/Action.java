package com.yh.bbs.action;

public class Action {
	private int uid;
	private String strAction;
	private String strAudio;
	
	public Action(String strData) {
		String[] temp = strData.replaceAll(" ","").split(",");

		this.setAction(Integer.parseInt(temp[0]),temp[1],temp[2]);
	}
	public Action(String strAction, String strAudio) {
		this.setAction(Action.generateUID(), strAction, strAudio);
	}
	public Action(int uid, String strAction, String strAudio) {
		this.setAction(uid, strAction, strAudio);
	}
	public void setAction(int uid, String strAction, String strAudio) {
		this.uid = uid;
		this.strAction = strAction;
		if ( strAudio.lastIndexOf("\\") > -1 )	
			this.strAudio = strAudio.substring(strAudio.lastIndexOf("\\")+1);
		else 
			this.strAudio = strAudio;
	}
	
	public String toString() {
		return String.format("%5d, %30s, %s", this.uid,this.strAction, this.strAudio);
	}
	public int getUID() {
		return this.uid;
	}
	public String getAudioName() {
		return this.strAudio;
	}
	public static int generateUID() {
		return (int)(Math.random()*10000) + 1;
	}
}
