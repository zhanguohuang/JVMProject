package org.chapter3;

/**
 * 说明并没有使用引用计数算法，主要问题是引用计数算法很难解决对象之间相互引用的问题
 */
public class ReferenceCountingGC {
	
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	//使之更加明显
	private byte[] bigSize = new byte[2 * _1MB];
	
	public static void testGC() {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		objA = null;
		objB = null;
		System.gc();
	}
}
