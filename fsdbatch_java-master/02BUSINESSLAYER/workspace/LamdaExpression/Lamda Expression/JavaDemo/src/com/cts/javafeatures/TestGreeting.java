package com.cts.javafeatures;

public class TestGreeting {
	
	@FunctionalInterface
	interface StringLengthLamda{
		public int getLength(String s);
	}

	public static void main(String[] args) {
		Greeting g = new Greeting();
//		Pass a functionality
//		IGreeting japaneseGreeting = new IGreeting(){
//			@Override
//			public void greet() {
//				System.out.println("Konichiwa!!");
//			}		
//		};
		IGreeting japaneseGreeting = ()->System.out.println("Konichiwa!!");
		g.sayHello(japaneseGreeting);
		
		StringLengthLamda sl = (s) -> s.length();
		System.out.println(sl.getLength("testthislength"));
		
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t.start();
		
		Thread t2 = new Thread(()->System.out.println(Thread.currentThread().getName()));
		t2.start();
		
		g.sayHello(new IGreeting(){
			@Override
			public void greet() {
				System.out.println("Bonjour!!");
			}		
		});
	}

}
