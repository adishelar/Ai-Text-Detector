package com.example.demo.controller;

import java.beans.JavaBean;

public class AnalysisResponse {
	  private String result;

      public AnalysisResponse(String result) {
          this.result = result;
      }

      public AnalysisResponse() {
		
	}

	public String getResult() {
          return result;
      }
      
      public void setResult(String result) {
          this.result = result;
      }
}
