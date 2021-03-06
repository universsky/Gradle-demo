package com.gradle.java.singleton;

import java.util.Date;

import com.gradle.api.uas.PlatformApi;
import com.gradle.java.utils.DateFormatUtil;



/**
 * @author Arison
 * 测试单例引用内存问题
 */
public class Main {

	public static void main(String[] args) {
      System.out.println(ApiConfig.getInstance(ApiUtils.getApiModel()).getmApiBase().login);
      if (ApiUtils.getApiModel() instanceof PlatformApi) {
		
	  }
	}
	

	
	@SuppressWarnings("unused")
	private static void printLnMemory(){
		Runtime run = Runtime.getRuntime();
		System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + (run.totalMemory()-run.freeMemory()) );
		System.out.println("time: " + (new Date()));
		// 获取开始时内存使用量
		long startMem = run.totalMemory()-run.freeMemory();
		System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + startMem );
        System.out.println("开始："+DateFormatUtil.getDateTime());
		for (int i=0;i<9999999;i++) {
//			ApiConfig.getInstance(ApiPlatform.getInstance()).getmApiConfig().init();
			//new ApiPlatform();
		}
		System.out.println("结束："+DateFormatUtil.getDateTime());
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i=0;i<500000;i++) {
//				ApiConfig.getInstance(ApiPlatform.getInstance()).getmApiConfig().init();
//				new ApiPlatform();
			}
			System.out.println("time: " + (new Date()));
			long endMem = run.totalMemory()-run.freeMemory();
			System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + endMem );
			System.out.println("memory difference[内存]:【" + (endMem-startMem)/1024+"】:kb");
			
		}
		
	}
	
	

}
