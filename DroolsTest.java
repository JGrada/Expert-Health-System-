package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.GUI.BiopsiaUI;
import com.sample.GUI.InicioUI;
import com.sample.GUI.MainGui;
import com.sample.GUI.PacienteUI;
import com.sample.GUI.RessonanciaUI;
import com.sample.GUI.currentWindow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest extends Application{

    public static final void main(String[] args) {
    	launch(args);
    	
    	

        try {
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");


        
        	
        	 //Regra Nr 1:
        	 //Paciente p1 = new Paciente ("Pedrao", 50, 0, 1,12,2020);
         	//kSession.insert(p1);

        	
        	
        	
        	/*
        	 * Regra Nr 1,5:
        	 * Paciente p1 = new Paciente ("Pedrao", 50, 2, 1,12,2020);
        	 * //kSession.insert(p1);

        	
        	*/
        	
        	/*
        	 * Regra Nr 2:
        	 * Paciente p1 = new Paciente ("Pedrao", 50, 2, 1,12,2020);
        	 * Ressonancia r1 = new Ressonancia(2, false, p1, false);ng a fo
        	 * //kSession.insert(p1);
        	 * //kSession.insert(r1);


        	 * 
        	*/
        	
        	/*Regra Nr3:
        	 * * Paciente p1 = new Paciente ("Pedrao", 50, 2, 1,12,2020);
        	 * Ressonancia r1 = new Ressonancia(2, false, p1, true);
        	 * * //kSession.insert(p1);
        	 * //kSession.insert(r1);
        	 */
        	

        	/*Regra Nr4:
        	 * * Paciente p1 = new Paciente ("Pedrao", 50, 2, 1,12,2020);
        	 * Biopsia b1 = new Biopsia(5, true, p1);
        	 * * //kSession.insert(p1);
        	 * //kSession.insert(b1);
        	 */
        	
        	/*Regra Nr6:
        	 *  Administrador a =  new Administrador();
        	 * *Paciente p1 = new Paciente ("Pedrao", 50, 2, 1,12,2020);
        	 * Biopsia b1 = new Biopsia(5, false, p1);
        	 * kSession.insert(a1);
        	 * * //kSession.insert(p1);
        	 * //kSession.insert(b1);
        	 */
        	
        	/*Regra Nr7:
        	 *  Administrador a =  new Administrador();
        	 * *Paciente p1 = new Paciente ("Pedrao", 50, 2, 1,12,2020);
        	 * Biopsia b1 = new Biopsia(5, false, p1);
        	 * Ressonancia r1 = new Ressonancia(4, false, p1, true);
        	 * kSession.insert(p1);
        	 * kSession.insert(b1);
        	 * kSession.insert(r1);
        	 * kSession.insert(a);
        	 */
        	
        	/*Regra Nr8:
        	 *  Administrador a =  new Administrador();
        	 * *Paciente p1 = new Paciente ("Pedrao", 50, 2, 1,12,2020);
        	 * Biopsia b1 = new Biopsia(1, true, p1);
        	 * kSession.insert(a);
        	 * kSession.insert(p1);
        	 * kSession.insert(b1);
        	 */
        	
        	/*Regra Nr9:
        	 *  Administrador a =  new Administrador();
        	 * *Paciente p1 = new Paciente ("Pedrao", 50, 2, 1,12,2020);
        	 * Biopsia b1 = new Biopsia(3, true, p1);
        	 * kSession.insert(a);
        	 * kSession.insert(p1);
        	 * kSession.insert(b1);
        	 */
        	
        	
        	
        	
        	
        	
        	
        	/*
        	Paciente p1 = new Paciente ("Pedrao", 50, 0, 1,12,2020);
        	Paciente p2 = new Paciente ("Pedrinho", 50, 2, 1,12,2020);
        	Biopsia b1 = new Biopsia(5, true, p1);
        	Ressonancia r1 = new Ressonancia(4, false, p2, true);
        	//Ressonancia r2 = new Ressonancia(4, false, p2, true);
        	Administrador a =  new Administrador();
        	Urologia u1 =  new Urologia(p1);
        	*/
        	/*
        	kSession.insert(p1);
        	kSession.insert(p2);
        	kSession.insert(b1);
        	kSession.insert(a);
        	kSession.insert(r1);
        	//kSession.insert(r2);
        	kSession.insert(u1);

        	*/
            kSession.fireAllRules();

        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        
        	

    }
    
    @Override
	public void start(Stage primaryStage) {
		
        primaryStage.setTitle("Sistema pericial");
        
		Scene scene = new Scene(new MainGui()); 
		primaryStage.setScene(scene);
		primaryStage.show();
		


        



    }


}
