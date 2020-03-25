/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Chris.Cusack
 */
public class CommonController extends HttpServlet {

    private RequestDispatcher view;
    
    public RequestDispatcher getView(){
        return view;
    }
    
    public void setView(HttpServletRequest request,String viewPath){
        view = request.getRequestDispatcher(viewPath);
    }
        
    protected int getInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public boolean isNumeric(HttpServletRequest request, String key) {
        boolean result = true;

        try {
            double d = Double.parseDouble(request.toString());
        } catch (NumberFormatException nfe) {
            result = false;
        }
        
        return result;
    }
    
    protected int getInteger(HttpServletRequest request, String key) {
        try {
            return Integer.parseInt(request.getParameter(key));
        } catch (Exception e) {
            return 0;
        }
    }

    protected double getDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return 0.0;
        }
    }
    
    protected double getDouble(HttpServletRequest request, String key) {
        try {
            return Double.parseDouble(request.getParameter(key));
        } catch (Exception e) {
            return 0.0;
        }
    }

    protected String getValue(HttpServletRequest request, String key) {
        return request.getParameter(key);       
    }

}