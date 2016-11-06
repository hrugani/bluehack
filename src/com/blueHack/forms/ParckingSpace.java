/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueHack.forms;

import com.codename1.maps.MapComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;

/**
 *
 * @author hrugani
 */
public class ParckingSpace extends Form {

    private TextField txtDestination;
    private TextField txtMaxDistance;
    private MapComponent mapComp;
    private Button btnSearch;
    private Button btnGetParkingSpaces;
    
    public ParckingSpace() {
        
        super();
        
        setTitle("Módulo de Vagas");
        
        preInit();
        init();
        postInit();
        
        
    }

    private void preInit() {
        
        this.btnSearch = createBtnSearch(); 
        this.btnGetParkingSpaces = createBtnGetParkingSpaces();
        this.txtDestination = createTxtDestination();
        this.mapComp = createMapComp();
        this.txtMaxDistance = createTxtDistance();
        
    }

    private void init() {
        
        Container cDestination = new Container(new BorderLayout());
            cDestination.addComponent(BorderLayout.CENTER, txtDestination);
            cDestination.addComponent(BorderLayout.EAST, btnSearch);
            
        
        Container cNorth = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            cNorth.addComponent(cDestination);
            cNorth.addComponent(txtMaxDistance);
        
        setLayout(new BorderLayout());
        addComponent(BorderLayout.NORTH, cNorth);
        addComponent(BorderLayout.CENTER, mapComp);
        addComponent(BorderLayout.SOUTH, btnGetParkingSpaces);
        
    }

    private void postInit() {
    }

    private Button createBtnGetParkingSpaces() {

        Button btn = new Button("Vagas Próximas");
        
        btn.addActionListener(                
            (ActionListener) (ActionEvent evt) -> {               
                Form ParkingListForm = new ParkingList();
                Command backCommand = new Command("Voltar") {
                    @Override
                    public void actionPerformed(ActionEvent ev) {
                         ParckingSpace.this.showBack();
                    } 
                }; 
                ParkingListForm.setBackCommand(backCommand);                               
                ParkingListForm.show();                
            }
        );
        
        return btn;
    }
    private TextField createTxtDestination() {
        TextField txt = new TextField();
        txt.setHint("Destino");
        return txt;
    }

    private TextField createTxtDistance() {
        TextField txt = new TextField();
        txt.setHint("Máxima Distância");
        txt.setConstraint(TextField.DECIMAL);
        return txt;
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
