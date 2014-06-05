package com.zhuoxuan.common.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/**
 * @description：用于执行任务的线程池
 * @date 2013-12-13 下午12:40:43
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public class XTExecuteThreadPool {

	protected ExecutorService executor;

	protected int pool_size;

	protected Semaphore semaphore;

	/**
	 * 初始化
	 */
	public void init(){
		executor = Executors.newFixedThreadPool(pool_size);
	}

	/**
	 * <p>
	 * 提交一个 Runnable 的任务
	 * </p>
	 * @param runnable
	 */
	public  Future<?> submit(Runnable runnable){
		return executor.submit(runnable);
	}
	
	/**
	 * <p>
	 * 提交一个 Callable 的任务
	 * </p>
	 * @param callable
	 */
	public  Future<?> submit(Callable<?> callable){
		return executor.submit(callable);
	}

	/**
	 * <p>
	 * 执行一个 Runnable 的任务
	 * </p>
	 * @param runnable void
	 */
	public void execute(Runnable runnable) {

		executor.execute(runnable);
	}

	/**
	 * <p>
	 * 初始化用于锁定当前线程池的信号量
	 * </p>
	 * void
	 */
	public void acquires() {

		try {
			if (semaphore == null) {
				semaphore = new Semaphore(pool_size);
			}
			semaphore.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * 释放用户锁定当前线程池的信号量
	 * </p>
	 * void
	 */
	public void release() {

		if (semaphore == null) {
			semaphore = new Semaphore(pool_size);
		}
		semaphore.release();
	}

	public void setPool_size(int pool_size) {
		this.pool_size = pool_size;
	}

}
