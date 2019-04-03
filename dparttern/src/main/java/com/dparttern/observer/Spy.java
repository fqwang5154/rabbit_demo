package com.dparttern.observer;

public class Spy extends Thread {
	private HanFeiZi hanFeiZi;
	private LiSi liSi;
	private String type;
	
	public Spy(HanFeiZi hanFeiZi, LiSi liSi, String type) {
		this.hanFeiZi = hanFeiZi;
		this.liSi = liSi;
		this.type = type;
	}
	
	@Override
	public void run() {
		while(true){
//			if("breakfast".equals(type)){
//				if(hanFeiZi.isHaveBreakfast()){
//					liSi.update("韩非子在吃饭");
//					hanFeiZi.setHaveBreakfast(false);
//				}
//			}else{
//				if(hanFeiZi.isHaveFun()){
//					liSi.update("韩非子在娱乐");
//					hanFeiZi.setHaveFun(false);
//				}
//			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
