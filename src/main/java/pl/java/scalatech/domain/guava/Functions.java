package pl.java.scalatech.domain.guava;

import com.google.common.base.Function;

public class Functions {
	
	 public static Function<Integer, Integer> byHalf() {
	        return new Function<Integer, Integer>() {
	            
	            public Integer apply(Integer integer) {
	                return integer / 2;
	            }
	        };
	    }

}