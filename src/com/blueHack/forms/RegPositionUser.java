/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueHack.forms;

import com.codename1.maps.MapComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author hrugani
 */
public class RegPositionUser extends Form {

    private MapComponent mapComp;
   // private SpanLabel lbltxtLocation;
    private Button btnPositionReg;
    
    public RegPositionUser() {
        super();
        setTitle("Reg. Posição Usuário");
        
        preInit();
        init();
        postInit();
        
        
    }

    private void preInit() {
        this.btnPositionReg = createBtnPositionReg();
        this.mapComp = createMapComp();
    }

    private void init() {
        
        Container cNorth = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cNorth.addComponent(new Label());
        cNorth.addComponent(btnPositionReg);
        
        setLayout(new BorderLayout());
        addComponent(BorderLayout.NORTH, cNorth);
        addComponent(BorderLayout.CENTER, mapComp);
        
    }

    private void postInit() {
    }

    private Button createBtnPositionReg() {
        Button btn = new Button("Posicionar?");
        btn.addActionListener(    
           (ActionListener) (ActionEvent evt) -> {
               Dialog.show("Mensagem", "Em Desenvolvimento", "OK", null);
            }
        );                        
        return btn;
    }

    private MapComponent createMapComp() {
        MapComponent mc = new MapComponent();
        return mc;
    }

    
}
