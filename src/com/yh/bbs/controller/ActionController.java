package com.yh.bbs.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.yh.bbs.action.Action;
import com.yh.bbs.config.Config;

public class ActionController {
	ArrayList<Action> list_Action= new ArrayList();

	FileController fCtrl	= null; 

	public ActionController() {
		fCtrl = new FileController(Config.FILE_ACTIONS);
		updateAction();
	}
	
	public void appendAction(String strAction, String strAudio) {
		
		Action action 			= new Action(strAction, strAudio);
		FileController fAudio	= new FileController(strAudio);
		
		try {
			fAudio.copy(Config.PATH_DIR_AUDIO+fAudio.getFileName());
			
			fCtrl.appendLine(action.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.list_Action.add(action);
	}	
	
	public ArrayList<Action> updateAction() {
		this.list_Action.clear();	//	ºñ¿ì±â

		ArrayList<String> stringlist = null;
		stringlist = fCtrl.readAll_withLineArray();

		for (String temp : stringlist) {
			this.list_Action.add(new Action(temp));
		}

		return this.list_Action;
	}
	public ArrayList<Action> getActionAll(){
		return this.list_Action;
	}

	public Action getAction(int uid) {
		for (Action action : this.list_Action) {
			if ( action.getUID() == uid )
				return action;
		}
		return null;
	}
	
}
