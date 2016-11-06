/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueHack.forms;

import com.codename1.components.SpanLabel;
import com.codename1.maps.MapComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.UIManager;

/**
 *
 * @author hrugani
 */
public class WhereIsMyCar extends Form {
    
    private TextField txtTag;
    private Button btnSearch;
    private MapComponent mapComp;
    private SpanLabel lblAddress; 

    public WhereIsMyCar() {
        
        super();
        
        setTitle("Onde está mau Carro?");
        
        preInit();
        init();
        postInit();
        
    }

    private void preInit() {
        this.txtTag = createTxtTag();
        this.btnSearch = createBtnSearch();
        this.lblAddress = createLblAddress();
        this.mapComp = createMapComp();
    }

    private void init() {
        
        Container cNorth = new Container(new BorderLayout());
            cNorth.addComponent(BorderLayout.CENTER, txtTag);
            cNorth.addComponent(BorderLayout.EAST, btnSearch);
            
        setLayout(new BorderLayout());
        addComponent(BorderLayout.NORTH, cNorth);
        addComponent(BorderLayout.CENTER, mapComp);
        addComponent(BorderLayout.SOUTH, lblAddress);

    }

    private void postInit() {
    }

    private TextField createTxtTag() {
        TextField txt = new TextField();
        txt.setHint("Entre a TAG da localização");
        return txt;
    }

    private SpanLabel createLblAddress() {
        SpanLabel lbl = new SpanLabel();
        return lbl;
    }

    private Button createBtnSetPosition() {
        Button btn = new Button("Posicionar");
        btn.addActionListener(
            (ActionListener) (ActionEvent evt) -> {
                // code action here
            }
        );
        return btn;
    }

    private MapComponent createMapComp() {
        MapComponent mc = new MapComponent();
        return mc;
    }

    private Button createBtnSearch() {
        Button btn = new Button(
            FontImage
               .createMaterial(
                   FontImage.MATERIAL_SEARCH,
                   UIManager.getInstance().getComponentStyle("Button"))
        );
        btn.addActionListener(
            (ActionListener) (ActionEvent evt) -> {
                Dialog.show("Mensagem", "Em Desenvolvimento", "OK", null);
            }
        );
        return btn;
    }
    
    
    
}
