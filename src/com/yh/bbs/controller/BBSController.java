package com.yh.bbs.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import com.yh.bbs.action.Action;
import com.yh.bbs.config.Config;

public class BBSController {
	
	ActionController actionCtrl = null;

	public BBSController() {
		initPath();

		actionCtrl = new ActionController();
	}
	
	public void initPath() {
		try {
			FileController.make_always(Config.PATH_DIR, "dir");
			FileController.make_always(Config.PATH_DIR_ACTION, "dir");
			FileController.make_always(Config.PATH_DIR_AUDIO, "dir");
			FileController.make_always(Config.FILE_ACTIONS, "file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void audioPlay(int uid) {
		Action action = actionCtrl.getAction(uid);
		if ( action != null ) {
			System.out.println("ASDFASDF");
			AudioController.play(Config.PATH_DIR_AUDIO+action.getAudioName());
		}
	}
}
