/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blueHack.forms;

import com.blueHack.Util;
import com.blueHack.entities.User;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author hrugani
 */
public class Login extends Form {

    private Label lblLogo;
    private TextField userName;
    private TextField password;
    private Button btnLogin;
    private Button btnNewUser;
    
    public Login() {
        super();
        setTitle("Login");
        
        preInit();
        init();
        postInit();
        
        
    }

    private void preInit() {
        
        this.lblLogo = createLblLogo();
        this.userName = createTxtUser();
        this.password = createTxtPassword();
        this.btnLogin = createBtnLogin();
        this.btnNewUser = createBtnNewUser();
        
        
    }

    private void init() {
        
        
        Container cCenter = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cCenter.addComponent(userName);
        cCenter.addComponent(password);
        cCenter.addComponent(btnLogin);
    
        setLayout(new BorderLayout());
        addComponent(BorderLayout.NORTH, lblLogo);
        addComponent(BorderLayout.CENTER, cCenter);
        addComponent(BorderLayout.SOUTH, btnNewUser);
                
        
    }

    private void postInit() {
    }

    private Label createLblLogo() {
        
        Image logo = null;
        try {
            logo = Image.createImage("/LOGO-LOGOALI3.png").scaledWidth(512);
        }
        catch (Exception e) {    
        }
        
        Label lbl = new Label(logo);
        lbl.getStyle().setAlignment(CENTER);
        return lbl;
        
    }

    private TextField createTxtUser() {
        TextField txt = new TextField();
        txt.setHint("Usuário");
        return txt;
    }

    private TextField createTxtPassword() {
        TextField txt = new TextField();
        txt.setConstraint(TextField.PASSWORD);
        txt.setHint("Senha");
        return txt;
    }

    private Button createBtnLogin() {
        Button btn = new Button("Login");
        
        btn.addActionListener(
            (ActionListener) (ActionEvent evt) -> {
                
                // User type defines kind of form that will
                // be instantiated when Register Button is pressed 
                User user;
                if ("usuario".equals(userName.getText())) {
                    user = new User();
                    user.setId("1");
                    user.setName("usuario");
                    user.setType("N");
                }
                else {
                    user = new User();
                    user.setId("E");
                    user.setName("enterprise");
                    user.setType("E");
                }
                Util.getInstance().setUser(user);
                
                
                // Show Initial Form and define
                // back command
                Form initialForm = new Initial();
                Command backCommand = new Command("Voltar") {
                    @Override
                    public void actionPerformed(ActionEvent ev) {
                         Login.this.showBack();
                    } 
                }; 
                initialForm.setBackCommand(backCommand);                               
                initialForm.show();
                
            }
        );
        
        return btn;
    }

    private Button createBtnNewUser() {
        Button btn = new Button("Novo Usuário");
        return btn;
    }

    
}
