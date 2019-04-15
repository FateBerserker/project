package com.graduate.test;

public class Main {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A (int v) {
        	System.out.println("父类构造函数");
            setValue(v);
        }
        public void setValue(int value) {
        	System.out.println("父类Set "+value);
            this.value= value;
        }
        public int getValue() {
            try {
            	System.out.println("父类get ");
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);// 11 17 
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3);
        }
        public void setValue(int value) {
        	System.out.println("子类Set "+value);
            super.setValue(2 * value);
        }
    }
}
