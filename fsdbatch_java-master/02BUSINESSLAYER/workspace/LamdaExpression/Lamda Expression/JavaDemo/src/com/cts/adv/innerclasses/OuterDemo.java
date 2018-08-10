package com.cts.adv.innerclasses;

//import com.cts.adv.innerclasses.Outer.Inner;

public class OuterDemo {

	public static void main(String[] args) {
		Outer outer = new Outer(34);
		Outer.Inner inner = new Outer.Inner();
		inner.displayId();

	}

}
