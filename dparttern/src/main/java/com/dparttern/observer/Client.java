package com.dparttern.observer;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		HanFeiZi hanFeiZi=new HanFeiZi();
		hanFeiZi.addObserver(new LiSi());
		hanFeiZi.addObserver(new ZhangSan());
		hanFeiZi.addObserver(new WangEr());
		
//		Spy spy1=new Spy(hanFeiZi, liSi, "breakfast");
//		spy1.start();
//		
//		Spy spy2=new Spy(hanFeiZi, liSi, "havefun");
//		spy2.start();
		
//		Thread.sleep(2000);
		
		
		hanFeiZi.haveBreakfast();
		
//		Thread.sleep(2000);
//		hanFeiZi.haveFun();
		
	}
}
