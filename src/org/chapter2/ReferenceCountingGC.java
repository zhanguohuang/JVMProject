package org.chapter2;

/**
 * ���߶���GC������֤�����������ղ��Ǽ����ķ�������������һ�ֿɴ����㷨
 * @author Administrator
 *
 */
public class ReferenceCountingGC {
	
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	/*�����Ա���Ե�Ψһ�������ռ���ڴ棬�Ա�����GC��־�п�����Ƿ񱻻��չ�*/
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
