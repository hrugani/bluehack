/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueHack.forms;

import com.blueHack.Util;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import java.util.ArrayList;
import com.blueHack.entities.Parking;
import com.codename1.components.Accordion;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.table.TableLayout;

/**
 *
 * @author hrugani
 */
public class ParkingList extends Form {          
            
    public ParkingList(){
        super();      
        setTitle("Lista de Estabelecimentos");
        init();
        posInit();       
    }

    private void preInit() {
        
    }

    private void init() {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
    }

    private void posInit() {
        removeAll();
        ArrayList<Parking> listParking =
            Util.getInstance().getParkingListTest();
        MyAccordion accr;
        for(Parking p : listParking) {
            accr = new MyAccordion(p);
            addComponent(accr);
        }
    }
        
    class MyAccordion extends Accordion{

        public MyAccordion(Parking p) {
            Container cMaster = createMaster(p);
            Container cDetail = createDatail(p);
            addContent(cMaster, cDetail);
        }        

        private Container createMaster(Parking p) {
            MultiButton mb;
            mb = new MultiButton();
            mb.setTextLine1(p.getName());
            mb.setTextLine2("" + p.getParkingSpaces());
            mb.setTextLine3(
                "hora: " + p.getPriceHour()
                + " - dia: " + p.getPriceDay()
                + " - mês: " + p.getPriceMonth()
            );            
            
            return mb;
        }

        private Container createDatail(Parking p) {
            
            Container cCenter = TableLayout.encloseIn(2,true, 
                    new Label("Hora:"),
                    new Label("" + p.getPriceHour()),
                    new Label("Diária:"),
                    new Label("" + p.getPriceDay()),
                    new Label("Mensal:"),
                    new Label("" + p.getPriceMonth())
            );
            
            Container cSouth = new Container(new GridLayout(1,4));
            cSouth.addComponent(new Label(" "));
            cSouth.addComponent(new Label(" "));
            cSouth.addComponent(new Label(" "));
            cSouth.addComponent(new WazeButton(p));
            
            Container c = new Container(new BorderLayout());
            c.addComponent(BorderLayout.CENTER, cCenter);
            c.addComponent(BorderLayout.SOUTH, cSouth);
            
            return c;
        }
    }
    
    class WazeButton extends Button{
        Parking p;
        public WazeButton(Parking p) {
            super("Waze");
            getStyle().setAlignment(CENTER);
            addActionListener((ActionListener) (ActionEvent evt) -> {
                    // Waze call example.
                    //url = "waze://?ll=-23.536299,-46.686158&navigate=yes";
                    String url =
                       new StringBuilder()
                       .append("waze://?ll=")
                       .append(p.getGeolocation())
                       .append("&navigate=yes")
                       .toString();
                    
                    Display.getInstance().execute(url);
            });
        }        
    }
}
