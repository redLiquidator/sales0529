package com.mdct.study.model.dto;

public class Parameter {

		private int value;
		
		public int getNo(){
			return value;
		}
		public void setNo(int value){
			this.value=value;
		}
		@Override
		public String toString() {
			return "Parameter [no=" + value + "]";
		}
		
}
