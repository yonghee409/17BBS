package com.yh.bbs;

import com.yh.bbs.controller.BBSController;

import com.yh.bbs.controller.AudioController;

public class Main {
	public static void main(String[] args) {
		String strAudio 		= "C:\\Users\\Yonghee\\Desktop\\cartoon-birds-2_daniel-simion.wav";
		BBSController bbsCtrl 	= new BBSController();
		
		bbsCtrl.audioPlay(6687);
	}
}
