package org.chapter2;

/**
 * 两者都被GC回收吗，证明了垃圾回收不是计数的方法，而倾向于一种可达性算法
 * @author Administrator
 *
 */
public class ReferenceCountingGC {
	
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	/*这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过*/
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
