package com.dparttern.observer;

public class LiSi implements Observer {

	@Override
	public void update(String context) {
		System.out.println("李斯：观察到韩非子活动，开始向老板汇报了...");
		this.report(context);
		System.out.println("李斯：汇报完毕");
	}

	private void report(String context) {
		System.out.println("李斯：报告王老板，韩非子有活动了-->"+context);
	}

}
