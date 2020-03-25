/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.nbcc.icecream.models.Sundae;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nbcc.icecream.models.Topping;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class SundaeController extends CommonController {
    
    private static final String SUNDAE_VIEW = "/sundae.jsp";
    private static final String SUNDAE_SUMMARY_VIEW = "/sundaeSummary.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        super.setView(request, SUNDAE_VIEW);
        Topping topping = new Topping();
        request.setAttribute("vm", topping);
        super.getView().forward(request, response);
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            super.setView(request, SUNDAE_SUMMARY_VIEW);
            
            if(super.isNumeric(request, "txtSundaeSubTotal")){
                String[] toppings = request.getParameterValues("chkToppings");
                ArrayList<Topping> addedToppings = new ArrayList();
                Topping topping = new Topping();
                Sundae createdSundae = new Sundae();
                for(String top : toppings){
                    //addedToppings.(super.getInteger(top), topping.getTopping(super.getInteger(top)));
                    addedToppings.add(addedToppings.size()+1, topping.getTopping(super.getInteger(top)));
                }
                createdSundae.setSubtotal(super.getDouble(request, "txtSundaeSubtotal"));
                createdSundae.setToppings(addedToppings);
                
                request.setAttribute("sundae", createdSundae);
            }
            
            
        }catch(Exception e){
            
        }
        
        
        
    }
    
}
