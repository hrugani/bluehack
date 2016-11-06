/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueHack.forms;

import com.blueHack.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
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
public class Initial extends Form {

    private Button btnRegister;
    private Button btnWhereIsMyCar;
    private Button btnParkingSpace;
    
    public Initial() {
        super();
        setTitle("LOHGO ALI");
        
        preInit();
        init();
        postInit();
        
        
    }

    private void preInit() {
        this.btnRegister = createBtnRegister();
        this.btnWhereIsMyCar = createBtnWhereIsMyCar();
        this.btnParkingSpace = createBtnParkingSpace();
    }

    private void init() {
        
        Container cCenter = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cCenter.addComponent(new Label());
        cCenter.addComponent(btnRegister);
        cCenter.addComponent(new Label());
        cCenter.addComponent(btnWhereIsMyCar);
        cCenter.addComponent(new Label());
        cCenter.addComponent(btnParkingSpace);
        
        setLayout(new BorderLayout());
        addComponent(BorderLayout.NORTH, new Label(" "));
        addComponent(BorderLayout.CENTER, cCenter);
                
        
    }

    private void postInit() {
    }


    private Button createBtnRegister() {
        Button btn = new Button("Registrar Posição");

        btn.addActionListener(
                
            (ActionListener) (ActionEvent evt) -> {
                
                if (Util.getInstance().getUser().getType().equals("E")) {

                    Form regPositionEnterprise = new RegPositionEnterprise();                
                    Command backCommand = new Command("Voltar") {
                        @Override
                        public void actionPerformed(ActionEvent ev) {
                             Initial.this.showBack();
                        } 
                    }; 
                    regPositionEnterprise.setBackCommand(backCommand);
                    regPositionEnterprise.show();
                    
                }
                else {
                    Form regPositionUser = new RegPositionUser();                
                    Command backCommand = new Command("Voltar") {
                        @Override
                        public void actionPerformed(ActionEvent ev) {
                             Initial.this.showBack();
                        } 
                    }; 
                    regPositionUser.setBackCommand(backCommand);
                    regPositionUser.show();
                }
                
            }
                
        );
        
        return btn;
    }

    private Button createBtnWhereIsMyCar() {
        Button btn = new Button("Onde está meu Carro?");
        btn.addActionListener(    
           (ActionListener) (ActionEvent evt) -> {

                Form whereIsMyCarForm = new WhereIsMyCar();     
                Command backCommand = new Command("Voltar") {
                    @Override
                    public void actionPerformed(ActionEvent ev) {
                         Initial.this.showBack();
                    } 
                }; 
                whereIsMyCarForm.setBackCommand(backCommand);
                whereIsMyCarForm.show();

           }
        );
        
        
        return btn;
    }

    private Button createBtnParkingSpace() {
        Button btn = new Button("Modulo de Vagas");
        
        btn.addActionListener(
                
            (ActionListener) (ActionEvent evt) -> {
                
                Form parkingForm = new ParckingSpace();
                
                Command backCommand = new Command("Voltar") {
                    @Override
                    public void actionPerformed(ActionEvent ev) {
                         Initial.this.showBack();
                    } 
                }; 
                parkingForm.setBackCommand(backCommand);
                parkingForm.show();
                
            }
                
        );
        
        return btn;
    }

    
}
